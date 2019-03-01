package top.nju.iznauy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created on 01/03/2019.
 * Description:
 *
 * @author iznauy
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class WrongFormatException extends RuntimeException {

    public WrongFormatException() {
        super("格式错误！");
    }

}
