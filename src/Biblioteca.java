import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Leitor> leitores = new ArrayList<>();
    private ArrayList<Tema> temas = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public Biblioteca() {

    }

    public Biblioteca(ArrayList<Livro> livros, ArrayList<Leitor> leitores, ArrayList<Tema> temas) {
        this.livros = livros;
        this.leitores = leitores;
        this.temas = temas;
    }

    public boolean livrosDisponiveis() {
        int emprestimos = 0;

        for (Livro livro : this.livros) {
            if (livro.getQuantidade() == livro.getQuantidadeEmp()) {
                emprestimos++;
            }
        }

        if (emprestimos == this.livros.size()) {
            return false;
        } else {
            return true;
        }
    }

    public String listarTemas() {
        String s = "";

        int i = 0;
        for (Tema tema : this.temas) {
            s += i + " - " + tema.getNome() + "\n ";
            i++;
        }

        return s;
    }

    public String listarLivros() {
        String s = "";

        int i = 0;
        for (Livro livro : this.livros) {
            s += i + " - " + livro.getNome() + "\n ";
            i++;
        }
    
        return s;
    }

    public String listarLivrosDisponiveis() {
        String s = "";

        int i = 0;
        for (Livro livro : this.livros) {
            if (livro.getQuantidade() != livro.getQuantidadeEmp()) {
                s += i + " - " + livro.getNome() + "\n ";
            }
            i++;
        }
    
        return s;
    }

    public String listarLeitores() {
        String s = "";

        int i = 0;
        for (Leitor leitor : this.leitores) {
            s += i + " - " + leitor.getNome() + "\n ";
            i++;
        }
    
        return s;
    }

    public String listarEmprestimos() {
        String s = "";

        int i = 0;
        for (Emprestimo emprestimo : this.emprestimos) {
            s += i + " - Livro: " + emprestimo.livro.getNome() + ", Leitor: " + emprestimo.leitor.getNome() + ", Data de empréstimo: " + emprestimo.dataEmp + ", Data de devolução: " + emprestimo.dataDev + "\n ";
            i++;
        }
    
        return s;
    }

    public void adicionarTema(Tema tema) {
        this.temas.add(tema);
    }

    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
    }

    public void adicionarLeitor(Leitor leitor) {
        this.leitores.add(leitor);
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }

    public void removerEmprestimo(int indice) {
        this.emprestimos.remove(indice);
    }
    
    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public Tema getTema(Integer indice) {
        if (indice == null) {
            return null;
        }
        else {
            return this.temas.get(indice);
        }
    }
    public ArrayList<Tema> getTemas() {
        return temas;
    }

    public Leitor getLeitor(Integer indice) {
        if (indice == null) {
            return null;
        }
        else {
            return this.leitores.get(indice);
        }
    }

    public ArrayList<Leitor> getLeitores() {
        return leitores;
    }

    public Livro getLivro(Integer indice) {
        if (indice == null) {
            return null;
        }
        else {
            return this.livros.get(indice);
        }
    }

    public Emprestimo getEmprestimo(Integer indice) {
        if (indice == null) {
            return null;
        }
        else {
            return this.emprestimos.get(indice);
        }
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
       
    
}
