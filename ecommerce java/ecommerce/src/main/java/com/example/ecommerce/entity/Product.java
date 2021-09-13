package com.example.ecommerce.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Accessors(chain = true)
@NoArgsConstructor
@Table
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Basic(optional = false)
    private String name;

    @Column
    private String description;

    @Column
    private int price;

//    @Column
//    private boolean available;

    @Column
    private String pictureUrl;

}
