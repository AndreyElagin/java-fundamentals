package javase02.t02;

import javase02.t03.StationeryProduct;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by daddyingrave on 26/06/2017.
 */
public class Employee {

    private String name;
    private Set<StationeryProduct> workplace;

    public Employee(String name) {
        workplace = new HashSet<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<StationeryProduct> getWorkplace() {
        return workplace;
    }

    public Employee addSupply(StationeryProduct supply) {
        workplace.add(supply);
        return this;
    }

}
