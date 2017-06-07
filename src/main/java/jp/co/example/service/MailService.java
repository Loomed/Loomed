package jp.co.example.service;

import java.util.*;

import org.springframework.boot.autoconfigure.*;

import jp.co.example.entity.*;

//@Slf4j
@SpringBootApplication
public interface MailService {
	public List<Mails> getMails(Users user);

	public int delete(Mails mail);
}



//	public static void main(String[] args) {
//		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
//		SpringApplication.run(MailService.class, args);
//		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
//	}

