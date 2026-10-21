import java.util.Scanner;

public class NumberTools {
    public static int sumInts (String line){
        Scanner scanner = new Scanner(line);
        int n = 0;
        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                n += scanner.nextInt();
            }
            else{
                scanner.next();
            }
        }
        scanner.close ();
        return n;
    }

    public static String stats (String line){
        Scanner scanner = new Scanner (line);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;
        int sum = 0;
        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                count++;
                int read = scanner.nextInt();
                if (read < min) min = read;
                if (read > max) max = read;
                sum += read;
            }
            else{
                scanner.next ();
            }
        }

        scanner.close();
        if (count == 0){
            return "count=0";
        }
        else{
            return "count="+count+" min="+min+" max="+max+" avg="+((float)sum/count);
        }
    }

    public static String bases (int n){
        String binary = Integer.toBinaryString(n);
        String hex = Integer.toHexString(n);
        String oct = Integer.toOctalString(n);

        return n + " = 0b" + binary + " = 0x" + hex + " = 0o" + oct;
    }

    public static int percent(int part, int total){
        return Math.round((float)part/total*100);
    }

    public static boolean sameValue (Integer a, Integer b){
        return a.equals(b);
    }

    public static void main(String[] args) throws Exception {
        IO.println("sumInts = " + sumInts("10 abc 30 4.5 -2"));
        IO.println("stats = " + stats("10 20 x 30"));
        IO.println("stats = " + stats("no numbers here"));
        IO.println("bases = " + bases(255));
        IO.println("percent = " + percent(1, 3) + " " + percent(2, 3));
        Integer x = 1000, y = 1000;
        IO.println("sameValue = " + sameValue(x, y) + ", but x == y is " + (x == y));
    }
}
