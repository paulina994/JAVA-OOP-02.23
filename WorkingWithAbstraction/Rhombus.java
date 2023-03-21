package WorkingWithAbstraction.LAB.WorkingWithAbstraction;

import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        //горна част
        //бр редове == n - 1
        printTopPart(n);
        //средната част -> 1 ред -> n = бр. звезди
        printMiddlePart(n);

        //долна част
        printBottomPart(n);


    }

    private static void printBottomPart(int n) {
        for (int row = n - 1; row >= 1; row--) {
            printRow(n, row);
        }
    }

    private static void printMiddlePart(int n) {
        for (int star = 1; star <= n; star++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printTopPart(int n) {
        for (int row = 1; row <= n - 1; row++) {
            printRow(n, row);
        }
    }

    private static void printRow(int n, int row) {
        //всеки ред -> {брой интервали = n - row}{бр.звезди = row}
        //n = 3
        //1 ред -> 2 инт + 1 зв
        //2 ред -> 1 ин + 2 зв
        for (int space = 1; space <= n - row; space++) {
            System.out.print(" ");
        }

        printMiddlePart(row);
    }

}

