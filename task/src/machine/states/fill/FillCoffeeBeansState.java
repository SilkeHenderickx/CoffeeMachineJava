package machine.states.fill;

import machine.CoffeeMachine;

public class FillCoffeeBeansState implements FillState{
    private final CoffeeMachine coffeeMachine;

    public FillCoffeeBeansState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void askQuestion() {
        System.out.println("Write how many grams of coffee beans do you want to add: ");
    }

    @Override
    public void handleUserInput(int amount) {

        coffeeMachine.coffeeBeans += amount;
    }
}
