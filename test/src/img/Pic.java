package img;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Pic {

	private Font font = new Font("微软雅黑", Font.BOLD, 12);// 添加字体的属性设置

	private Graphics2D g = null;

	private int fontsize = 0;

	private int x = 0;

	private int y = 0;

	/**
	 * 导入本地图片到缓冲区
	 */
	public BufferedImage loadImageLocal(String imgName) {
		try {
			return ImageIO.read(new File(imgName));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * 导入网络图片到缓冲区
	 */
	public BufferedImage loadImageUrl(String imgName) {
		try {
			URL url = new URL(imgName);
			return ImageIO.read(url);
		} catch (IOException e) {
			System.out.println(e.getMessage());
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
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * 设定文字的字体等
	 */
	public void setFont(String fontStyle, int fontSize) {
		this.fontsize = fontSize;
		this.font = new Font(fontStyle, Font.PLAIN, fontSize);
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
	 */
	public BufferedImage modifyImage(BufferedImage img, Object content, int x, int y) {

		try {
			int w = img.getWidth();
			int h = img.getHeight();
			g = img.createGraphics();
			g.setBackground(Color.WHITE);
			g.setColor(Color.BLACK);//设置字体颜色
			if (this.font != null)
				g.setFont(this.font);
			// 验证输出位置的纵坐标和横坐标
			if (x >= h || y >= w) {
				this.x = h - this.fontsize + 2;
				this.y = w;
			} else {
				this.x = x;
				this.y = y;
			}
			if (content != null) {
				g.drawString(content.toString(), this.x, this.y);
			}
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return img;
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（输出多个文本段） xory：true表示将内容在一行中输出；false表示将内容多行输出
	 */
	public BufferedImage modifyImage(BufferedImage img, Object[] contentArr, int x, int y, boolean xory) {
		try {
			int w = img.getWidth();
			int h = img.getHeight();
			g = img.createGraphics();
			g.setBackground(Color.WHITE);
			g.setColor(Color.RED);
			if (this.font != null)
				g.setFont(this.font);
			// 验证输出位置的纵坐标和横坐标
			if (x >= h || y >= w) {
				this.x = h - this.fontsize + 2;
				this.y = w;
			} else {
				this.x = x;
				this.y = y;
			}
			if (contentArr != null) {
				int arrlen = contentArr.length;
				if (xory) {
					for (int i = 0; i < arrlen; i++) {
						g.drawString(contentArr[i].toString(), this.x, this.y);
						this.x += contentArr[i].toString().length() * this.fontsize / 2 + 5;// 重新计算文本输出位置
					}
				} else {
					for (int i = 0; i < arrlen; i++) {
						g.drawString(contentArr[i].toString(), this.x, this.y);
						this.y += this.fontsize + 2;// 重新计算文本输出位置
					}
				}
			}
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return img;
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
	 * 
	 * 时间:2007-10-8
	 * 
	 * @param img
	 * @return
	 */
	public BufferedImage modifyImageYe(BufferedImage img) {

		try {
			int w = img.getWidth();
			int h = img.getHeight();
			g = img.createGraphics();
			g.setBackground(Color.WHITE);
			g.setColor(Color.blue);//设置字体颜色
			if (this.font != null)
				g.setFont(this.font);
			g.drawString("www.hi.baidu.com?xia_mingjian", w - 85, h - 5);
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return img;
	}

	public BufferedImage modifyImagetogeter(BufferedImage imgtop, BufferedImage imgbottom, int x, int y) {
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
			System.out.println(e.getMessage());
		}

		return newImage;
	}

	public static void main(String[] args) {

		Pic tt = new Pic();

		BufferedImage d = tt.loadImageLocal("E:\\bg.png");
		BufferedImage b = tt.loadImageLocal("E:\\11.png");
		//往图片上写文件
		tt.writeImageLocal("E:\\bg1.png", tt.modifyImage(d, "W 1 A 8 5 6 9 1", 35, 155));

		//将多张图片合在一起
		tt.writeImageLocal("E:\\new.png", tt.modifyImagetogeter(b, d, 15, 10));
		
//		BufferedImage e = tt.loadImageLocal("E:\\new.png");
//		BufferedImage f = tt.loadImageLocal("E:\\big.png");
		BufferedImage e = tt.loadImageLocal("E:\\new.png");
		BufferedImage f = tt.loadImageLocal("E:\\big.png");
		tt.writeImageLocal("E:\\newbig.png", tt.modifyImagetogeter(e, f, 69, 50));

		System.out.println("success");
	}

}
