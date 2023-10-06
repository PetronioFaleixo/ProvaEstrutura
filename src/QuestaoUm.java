import java.io.*;
import java.util.*;

public class QuestaoUm {
    public static void main(String[] args) {
        List<String> historico = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        carregarHistorico(historico);

        mostrarHistoricoDecrescente(historico);

        System.out.print("Digite o link a ser excluído: ");
        String linkExcluir = scanner.nextLine();

        if (historico.remove(linkExcluir)) {
            System.out.println("Link excluído com sucesso!");
        } else {
            System.out.println("O link não existe.");
        }

        mostrarHistorico(historico);

        System.out.print("Digite o link a ser consultado: ");
        String linkConsultar = scanner.nextLine();

        if (historico.contains(linkConsultar)) {
            System.out.println("Link encontrado!");
        } else {
            System.out.println("Link não existe.");
        }

        salvarHistorico(historico);
    }

    private static void carregarHistorico(List<String> historico) {
        try (BufferedReader reader = new BufferedReader(new FileReader("historico.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                historico.add(linha);
            }
        } catch (IOException e) {
        }
    }

    private static void mostrarHistoricoDecrescente(List<String> historico) {
        List<String> historicoOrdenado = new ArrayList<>(historico);
        Collections.sort(historicoOrdenado, Collections.reverseOrder());
        System.out.println("Histórico de links em ordem decrescente:");
        mostrarHistorico(historicoOrdenado);
    }

    private static void mostrarHistorico(List<String> historico) {
        System.out.println("Histórico de links:");
        for (int i = 0; i < historico.size(); i++) {
            System.out.println(i + ": " + historico.get(i));
        }
    }

    private static void salvarHistorico(List<String> historico) {
        try (PrintWriter writer = new PrintWriter("historico.txt")) {
            for (String link : historico) {
                writer.println(link);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
