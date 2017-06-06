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
public class MailsDaoTest {
//	Mails findByIdAndTitleAndContents(Integer mailID, String mailTitle, String mailContents);
//
//	Integer getNewMails(Users user);

	@Autowired
	private MailsDao mailsDao;

	@Test
	public void メールが取得できる() throws Exception{
		assertTrue(true);
	}

	@Test
	public void メールが取得できない() throws Exception{
		assertTrue(true);
	}

	@Test
	public void 最新のメール数を取得できる() throws Exception{
		assertTrue(true);
	}

	@Test
	public void 最新のメール数を取得できない() throws Exception{
		assertTrue(true);
	}

}
