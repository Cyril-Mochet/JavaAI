package weights.setup;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;

public class Calibrage {

    /**Set the weights initial values.*/
    public void setWeight() {
        int InputSize = 2;
        int OutputSize = 1;
        int HiddenSize = 3;
        double[][] weight1 = new double[2][3];
        double[] weight2 = new double[3];
        String strWeights = new String();

        for (int i=0; i != HiddenSize; i++){
            weight1[0][i] = Math.random() -1;
            weight1[1][i] = Math.random() -1;
        }

        for(int i=0; i != HiddenSize; i++){
            weight2[i] = Math.random() * (-1);
        }

        //Reader in = new FileReader("weights.csv");
        Path weightsPath = Paths.get("weights.csv");
        try {
            Files.write(weightsPath, String.format("Weight1[0][0],Weight1[0][1],Weight1[0][2],Weight1[1][0],Weight1[1][1],Weight1[1][2],Weight2[0],Weight2[1],Weight2[2]%n").getBytes());
        } catch (IOException e) {
            e.printStackTrace(); //A remplacer à terme
        }

        for (int i =0; i < weight1.length; i++ ){
            for (int j =0; j < weight1[i].length; j++){
                if (strWeights.length() > 0) {
                    strWeights += "," + weight1[i][j];
                } else {
                    strWeights += weight1[i][j];
                }
            }
        }
        for (int i = 0; i< weight2.length; i++){
            if (strWeights.length() > 0) {
                strWeights += "," + weight2[i];
            } else {
                strWeights += weight2[i];
            }
        }

        if (strWeights.length() > 0){
            strWeights += "%n";
        }

//        System.out.println(strWeights);

        try {
            Files.write(weightsPath, String.format(strWeights).getBytes(), APPEND);
        } catch (IOException e) {
            e.printStackTrace();//A remplacer à terme
        }

    }
}
