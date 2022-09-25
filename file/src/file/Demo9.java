package file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-24
 * Time: 21:31
 */
public class Demo9 {
    public static void main(String[] args) {
        try (Writer writer =  new FileWriter("test1.txt")){
            writer.write("hello world");

            writer.write("\nnihao");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
