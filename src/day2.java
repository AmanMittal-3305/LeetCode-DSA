import java.util.*;

public class day2 {

    //Problem No 01 => 54. Spiral Matrix
    //https://leetcode.com/problems/spiral-matrix/
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int sr = 0;
        int er = matrix.length -1;
        int sc = 0;
        int ec = matrix[0].length-1;
        while(sr <= er && sc <= ec){
            //top
            for(int j = sc ; j<= ec; j++){
                result.add(matrix[sr][j]);
            }
            //right
            for(int j = sr+1 ; j<= er; j++){
                result.add(matrix[j][ec]);
            }
            //bottom
            for(int j = ec-1 ; j>= sc; j--){
                if(sr == er){
                    break;
                }
                result.add(matrix[er][j]);
            }
            //left
            for(int j = er-1 ; j>= sr+1; j--){
                if(sc == ec){
                    break;
                }
                result.add(matrix[j][sc]);
            }
            sr++;
            sc++;
            er--;
            ec--;
        }
        return result;
    }


    //Problem No 02 => 59. Spiral Matrix II
    //https://leetcode.com/problems/spiral-matrix-ii/
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int sr = 0;
        int er = matrix.length - 1;
        int sc = 0;
        int ec = matrix[0].length - 1;
        int count = 1;

        while (sr <= er && sc <= ec) {
            // Top
            for (int j = sc; j <= ec; j++) {
                matrix[sr][j] = count;
                count++;
            }
            sr++;

            // Right
            for (int j = sr; j <= er; j++) {
                matrix[j][ec] = count;
                count++;
            }
            ec--;

            // Bottom
            if (sr <= er) {
                for (int j = ec; j >= sc; j--) {
                    matrix[er][j] = count;
                    count++;
                }
                er--;
            }

            // Left
            if (sc <= ec) {
                for (int j = er; j >= sr; j--) {
                    matrix[j][sc] = count;
                    count++;
                }
                sc++;
            }
        }
        return matrix;
    }


    //Probelem No. 03 => 796. Rotate String
    //https://leetcode.com/problems/rotate-string/
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int n = s.length();
        StringBuilder result = new StringBuilder(s);

        for (int i = 0; i < n; i++) {
            if (result.toString().equals(goal)) {
                return true;
            }
            result = new StringBuilder(result.substring(1) + result.charAt(0));
        }

        return false;
    }


    //Problem No 04 => 541. Reverse String II
    //https://leetcode.com/problems/reverse-string-ii/
    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i += 2 * k) {
            // Reverse the first k characters
            int start = i;
            int end = Math.min(i + k, n);
            StringBuilder reversed = new StringBuilder(s.substring(start, end)).reverse();
            result.append(reversed);

            // Append the remaining characters (up to 2k) as they are
            int remainingEnd = Math.min(i + 2 * k, n);
            result.append(s.substring(end, remainingEnd));
        }

        return result.toString();
    }
}
