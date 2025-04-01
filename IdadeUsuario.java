import java.time.Year;
import java.util.Scanner;

public class IdadeUsuario {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String nome;
            int nascimento;
            int idade;
            // Solicitar e validar o nome do usuário
            while (true) {
                System.out.print("Por favor, insira seu nome (apenas letras): ");
                nome = scanner.nextLine().trim(); // Remove espaços em branco no início e no final
                if (nome.matches("[a-zA-ZÀ-ÿ ]+")) { // Verifica se o nome contém apenas letras (inclusive acentos) e espaços
                    break;
                } else {
                    System.out.println("Entrada Inválida! O nome deve conter apenas letras e espaços.");
                }
            }   // Solicitar e validar o ano de nascimento
            while (true) {
                System.out.print("Por favor, insira o ano do seu nascimento (apenas números inteiros): ");
                if (scanner.hasNextInt()) { // Verifica se a entrada é um número inteiro
                    nascimento = scanner.nextInt();
                    int anoAtual = Year.now().getValue(); // Obtém o ano atual
                    idade = anoAtual - nascimento; // Calcula a idade
                    
                    // Valida a idade (0 ≤ idade ≤ 120)
                    if (idade >= 0 && idade <= 120) {
                        break;
                    } else {
                        System.out.println("Entrada Inválida! A idade deve estar entre 0 e 120 anos.");
                    }
                } else {
                    System.out.println("Entrada Inválida! Certifique-se de inserir um número inteiro.");
                    scanner.next(); // Limpa a entrada inválida
                }
            }   // Exibindo a mensagem com base na idade
            if (idade > 60) {
                System.out.println("Olá, " + nome + "! \nIncrível, você tem " + idade + " anos. \nEntão, já é considerado idoso.");
            } else if (idade < 18) {
                System.out.println("Olá, " + nome + "! \nVocê tem " + idade + " anos. \nEntão, ainda é considerado menor de idade.");
            } else {
                System.out.println("Olá, " + nome + "! \nVocê tem " + idade + " anos. \nEntão, já é considerado maior de idade.");
            }
            // Fecha o Scanner
        }
    }
}