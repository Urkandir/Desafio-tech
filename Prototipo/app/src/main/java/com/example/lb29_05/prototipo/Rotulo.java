package com.example.lb29_05.prototipo;

public class Rotulo {
    private String id_rotulo;
    private boolean aplicavel; //Por exemplo: Se há uma pessoa na foto ou não, ou se há um carro na foto ou não
    private String nome_rotulo; //Ou pode ser o que o rótulo diz, como por exemplo "Há uma pessoa nesta imagem?"


    public void setId_rotulo(String parametroId_rotulo) {
        id_rotulo = parametroId_rotulo;
    }

    public String getId_rotulo() {
        return id_rotulo;
    }

    public void setAplicavel(boolean parametroAplicavel) {
        aplicavel = parametroAplicavel;
    }

    public boolean getAplicavel() {
        return aplicavel;
    }

    public void setNome_rotulo(String parametroNome_rotulo) {
        nome_rotulo = parametroNome_rotulo;
    }

    public String getNome_rotulo() {
        return nome_rotulo;
    }
}
