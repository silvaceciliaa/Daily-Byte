import java.util.Arrays;

public class WhoWins {

    public static void main(String[] args) throws Exception {
        int[] numeros = new int[] {14, 30, 1, 132, 2, 3, 12, 128, 290, 13, 4, 90, 15};
        int ultimaPonta = 0, numeroSaiu, vez = 1, pontosUm = 0, pontosDois = 0;
        
        while (numeros.length > 0){

            System.out.println(Arrays.toString(numeros));
            numeroSaiu = obterNumeroSaiu(numeros);

            if (vez == 1) {
                System.out.println("Jogador 1: " + numeroSaiu);
                pontosUm += numeroSaiu;
            }
            else if(vez == 2) {
                System.out.println("Jogador 2: " + numeroSaiu);
                pontosDois += numeroSaiu;
            }
            numeros = retirarNumeros(numeros, ultimaPonta);
            vez = vezJogar(vez);

        }
        if (pontosUm > pontosDois) {
            System.out.println("Jogador número 1 vencedor: " + pontosUm);
        }
        else if(pontosDois > pontosUm) {
            System.out.println("Jogador número 2 vencedor: " + pontosDois);
        }
        else {
            System.out.println("Empate!");
        }
    }


    public static int[] retirarNumeros(int[] numeros, int ultimaPonta) {
        if (numeros.length == 0) {
            return new int[0];
        }

        int[] novaArray = new int[numeros.length - 1];
        int primeiraPonta = numeros[0];
        ultimaPonta = numeros[numeros.length - 1];
    
        if (primeiraPonta > ultimaPonta) {
            for (int i = 1; i < numeros.length; i++) {
                novaArray[i - 1] = numeros[i];
            }
        } else if (primeiraPonta < ultimaPonta) {
            for (int i = 0; i < numeros.length - 1; i++) {
                novaArray[i] = numeros[i];
            }
        }
    
        return novaArray;
    }

    public static int obterNumeroSaiu(int[] numeros) {
        if (numeros.length == 0) {
            return 0; 
        }

        int primeiraPonta = numeros[0];
        int ultimaPonta = numeros[numeros.length - 1];

        if (primeiraPonta > ultimaPonta) {
            return primeiraPonta;
        } else {
            return ultimaPonta;
        }
    }


    static int vezJogar(int vezAtual) {
        if (vezAtual == 1) {
            return 2;
        } else {
            return 1;
        }
    }
    
}

