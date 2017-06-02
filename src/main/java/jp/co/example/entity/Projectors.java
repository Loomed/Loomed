package jp.co.example.entity;

import java.sql.Timestamp;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Projectors {
	private Integer projectorId;
	private Integer trainingId;
	private Integer projectorNumber;
	private Integer userId;
	private Timestamp reserveTime;

}
