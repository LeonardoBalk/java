package org.example;

public class Professor extends Pessoa {
    String setor;
    String siape;

    public Professor(String nome, boolean temAgendamento, float creditos, boolean temBSE, String setor, String siape) {
        super(nome, temAgendamento, creditos, temBSE);
        this.setor = setor;
        this.siape = siape;
        this.temBSE = false;
    }
}

public String getSetor() {
    return setor;
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