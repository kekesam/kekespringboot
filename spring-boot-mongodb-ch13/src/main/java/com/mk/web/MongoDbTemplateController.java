package com.mk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mk.bean.Special;

@RestController
public class MongoDbTemplateController {

	 @Autowired
	 private MongoTemplate mongoTemplate;

	 @GetMapping("/count2")
	 public long template() {
		 Query query = new Query();
		 //query.addCriteria(Criteria.where("id").is(id));
		 return mongoTemplate.count(query, Special.class);
	 }
	 
	 
	 @GetMapping("/count3/{title}")
	 public long countlike(@PathVariable("title")String title) {
		 Query query = new Query();
		 query.addCriteria(Criteria.where("title").regex(title));
		 return mongoTemplate.count(query, Special.class);
	 }
	 
	 
	 
}
/*
 * 分页时查找数量：

1
2
3
4
5
6
7
public long countSample(String id) {
        Query query = new Query();
        if (StringUtil.hasText(id))
            query.addCriteria(Criteria.where("creator").is(id));
 
        return mongoTemplate.count(query, Sample.class);
    }
　　分页：

1
2
3
4
5
6
7
8
9
10
11
12
public List<Sample> searchAllSample(String id, PageTag page) {
       Query query = new Query();
       query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "update_date")));
       int skip = (page.getCurrentPage() - 1) * page.getPageSize();
       if (StringUtil.hasText(id)) {
           Criteria criteria = Criteria.where("creator").is(id);
           query.addCriteria(criteria);
       }
       query.skip(skip);// 从那条记录开始
       query.limit(page.getPageSize());// 取多少条记录
       return mongoTemplate.find(query, Sample.class);
   }
　　修改数量：

1
2
3
4
5
6
7
public void modifyHitNumByNo(String no) {
       Query query = new Query();
       query.addCriteria(Criteria.where("sap_no").is(no));
       Update update = new Update();
       update.inc("hit_num", 1);
       mongoTemplate.updateFirst(query, update, Project.class);
   }
　　模糊查询：

1
2
3
4
5
6
7
8
public List<Sample> findSamples(String memberId, SelectVo selectVo) {
       Criteria criteria = Criteria.where("creator").is(memberId);
       if (StringUtil.hasText(selectVo.getName())) {
           Pattern pattern = Pattern.compile("^.*" + selectVo.getName() + ".*$", Pattern.CASE_INSENSITIVE);
           criteria.orOperator(Criteria.where("projectNo").regex(pattern), Criteria.where("name").regex(pattern));
       }
       return findPageList(Query.query(criteria), Sample.class, new PageTag(selectVo.getPage(), selectVo.getPageSize()));
   }
　　一般查询：

1
2
3
4
5
6
7
8
public List<Project> getProjects(String creator) {
        Query query = new Query();
        if (StringUtil.hasText(creator)) {
            Criteria criteria = Criteria.where("creator").is(creator);
            query.addCriteria(criteria);
        }
        return mongoTemplate.find(query, Project.class);
    }
　　

1
2
3
4
5
6
public Experiment getExperimentByExpNo(String expNo) {
       Query query = new Query();
       Criteria criteria = Criteria.where("exp_no").is(expNo);
       query.addCriteria(criteria);
       return mongoTemplate.findOne(query, Experiment.class);
   }
　　

1
2
3
4
5
6
7
8
9
10
11
12
13
public void saveOrUpdateExperiment(Experiment experiment) {
 
      if (StringUtil.hasText(experiment.getExpNo())) {
          Query query = new Query();
          Criteria criteria = Criteria.where("exp_no").is(experiment.getExpNo());
          query.addCriteria(criteria);
          Experiment exp = mongoTemplate.findAndRemove(query, Experiment.class);
          experiment.setCreator(exp.getCreator());
          experiment.setCreateDate(exp.getCreateDate());
      }
 
      mongoTemplate.save(experiment);
  }
 * 
 * 
 * */
