package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) {
        try {
            InputStreamReader isr1 = new InputStreamReader(new FileInputStream("Data.txt"));
            InputStreamReader isr2 = new InputStreamReader(new FileInputStream(new File("Data.txt")));
            InputStreamReader isr3 = new InputStreamReader(System.in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
