package com.codegym.case_module_four.model.service;

import javax.persistence.*;
import java.util.List;

@Entity(name = "rental_type")
public class RentalType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_type_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private double cost;

    @OneToMany(mappedBy = "rentalType",cascade = CascadeType.ALL)
    private List<Services> services;

    public RentalType() {
    }

    public RentalType(int id, String name, double cost, List<Services> services) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.services = services;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }
}
