package machine.states;

import machine.CoffeeMachine;
import machine.states.fill.*;

import java.util.ArrayList;
import java.util.List;

public class FillCoffeeMachineState implements CoffeeMachineState{

    private final CoffeeMachine coffeeMachine;
    private final List<FillState> fillStates;
    private int index;

    public FillCoffeeMachineState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;

        fillStates = new ArrayList<>();
        fillStates.add(new FillWaterState(coffeeMachine));
        fillStates.add(new FillMilkState(coffeeMachine));
        fillStates.add(new FillCoffeeBeansState(coffeeMachine));
        fillStates.add(new FillDisposableCupsState(coffeeMachine));

        index = 0;
    }

    @Override
    public void askQuestion() {
        fillStates.get(index).askQuestion();
    }

    @Override
    public void handleUserInput(String input) {
        int amount = Integer.parseInt(input);
        fillStates.get(index).handleUserInput(amount);
        if (index < fillStates.size()-1) index++;
        else coffeeMachine.coffeeMachineState = new AwaitingActionCoffeeMachineState(coffeeMachine);
    }
}
