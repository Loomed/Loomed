
package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Users;

public interface MemberService {

	public List<Users> Member(int roomId, int comId);
}
