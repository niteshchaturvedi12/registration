package com.modulobytes.registration.models;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;
    private String name;
    public Role() {
    }
    public Role(String name) {
        this.name = name;
    }

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

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Role [name=").append(name).append("]").append(" [id=").append(id).append("]");
        return builder.toString();
    }
}
