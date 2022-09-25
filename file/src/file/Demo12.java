package file;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-24
 * Time: 22:24
 */
public class Demo12 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("please enter the path that you want to copy: ");

        String srcPath = scanner.next();
        File srcFile = new File(srcPath);
        if (!srcFile.exists()){
            System.out.println("the path you enter is not exist!");
            return;
        }else if (!srcFile.isFile()) {
            System.out.println("the file you want to copy is not commmon file!");
            return;
        }
        System.out.println("please enter the path to the file you want to copy to: ");
        String destPath = scanner.next();
        File destFile = new File(destPath);
        if (destFile.exists()){
            System.out.println("the target you want to cover was exist!");
            return;
        }

        try (InputStream inputStream = new FileInputStream(srcFile)){
            try (OutputStream outputStream = new FileOutputStream(destFile)){
                byte[] buf = new byte[1024];
                while (true) {
                    int len = inputStream.read(buf);
                    System.out.println("len = " + len);
                    if (len == -1){
                        break;
                    }
                    outputStream.write(buf,0,len);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("the mission is over");

    }

}
