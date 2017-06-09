package jp.co.example.form;

import jp.co.example.entity.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDeleteForm extends Users {
	private Integer userId;
}
