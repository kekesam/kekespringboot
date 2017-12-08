//package com.mk.dao;
//public class ExamLogDaoImpl implements ExamLogDao{
//	
//	@Autowired
//	private MongoTemplate mongoTemplate;
//	/**
//	 * 进入考试
//	 * return uuid
//	 */
//	@Override
//	public String enterExamLog(Object[] args) {
//		Date date=new Date();
//		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String logUuid=RText.getUUID();//自动生成uuid
//		String enterTime=format.format(date); //系统当前时间
//		Log_Exam_Base examL=new Log_Exam_Base();
//		examL.setLogUuid(logUuid);
//		examL.setExamId(ObjectUtils.toString(args[0], ""));
//		examL.setExamName(ObjectUtils.toString(args[1], ""));
//		examL.setEgid(ObjectUtils.toString(args[2], ""));
//		examL.setUserId(ObjectUtils.toString(args[3], ""));
//		examL.setUserName(ObjectUtils.toString(args[4], ""));
//		examL.setAccount(ObjectUtils.toString(args[5], ""));
//		examL.setClientIp(ServletActionContext.getRequest().getRemoteAddr());
//		examL.setEnterTime(enterTime);
//		mongoTemplate.insert(examL, "ExamLog");//自定义集合名插入文档
//		return logUuid;
//	}
//	
//	/**
//	 * 退出考试
//	 */
//	@Override
//	public void exitExamLog(Object[] args) {
//		Date date=new Date();
//		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String exitTime=format.format(date); //系统当前时间
//		Query query = new Query(Criteria.where("logUuid").is(ObjectUtils.toString(args[0], "")));
//		Update update = new Update().set("exitTime", exitTime);
//		WriteResult r=mongoTemplate.upsert(query, update, "ExamLog");//根据字段修改文档
//		
//	}
//	/**
//	 * 答题操作
//	 */
//
//	@Override
//	public void answerTopicLog(Object[] args) {
//		Date date=new Date();
//		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String exitTime=format.format(date); //系统当前时间
//		Log_Exam_Operation eolM=new Log_Exam_Operation();
//		eolM.setOperationTime(exitTime);
//		eolM.setTopicId(ObjectUtils.toString(args[1], ""));
//		eolM.setTopic(ObjectUtils.toString(args[2], ""));
//		eolM.setAnswer(ObjectUtils.toString(args[3], ""));
//		eolM.setAnswerContent(ObjectUtils.toString(args[4], ""));
//		Query query = Query.query(Criteria.where("logUuid").is(ObjectUtils.toString(args[0], "")));
//        Update update = new Update().addToSet("operation", eolM);
//        WriteResult r=mongoTemplate.upsert(query, update, "ExamLog");//根据某一字段往内嵌文档增加一条数据
//	}
//	/**
//	 * 日志列表
//	 */
//	@Override
//	public PageObject getExamLogPageObject(Object[] args,Map req) {
//		int totalCount = 1;
//		int start = NumberUtils.toInt(ObjectUtils.toString(req.get("start"),"0"));
//		int limit = NumberUtils.toInt(ObjectUtils.toString(req.get("limit"),"25"));
//		List returnValue = null;
//		try {
//			Query query = new Query().limit(limit);//分页条数设置
//			if(args.length>=3){//条件模糊查询
//				if(args[0]!=null&&!"".equals(ObjectUtils.toString(args[0]))){
//					query.addCriteria(new Criteria("account").regex(".*?" + ObjectUtils.toString(args[0]) + ".*"));
//				}
//				if(args[1]!=null&&!"".equals(ObjectUtils.toString(args[1]))){
//					query.addCriteria(new Criteria("userName").regex(".*?" + ObjectUtils.toString(args[1]) + ".*"));
//				}
//				if(args[2]!=null&&!"".equals(ObjectUtils.toString(args[2]))){
//					query.addCriteria(new Criteria("examName").regex(".*?" + ObjectUtils.toString(args[2]) + ".*"));
//				}
//			}
//			query.skip(start);//跳过前start条数据
//			
//			query.sort().on("enterTime", Order.DESCENDING);//按进入时间倒序排序
//			returnValue = mongoTemplate.find(query, Log_Exam_Base.class, "ExamLog");
//			totalCount = (int) mongoTemplate.count(query, "ExamLog");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		PageObject page = new PageObject();
//		page.setDatasource(returnValue);
//		page.setTotalCount(totalCount);
//		
//		int _absolutePage = (int)Math.ceil(totalCount * 1.0/limit);
//		page.setAbsolutePage(_absolutePage);
//		
//		int _currentPage = start/limit + 1;
//		page.setCurrentPage(_currentPage);
//		
//		return page;
//	}
//	@Override
//	public List getExamLogList(Object[] args) {
//		List returnValue = null;
//		try {
//			Query query = new Query().limit(60000);
//			if(args.length>=3){
//				if(args[0]!=null&&!"".equals(ObjectUtils.toString(args[0]))){
//					query.addCriteria(new Criteria("account").regex(".*?" + ObjectUtils.toString(args[0]) + ".*"));
//				}
//				if(args[1]!=null&&!"".equals(ObjectUtils.toString(args[1]))){
//					query.addCriteria(new Criteria("userName").regex(".*?" + ObjectUtils.toString(args[1]) + ".*"));
//				}
//				if(args[2]!=null&&!"".equals(ObjectUtils.toString(args[2]))){
//					query.addCriteria(new Criteria("examName").regex(".*?" + ObjectUtils.toString(args[2]) + ".*"));
//				}
//			}
//			query.sort().on("enterTime", Order.DESCENDING);//按进入时间倒序排序
//			returnValue = mongoTemplate.find(query, Log_Exam_Base.class, "ExamLog");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return returnValue;
//	}
//	/**
//	 * 获取内嵌子文档列表数据
//	 */
//	@Override
//	public PageObject getExamOperation(Object[] args, Map req) {
//		int totalCount = 1;
//		int start = NumberUtils.toInt(ObjectUtils.toString(req.get("start"),"0"));
//		int limit = NumberUtils.toInt(ObjectUtils.toString(req.get("limit"),"25"));
//		
//		List returnValue = null;
//		try {
//			Query query = new Query().limit(limit);
//			query.addCriteria(Criteria.where("logUuid").is(ObjectUtils.toString(args[0], "")));
//			query.skip(start);
//			query.sort().on("operationTime", Order.DESCENDING);//按操作时间倒序排序
//			List exmL = mongoTemplate.find(query, Log_Exam_Base.class, "ExamLog");
//			if(exmL.size()>0){
//				Log_Exam_Base em=(Log_Exam_Base) exmL.get(0);
//				returnValue=em.getOperation();
//			}
//			if(returnValue!=null){
//				totalCount = returnValue.size();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		PageObject page = new PageObject();
//		page.setDatasource(returnValue);
//		page.setTotalCount(totalCount);
//		
//		int _absolutePage = (int)Math.ceil(totalCount * 1.0/limit);
//		page.setAbsolutePage(_absolutePage);
//		
//		int _currentPage = start/limit + 1;
//		page.setCurrentPage(_currentPage);
//		
//		return page;
//	}
//}