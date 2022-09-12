package com.pandenutella.yt.core.utilities;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

@RequiredArgsConstructor
public final class ManaCostConverter {

    @SneakyThrows
    public int[] getManaCosts(String raw, int spellsPerRound) {

        if (raw.length() != spellsPerRound)
            throw new Exception();

        try {
            parseInt(raw);
        } catch (Exception e) {
            throw new Exception();
        }

        int[] manaCosts = new int[spellsPerRound];
        for (int i = 0; i < raw.length(); i++)
            manaCosts[i] = parseInt(valueOf(raw.charAt(i)));

        return manaCosts;
    }

    public int getTotalManaCost(String raw, int spellsPerRound) {
        int[] manaCosts = getManaCosts(raw, spellsPerRound);
        int totalManaCost = 0;

        for (int i = 0; i < spellsPerRound; i++)
            totalManaCost += manaCosts[i];

        return totalManaCost;
    }
}
