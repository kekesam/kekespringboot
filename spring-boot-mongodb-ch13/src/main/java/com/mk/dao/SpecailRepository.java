package com.mk.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mk.bean.Special;

/**
 * 
 * 查询规则 根据实体类中的属性进行查询： 当需要根据实体类中的属性查询时，MongoRepository提供的方法已经不能满足，
 * 我们需要在PersonRepository仓库中定义方法， 定义方法名的规则为：find + By + 属性名（首字母大写），如：根据姓名查询Person
 *
 */
@Repository
public interface SpecailRepository extends MongoRepository<Special, String> {

	public Special findBySid(String sid);

	public Special findByTitle(String title);

	/**
	 * 
	 * 5）根据实体类中的属性进行模糊查询： 当需要根据实体类中的属性进行模糊查询时，我们也需要在PersonRepository仓库中定义方法，
	 * 模糊查询定义方法名的规则为：find + By + 属性名（首字母大写） + Like，如：根据姓名进行模糊查询Person
	 */
	public List<Special> findByTitleLike(String title);
	
	public int countByTitleLike(String title);

	/**
	 * 6:根据实体类中的属性进行模糊查询带分页：
	 * 带分页的模糊查询，其实是把模糊查询以及分页进行合并，同时我们也需要在PersonRepository仓库中定义方法，
	 * 定义方法名的规则和模糊查询的规则一致，只是参数不同而已。
	 * 
	 */
	public Page<Special> findByTitleLike(String title, Pageable pageable);

	/*
	 * 根据实体类中的属性进行模糊查询带分页，同时指定返回的键（数据库中的key,实体类中的属性）：
	 * 解释一下什么是指定返回的键：也就是说当我们进行带分页的模糊查询时，不想返回数据库中的所有字段，只是返回一部分字段。例如：
	 * 只返回Person中的id和name，不返回age. 若想指定返回的键，我们需要在PersonRepository中添加方法，同时使用注解@Query。
	 * 仓库中定义的方法：
	 */
	// @Query(value="{'name':?0}",fields="{'name':1}")
	// public Page<Special> findByTitleLike(String name,Pageable pageable);
	/*
	 * 其中value是查询的条件，？0这个是占位符，对应着方法中参数中的第一个参数，如果对应的是第二个参数则为？1。fields是我们指定的返回字段，
	 * 其中id是自动返回的，不用我们指定，bson中{'name':1}的1代表true，也就是代表返回的意思。 在service中对仓库中的方法的调用：
	 */

	/**
	 * 1）需要查询所有数据，同时指定返回的键
	 * 当我们需要查询所有数据，同时需要指定返回的键时，则不能使用仓库中自带的findAll（）方法了。我们可以查询所有id不为空的数据，同时指定返回的键。当我们需要根据一个key且该key不为空进行查询，方法名的定义规则为：find
	 * + By + 属性名（首字母大写） + NotNull。 仓库中定义的方法：
	 **/
	@Query(value = "{'_id':{'$ne':null}}", fields = "{'name':1}")
	public Page<Special> findByIdNotNull(Pageable pageable);
	/*
	 * 2）MongoDB的其他查询不一一列举，但将java中的仓库定义的方法名的规则列举如下，使用时将仓库中方法上的注解@
	 * Query中的value进行适当泰欧正即可。 GreaterThan(大于) 方法名举例：findByAgeGreaterThan(int age)
	 * query中的value举例：{"age" : {"$gt" : age}}
	 * 
	 * LessThan（小于） 方法名举例：findByAgeLessThan(int age) query中的value举例：{"age" : {"$lt"
	 * : age}}
	 * 
	 * Between（在...之间） 方法名举例：findByAgeBetween(int from, int to)
	 * query中的value举例：{"age" : {"$gt" : from, "$lt" : to}}
	 * 
	 * Not（不包含） 方法名举例：findByNameNot(String name) query中的value举例：{"age" : {"$ne" :
	 * name}}
	 * 
	 * Near（查询地理位置相近的） 方法名举例：findByLocationNear(Point point)
	 * query中的value举例：{"location" : {"$near" : [x,y]}}
	 * 
	 * 
	 * 
	 */
	
	
	
	/**
	 * 
	 * GreaterThan(大于) 
findByAgeGreaterThan(int age) 
{"age" : {"$gt" : age}}     大于等于用'$gte'表示
LessThan（小于） 
findByAgeLessThan(int age) 
{"age" : {"$lt" : age}}     小于等于用'$lte'表示
Between（在...之间） 
findByAgeBetween(int from, int to) 
{"age" : {"$gt" : from, "$lt" : to}}
IsNotNull, NotNull（是否非空） 
findByFirstnameNotNull() 
{"age" : {"$ne" : null}}
IsNull, Null（是否为空） 
findByFirstnameNull() 
{"age" : null}
Like（模糊查询） 
findByFirstnameLike(String name) 
{"age" : age} ( age as regex)
(No keyword) findByFirstname(String name) 
{"age" : name}
Not（不包含） 
findByFirstnameNot(String name) 
{"age" : {"$ne" : name}}
Near（查询地理位置相近的） 
findByLocationNear(Point point) 
{"location" : {"$near" : [x,y]}}
Within（在地理位置范围内的） 
findByLocationWithin(Circle circle) 
{"location" : {"$within" : {"$center" : [ [x, y], distance]}}}
Within（在地理位置范围内的） 
findByLocationWithin(Box box) 
{"location" : {"$within" : {"$box" : [ [x1, y1], x2, y2]}}}
尽管以上查询功能已经很丰富，但如果还不能满足使用情况的话可以用一下方法---基于mongodb原本查询语句的查询方式。
例：在原接口中加入
@Query("{ 'name':{'$regex':?2,'$options':'i'}, sales': {'$gte':?1,'$lte':?2}}")  
public Page<Product> findByNameAndAgeRange(String name,double ageFrom,double ageTo,Pageable page);  
注释Query里面的就是mongodb原来的查询语法，我们可以定义传进来的查询参数，通过坐标定义方法的参数。
还可以在后面指定要返回的数据字段，如上面的例子修改如下，则只通过person表里面的name和age字段构建person对象。 
@Query(value="{ 'name':{'$regex':?2,'$options':'i'}, sales':{'$gte':?1,'$lte':?2}}",fields="{ 'name' : 1, 'age' : 1}")   
public Page<Product> findByNameAndAgeRange(String name,double ageFrom,double ageTo,Pageable page);  
	 */

}