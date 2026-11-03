package Library;

public class InvalidIsbn extends Exception{

    public InvalidIsbn (){
        super ();
    }

    public InvalidIsbn (String message){
        super (message);
    }
}
