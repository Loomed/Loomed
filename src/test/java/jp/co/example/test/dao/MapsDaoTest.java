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
public class MapsDaoTest {

	@Autowired
	private MapsDao mapDao;

	@Test
	public void テスト27() throws Exception{
		assertEquals(1, mapDao.update(9, 99));
	}

	@Test
	public void テスト28() throws Exception{
		//assertEquals(1, mapDao.update(10, 99));
	}

	@Test
	public void テスト29() throws Exception{
		assertEquals(0, mapDao.update(77, 77));
	}

	@Test
	public void テスト30() throws Exception{
//		List<Maps> maps = mapDao.selectWhereUserId(1);
//
//		assertEquals("全体管理", maps.get(0).get);
	}

	@Test
	public void テスト31() throws Exception{
		List<Maps> maps = mapDao.selectWhereUserId(99);

		assertEquals(null, maps);
	}
}
