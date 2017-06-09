package jp.co.example.test.dao;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import jp.co.example.dao.ProjectorsDao;
import jp.co.example.entity.Projectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ContextConfiguration(classes = LoomedApplication.class)
public class ProjectorsDaoTest {

	@Autowired
	private ProjectorsDao projectorsDao;

	@Test
	public void テスト34() throws Exception {

		// テストデータ作成
		int trainingId = 2;
		final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Timestamp dateMin = new Timestamp(SDF_DATETIME.parse("2017/6/5 0:0:0").getTime());
		Timestamp dateMax = new Timestamp(SDF_DATETIME.parse("2017/6/5 11:35:0").getTime());
		List<Projectors> pro = projectorsDao.selectProjectorsWhereTrainingIdAndDate(trainingId, dateMin, dateMax);

		assertEquals(3, pro.size());
	}

	@Test
	public void テスト35() throws Exception {

		// テストデータ作成
		int trainingId = 1;
		final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Timestamp dateMin = new Timestamp(SDF_DATETIME.parse("2017/6/5 0:0:0").getTime());
		Timestamp dateMax = new Timestamp(SDF_DATETIME.parse("2017/6/5 11:35:0").getTime());
		List<Projectors> pro = projectorsDao.selectProjectorsWhereTrainingIdAndDate(trainingId, dateMin, dateMax);

		assertEquals(0, pro.size());
	}

	@Test
	public void テスト36() throws Exception {

		// テストデータ作成
		int trainingId = 2;
		final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Timestamp dateMin = new Timestamp(SDF_DATETIME.parse("2017/6/5 11:0:0").getTime());
		List<Projectors> pro = projectorsDao.selectProjectorsWhereTrainingIdAndDateTime(trainingId, dateMin);

		assertEquals(0, pro.size());
	}

	@Test
	public void テスト37() throws Exception {

		// テストデータ作成
		int trainingId = 2;
		final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Timestamp dateMin = new Timestamp(SDF_DATETIME.parse("2017/6/5 9:0:0").getTime());
		List<Projectors> pro = projectorsDao.selectProjectorsWhereTrainingIdAndDateTime(trainingId, dateMin);

		assertEquals(2, pro.size());
	}

	@Test
	public void テスト38() throws Exception {

		// テストデータ作成
		int projectorId = 2;
		int cnt = projectorsDao.deleteWhereProjectorId(projectorId);
		System.out.println("tes:" + cnt);

		assertEquals(1,cnt);
	}

//	@Test
//	public void テスト39() throws Exception {
//
//		// テストデータ作成
//		int cnt = projectorsDao.deleteWhereProjectorId(projectorId)
//
//		assertTrue(false);
//	}

	@Test
	public void テスト40() throws Exception {

		// テストデータ作成
		int trainingId = 3;
		int projectorNumber = 1;
		int userId = 10;
		final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Timestamp reserveTime = new Timestamp(SDF_DATETIME.parse("2017/6/5 11:0:0").getTime());

		int cnt = projectorsDao.insertProjectoReserve(trainingId, projectorNumber, userId, reserveTime);

		assertEquals(1,cnt);
	}

	@Test(expected=DataAccessException.class)
	public void テスト41() throws Exception {

		// テストデータ作成
		projectorsDao.insertProjectoReserve(null, null, null, null);

	}

//	@Test
//	public void テスト42() throws Exception {
//
//		// テストデータ作成
//		int cnt = projectorsDao.insertProjectoReserve(null, null, null, null);
//
//		assertTrue(false);
//	}
//
//	@Test
//	public void テスト43() throws Exception {
//
//		// テストデータ作成
//		int cnt = projectorsDao.insertProjectoReserve(null, null, null, null);
//
//		assertTrue(false);
//	}

	@Test(expected=DataAccessException.class)
	public void テスト43() throws Exception {

		// テストデータ作成
		final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Timestamp reserveTime = new Timestamp(SDF_DATETIME.parse("2017/6/5 11:0:0").getTime());

		projectorsDao.insertProjectoReserve(null, 2, 2, reserveTime);

	}

//	@Test
//	public void テスト44() throws Exception {
//
//		// テストデータ作成
//		int cnt = projectorsDao.insertProjectoReserve(null, null, null, null);
//
//		assertTrue(false);
//	}

}
