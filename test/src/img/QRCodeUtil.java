package img;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRCodeUtil {

    /** 默认宽度 200 */
    public static final int DEFAULT_WIDTH = 200;

    /** 默认高度 200 */
    public static final int DEFAULT_HEIGHT = 200;

    /** 默认图片格式 */
    public static final String FOMART = "png";
    /** 白边大小，取值范围0~4 */
    private static int MARGIN = 0;
    
    /**
     * 将字符串内容转换成二维码
     * 
     * @author hupan
     * @version 1.0
     * @created 2015-7-7 下午2:07:35
     * @param content
     * @return
     * @throws WriterException
     * @throws IOException
     */
    public static InputStream createQRcode(String content) throws WriterException, IOException {
        // 用于设置QR二维码参数
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        // 设置编码方式
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, MARGIN);
       
        // 生成矩阵，参数顺序分别为：编码内容，编码类型，生成图片宽度，生成图片高度，设置参数
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, DEFAULT_WIDTH, DEFAULT_HEIGHT, hints);
        //bitMatrix = deleteWhite(bitMatrix);
        
        // 创建字节数组输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 输出图像
        MatrixToImageWriter.writeToStream(bitMatrix, FOMART, baos);
        
        return new ByteArrayInputStream(baos.toByteArray());
    }
    
    /**
     * 将字符串内容转换成二维码
     * 
     * @author hupan
     * @version 1.0
     * @created 2016-8-24 下午17:47:35
     * @param content
     * @param width
     * @param height
     * @return
     * @throws WriterException
     * @throws IOException
     */
    public static InputStream createQRcode(String content, int width, int height) throws WriterException, IOException {
    	// 用于设置QR二维码参数
    	Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
    	// 设置编码方式
    	hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
    	hints.put(EncodeHintType.MARGIN, MARGIN);
    	
    	// 生成矩阵，参数顺序分别为：编码内容，编码类型，生成图片宽度，生成图片高度，设置参数
    	BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
    	//bitMatrix = deleteWhite(bitMatrix);
    	
    	// 创建字节数组输出流
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	// 输出图像
    	MatrixToImageWriter.writeToStream(bitMatrix, FOMART, baos);
    	
    	return new ByteArrayInputStream(baos.toByteArray());
    }
    
    /** 
     * 二维码去白边
     * 
     * @author hupan
     * @version 1.0
     * @created 2015-7-20 上午9:07:43
     * @param matrix
     * @return
     */
    public static BitMatrix deleteWhite(BitMatrix matrix){
        int[] rec = matrix.getEnclosingRectangle();
        int resWidth = rec[2] + 1;
        int resHeight = rec[3] + 1;

        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
        resMatrix.clear();
        for (int i = 0; i < resWidth; i++) {
            for (int j = 0; j < resHeight; j++) {
                if (matrix.get(i + rec[0], j + rec[1]))
                    resMatrix.set(i, j);
            }
        }
        return resMatrix;
    }
    
}
