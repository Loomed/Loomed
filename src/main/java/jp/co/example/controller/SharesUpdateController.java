package jp.co.example.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
	public Object post(@RequestParam("upload_file") MultipartFile multipartFile,
			@RequestParam("filetype") String fileType, // ファイル種類
			HttpSession session, HttpServletRequest reques) throws IOException {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

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
		// Trainings tra = (Trainings)
		// session.getAttribute(ScopeKey.LOGINROOM.getScopeKey());
		// ファイル種類から決まる値をセットする
		// ファイルパス
		StringBuffer filePath = new StringBuffer("/uploadfile").append(File.separator).append(fileType);

		Trainings tra = new Trainings(5, "セキュリティ講座", 1, "セキュリティ講座としてSEA/J資格受験");
		// アップロードファイルを格納するディレクトリを作成する
		File uploadDir = mkdirs(filePath);
		try {
			// アップロードファイルを置く
			File uploadFile = new File(uploadDir.getPath() + "/" + filename + fileType);
			StringBuffer path = new StringBuffer(uploadDir.getPath() + "/" + filename + fileType);
			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream uploadFileStream = new BufferedOutputStream(new FileOutputStream(uploadFile));
			uploadFileStream.write(bytes);
			uploadFileStream.close();
			SS.InsertFile(tra, path, filename, rad);
			return "アップロード成功";
		} catch (Exception e) {
			// 異常終了時の処理
			return "エラー";
		} catch (Throwable t) {
			// 異常終了時の処理
		}

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return "/shareconfig";
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
		// 既に存在する場合はプレフィックスをつける
		int prefix = 0;
		while (uploadDir.exists()) {
			prefix++;
			uploadDir = new File(filePath.toString() + String.valueOf(prefix));
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
