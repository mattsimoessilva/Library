public class Livro {
    private String nome;
    private String autor;
    private int numPagina;
    private Tema tema;
    private String editora;
    private int quantidade;
    private int quantidadeEmp = 0;

    public Livro() {

    }

    public Livro(String nome, String autor, int numPagina, Tema tema, String editora, int quantidade) {
        this.nome = nome;
        this.autor = autor;
        this.numPagina = numPagina;
        this.tema = tema;
        this.editora = editora;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getQuantidadeEmp() {
        return quantidadeEmp;
    }

    public void adicionarQuantidadeEmp(int numero) {
        this.quantidadeEmp += numero;
    }

    public void removerQuantidadeEmp(int numero) {
        this.quantidadeEmp -= numero;
    }
}
