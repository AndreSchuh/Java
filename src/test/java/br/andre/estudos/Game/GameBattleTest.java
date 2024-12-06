package br.andre.estudos.Game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameBattleTest {

    @Test
    void battleScenarioTest(){
        Warrior warrior = new Warrior("Thor", 100, 30);
        Wizard wizard = new Wizard("Merlin", 50, 20);

        while (warrior.isAlive() && wizard.isAlive()) {
            warrior.attack(wizard);
            if (!wizard.isAlive()) break;

            wizard.attack(warrior);
        }

        assertTrue(warrior.isAlive() || wizard.isAlive());
    }
}

