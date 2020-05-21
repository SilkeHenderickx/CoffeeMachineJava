package machine.states.fill;

import machine.CoffeeMachine;

public class FillWaterState implements FillState{
    private final CoffeeMachine coffeeMachine;

    public FillWaterState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void askQuestion() {
        System.out.println("Write how many ml of water do you want to add: ");
    }

    @Override
    public void handleUserInput(int amount) {

        coffeeMachine.water += amount;
    }
}
