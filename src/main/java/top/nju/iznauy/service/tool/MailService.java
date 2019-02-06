package top.nju.iznauy.service.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Service
public class MailService {

    private static final String FROM = "2863486157@qq.com";

    private JavaMailSender sender;

    public void sentMail(String from, String to, String title, String content) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);

        sender.send(message);
    }

    public void sentMail(String to, String code) {

        String title = "MyCourse激活邮件";
        String content = "您的账号激活码为：" + code + "，清注意及时激活。";

        sentMail(FROM, to, title, content);
    }

    @Autowired
    public void setSender(JavaMailSender sender) {
        this.sender = sender;
    }
}
