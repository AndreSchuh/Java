package br.andre.estudos.polimorfismo;


class ElectricCar extends Car implements CarSpecialSkill {
    private int batteryLevel;

    public ElectricCar(String model, String color) {
        super(model, color);
        this.batteryLevel = 100;
    }

    @Override
    public void accelerate(int increment) {
        if (batteryLevel > 0) {
            speed += increment;
            batteryLevel -= increment / 10;
            System.out.println("Carro elétrico acelerando silenciosamente!");
        } else {
            System.out.println("Bateria baixa. Precisa recarregar!");
        }
    }

    @Override
    public void performSpecialSkill() {
        System.out.println("Recarregando bateria... Nível atual: " + batteryLevel + "%");
        batteryLevel = Math.min(batteryLevel + 20, 100);
    }
}