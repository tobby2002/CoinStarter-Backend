package coinstarter.common.exception;

import org.springframework.http.HttpStatus;

public abstract class NotFoundException extends CustomException {

    public NotFoundException() {
        super();
    }

    NotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
