package org.example;


import java.util.HashSet;
import java.util.Set;

/*
 * Dado un metodo que recibe una String, comprobar si todos los caracteres son únicos o no.
 *
 * isUnique("abcde") => true;
 * isUnique("abcded") => false;
 * Algoritmo de complejidad constante O(1)
 *
 */
public class IsUnique {

    //Asumiento que es ASCII. Dependiendo de la codificacion, seran mas
    private static int NUMBER_OF_CHARS = 128;

    public boolean isUnique(String s) {
        if (s.length() > NUMBER_OF_CHARS) return false; //si es mayor que el numero de caracteres, hay repetidos

        Set<Character> set = new HashSet<>();
        for (Character c : s.toCharArray()){
            if (set.contains(c)) return false; //para cada caracter vamos a comprobar si existe en el set (si se repite)
            set.add(c); //si no, lo agregas al set
        }

        return true; //aqui significa que nuestra cadena de texto no tiene repetidos
    }
}
