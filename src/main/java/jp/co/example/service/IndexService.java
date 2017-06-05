package jp.co.example.service;

import jp.co.example.entity.Users;

public interface IndexService {

	public Users LoginJudge(int id, String pass);

	public int RoomJudge(int id);

}
