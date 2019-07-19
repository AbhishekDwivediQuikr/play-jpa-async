package models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "person", schema = "reward_sys")

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public Person(){}

    public Person(String name)
    {
        this.name = name;
    }

    @OneToMany(mappedBy = "person",cascade = CascadeType.MERGE)
    private List<Vehicle> vehicleList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
