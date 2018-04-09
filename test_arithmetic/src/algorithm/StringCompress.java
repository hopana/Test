package algorithm;

import algorithm.utils.Md5Util;

/**
 * 16位整数字符串压缩为6位唯一推荐码
 *
 * @author hupan
 * @since 2018-04-09 10:53
 */
public class StringCompress {

    public static void main(String[] args) {

    }

    private static String[] compress(String url) {
        // 要使用生成 URL 的字符
        String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        // 对传入网址进行 MD5 加密
        //String md5Str = Md5Util.getMD5Str1(url);

        String[] resUrl = new String[4];
        for (int i = 0; i < 4; i++) {

            // 把加密字符按照8位一组看成16进制与0x3FFFFFFF进行位与运算
            String tempStr = md5Str.substring(i * 8, i * 8 + 8);

            // 这里需要使用long型来转换，因为Inteper.parseInt()只能处理31位,首位为符号位,如果不用long，则会越界
            long lHexLong = 0x3FFFFFFF & Long.parseLong(tempStr, 16);
            StringBuilder outChars = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                // 把得到的值与0x0000003D进行位与运算，取得字符数组chars索引
                long index = 0x0000003D & lHexLong;
                // 把取得的字符相加
                outChars.append(chars[(int) index]);
                // 每次循环按位右移 5 位
                lHexLong = lHexLong >> 5;
            }
            // 把字符串存入对应索引的输出数组
            resUrl[i] = outChars.toString();
        }
        return resUrl;
    }
}
