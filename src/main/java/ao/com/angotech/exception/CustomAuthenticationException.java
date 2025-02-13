package ao.com.angotech.exception;

public class CustomAuthenticationException extends RuntimeException {

    public CustomAuthenticationException(String msg) {
        super(msg);
    }
}
