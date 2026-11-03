package Library;

public class Libro {
    private String autori;
    private String titolo;
    private String editore;
    private String codice;

    public Libro (String autori, String titolo, String editore, String codice){
        this.autori = autori;
        this.titolo = titolo;
        this.editore = editore;
        this.codice = codice;
    }

    @Override 
    public String toString (){
        return autori + " " + titolo + " " + editore + " " + codice;
    }

    public String getCodice (){
        return this.codice;
    }

    public String getAutori (){
        return this.autori;
    }


}
