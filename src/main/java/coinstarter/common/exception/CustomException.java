package coinstarter.common.exception;

import org.springframework.http.HttpStatus;

public abstract class CustomException extends RuntimeException {

    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatus();

    public abstract Object[] getArguments();

    public abstract String getDefaultMessage();
}
