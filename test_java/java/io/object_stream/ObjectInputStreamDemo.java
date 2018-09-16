package io.object_stream;

import java.io.*;

/**
 * 测试ObjectInputStream的resolveObject方法
 *
 * @author hupan
 * @date 2018/07/12
 */

public class ObjectInputStreamDemo extends ObjectInputStream {

    public ObjectInputStreamDemo(InputStream in) throws IOException {
        super(in);
    }

    public static void main(String[] args) {
        try {
            // create an ObjectInputStream for the file we created before
            ObjectInputStreamDemo ois = new ObjectInputStreamDemo(new FileInputStream("D:\\rsa.keypair.dat"));

            // enable object resolving
            ois.enableResolveObject(true);

            // get the class for string and print the name
            System.out.println("" + ois.resolveObject(ois.readObject()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}