package designpatterns.state.gumballstate;

public class StateNoCoin implements State{
    // composition
    GumballMachine gumballMachine;

    public StateNoCoin(GumballMachine gumballMachine) {
        // set context
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You inserted a coin");
        // change state of machine
        gumballMachine.setState(gumballMachine.getStateHasCoin());
    }

    @Override
    public void ejectCoin() {
        System.out.println("Please insert a coin first.");
    }

    @Override
    public void turnCrank() {
        System.out.println("Please insert a coin first.");
    }

    @Override
    public void dispenseGum() {
        System.out.println("Please insert a coin first.");
    }

    @Override
    public String toString() {
        return "NO_COIN";
    }
}
