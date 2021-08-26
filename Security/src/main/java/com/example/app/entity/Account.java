package com.example.app.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "accounts")
public class Account implements Serializable {

    private static final long serialVersionUID = -2054386655979281969L;

    public static final String ROLE_MANAGER = "MANAGER";
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";

    @Id
    @Column(name = "name", columnDefinition = "varchar(50) not null")
    @NotEmpty(message = "Tên không được để trống")
    private String name;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "email", nullable = false, unique = true, length = 45)
    @Email(message = "Email sai định dạng")
    @NotEmpty(message = "Email không được để trống")
    private String email;

    @Column(name = "password", nullable = false, length = 60)
    @NotBlank(message = "Mật khẩu bắt buộc")
    @NotEmpty(message = "Mật khẩu không được để trống")
    @Max( value = 10 ,message = "Mật khẩu tối đa 10 ký tự")
    private String password;

    @Column(name = "address", nullable = false)
    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    @Column(name = "image")
    private String image;

    @Column(name = "role", length = 20, nullable = false)
    private String role;
    @Column(name = "Active", length = 1, nullable = false)
    private boolean active;
}
