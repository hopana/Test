package string;

/**
 * @author hupan
 * @version 2.0
 * @created 2015-8-6 下午2:14:48
 */
public class IPTest {
    public static void main(String[] args) {
        String ip = "192.168.5.41";
        System.out.println(toLong(ip));
    }

    public static long toLong(String ip) {
        String[] strs = ip.split("\\.");
        if ((strs == null) || (strs.length != 4)) {
            return -1L;
        }
        long[] parts = new long[4];
        for (int i = 0; i < 4; i++) {
            parts[i] = Integer.parseInt(strs[i]);
            if (parts[i] < 0L) {
                return -2L;
            }
        }

        System.out.println(parts[0] << 24);
        System.out.println(parts[1] << 16);
        System.out.println(parts[2] << 8);
        System.out.println(parts[3]);

        return (parts[0] << 24) + (parts[1] << 16) + (parts[2] << 8) + parts[3];
    }
}
