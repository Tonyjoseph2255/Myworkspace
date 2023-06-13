package com.example.snapdeal.entity;




import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
public class DealEntity {
	 @Id
	  //@GeneratedValue(strategy=GenerationType.AUTO)
	public String order_id;
	public String return_reason;
	public Date order_date;
	public Date ship_date;
	public String ship_mode;
	public String product_id;
	public Integer days_to_ship;
	public String category;
	public String sub_category;
	public String product_name;

	

}