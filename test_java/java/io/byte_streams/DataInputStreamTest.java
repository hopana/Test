package io.byte_streams;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class DataInputStreamTest {
    public static void main(String[] args) throws FileNotFoundException {
        DataInputStream dis = new DataInputStream(new FileInputStream("in.txt"));
    }
}
