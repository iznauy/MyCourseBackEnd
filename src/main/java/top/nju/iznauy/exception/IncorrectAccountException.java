package top.nju.iznauy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectAccountException extends RuntimeException {

    public IncorrectAccountException(String message) {
        super(message);
    }
}
