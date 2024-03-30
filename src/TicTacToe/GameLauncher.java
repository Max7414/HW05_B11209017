package TicTacToe;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

            int inputX;

            String regex = "^[1-3]$";
            Pattern pattern = Pattern.compile(regex);

            inputX = scanner.nextInt();
            Matcher matcher = pattern.matcher(Integer.toString(inputX));

            if(matcher.matches())
                xAxis = inputX;
            else {
                System.out.println("請輸入 1～3 的數字！");
                continue;
            }


            System.out.println("請輸入列數(1~3)：");

            int inputY;
            inputY = scanner.nextInt();
            Matcher matcherY = pattern.matcher(Integer.toString(inputY));

            if (matcherY.matches())
                yAxis = inputY;
            else {
                System.out.println("請輸入 1～3 的數字！");
                continue;
            }

            if (ticTacToe.getElement(xAxis-1,yAxis-1) == 1 || ticTacToe.getElement(xAxis-1,yAxis-1) == 0) {
                System.out.println("該座標已經有值了");
                continue;
            } else {
                ticTacToe.setXaxis(xAxis);
                ticTacToe.setYaxis(yAxis);
            }

            ticTacToe.setGameArray(playerTurns);
            playerTurns++;
            ticTacToe.showGame();

            result = ticTacToe.checkWinner();
            System.out.println(result);

            if (result.contains("勝利")) { //完成
                System.exit(0);
            }

        }
    }
}