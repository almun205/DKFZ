package org.dkfz;

import java.util.List;

public class DNAColorBalanceCalculator {

    public void processSequences(List<String> sequences){
        int len = sequences.get(0).length();

        // Kopfzeile der Tabelle
        System.out.println("------------------------");
        System.out.println("| Zyklus | Rot  | Grün |");
        System.out.println("---------|------|-------");
        // logic for each cycle of the laser scanner (1..n)---> len
        // iter over each cycle
        for (int i = 0; i < len; i++){
            int redVisible = 0;
            int greenVisible = 0;

            // iter over each sequence
            for (String seq: sequences){
                char base = seq.charAt(i);
                if (isVisibleUnderRedLaserPhoto(base)) redVisible++;
                if (isVisibleUnderGreenLaserPhoto(base)) greenVisible++;
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


}
