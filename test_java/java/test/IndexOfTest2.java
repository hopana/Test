package test;

public class IndexOfTest2 {
    public static void main(String[] args) {
        //String names = "梁博,比尔盖茨,周瑜,曹操,刘备,";
        String names = ",梁博,比尔盖茨周瑜曹操刘备";
        if (names.indexOf(",") > 0) {
            System.out.println("Bingo...");
        } else {
            System.out.println(names.indexOf(","));
        }
    }
}
