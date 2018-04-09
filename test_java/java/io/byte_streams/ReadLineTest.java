package io.byte_streams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadLineTest {

    public static void main(String[] args) {
        String br_value = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\man.log")));
            while (br.readLine() != null) {
                br_value += br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(br_value);
    }

}
