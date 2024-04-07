import com.exercicio.model.Lanche;
import com.exercicio.model.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    private static final List<Lanche>  lanches = new ArrayList<>();
    private static final List<Pedido> listaPedido = new ArrayList<>();
    public static void main(String[] args) {




        lanches.add(new Lanche(1, "Cachorro Quente", 4.00));
        lanches.add(new Lanche(2, "X-Salada", 4.5));
        lanches.add(new Lanche(3, "X-Bacon", 5.00));
        lanches.add(new Lanche(4, "Torrada Simples", 2.00));
        lanches.add(new Lanche(5, "Refrigerante", 1.5));

        System.out.println("Seja bem-vindo à lanchonete creimbergx.");
        System.out.println("=*=*=*=*=*=*=*=*  CARDÁPIO  =*=*=*=*=*=*=*=*");
        System.out.println("\n");
        for (Lanche lanche : lanches) {
            System.out.print("Código " + lanche.getCodigo() + " ");
            System.out.print("Lanche " + lanche.getEspecificacao() + " ");
            System.out.print("Preço "  + lanche.getPreco());
            System.out.println("\n");
        }

        System.out.println("------------------------------------------");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o código do lanche que deseja: ");
        int codigoLanche = solicitarNumero(scanner);
        procurarLanchePeloCodigo(codigoLanche);

        System.out.println("Insira a quantidade de lanches que deseja: ");
        int quantidade = solicitarNumero(scanner);

        listaPedido.add(pedidoCliente(codigoLanche, quantidade, lanches));



        char respostaMaisUmLanche = maisUmLanche(scanner);
        while (respostaMaisUmLanche == 's') {
            System.out.println("Insira o código do lanche que deseja: ");
            codigoLanche = solicitarNumero(scanner);
            procurarLanchePeloCodigo(codigoLanche);

            System.out.println("Insira a quantidade de lanches que deseja: ");
            quantidade = solicitarNumero(scanner);
            listaPedido.add(pedidoCliente(codigoLanche, quantidade, lanches));

            respostaMaisUmLanche = maisUmLanche(scanner);
        }

    }

    private static void procurarLanchePeloCodigo(int codigo) {
        switch (codigo) {
            case 1:
                System.out.println("Cachorro Quente");
                return;
            case 2:
                System.out.println("X-Salada");
                return;
            case 3:
                System.out.println("X-Bacon");
                return;
            case 4:
                System.out.println("Torrada simples");
                return;
            case 5:
                System.out.println("Refrigerante");
                return;
            default:
                System.out.println("Código fora da lista de lanches. Por favor tente novamente:");
                break;
        }
    }

    private static int solicitarNumero(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.next(); // Limpar o buffer do scanner
            }
        }
    }

    private static char maisUmLanche(Scanner scanner) {
        double totalDoPedido = 0;
        System.out.println("Deseja incluir mais um lanche nesse pedido? (Sim ou Não): ");
        String resposta = scanner.next().toLowerCase();
        if (String.valueOf(resposta.charAt(0)).equals("n")) {
            System.out.println("Pedido realizado com sucesso");
            System.out.println("*=*=*=*=*=*=* ~ PEDIDO ~ *=*=*=*=*=*=*");
            System.out.printf("%-10s %-20s %-10s\n", "Quantia", "Lanche", "Preço");
            for (Pedido pedido : listaPedido) {
                System.out.printf("%-10s %-20s %-10s\n",
                        pedido.getQuantidadeDeLanches() + "x",
                        pedido.getLanche().getEspecificacao(),
                        NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(pedido.getValor()));;
                totalDoPedido += pedido.getValor();
            }
            System.out.printf("%-31s %-10s\n", "TOTAL", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(totalDoPedido));
            System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        }
        return resposta.charAt(0);
    }

    private static Pedido pedidoCliente(int codigoLanche, int quantidade, List<Lanche> lanches){
        Pedido pedido = new Pedido();
        //adicionando o lanche que o cliente escolheu na lista de pedido
        for (Lanche lanche : lanches) {
            if(lanche.getCodigo() == codigoLanche){
                pedido.setLanche(lanche);
                pedido.setQuantidadeDeLanches(quantidade);
                break;
            }

        }
        pedido.setValor(pedido.getLanche().getPreco() * quantidade);
        return pedido;

    }
}