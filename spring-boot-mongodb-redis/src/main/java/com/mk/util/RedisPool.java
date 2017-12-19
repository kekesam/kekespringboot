package com.mk.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


public class RedisPool {

	private static JedisPool pool;//jedis连接池
	private static Integer maxTotal = 20;//最大连接数
	private static Integer maxIdle = 10;//最大的空闲的jedis个数
	private static Integer minIdle = 2;//最小的空闲的jedis个数
	private static Boolean testOnBorrow = true;//从jedis连接池获取连接时，校验并返回可用的连接
	private static Boolean testOnReturn = false;//把连接返回jedis连接池获取连接时，校验并返回可用的连接
	
	
	//redis的连接信息
	private static String host = "192.168.0.103";
	private static int port = 6379;
	private static String password = "xiaoer1986";
	private static int timeout = 1000*3;
	
	
	public static void initPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(maxIdle);
		config.setMaxTotal(maxTotal);
		config.setMinIdle(minIdle);
		config.setTestOnBorrow(testOnBorrow);
		config.setTestOnReturn(testOnReturn);
		//连接耗尽的时候，是否阻塞，false超过报出异常。true一直阻塞直到超时。
		config.setBlockWhenExhausted(true);
		pool = new JedisPool(config,host,port,timeout,password);
	}
	
	static{
		initPool();
	}
	
	//获取jedis对象
	public static Jedis getJedis() {
		return pool.getResource();
	}
	
	public static void closeJedis(Jedis jedis) {
		jedis.close();
	}
	
	public static void main(String[] args) {
		Jedis jedis = getJedis();
		jedis.set("age", "30");
	    jedis.set("password", "123456");
		closeJedis(jedis);
	}
}
