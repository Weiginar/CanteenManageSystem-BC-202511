package com.system.canteen.entity;

import java.sql.Timestamp;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 菜品偏好：(DishPreferences)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "DishPreferences")
public class DishPreferences implements Serializable {

    // DishPreferences编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_preferences_id")
    private Integer dish_preferences_id;

    // 菜品名称
    @Basic
    private String dish_name;
    // 男性点餐数
    @Basic
    private Integer number_of_male_orders;
    // 女性点餐数
    @Basic
    private Integer number_of_meals_ordered_by_women;
    // 备注信息
    @Basic
    private String remarks;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
