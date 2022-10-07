package file;

import java.io.File;

public class Demo5 {
    // 文件重命名
    public static void main(String[] args) {
        File file1 = new File("./test1.txt");
        File file2 = new File("./test2.txt");
        file1.renameTo(file2);
    }
}
