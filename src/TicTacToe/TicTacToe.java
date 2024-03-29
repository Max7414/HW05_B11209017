package TicTacToe;

    class TicTacToe {
        private int xAxis, yAxis = 0;
        private int gameArray[][] = {{3,3,3},
                                     {3,3,3},
                                     {3,3,3}
        };
        public int getxAxis() {
            return xAxis;
        }

        public void setxAxis(int xAxis) {
            this.xAxis = xAxis;
        }

        public int getyAxis() {
            return yAxis;
        }

        public void setyAxis(int yAxis) {
            this.yAxis = yAxis;
        }

        public void setGameArray(int playerTurns) {
            gameArray[getyAxis()][getyAxis()] = playerTurns;
        }

        public String checkWinner() {
            for (int i = 0; i < 3; i++) {
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

            // 檢查平局
            boolean isDraw = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (gameArray[i][j] == -1) {
                        isDraw = false;
                        break;
                    }
                }
            }
            if (isDraw)
                return "平局";

            // 無人獲勝
            return "無人獲勝";
        }



        public void showGame()
        {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (gameArray[i][j] == 0) {
                        System.out.print("O");
                    } else if (gameArray[i][j] == 1) {
                        System.out.print("X");
                    }
                    if (j < 2) {
                        System.out.print("|");
                    }
                }
                System.out.println();
                if (i < 2) {
                    System.out.println("-----");
                }
            }
        }
    }
