public class Emprestimo {
    Livro livro;
    Leitor leitor;
    String dataEmp;
    String dataDev;

    public Emprestimo() {

    }
    
    public Emprestimo(Livro livro, Leitor leitor, String dataEmp, String dataDev) {
        this.livro = livro;
        this.leitor = leitor;
        this.dataEmp = dataEmp;
        this.dataDev = dataDev;
    }

    
}
