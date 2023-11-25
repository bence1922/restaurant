package bme.restaurant.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import bme.restaurant.dao.Booking;
import bme.restaurant.dto.BookingDTO;
import bme.restaurant.dto.NewBookingDTO;
import bme.restaurant.dto.TableDTO;
import bme.restaurant.repository.BookingRepository;
import bme.restaurant.repository.TableRepository;
import bme.restaurant.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private TableRepository tableRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public BookingDTO getBooking(String id) {
        return bookingRepo.findById(id).get().toDTO();
    }

    @Override
    public BookingDTO bookTable(NewBookingDTO newBookingDTO) {
        // TODO: check if the booking is possible, maybe with the query tables for booking
        var table = tableRepo.findByNumber(newBookingDTO.getTableNumber());
        var customer = userRepo.findById(newBookingDTO.getUserId());
        var booking = new Booking(
            table, 
            customer.get(), 
            newBookingDTO.getStartingDate().toLocalDateTime(), 
            newBookingDTO.getEndingDate().toLocalDateTime(), 
            BookingDTO.StatusEnum.PENDING.getValue(), 
            newBookingDTO.getPeopleCount());

        booking = bookingRepo.save(booking);
        return booking.toDTO();
    }

    @Override
    public BookingDTO bookingStatusUpdate(String id, String status) {
        var booking = bookingRepo.findById(id).get();
        booking.setStatus(status);
        booking = bookingRepo.save(booking);
        return booking.toDTO();
    }

    @Override
    public List<BookingDTO> queryBookings(
            Integer tableNumber,
            String customerName,
            OffsetDateTime from,
            OffsetDateTime to) {
        Query query = new Query();

        if (tableNumber != null) {
            var table = tableRepo.findByNumber(tableNumber);
            query.addCriteria(Criteria.where("table").is(table));
        }

        if (customerName != null) {
            var customers = userRepo.findByNameContaining(customerName);
            query.addCriteria(Criteria.where("customer").in(customers));
        }

        if (from != null) {
            query.addCriteria(Criteria.where("start").gte(from.toLocalDateTime()));
        }

        if (to != null) {
            query.addCriteria(Criteria.where("start").lte(to.toLocalDateTime()));
        }

        var bookings = mongoTemplate.find(query, Booking.class);

        return bookings
                .stream()
                .map(booking -> booking.toDTO())
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingDTO> queryCustomerBookings(String userId, OffsetDateTime from, OffsetDateTime to) {
        Query query = new Query();

        var customer = userRepo.findById(userId);
        query.addCriteria(Criteria.where("customer").is(customer));

        if (from != null) {
            query.addCriteria(Criteria.where("start").gte(from.toLocalDateTime()));
        }

        if (to != null) {
            query.addCriteria(Criteria.where("start").lte(to.toLocalDateTime()));
        }

        var bookings = mongoTemplate.find(query, Booking.class);

        return bookings
                .stream()
                .map(booking -> booking.toDTO())
                .collect(Collectors.toList());
    }

    @Override
    public List<TableDTO> queryTablesForBooking(OffsetDateTime from, OffsetDateTime to) {
        Query query = new Query();

        query.addCriteria(new Criteria().orOperator(
                Criteria.where("start")
                        .gte(from.toLocalDateTime())
                        .lte(to.toLocalDateTime()),
                Criteria.where("end")
                        .gte(from.toLocalDateTime())
                        .lte(to.toLocalDateTime())));

        var bookedTableIds = mongoTemplate.find(query, Booking.class)
                .stream()
                .map(booking -> booking.getTable().getId())
                .collect(Collectors.toSet());

        return tableRepo.findAll().stream()
                .filter(table -> !bookedTableIds.contains(table.getId()))
                .map(table -> table.toDTO())
                .collect(Collectors.toList());
    }
}
