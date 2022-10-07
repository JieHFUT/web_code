package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Demo15 {
    // 遍历目录, 看某个输入的词是否在文件名或者文件内容中存在.
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要搜索的目录:");
        String rootPath = scanner.next();
        File rootFile = new File(rootPath);
        if (!rootFile.exists()) {
            System.out.println("要扫描的目录不存在!");
            return;
        }
        if (!rootFile.isDirectory()) {
            System.out.println("要扫描的路径不是目录!");
            return;
        }
        System.out.println("请输入要搜索的词:");
        String toFind = scanner.next();

        // 递归遍历目录
        scanDir(rootFile, toFind);
    }

    private static void scanDir(File rootFile, String toFind) throws IOException {
        File[] files = rootFile.listFiles();
        if (files == null) {
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                scanDir(f, toFind);
            } else {
                tryFindInFile(f, toFind);
            }
        }
    }

    // 判定 toFind 是否是文件名 或者 是文件内容的一部分
    private static void tryFindInFile(File f, String toFind) throws IOException {
        // 是不是文件名的一部分
        if (f.getName().contains(toFind)) {
            System.out.println("找到文件名匹配的文件: " + f.getCanonicalPath());
            return;
        }
        // 是不是文件内容的一部分
        try (InputStream inputStream = new FileInputStream(f)) {
            // 把文件内容整个的都读出来.
            StringBuilder stringBuilder = new StringBuilder();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
            // 读取完毕了.
            if (stringBuilder.indexOf(toFind) >= 0) {
                System.out.println("找到文件内容匹配的文件: " + f.getCanonicalPath());
                return;
            }
        }
    }
}
