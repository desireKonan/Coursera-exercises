public class HelloGoodbye {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.err.println("Error ! You don't define parameters !");
        } else {
            StringBuilder helloWord = new StringBuilder("Hello ");
            StringBuilder goodbyeWord = new StringBuilder("Goodbye ");
            for (int i = 0; i < args.length - 1; i++) {
                helloWord.append(args[i]).append(" and ");
                goodbyeWord.append(args[args.length - (1 + i)]).append(" and ");
            }

            helloWord.append(args[args.length - 1]).append(".");
            goodbyeWord.append(args[0]).append(".");

            System.out.println(helloWord.toString());
            System.out.println(goodbyeWord.toString());
        }


    }
}
