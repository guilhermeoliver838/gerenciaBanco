import java.util.Scanner;

public class gerenciaBanco {
    // Definição da classe Cliente
    static class Cliente {
        // Atributos da classe Cliente
        private String nome;
        private String sobrenome;
        private String cpf;
        private double saldo;

        // Método construtor da classe Cliente
        public Cliente(String nome, String sobrenome, String cpf) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.cpf = cpf;
            this.saldo = 0.0;
        }

        // Método para consultar saldo
        public void consultarSaldo() {
            System.out.println("Saldo atual: R$" + saldo);
        }

        // Método para realizar depósito
        public void depositar(double valorDeposito) {
            saldo += valorDeposito;
            System.out.println("Depósito de R$" + valorDeposito + " realizado com sucesso.");
        }

        // Método para realizar saque
        public void sacar(double valorSaque) {
            if (valorSaque > saldo) {
                System.out.println("Saldo insuficiente para realizar o saque.");
            } else {
                saldo -= valorSaque;
                System.out.println("Saque de R$" + valorSaque + " realizado com sucesso.");
            }
        }

        // Método getter para obter o nome do cliente
        public String getNome() {
            return nome;
        }

        // Método getter para obter o sobrenome do cliente
        public String getSobrenome() {
            return sobrenome;
        }

        // Método getter para obter o CPF do cliente
        public String getCpf() {
            return cpf;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitando informações ao usuário
        System.out.println("Bem-vindo ao Banco XYZ!");
        System.out.print("Por favor, informe seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Por favor, informe seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Por favor, informe seu CPF: ");
        String cpf = scanner.nextLine();

        // Criando um objeto da classe Cliente
        Cliente cliente = new Cliente(nome, sobrenome, cpf);

        // Menu de operações
        int opcao;
        do {
            System.out.println();
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Realizar depósito");
            System.out.println("3 - Realizar saque");
            System.out.println("4 - Encerrar");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            // Executando a operação selecionada pelo usuário
            switch (opcao) {
                case 1:
                    cliente.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    cliente.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    cliente.sacar(valorSaque);
                    break;
                case 4:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}

