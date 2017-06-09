package jp.co.example.service;

import java.util.*;

import jp.co.example.entity.*;
import jp.co.example.form.*;

public interface UserConfigService {

	List<UsersEx> getUser();

	List<Companies> getCompanies();

	List<Trainings> getTrainig();

	int insert(UserConfigForm userConfigForm, Maps[] maps);

	int delete(Users user);
}
