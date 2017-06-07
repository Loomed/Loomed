package jp.co.example.form;

import jp.co.example.entity.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailInsertForm extends Mails {
	private Integer[] receptionUserIds;
	private Integer transmissionUserId;
	private String mailTitle;
	private String mailContents;
}
