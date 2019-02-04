package top.nju.iznauy.po.config;

import org.hibernate.dialect.MySQL57Dialect;

/**
 * Created on 04/02/2019.
 * Description:
 *
 * @author iznauy
 */
public class MySQL5DialectUTF8 extends MySQL57Dialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
