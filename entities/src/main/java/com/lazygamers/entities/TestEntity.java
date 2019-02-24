package com.lazygamers.entities;

import javax.persistence.*;

@Entity
@Table(name = "test_entities")
@NamedQueries({
    @NamedQuery(name = "Test.findByName", query = "SELECT t FROM TestEntity t WHERE t.name = :name")
})
public class TestEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    
    private String lastName;
    
    private String address;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}
