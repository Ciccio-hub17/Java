package Ex2_7;

public class AuditLog {

    private static AuditLog instance;

    private int count = 0;
    private String last = null;

    private AuditLog (){ 
        IO.println ("Audition class created");
    }

    public static AuditLog getInstance (){
        if (instance == null){
            instance = new AuditLog();
        }

        return instance;
    }

    static {
        IO.println ("Audition class loaded");
    }

    public void record (String message){
        count++;
        last = message;
    }

    public int count (){
        return count;
    }

    public String last (){
        return last;
    }

}
