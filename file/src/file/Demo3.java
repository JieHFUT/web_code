package file;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-24
 * Time: 16:10
 */
public class Demo3 {

    // 文件重命名
    public static void main(String[] args) throws InterruptedException {

        File file = new File("test0.txt");

        File file1 = new File("test1.txt");

        file1.renameTo(file);

        Thread.sleep(3000);

        file.renameTo(file1);




    }
}
