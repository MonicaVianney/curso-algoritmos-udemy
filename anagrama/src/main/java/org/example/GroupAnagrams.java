package org.example;

import java.lang.reflect.Array;
import java.util.*;

/*
 * Un anagrama es una palabra creada a partir de la reordenación de las letras de otra palabra. Ej: saco - caso
 * Dado un array de strings, devuelve los anagramas agrupados. Cualquier orden es válido.
 *
 * Ejemplo:
 *  Input: words = ["saco", "arresto", "programa", "rastreo", "caso"].
 *  Output: [["saco", "caso"], ["arresto", "rastreo"], ["programa"]].
 *
 * Solucion:
 * ¿Cómo saber si una palabra es un anagrama? La palabra debe de tener la misma longitud de caracteres,
 * así como la misma cantidad de letras
 *
 * Un array de enteros podría solucionar esto, en donde el array sería del tamaño de letras
 * del abecedario (26), que en cada posición de array, se almacene el número de 'a', 'b', 'c', etc.
 * que tiene una palabra.
 *
 * En la posición 1, el número de a's que tiene la palabra, en la posición 2 el
 * número de b's, en la posición 3, el número de c's, y así sucesivamente.
 *
 * Ejemplo para saco y caso:
 * [1, 0, 1, 0..., 1, 0..., 1, 0,0,0];
 *
 * Complejidad del algoritmo:
 * O(N) * O(c) siendo N el numero de palabras de nuestro array, y siendo c el numero de caracteres
 * de la palabra mas grande
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] words) {
        //realizar las comprobaciones necesarias sobre nuestra entrada
        //agrupar nuestras palabras en anagramas
        //y devolverlo en el formato que nos piden
        if (words == null || words.length == 0) return Collections.emptyList();

        Map<String, List<String>> anagramMap = buildAnagramMap(words);
        return new ArrayList<>(anagramMap.values());

    }

    private Map<String, List<String>> buildAnagramMap(String[] words){
        Map<String, List<String>> map = new HashMap<>();
        for(String word : words){ //para cada palabra, calculamos su hash
            String hash = getAnagramHash(word);
            //Si ese hash no existe en el mapa, tenemos que crear una lista vacia para introducir
            //los anagramas de esa palabra
            if (!map.containsKey(hash)){
                map.put(hash, new ArrayList<>());
            }

            //tanto si el hash ya existia en el mapa o no, tenemos que añadirlo la palabra a la lista de anagramas
            map.get(hash).add(word);
        }
        return map;
    }

    private String getAnagramHash(String s){
        int[] letterCount = new int[26];
        for (int c : s.toCharArray()) { //1 char es equivalente a 1 entero ya que representa un entero en ASCII
            letterCount[c - 'a']++; //restamos el caracter menos a, y sumamos 1 unidad
            //obtienes la posicion en el array de letras y luego aumentas en 1 la posicion para avanzar en el array
        }

        return Arrays.toString(letterCount);
    }
}
