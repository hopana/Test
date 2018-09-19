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
        for (int i = 0; i < 10000; i++) {
            System.out.println(compress(i + ""));
        }
    }

    private static String compress(String s) {
        String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String md5Str = Md5Util.getMD5Str1(s);

        String[] resUrl = new String[4];
        for (int i = 0; i < 4; i++) {
            String tempStr = md5Str.substring(i * 8, i * 8 + 8);
            long lHexLong = 0x3FFFFFFF & Long.parseLong(tempStr, 16);
            StringBuilder outChars = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                // 把得到的值与0x0000003D进行位与运算，取得字符数组chars索引
                // 把取得的字符相加
                outChars.append(chars[(int) lHexLong % 61]);
                // 每次循环按位右移 5 位
                lHexLong = lHexLong >> 5;
            }
            // 把字符串存入对应索引的输出数组
            resUrl[i] = outChars.toString();
        }

        return resUrl[0];
    }
}
