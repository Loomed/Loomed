package jp.co.example.service;

import java.util.*;

import jp.co.example.entity.*;

public interface UserChangeService {
	List<Companies> getCompanies();

	List<Trainings> getTrainig();

	List<Maps> getMaps(Users user);
}
