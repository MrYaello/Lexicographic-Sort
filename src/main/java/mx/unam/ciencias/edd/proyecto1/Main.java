package mx.unam.ciencias.edd.Proyecto1;

import mx.unam.ciencias.edd.Lista;
import java.util.Comparator;
import java.text.Normalizer;

/**
  * Clase que realiza la actividad principal del proyecto. Ordenar la lista de cadenas,
  * normalizar las cadenas y formatear la lista.
  */
public class Main extends Flags {
  /**
    * Método que ordena léxicograficamente una lista de cadenas ignorando
    * espacios y acentos.
    * @param l - Lista de cadenas.
    * @return Lista<String> - Lista ordenada léxicográficamente.
    */
  public static Lista<String> lexSort(Lista<String> l) { 
    return l.mergeSort(new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        String a = makeItComparable(s1);
        String b = makeItComparable(s2);
        return a.compareTo(b);
      }
    });
  }
  
  /**
    * Método que elimina los espacios, reemplaza las mayúsculas y acentos.
    * @param s - Cadena a hacer comparable.
    * @return String r - Cadena sin acentos, mayúsculas y espacios.
    */
  private static String makeItComparable(String s) { 
    String r = s.toLowerCase().trim();
    return normalize(r).replaceAll("\\p{M}", "").replaceAll("\\W", "");
  }
  
  /**
    * Método que separa los acentos de los caracteres.
    * @param s - Cadena a modificar.
    * @return String - Cadena modificada.
    */
  private static String normalize(String s) {
    return s == null ? null : Normalizer.normalize(s, Normalizer.Form.NFKD);
  }
  
  /**
    * Método que formatea la lista para su escritura en archivo.
    * @param l - Lista de cadenas.
    * @return String - Cadena formateada.
    */
  public static String formatedString(Lista<String> l) {
    String r = "";
    for (String s : l) {
      r += s + "\n";
    }
    return r;
  }
  
  /**
    * Método que imprime la lista formateada.
    * @param l - Lista de cadenas.
    */
  public static void printString(Lista<String> l) {
    System.out.println(formatedString(l));
  }
}
