package io.ryanpro.jpaidgentest;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "test_entity")
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}