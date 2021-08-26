package com.example.app.entity.base;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name = "brand")
public class BrandBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long id;
    @Column(name = "brand", nullable = false)
    private String Brand;

    @OneToMany(mappedBy = "brandBase", cascade = CascadeType.ALL)
    private Collection<Products> products;
}
