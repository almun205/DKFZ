package org.dkfz;

import java.util.List;

public class DNAColorBalanceCalculator {

    public void processSequences(List<String> sequences){
        int len = sequences.get(0).length();

        for (int i = 0; i < len; i++){
            int redVisible = 0;
            int greenVisible = 0;

            for (String seq: sequences){
                char base = seq.charAt(i);
                if (isVisibleUnderRedLaserPhoto(base)) redVisible++;
                if (isVisibleUnderGreenLaserPhoto(base)) greenVisible++;
            }

            System.out.println("- Red: " + redVisible +" |"+" greed: " + greenVisible);
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


}
