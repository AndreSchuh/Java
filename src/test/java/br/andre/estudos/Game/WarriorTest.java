package br.andre.estudos.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    private Warrior warrior;
    private Wizard wizard;

    @BeforeEach
    void setUp(){
        warrior = new Warrior("Thor", 200, 30);
        wizard = new Wizard("Merlin", 150, 40);
    }

    @Test
    void attackTest(){
        int saudeInicialWizard = wizard.saude;

        warrior.attack(wizard);

        assertTrue(wizard.saude < saudeInicialWizard);
        assertTrue(wizard.saude >= 0);
    }

    @Test
    void performSpecialMoveTest(){
        int poderInicial = warrior.poder;

        warrior.performSpecialMove();

        assertEquals(poderInicial * 2, warrior.poder);
    }

    @Test
    void isAliveTest(){
        warrior.saude = 0;
        assertFalse(warrior.isAlive());

        warrior.saude = 100;
        assertTrue(warrior.isAlive());
    }
}
