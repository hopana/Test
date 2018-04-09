package img;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.google.zxing.WriterException;

public class Test {
	public static void main(String args[]) throws WriterException, IOException {
//		QRCode test = new QRCode();
//        File file = new File("E://test.png");
//        test.encode("https://login.weixin.qq.com/p/d9e9a76e6b5f47", file, BarcodeFormat.QR_CODE, 385, 385, null);
//        test.decode(file);
//        
//		try {
//			// 读取第一张图片
//			File fileOne = new File("e:/test.png");
//			BufferedImage ImageOne = ImageIO.read(fileOne);
//			int width = ImageOne.getWidth();// 图片宽度
//			int height = ImageOne.getHeight();// 图片高度
//			// 从图片中读取RGB
//			int[] ImageArrayOne = new int[width * height];
//			ImageArrayOne = ImageOne.getRGB(0, 0, width, height, ImageArrayOne,
//					0, width);
//
//			//System.out.println(width/1.8);
//			//System.out.println(height/1.8);
//			// 对第二张图片做相同的处理
//			File fileTwo = new File("e:/wx1.png");
//			BufferedImage ImageTwo = getConvertedImage(ImageIO.read(fileTwo));
//			int[] ImageArrayTwo = new int[width * height];
//			ImageArrayTwo = ImageTwo.getRGB(0, 0, ImageTwo.getWidth(), ImageTwo
//					.getHeight(), ImageArrayTwo, 0, width);
//			// 生成新图片
//			// BufferedImage ImageNew = new BufferedImage(width * 2, height,
//			// BufferedImage.TYPE_INT_RGB);
//			BufferedImage ImageNew = new BufferedImage(width, height,
//					BufferedImage.TYPE_INT_RGB);
//			ImageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);// 设置左半部分的RGB
//			
//			int newWidth = (width - ImageTwo.getWidth())/2;
//			int newHeight = (height - ImageTwo.getHeight())/2;
//			ImageNew.setRGB(newWidth, newHeight, ImageTwo.getWidth(), ImageTwo.getHeight(), ImageArrayTwo, 0, width);// 设置右半部分的RGB
//			File outFile = new File("e:/out.png");
//			ImageIO.write(ImageNew, "png", outFile);// 写图片
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		StringBuffer sb = new StringBuffer();
		//1501000001-1051005500
		//B餐用1502000001-1502005500号段
		//C餐用1503000001-1503008000号段
		//D餐用1504000001-1504001000号段
		for(int i=1;i<=10;i++) {
			String materialId = "105100" + String.format("%04d", i);
			sb.append("insert into lepos_business.t_material_merchant(F_material_id) values('" + materialId + "');\n");

			InputStream in = QRCodeUtil.createQRcode("http://pos.yeahka.com/leposweb/mobile/regist_pre.do?materialId=" + materialId);
			
			File f = new File("e:\\QR\\" + materialId + ".png");
			OutputStream os = new FileOutputStream(f);
		   int bytesRead = 0;
		   byte[] buffer = new byte[8192];
		   while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
		    os.write(buffer, 0, bytesRead);
		   }
		   os.close();
		   in.close();
		   
		}
			
		getFile(sb.toString().getBytes(),"e:\\","a.txt");
		System.out.println("done");
		
		

		
		
//		byte[] bytes = new byte[in.available()];
//		String base64 = new BASE64Encoder().encode(bytes);
//		System.out.println(base64);
	}
	
	public static void getFile(byte[] bfile, String filePath,String fileName) {
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		File file = null;
		try {
			File dir = new File(filePath);
			if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在
				dir.mkdirs();
			}
			file = new File(filePath+"\\"+fileName);
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
	   /**
     * 将背景为黑色不透明的图片转化为背景透明的图片
     * @param image 背景为黑色不透明的图片（用555格式转化后的都是黑色不透明的）
     * @return 转化后的图片
     */
    private static BufferedImage getConvertedImage(BufferedImage image){
        int width=image.getWidth();
        int height=image.getHeight();
        BufferedImage convertedImage=null;
        Graphics2D g2D=null;
        //采用带1 字节alpha的TYPE_4BYTE_ABGR，可以修改像素的布尔透明
        convertedImage=new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        g2D = (Graphics2D) convertedImage.getGraphics();
        g2D.drawImage(image, 0, 0, null);
        //像素替换，直接把背景颜色的像素替换成0
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                int rgb=convertedImage.getRGB(i, j);
                if(isBackPixel(rgb)){
                    convertedImage.setRGB(i, j,0);
                }
            }
        }
        g2D.drawImage(convertedImage, 0, 0, null);
        return convertedImage;
    }
    /**
     * 判断当前像素是否为黑色不透明的像素（-16777216）
     * @param pixel 要判断的像素
     * @return 是背景像素返回true，否则返回false
     */
    private static boolean isBackPixel(int pixel){
        int back[]={-16777216};
        for(int i=0;i<back.length;i++){
            if(back[i]==pixel) return true;
        }
        return false;
    }
	/**
	 * 合并多张图片 Merge all pics in one ############# # pic1 # ############# # pic2
	 * # ############# # pic3 # #############
	 * 
	 * @param pics
	 * @param dst_pic
	 * @return
	 */
	public static boolean merge(String[] pics, String dst_pic, String type) {
		int len = pics.length;
		if (len < 1) {
			System.out.println("pics len < 1");
			return false;
		}

		File[] src = new File[len];
		BufferedImage[] images = new BufferedImage[len];
		int[][] ImageArrays = new int[len][];
		for (int i = 0; i < len; i++) {
			try {
				src[i] = new File(pics[i]);
				images[i] = ImageIO.read(src[i]);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			int width = images[i].getWidth();
			int height = images[i].getHeight();
			ImageArrays[i] = new int[width * height];// 从图片中读取RGB
			ImageArrays[i] = images[i].getRGB(0, 0, width, height,
					ImageArrays[i], 0, width);
		}
		int dst_height = 0;
		for (int i = 0; i < images.length; i++)
			dst_height += images[i].getHeight();
		if (dst_height < 1) {
			System.out.println("dst_height < 1");
			return false;
		}
		// 生成新图片
		try {
			int dst_width = images[0].getWidth();
			BufferedImage ImageNew = new BufferedImage(images[0].getWidth(),
					dst_height, BufferedImage.TYPE_INT_RGB);
			int height_i = 0;
			for (int i = 0; i < images.length; i++) {
				ImageNew.setRGB(0, height_i, dst_width, images[i].getHeight(),
						ImageArrays[i], 0, dst_width);
				height_i += images[i].getHeight();
			}
			File outFile = new File(dst_pic);
			ImageIO.write(ImageNew, type, outFile);// 写图片
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
