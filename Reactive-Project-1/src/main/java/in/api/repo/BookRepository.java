package in.api.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import in.api.entities.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book,Integer> {
	
	public Mono<Book> findByName(String name);	
	
	public Flux<Book> findByAuthor(String author);
	
	public Flux<Book> findByPublisher(String publisher);
	
	public Flux<Book> findByNameAndAuthor(String name,String author);
	
	
	@Query("select * from book_details where author = :auth")
	public Flux<Book> getAllBooksByAuthor(@Param("auth") String author);
	
	@Query("select * from book_details where name LIKE :title")
	public Flux<Book> searchBookByTitle(String title);
	

}
