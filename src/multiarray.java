package multiarray;
import java.util.*;

// Each question is its own class. Compile: javac multiarray.java   Run: java multiarray.InputMatrix

// Program: Enter the Matrix of rows and columns entered by the user and print in matrix format
// file name should be InputMatrix.java
class InputMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and columns: ");
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] m = new int[r][c];
        System.out.println("Enter " + (r * c) + " elements:");
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) m[i][j] = sc.nextInt();
        System.out.println("Matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) System.out.print(m[i][j] + "\t");
            System.out.println();
        }
    }
}

// Program: Program to Add Two Matrices
// file name should be AddMatrices.java
class AddMatrices {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] b = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        int[][] s = new int[3][3];
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) s[i][j] = a[i][j] + b[i][j];
        for (int[] row : s) System.out.println(Arrays.toString(row));
    }
}

// Program: Program to Multiply Two Matrices
// file name should be MultiplyMatrices.java
class MultiplyMatrices {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};      // 2x3
        int[][] b = {{7, 8}, {9, 10}, {11, 12}}; // 3x2
        int[][] p = new int[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 3; k++) p[i][j] += a[i][k] * b[k][j];
        for (int[] row : p) System.out.println(Arrays.toString(row));
    }
}

// Program: Program to subtract the two matrices
// file name should be SubtractMatrices.java
class SubtractMatrices {
    public static void main(String[] args) {
        int[][] a = {{9, 8, 7}, {6, 5, 4}};
        int[][] b = {{1, 2, 3}, {4, 5, 6}};
        int[][] d = new int[2][3];
        for (int i = 0; i < 2; i++) for (int j = 0; j < 3; j++) d[i][j] = a[i][j] - b[i][j];
        for (int[] row : d) System.out.println(Arrays.toString(row));
    }
}

// Program: Program to determine whether two matrices are equal
// file name should be EqualMatrices.java
class EqualMatrices {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{1, 2}, {3, 4}};
        boolean equal = a.length == b.length;
        for (int i = 0; equal && i < a.length; i++) {
            if (a[i].length != b[i].length) { equal = false; break; }
            for (int j = 0; j < a[i].length; j++) if (a[i][j] != b[i][j]) { equal = false; break; }
        }
        System.out.println("Matrices are " + (equal ? "equal" : "not equal"));
    }
}

// Program: Program to display the lower triangular matrix
// file name should be LowerTriangular.java
class LowerTriangular {
    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) System.out.print((j <= i ? m[i][j] : 0) + " ");
            System.out.println();
        }
    }
}

// Program: Program to display the upper triangular matrix
// file name should be UpperTriangular.java
class UpperTriangular {
    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) System.out.print((j >= i ? m[i][j] : 0) + " ");
            System.out.println();
        }
    }
}

// Program: Program to find the frequency of odd & even numbers in the given matrix
// file name should be OddEvenFrequency.java
class OddEvenFrequency {
    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int even = 0, odd = 0;
        for (int[] row : m) for (int x : row) if (x % 2 == 0) even++; else odd++;
        System.out.println("Even numbers = " + even + ", Odd numbers = " + odd);
    }
}

// Program: Program to find the sum of each row and each column of a matrix
// file name should be RowColumnSum.java
class RowColumnSum {
    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < m.length; i++) {
            int rs = 0;
            for (int j = 0; j < m[i].length; j++) rs += m[i][j];
            System.out.println("Sum of row " + (i + 1) + " = " + rs);
        }
        for (int j = 0; j < m[0].length; j++) {
            int cs = 0;
            for (int i = 0; i < m.length; i++) cs += m[i][j];
            System.out.println("Sum of column " + (j + 1) + " = " + cs);
        }
    }
}

// Program: Program to find the transpose of a given matrix
// file name should be TransposeOfMatrix.java
class TransposeOfMatrix {
    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}};
        int[][] t = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) for (int j = 0; j < m[0].length; j++) t[j][i] = m[i][j];
        for (int[] row : t) System.out.println(Arrays.toString(row));
    }
}

// Program: Program to determine whether a given matrix is an identity matrix
// file name should be IdentityMatrix.java
class IdentityMatrix {
    public static void main(String[] args) {
        int[][] m = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        boolean identity = m.length == m[0].length;
        for (int i = 0; identity && i < m.length; i++)
            for (int j = 0; j < m[i].length; j++)
                if ((i == j && m[i][j] != 1) || (i != j && m[i][j] != 0)) { identity = false; break; }
        System.out.println("Matrix is " + (identity ? "" : "not ") + "an identity matrix");
    }
}

// Program: Program to Transpose matrix (in place, for a square matrix)
// file name should be TransposeInPlace.java
class TransposeInPlace {
    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < m.length; i++)
            for (int j = i + 1; j < m.length; j++) { int t = m[i][j]; m[i][j] = m[j][i]; m[j][i] = t; }
        for (int[] row : m) System.out.println(Arrays.toString(row));
    }
}

// Program: Program to determine whether a given matrix is a sparse matrix
// file name should be SparseMatrix.java
class SparseMatrix {
    public static void main(String[] args) {
        int[][] m = {{1, 0, 3}, {0, 0, 4}, {6, 0, 0}};
        int zeros = 0, total = m.length * m[0].length;
        for (int[] row : m) for (int x : row) if (x == 0) zeros++;
        // a matrix is sparse when more than half of its elements are zero
        System.out.println("Zeros = " + zeros + " of " + total);
        System.out.println("Matrix is " + (zeros > total / 2 ? "" : "not ") + "a sparse matrix");
    }
}
