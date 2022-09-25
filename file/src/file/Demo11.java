package file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-24
 * Time: 21:39
 */
public class Demo11 {
    // 实现递归遍历一个文件，然后询问其是不是要删除
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the path to scan: ");
        String rootPath = scanner.next();

        File root = new File(rootPath);
        if (!root.exists()){
            System.out.println("the path you enter is not exist!");
            return;
        }

        System.out.println("please enter the file's name that you want to delete");
        String toDelete = scanner.next();

        scanDir(root, toDelete);

    }

    private static void scanDir(File root, String toDelete) {
        // 加一个日志用来观察当前递归的过程
        try {
            System.out.println(root.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        File[] files = root.listFiles();
        if (files == null){
            // 空的目录
            return;
        }
        for (File f : files) {
            if (f.isDirectory()){
                scanDir(f, toDelete);
            }else{
                tryDelete(f, toDelete);
            }
        }


    }

    private static void tryDelete(File f, String toDelete) {
        // 这是一个文件，是不是要查找地文件
        if (f.getName().contains(toDelete)){
            try {
                System.out.println("Please confirm if you want to delete the file(Y/N):> " + f.getCanonicalPath());
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                if (choice.equals("N")){
                    return;
                }else {
                    f.delete();
                    System.out.println("OK, the file was deleted");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
