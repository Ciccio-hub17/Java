import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        IO.println(Arrays.deepToString(pascal(5)));
        IO.println(Arrays.deepToString(transpose(new int[][]{{1, 2, 3}, {4, 5, 6}})));
        double[][] grid = {{1, 2}, {3, 4, 5}};
        swapRows(grid, 0, 1);
        IO.println(Arrays.deepToString(grid));
        IO.println(average(1, 2, 3, 4) + " " + average(new double[]{2, 4}) + " " + average());
        IO.println(max(4) + " " + max(9, 3, 15, 5));
        int[] merged = concatSorted(new int[]{7, 2, 5}, new int[]{1, 8, 5});
        IO.println(Arrays.toString(merged));
        IO.println(Arrays.binarySearch(merged, 7));
        int[] copy = Arrays.copyOf(merged, merged.length);
        IO.println((copy == merged) + " " + Arrays.equals(copy, merged));
        int[] filled = new int[4];
        Arrays.fill(filled, -1);
        IO.println(Arrays.toString(filled));
    }

    public static int[][] pascal (int n){
        int[][] v = new int[n][];
        for (int i = 0; i < n; i++){
            v[i] = new int[i+1];
            for (int j = 0; j < i + 1; j++){
                if (j == 0 || j == i){
                    v[i][j] = 1;
                }
                else{
                    v[i][j] = v[i-1][j-1] + v[i-1][j];
                }
            }
        }
        return v;
    }

    public static int[][] transpose (int[][] m){
        int temp;
        for (int i = 0; i < m.length; i++){
            for (int j = i+1; j < m.length; j++){
                temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }
        return m;
    }

    public static void swapRows (double[][] m, int i, int j){
        double[] temp = m[i];
        m[i] = m[j];
        m[j] = temp;
    }

    public static double average (double... values ){
        if (values.length == 0){
            return Double.NaN;
        }
        int sum = 0;
        for (int i = 0; i < values.length; i++){
            sum += values[i];
        }
        return (double)sum/values.length;
    }

    public static int max (int first, int... others){
        if (others.length == 0){
            return first;
        }

        int max = first;
        for (int i = 0;i < others.length; i++){
            if (others[i] > max ){
                max = others[i];
            }
        }
        return max;
    }

    public static int [] concatSorted (int [] a, int [] b){
        int [] result = Arrays.copyOf(a, a.length + b.length);
        for (int i = 0;i < b.length; i++){
            result[i+a.length] = b[i];
        }

        Arrays.sort(result);

        return result;
    }
}
