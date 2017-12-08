package com.mk.bean;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor//无参构造器
@AllArgsConstructor//所有属性的构造器
@ToString(of={"id","title"})
@EqualsAndHashCode(of= {"id","title"})
public class HashCodeEqualsDemo {
	private String id;
	private String title;
	private String img;
	private Long createtime;
	private Integer status;
}