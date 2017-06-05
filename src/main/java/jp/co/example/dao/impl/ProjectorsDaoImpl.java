package jp.co.example.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.example.dao.ProjectorsDao;
import jp.co.example.entity.Projectors;

@Repository
public class ProjectorsDaoImpl implements ProjectorsDao{

	@Override
	public List<Projectors> selectProjectorsWhereTrainingIdAndDate(Integer trainingId, Timestamp dateMin,
			Timestamp dateMax) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<Projectors> selectProjectorsWhereTrainingIdAndDateTime(Integer trainingId, Timestamp dateTime) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
