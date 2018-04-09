package io.file;

import java.io.File;
import java.io.IOException;

public class GetAbsolutePathTest {
    public static void main(String[] args) throws IOException {
        File f = File.createTempFile("test", ".txt");
        System.out.println(f.getAbsolutePath());
    }
}
