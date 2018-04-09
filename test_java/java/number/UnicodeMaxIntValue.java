package number;

/**
 * 注释
 *
 * @author Administrator
 * @since 2017-05-13 22:25
 */
public class UnicodeMaxIntValue {
    public static void main(String[] args) {
         int MAX_PAGE_SIZE = '\uffff';
         int max = Integer.MAX_VALUE;
        System.out.println(MAX_PAGE_SIZE);
        System.out.println(max);
    }
}
