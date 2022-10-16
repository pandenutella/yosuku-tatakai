package com.pandenutella.yt.core.utilities;

public class StringUtility {
    public String flip(String string) {
        String[] letters = string.split("");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = letters.length - 1; i >= 0; i--)
            stringBuilder.append(flipCharacter(letters[i]));

        return stringBuilder.toString();
    }

    private String flipCharacter(String character) {
        return switch (character) {
            case "(" -> ")";
            case ")" -> "(";
            case "<" -> ">";
            case ">" -> "<";
            default -> character;
        };
    }
}
