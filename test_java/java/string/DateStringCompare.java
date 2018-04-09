package string;

public class DateStringCompare {
    public static void main(String[] args) {
        String date1 = "20130501120323";
        String date2 = "20150700820323";

        Long dateNum1 = Long.parseLong(date1);
        Long dateNum2 = Long.parseLong(date2);
        if (dateNum1 < dateNum2) {
            System.out.println("dateNum1<dateNum2");
        }
    }
}
