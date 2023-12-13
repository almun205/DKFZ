package org.dkfz;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "sequences.txt";
        String OutputFilePath = "output.txt";
        try {
            List<String> sequences = readSequencesFromFile(inputFilePath);
            //System.out.println("List of the Sequences: " + sequences);
            DNAColorBalanceCalculator calculator = new DNAColorBalanceCalculator();
            calculator.processSequencesAndWriteResultsToFile(sequences, OutputFilePath);
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    private static List<String> readSequencesFromFile(String filePath) throws IOException {
        List<String> sequences = new ArrayList<>();
        // read line by line from file & add each line to sequencesList
        //try if the file exists
       try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
           String line;
           while ((line = reader.readLine()) != null) {
               sequences.add(line);
           }
       }
        return sequences;
    }

}