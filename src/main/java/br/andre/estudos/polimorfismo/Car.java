package br.andre.estudos.polimorfismo;


// Classe abstrata base para carros
abstract class Car {
    protected String model;
    protected String color;
    protected int speed;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
        this.speed = 0;
    }

    // Método abstrato para acelerar
    public abstract void accelerate(int increment);

    // Método comum para mostrar informações
    public void displayInfo() {
        System.out.println("Modelo: " + model);
        System.out.println("Cor: " + color);
        System.out.println("Velocidade atual: " + speed + " km/h");
    }
}
