package qrcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Utils {

	public static String insertWhiteSpace(String s) {
		if (s == null || "".equals(s)) {
			return s;
		}

		String str = "";
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() - 1) {
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
	public static BufferedImage modifyImage(BufferedImage img, Object content, int x, int y, Font font) {
		try {
			Graphics2D g = img.createGraphics();

			int w = img.getWidth();
			int h = img.getHeight();

			// 抗锯齿效果
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.setBackground(Color.WHITE);
			g.setColor(Color.BLACK);//设置字体颜色

			if (font != null) {
				g.setFont(font);
			}

			// 验证输出位置的纵坐标和横坐标
			if (x >= w || y >= h) {
				x = w;
				y = h - font.getSize() + 2;
			}

			if (content != null) {
				g.drawString(content.toString(), x, y);
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
	public static BufferedImage loadImageLocal(String imgName) {
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
	public static void writeImageLocal(String newImage, BufferedImage img) {
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
	public static BufferedImage mergeTop2Bottom(BufferedImage imgtop, BufferedImage imgbottom, int x, int y) {
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
}
