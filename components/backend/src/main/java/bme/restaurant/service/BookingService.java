package bme.restaurant.service;

import java.time.OffsetDateTime;
import java.util.List;

import bme.restaurant.dto.BookingDTO;
import bme.restaurant.dto.NewBookingDTO;
import bme.restaurant.dto.TableDTO;

public interface BookingService {
    BookingDTO getBooking(String id);
    BookingDTO bookTable(NewBookingDTO newBookingDTO);
    BookingDTO bookingStatusUpdate(String id, String status);
    List<BookingDTO> queryBookings(Integer tableNumber, String customerName, OffsetDateTime from, OffsetDateTime to);
    List<BookingDTO> queryCustomerBookings(String customerId, OffsetDateTime from, OffsetDateTime to);
    List<TableDTO> queryTablesForBooking(OffsetDateTime from, OffsetDateTime to);
}
