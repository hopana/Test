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
        System.out.println(compress("1598645168486981"));
        System.out.println(compress("1598645168486982"));
        System.out.println(compress("1598645168486983"));
        System.out.println(compress("3598645168486983"));
        System.out.println(compress("2598645168486983"));
        System.out.println(compress("5598645168486983"));
    }

    private static String compress(String s) {
        String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String md5Str = Md5Util.getMD5Str1(s);

        String[] resUrl = new String[2];
        for (int i = 0; i < 2; i++) {
            String tempStr = md5Str.substring(i * 8, i * 8 + 8);
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

        return resUrl[0];
    }
}
