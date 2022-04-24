class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
           if (matrix == null) {
            throw new IllegalArgumentException("Input is invalid");
        }

        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int dir = 0;

        while (top <= bottom && left <= right) {
            switch (dir) {
                case 0: // Right
                    for (int i = left; i <= right; i++) {
                        result.add(matrix[top][i]);
                    }
                    top++;
                    break;
                case 1: // Down
                    for (int i = top; i <= bottom; i++) {
                        result.add(matrix[i][right]);
                    }
                    right--;
                    break;
                case 2: // Left
                    for (int i = right; i >= left; i--) {
                        result.add(matrix[bottom][i]);
                    }
                    bottom--;
                    break;
                case 3: // Top
                    for (int i = bottom; i >= top; i--) {
                        result.add(matrix[i][left]);
                    }
                    left++;
            }
            dir = (dir + 1) % 4;
        }

        return result;
    }
}
//m*n