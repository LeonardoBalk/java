package org.example;

public class Aluno extends Pessoa {
    private String matricula;
    private String curso;

    public Aluno(String nome, String matricula, String curso, boolean temAgendamento, float creditos, boolean temBSE) {
        super(nome, temAgendamento, creditos, temBSE);
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    private boolean temCreditos (float credito){
        if(credito >= 2.50){
            return true;
        }

        return false;
    }

    public boolean podeAlmocar(float n){
        if(temAgendamento && (temBSE || temCreditos(n))){
            return true;
        }
        return false;
    }

    public void almocou(boolean podeAlmocar){
        if(podeAlmocar){
            System.out.println("Almocou!");
            if(!temBSE){
                creditos -= 2.50;
            }
        }
    }
}