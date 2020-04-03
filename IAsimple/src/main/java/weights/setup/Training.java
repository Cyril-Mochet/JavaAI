package weights.setup;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Training {
    public void propagationAvant(){
        try {
            Reader in = new FileReader("weights.csv");
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            double[][] weight1 = new double[2][3];
            double[] weight2 = new double[3];

            for (CSVRecord record : records) {
                for (int i=0; i<weight1.length; i++){
                    for (int j=0; j<weight1[i].length; j++){
                        weight1[i][j] = Double.valueOf(record.get("Weight1[" + i + "][" + j + "]"));
                    }
                }
                for (int i=0; i<weight2.length; i++){
                    weight2[i] = Double.valueOf(record.get("Weight2[" + i + "]"));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
