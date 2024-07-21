package in.api.repo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.api.entities.Book;
import in.api.repo.BookRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class RepositoryTest {
	
	@Autowired
	private BookRepository bookRepo;
	
	@Test
	public void findMethodTest() {
//		Mono<Book> nameMono = bookRepo.findByName("Basic Spring Boot Book");
//		StepVerifier.create(nameMono)
//					.expectNextCount(1)
//					.verifyComplete();
		
//		Flux<Book> authorFlux = bookRepo.findByAuthor("Darshan");
//		StepVerifier.create(authorFlux)
//					.expectNextCount(1)
//					.verifyComplete();
		
//		bookRepo.findByNameAndAuthor("Basic Spring Boot Book","Siddhesh")
//											  .as(StepVerifier::create)
//											  .expectNextCount(1)
//											  .verifyComplete();
		
		
		
	}
	
	@Test
	public void queryMethodTest() {
//		bookRepo.getAllBooksByAuthor("Darshan")
//				.as(StepVerifier :: create)
//				.expectNextCount(1)
//				.verifyComplete();
		
		
		bookRepo.searchBookByTitle("%front%")
				.as(StepVerifier :: create)
				.expectNextCount(1)
				.verifyComplete();
	}

}
