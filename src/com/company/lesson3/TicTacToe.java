package com.company.lesson3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static void initFields() {
        System.out.print("Введите размер поля через пробел >>  ");
        fieldSizeX = SCANNER.nextInt();
        fieldSizeY = SCANNER.nextInt();
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void showFields() {
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print("|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("__________");
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.printf("Введите координаты X и Y (от 1 до %d) через пробел>> ", fieldSizeX);
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_AI;
    }

    private static boolean checkWin(char c) {
        Boolean foundWin = true, foundWin2 = true, foundWin3 = true, foundWin4 = true;
        int k = 0;
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] != c)
                    foundWin = false;
                if (field[j][i] != c)
                    foundWin2 = false;
                if (field[j][j] != c) {
                    foundWin3 = false;
                }
            }
            if (field[i][fieldSizeY - k++ - 1] != c)
                foundWin4 = false;
            if (foundWin || foundWin2 || foundWin3 || (i == fieldSizeY - 1 && foundWin4))
                return true;
            foundWin = true;
        }
        return false;
    }

    private static boolean cbeckDraw() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initFields();
        showFields();
        while (true) {
            humanTurn();
            showFields();
            if (checkWin(DOT_HUMAN)) {
                System.out.println("Human Win!");
                break;
            }
            if (cbeckDraw()) {
                System.out.println("Draw!");
                break;
            }

            aiTurn();
            showFields();
            if (checkWin(DOT_AI)) {
                System.out.println("Ai Win!");
                break;
            }
            if (cbeckDraw()) {
                System.out.println("Draw!");
                break;
            }
        }
    }
}
