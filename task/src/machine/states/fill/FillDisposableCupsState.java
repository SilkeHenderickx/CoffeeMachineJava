package machine.states.fill;

import machine.CoffeeMachine;

public class FillDisposableCupsState implements FillState{
    private final CoffeeMachine coffeeMachine;

    public FillDisposableCupsState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void askQuestion() {
        System.out.println("Write how many disposable cups do you want to add: ");
    }

    @Override
    public void handleUserInput(int amount) {

        coffeeMachine.disposableCups += amount;
    }
}
