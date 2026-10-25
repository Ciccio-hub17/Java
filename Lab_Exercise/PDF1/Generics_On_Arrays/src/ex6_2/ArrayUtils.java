package ex6_2;

import java.lang.Comparable;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.Arrays;

public class ArrayUtils {

    private ArrayUtils(){ }

    public static <T> int indexOf (T[] a, T x){
        for (int i = 0; i < a.length; i++){
            if (a[i].equals(x)){
                return i;
            }
        }

        return -1;
    }

    public static <T> T remove (T[] a, T el){
        int i = ArrayUtils.indexOf (a, el);

        if (i == -1){
            return null;
        }

        T temp = a[i];
        a[i] = null;
        return temp;
    }

    public static <T> void swap (T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T extends Comparable<? super T>> T max(T[] a){
        if (a.length == 0){
            return null;
        }

        T max = null;
        for (int i = 0; i < a.length; i++){
            if (a[i] != null){
                if (max == null){
                    max = a[i];
                }
                else if (max.compareTo(a[i]) < 0){
                    max = a[i];
                }
            }
        }

        return max;
    }

    public static <T> T max (T[] a, Comparator<? super T> order){
        if (a.length == 0){
            return null;
        }

        T max = null;
        for (int i = 0; i < a.length; i++){
            if (a[i] != null){
                if (max == null){
                    max = a[i];
                }
                else if (order.compare (max, a[i]) < 0){
                    max = a[i];
                }
            }
        }

        return max;
    }

    public static <T> T[] append (T[] a, T x){
        T[] newVet = Arrays.copyOf(a, a.length+1);
        newVet[newVet.length-1] = x;
        return newVet;
    }

    public static <T> int count (T[] a, Predicate<?super T> cond){
        int count = 0;
        for (int i = 0; i < a.length; i++){
            if (cond.test(a[i])){
                count++;
            }
        }
        return count;
    }

    public static <T> T[] filter (T[] a, Predicate<? super T> cond){
        T[] new_v = Arrays.copyOf (a, a.length);
        int j = 0;
        for (int i = 0; i < a.length; i++){
            if (cond.test(a[i])){
                new_v[j++] = a[i];
            }
        }

        return Arrays.copyOf (new_v, j);
    }
}
