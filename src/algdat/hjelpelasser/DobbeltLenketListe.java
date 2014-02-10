package algdat.hjelpelasser;


import java.util.*;

public class DobbeltLenketListe<T> implements Liste<T>
{
  private static final class Node<T>       // en indre nodeklasse
  {
    private T verdi;
    private Node<T> forrige, neste;

    private Node(T verdi, Node<T> forrige, Node<T> neste)   // konstruktør
    {
      this.verdi = verdi;
      this.forrige = forrige;
      this.neste = neste;
    }
  }

  private Node<T> hode;         // peker til den første i listen
  private Node<T> hale;         // peker til den siste i listen
  private int antall;           // antall noder i listen
  private int antallEndringer;  // antall endringer i listen
  
  private void indeksKontroll(int indeks)
  {
    if (indeks < 0 )
      throw new IndexOutOfBoundsException("Indeks " +
         indeks + " er negativ!");
    else if (indeks >= antall)
      throw new IndexOutOfBoundsException("Indeks " +
          indeks + " >= antall(" + antall + ") noder!");
  }
  
  private static <T> void nullSjekk(T verdi)
  {
    if(verdi == null) throw new NullPointerException("Verdi er lik NULL");
  }
  
  private Node<T> finnNode(int indeks)
  {
    Node <T> p;
    
    if(indeks <= antall/2)
    {
      p = hode; 
      for(int i = 0; i < indeks; i++)
      {
        p = p.neste;
      }
    }
    else
    {
      p = hale; 
      for(int i = antall - 1; i > indeks; i--)
      {
        p = p.forrige;
      }
    }
    return p; 
  }

  public DobbeltLenketListe()  // konstruktør
  {
    hode = hale = null;
    antall = 0;
    antallEndringer = 0;
  }
  
  public boolean tom()
  {
    if(antall == 0) return true;
    return false;
  }
  
  public int antall()
  {
    return antall;
  }
  
  public void nullstill()
  {
    // foreløpig kode
  }
  
  public boolean inneholder(T verdi)
  {
    return false;  // foreløpig kode
  }
  
  public void leggInn(int indeks, T verdi)
  {
    // foreløpig kode
  }
  
  public boolean leggInn(T verdi)
  {
    nullSjekk(verdi);
    if(antall == 0)
    {
      hode = hale = new Node<>(verdi, null, null);
    }
    else
    {
      hale = hale.neste = new Node<>(verdi,null,hale);
    }
    antall++;
    antallEndringer++;
    
    return true;
  }
  
  public T hent(int indeks)
  {
    indeksKontroll(indeks);
    return finnNode(indeks).verdi;
  }
  
  public int indeksTil(T verdi)
  {
    if(verdi == null) return -1;
    
    Node<T> p = hode; 
    
    for(int i = 0; i < antall; i++, p = p.neste)
    {
      if(p.verdi.equals(verdi))
      {
        return i;
      }
    }
    return -1;
  }
  
  public T oppdater(int indeks, T nyverdi)
  {
    indeksKontroll(indeks);
    nullSjekk(nyverdi);
    
    Node<T> p = finnNode(indeks);
    
    T gammel = p.verdi;
    p.verdi = nyverdi;
    antallEndringer++;
    return gammel;
  }
  
  public T fjern(int indeks)
  {
    return null;  // foreløpig kode 
  }
  
  public boolean fjern(T verdi)
  {
    return false;  // foreløpig kode
  }
  
  private class DobbeltLenketListeIterator implements Iterator<T>
  {
    private Node<T> p;
    private boolean fjernOK;
    private int forventetAntallEndringer;

    private DobbeltLenketListeIterator()
    {
      p = hode;         // p starter på den første i listen
      fjernOK = false;  // blir sann når next() kalles
      forventetAntallEndringer = antallEndringer;  // teller endringer
    }
    
    public boolean hasNext()
    {
      return false;  // foreløpig kode 
    }
    
    public T next()
    {
      return null;  // foreløpig kode
    }
    
    public void remove()
    {
      // foreløpig kode
    }

  } // class DobbeltLenketListeIterator  

  public Iterator<T> iterator()
  {
    return new DobbeltLenketListeIterator();
  }
  
  public Iterator<T> iterator(int indeks)
  {
    return null; // foreløpig kode
  }
  
  public String toString()
  {
    if(antall == 0) return "[]";
    
    StringBuilder s = new StringBuilder();
    s.append("[");
    Node<T> p = hode;
    s.append(p.verdi);
    for(int i = 0; i < antall-1; i++)
    {
      s.append(", ").append(p.neste.verdi);
      p = p.neste;
    }
    s.append("]");
    return s.toString();
  }

  public String omvendtString()
  {
    if(antall == 0) return "[]";
    
    StringBuilder s = new StringBuilder();
    s.append("[");
    Node<T> h = hode;
    s.append(h.verdi);
    
    for(int i = antall -1; i > 0; i--)
    {
      s.append(", ").append(h.forrige.verdi);
      h = h.forrige;
    }
    s.append("]");
    return s.toString();
  }

} // class DobbeltLenketListe