package file;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-24
 * Time: 17:59
 */
public class Demo8 {

    public static void main(String[] args) {

        try (OutputStream outputStream = new FileOutputStream("test1.txt")){

            String s = "hello javaee";
            outputStream.write(s.getBytes());

            String s1 = "\nhello javase";
            outputStream.write(s1.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
