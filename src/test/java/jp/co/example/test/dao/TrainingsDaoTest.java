package jp.co.example.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;

import jp.co.example.dao.*;
import jp.co.example.entity.Users;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainingsDaoTest {


	@Autowired
	private TrainingsDao trainingDao;

	@Test

	public void テスト69() throws Exception {
		Users user = trainingDao.getTraining(1);

		assertEquals("1", user.getUserId());
		assertEquals(Integer.valueOf(1), user.getCompanyId());
		assertEquals(Integer.valueOf(0), user.getAuthority());
	}

	public void テスト70() throws Exception {

		int
		assertTrue(false);

	}

	@Test
	public void テスト71() throws Exception {
		List list = trainingsDao. AllRooms();

		assertTrue(false);

	}

}
