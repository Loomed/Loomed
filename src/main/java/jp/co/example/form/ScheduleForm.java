package jp.co.example.form;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScheduleForm {
	private String time;
	private String content;
}
