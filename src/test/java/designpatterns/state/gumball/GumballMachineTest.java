package designpatterns.state.gumball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GumballMachineTest {
    @Test
    void gumballMachine_GivenCoinAndTurnCrank_ExpectedNoCoinState() {
        GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println(gumballMachine);

        gumballMachine.insertCoin();
        gumballMachine.turnCrank();

        Assertions.assertEquals(gumballMachine.NO_COIN, gumballMachine.state);
    }

    @Test
    void gumballMachine_GivenCoinEjectCoin_ExpectedNoCoinState() {
        GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println(gumballMachine);

        gumballMachine.insertCoin();
        gumballMachine.ejectCoin();

        Assertions.assertEquals(gumballMachine.NO_COIN, gumballMachine.state);
        Assertions.assertEquals(5, gumballMachine.count);
    }

    @Test
    void gumballMachine_GivenCoinAndTurnCrank_ExpectedNoGumState() {
        GumballMachine gumballMachine = new GumballMachine(1);
        System.out.println(gumballMachine);

        gumballMachine.insertCoin();
        gumballMachine.turnCrank();

        Assertions.assertEquals(gumballMachine.NO_GUM, gumballMachine.state);
        Assertions.assertEquals(0, gumballMachine.count);
    }

    @Test
    void gumballMachine_GivenEjectCoin_ExpectedNoCoinState() {
        GumballMachine gumballMachine = new GumballMachine(1);
        System.out.println(gumballMachine);

        gumballMachine.ejectCoin();

        Assertions.assertEquals(gumballMachine.NO_COIN, gumballMachine.state);
    }

    @Test
    void gumballMachine_GivenInsertCoin_ExpectedNoGumState() {
        GumballMachine gumballMachine = new GumballMachine(0);
        System.out.println(gumballMachine);

        gumballMachine.insertCoin();

        Assertions.assertEquals(gumballMachine.NO_GUM, gumballMachine.state);
    }
}
