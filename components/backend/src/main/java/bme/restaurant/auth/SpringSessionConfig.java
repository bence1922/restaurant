package bme.restaurant.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSession;
import org.springframework.session.SessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.Session;

@Configuration
@EnableSpringHttpSession
public class SpringSessionConfig {

    @Bean
    public SessionRepository<MapSession> sessionRepository() {
        Map<String, Session> sessionMap = new HashMap<>();
        return new MapSessionRepository(sessionMap);
    }
}