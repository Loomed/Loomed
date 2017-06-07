package jp.co.example.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailsEx extends Mails {
	private String receptionUserName;

	public MailsEx(Mails mail)
	{
		super.setMailId(mail.getMailId());
		super.setReceptionUserId(mail.getReceptionUserId());
		super.setTransmissionUserId(mail.getTransmissionUserId());
		super.setMailTitle(mail.getMailTitle());
		super.setMailDate(mail.getMailDate());
		super.setOpenFlag(mail.isOpenFlag());
		super.setMailContents(mail.getMailContents());
	}

}
