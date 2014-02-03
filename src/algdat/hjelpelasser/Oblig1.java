package algdat.hjelpelasser;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1
{
  private static void bytt(int[] a, int i, int j)
  {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  private static void bytt(char[] a, int i, int j)
  {
    char temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
  
  public static int maks(int[] a)
  {
    if(a.length < 1)
    {
      throw new NoSuchElementException("a er tom!");
    }
    
    for(int i = 1; i < a.length; i++)
    {
      if(a[i - 1] > a[i])
      {
        bytt(a, i - 1, i);
      }
    }
    return a[a.length - 1];
  }
  
  
  public static void sortering(int[] a)
  {
    for(int i = a.length; i > 0; i--)
    {
      for(int j = 1; j < i; j++)
      {
        if(a[j-1] > a[j])
        {
          bytt(a, j-1,j);
        }
      }
    }
  }
  
  
  public static int antallUlikeSortert(int [] a)
  {
    if(a.length < 2)
    {
      return a.length;
    }
    int antallUlike = 1;
    
    for(int i = 1; i < a.length; i++)
    {
      if(a[i-1] > a[i])
      {
         throw new IllegalStateException("A er ikke sortert");
      }
      else if(a[i-1] < a[i])
      {
        antallUlike++;
      }
      
    }
    return antallUlike;
  }
  
  public static int antallUlikeUsortert(int [] a)
  {
    if(a.length < 2)
    {
      return a.length;
    }
    
    int antallUlike = 1;
    
    for(int i = 1; i < a.length; i++)
    {
      int j = 0;
      for(; j < a.length; j++)
      {
        if(a[j] == a[i]){
          break;
        }
      }
      if(j == i)
        {
          antallUlike++;
        }
    }
    return antallUlike;
  }
  
  public static void rotasjon(char []a)
  {
    if(a.length > 1)
    {
      char temp = a[a.length - 1];
      for(int i = a.length - 1; i > 0; i--)
      {
        a[i] = a[i-1];
      }
      a[0] = temp;
    }
  }
  
  public static void rotasjon(char []a, int k)
  {
    int n = a.length;
    if(n <= 1) return;
    
    k %= n;
    if(k < 0) k += n;
    
    int v = 0, h = n - 1;
    while(v < h) bytt(a,v++,h--);
    
    v = 0; h = k-1;
    while(v < h) bytt(a,v++,h--);
    
    v = k; h = n-1;
    while(v<h) bytt(a,v++,h--);
        
  }
  
   public static String toString(int[] a, char v, char h, String mellomrom)
  {
    StringBuilder s = new StringBuilder();
    s.append(v);

    if (a.length > 0)
    {
      s.append(a[0]);
    }

    for (int i = 1; i < a.length; i++)
    {
      s.append(mellomrom).append(a[i]);
    }

    s.append(h);

    return s.toString();
  }
   
   
  public static int[] tredjeMinst(int[] a)
  {
    int n = a.length;     // tabellens lengde

    if (n < 3)     // må ha minst tre verdier
    {
      throw new IllegalArgumentException("a.length(" + n + ") < 3!");
    }

    int m = 0;     // m er posisjonen til minst verdi
    int nm = 1;    // nm er posisjonen til nest minst verdi
    int tm = 2;    // tm er posisjonen til tredje minst verdi

    // vi bytter om slik at når vi starter er m posisjonen til
    // den minste av de tre første, nm er posisjonen til den nest
    // minste og tm posisjonen til den største av de tre første

    if (a[nm] < a[m])
    {
      m = 1;
      nm = 0;
    }

    if (a[tm] < a[m])
    {
      int temp = tm;
      tm = m;
      m = temp;
    }

    if (a[tm] < a[nm])
    {
      int temp = tm;
      tm = nm;
      nm = temp;
    }

    int minverdi = a[m];                // minste verdi
    int nestminverdi = a[nm];           // nest minste verdi
    int tredjeminverdi = a[tm];         // tredje minste verdi

    for (int i = 3; i < n; i++)
    {
      int verdi = a[i];

      if (verdi < tredjeminverdi)
      {
        if (verdi < nestminverdi)
        {
          if (verdi < minverdi)
          {
            tm = nm;
            tredjeminverdi = nestminverdi;

            nm = m;
            nestminverdi = minverdi;

            m = i;
            minverdi = verdi;
          }
          else  // verdi >= minverdi && verdi < nestminverdi
          {
            tm = nm;
            tredjeminverdi = nestminverdi;

            nm = i;
            nestminverdi = verdi;
          }
        }
        else // verdi >= nestminverdi && verdi < tredjeminverdi
        {
          tm = i;
          tredjeminverdi = verdi;
        }
      }

    } // for

    return new int[] { m, nm, tm };
  }
  
  
  public static int[] kMinst(int[] a, int k)
  {
    if (k < 1)
    {
     throw new IllegalArgumentException
        ("k(" + k + ") må være positiv!!");
    }

    if (a.length < k)
    {
      throw new IllegalArgumentException
        ("k(" + k + ") må være <= a.length(" + a.length + ")!");
    }

    int[] verdier = Arrays.copyOf(a, k);   // de k første verdiene i a
    Arrays.sort(verdier);

    for (int i = k; i < a.length; i++)
    {
      int verdi = a[i];

      if (verdi < verdier[k-1])
      {
        // verdi skal inn på rett sortert plass i verdier
        int j = k - 2;
        for ( ; j >= 0 && verdi < verdier[j]; j--)
        {
          verdier[j+1] = verdier[j];    // flytter i verdier
        }
        verdier[j+1] = verdi;           // legger inn på plass j + 1
      }
    }

    return verdier;  // returnerer indeks-tabellen
  }
  
  
  public static int[] bokstavfrekvens(String url) throws IOException
  {
    int[] frekvens = new int[256];
    InputStream inn = new BufferedInputStream((new URL(url)).openStream());
    int k;
    while ((k = inn.read()) != -1) frekvens[k]++;

    int[] antall = new int[29]; // A til Ã?

    for (int i = 0; i < 26; i++)  // A/a til Z/z
      antall[i] = frekvens[i + 'A'] + frekvens[i + 'a'];

    antall[26] = frekvens['Æ'] + frekvens['æ'];
    antall[27] = frekvens['ø'] + frekvens['Ø'];
    antall[28] = frekvens['å'] + frekvens['Å'];

    return antall;
  }
  
}
