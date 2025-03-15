package com.Ioan.jobportal.entity;


import jakarta.persistence.*;

@Entity
public class JobCompany {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String name;
    private String logo;

    public JobCompany() {
    }

    public JobCompany(Integer id, String name, String logo) {
        Id = id;
        this.name = name;
        this.logo = logo;
    }

    public Integer getId() {
        return Id;
    }

    public JobCompany setId(Integer id) {
        Id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public JobCompany setName(String name) {
        this.name = name;
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public JobCompany setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    @Override
    public String toString() {
        return "JobCompany{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
