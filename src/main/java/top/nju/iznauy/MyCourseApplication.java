package top.nju.iznauy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MyCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCourseApplication.class, args);
    }

}

