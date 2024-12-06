package br.andre.estudos.polimorfismo;


import java.util.Random;

public class CarRace {
    public static void main(String[] args) {
        // Criando diferentes tipos de carros
        Car sportsCar = new SportsCar("Mustang", "Vermelho");
        Car electricCar = new ElectricCar("Tesla", "Branco");

        // Demonstrando polimorfismo
        Car[] cars = {sportsCar, electricCar};

        Random random = new Random();
        int races = random.nextInt(11);

        for (int i = 0; i < races; i++) {
            System.out.println("\n================ Corrida " + (i + 1) +" ================");

            for (Car car : cars) {
                Random r1 = new Random();
                int increment = r1.nextInt(100);
                car.displayInfo();
                car.accelerate(increment);

                // Usando polimorfismo com a interface
                if (car instanceof CarSpecialSkill) {
                    ((CarSpecialSkill) car).performSpecialSkill();
                }

                System.out.println("-------------------");
            }
            System.out.println("================ fim corrida ================");
        }
    }
}