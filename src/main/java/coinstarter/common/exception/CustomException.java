package coinstarter.common.exception;

import org.springframework.http.HttpStatus;

public abstract class CustomException extends RuntimeException {

    CustomException() {
    }

    CustomException(String message) {
        super(message);
    }

    public String getMessageCode() {
        return this.getClass().getSimpleName();
    }

    public String getDefaultMessage() {
        return this.getLocalizedMessage();
    }

    public abstract HttpStatus getStatus();

    public abstract Object[] getArguments();
}
