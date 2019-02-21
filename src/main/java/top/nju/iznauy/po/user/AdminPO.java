package top.nju.iznauy.po.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created on 04/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminPO {

    @Id
    private String userName;

    @Column(nullable = false)
    private String password;

}
