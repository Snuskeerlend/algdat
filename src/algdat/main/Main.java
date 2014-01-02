/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algdat.main;
import algdat.hjelpelasser.Tabell;

/**
 *
 * @author erlendrognes
 */
public class Main
{
  public static void main(String[] args)        // hovedprogram
  {
    int[] a = Tabell.randPerm(20);              // en tilfeldig tabell
    for (int k : a) System.out.print(k + " ");  // skriver ut a

    int m = Tabell.maks(a);   // finner posisjonen til største verdi

    System.out.println("\nStørste verdi ligger på plass " + m);
    
    Tabell.skrivln(a);

  } // main

} // class Program