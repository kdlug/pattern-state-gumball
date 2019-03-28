package designpatterns.state.gumballstate;

public class StateNoGum implements State {
    private GumballMachine gumballMachine;

    public StateNoGum(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Sorry, gumball machine is empty!");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Sorry, gumball machine is empty!");
    }

    @Override
    public void turnCrank() {
        System.out.println("Sorry, gumball machine is empty!");
    }

    @Override
    public void dispenseGum() {
        System.out.println("Sorry, gumball machine is empty!");
    }

    @Override
    public String toString() {
        return "NO_GUM";
    }
}
