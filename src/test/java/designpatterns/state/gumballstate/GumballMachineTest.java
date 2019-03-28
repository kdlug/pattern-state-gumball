package designpatterns.state.gumballstate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GumballMachineTest {
    @Test
    void gumballMachine_GivenCoinAndTurnCrank_ExpectedNoCoinState() {
        GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println(gumballMachine);

        gumballMachine.insertCoin();
        gumballMachine.turnCrank();

        Assertions.assertEquals(gumballMachine.getStateNoCoin(), gumballMachine.getState());
    }

    @Test
    void gumballMachine_GivenCoinEjectCoin_ExpectedNoCoinState() {
        GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println(gumballMachine);

        gumballMachine.insertCoin();
        gumballMachine.ejectCoin();

        Assertions.assertEquals(gumballMachine.getStateNoCoin(), gumballMachine.getState());
        Assertions.assertEquals(5, gumballMachine.getCount());
    }

    @Test
    void gumballMachine_GivenCoinAndTurnCrank_ExpectedNoGumState() {
       GumballMachine gumballMachine = new GumballMachine(1);
        System.out.println(gumballMachine);

        gumballMachine.insertCoin();
        gumballMachine.turnCrank();

        Assertions.assertEquals(gumballMachine.getStateNoGum(), gumballMachine.getState());
        Assertions.assertEquals(0, gumballMachine.getCount());
    }

    @Test
    void gumballMachine_GivenEjectCoin_ExpectedNoCoinState() {
        GumballMachine gumballMachine = new GumballMachine(1);
        System.out.println(gumballMachine);

        gumballMachine.ejectCoin();

        Assertions.assertEquals(gumballMachine.getStateNoCoin(), gumballMachine.getState());
    }

    @Test
    void gumballMachine_GivenInsertCoin_ExpectedNoGumState() {
        GumballMachine gumballMachine = new GumballMachine(0);
        System.out.println(gumballMachine);

        gumballMachine.insertCoin();

        Assertions.assertEquals(gumballMachine.getStateNoGum(), gumballMachine.getState());
    }
}
