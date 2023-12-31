package bme.restaurant.auth;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.session.MapSession;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class AuthorizeAspect {
    @Autowired
    private SessionRepository<MapSession> sessionRepository;

    @Before("@annotation(Authorize)")
    public void authorize(JoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        if (method.isAnnotationPresent(Authorize.class)) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                    .getRequest();
            String permission = method.getAnnotation(Authorize.class).permission();
            boolean selfAccess = method.getAnnotation(Authorize.class).selfAccess();
            String[] roles = method.getAnnotation(Authorize.class).roles();

            var sessionId = request.getHeader("sessionId");

            if (sessionId == null) {
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "SessionId not given");
            }

            var session = sessionRepository.findById(sessionId);

            if (session == null) {
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Session not found");
            }

            String role = session.getAttribute("role").toString();

            if (!Role.valueOf(role).hasPermission(permission)) {
                throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "Access Denied");
            }

            if (selfAccess) {
                String[] parameterNames = signature.getParameterNames();
                Object[] parameterValues = joinPoint.getArgs();
                String userId_Path = "";
                for (int i = 0; i < parameterNames.length; i++) {
                    if ("userId".equals(parameterNames[i])) {
                        userId_Path = (String) parameterValues[i];
                        break;
                    }
                }
                var userId_Session = session.getAttribute("userId").toString();
                if (!userId_Path.equals(userId_Session) && !Arrays.asList(roles).contains(role)) {
                    throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "Can only access own data");
                }
            }
        }
    }
}