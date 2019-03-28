package designpatterns.state.gumball;

public class GumballMachine {
    final static int NO_GUM = 0;
    final static int NO_COIN = 1;
    final static int HAS_COIN = 2;
    final static int GUM_SOLD = 3;

    int state = NO_GUM;
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;

        if (count > 0) {
            state = NO_COIN;
        }
    }

    public void insertCoin() {
        if (state == NO_GUM) {
            System.out.println("You can't insert a coin, gumball machine is sold out");
        } else if (state == NO_COIN) {
            state = HAS_COIN;
            System.out.println("You inserted a coin");
        } else if (state == HAS_COIN) {
            System.out.println("You can't insert more than one coin");
        } else if (state == GUM_SOLD) {
            System.out.println("Please wait for a gumball");
        }
    }

    public void ejectCoin() {
        if (state == NO_GUM) {
            System.out.println("You can't eject a coin, gumball machine is sold out");
        } else if (state == NO_COIN) {
            System.out.println("You can't eject a coin. Insert a coin first,");
        } else if (state == HAS_COIN) {
            state= NO_COIN;
            System.out.println("Coin is ejected.");
        } else if (state == GUM_SOLD) {
            System.out.println("You can't eject a coin. You've just turned crank out");
        }
    }

    public void turnCrank() {
        if (state == NO_GUM) {
            System.out.println("You've turned a crank but you have to insert a coin first.");
        } else if (state == NO_COIN) {
            System.out.println("You've turned a crank but you have to insert a coin first.");
        } else if (state == HAS_COIN) {
            state= GUM_SOLD;
            System.out.println("You've turned a crank, please wait for a gumball");
            dispense();
        } else if (state == GUM_SOLD) {
            System.out.println("You've turned a crank but you can't get a second gumball.");
        }
    }

    private void dispense() {
        if (state == GUM_SOLD) {
            System.out.println("Delivering a gum");
            count = count - 1;

            if (count > 0) {
                state = NO_COIN;
            } else if (count == 0) {
                System.out.println("Sorry, gumball machine is sold out");
                state = NO_GUM;
            }
        } else if (state == NO_GUM) {
            System.out.println("Sorry, gumball machine is sold out");
        } else if (state == NO_COIN) {
            System.out.println("No gumball dispensed");
        } else if (state == HAS_COIN) {
            state = GUM_SOLD;
            System.out.println("No gumball dispensed");
        }
    }
    public void refill(int gumAmount) {
        this.count = count + gumAmount;

        if (count > 0) {
            this.state = NO_COIN;
        } else {
            this.state = NO_GUM;
        }
    }

    public String toString() {
        StringBuffer result = new StringBuffer();

        result.append("Gumball machine ver. 1.0 \n");
        result.append("Amount of gums #" + count + "\n");

        if (state == NO_GUM) {
            result.append("Sorry, gumball machine is sold out");
        } else if (state == NO_COIN) {
            result.append("Waiting for a coin");
        } else if (state == HAS_COIN) {
            result.append("Waiting for turn a crank");
        } else  if (state == GUM_SOLD) {
            result.append("Delivering a gum");
        }

        return result.toString();
    }

}
