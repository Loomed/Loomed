package jp.co.example.service;

import java.util.*;

import org.springframework.boot.autoconfigure.*;

import jp.co.example.entity.*;
import jp.co.example.form.*;

@SpringBootApplication
public interface MailService {
	List<MailsEx> getMails(Users user);

	List<MailsEx> getMails();

	int delete(Mails mail);

	int insert(MailInsertForm mailInsertForm);

	List<List<Users>> getUsersButAuth();

	int openMail(Integer mailId);
}