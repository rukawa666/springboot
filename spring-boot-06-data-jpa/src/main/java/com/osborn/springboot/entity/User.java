package com.osborn.springboot.entity;

import javax.persistence.*;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-13 21:45
 *
 * @Entity告诉JPA这是一个实体类(和数据库表映射)
 * @Table来指定和哪个数据表对应；如果省略默认表名就是user
 * @Id标注是一个主键
 * @GeneratedValue表示自增主键
 * @Column标注数据库对应字段，省略情况下默认列名就是属性名
 *
 */
//使用JPA注解配置映射关系
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "email")
    private String email;

    public User(Integer id, String lastName, String email) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
