package machine.states;

import machine.CoffeeMachine;

public class BuyCoffeeMachineState implements CoffeeMachineState {

    private final CoffeeMachine coffeeMachine;

    public BuyCoffeeMachineState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void askQuestion() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
    }

    @Override
    public void handleUserInput(String input) {
        buyCoffee(input);
        coffeeMachine.coffeeMachineState = new AwaitingActionCoffeeMachineState(coffeeMachine);
    }

    private void buyCoffee(String coffeeType){

        switch (coffeeType){
            case "BACK":
                break;
            case "1": //espresso
                handleEspresso();
                break;
            case "2": //latte
                handleLatte();
                break;
            case "3": //cappuccino
                handleCappuccino();
                break;
        }
    }

    private void handleCappuccino() {
        if(hasEnoughCups() && hasEnoughWater(200) && hasEnoughMilk(100) && hasEnoughCoffeeBeans(12)){
            System.out.println("I have enough resources, making you a coffee!");
            coffeeMachine.water -= 200;
            coffeeMachine.milk -= 100;
            coffeeMachine.coffeeBeans -= 12;
            coffeeMachine.money += 6;
            coffeeMachine.disposableCups -= 1;
        }
    }

    private void handleLatte() {
        if(hasEnoughCups() && hasEnoughWater(350) && hasEnoughMilk(75) && hasEnoughCoffeeBeans(20)){
            System.out.println("I have enough resources, making you a coffee!");
            coffeeMachine.water -= 350;
            coffeeMachine.milk -= 75;
            coffeeMachine.coffeeBeans -= 20;
            coffeeMachine.money += 7;
            coffeeMachine.disposableCups -= 1;
        }
    }

    private void handleEspresso() {
        if(hasEnoughCups() && hasEnoughWater(250) && hasEnoughCoffeeBeans(16)){
            System.out.println("I have enough resources, making you a coffee!");
            coffeeMachine.water -= 250;
            coffeeMachine.coffeeBeans -= 16;
            coffeeMachine.money += 4;
            coffeeMachine.disposableCups -= 1;
        }
    }

    private boolean hasEnoughWater(int water){
        if(coffeeMachine.water < water){
            System.out.println("Sorry, not enough water!");
            return false;
        }
        return true;
    }

    private boolean hasEnoughCups(){
        if(coffeeMachine.disposableCups < 1){
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        return true;
    }

    private boolean hasEnoughMilk(int milk){
        if(coffeeMachine.milk < milk){
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        return true;
    }

    private boolean hasEnoughCoffeeBeans(int coffeeBeans){
        if(coffeeMachine.coffeeBeans < coffeeBeans){
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        return true;
    }
}
