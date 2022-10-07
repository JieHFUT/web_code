package file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Demo9 {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("test2.txt")) {
            // 读文件
            byte[] b = new byte[1024];
            int len = inputStream.read(b);
            // .............
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
