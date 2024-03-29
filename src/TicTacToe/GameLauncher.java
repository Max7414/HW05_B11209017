package TicTacToe;

import java.util.Scanner;

public class GameLauncher {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int playerTurns = 0;
        int xAxis, yAxis;
        TicTacToe ticTacToe = new TicTacToe();

        boolean ifGameEnd = false;

        while(!ifGameEnd) {
            playerTurns %= 2;

            if (playerTurns % 2 == 0) {
                System.out.println("[O的回合]");
            }
            else {
                System.out.println("[X的回合]");
            }
            System.out.println("請輸入行數(1~3)：");
            xAxis = scanner.nextInt();
            System.out.println("請輸入行數(1~3)：");
            yAxis = scanner.nextInt();

            if (ticTacToe.getxAxis() == xAxis && ticTacToe.getyAxis() == yAxis)
                System.out.println("該座標已經有值了");
            else {
                ticTacToe.setxAxis(xAxis);
                ticTacToe.setyAxis(yAxis);
            }
            
            ticTacToe.setGameArray(playerTurns);
            playerTurns++;
        }
    }
}