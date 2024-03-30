package TicTacToe;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameLauncher {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int playerTurns = 0;    //玩家代碼 0 表示O 1表示X
        int xAxis, yAxis;       //用於輸入的X Y軸變數
        String result;          //儲存遊戲結果變數
        TicTacToe ticTacToe = new TicTacToe(); //創造新ticTacToe物件


        while(true) {
            playerTurns %= 2; //玩家代碼在0-1之間

            if (playerTurns % 2 == 0) {
                System.out.println("[O的回合]"); //O,X切換
            }
            else {
                System.out.println("[X的回合]");
            }
            System.out.println("請輸入行數(1~3)：");

            int inputX;

            String regex = "^[1-3]$";
            Pattern pattern = Pattern.compile(regex);//正則表達 限制輸入為1-3

            inputX = scanner.nextInt();
            Matcher matcher = pattern.matcher(Integer.toString(inputX));

            if(matcher.matches())//檢查正則表達是否吻合
                xAxis = inputX;
            else {
                System.out.println("請輸入 1～3 的數字！");
                continue;
            }


            System.out.println("請輸入列數(1~3)：");

            int inputY;
            inputY = scanner.nextInt();
            Matcher matcherY = pattern.matcher(Integer.toString(inputY));//正則表達 限制輸入為1-3

            if (matcherY.matches())
                yAxis = inputY;//檢查正則表達是否吻合
            else {
                System.out.println("請輸入 1～3 的數字！");
                continue;
            }

            if (ticTacToe.getElement(xAxis-1,yAxis-1) == 1 || ticTacToe.getElement(xAxis-1,yAxis-1) == 0) {
                System.out.println("該座標已經有值了");//重複輸入判斷 如果array的值已經是0,1的話就禁止輸入
                continue;
            } else {
                ticTacToe.setXaxis(xAxis);
                ticTacToe.setYaxis(yAxis);
            }

            ticTacToe.setGameArray(playerTurns);//呼叫設定陣列函數 並傳遞是O的還是X的
            playerTurns++; //完成後切換玩家
            ticTacToe.showGame();//輸出井字遊戲的外觀

            result = ticTacToe.checkWinner();//遊戲結果字串
            System.out.println(result);

            if (result.contains("勝利")) { //遊戲結束時結束程式
                System.exit(0);
            } else if (result.contains("平局")) System.exit(0);

        }
    }
}