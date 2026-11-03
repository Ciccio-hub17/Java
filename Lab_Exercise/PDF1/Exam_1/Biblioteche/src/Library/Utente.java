package Library;

import java.util.ArrayList;
import java.util.List;

public class Utente {
    private Integer codice;
    private String nome;
    private String cognome;

    private List<Libro> prestiti = new ArrayList<> ();

    public Utente (int codice, String nome, String cognome){
        this.codice = codice;
        this.nome = nome;
        this.cognome = cognome;
    }

    @Override 
    public String toString (){
        return codice + " " + nome + " " + cognome;
    }

    public Integer getCodice (){
        return codice;
    }

    public void noleggio (Libro libro){
        prestiti.add(libro);
    }

    public void reso (Libro libro){
        prestiti.remove(libro);
    }

    public List<Libro> prestiti (){
        prestiti.sort((l1, l2) -> l1.getAutori().compareTo(l2.getAutori()));
        return prestiti;
    }



}
