package br.andre.estudos.Game;

class Warrior {

    protected String nome;
    protected int saude;
    protected int poder;

    public Warrior(String nome, int saude, int poder) {
        this.nome = nome;
        this.saude = saude;
        this.poder = poder;
    }

    public void displayStatus(){
        System.out.println("Nome: " + nome);
        System.out.println("Saúde: " + saude);
        System.out.println("Poder: " + poder);
    }

    public void attack(Wizard wizard, int dano){
        wizard.saude -= dano;
        System.out.println("ATAQUE DE " + nome + " com " + dano + " de dano");
        System.out.println("SAÚDE DE " + wizard.nome + ": " + wizard.saude);
    }

    public void specialMove(){
        poder *= 2;
        System.out.println("Poder de " + nome + " duplicado!");
    }

    public boolean isAlive(){
        return saude > 0;
    }
}
