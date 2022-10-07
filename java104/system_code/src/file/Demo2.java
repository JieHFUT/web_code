package file;

import java.io.File;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        // 前面没写 ./ , 也相当于是 ./, ./ 可以省略~~
        File file = new File("helloworld.txt");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println("========================");
        // 创建文件
        file.createNewFile();
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
    }
}
