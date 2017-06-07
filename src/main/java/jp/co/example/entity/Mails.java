package jp.co.example.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mails {
	private Integer mailId;
	private Integer receptionUserId;
	private Integer transmissionUserId;
	private String mailTitle;
	private String mailContents;
	private Timestamp mailDate;
	private boolean openFlag;

}
