package arrays;

import java.util.Arrays;

public class TicTac {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for(int j=0;j<3;j++){
                board[i][j] = '-';
            }

        }
        board[0][0] = '1';
        board[1][0] = '1';
        board[2][0] = '1';

        System.out.println(Arrays.deepToString(board));

    }
}
