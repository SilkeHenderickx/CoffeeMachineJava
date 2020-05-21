package machine.states;

public interface CoffeeMachineState {

    void askQuestion();
    void handleUserInput(String input);
}
