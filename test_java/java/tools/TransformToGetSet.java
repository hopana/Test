package tools;

public class TransformToGetSet {
    public static void main(String[] args) {
        String[] columns = {"F_status", "F_create_time"};

        for (int i = 0; i < columns.length; i++) {
            String[] arr = columns[i].split("_");

            String attr = "";
            for (String s : arr) {
                attr += s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
            }

            columns[i] = "get" + attr;
        }

        for (String s : columns) {
            System.out.println(s);
        }
    }
}
