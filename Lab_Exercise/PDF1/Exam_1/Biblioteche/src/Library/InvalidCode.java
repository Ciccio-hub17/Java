package Library;

public class InvalidCode extends Exception{
    public InvalidCode (){
        super ();
    }

    public InvalidCode (String message){
        super (message);
    }
}
