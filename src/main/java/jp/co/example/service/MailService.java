package jp.co.example.service;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import jp.co.example.entity.Mails;
import jp.co.example.entity.Users;

//@Slf4j
@SpringBootApplication
public interface MailService {
	public List<Mails> getMails(Users user);
}



//	public static void main(String[] args) {
//		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
//		SpringApplication.run(MailService.class, args);
//		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
//	}

