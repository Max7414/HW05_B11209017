package TicTacToe;

import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int playerTurns = 0;
        int xAxis, yAxis;
        String result;
        TicTacToe ticTacToe = new TicTacToe();


        while(true) {
            playerTurns %= 2;

            if (playerTurns % 2 == 0) {
                System.out.println("[O的回合]");
            }
            else {
                System.out.println("[X的回合]");
            }
            System.out.println("請輸入行數(1~3)：");
            xAxis = scanner.nextInt();
            System.out.println("請輸入列數(1~3)：");
            yAxis = scanner.nextInt();

            if (ticTacToe.getXaxis() == xAxis-1 &&
                    ticTacToe.getYaxis() == yAxis-1) {
                System.out.println("該座標已經有值了");
            } else {
                ticTacToe.setXaxis(xAxis);
                ticTacToe.setYaxis(yAxis);
            }

            ticTacToe.setGameArray(playerTurns);
            playerTurns++;
            ticTacToe.showGame();

            result = ticTacToe.checkWinner();

            if (result.contains("獲勝")) {
                System.exit(0);
            }

        }
    }
}