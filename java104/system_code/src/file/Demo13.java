package file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Demo13 {
    // 实现一个递归遍历文件, 并询问删除.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的路径: ");
        String rootPath = scanner.next();
        File root = new File(rootPath);
        if (!root.exists()) {
            System.out.println("您输入的路径不存在, 无法进行扫描!");
            return;
        }
        System.out.println("请输入要删除的文件名(或者一部分): ");
        String toDelete = scanner.next();

        // 准备进行递归, 通过递归的方式, 来找到所有的文件.
        // 找到所有的文件之后, 再尝试进行删除
        scanDir(root, toDelete);
    }

    public static void scanDir(File rootDir, String toDelete) {
        // 加上个日志, 看一下这里当前递归的过程.
        try {
            System.out.println(rootDir.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        File[] files = rootDir.listFiles();
        if (files == null) {
            // 空目录, 直接返回
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                // 是目录, 就进行递归
                scanDir(f, toDelete);
            } else {
                // 普通文件
                tryDelete(f, toDelete);
            }
        }
    }

    public static void tryDelete(File f, String toDelete) {
        // 看看当前文件名是否包含了 toDelete, 如果包含, 就删除, 否则就啥都不干.
        if (f.getName().contains(toDelete)) {
            try {
                System.out.println("是否要删除文件(Y/n): " + f.getCanonicalPath());
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                if (choice.equals("Y")) {
                    f.delete();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
