/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algdat.main;
import algdat.hjelpelasser.Tabell;
import java.io.IOException;

/**
 *
 * @author erlendrognes
 */
public class Main
{
  public static void main(String[] args) throws IOException
  {
      int[] a = Tabell.randPerm(20); // tilfeldig permutasjon av 1 . . 20
  int[] b = Tabell.nestMaks(a);  // metoden returnerer en tabell

  int m = b[0], nm = b[1];       // m for maks, nm for nestmaks

  Tabell.skrivln(a);        // se Oppgave 5 i Avsnitt 1.2.2
  System.out.print("Størst(" + a[m] + ") har posisjon " + m);
  System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);

  // Eksempel på en utskrift:

  // 12 16 15 6 10 8 9 2 14 19 5 18 20 13 3 7 11 1 4 17
  // Størst(20) har posisjon 12, nest størst(19) har posisjon 9
  }
} // class Program