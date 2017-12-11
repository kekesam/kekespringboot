package com.mk.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mk.bean.User;
import java.lang.String;
import java.util.List;

public interface IUserRespository extends JpaRepository<User, Long>{

	public List<User> findByUsername(String username);
}
