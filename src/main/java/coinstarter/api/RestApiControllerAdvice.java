package coinstarter.api;

import coinstarter.common.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class RestApiControllerAdvice {

    private final MessageSourceAccessor accessor;

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handlerCustomException(CustomException e) {
        return ResponseEntity.status(e.getStatus())
                             .body(makeBody(e));
    }

    private ErrorResponse makeBody(CustomException e) {
        return ErrorResponse.builder()
                            .status(e.getStatus())
                            .message(accessor.getMessage(e.getMessageCode(), e.getArguments(), e.getDefaultMessage()))
                            .build();
    }

}
