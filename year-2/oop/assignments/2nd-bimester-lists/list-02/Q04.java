public class Q04 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[i + 1];

            for (int j = 0; j < matrix[i].length; j++) matrix[i][j] = i;
        }
    }
}