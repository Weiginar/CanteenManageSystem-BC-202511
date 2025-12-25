package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 菜品信息：(DishInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "DishInformation")
public class DishInformation implements Serializable {

    // DishInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_information_id")
    private Integer dish_information_id;

    // 菜品名称
    @Basic
    private String dish_name;
    // 菜品分类
    @Basic
    private String categorization_of_dishes;
    // 菜品价格
    @Basic
    private Integer price_of_dishes;
    // 菜品食材
    @Basic
    private String dishes_and_ingredients;
    // 菜品口味
    @Basic
    private String taste_of_dishes;
    // 菜品图片
    @Basic
    private String picture_of_dishes;
    // 菜品介绍
    @Basic
    private String introduction_to_dishes;

    // 点击数
    @Basic
    private Integer hits;

    // 点赞数
    @Basic
    private Integer praise_len;












    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
