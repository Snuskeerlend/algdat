package algdat.hjelpelasser;

import static algdat.hjelpelasser.Tabell.bytt;
import static algdat.hjelpelasser.Tabell.maks;
import static algdat.hjelpelasser.Tabell.min;
import java.util.Random;

public class Tabell
{
  public static void bytt(int[] a, int i, int j)
  {
    int temp = a[i]; a[i] = a[j]; a[j] = temp;
  }
     
  public static int[] randPerm(int n)  // en effektiv versjon
  {
    Random r = new Random();         // en randomgenerator
    int[] a = new int[n];            // en tabell med plass til n tall
    for (int i = 0; i < n; i++)
      a[i] = i + 1;                  // legger inn tallene 1, 2, . , n

    for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
    {
      int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
      bytt(a,k,i);                   // bytter om
    }
    return a;                        // permutasjonen returneres
  }
  
  public static void randPerm(int[] a)  // stokker om a
  {
    Random r = new Random();     // en randomgenerator

    for (int k = a.length - 1; k > 0; k--)
    {
      int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
      bytt(a,k,i);
    }
  }
  
  public static int maks(int[] a, int fra, int til)
  {
    if (fra < 0 || til > a.length || fra >= til)
    {
      throw new IllegalArgumentException("Illegalt intervall!");
    }

    int m = fra;              // indeks til største verdi i a[fra:til>
    int maksverdi = a[fra];   // største verdi i a[fra:til>

    for (int i = fra + 1; i < til; i++)
    {
      if (a[i] > maksverdi)
      {
        m = i;                  // indeks til største verdi oppdateres
        maksverdi = a[m];       // største verdi oppdateres
      }
    }

    return m;  // posisjonen til største verdi i a[fra:til>
  }
  
  public static int maks(int[] a)  // bruker hele tabellen
  {
    return maks(a,0,a.length);     // kaller metoden over
  }
  
  public static int min(int[] a, int fra, int til)
  {
    if (fra < 0 || til > a.length || fra >= til)
      throw new IllegalArgumentException("Illegalt intervall!");

    int m = fra;             // indeks til minste verdi i a[fra:til>
    int minverdi = a[fra];  // minste verdi i a[fra:til>

    for (int i = fra + 1; i < til; i++) if (a[i] < minverdi)
    {
      m = i;               // indeks til minste verdi oppdateres
      minverdi = a[m];    // minste verdi oppdateres
    }

    return m;  // posisjonen til minste verdi i a[fra:til>
  }

  public static int min(int[] a)  // bruker hele tabellen
  {
    return min(a,0,a.length);  // kaller metoden over
  }
  
  public static void bytt(char[] c, int i, int j)
  {
    char temp = c[i]; c[i] = c[j]; c[j] = temp;
  }
  
   public static void fratilKontroll(int tablengde, int fra, int til)
  {
    if (fra < 0)                                  // fra er negativ
      throw new ArrayIndexOutOfBoundsException
        ("fra(" + fra + ") er negativ!");

    if (til > tablengde)                          // til er utenfor tabellen
      throw new ArrayIndexOutOfBoundsException
        ("til(" + til + ") > tablengde(" + tablengde + ")");

    if (fra > til)                                // fra er større enn til
      throw new IllegalArgumentException
        ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
  }
  
  public static void skriv(int[] a, int fra, int til)
  {
    fratilKontroll(a.length,fra,til);
    for(int i = fra; i < til; i++)
    {
      System.out.println(a[i] + " ");
    }
  }
  
  public static void skriv(int... a)
  {
    for(int k : a) System.out.println(k + " ");
  }
  
  public static void skrivln(int[] a, int fra, int til)
  {
    skriv(a,fra,til);
    System.out.println();
  }

  public static void skrivln(int... a)
  {
    skriv(a);
    System.out.println();
  }
  
  public static void skriv(char[] c, int fra, int til)
  {
    fratilKontroll(c.length, fra, til);
    for (int i = fra; i < til; i++) System.out.print(c[i] + " ");
  }

  public static void skriv(char... c)
  {
    for (char d : c) System.out.print(d + " ");
  }

  public static void skrivln(char[] c, int fra, int til)
  {
    fratilKontroll(c.length, fra, til);
    for (int i = fra; i < til; i++) System.out.print(c[i] + " ");
    System.out.println();
  }

  public static void skrivln(char... c)
  {
    skriv(c);
    System.out.println();
  }
  
  public static int[] naturligeTall(int n)
  {
    if (n < 1) throw new
      IllegalArgumentException("n(" + n + ") er mindre enn 1!");

    int[] a = new int[n];
    for (int i = 0; i < n; i++) a[i] = i + 1;
    return a;
  }

  public static int[] heleTall(int fra, int til)
  {
    if (fra > til) throw new
      IllegalArgumentException("fra(" + fra + ") > til(" + til + ")");

    int[] a = new int[til - fra];
    for (int i = fra; i < til; i++) a[i-fra] = i;
    return a;
  }
  
  public static void vhKontroll(int tablengde, int v, int h)
  {
    if (v < 0)
      throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

    if (h >= tablengde)
      throw new ArrayIndexOutOfBoundsException
        ("h(" + h + ") >= tablengde(" + tablengde + ")");

    if (v > h + 1)
      throw new IllegalArgumentException
        ("v = " + v + ", h = " + h);
  }
  
  
  
  
}
