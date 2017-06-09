package jp.co.example.test.dao;

import static org.junit.Assert.*;

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
import jp.co.example.dao.MailsDao;
import jp.co.example.entity.Mails;
import jp.co.example.entity.Users;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ContextConfiguration(classes = LoomedApplication.class)
public class MailsDaoTest {

	@Autowired
	MailsDao mailsDao;

	@Test
	public void テスト16() {

		List<Mails> mails = mailsDao.findByReUserId(3);

		assertEquals(2, mails.size());
	}

	@Test
	public void テスト17() {

		List<Mails> mails = mailsDao.findByReUserId(99);

		assertEquals(0, mails.size());
	}

	@Test
	public void テスト18() {

		 Integer count = mailsDao.getNewMails(new Users(3, null, null, null, null));

		 assertEquals(Integer.valueOf(1), count);
	}

	@Test
	public void テスト19() {

		int count = mailsDao.delete(1);

		// 実際のテーブルで確認
		assertEquals(1, count);
	}

	@Test
	public void テスト20() {
		int cnt = mailsDao.delete(88);

		assertEquals(0, cnt);
	}

	@Test
	public void テスト21() {
		// Mails mail = new Mails();
		// mail.setReceptionUserId(11);
		// mail.setTransmissionUserId(22);
		// mail.setMailTitle("欠席確認");
		// mail.setMailContents("降谷さんお疲れ様です、風見です。");
		// // mail.setMailDate(20170512);
		// mail.setOpenFlag(false);

		int count = mailsDao.insert(11, 22, "欠席確認", "降谷さんお疲れ様です、風見です。");

		assertEquals(1, count);
	}

	@Test(expected=DataAccessException.class)
	public void テスト22() {
		int count = mailsDao.insert(0, 0, null, null);
	}

//	@Test
//	public void テスト23() {
//		mailsDao.insert(1, 2,
//				"123456789022345678903234567890423456789052345678906234567890723456789082345678909234567890123456789023これで128",
//				null);
//
//		// データベース目視
//		assertTrue(false);
//	}

	@Test(expected=DataAccessException.class)
	public void テスト26() {

		int cnt = mailsDao.insert(99, 88, "aa", "ii");
	}
}
