package in.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.api.entities.Book;
import in.api.services.BookService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	//create
	@PostMapping
	public Mono<Book> create(@RequestBody Book book){
		return bookService.create(book);		
	}	
	
	//get all books
	@GetMapping
	public Flux<Book> getAll(){
		return bookService.getAll();
	}
	
	//get single book
	@GetMapping("/{bid}")
	public Mono<Book> get(@PathVariable("bid") int bookId){
		return bookService.get(bookId);
	}
	
	//update 
	@PutMapping("/{bid}")
	public Mono<Book> update(@RequestBody Book book, @PathVariable("bid") int bookId){
		return bookService.update(book,bookId);
	}
	
	//delete
	@DeleteMapping("/{bid}")
	public Mono<Void> delete(@PathVariable("bid") int bookId){
		return bookService.delete(bookId);
	}
	
	//search
	@GetMapping("/search")
	public Flux<Book> searchBooks(@RequestParam("query") String query){
		System.out.println(query);
		return this.bookService.searchBook(query);
	}
	
	@ExceptionHandler(Exception.class) // Can be more specific for relevant exceptions
    public Mono<ResponseEntity<String>> handleCreateException(Exception ex) {
        // Log the exception for debugging
        System.out.println("Error creating book: "+ex);
        
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while creating the book."));
    }

}
