package org.dkfz;

import java.util.List;

public class DNAColorBalanceCalculator {

    public void processSequences(List<String> sequences){
        int MaxLen = findMaxLen(sequences);

        // Kopfzeile der Tabelle
        System.out.println("------------------------");
        System.out.println("| Zyklus | Rot  | Grün |");
        System.out.println("---------|------|-------");
        // logic for each cycle of the laser scanner (1..n)---> len
        // iter over each cycle
        for (int i = 0; i < MaxLen; i++){
            int redVisible = 0;
            int greenVisible = 0;

            // iter over each sequence
            for (String seq: sequences){
                // check if the index is in the range of the sequence length
                if (i< seq.length()){
                char base = seq.charAt(i);
                if (isVisibleUnderRedLaserPhoto(base)) redVisible++;
                if (isVisibleUnderGreenLaserPhoto(base)) greenVisible++;
             }
            }
            System.out.printf("| %-6d | %-5d| %-5d| %n", i + 1, redVisible, greenVisible);

        }
        System.out.println("------------------------");

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
