package designpatterns.state.gumballstate;

public class GumballMachine {
    // interface type
    State stateNoGum;
    State stateNoCoin;
    State stateHasCoin;
    State stateGumSold;

    private int count = 0;
    // current state
    // interface type
    private State state;

    public GumballMachine(int gumAmount) {
        // creating concrete states
        this.stateNoGum = new StateNoGum(this);
        this.stateNoCoin = new StateNoCoin(this);
        this.stateHasCoin = new StateHasCoin(this);
        this.stateGumSold = new StateGumSold(this);

        this.setCount(gumAmount);

        if (count > 0) {
            this.setState(stateNoCoin);
        } else {
            this.setState(stateNoGum);
        }
    }

    public void insertCoin() {
        state.insertCoin();
    }

    public void ejectCoin() {
        state.ejectCoin();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispenseGum();
    }

    public State getStateNoGum() {
        return stateNoGum;
    }

    public State getStateNoCoin() {
        return stateNoCoin;
    }

    public State getStateHasCoin() {
        return stateHasCoin;
    }

    public State getStateGumSold() {
        return stateGumSold;
    }

    /**
     * Helper method
     */
    public void releaseGum() {
        System.out.println("Releasing a gum");
        if (count > 0) {
            count = count - 1;
        }
    }

    public int getCount() {
        return count;
    }

    public State getState() {
        return state;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setState(State state) {
        this.state = state;
    }


    public String toString() {
        StringBuffer result = new StringBuffer();

        result.append("Gumball machine ver. 1.0 \n");
        result.append("Amount of gums #" + count + "\n");
        result.append("State #" + state + "\n");

        return result.toString();
    }
}
