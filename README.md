##spring-boot留言板

项目的目标
	
	1 使用spring写个简单的留言板
	2 尽可能的使用spring的各种配置
	
项目的具体目标
	
	1 添加留言
	2 留言列表

项目的实施
	
	DONE 0 配置多个配置文件
		1 配置任意目录下的文件
		2 配置config下的文件
		3 配置各个环境下的文件
	DONE 0.1 项目启动选用 8888 端口 
	
	DONE 1 给项目加上一个库一点的banner
		在配置里面加上banner.txt 文件即可
		http://patorjk.com/software/taag
		http://www.network-science.de/ascii/
		http://www.degraeve.com/img2txt.php
	
	DONE 1.1 对所有异常进行统一处理
	
	DONE 2 使用log4j2写日志
		1 记录各个级别的日志
		2 了解log4j2的基本的配置
	
	 3 使用Thymeleaf模板引擎渲染数据
	 		基本使用: https://www.cnblogs.com/topwill/p/7434955.html
	
	 4 使用三种方式实现列表和添加的功能
	 
	 	1 JdbcTemplate
	 		1.1 SpringBoot默认采用tomcat-jdbc连接池，如果需要C3P0，DBCP，Druid等作为连接池，需要加入相关依赖以及配置，这里不作说明，采用默认配置即
	 		
	 		1.2 spring会默认读取配置里面的
				 spring.datasource.url						 spring.datasource.username		        spring.datasource.password
			     spring.datasource.driver-class-name
	 		
	 	2 Spring-data-jpa
	 		2.1 与hibernate整合
	 		2.2 与mybaits整合
	 	3 Spring Boot多数据源配置和使用
	 
	 5 
	 
	 9 创建项目的springboot的maven模板
	
todo	
	
	后续整合 
		Dubbo
		RocketMQ
	
	
	
	
	
	
	
	
	
	