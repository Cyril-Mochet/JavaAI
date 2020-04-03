package  weights.setup;

public class Main {
    public static void main(String[] args) {
        Calibrage Initialize = new Calibrage();
        Initialize.setWeight();

        Training Cycle = new Training();
        Cycle.propagationAvant();
    }
}
