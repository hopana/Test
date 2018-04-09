package cache.ehcache;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author hupan
 * @version 2.0
 * @created 2015-8-10 上午11:53:22
 */

public class Bean implements Serializable {
    private static final long serialVersionUID = 1L;

    public Long TEST_ID;
    public String TEST_NAME;
    public Timestamp TEST_TIME;
    public BigDecimal TEST_VALUE;

    @Override
    public String toString() {
        return String.format("ID:%s NAME:%s", TEST_ID, TEST_NAME);
    }
}