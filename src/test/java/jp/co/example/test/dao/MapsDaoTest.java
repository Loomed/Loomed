package jp.co.example.test.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.LoomedApplication;
import jp.co.example.dao.MapsDao;
import jp.co.example.entity.Maps;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ContextConfiguration(classes = LoomedApplication.class)
public class MapsDaoTest {

	@Autowired
	private MapsDao mapDao;

	@Test
	public void テスト27() throws Exception{
		//assertEquals(1, mapDao.update(9, 99));
		fail();
	}

	@Test
	public void テスト28() throws Exception{
		//assertEquals(1, mapDao.update(10, 99));
		fail();
	}

	@Test
	public void テスト29() throws Exception{
		//assertEquals(0, mapDao.update(77, 77));
		fail();
	}

	@Test
	public void テスト30() throws Exception{
		List<Maps> maps = mapDao.selectWhereUserId(6);

		assertEquals(2, maps.size());
	}

	@Test
	public void テスト31() throws Exception{
		List<Maps> maps = mapDao.selectWhereUserId(99);

		assertEquals(0, maps.size());
	}
}
