<<<<<<< HEAD
//package jp.co.example.dao.impl;
//
//import org.springframework.stereotype.Repository;
//
//import jp.co.example.dao.MailsDao;
//
//@Repository
//public class MailsDaoImpl implements MailsDao {
//	@Override
//	Mails findByIdAndTitleAndContents(Integer mailID, String mailTitle, String mailContents) {
//
//	}
//}
=======
package jp.co.example.dao.impl;

import org.springframework.stereotype.Repository;

import jp.co.example.dao.MailsDao;
import jp.co.example.entity.Mails;

@Repository
public class MailsDaoImpl implements MailsDao {
	@Override
	public Mails findByIdAndTitleAndContents(Integer mailID, String mailTitle, String mailContents) {
		return Mails;

	}
}
>>>>>>> df8e6986e156f24fe0fe9649136a8ed228c67c8a
