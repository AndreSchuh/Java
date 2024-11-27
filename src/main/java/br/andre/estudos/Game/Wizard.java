package br.andre.estudos.Game;

import java.util.Random;

public class Wizard {

    Random random = new Random();

    protected String nome;
    protected int saude;
    protected int poder;

    public Wizard(String nome, int saude, int poder) {
        this.nome = nome;
        this.saude = saude;
        this.poder = poder;
    }

    public void displayStatus(){
        System.out.println("Nome: " + nome);
        System.out.println("Saúde: " + saude);
        System.out.println("Poder: " + poder);
    }

    public void attack(Warrior warrior, int dano){
        warrior.saude -= dano;
        System.out.println("ATAQUE DE " + nome + " com " + dano + " de dano");
        System.out.println("SAÚDE DE " + warrior.nome + ": " + warrior.saude);
    }

    public void specialMove(){
        saude += random.nextInt(30);
        System.out.println("Saúde de " + nome + " aumentada para: " + saude);
    }

    public boolean isAlive(){
        return saude > 0;
    }
}


