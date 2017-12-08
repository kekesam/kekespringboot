package com.mk.bean;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor//无参构造器
@AllArgsConstructor//所有属性的构造器
@ToString(exclude="img")//exclude排除属性img的toString的加入
//@EqualsAndHashCode//自动生成hashCode和 eqauls方法。
@EqualsAndHashCode(exclude="img")//判断对img的生成
public class ConstructorDemo {

	private String id;
	private String title;
	private String img;
	private Long createtime;
	private Integer status;
}