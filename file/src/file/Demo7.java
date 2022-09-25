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
 * Time: 17:42
 */
public class Demo7 {

    public static void main(String[] args) {
        try ( InputStream inputStream = new FileInputStream("test1.txt")){
            // 读文件
            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
