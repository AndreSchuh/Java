package br.andre.estudos.polimorfismo;


// Carros específicos com habilidades diferentes
class SportsCar extends Car implements CarSpecialSkill {
    private boolean turboMode;

    public SportsCar(String model, String color) {
        super(model, color);
        this.turboMode = false;
    }

    @Override
    public void accelerate(int increment) {
        speed += turboMode ? increment * 2 : increment;
        System.out.println("Carro esportivo acelerando!");
    }

    @Override
    public void performSpecialSkill() {
        turboMode = !turboMode;
        System.out.println("Modo turbo " + (turboMode ? "ATIVADO!" : "desativado."));
    }
}