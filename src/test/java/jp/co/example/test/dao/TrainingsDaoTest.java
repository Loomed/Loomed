package jp.co.example.test.dao;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.dao.*;
import org.springframework.test.context.junit4.*;
import org.springframework.transaction.annotation.*;

import jp.co.example.dao.*;
import jp.co.example.entity.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TrainingsDaoTest {

	@Autowired
	private TrainingsDao trainingDao;

	@Test
	public void trainingDaoTest_1() throws Exception {

		assertEquals(12, trainingDao.AllRooms().size());
	}

	@Test
	public void trainingDaoTest_2() throws Exception {

		Trainings actual = trainingDao.getTraining(3);

		Trainings expected = new Trainings();
		expected.setTrainingId(3);
		expected.setTrainingName("PHP研修");
		expected.setProjectorCount(3);
		expected.setTrainingInfo("未経験者向けのPHP研修");

		assertEquals(expected.getTrainingId(), actual.getTrainingId());
		assertEquals(expected.getTrainingName(), actual.getTrainingName());
		assertEquals(expected.getProjectorCount(), actual.getProjectorCount());
		assertEquals(expected.getTrainingInfo(), actual.getTrainingInfo());

	}

	@Test(expected=DataAccessException.class)
	public void trainingDaoTest_3() throws Exception {
		trainingDao.getTraining(99);
	}

	@Test
	public void trainingDaoTest_4() throws Exception {

		assertEquals(1, trainingDao.InsTraining(4, "SCALA研修", 6, "未経験者向けSCALA研修"));
	}

	@Test(expected=DataAccessException.class)
	public void trainingDaoTest_5() throws Exception {
		trainingDao.InsTraining(0, null, 0, null);
	}

	@Test(expected=DataAccessException.class)
	public void trainingDaoTest_6() throws Exception {
		trainingDao.DelTraining(8);
	}

	@Test
	public void trainingDaoTest_7() throws Exception {

		assertEquals(0, trainingDao.DelTraining(99));
	}

}
