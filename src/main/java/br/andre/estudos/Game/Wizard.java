package br.andre.estudos.Game;

import java.util.Random;

class Wizard extends Character implements SpecialMove{

    Random random = new Random();

    private int dano;

    public Wizard(String nome, int saude, int poder) {
        super(nome, saude, poder);
    }

    public void attack(Character character){
        dano = random.nextInt(poder);
        character.saude -= dano;
        System.out.println("ATAQUE DE " + nome + " com " + dano + " de dano");
        System.out.println("SAÚDE DE " + character.nome + ": " + character.saude);
    }

    public void performSpecialMove(){
        saude += random.nextInt(30);
        System.out.println("Saúde de " + nome + " aumentada para: " + saude);
    }

    public boolean isAlive(){
        return saude > 0;
    }
}


