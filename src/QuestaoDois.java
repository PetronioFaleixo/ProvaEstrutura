import java.util.Random;
public class QuestaoDois {
    public static void main(String[] args) {
        // Definir os produtos
        String[] produtos = {
                "xampu",
                "condicionador",
                "hidratante",
                "tintura",
                "demaquilante",
                "vazio"
        };

        String[][] armazenamento = new String[40][40];
        Random rand = new Random();

        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                int produtoIndex = rand.nextInt(produtos.length);
                armazenamento[i][j] = produtos[produtoIndex];
            }
        }

        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                System.out.print(armazenamento[i][j] + " ");
            }
            System.out.println();
        }

        for (String produto : produtos) {
            int quantidade = contarProduto(armazenamento, produto);
            System.out.println(produto + ": " + quantidade);
        }
    }

    public static int contarProduto(String[][] armazenamento, String produto) {
        int quantidade = 0;
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                if (armazenamento[i][j].equals(produto)) {
                    quantidade++;
                }
            }
        }
        return quantidade;
    }
}
