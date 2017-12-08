package com.mk.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.bean.Special;
import com.mk.dao.SpecailRepository;

@Controller
public class SpecialController {

	@Autowired
	private SpecailRepository specialDao;
	// @Autowired
	// private MongoTemplate mongoTemplate;

	// 修改和保存
	@ResponseBody
	@GetMapping("/save")
	public String index() {
		Special special = new Special();
		// special.setId("5a223c633dd06603b4ec4484");
		special.setTitle("kekesamspring boot 整合mongodb");
		special.setImg("xxxx.jpg");
		special.setStatus(1);
		special.setCreatetime(new Date().getTime());
		// specialDao.save(special);
		specialDao.insert(special);
		// insert和save的区别是：insert就仅仅是保存，如果是save,没有ID的时候就保存，否则就更新。
		return "success";
	}

	// 修改和保存
	@ResponseBody
	@GetMapping("/find")
	public List<Special> find() {
		List<Special> specials = specialDao.findAll();
		return specials;
	}
	
	@ResponseBody
	@GetMapping("/count")
	public int count() throws Exception {
		long size = specialDao.count();
		int count = Integer.valueOf(String.valueOf(size));
		return count;
	}

	@ResponseBody
	@GetMapping("/get/{id}")
	public Special get(@PathVariable("id")String id) {
		Special special = specialDao.findBySid(id);
		return special;
	}

	// http://localhost:8080/page/1/2
	// http://localhost:8080/page/2/2
	@ResponseBody
	@GetMapping("/page/{page}/{rows}")
	public Page<Special> queryAllByPage(@PathVariable("page") int page, @PathVariable("rows") int rows)
			throws Exception {
		QPageRequest pageRequest = new QPageRequest(page - 1, rows);
		return specialDao.findAll(pageRequest);
	}

	@ResponseBody
	@GetMapping("/findlike/{title}")
	public List<Special> findlike(@PathVariable("title")String title) throws Exception {
		return specialDao.findByTitleLike(title);
	}
	
	@ResponseBody
	@GetMapping("/countlike/{title}")
	public int countlike(@PathVariable("title")String title) throws Exception {
		return specialDao.countByTitleLike(title);
	}
}
