package jp.co.example.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jp.co.example.entity.Trainings;
import jp.co.example.service.ShareService;
@RestController
@RequestMapping("file/upload")
public class SharesUpdateController {
	@Autowired
	private ShareService SS;

	//登録
		 @RequestMapping(method = RequestMethod.POST)
		    public Object post(
		            @RequestParam("upload_file") MultipartFile multipartFile,
		            @RequestParam("filetype") String fileType ,// ファイル種類
		            HttpSession session,HttpServletRequest reques){

		        // ファイルが空の場合は異常終了
		        if(multipartFile.isEmpty()){
		            // 異常終了時の処理
		        }
		        boolean rad ;
		        String filename = reques.getParameter("inputName");
		        String radio = reques.getParameter("rad1");
		        if(radio.equals("visible")){
		        	 rad = true;
		        }else{
		        	rad = false;
		        }
		       // Trainings tra = (Trainings) session.getAttribute(ScopeKey.LOGINROOM.getScopeKey());
		        // ファイル種類から決まる値をセットする
		        StringBuffer filePath = new StringBuffer("/uploadfile")
		                                        .append(File.separator).append(fileType);   //ファイルパス
		        Trainings tra = new Trainings(5,"セキュリティ講座",1,"セキュリティ講座としてSEA/J資格受験");
		        // アップロードファイルを格納するディレクトリを作成する
		        File uploadDir = mkdirs(filePath);

		        try {
		            // アップロードファイルを置く
		            File uploadFile =
		                    new File(uploadDir.getPath() + "/" + fileType);
		            byte[] bytes = multipartFile.getBytes();
		            BufferedOutputStream uploadFileStream =
		                    new BufferedOutputStream(new FileOutputStream(uploadFile));
		            uploadFileStream.write(bytes);
		            uploadFileStream.close();
		            SS.InsertFile(tra,filePath,filename,rad);
		            return "アップロード成功";
		        } catch (Exception e) {
		            // 異常終了時の処理
		        } catch (Throwable t) {
		            // 異常終了時の処理
		        }
				return "/shareconfig";
		    }
		    /**
		     * アップロードファイルを格納するディレクトリを作成する
		     *
		     * @param filePath
		     * @return
		     */
		    private File mkdirs(StringBuffer filePath){
		        Date now = new Date();
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		        File uploadDir = new File(filePath.toString(), sdf.format(now));
		        // 既に存在する場合はプレフィックスをつける
		        int prefix = 0;
		        while(uploadDir.exists()){
		            prefix++;
		            uploadDir =
		                    new File(filePath.toString() + sdf.format(now) + "-" + String.valueOf(prefix));
		        }

		        // フォルダ作成
		        uploadDir.mkdirs();

		        return uploadDir;
		    }

}
