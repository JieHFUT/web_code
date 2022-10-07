package file;

import java.io.File;

public class Demo4 {
    // 创建目录
    public static void main(String[] args) {
        File file = new File("test/aa/1");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println("=========================");
        // file.mkdir();
        file.mkdirs();
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
    }
}
