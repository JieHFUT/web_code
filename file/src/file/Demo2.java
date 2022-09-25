package file;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-24
 * Time: 16:04
 */
public class Demo2 {

    public static void main(String[] args) {
        // 创建目录
        File file = new File("111");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println("==================");

        file.mkdir();
        System.out.println(file.exists());
        file.delete();

        File file1 = new File("111/222/333");
        file1.mkdirs();


    }
}
