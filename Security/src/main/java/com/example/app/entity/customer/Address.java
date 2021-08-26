package com.example.app.entity.customer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id; // id quốc gia
    @NotBlank
    @Column(name = "city", nullable = false)
    private String city; // thành phố
    @NotBlank
    @Column(name = "district", nullable = false)
    private String district; // Huyện
    @NotBlank
    @Column(name = "commune", nullable = false)
    private String commune; // Xã
    private String other; // số nhà địa chỉ.

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL) // mappedBy trỏ tới tên biến Address ở trong Person.
    private Collection<Customer> customers;
}
