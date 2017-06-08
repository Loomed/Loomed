package jp.co.example.test.dao;

import static org.junit.Assert.*;

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
public class ProjectorsDaoTest {

	@Autowired
	private ProjectorsDao projectorsDao;

	@Test
	public void テスト34() throws Exception {

		// テストデータ作成
		Projectors pro = projectorsDao.selectProjectorsWhereTrainingIdAndDate(trainingId, dateMin, dateMax);

		assertTrue(false);
	}

	@Test
	public void テスト35() throws Exception {

		// テストデータ作成
		Projectors pro = projectorsDao.selectProjectorsWhereTrainingIdAndDate(trainingId, dateMin, dateMax);

		assertTrue(false);
	}

	@Test
	public void テスト36() throws Exception {

		// テストデータ作成
		Projectors pro = projectorsDao.selectProjectorsWhereTrainingIdAndDateTime(trainingId, dateMin, dateMax);

		assertTrue(false);
	}

	@Test
	public void テスト37() throws Exception {

		// テストデータ作成
		Projectors pro = projectorsDao.selectProjectorsWhereTrainingIdAndDateTime(trainingId, dateMin, dateMax);

		assertTrue(false);
	}

	@Test
	public void テスト38() throws Exception {

		// テストデータ作成
		int cnt = projectorsDao.deleteWhereProjectorId(projectorId)

		assertTrue(false);
	}

	@Test
	public void テスト39() throws Exception {

		// テストデータ作成
		int cnt = projectorsDao.deleteWhereProjectorId(projectorId)

		assertTrue(false);
	}

	@Test
	public void テスト40() throws Exception {

		// テストデータ作成
		int cnt = projectorsDao.insertProjectoReserve(trainingId, projectorNumber, userId, reserveTime))

		assertTrue(false);
	}

	@Test
	public void テスト41() throws Exception {

		// テストデータ作成
		int cnt = projectorsDao.insertProjectoReserve(null, null, null, null);

		assertTrue(false);
	}

	@Test
	public void テスト42() throws Exception {

		// テストデータ作成
		int cnt = projectorsDao.insertProjectoReserve(null, null, null, null);

		assertTrue(false);
	}

	@Test
	public void テスト43() throws Exception {

		// テストデータ作成
		int cnt = projectorsDao.insertProjectoReserve(null, null, null, null);

		assertTrue(false);
	}

	@Test
	public void テスト44() throws Exception {

		// テストデータ作成
		int cnt = projectorsDao.insertProjectoReserve(null, null, null, null);

		assertTrue(false);
	}

	@Test
	public void テスト45() throws Exception {

		// テストデータ作成
		int cnt = projectorsDao.insertProjectoReserve(null, null, null, null);

		assertTrue(false);
	}


}
