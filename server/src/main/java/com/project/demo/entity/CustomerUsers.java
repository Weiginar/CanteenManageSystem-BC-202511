package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 顾客用户：(CustomerUsers)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CustomerUsers")
public class CustomerUsers implements Serializable {

    // CustomerUsers编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_users_id")
    private Integer customer_users_id;

    // 顾客姓名
    @Basic
    private String customer_name;
    // 顾客性别
    @Basic
    private String customer_gender;
    // 顾客年龄
    @Basic
    private String customer_age;












    // 用户编号
    @Id
    @Column(name = "user_id")
    private Integer userId;


    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
