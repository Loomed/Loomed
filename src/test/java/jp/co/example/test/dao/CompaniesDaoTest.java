package jp.co.example.test.dao;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.transaction.annotation.*;

import jp.co.example.*;
import jp.co.example.dao.*;
import jp.co.example.entity.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ContextConfiguration(classes = LoomedApplication.class)
public class CompaniesDaoTest {

	@Autowired
	CompaniesDao companiesDao;

	@Test
	public void テスト１() {

		List<Companies> companies = companiesDao.findCompanyId("株式会社003");

		assertEquals("株式会社003", companies.get(0).getCompanyName());
	}

	@Test
	public void テスト2() {

		List<Companies> companies = companiesDao.findCompanyId("株式会社999");

		assertEquals(null, companies.get(0).getCompanyName());
	}

	@Test
	public void テスト3() {

		Companies companies = companiesDao.findCompany(1);

		assertEquals(Integer.valueOf(1), companies.getCompanyId());
	}

	@Test
	public void テスト4() {

		Companies companies = companiesDao.findCompany(99);

		assertEquals(null, companies);
	}

	@Test
	public void テスト5() {
		Users user = new Users();
		user.setCompanyId(1);

		List list = new ArrayList<>();
		list.add(user);

		List<Companies> com = companiesDao.FindRoomMemberComp(list);

		assertEquals(Integer.valueOf(1), com.get(0).getCompanyId());
	}

	@Test
	public void テスト6() {
		Users user = new Users();
		user.setCompanyId(77);

		List list = new ArrayList<>();
		list.add(user);

		List<Companies> com = companiesDao.FindRoomMemberComp(list);

		assertEquals(null, com);
	}

	@Test
	public void テスト7() {

		List<Companies> com = companiesDao.getCompanis();

		assertEquals(6, com.size());
	}

	@Test
	public void テスト8() {

		companiesDao.insert("株式会社011");

		assertEquals("株式会社011", companiesDao.findCompanyId("株式会社011").get(0).getCompanyName());
	}

	@Test
	public void テスト9() {

		companiesDao.insert(null);

		assertEquals(null, companiesDao.findCompanyId(null).get(0).getCompanyName());
	}

	@Test
	public void テスト10() {

		try {
			companiesDao.insert("株式会社12");
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void テスト11() {

		int cnt =  companiesDao.insert("123456789022345678903234567890423456789052345678906234567890723456789082345678909234567890123456789023これで128");

		assertEquals(1, cnt);
	}

	@Test
	public void テスト12() {

		int cnt =  companiesDao.insert("1234567890223456789032345678904234567890523456789062345678907234567890823456789092345678901234567890234これで129");

		assertEquals(0, cnt);
	}

	@Test
	public void テスト13() {

		int cnt =  companiesDao.insert(null);

		assertEquals(0, cnt);
	}

}
