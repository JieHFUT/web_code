package file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo10 {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("test2.txt")) {

//            outputStream.write('h');
//            outputStream.write('e');
//            outputStream.write('l');
//            outputStream.write('l');
//            outputStream.write('o');

            String s = "hello java";
            outputStream.write(s.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
