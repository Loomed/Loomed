package jp.co.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trainings {
	private Integer trainingId;
	private String trainingName;
	private Integer projectorCount;
	private String trainingInfo;
}
