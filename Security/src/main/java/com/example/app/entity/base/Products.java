package com.example.app.entity.base;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "base_id")
    private Long id;
    @Column(name = "name" , nullable = false)
    private String name;
    @Column(name = "image", nullable = false,length = Integer.MAX_VALUE)
    private String image;
    @Column(name = "price" , nullable = false)
    private double price;
    @Column(name = "title", nullable = false)
    private String title;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_Date", nullable = false)
    private Date createDate;
    @Column(name = "gift")
    private double gift; // Quà tặng
    @Column(name = "discount")
    private double discount; // Giảm giá.

    @Transient
    private MultipartFile[] logoFiles;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private BrandBase brandBase;

}
