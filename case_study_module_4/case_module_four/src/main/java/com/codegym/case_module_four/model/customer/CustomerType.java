package com.codegym.case_module_four.model.customer;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customer_type")
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    private Integer id;
    @Column(name = "customer_type_name")
    private String nameType;

    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL)
    private List<Customer> customers;


    public CustomerType() {
    }

    public CustomerType(Integer id, String nameType, List<Customer> customers) {
        this.id = id;
        this.nameType = nameType;
        this.customers = customers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String name) {
        this.nameType = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
