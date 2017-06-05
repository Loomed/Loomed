package jp.co.example.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import jp.co.example.entity.Mails;

//@Slf4j
@SpringBootApplication
public interface MailService {
	public Mails findByIdAndTitleAndContents(Integer mailID, String mailTitle, String mailContents);

	//ここまで送信に関する入力部分



//	public static void main(String[] args) {
//		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
//		SpringApplication.run(MailService.class, args);
//		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
//	}
}
