package one.digitalinnovation;


import java.time.LocalDateTime;

public class Mentoria extends ConteudoEducacional{

    private LocalDateTime data;

    @Override
    public double calcularXp() {
        return XP_PADRAO;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
