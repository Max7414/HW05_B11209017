package TicTacToe;

    class TicTacToe {
        private int xAxis, yAxis = 0; //x軸y軸
        private final int[][] gameArray = {{3,3,3},  //初始遊戲陣列 3代表空 0表示O 1 表示X
                                     {3,3,3},
                                     {3,3,3}
        };
        public int getXaxis() {//getter
            return xAxis - 1;
        }

        public void setXaxis(int xAxis) {
            this.xAxis = xAxis;
        }//setter

        public int getYaxis() {
            return yAxis;
        }//getter

        public void setYaxis(int yAxis) {//setter
            this.yAxis = yAxis - 1;
        }

        public void setGameArray(int playerTurns) { //將陣列的值調整為玩家的值
            gameArray[getXaxis()][getYaxis()] = playerTurns;
        }
        //將遊戲陣列的值設定為0或1
        public String checkWinner() {
            for (int i = 0; i < 3; i++) { //檢查行
                if (gameArray[i][0] == gameArray[i][1] && gameArray[i][1] == gameArray[i][2]) {
                    if (gameArray[i][0] == 0) {
                        return "「玩家1」勝利！！";
                    }
                    else if (gameArray[i][0] == 1)
                        return "「玩家2」勝利！!";
                }
            }

            // 檢查列
            for (int i = 0; i < 3; i++) {
                if (gameArray[0][i] == gameArray[1][i] && gameArray[1][i] == gameArray[2][i]) {
                    if (gameArray[0][i] == 0)
                        return "「玩家1」勝利！！";
                    else if (gameArray[0][i] == 1)
                        return "「玩家2」勝利！!";
                }
            }

            // 檢查對角線
            if ((gameArray[0][0] == gameArray[1][1] && gameArray[1][1] == gameArray[2][2]) ||
                    (gameArray[0][2] == gameArray[1][1] && gameArray[1][1] == gameArray[2][0])) {
                if (gameArray[1][1] == 0)
                    return "「玩家1」勝利！！";
                else if (gameArray[1][1] == 1)
                    return "「玩家2」勝利！!";
            }

            // 檢查平局 如果所有值都是非3的話 已填滿遊戲
            boolean isDraw = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (gameArray[i][j] == 3) {
                        isDraw = false;
                        break;
                    }
                }
            }
            if (isDraw)
                return "平局！";

            return "";
        }

        public int getElement(int row, int column) {
            // 檢查給定的行和列索引是否在gameArray的範圍內
            if (row >= 0 && row < gameArray.length && column >= 0 && column < gameArray[0].length) {
                return gameArray[row][column];  // 如果在範圍內，則返回指定行和列的元素
            } else {
                throw new IllegalArgumentException("Invalid row or column index");//照理不會出現的情況
            }
        }

        public void showGame()
        {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (gameArray[i][j] == 0) {   // 如果值為0，則打印“O”（代表玩家O）
                        System.out.print("O");
                    } else if (gameArray[i][j] == 1) { // 如果值為1，則打印“X”（代表玩家X）
                        System.out.print("X");
                    } else { // 如果值既不是0也不是1 (=3)，則打印一個空格（空單元格）
                        System.out.print(" ");
                    }
                    if (j < 2) {  // 如果不是最後一列，則在列之間打印分隔符
                        System.out.print(" | ");
                    }
                }
                System.out.println();

                if (i < 2) { // 如果不是最後一行，則在行之間打印分隔符
                    System.out.println("-- -- --");
                }
            }
        }
    }
