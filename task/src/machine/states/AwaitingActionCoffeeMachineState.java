package machine.states;

import machine.CoffeeMachine;
import machine.State;

public class AwaitingActionCoffeeMachineState implements CoffeeMachineState {

    private final CoffeeMachine coffeeMachine;

    public AwaitingActionCoffeeMachineState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void askQuestion() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    @Override
    public void handleUserInput(String input) {
        handleAwaitingAction(input);
    }

    private void handleAwaitingAction(String coffeeMachineAction) {
        switch (coffeeMachineAction) {
            case "EXIT":
                System.exit(0);
                break;
            case "BUY":
                coffeeMachine.coffeeMachineState = new BuyCoffeeMachineState(coffeeMachine);
                break;
            case "FILL":
                coffeeMachine.coffeeMachineState = new FillCoffeeMachineState(coffeeMachine);
                break;
            case "TAKE":
                takeMoney();
                break;
            case "REMAINING":
                printCoffeeMachineContents();
                break;
        }
    }

    private void takeMoney(){

        System.out.println("I gave you $" + coffeeMachine.money);
        coffeeMachine.money = 0;

    }

    private void printCoffeeMachineContents(){
        System.out.println("The coffee machine has:");
        System.out.println(coffeeMachine.water + " of water");
        System.out.println(coffeeMachine.milk + " of milk");
        System.out.println(coffeeMachine.coffeeBeans + " of coffee beans");
        System.out.println(coffeeMachine.disposableCups + " of disposable cups");
        System.out.println(coffeeMachine.money + " of money");
    }
}
