package qrcode;

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

    /** Ĭ�Ͽ�� 200 */
    public static final int DEFAULT_WIDTH = 200;

    /** Ĭ�ϸ߶� 200 */
    public static final int DEFAULT_HEIGHT = 200;

    /** Ĭ��ͼƬ��ʽ */
    public static final String FOMART = "png";
    /** �ױߴ�С��ȡֵ��Χ0~4 */
    private static int MARGIN = 0;
    
    /**
     * ���ַ�����ת���ɶ�ά��
     * 
     * @author hupan
     * @version 1.0
     * @created 2015-7-7 ����2:07:35
     * @param content
     * @return
     * @throws WriterException
     * @throws IOException
     */
    public static InputStream createQRcode(String content) throws WriterException, IOException {
        // ��������QR��ά�����
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        // ���ñ��뷽ʽ
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, MARGIN);
       
        // ��ɾ��󣬲���˳��ֱ�Ϊ���������ݣ��������ͣ����ͼƬ��ȣ����ͼƬ�߶ȣ����ò���
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, DEFAULT_WIDTH, DEFAULT_HEIGHT, hints);
        //bitMatrix = deleteWhite(bitMatrix);
        
        // �����ֽ����������
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // ���ͼ��
        MatrixToImageWriter.writeToStream(bitMatrix, FOMART, baos);
        
        return new ByteArrayInputStream(baos.toByteArray());
    }
    
    /**
     * ���ַ�����ת���ɶ�ά��
     * 
     * @author hupan
     * @version 1.0
     * @created 2016-8-24 ����17:47:35
     * @param content
     * @param width
     * @param height
     * @return
     * @throws WriterException
     * @throws IOException
     */
    public static InputStream createQRcode(String content, int width, int height) throws WriterException, IOException {
    	// ��������QR��ά�����
    	Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
    	// ���ñ��뷽ʽ
    	hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
    	hints.put(EncodeHintType.MARGIN, MARGIN);
    	
    	// ��ɾ��󣬲���˳��ֱ�Ϊ���������ݣ��������ͣ����ͼƬ��ȣ����ͼƬ�߶ȣ����ò���
    	BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
    	//bitMatrix = deleteWhite(bitMatrix);
    	
    	// �����ֽ����������
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	// ���ͼ��
    	MatrixToImageWriter.writeToStream(bitMatrix, FOMART, baos);
    	
    	return new ByteArrayInputStream(baos.toByteArray());
    }
    
    /** 
     * ��ά��ȥ�ױ�
     * 
     * @author hupan
     * @version 1.0
     * @created 2015-7-20 ����9:07:43
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
