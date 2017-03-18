package org.pensionplan.pensionplan;

/**
 * Created by owner on 2/5/2017.
 */
public class Trustees {
    private String name;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Trustees(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Trustees() {
    }
}
