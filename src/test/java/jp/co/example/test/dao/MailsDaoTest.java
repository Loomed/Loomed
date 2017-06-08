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
import jp.co.example.dao.MailsDao;
import jp.co.example.entity.Mails;

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

		assertEquals(null, mails);
	}

	@Test
	public void テスト18() {
//
//		 Mails Mails = mailsDao.getNewMails(null);
//
//		 assertEquals(Integer.valueOf(1), Mails.getCompanyId());
	}

	@Test
	public void テスト19() {

		mailsDao.delete(1);

		// 実際のテーブルで確認
		assertTrue(false);
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

		mailsDao.insert(11, 22, "欠席確認", "降谷さんお疲れ様です、風見です。");

		// データベース目視
		assertTrue(false);
	}

	@Test
	public void テスト22() {
	}

	@Test
	public void テスト23() {
		mailsDao.insert(1, 2,
				"123456789022345678903234567890423456789052345678906234567890723456789082345678909234567890123456789023これで128",
				null);

		// データベース目視
		assertTrue(false);
	}

	@Test
	public void テスト26() {

		int cnt = mailsDao.insert(99, 88, null, null);

		assertEquals(0, cnt);
	}
}
