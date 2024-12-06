package br.andre.estudos.Game;

import java.util.Random;

class Warrior extends Character implements SpecialMove {

    Random random = new Random();

    private int dano;
    private boolean rodadasPoderDuplicado = false;

    public Warrior(String nome, int poder, int saude) {
        super(nome, poder, saude);
    }

    @Override
    public void attack(Character character){
        dano = random.nextInt(poder);
        character.saude -= dano;
        System.out.println("ATAQUE DE " + nome + " com " + dano + " de dano");
        System.out.println("SAÚDE DE " + character.nome + ": " + character.saude);
    }

    @Override
    public void performSpecialMove(){
        boolean chanceAleatoria = random.nextBoolean();



        if(rodadasPoderDuplicado == false && chanceAleatoria == true){
            poder *= 2;
            rodadasPoderDuplicado = true;
            System.out.println("Poder duplicado ativado.");
        }else if(rodadasPoderDuplicado == true && chanceAleatoria == false){
            poder /= 2;
            rodadasPoderDuplicado = false;
            System.out.println("Poder duplicado desativado.");
        } else {
            System.out.println("Poder mantido.");
        }
    }
}
