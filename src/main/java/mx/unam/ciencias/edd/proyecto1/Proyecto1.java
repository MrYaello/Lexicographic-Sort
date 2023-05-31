package mx.unam.ciencias.edd.Proyecto1;

import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.Cola;

/**
  * Clase que ordena léxicograficamente archivos de texto o
  * entrada recibida, con posibilidad de guardar en archivo
  * y ordenar de forma inversa.
  */
public class Proyecto1 extends Main {
  public static void main(String[] args) {
    /* Procesar los argumentos */
    flagsChecker(args);
    /* Cola que contiene la lista de rutas de archivos de entrada. */
    Cola<String> paths = getFilePaths();
    /* Objeto para hacer uso de la clase de lectura. */
    Read read = new Read();
    /* Si la cola de rutas es vacia se procede con la entrada estandar, de lo contrario
       con los archivos. */
    if (paths.esVacia()) read.read(read.standardInput());
    else read.read(read.file(paths.saca())); 
    while (!paths.esVacia()) {
      read.read(read.file(paths.saca()));
    }
    /* Se ordena la lista obtenida */
    Lista<String> lista = lexSort(read.getLista());
    /* Invierte el orden si es requerido */
    if (doReverse()) lista = lista.reversa();
    /* Si se proporcionó ruta de salida escribe en el archivo, de lo contrario
       imprime en terminal. */
    if (getOutPathFile() != null) {  
      Write write = new Write(getOutPathFile());
      write.writeFile(formatedString(lista));
      System.out.println("Guardado en " + getOutPathFile());
    } else printString(lista);
  }  
}
