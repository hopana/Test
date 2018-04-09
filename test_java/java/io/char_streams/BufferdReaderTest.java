package io.char_streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class BufferdReaderTest {
    public static void main(String[] args) {
        try {
            Reader reader = new BufferedReader(new FileReader("D:/test.txt"));
            if (reader.read() != -1) {
                System.out.println((char) (reader.read()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

