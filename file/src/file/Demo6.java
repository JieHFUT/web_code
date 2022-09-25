package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-24
 * Time: 17:42
 */
public class Demo6 {

    public static void main(String[] args) throws IOException {
        InputStream inputStream  = new FileInputStream("test1.txt");
        Scanner scanner = new Scanner(inputStream);

        String str = scanner.nextLine();

        System.out.println(str);
        inputStream.close();

    }
}
