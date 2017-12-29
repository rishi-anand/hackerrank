package extra.graph;

public class HelloWorld {

    public static void main(String[] devashree){

        try {
            int a = 5;
            int b[] = {1, 2, 4, 5, 6, 7, 8};

            for (int i = 2; i < b.length; i = i + 9) {

                System.out.println("i = " + i);
                System.out.println(b[i + 9]);

                System.out.println("OK");


                //b[i] = 4;
            }

        } catch (Exception e){
            System.out.println("HIII");
        } finally {
            System.out.println("SUCCESS");
        }


    }

}
