package file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-24
 * Time: 17:39
 */
public class Demo5 {

    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("test1.txt");

        char[] buffer = new char[100];
        int len = reader.read(buffer);
        for (int i = 0; i < len; i++) {

            System.out.print(buffer[i]);
        }
        reader.close();
    }

}
