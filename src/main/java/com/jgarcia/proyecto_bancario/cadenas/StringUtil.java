package com.jgarcia.proyecto_bancario.cadenas;

import java.util.HashSet;
import java.util.Set;

public class StringUtil {

    public boolean hasUniqueLetters(String input) {
        Set<Character> charSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!charSet.add(c)) {
                return false;
            }
        }
        return true;
    }
}
