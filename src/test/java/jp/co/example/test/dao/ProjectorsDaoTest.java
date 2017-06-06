package jp.co.example.test.dao;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;

import jp.co.example.dao.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectorsDaoTest {
//	List<Projectors> selectProjectorsWhereTrainingIdAndDate(Integer trainingId, Timestamp dateMin, Timestamp dateMax);
//	List<Projectors> selectProjectorsWhereTrainingIdAndDateTime(Integer trainingId, Timestamp dateTime);


	@Autowired
	private ProjectorsDao projectorsDao;

	@Test
	public void メールが取得できる() throws Exception{
		assertTrue(true);
	}

	@Test
	public void メールが取得できない() throws Exception{
		assertTrue(true);
	}
}
