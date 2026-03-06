package atv1BoasPraticas;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    List<Livro> livros = new ArrayList<>();

    private boolean existeLivro(String titulo) { //Verifica se já existe o livro no catálogo
        for (Livro l : livros){
            if(l.getTitulo().equals(titulo)){
                return true;
            }
        }
        return false;
    }

    private boolean estaEmprestado(String titulo){
        if (existeLivro(titulo)){
            for(Livro l : livros){
                if (l.getTitulo().equals(titulo) && l.isEmprestado()){
                    return true;
                }
            }
        }
        return false;
    }

    public void adicionarLivro(Livro livro){ //Adiciona livro no catálogo, caso ele ainda não exista
        if(!existeLivro(livro.getTitulo())){
            livros.add(livro);
            System.out.println("Livro "+livro.getTitulo()+" adicionado com sucesso!");
        }else{
            System.out.println("O livro "+livro.getTitulo()+" já está em catálogo!");
        }
    }

    public void emprestarLivro(String titulo){ //Emprestar livro, caso ele ainda não esteja emprestado e caso a lista não esteja vazia
        if(!livros.isEmpty() && existeLivro(titulo) && !estaEmprestado(titulo)){
            for(Livro l : livros){
                if(l.getTitulo().equals(titulo)){
                    l.setEmprestado(true);
                    System.out.println("Livro "+titulo+" emprestado com sucesso!");
                    break;
                }
            }
        }else if(existeLivro(titulo)){
            System.out.println("Livro "+titulo+" já foi emprestado!");
        }else{
            System.out.println("O livro desejado não está em catálogo.");
        }
    }

    public void listarLivros(){ //Exibe os livros catalogados, caso não esteja vazia
        if(!livros.isEmpty()){
            System.out.println("Livros catálogados: "+livros.size()+"\n"+ livros);
        }else{
            System.out.println("Não há livros no catálogo!");
        }
    }
}
