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
        int jumpSize = 1;
    
        for (int i = 1; i < stones.length; ) {
            int nextStone = stones[i - 1] + jumpSize;
            
            if (i == stones.length - 1 && stones[i] == nextStone) {
                return true;
            }
            
            while (i < stones.length && stones[i] < nextStone) {
                i++;
            }
            
            if (i < stones.length && stones[i] != nextStone) {
                return false;
            }
            
            jumpSize++;
        }
        
        return true;
    }
    
}
