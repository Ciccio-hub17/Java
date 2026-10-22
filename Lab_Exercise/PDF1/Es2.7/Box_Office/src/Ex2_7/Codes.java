package Ex2_7;

public class Codes {
    
    private Codes (){

    }

    public static String code (char prefix, int n){
        return String.format ("%c%04d", prefix, n);
    }

    public static boolean isValid (String code){
        if (code == null || code.length() != 5){
            return false;
        }
        char c = code.charAt(0);
        if (c < 'A' || c > 'Z'){
            return false;
        }
        for (int i = 1; i < code.length(); i++){
            c = code.charAt(i);
            if (c < '0' && c > '9'){
                return false;
            }
        }

        return true;
    }

    public static int number (String code){
        if (!isValid(code)){
            throw new IllegalArgumentException("Illegal code");
        }

        return Integer.parseInt(code.substring(1));

    }

}
