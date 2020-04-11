
         package org.sid.ecombackend;

		import net.bytebuddy.utility.RandomString;
		import org.sid.ecombackend.dao.CategoryRepository;
		import org.sid.ecombackend.dao.ProductRepository;
		import org.sid.ecombackend.entities.Category;
		import org.sid.ecombackend.entities.Product;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.boot.CommandLineRunner;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import lombok.Data;
		import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

		import java.util.Random;

@SpringBootApplication
public class  EcomBackendApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private RepositoryRestConfiguration  repositoryrestConfiguration;

	public static void main (String[]args) {
		SpringApplication.run(EcomBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryrestConfiguration.exposeIdsFor(Product.class,Category.class);
 /*
		categoryRepository.save(new Category(null,"Computers",null,null,null));
		categoryRepository.save(new Category(null,"Printers",null,null,null));
		categoryRepository.save(new Category(null,"Smart Phones",null,null,null));

		Random rdm=new Random();
		categoryRepository.findAll().forEach (c->{
			for(int i = 0; i<10; i++) {
				Product p = new Product();
				p.setName(RandomString.make(18));
				p.setCurrentPrice(100 + rdm.nextInt(10000));
				p.setAvailable(rdm.nextBoolean());
				p.setPromotion(rdm.nextBoolean());
				p.setSelected(rdm.nextBoolean());
				p.setPhotoName("unKnown.png");

				p.setCategory(c);

				productRepository.save(p);
			}

		}); */
	}

}



