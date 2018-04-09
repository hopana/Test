package img;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.google.zxing.WriterException;

public class TestCreateImage {

	private Font font = new Font("Calibri", Font.BOLD, 38);// 添加字体的属性设置 38/50
	private Graphics2D g = null;
	private int fontsize = 0;
	private int x = 0;
	private int y = 0;
	
	public static void main(String[] args) throws WriterException, IOException {
//		createBig();
		createSmall();
	}
	
	public static void createSmall() throws WriterException, IOException {
		//StringBuffer sb = new StringBuffer();
		
//      A餐用1501000001-1501001000号段
//      B餐用1502000001-1502005000号段
//      C餐用1503000001-1503005000号段
		// 1505000001~1505000200
		for (int i = 1; i <= 200; i++) {
			String materialId = "1505000" + String.format("%03d", i);
			//sb.append("insert into lepos_business.t_material_merchant(F_material_id) values('" + materialId + "');\n");
			
			createSmallConcrete(materialId);
		}
		
//		for (int i = 1; i <= 1000; i++) {
//			String materialId = "150100" + String.format("%04d", i);
//			//sb.append("insert into lepos_business.t_material_merchant(F_material_id) values('" + materialId + "');\n");
//
//			createSmallConcrete(materialId);
//		}
		
//		for (int i = 648; i <= 5000; i++) {
//			String materialId = "150200" + String.format("%04d", i);
//			//sb.append("insert into lepos_business.t_material_merchant(F_material_id) values('" + materialId + "');\n");
//			
//			createSmallConcrete(materialId);
//		}

		//tc.getFile(sb.toString().getBytes(), "E:\\QR", "a-sql.txt");

		System.out.println("done");
	
	}
	
	public static void createSmallConcrete(String materialId) throws WriterException, IOException {
		TestCreateImage tc = new TestCreateImage();
		
		InputStream in = QRCodeUtil.createQRcode("http://pos.yeahka.com/leposweb/mobile/regist_pre.do?materialId=" + materialId, 389, 389);

		File f = new File("E:\\QR\\s-" + materialId + ".png");
		OutputStream os = new FileOutputStream(f);
		
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		
		while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
			os.write(buffer, 0, bytesRead);
		}
		os.close();
		in.close();
		
		//合并二维码到白色矩形
		BufferedImage whiteSquare = tc.loadImageLocal("E:\\QR\\s-whiteSquare.png");
		BufferedImage qrCode = tc.loadImageLocal("E:\\QR\\s-" + materialId + ".png");
		tc.writeImageLocal("E:\\QR\\s-newQR-" + materialId + ".png", tc.mergeTop2Bottom(qrCode, whiteSquare, 0, 0));
		
		//往白色矩形上写编号
		BufferedImage newQRCode = tc.loadImageLocal("E:\\QR\\s-newQR-" + materialId + ".png");
		tc.writeImageLocal("E:\\QR\\s-" + materialId + "-code.png", tc.modifyImage(newQRCode, insertWhiteSpace(materialId), 61, 406));
		
		// 合并写了编号的图片到背景
		//BufferedImage finalQR = tc.loadImageLocal("E:\\QR\\s-" + materialId + "-code.png");
		//BufferedImage bigBg = tc.loadImageLocal("E:\\QR\\s-big.png");
		
		// 保存最终图片
		//tc.writeImageLocal("E:\\QR\\small\\" + materialId + ".png", tc.mergeTop2Bottom(finalQR, bigBg, 124, 340));

		new File("E:\\QR\\s-" + materialId + ".png").delete();
		new File("E:\\QR\\s-newQR-" + materialId + ".png").delete();
		//new File("E:\\QR\\s-" + materialId + "-code.png").delete();
	}
	
	public static void createBig() throws WriterException, IOException {
		//StringBuffer sb = new StringBuffer();
		
		//1501000001-1051005500
		//B餐用1502000001-1502005500号段
		//C餐用1503000001-1503008000号段
		//D餐用1504000001-1504001000号段
		
		for (int i = 4000; i <= 5000; i++) {
			String materialId = "150300" + String.format("%04d", i);
			//sb.append("insert into lepos_business.t_material_merchant(F_material_id) values('" + materialId + "');\n");
			
			createBigConcrete (materialId);
		}
		
		for (int i = 1; i <= 1000; i++) {
			String materialId = "150100" + String.format("%04d", i);
			//sb.append("insert into lepos_business.t_material_merchant(F_material_id) values('" + materialId + "');\n");
			
			createBigConcrete (materialId);
		}
		
		for (int i = 1; i <= 5000; i++) {
			String materialId = "150200" + String.format("%04d", i);
			//sb.append("insert into lepos_business.t_material_merchant(F_material_id) values('" + materialId + "');\n");
			
			createBigConcrete (materialId);
		}
		
		//tc.getFile(sb.toString().getBytes(), "E:\\QR", "b-sql.txt");
		
		System.out.println("done");
		
	}
	
	public static void createBigConcrete (String materialId) throws WriterException, IOException {
		TestCreateImage tc = new TestCreateImage();
		
		InputStream in = QRCodeUtil.createQRcode("http://pos.yeahka.com/leposweb/mobile/regist_pre.do?materialId=" + materialId, 649, 649);
		
		File f = new File("E:\\QR\\b-" + materialId + ".png");
		OutputStream os = new FileOutputStream(f);
		
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		
		while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
			os.write(buffer, 0, bytesRead);
		}
		os.close();
		in.close();
		
		//合并二维码到白色矩形
		BufferedImage whiteSquare = tc.loadImageLocal("E:\\QR\\b-whiteSquare.png");
		BufferedImage qrCode = tc.loadImageLocal("E:\\QR\\b-" + materialId + ".png");
		tc.writeImageLocal("E:\\QR\\b-newQR-" + materialId + ".png", tc.mergeTop2Bottom(qrCode, whiteSquare, 0, 0));
		
		//往白色矩形上写编号
		BufferedImage newQRCode = tc.loadImageLocal("E:\\QR\\b-newQR-" + materialId + ".png");
		tc.writeImageLocal("E:\\QR\\b-" + materialId + "-code.png", tc.modifyImage(newQRCode, insertWhiteSpace(materialId), 153, 695));
		
		// 合并写了编号的图片到紫色背景
		BufferedImage finalQR = tc.loadImageLocal("E:\\QR\\b-" + materialId + "-code.png");
		BufferedImage bigBg = tc.loadImageLocal("E:\\QR\\b-big.png");
		tc.writeImageLocal("E:\\QR\\big\\" + materialId + ".png", tc.mergeTop2Bottom(finalQR, bigBg, 266, 584));
		
		new File("E:\\QR\\b-" + materialId + ".png").delete();
		new File("E:\\QR\\b-newQR-" + materialId + ".png").delete();
		new File("E:\\QR\\b-" + materialId + "-code.png").delete();
	}
	
	public static String insertWhiteSpace(String s) {
		if (s == null || "".equals(s)) {
			return s;
		}

		String str = "";
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() -1) {
				str += s.charAt(i) + " ";
			} else {
				str += s.charAt(i);
			}
		}

		return str;
	}
	
	/**
	 * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
	 */
	public BufferedImage modifyImage(BufferedImage img, Object content, int x, int y) {
		try {
			int w = img.getWidth();
			int h = img.getHeight();
			g = img.createGraphics();
			// 抗锯齿效果
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.setBackground(Color.WHITE);
			g.setColor(Color.BLACK);//设置字体颜色
			if (this.font != null)
				g.setFont(this.font);
			// 验证输出位置的纵坐标和横坐标
			if (x >= w || y >= h) {
				this.x = w;
				this.y = h - this.fontsize + 2;
			} else {
				this.x = x;
				this.y = y;
			}
			if (content != null) {
				g.drawString(content.toString(), this.x, this.y);
			}
			g.dispose();
		} catch (Exception e) {
			System.out.println("modifyImage:");
			e.printStackTrace();
		}

		return img;
	}
	
	/**
	 * 导入本地图片到缓冲区
	 */
	public BufferedImage loadImageLocal(String imgName) {
		try {
			return ImageIO.read(new File(imgName));
		} catch (IOException e) {
			System.out.println("loadImageLocal:");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成新图片到本地
	 */
	public void writeImageLocal(String newImage, BufferedImage img) {
		if (newImage != null && img != null) {
			try {
				File outputfile = new File(newImage);
				ImageIO.write(img, "png", outputfile);
			} catch (IOException e) {
				System.out.println("writeImageLocal:");
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将上面的图片合并到底部图片中
	 * @param imgtop
	 * @param imgbottom
	 * @param x
	 * @param y
	 * @return
	 */
	public BufferedImage mergeTop2Bottom(BufferedImage imgtop, BufferedImage imgbottom, int x, int y) {
		BufferedImage newImage = null;

		try {
			//读取第一张图片
			int topWidth = imgtop.getWidth();//图片宽度
			int topHeight = imgtop.getHeight();//图片高度
			//从图片中读取RGB
			int[] arrTop = new int[topWidth * topHeight];
			arrTop = imgtop.getRGB(0, 0, topWidth, topHeight, arrTop, 0, topWidth);
			//对第二张图片做相同的处理
			int bgWidth = imgbottom.getWidth();//图片宽度
			int bgHeight = imgbottom.getHeight();//图片高度
			int[] arrBottom = new int[bgWidth * bgHeight];
			arrBottom = imgbottom.getRGB(0, 0, bgWidth, bgHeight, arrBottom, 0, bgWidth);

			//生成新图片
			newImage = new BufferedImage(bgWidth, bgHeight, BufferedImage.TYPE_INT_RGB);
			//先绘制背景图片
			newImage.setRGB(0, 0, bgWidth, bgHeight, arrBottom, 0, bgWidth);//设置右半部分的RGB
			//再绘制上层图片
			newImage.setRGB(x, y, topWidth, topHeight, arrTop, 0, topWidth);//设置左半部分的RGB

		} catch (Exception e) {
			System.out.println("mergeTop2Bottom:");
			e.printStackTrace();
		}

		return newImage;
	}

	public void getFile(byte[] bfile, String filePath, String fileName) {
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		File file = null;
		try {
			File dir = new File(filePath);
			if (!dir.exists() && dir.isDirectory()) {//判断文件目录是否存在
				dir.mkdirs();
			}
			file = new File(filePath + "\\" + fileName);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(bfile);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}
