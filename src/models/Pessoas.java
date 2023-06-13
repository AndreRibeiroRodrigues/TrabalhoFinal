package models;

import java.util.ArrayList;
import java.util.List;

public class Pessoas {
    List<Pessoa> pessoas;

    
    Pessoas(){
        this.pessoas = new ArrayList<Pessoa>();
        
    }
    public Pessoa getPessoas(int indice) {
        return pessoas.get(indice);
    }

    public void setPessoas(Pessoa pessoas) {
        this.pessoas.add(pessoas);
    }
    
}
