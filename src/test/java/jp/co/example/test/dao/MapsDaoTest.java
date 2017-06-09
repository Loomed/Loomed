package jp.co.example.test.dao;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.dao.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.transaction.annotation.*;

import jp.co.example.*;
import jp.co.example.dao.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ContextConfiguration(classes = LoomedApplication.class)
public class MapsDaoTest {

	@Autowired
	private MapsDao mapDao;

	@Test
	public void MapsDaoTest_1() throws Exception{
		assertEquals(2, mapDao.selectWhereUserId(5).size());
	}

	@Test
	public void MapsDaoTest_2() throws Exception{
		assertEquals(0, mapDao.selectWhereUserId(99).size());
	}

	@Test
	public void MapsDaoTest_3() throws Exception{
		assertEquals(4, mapDao.selectUserIDAndUserNameJoinUsers(8, 4).size());
	}

	@Test
	public void MapsDaoTest_4() throws Exception{
		assertEquals(0, mapDao.selectUserIDAndUserNameJoinUsers(99, 99).size());
	}

	@Test
	public void MapsDaoTest_5() throws Exception{
		assertEquals(1, mapDao.update(4, 3));
	}

	@Test(expected=DataAccessException.class)
	public void MapsDaoTest_6() throws Exception{
		mapDao.update(99, 99);
	}

	@Test
	public void MapsDaoTest_7() throws Exception{

		assertEquals(1, mapDao.delete(3));
	}

	@Test
	public void MapsDaoTest_8() throws Exception{
		assertEquals(0, mapDao.delete(99));
	}
}
