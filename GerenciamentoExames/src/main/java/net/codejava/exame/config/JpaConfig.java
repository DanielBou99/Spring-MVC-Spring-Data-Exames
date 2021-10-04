package net.codejava.exame.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableJpaRepositories(basePackages = {"net.codejava.exame"}) // Indica aonde o Spring DATA encontra os Repositórios
@EnableTransactionManagement // Permite que o Spring utilize o gerenciamento de transação
public class JpaConfig {

	    @Bean
	    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(entityManagerFactory);
	        return transactionManager;
	    } 
		
		@Bean
		public DataSource datasource() { // Configurações do BD
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName( "com.mysql.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/exames?useSSL=false&serverTimezone=UTC");
			ds.setUsername("root");
			ds.setPassword("admin");
			return ds;
		}
		
		@Bean(name= "entityManagerFactory")
		public LocalContainerEntityManagerFactoryBean  entityManagerFactoryBean(DataSource ds ) { // Configurações da JPA
			LocalContainerEntityManagerFactoryBean  emfb = new LocalContainerEntityManagerFactoryBean ();
			emfb.setDataSource(ds);
			emfb.setPackagesToScan("net.codejava.exame");
			emfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
			Properties jpaProterties = new Properties();
			jpaProterties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
			jpaProterties.put("hibernate.format_sql", true );
			jpaProterties.put("hibernate.show_sql", true);
			/*
			valores para o hibernate.hbm2ddl.auto:
			validate: validar o schema, não faz mudanças no banco de dados.
			update: faz update o schema.
			create: cria o schema, destruindo dados anteriores.
			create-drop: drop o schema quando ao terminar a sessão.
			*/
			jpaProterties.put("hibernate.hbm2ddl.auto", "update");
			emfb.setJpaProperties(jpaProterties);
			return emfb;
		}	    
}