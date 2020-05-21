package machine;

import machine.states.AwaitingActionCoffeeMachineState;
import machine.states.CoffeeMachineState;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args){

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            coffeeMachine.askQuestion();
            coffeeMachine.handleUserInput(scanner.next());
        }
    }

    public int water;
    public int milk;
    public int coffeeBeans;
    public int disposableCups;
    public int money;
    public CoffeeMachineState coffeeMachineState;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.disposableCups = 9;
        this.money = 550;
        this.coffeeMachineState = new AwaitingActionCoffeeMachineState(this);
    }


    public void askQuestion() {
        coffeeMachineState.askQuestion();
    }

    public void handleUserInput(String userInput){
        String upperCaseUserInput = userInput.toUpperCase();
        coffeeMachineState.handleUserInput(upperCaseUserInput);

    }
}
