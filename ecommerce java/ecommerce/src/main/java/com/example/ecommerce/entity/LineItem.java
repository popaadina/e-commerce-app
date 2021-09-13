package com.example.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "lineItem")
@Data
@JsonIgnoreProperties(value = {"order"})
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int lineItemId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private Order order;

    @Column
    private int price;

    @Column
    @Basic(optional = false)
    private String name;


}
