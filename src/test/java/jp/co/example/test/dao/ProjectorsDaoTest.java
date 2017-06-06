package jp.co.example.test.dao;

import java.sql.Timestamp;
import java.util.List;

import jp.co.example.entity.Projectors;

public interface ProjectorsDaoTest {
	List<Projectors> selectProjectorsWhereTrainingIdAndDate(Integer trainingId, Timestamp dateMin, Timestamp dateMax);
	List<Projectors> selectProjectorsWhereTrainingIdAndDateTime(Integer trainingId, Timestamp dateTime);
}
