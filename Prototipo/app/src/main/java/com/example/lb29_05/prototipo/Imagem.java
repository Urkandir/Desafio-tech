package com.example.lb29_05.prototipo;

import java.util.ArrayList;
import java.util.List;

public class Imagem {
    private String id_imagem;
    //private boolean rotulo;
    List<Rotulo> rotulos = new ArrayList<Rotulo>(); //Lista de objetos da classe rotulos
    //Pode ter uma lista de rótulos ou "perguntas"


    public void setId_imagem(String parametroId_imagem) {
        id_imagem = parametroId_imagem;
    }

    public String getId_imagem() {
        return id_imagem;
    }

    /*public void setRotulo(boolean parametroRotulo) {
        rotulo = parametroRotulo;
    }

    public boolean getRotulo() {
        return rotulo;
    }*/
}
