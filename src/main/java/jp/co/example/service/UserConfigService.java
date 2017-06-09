package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.*;
import jp.co.example.form.UserConfigForm;

public interface UserConfigService {

	List<UsersEx> getUser();

	List<Companies> getCompanies();

	List<Trainings> getTrainig();

	List<List<Maps>> getUserListMaps(List<Users> userlist);

	int insert(UserConfigForm userConfigForm, Maps[] maps);

	int delete(Users user);
}
