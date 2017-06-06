package jp.co.example.test.dao;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;

import jp.co.example.dao.*;
import jp.co.example.entity.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapsDaoTest {


//	Maps getUserTrainigs(Users user);
//
//	int update(int userId, int trainingId);

	@Autowired
	private MapsDao mapDao;

	@Test
	public void ユーザの研修教室が取得できる() throws Exception{

		Users user = new Users();
		user.setUserId(3);

		Maps expected = mapDao.getUserTrainigs(user);

		Maps actual = new Maps();
		actual.setUserId(3);
		actual.setTrainingId(1);

		assertEquals(expected, actual);
	}

	@Test
	public void ユーザの研修教室が取得できない() throws Exception{

		Users user = new Users();
		user.setUserId(-1);

		Maps expected = mapDao.getUserTrainigs(user);

		Maps actual = null;

		assertEquals(expected, actual);
	}

	@Test
	public void 研修教室の更新が出来る() throws Exception{

		int expected = mapDao.update(3, 3);

		assertEquals(expected, 1);
	}

	@Test
	public void 研修教室の更新が出来ない() throws Exception{

		int expected = mapDao.update(-1, 3);

		assertEquals(expected, 0);
	}

}
