package one.digitalinnovation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Dev {
    private String nome;
    private List<ConteudoEducacional> conteudosInscritos = new ArrayList<>();
    private List<ConteudoEducacional> conteudosConcluidos = new ArrayList<>();

    public void inscrever(ConteudoEducacional conteudo){
        if (conteudosInscritos.contains(conteudo)){
            System.err.println("Você já está inscrito ...");
        } else{
            conteudosInscritos.add(conteudo);
        }
    }

    public void inscrever(Bootcamp bootcamp){
        /*
        for(ConteudoEducacional conteudoEducacional : bootcamp.getConteudos()){
            inscrever(conteudoEducacional);
        }
        */
        bootcamp.getConteudos().stream().forEach(this::inscrever);
        bootcamp.getDevs().add(this);
    }

    public double calcularTotalXP(){
        return conteudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularXp()).sum();
    }

    public void progredir(){
        Optional<ConteudoEducacional> conteudoEducacional = conteudosInscritos.stream().findFirst();
        if(conteudoEducacional.isPresent()){
            conteudosConcluidos.add(conteudoEducacional.get());
            conteudosInscritos.remove(conteudoEducacional.get());
        }else{
            System.err.println("Você não tem nenhum curso em sua fila");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
