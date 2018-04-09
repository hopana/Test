package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class ReverseOrder extends ArrayList {
    public static String read(String fileName) throws IOException {
        StringBuffer sb = new StringBuffer();
        LinkedList lines = new LinkedList();
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;
        while ((s = in.readLine()) != null)
            lines.add(s);
        in.close();
        ListIterator it = lines.listIterator(lines.size());
        while (it.hasPrevious()) {
            sb.append(it.previous());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void write(String fileName, String text) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        out.print(text);
        out.close();
    }

    public ReverseOrder(String fileName) throws IOException {
        super(Arrays.asList(read(fileName).split("\n")));
    }

    public void write(String fileName) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        for (int i = 0; i < size(); i++)
            out.println(get(i));
        out.close();
    }

    public static void main(String[] args) throws Exception {
        String fileName = "e:\\1124\\before.txt";
        ReverseOrder text = new ReverseOrder(fileName);
        text.write("e:\\1124\\after.txt");
    }
    /*
	 * �����һ�����У��ֹ�ɾ��һ��
	 */
}