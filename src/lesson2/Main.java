package com.company;

import java.util.Arrays;

public class Main {

    // HomeWork 2

    public static void main(String[] args) {
        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
        int[] mas = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        replaceNumbers(mas);
        System.out.println("1. Replace 0 to 1, 1 to 1: " + Arrays.toString(mas));

        //  2. Задать пустой целочисленный массив размером 8. Написать метод, который помощью цикла заполнит его значениями
        //  1 4 7 10 13 16 19 22;
        int[] mas2 = new int[8];
        fillMass(mas2);
        System.out.println("2. Fill massive 1 4 7 10 13 16 19 22: " + Arrays.toString(mas2));

        // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
        // написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
        int[] mas3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplicaton(mas3);
        System.out.println("3. If element < 6 ten *2 [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]: " + Arrays.toString(mas3));


        // 4. Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
        int[] mas4 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        maxMin(mas4);

        // 5. * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
        // заполнить его диагональные элементы единицами, используя цикл(ы);
        int[][] mas5 = new int[10][10];
        diagonal(mas5);
        System.out.println("5. Matr with replace diagonal to 1: ");
        for (int[] m : mas5) {
            System.out.println(Arrays.toString(m));
        }

        // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
        // checkBalance ([10, || 1, 2, 3, 4]) → true. Абстрактная граница показана символами ||, эти символы в массив не входят.
        int[] mas6 = {1, 1, 2, 2, 1, 3, 1, 1, 3, 3, 1, 1};
        System.out.println("6. Balance {1, 1, 2, 2, 1, 3, 1, 1, 3, 3, 1, 1}: " + checkBalance(mas6));

        // 7 *** Написать метод, которому на вход подаётся одномерный массив и число n
        // (может быть положительным, или отрицательным), при этом метод должен циклически сместить все элементы массива на n позиций.
        int[] mas7 = {1, 2, 3, 4, 5};
        System.out.println("7. Offset {1, 2, 3, 4, 5}: " + Arrays.toString(offset(mas7, -2)));
    }

    // 1.
    private static void replaceNumbers(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            mas[i] = mas[i] == 1 ? 0 : 1;
        }
    }

    // 2. Fill massive [1 4 7 10 13 16 19 22]
    private static void fillMass(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            switch (i) {
                case 0:
                    mas[i] = 1;
                    break;
                case 1:
                    mas[i] = 4;
                    break;
                case 2:
                    mas[i] = 7;
                    break;
                case 3:
                    mas[i] = 10;
                    break;
                case 4:
                    mas[i] = 13;
                    break;
                case 5:
                    mas[i] = 16;
                    break;
                case 6:
                    mas[i] = 19;
                    break;
                case 7:
                    mas[i] = 22;
                    break;
            }
        }
    }

    // 3. Multiplication elements if < 6. Massive [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    private static void multiplicaton(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            mas[i] = mas[i] < 6 ? mas[i]*2 : mas[i];
        }
    }

    // 4. Max and min element {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}
    private static void maxMin(int[] mas) {
        int max = mas[0], min = mas[0];
        for (int i = 1; i < mas.length; i++) {
            max = mas[i] > max ? mas[i] : max;
            min = mas[i] < min ? mas[i] : min;
        }
        System.out.print("4. Massive {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}   ");
        System.out.print("Max element: " + max + "   ");
        System.out.println("Min element: " + min);
    }

    // 5. Fill diagonals 1
    private static void diagonal(int[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (j == i) {
                    mas[i][j] = 1;
                }
                if (j == mas.length - 1) {
                    mas[i][mas.length - i - 1] = 1;
                }
            }
        }
    }

    // 6.
    private static boolean checkBalance(int[] mas) {
        int sumRight = 0, sumLeft = 0;
        for (int i = 0; i < mas.length - 1; i++) {
            sumLeft += mas[i];
            for (int j = i + 1; j < mas.length; j++) {
                sumRight += mas[i];
            }
            if (sumRight == sumLeft){
                return true;
            }
            sumRight = 0;
        }
        return false;
    }

    // 7.
    private static int[] offset(int[] mas, int offs) {
        int start = 0, j = 0;
        int[] newMas = new int[mas.length];
        if (offs > 0) {
            start = mas.length - offs;
        } else {
            start = - offs;
        }
        for (int i = start; i < mas.length; i++) {
            newMas[j++] = mas[i];
        }
        for (int i = 0; i < start; i++) {
            newMas[j++] = mas[i];
        }
        return newMas;
    }

    private static void swap(int[] mas, int i, int j) {
        int tmp = mas[i];
        mas[i] = mas[j];
        mas[j] = tmp;
    }
}