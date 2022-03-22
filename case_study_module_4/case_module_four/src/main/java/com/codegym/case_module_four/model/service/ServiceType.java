package com.codegym.case_module_four.model.service;


import javax.persistence.*;
import java.util.List;

@Entity(name = "service_type")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "serviceType",cascade = CascadeType.ALL)
    private List<Services> services;

    public ServiceType() {
    }

    public ServiceType(int id, String name, List<Services> services) {
        this.id = id;
        this.name = name;
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

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

}
