package Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Biblioteca {
    private String name;

    private HashMap<String, Libro> libri = new HashMap<>();
    private HashMap<Integer, Utente> utenti = new HashMap<> ();
    private HashMap<String, Utente> prestiti = new HashMap<>();
    private HashMap <String, Queue<Utente>> pendenti = new HashMap<>();

    public Biblioteca (String name){
        this.name = name;
    }

    public String getName (){
        return name;
    }

    public void addLibro (Libro libro) throws InvalidIsbn{
        if (libri.containsKey(libro.getCodice())){
            throw new InvalidIsbn("Libro già presente in elenco");
        }

        libri.put(libro.getCodice(), libro);
    }

    public Libro getLibro (String codice){
        return libri.get(codice);
    }

    public List<Libro> libriPerAutore (){
        List<Libro> lista = new ArrayList<>(libri.values());

        lista.sort((l1, l2) -> l1.getAutori().compareTo(l2.getAutori()));

        return lista;
    }

    public void addUtente (Utente utente) throws InvalidCode{
        if (utenti.containsKey(utente.getCodice())){
            throw new InvalidCode ("Utente gia registrato");
        }

        utenti.put(utente.getCodice(), utente);
    }

    public List<Utente> utenti (){
        List <Utente> lista = new ArrayList<> (utenti.values());

        lista.sort ((u1, u2) -> u1.getCodice().compareTo(u2.getCodice()));

        return lista;
    }

    public Libro prestito (int codU, String codL) throws InvalidCode, InvalidIsbn{
        if (!(utenti.containsKey(codU))){
            throw new InvalidCode("Utente non registrato");
        }

        if (!(libri.containsKey(codL))){
            throw new InvalidIsbn("Libro non presente in biblioteca");
        }

        if (!(prestiti.containsKey(codL))){
            prestiti.put (codL, utenti.get(codU));
            utenti.get(codU).noleggio(libri.get(codL));

            return libri.get(codL);
        }
        else if (prestiti.get(codL).equals(utenti.get(codU))){
            return null;
        }
        else{
            if (!(pendenti.containsKey(codL))){
                pendenti.put(codL, new LinkedList<Utente> ());
            }
            pendenti.get(codL).add(utenti.get(codU));
        }

        return null;
    }

    public Queue<Utente> getRichieste (Libro libro){
        return pendenti.get(libro.getCodice());
    }

    public Libro restituzione (int codU, String codL) throws InvalidCode, InvalidIsbn{
        if (!(utenti.containsKey(codU))){
            throw new InvalidCode("Utente non registrato");
        }

        if (!(libri.containsKey(codL))){
            throw new InvalidIsbn("Libro non presente in biblioteca");
        }

        if (!prestiti.containsKey(codL) || !(prestiti.get(codL).equals(utenti.get(codU)))){
            return null;
        }

        prestiti.get(codL).reso(libri.get(codL));

        if (pendenti.containsKey(codL)){
            prestiti.put(codL, pendenti.get(codL).poll());
            prestiti.get(codL).noleggio(libri.get(codL));
            if (pendenti.get(codL).isEmpty()){
                pendenti.remove(codL);
            }
        }
        else{
            prestiti.remove(codL);
        }
        
        return libri.get(codL);
    }


    public List<Libro> elencoPrestiti (){
        List<Libro> lista = new ArrayList<> ();
        for (String key : prestiti.keySet()){
            lista.add (libri.get(key));
        }
        lista.sort ((l1, l2) -> l1.getAutori().compareTo(l2.getAutori()));
        return lista;
    }

    public List<Libro> elencoRichieste (){
        List<Libro> lista = new ArrayList<>();
        for (String key : pendenti.keySet()){
            lista.add (libri.get(key));
        }
        lista.sort ((l1, l2) -> l1.getAutori().compareTo(l2.getAutori()));
        return lista;
    }


}
