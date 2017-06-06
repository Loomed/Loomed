package jp.co.example.myTest;

import jp.co.example.entity.*;
import lombok.*;

@Getter
@Setter
public class MyUsers extends Users {
	private String companyName;
	private String authName;
}
