import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {

    public static void main(String[] args) throws Exception {
        if(args.length == 0) {
            StdOut.println("No arguments !");
        } else {
            int len = args.length;
            boolean isChampion = false;
            String champion = args[0];
            for (int i = 1; i < len; i++) {
                isChampion =  StdRandom.bernoulli((double) 1 / i);
                if(isChampion) {
                    champion = args[i];
                }
            }
            StdOut.println("Le mot random est : " + champion);
        }
    }

}
