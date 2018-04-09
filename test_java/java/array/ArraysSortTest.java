package array;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class ArraysSortTest {

    public static void main(String[] args) {
        String token = "4gService";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String timestamp = sdf.format(date);
        String nonce = String.valueOf(new Random().nextInt(100));
        String[] arr = new String[]{token, timestamp, nonce};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
