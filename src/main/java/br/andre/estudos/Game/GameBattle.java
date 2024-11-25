package br.andre.estudos.Game;


import java.util.Random;
import java.util.Scanner;

public class GameBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Warrior warrior = new Warrior("Thor");
        Wizard wizard = new Wizard("Merlin");

        while (true) {
            System.out.println("\n--- MENU DE BATALHA ---");
            System.out.println("1. Ver status dos personagens");
            System.out.println("2. Warrior atacar Wizard");
            System.out.println("3. Wizard atacar Warrior");
            System.out.println("4. Usar movimento especial do Warrior");
            System.out.println("5. Usar movimento especial do Wizard");
            System.out.println("0. Sair do jogo");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    warrior.displayStatus();
                    wizard.displayStatus();
                    break;
                case 2:
                    warrior.attack(wizard);
                    break;
                case 3:
                    wizard.attack(warrior);
                    break;
                case 4:
                    warrior.specialMove();
                    break;
                case 5:
                    wizard.specialMove();
                    break;
                case 0:
                    System.out.println("Saindo do jogo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }

            // Verificar se algum personagem morreu
            if (!warrior.isAlive() || !wizard.isAlive()) {
                System.out.println("\n🏆 BATALHA TERMINADA! 🏆");

                if (!warrior.isAlive() && !wizard.isAlive()) {
                    System.out.println("🤝 Empate! Ambos os personagens morreram simultaneamente!");
                } else if (!warrior.isAlive()) {
                    System.out.println("🧙 Merlin (Wizard) VENCEU a batalha!");
                    System.out.println("💀 Thor (Warrior) foi derrotado!");
                } else {
                    System.out.println("⚔️ Thor (Warrior) VENCEU a batalha!");
                    System.out.println("💀 Merlin (Wizard) foi derrotado!");
                }
                break;
            }
        }

        scanner.close();
    }
}