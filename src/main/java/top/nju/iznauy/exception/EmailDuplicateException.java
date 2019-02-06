package top.nju.iznauy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class EmailDuplicateException extends RuntimeException {

    public EmailDuplicateException(String message) {
        super(message);
    }
}
