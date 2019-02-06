package top.nju.iznauy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerUnknownException extends RuntimeException {

    public ServerUnknownException(String message) {
        super(message);
    }

}
