package br.andre.estudos.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WizardTest {

    private Warrior warrior;
    private Wizard wizard;

    @BeforeEach
    void setUp(){
        warrior = new Warrior("Thor", 200, 30);
        wizard = new Wizard("Merlin", 150, 40);
    }

    @Test
    void attackTest(){
        int saudeInicialWarrior = warrior.saude;

        wizard.attack(warrior);

        assertTrue(warrior.saude < saudeInicialWarrior);
        assertTrue(warrior.saude >= 0);
    }

    @Test
    void performSpecialMoveTest(){
        int saudeInicial = wizard.poder;

        wizard.performSpecialMove();

        assertTrue(saudeInicial < wizard.saude);
    }

    @Test
    void isAliveTest(){
        wizard.saude = 0;
        assertFalse(wizard.isAlive());

        wizard.saude = 100;
        assertTrue(wizard.isAlive());
    }
}
