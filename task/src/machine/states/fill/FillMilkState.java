package machine.states.fill;

import machine.CoffeeMachine;

public class FillMilkState implements FillState {
    private final CoffeeMachine coffeeMachine;

    public FillMilkState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void askQuestion() {
        System.out.println("Write how many ml of milk do you want to add: ");
    }

    @Override
    public void handleUserInput(int amount) {

        coffeeMachine.milk += amount;
    }
}
