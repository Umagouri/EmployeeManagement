package com.flm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.flm")
@EnableWebMvc
@EnableTransactionManagement
public class Configs {
        
	@Bean
	  public  LocalSessionFactoryBean localsessionfactorybean() {
		    LocalSessionFactoryBean ls=new LocalSessionFactoryBean();
		    DataSource datasource=datasource();
		        ls.setDataSource(datasource);
		        ls.setPackagesToScan("com.flm");
		        ls.setHibernateProperties(hibernateProperties());
		        return ls;    
	  }
	
	  @Bean
	  public DataSource datasource() {
		    DriverManagerDataSource dmds=new DriverManagerDataSource();
		           dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		           dmds.setUrl("jdbc:mysql://127.0.0.1:3306/projects");
		           dmds.setUsername("root");
		           dmds.setPassword("password");
                    return dmds;		    
	  }
	  
	  @Bean
	  public Properties hibernateProperties() {
		    Properties props=new Properties();
		    props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		    props.setProperty("hibernate.show_sql","true");
		    props.setProperty("hibernate.hbm2ddl.auto","update");
		    return props;
	  }
	  
	  @Bean
	  public org.springframework.orm.hibernate5.HibernateTransactionManager hibernatetransactionmanager(SessionFactory sessionfactory) {
		  HibernateTransactionManager tm=new HibernateTransactionManager();
		  tm.setSessionFactory(sessionfactory);
		  return tm;
		  
	  }
	  
	    @Bean
	   public InternalResourceViewResolver InternalResourceViewResolver() {
		    InternalResourceViewResolver irvr=new InternalResourceViewResolver();
		     irvr.setPrefix("/WEB-INF/views/");
		     irvr.setSuffix(".jsp");
			return irvr;
		    
	   }
}
