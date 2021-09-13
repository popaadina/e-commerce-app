package com.example.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;

    @Column
    private String status;


    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<LineItem> lineItems = new ArrayList<>();

}
