import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            Scanner reader = new Scanner(System.in, "CP850");

            System.out.println("""
                Bem-vindo à biblioteca. Selecione um número correspondente a uma opção do menu: \n
                - Digite 1 para cadastrar livros \n
                - Digite 2 para cadastrar leitores \n
                - Digite 3 para cadastrar temas \n
                - Digite 4 para empréstimo de livros \n 
                - Digite 5 para devolução de livros \n
            """);
            int number = reader.nextInt();
            reader.nextLine();

            if (number == 1) {
                while (true) {
                    Integer indiceTema = null;

                    System.out.println("Nome do livro: ");
                    String nome = reader.nextLine();

                    System.out.println("Autor: ");
                    String autor = reader.nextLine();

                    System.out.println("Número de páginas: ");
                    int numPagina = reader.nextInt();
                    reader.nextLine();

                    if (biblioteca.getTemas().size() > 0) {
                        System.out.println(String.format("Escolha um tema: \n %s", biblioteca.listarTemas()));
                        indiceTema = reader.nextInt();
                        reader.nextLine();
                    } 

                    System.out.println("Nome da editora: ");
                    String editora = reader.nextLine();

                    System.out.println("Quantidade: ");
                    int quantidade = reader.nextInt();
                    reader.nextLine();

                    if (nome.equals("") || autor.equals("") || editora.equals("")) {
                        System.out.println("Não foi possível cadastrar o objeto");
                        continue;
                    }
                    else {
                        Livro livro = new Livro(nome, autor, numPagina, biblioteca.getTema(indiceTema), editora, quantidade);
                        biblioteca.adicionarLivro(livro);
                        System.out.println("Livro cadastrado");
                        break;
                    }
                }

                while (true) {
                    System.out.println("Deseja continuar no sistema? (S/N)");
                    String escolha = reader.nextLine();

                    if (escolha.toLowerCase().equals("s")) {
                        break;
                    } 
                    else if (escolha.toLowerCase().equals("n")) {
                        System.exit(0);
                    }
                }
            }
            else if (number == 2) {
                while (true) {
                    System.out.println("Nome: ");
                    String nome = reader.nextLine();

                    System.out.println("E-mail: ");
                    String email = reader.nextLine();

                    if (nome.equals("") || email.equals("")) {
                        System.out.println("Não foi possível cadastrar o objeto");
                        continue;
                    } else {
                        Leitor leitor = new Leitor(nome, email);
                        biblioteca.adicionarLeitor(leitor);
                        System.out.println("Leitor cadastrado");
                        break;
                    }
                }

                while (true) {
                    System.out.println("Deseja continuar no sistema? (S/N)");
                    String escolha = reader.nextLine();

                    if (escolha.toLowerCase().equals("s")) {
                        break;
                    } 
                    else if (escolha.toLowerCase().equals("n")) {
                        System.exit(0);
                    }
                }
            }
            else if (number == 3) {
                while (true) {
                    System.out.println("Nome: ");
                    String nome = reader.nextLine();

                    if (nome.equals("")) {
                        System.out.println("Não foi possível cadastrar o objeto");
                        continue;
                    } else {
                        Tema tema = new Tema(nome);
                        biblioteca.adicionarTema(tema);
                        System.out.println("Tema cadastrado");
                        break;
                    }
                }

                while (true) {
                    System.out.println("Deseja continuar no sistema? (S/N)");
                    String escolha = reader.nextLine();

                    if (escolha.toLowerCase().equals("s")) {
                        break;
                    } 
                    else if (escolha.toLowerCase().equals("n")) {
                        System.exit(0);
                    }
                }
            }
            else if (number == 4) {
                while (true) {
                    if (biblioteca.getLivros().size() > 0 && biblioteca.getLeitores().size() > 0 && biblioteca.livrosDisponiveis()) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                        System.out.println(String.format("Escolha um livro: \n %s", biblioteca.listarLivrosDisponiveis()));
                        int indiceLivro = reader.nextInt();
                        reader.nextLine();

                        System.out.println(String.format("Escolha um leitor: \n %s", biblioteca.listarLeitores()));
                        int indiceLeitor = reader.nextInt();
                        reader.nextLine();

                        System.out.println("Informe a data de empréstimo: ");
                        String dataEmpString = reader.nextLine();
                        Date dataEmp = dateFormat.parse(dataEmpString);

                        System.out.println("Informe a data de devolução: ");
                        String dataDevString = reader.nextLine();
                        Date dataDev = dateFormat.parse(dataDevString);

                        if (dataEmp.equals("") || dataDev.equals("") || dataEmp.equals(dataDev) || dataDev.before(dataEmp)) {
                            System.out.println("Não foi possível realizar o empréstimo");
                        } else {
                            biblioteca.getLivro(indiceLivro).adicionarQuantidadeEmp(1);
                            Emprestimo emprestimo = new Emprestimo(biblioteca.getLivro(indiceLivro), biblioteca.getLeitor(indiceLeitor), dataEmp, dataDev);
                            biblioteca.adicionarEmprestimo(emprestimo);
                            System.out.println("Empréstimo realizado");
                            break;
                        }
                    } else {
                        System.out.println("Não há como emprestar livros");
                        break;
                    }
                }

                while (true) {
                    System.out.println("Deseja continuar no sistema? (S/N)");
                    String escolha = reader.nextLine();

                    if (escolha.toLowerCase().equals("s")) {
                        break;
                    } 
                    else if (escolha.toLowerCase().equals("n")) {
                        System.exit(0);
                    }
                }
            }
            else if (number == 5) {
                if (biblioteca.getLivros().size() > 0 && biblioteca.getLeitores().size() > 0) {
                    System.out.println(String.format("Escolha um empréstimo: \n %s", biblioteca.listarEmprestimos()));
                    int indiceEmprestimo = reader.nextInt();
                    reader.nextLine();

                    biblioteca.getEmprestimo(indiceEmprestimo).getLivro().removerQuantidadeEmp(1);   
                    biblioteca.removerEmprestimo(indiceEmprestimo);  
                    System.out.println("Devolução realizada"); 
                }
                
                while (true) {
                    System.out.println("Deseja continuar no sistema? (S/N)");
                    String escolha = reader.nextLine();

                    if (escolha.toLowerCase().equals("s")) {
                        break;
                    } 
                    else if (escolha.toLowerCase().equals("n")) {
                        System.exit(0);
                    }
                }
            }
        }
        
    }
}
