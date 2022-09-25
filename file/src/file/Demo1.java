package file;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-22
 * Time: 10:05
 */
public class Demo1 {

    public static void main(String[] args) throws IOException, InterruptedException {

        File file = new File("E:/code/web_code/file/test1.txt");

        System.out.println(file.getParent());
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());

        System.out.println(file.exists());
        file.createNewFile();
        System.out.println(file.exists());

        System.out.println("===================");
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());


        File file1 = new File("test2.txt");
        file1.createNewFile();
        System.out.println("file1 is exists: " + file1.exists());
        System.out.println("deldete the file1");
        Thread.sleep(2000);
        file1.delete();
        System.out.println("file1 is exists: " + file1.exists());


        File file2 = new File("test3.txt");
        file2.createNewFile();
        System.out.println("file1 is exists: " + file1.exists());
        System.out.println("deldete the file1");
        file2.deleteOnExit();
        System.out.println("file1 is exists: " + file1.exists());
        Thread.sleep(5000);

    }
}
