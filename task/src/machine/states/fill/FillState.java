package machine.states.fill;

import machine.states.CoffeeMachineState;

public interface FillState {
    void askQuestion();
    void handleUserInput(int amount);
}
