package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

public class GetImgHW {
	public static Map<String, Long> getImgInfo(String imgpath) {
		Map<String, Long> map = new HashMap<String, Long>(3);
		File imgfile = new File(imgpath);
		try {
			FileInputStream fis = new FileInputStream(imgfile);
			BufferedImage buff = ImageIO.read(imgfile);
			map.put("w", buff.getWidth() * 1L);
			map.put("h", buff.getHeight() * 1L);
			map.put("s", imgfile.length());
			fis.close();
		} catch (FileNotFoundException e) {
			System.err.println("所给的图片文件" + imgfile.getPath() + "不存在！计算图片尺寸大小信息失败！");
			map = null;
		} catch (IOException e) {
			System.out.println(e);
			System.err.println("计算图片" + imgfile.getPath() + "尺寸大小信息失败！");
			map = null;
		}
		return map;
	}

	public static void main(String[] args) {
		Map<String, Long> map = getImgInfo("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
		
		for (Entry<String, Long> entry: map.entrySet()) {
			System.out.println("key:"+ entry.getKey());
			System.out.println("value:"+ entry.getValue());
		}
	}
}
