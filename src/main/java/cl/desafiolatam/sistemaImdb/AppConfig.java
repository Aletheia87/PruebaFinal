package cl.desafiolatam.sistemaImdb;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("cl.desafiolatam.sistemaImdb")
@PropertySource("classpath:database.properties")
public class AppConfig {

	@Autowired
	Environment ambiente;

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setUrl(ambiente.getProperty("url"));
		dmds.setUsername(ambiente.getProperty("user"));
		dmds.setPassword(ambiente.getProperty("password"));
		dmds.setDriverClassName(ambiente.getProperty("driver"));
		return dmds;
	}

}
