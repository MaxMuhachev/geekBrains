package lesson6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("src/lesson6");
        String nowPath = file.getAbsolutePath(), fileName1 = "/1.txt";
        readFile(nowPath, fileName1, "/2.txt");
        System.out.println();

        System.out.println("Введите слово (или словосочетание, или предложение), которое надо найти в файле>>  ");
        if (checkWordForFile(nowPath + fileName1, sc.nextLine())) {
            System.out.println("Введённая строка имеется в файле " + fileName1);
        } else {
            System.out.println("Введённой строки НЕТ в файле " + fileName1);
        }

        System.out.println("Введите слово, которое надо найти в файлах папки>>  ");
        if (checkDerictory(file, sc.nextLine())) {
            System.out.println("Введённая строка имеется в названиях файлов!");
        } else {
            System.out.println("Введённой строки НЕТ в названиях файлов!");
        }
    }

     private static void readFile(String path, String fileName1, String fileName2){
        List<String> files = Arrays.asList(path + fileName1, path + fileName2);
        for (String f : files) {
             try(FileInputStream file = new FileInputStream(f))
             {
                 int i = -1;
                 while((i = file.read()) != -1){

                     System.out.print((char)i);
                 }
             }
             catch(IOException ex){

                 System.out.println(ex.getMessage());
             }
             System.out.println();
         }
    }

     private static boolean checkWordForFile(String fileName, String findString){
         StringBuilder word = new StringBuilder("");
         try(FileInputStream file = new FileInputStream(fileName))
         {
             int i = -1;
             while((i = file.read()) != -1){
                if (i != 13 && i != 10){
                    word.append((char) i);
                } else {
                    if (word.toString().lastIndexOf(findString) != -1) {
                        return true;
                    }
                    word.setLength(0);
                }
             }
         }
         catch(IOException ex){

             System.out.println(ex.getMessage());
         }
         return  false;
    }

     private static boolean checkDerictory(File file, String findString) {
         for (String fileName : file.list()) {
            if (fileName.lastIndexOf(findString) != -1) {
                return true;
            }
         }
         return false;
     }
}
