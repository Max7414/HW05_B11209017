package TicTacToe;

    class TicTacToe {
        private int xAxis, yAxis = 0;
        private int gameArray[][] = new int[3][3];
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

        public void showGame(int[][] gameArray)
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
