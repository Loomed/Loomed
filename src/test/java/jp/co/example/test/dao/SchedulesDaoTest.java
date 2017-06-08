package jp.co.example.test.dao;

import static org.junit.Assert.*;

import java.sql.*;
import java.util.*;
import java.util.Date;

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

		assertTrue(false);
	}

	@Test
	public void テスト50() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.updateScheduleWhereScheduleId();

		assertTrue(false);
	}

	@Test
	public void テスト51() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.updateScheduleWhereScheduleId();

		assertTrue(false);
	}

	@Test
	public void テスト52() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.updateScheduleWhereScheduleId();

		assertTrue(false);
	}

	@Test
	public void テスト53() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.updateScheduleWhereScheduleId();

		assertTrue(false);
	}

	@Test
	public void テスト54() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.deleteScheduleWhereScheduleId();

		assertTrue(false);
	}

	@Test
	public void テスト55() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.deleteScheduleWhereScheduleId();

		assertTrue(false);
	}

	@Test
	public void テスト56() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.insertSchedule(10, "毛利さんにメールする", new Timestamp(new Date().getTime()), false );

		assertEquals(1, cnt);
	}

	@Test
	public void テスト57() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.insertSchedule(10, null, null, true );

		assertEquals(1, cnt);
	}

	@Test
	public void テスト58() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.insertSchedule(null, null, null, true );

		assertEquals(0, cnt);
	}

	@Test
	public void テスト59() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.insertSchedule(1, "12345678902234567890323456789042345678905234567890623456789072345678908234567890923456789012345678902343これで128", null, true );

		assertEquals(1, cnt);
	}

	@Test
	public void テスト60() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.insertSchedule(1, "1234567890223456789032345678904234567890523456789062345678907234567890823456789092345678901234567890234これで129", null, true );

		assertEquals(0, cnt);
	}

	@Test
	public void テスト61() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.insertSchedule(99, "毛利さんにメールする", null, false );

		assertEquals(0, cnt);
	}

}
