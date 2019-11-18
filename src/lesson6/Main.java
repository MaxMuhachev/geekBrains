package lesson6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

//    1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
//    2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
//    3. Написать программу, которая проверяет присутствует ли указанное пользователем слово (или словосочетание, или предложение) в файле. (Работаем только с латиницей)
//    4. ** Написать метод, проверяющий, есть ли указанное слово в файлах папки

    private static StringBuilder word = new StringBuilder("");
    private static String nowPath;
    private static int i = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file = new File("src/lesson6");
        nowPath = file.getAbsolutePath() + "/";
        String fileName1 = "1.txt";
        readFile( fileName1, "2.txt");
        printFile(fileName1);
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

     private static void readFile(String fileName1, String fileName2){
        readFile(fileName1);
         try {
             FileOutputStream fout = new FileOutputStream(nowPath + fileName1);

             fout.write((word.toString() + "\n\r" + readFile(fileName2)).getBytes());
         }
         catch(IOException ex){
             System.out.println(ex.getMessage());
         }
         System.out.println();
    }

    private static String readFile(String fileName1) {
        word.setLength(0);
        try(FileInputStream file = new FileInputStream(nowPath + fileName1))
        {
            int i = -1;
            while((i = file.read()) != -1){
                word.append((char)i);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return word.toString();
    }


    private static void printFile(String fileName1) {
        System.out.println("Результат файла " + fileName1 + ">>");
        try(FileInputStream file = new FileInputStream(nowPath + fileName1))
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

     private static boolean checkWordForFile(String fileName, String findString){
         try(FileInputStream file = new FileInputStream(fileName))
         {
             i = -1;
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
