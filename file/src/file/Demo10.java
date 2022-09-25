package file;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-24
 * Time: 21:34
 */
public class Demo10 {
    public static void main(String[] args) {

        try (OutputStream outputStream  = new FileOutputStream("test1.txt")){
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println("aaaaaaaaaaaaaa");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
