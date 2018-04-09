package cache.ehcache;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @author hupan
 * @version 2.0
 * @created 2015-8-10 上午11:54:13
 */
public class Demo {

    public static void main(String[] args) {
        CacheManager manager = CacheManager.create("src/cache/ehcache/ehcache.xml");
        Cache cache = manager.getCache("demoCache");
        Connection conn = DB.getConnection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT TEST_ID,TEST_NAME,TEST_TIME,TEST_VALUE FROM TEST";
            ResultSet querySet = stmt.executeQuery(sql);

            while (querySet.next()) {
                Bean curr = new Bean();
                curr.TEST_ID = querySet.getLong(1);
                curr.TEST_NAME = querySet.getString(2);
                curr.TEST_TIME = querySet.getTimestamp(3);
                curr.TEST_VALUE = querySet.getBigDecimal(4);

                cache.put(new Element(curr.TEST_ID, curr));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 获取缓存管理器中的缓存配置名称
        for (String cacheName : manager.getCacheNames()) {
            //System.out.println(cacheName);
        }
        // 获取所有的缓存对象
        for (Object key : cache.getKeys()) {
            //System.out.println(key);
        }

        Element elem = cache.get(20L);
        System.out.println(elem.getObjectValue());
    }
}
