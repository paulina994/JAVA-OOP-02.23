package WorkingWithAbstraction.EX.WorkingWithAbstraction.Cardsuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    /*     System.out.println("Card Suits:");
         for(CardSuit cardSuit : CardSuit.values()){
             System.out.printf("Ordinal value: %d; Name value: %s%n",cardSuit.ordinal(),cardSuit.name());
      */
        Scanner scanner = new Scanner(System.in);
        WorkingWithAbstraction.EX.WorkingWithAbstraction.CardRank.Main.CardRank cardRank = WorkingWithAbstraction.EX.WorkingWithAbstraction.CardRank.Main.CardRank.valueOf(scanner.nextLine());
        WorkingWithAbstraction.EX.WorkingWithAbstraction.CardRank.Main.CardRank cardSuit = WorkingWithAbstraction.EX.WorkingWithAbstraction.CardRank.Main.CardRank.valueOf(scanner.nextLine());

        int cardPower = cardRank.getPower() + cardSuit.getPower();
        System.out.printf("Card name: %s of %s; Card power: %d", cardRank, cardSuit, cardPower);
    }
}

