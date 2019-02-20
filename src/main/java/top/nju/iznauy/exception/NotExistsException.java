package top.nju.iznauy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created on 20/02/2019.
 * Description:
 *
 * @author iznauy
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotExistsException extends RuntimeException {

    public NotExistsException(String message) {
        super(message);
    }
}
