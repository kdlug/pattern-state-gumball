package designpatterns.state.gumballstate;

public class StateHasCoin implements State {
    private GumballMachine gumballMachine;

    public StateHasCoin(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You can't insert more than one coin.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Coin ejected.");
        gumballMachine.setState(gumballMachine.stateNoCoin);
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned crank...");
        gumballMachine.setState(gumballMachine.getStateGumSold());
    }

    @Override
    public void dispenseGum() {
        System.out.println("Please turn the crank first.");
    }


    @Override
    public String toString() {
        return "HAS_COIN";
    }
}
