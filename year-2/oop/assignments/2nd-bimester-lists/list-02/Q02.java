public class Q02 {
    public static void main(String[] args) {
        Boolean[][] matrix = new Boolean[20][10];

        // Complexidade de tempo O(n²)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i % 2 == 0;
                System.out.println("(" + i + "," + j + ")" + " = " + matrix[i][j]);
            }
        }
    }
}