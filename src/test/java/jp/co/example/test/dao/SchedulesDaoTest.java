package jp.co.example.test.dao;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.LoomedApplication;
import jp.co.example.dao.SchedulesDao;
import jp.co.example.entity.Schedules;

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
		final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		List<Schedules> schedule = scheduleDao.selectScheduleWhereUserIdAndDate(1,
				new Timestamp(SDF_DATETIME.parse("2017/6/6 0:0:0").getTime()),
				new Timestamp(SDF_DATETIME.parse("2017/6/7 0:0:0").getTime()));

		assertEquals(3, schedule.size());
	}

	@Test
	public void テスト46() throws Exception {

		// テストデータ作成
		final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		List<Schedules> schedule = scheduleDao.selectScheduleWhereUserIdAndDate(1,
				new Timestamp(SDF_DATETIME.parse("2016/1/1 0:0:0").getTime()),
				new Timestamp(SDF_DATETIME.parse("2016/1/2 0:0:0").getTime()));

		assertEquals(0, schedule.size());
	}

	@Test
	public void テスト47() throws Exception {

		// テストデータ作成
		List<Schedules> schedule = scheduleDao.getInpoSche();
		System.out.println("tes:"+schedule.size());
		assertEquals(4, schedule.size());
	}

//	@Test
//	public void テスト48() throws Exception {
//
//		// テストデータ作成
//		List<Schedules> schedule = scheduleDao.getInpoSche();
//
//		assertTrue(false);
//	}

	@Test
	public void テスト49() throws Exception {

		// テストデータ作成
		final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy/MM/dd HH:mm");

		int cnt = scheduleDao.updateScheduleWhereScheduleId(1, "aaaaa", new Timestamp(SDF_DATETIME.parse("2016/1/1 0:0:0").getTime()),
				false);

		assertEquals(1, cnt);
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
		int cnt = scheduleDao.insertSchedule(10, "毛利さんにメールする", new Timestamp(new Date().getTime()), false);

		assertEquals(1, cnt);
	}

	@Test
	public void テスト57() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.insertSchedule(10, null, null, true);

		assertEquals(1, cnt);
	}

	@Test
	public void テスト58() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.insertSchedule(null, null, null, true);

		assertEquals(0, cnt);
	}

	@Test
	public void テスト59() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.insertSchedule(1,
				"12345678902234567890323456789042345678905234567890623456789072345678908234567890923456789012345678902343これで128",
				null, true);

		assertEquals(1, cnt);
	}

	@Test
	public void テスト60() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.insertSchedule(1,
				"1234567890223456789032345678904234567890523456789062345678907234567890823456789092345678901234567890234これで129",
				null, true);

		assertEquals(0, cnt);
	}

	@Test
	public void テスト61() throws Exception {

		// テストデータ作成
		int cnt = scheduleDao.insertSchedule(99, "毛利さんにメールする", null, false);

		assertEquals(0, cnt);
	}

}
