class rotate90 {
    public void rotate(int[][] matrix) {
        int l = matrix.length; 
        
        for(int i = 0; i < l/2; i++) {
            for(int j = i; j < l - i - 1; j++) {
                rotate(matrix, i, j, l - 1);
            }
        }
    }
    
    public void rotate(int[][] matrix, int i, int j, int l) {        
        int one = matrix[i][j];
        int two = matrix[j][l-i];
        int three = matrix[l-i][l-j];
        int four = matrix[l-j][i];
        
        matrix[i][j] = four;
        matrix[j][l-i] = one;
        matrix[l-i][l-j] = two;
        matrix[l-j][i] = three;
    }
}
