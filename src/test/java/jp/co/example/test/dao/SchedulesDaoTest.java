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
public class SchedulesDaoTest {
	@Autowired
	private SchedulesDao scheduleDao;

	@Test
	public void テスト45() throws Exception {

		// テストデータ作成
		Schedules schedule = scheduleDao.selectScheduleWhereUserIdAndDate();

		assertTrue(false);
	}

	@Test
	public void テスト46() throws Exception {

		// テストデータ作成
		Schedules schedule = scheduleDao.selectScheduleWhereUserIdAndDate(userId, dateMin, dateMax);

		assertTrue(false);
	}

	@Test
	public void テスト47() throws Exception {

		// テストデータ作成
		List<Schedules> schedule = scheduleDao.getInpoSche();

		assertTrue(false);
	}

	@Test
	public void テスト48() throws Exception {

		// テストデータ作成
		List<Schedules> schedule = scheduleDao.getInpoSche();

		assertTrue(false);
	}

	@Test
	public void テスト49() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.updateScheduleWhereScheduleId();

		assertEquals(expected, actual);
	}

}
