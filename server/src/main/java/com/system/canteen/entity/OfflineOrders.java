package com.system.canteen.entity;

import java.sql.Timestamp;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 线下订单：(OfflineOrders)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "OfflineOrders")
public class OfflineOrders implements Serializable {

    // OfflineOrders编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offline_orders_id")
    private Integer offline_orders_id;

    // 订单编号
    @Basic
    private String order_number;
    // 菜品名称
    @Basic
    private String dish_name;
    // 菜品分类
    @Basic
    private String categorization_of_dishes;
    // 菜品价格
    @Basic
    private String price_of_dishes;
    // 订单日期
    @Basic
    private Timestamp order_date;
    // 顾客信息
    @Basic
    private Integer customer_information;
    // 顾客姓名
    @Basic
    private String customer_name;
    // 顾客性别
    @Basic
    private String customer_gender;
    // 联系电话
    @Basic
    private String contact_number;
    // 点餐数量
    @Basic
    private Integer order_quantity;
    // 菜品总价
    @Basic
    private String total_price_of_dishes;
    // 点餐备注
    @Basic
    private String order_notes;
    // 订单状态
    @Basic
    private String order_status;




    // 支付状态
    @Basic
    private String pay_state;

    // 支付类型: 微信、支付宝、网银
    @Basic
    private String pay_type;

	// 选座状态
	@Basic
	private String seat;









    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
