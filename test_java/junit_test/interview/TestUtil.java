package interview;

import java.util.List;

import org.junit.Assert;

public class TestUtil<T> {
    public void compareList(List<T> expected, List<T> actual) {
        int i = 0;
        for (T str : expected) {
            Assert.assertEquals("Failed at index " + i, str, actual.get(i++));
        }
    }
}
