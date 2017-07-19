package javase02.t06;

import javase02.t07.SubmarineClass;

/**
 * Created by daddyingrave on 30/06/2017.
 *
 * Task 6. Inner classes
 */
@SubmarineClass(name = "K-3")
public class NuclearSubmarine {

    private boolean inNavigation;
    private EngineForNuclearSubmarine engine;

    public NuclearSubmarine() {
        this.engine = new EngineForNuclearSubmarine();
    }

    public void goNavigation() {
        if (engine.checkIgnition()) {
            inNavigation = true;
        } else {
            engine.turnItOn();
            inNavigation = true;
        }
        System.out.println("We all live in a yellow submarine!");
    }

    public void stopNavigation() {
        inNavigation = false;
        engine.turnItOff();
        System.out.println("Going to sleep...");
    }

    public boolean isInNavigation() {
        return inNavigation;
    }

    private class EngineForNuclearSubmarine {

        private boolean ignitionState;

        public void turnItOn() {
            ignitionState = true;
        }

        public void turnItOff() {
            ignitionState = false;
        }

        public boolean checkIgnition() {
            return ignitionState;
        }

    }

}