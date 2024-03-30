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

        public String checkWinner() {
            for (int i = 0; i < 3; i++) { //檢查行
                if (gameArray[i][0] == gameArray[i][1] && gameArray[i][1] == gameArray[i][2]) {
                    if (gameArray[i][0] == 0) {
                        return "「玩家1」勝利！！";
                    }
                    else if (gameArray[i][0] == 1)
                        return "玩家2」勝利！!";
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
                    return "玩家2」勝利！!";
            }

            // 檢查平局 如果所有值都是非3的話
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
                return "平局";

            return "";
        }

        public int getElement(int row, int column) {
            if (row >= 0 && row < gameArray.length && column >= 0 && column < gameArray[0].length) {
                return gameArray[row][column];
            } else {
                throw new IllegalArgumentException("Invalid row or column index");
            }
        }

        public void showGame()
        {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (gameArray[i][j] == 0) {
                        System.out.print("O");
                    } else if (gameArray[i][j] == 1) {
                        System.out.print("X");
                    } else {
                        System.out.print(" ");
                    }
                    if (j < 2) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();

                if (i < 2) {
                    System.out.println("-- -- --");
                }
            }
        }
    }
