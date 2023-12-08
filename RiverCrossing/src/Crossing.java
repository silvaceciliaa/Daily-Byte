import java.util.Arrays;
import java.util.Scanner;

public class Crossing {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int numero = 3;

        int stones[] = new int[numero];        

        System.out.print("Digite em qual posição as pedras estão: ");
        for (int i = 0; i < stones.length; i++) {
            stones[i] = scanner.nextInt();
        }

        Arrays.sort(stones);
        boolean verifier = CrossingVerifier(stones);

        if (verifier) {
            System.out.println(Arrays.toString(stones) + " true");
        }
        else{
            System.out.println(Arrays.toString(stones) + " false");
        }

        scanner.close();
    }

    public static boolean CrossingVerifier(int[] stones) {
        int jumpSize = stones[0];
    
        for (int i = 0; i < stones.length; i++) {
            if (jumpSize >= stones[i]) {
                jumpSize = stones[i] + jumpSize;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
