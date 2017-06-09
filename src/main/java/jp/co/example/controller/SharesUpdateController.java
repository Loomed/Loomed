package jp.co.example.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import enums.LogEnum;
import enums.RedirectController;
import enums.ScopeKey;
import jp.co.example.entity.Shares;
import jp.co.example.entity.Trainings;
import jp.co.example.service.ShareService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@RestController
@Slf4j
@RequestMapping("file/upload")
public class SharesUpdateController {
	@Autowired
	private ShareService SS;

	// 登録
	@RequestMapping(method = RequestMethod.POST)
	public Object post(@RequestParam("upload_file") MultipartFile multipartFile, @RequestParam("filetype") String fileType, // ファイル種類
			HttpSession session, HttpServletRequest reques) throws IOException {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<Shares> list = new ArrayList<Shares>();

		// ファイルが空の場合は異常終了
		if (multipartFile.isEmpty()) {
			return "/shareconfig";
		}
		boolean rad = false;
		String filename = reques.getParameter("inputName");
		String rad1 = reques.getParameter("rad");
		System.out.println(fileType);
		System.out.println(filename);
		if (rad1.equals("1")) {
			rad = true;
		} else {
			rad = false;
		}
		Trainings tra = (Trainings) session.getAttribute(ScopeKey.LOGINROOM.getScopeKey());
		// ファイル種類から決まる値をセットする
		// ファイルパス
		StringBuffer filePath = new StringBuffer("/uploadfile").append(File.separator).append(fileType);
		// アップロードファイルを格納するディレクトリを作成する
		File uploadDir = mkdirs(filePath);
		try {
			// アップロードファイルを置く
			File uploadFile = new File(uploadDir.getPath() + "/" + filename + fileType);
			StringBuffer path = new StringBuffer(uploadDir.getPath() + "/" + filename + fileType);
			String dlpath = new String(path);
			byte[] bytes = multipartFile.getBytes();
			System.out.println(dlpath);
			BufferedOutputStream uploadFileStream = new BufferedOutputStream(new FileOutputStream(uploadFile));
			uploadFileStream.write(bytes);
			uploadFileStream.close();
			SS.InsertFile(tra, dlpath, filename, rad);
			list = SS.selectlist(tra.getTrainingId());
			session.setAttribute("list", list);
			return "アップロードが成功しました。リスト更新のためしばらくお待ち下さい。";
		}catch (NullPointerException w) {
		}

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return RedirectController.SHARECONFIG.getRedirectName();
	}

	/**
	 * アップロードファイルを格納するディレクトリを作成する
	 *
	 * @param filePath
	 * @return
	 */
	private File mkdirs(StringBuffer filePath) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		File uploadDir = new File(filePath.toString());
		// 既に存在する場合はそのフォルダにぶち込む
		if (uploadDir.exists()) {
			uploadDir = new File(filePath.toString());
		} else {
			uploadDir.mkdirs();
		}
		// フォルダ作成
		uploadDir.mkdirs();
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return uploadDir;
	}

	@Bean
	public Filter multipartFilter() {
		MultipartFilter filter = new MultipartFilter();
		return filter;
	}

}
