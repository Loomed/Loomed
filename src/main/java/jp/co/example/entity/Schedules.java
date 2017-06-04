package jp.co.example.entity;

import java.sql.Timestamp;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedules {
	private Integer scheduleId;
	private Integer userId;
	private String scheduleContents;
	private Timestamp uploadDatetime;
	private boolean Important;
}
