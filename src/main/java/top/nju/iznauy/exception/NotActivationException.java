package top.nju.iznauy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class NotActivationException extends RuntimeException {

    public NotActivationException() {
        super("账号尚未激活");
    }
}
