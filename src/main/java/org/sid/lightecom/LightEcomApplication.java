package org.sid.lightecom;

import net.bytebuddy.utility.RandomString;
import org.sid.lightecom.dao.CategoryRepository;
import org.sid.lightecom.dao.ProductRepository;
import org.sid.lightecom.entities.Category;
import org.sid.lightecom.entities.Product;
import org.sid.lightecom.web.AddproductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import java.util.Random;
@Configuration
@ComponentScan
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
@PropertySource("application.properties")
@SpringBootApplication
public class LightEcomApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository prrepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
	    SpringApplication.run(LightEcomApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
	     repositoryRestConfiguration.exposeIdsFor(Product.class, Category.class);
       
    }
}
