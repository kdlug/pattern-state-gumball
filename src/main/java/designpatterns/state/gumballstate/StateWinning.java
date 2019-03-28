package designpatterns.state.gumballstate;

public class StateWinning implements State {
    private GumballMachine gumballMachine;

    public StateWinning(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You can't insert more than one coin. Please wait for a gum.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Sorry, you can't eject a coin after you turned the crank. ");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned the crank again.");
    }

    @Override
    public void dispenseGum() {
        System.out.println("Congratulations! You've won an extra gum!");

        gumballMachine.releaseGum();

        if (gumballMachine.getCount() > 0) {
            gumballMachine.releaseGum();
            gumballMachine.setState(gumballMachine.getStateNoCoin());
        } else {
            System.out.println("Ups! There is no gum");
            gumballMachine.setState(gumballMachine.getStateNoGum());
        }
    }

    @Override
    public String toString() {
        return "GUM_WINNING";
    }
}
