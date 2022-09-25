package file;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-24
 * Time: 22:43
 */
public class Demo13 {

    public static void main(String[] args) throws IOException {
        // 遍历目录, 看某个输入的词是否在文件名或者文件内容中存在.
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter the directory you want to inquire: ");
        String rootPath = scanner.next();
        File rootFile = new File(rootPath);
        if (!rootFile.isDirectory()){
            System.out.println("the directory you enter is not exist");
            return;
        }
        System.out.println("please enter the content you want to inquire: ");
        String content = scanner.next();

        inquire(rootFile, content);
    }

    private static void inquire(File rootFile, String content) throws IOException {
        File[] files = rootFile.listFiles();

        if (files == null){
            System.out.println("the content in the directort is empty");
            return;
        }

        for (File f : files) {
            if (f.isDirectory()){
                inquire(f, content);
            }else {
                deepInquire(f, content);
            }
        }
    }

    private static void deepInquire(File f, String content) throws IOException {
        if (f.getName().contains(content)){
            System.out.println("the file'name contains the name of your enter");
        } else {
            try (InputStream inputStream = new FileInputStream(f)){
                StringBuilder stringBuilder = new StringBuilder();
                Scanner scanner = new Scanner(inputStream);
                while (scanner.hasNextLine()){
                    stringBuilder.append(scanner.nextLine());
                }

                if (stringBuilder.indexOf(content) >= 0) {
                    System.out.println("you have found the file'name: " + f.getCanonicalPath());
                    return;
                }
            }
        }
    }
}
