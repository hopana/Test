package img;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class MergeTwo {
	public void createPicTwo2(int x, int y) {
		try {
			//读取第一张图片
			File fileOne = new File("e:\\big.png");
			BufferedImage ImageOne = ImageIO.read(fileOne);
			int width = ImageOne.getWidth();//图片宽度
			int height = ImageOne.getHeight();//图片高度
			//从图片中读取RGB
			int[] ImageArrayOne = new int[width * height];
			ImageArrayOne = ImageOne.getRGB(0, 0, width, height, ImageArrayOne, 0, width);
			//对第二张图片做相同的处理
			File fileTwo = new File("e:\\new.png");
			BufferedImage ImageTwo = ImageIO.read(fileTwo);
			int widthTwo = ImageTwo.getWidth();//图片宽度
			int heightTwo = ImageTwo.getHeight();//图片高度
			int[] ImageArrayTwo = new int[widthTwo * heightTwo];
			ImageArrayTwo = ImageTwo.getRGB(0, 0, widthTwo, heightTwo, ImageArrayTwo, 0, widthTwo);

			//生成新图片
			BufferedImage ImageNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			ImageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);//设置左半部分的RGB
			ImageNew.setRGB(x, y, widthTwo, heightTwo, ImageArrayTwo, 0, widthTwo);//设置右半部分的RGB
			ImageNew.setRGB(x * 2, y, widthTwo, heightTwo, ImageArrayTwo, 0, widthTwo);//设置右半部分的RGB
			File outFile = new File("e:\\out.png");
			ImageIO.write(ImageNew, "png", outFile);//写图片

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MergeTwo mt = new MergeTwo();
		mt.createPicTwo2(0, 0);
	}
}
