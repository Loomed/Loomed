package jp.co.example.service.impl;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import jp.co.example.entity.Mails;

//@Slf4j
@SpringBootApplication
public interface MailService {
	public Mails findByIdAndTitleAndContents(Integer mailID, String mailTitle, String mailContents);

//	public static void main(String[] args) {
//		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
//		SpringApplication.run(MailService.class, args);
//		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
//	}
}
