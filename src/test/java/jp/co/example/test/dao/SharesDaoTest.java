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
import jp.co.example.dao.SharesDao;
import jp.co.example.entity.Companies;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ContextConfiguration(classes = LoomedApplication.class)
public class SharesDaoTest {

	@Autowired
	SharesDao sharesDao;

	@Test
	public void テスト62() throws Exception {

		int cnt = sharesDao.insertFilepass(tra, filePath, upload, filename, radio);
		assertTrue(false);

	}

	@Test
	public void テスト63() throws Exception {

		int cnt = sharesDao.insertFilepass(tra, filePath, upload, filename, radio);
		assertTrue()
	}

	@Test
	public void テスト64() throws Exception {

		sharesDao.insert("null");

		assertEquals("null1", sharesDao.insertFilepass("null").get(0).getCompanyName());
	}

	@Test
	public void テスト65() throws Exception {

		int cnt = sharesDao.insertFilepass(tra, filePath, upload, filename, radio);
		assertTrue(false);
	}

	@Test
	public void テスト66() throws Exception {

		int cnt = sharesDao.insertFilepass(tra, filePath, upload, filename, radio);
		assertTrue(false);
	}

	@Test
	public void テスト67() throws Exception {

		int cnt = sharesDao.insertFilepass(tra, filePath, upload, filename, radio);
		assertTrue(false);
	}

	@Test
	public void テスト68() throws Exception {

		int cnt = sharesDao.insertFilepass(tra, filePath, upload, filename, radio);
		assertTrue(false);
	}


}
