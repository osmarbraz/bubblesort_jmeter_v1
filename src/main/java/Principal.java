
public class Principal {

    public void bubblesort(int c[], int n) {
        int troca = 1;
        int m = n - 1;
        int k = 1;
        int ch;
        while (troca == 1) {
            troca = 0;
            for (int i = 0; i < m; i++) {
                if (c[i] > c[i + 1]) { //troca
                    ch = c[i];
                    c[i] = c[i + 1];
                    c[i + 1] = ch;
                    k = i;  //posicao da ultima troca
                    troca = 1; //sinaliza ocorrência da troca
                }
            }
            m = k; //vetor ja ordenado de m+1 ate n
        }
    }

    public void classificar(int quantidade, int intervalo) {
        int x[] = new int[quantidade];
        int n = quantidade;
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < n; i++) {
            //Gera numeros aleatórios
            x[i] = random.nextInt(intervalo + 1);
        }

        System.out.println(">>> BubbleSort <<<");
        System.out.println("Original: ");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " - " + x[i]);
        }

        bubblesort(x, n);

        System.out.println("Depois: ");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " - " + x[i]);
        }
    }

    public static void main(String args[]) {
        new Principal().classificar(100, 100);
    }
}
