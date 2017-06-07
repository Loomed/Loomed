package jp.co.example.form;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.example.entity.Mails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailForm extends Mails{
	@NotBlank
	private Integer receptionUserId;
	@NotBlank
	private String mailTitle;
	@NotBlank
	private String mailContents;

	}

