package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-24
 * Time: 16:20
 */
public class Demo4 {

    public static void main(String[] args) throws IOException {
        // use InputStream

        InputStream inputStream = null;
        // open file test1.txt
        try {
            inputStream = new FileInputStream("./test1.txt");


            /*int count = 0;
        while (true){
            int b = inputStream.read();
            if (b == -1)
                break;
            count++;
            System.out.println(b);
        }
        System.out.println("the number of byte = " + count);*/


            System.out.println("==============================");
            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);
            System.out.println("the number of byte = " + len);
            String str = new String(bytes, 0, len, "utf8");
            System.out.println(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }






    }
}
