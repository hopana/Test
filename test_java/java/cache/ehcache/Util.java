package cache.ehcache;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Random;

/**
 * @author hupan
 * @version 2.0
 * @created 2015-8-10 上午11:51:15
 */

public class Util {

    public static Random rand = new Random();
    public static String atoz = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String genString(int length) {
        StringBuilder re = new StringBuilder(length);
        re.append(atoz.charAt(rand.nextInt(52)));
        for (int i = 0; i < length; i++) {
            re.append(atoz.charAt(rand.nextInt(62)));
        }
        return re.toString();
    }

    public static double genDouble() {
        double d1 = 5120 * rand.nextDouble();
        double d2 = 1024000 * rand.nextDouble();
        return d1 + d2;
    }

    public static void traditionalInsert(int total) throws Exception {
        Thread.sleep(3000);
        Timestamp current = new Timestamp(System.currentTimeMillis());
        Connection conn = DB.getConnection();
        try {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO TEST (TEST_ID,TEST_NAME,TEST_TIME,TEST_VALUE) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 1; i <= total; i++) {
                ps.setLong(1, i);
                ps.setString(2, Util.genString(33));
                ps.setTimestamp(3, current);
                ps.setBigDecimal(4, new BigDecimal(Util.genDouble()));
                ps.addBatch();
                if ((i % 500) == 0) {
                    ps.executeBatch();
                }
            }
            ps.executeBatch();
            conn.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }
}