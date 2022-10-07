package file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo7 {
    // 使用字符流读一下文件
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("test2.txt");
        char[] buffer = new char[1024];
        int len = reader.read(buffer);
        for (int i = 0; i < len; i++) {
            System.out.println(buffer[i]);
        }
        reader.close();
    }
}
