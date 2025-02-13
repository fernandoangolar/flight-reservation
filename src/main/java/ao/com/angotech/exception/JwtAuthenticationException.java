package ao.com.angotech.exception;

public class JwtAuthenticationException extends RuntimeException {

    public  JwtAuthenticationException(String msg) {
        super(msg);
    }
}
