package jp.co.example.form;

import jp.co.example.entity.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailDeleteForm extends Mails {
	private Integer mailId;
	private boolean openFlag;
}
