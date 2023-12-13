package org.dkfz;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DNAColorBalanceCalculator {

    public void processSequencesAndWriteResultsToFile(List<String> sequences, String outputFilePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath)) ) {
            int MaxLen = findMaxLen(sequences);


            // Kopfzeile der Tabelle in Terminal ausgeben
            System.out.println("------------------------");
            System.out.println("| Cycle  | Red  | Green |");
            System.out.println("---------|------|-------");
            // Kopfzeile der Tabelle in Datei schreiben
            writer.write("------------------------\n");
            writer.write("| Cycle  | Red  | Green |\n");
            writer.write("---------|------|-------\n");

            // logic for each cycle of the laser scanner (1..n)---> len
            // iter over each cycle
            for (int i = 0; i < MaxLen; i++) {
                int redVisible = 0;
                int greenVisible = 0;

                // iter over each sequence
                for (String seq : sequences) {
                    // check if the index is in the range of the sequence length
                    if (i < seq.length()) {
                        char base = seq.charAt(i);
                        if (isVisibleUnderRedLaserPhoto(base)) redVisible++;
                        if (isVisibleUnderGreenLaserPhoto(base)) greenVisible++;
                    }
                }
                System.out.printf("| %-2d.    | %-5d| %-5d| %n", i + 1, redVisible, greenVisible);
                writer.write(String.format("| %-6d | %-5d| %-5d| %n", i + 1, redVisible, greenVisible));

            }
            System.out.println("------------------------");
            writer.write("------------------------\n");

        }
    }

    public boolean isVisibleUnderRedLaserPhoto(char base){
         boolean adenin = (base == 'A');
         boolean cytosin = (base == 'C');

        return (adenin || cytosin);
    }
    public boolean isVisibleUnderGreenLaserPhoto(char base){
        boolean thymin = (base == 'T');
        boolean guanin = (base == 'A');

        return (thymin || guanin);

    }
    // find the maxLen of the sequences if they are not all the same length in warse case
    public int findMaxLen(List<String> sequences){
        int maxLen = 0;
        for (String seq: sequences){
            if (seq.length() > maxLen)
                maxLen = seq.length();
        }
        return maxLen;
    }


}
