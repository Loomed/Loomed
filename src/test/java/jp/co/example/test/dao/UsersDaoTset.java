package jp.co.example.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.LoomedApplication;
import jp.co.example.dao.UsersDao;
import jp.co.example.entity.Users;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ContextConfiguration(classes = LoomedApplication.class)
public class UsersDaoTset {

	@Autowired
	private UsersDao usersDao;

	@Test
	public void テスト72() throws Exception {
		Users user = usersDao.findByIdAndPass(1, "pass");

		assertEquals("山田 太郎", user.getUserName());
		assertEquals(Integer.valueOf(1), user.getCompanyId());
		assertEquals(Integer.valueOf(0), user.getAuthority());
	}

	@Test
	public void テスト73() throws Exception {
		Users user = usersDao.findByIdAndPass(99, "pass99");

		assertEquals(null, user);
	}

	@Test
	public void テスト74() throws Exception {
		Users user = usersDao.findById(2);

		assertEquals("山田 次郎", user.getUserName());
		assertEquals(Integer.valueOf(1), user.getCompanyId());
		assertEquals(Integer.valueOf(0), user.getAuthority());
	}

	@Test
	public void テスト75() throws Exception {
		Users user = usersDao.findById(99);

		assertEquals(null, user);
	}

	@Test
	public void テスト76() throws Exception {
		usersDao.updatePass(5, "aaa");

		Users user = usersDao.findById(5);
		assertEquals("aaa", user.getPassword());
	}

	@Test(expected = DataAccessException.class)
	public void テスト77() throws Exception {
		usersDao.updatePass(5, null);

	}

	// @Test
	// public void テスト78() throws Exception {
	// usersDao.updatePass(5, null);
	//
	// Users user = usersDao.findById(5);
	// assertEquals(null, user.getPassword());
	// }

	@Test
	public void テスト78() throws Exception {
		int cnt = usersDao.updatePass(6, "12345678902234567890323456789042345これで50");

		assertEquals(1, cnt);
	}

	// @Test
	// public void テスト79() throws Exception {
	// int cnt = usersDao.updatePass(7,
	// "123456789022345678903234567890423456これで51");
	//
	// assertEquals(0, cnt);
	// }

	@Test
	public void テスト80() throws Exception {
		int cnt = usersDao.updatePass(99, "aaa");

		Users user = usersDao.findById(99);
		assertEquals(0, cnt);
		// assertEquals("aaa", user.getPassword());
	}

	@Test
	public void テスト81() throws Exception {
		usersDao.updatePass(8, "pppp");

		Users user = usersDao.findById(8);
		assertEquals("pppp", user.getPassword());
	}

	@Test
	public void テスト82() throws Exception {
		usersDao.updateAll(5, "aaa", "羽田 秀吉", 3, 3);

		Users user = usersDao.findById(5);
		assertEquals("aaa", user.getPassword());
		assertEquals("羽田 秀吉", user.getUserName());
		assertEquals(Integer.valueOf(3), user.getCompanyId());
		assertEquals(Integer.valueOf(3), user.getAuthority());
	}

	@Test(expected = DataAccessException.class)
	public void テスト83() throws Exception {
		usersDao.updateAll(6, null, null, null, null);

		Users user = usersDao.findById(6);
		// assertEquals(null, user.getPassword());
		// assertEquals(null, user.getUserName());
		// assertEquals(null, user.getCompanyId());
		// assertEquals(null, user.getAuthority());
	}

	@Test
	public void テスト84() throws Exception {
		int cnt = usersDao.updateAll(6, "12345678902234567890323456789042345これで50", "山田 武", 2, 1);

		assertEquals(1, cnt);
	}

	// @Test
	// public void テスト85() throws Exception {
	// int cnt = usersDao.updateAll(7,
	// "123456789022345678903234567890423456これで51", "山田 武", 2, 1);
	//
	// assertEquals(0, cnt);
	// }

	@Test
	public void テスト86() throws Exception {
		int cnt = usersDao.updateAll(99, "aaa", "世良 真純", 3, 3);

		assertEquals(0, cnt);
	}

	@Test
	public void テスト87() throws Exception {
		List list = usersDao.FindCompMember(2, 2);
		System.out.println("てすてす87：" + list.size());

		assertEquals(2, list.size());
	}


	@Test
	public void テスト88() throws Exception {
		List list = usersDao.FindRoomMember(2);

		assertEquals(4, list.size());
	}

	@Test
	public void テスト89() throws Exception {
		List<Users> list = usersDao.fingAllUsers();

		assertEquals(25, list.size());
	}

}
