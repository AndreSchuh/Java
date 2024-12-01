package br.andre.estudos.Game;

abstract class Character {

    protected String nome;
    protected int saude;
    protected int poder;

    public Character(String nome, int saude, int poder) {
        this.nome = nome;
        this.saude = saude;
        this.poder = poder;
    }

    public abstract void attack(Character character);

    public boolean isAlive(){return saude > 0;}

    public void displayStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Saude: " + saude);
        System.out.println("Poder: " + poder);
    }
}
