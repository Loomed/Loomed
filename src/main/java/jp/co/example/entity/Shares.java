package jp.co.example.entity;

import java.sql.Date;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shares {
	private Integer shareId;
	private Integer trainingId;
	private byte[] shareContents;
	private Date uploadDate;
	private boolean visible;
	private String title;
}
