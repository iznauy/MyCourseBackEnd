package top.nju.iznauy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created on 20/02/2019.
 * Description:
 *
 * @author iznauy
 */
@ResponseStatus(HttpStatus.CONTINUE)
public class DuplicationException extends RuntimeException {

    public DuplicationException(String message) {
        super(message);
    }
}
