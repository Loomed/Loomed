package jp.co.example.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shares {
	private Integer shareId;
	private Integer trainingId;
	private String shareContents;
	private Date uploadDate;
	private boolean visible;
	private String title;
}
