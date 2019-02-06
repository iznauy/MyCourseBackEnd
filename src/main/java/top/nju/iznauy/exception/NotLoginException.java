package top.nju.iznauy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class NotLoginException extends RuntimeException {

    public NotLoginException(String message) {
        super(message);
    }
}
