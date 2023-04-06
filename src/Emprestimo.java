import java.text.SimpleDateFormat;
import java.util.Date;

public class Emprestimo {
    private Livro livro;
    private Leitor leitor;
    private Date dataEmp;
    private Date dataDev;

    public Emprestimo() {

    }

    public Emprestimo(Livro livro, Leitor leitor, Date dataEmp, Date dataDev) {
        this.livro = livro;
        this.leitor = leitor;
        this.dataEmp = dataEmp;
        this.dataDev = dataDev;
    }

    public Livro getLivro() {
        return livro;
    }
    
}
