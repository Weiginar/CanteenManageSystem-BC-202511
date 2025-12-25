package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 营业额信息：(TurnoverInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "TurnoverInformation")
public class TurnoverInformation implements Serializable {

    // TurnoverInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "turnover_information_id")
    private Integer turnover_information_id;

    // 标题名称
    @Basic
    private String title_name;
    // 营业日期
    @Basic
    private Timestamp business_date;
    // 营业金额
    @Basic
    private Integer business_amount;
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
