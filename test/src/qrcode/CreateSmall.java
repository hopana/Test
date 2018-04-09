package qrcode;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.google.zxing.WriterException;

public class CreateSmall {
	public static void main(String[] args) throws WriterException, IOException {
		createSmall();
	}
	
	public static void createSmall() throws WriterException, IOException {
//      A餐用1501000001-1501001000号段
//      B餐用1502000001-1502005000号段
//      C餐用1503000001-1503005000号段
//		
		for (int i = 1; i <= 1000; i++) {
			createSmallConcrete("150100" + String.format("%04d", i), "150100");
		}
		
		for (int i = 1; i <= 5000; i++) {
			createSmallConcrete("150200" + String.format("%04d", i), "150200");
		}
		
//		for (int i = 1; i <= 5000; i++) {
//			createSmallConcrete("150300" + String.format("%04d", i), "150300");
//		}		

		System.out.println("done");
	
	}
	
	public static void createSmallConcrete(String materialId, String dir) throws WriterException, IOException {
		InputStream in = QRCodeUtil.createQRcode("http://pos.yeahka.com/leposweb/mobile/regist_pre.do?materialId=" + materialId, 389, 389);

		File f = new File("E:\\QR2\\s-" + materialId + ".png");
		OutputStream os = new FileOutputStream(f);
		
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		  
		while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
			os.write(buffer, 0, bytesRead);
		}
		os.close();
		in.close();
		
		//合并二维码到白色矩形
		BufferedImage whiteSquare = Utils.loadImageLocal("E:\\QR2\\s-whiteSquare.png");
		BufferedImage qrCode = Utils.loadImageLocal("E:\\QR2\\s-" + materialId + ".png");
		Utils.writeImageLocal("E:\\QR2\\s-newQR-" + materialId + ".png", Utils.mergeTop2Bottom(qrCode, whiteSquare, 0, 0));
		
		//往白色矩形上写编号
		BufferedImage newQRCode = Utils.loadImageLocal("E:\\QR2\\s-newQR-" + materialId + ".png");
		Utils.writeImageLocal("E:\\QR2\\small\\" + dir + "\\" + materialId + ".png", Utils.modifyImage(newQRCode, Utils.insertWhiteSpace(materialId), 61, 406, new Font("Calibri", Font.BOLD, 38)));
		
		// 合并写了编号的图片到紫色背景
//		BufferedImage finalQR = Utils.loadImageLocal("E:\\QR2\\s-" + materialId + "-code.png");
//		BufferedImage bigBg = Utils.loadImageLocal("E:\\QR2\\s-big.png");
		
		//保存最终合成好的图片
//		Utils.writeImageLocal("E:\\QR2\\small\\" + dir + "\\" + materialId + ".png", Utils.mergeTop2Bottom(finalQR, bigBg, 124, 340));

		new File("E:\\QR2\\s-" + materialId + ".png").delete();
		new File("E:\\QR2\\s-newQR-" + materialId + ".png").delete();
//		new File("E:\\QR2\\s-" + materialId + "-code.png").delete();
	}
	
}
