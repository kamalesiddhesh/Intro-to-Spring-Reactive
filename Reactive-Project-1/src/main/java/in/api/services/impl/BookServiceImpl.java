package in.api.services.impl;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.api.entities.Book;
import in.api.repo.BookRepository;
import in.api.services.BookService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepo;

	@Override
	public Mono<Book> create(Book book) {
		System.out.println(Thread.currentThread().getName());
		Mono<Book> createdBook = bookRepo.save(book).doOnNext(data->{
			System.out.println(Thread.currentThread().getName());
		});

		return createdBook;
		
	}

	@Override
	public Flux<Book> getAll() {
		return bookRepo.findAll()
					   .delayElements(Duration.ofSeconds(2))
					   .log()
					   .map(book->{
								book.setName(book.getName().toUpperCase());
								return book;
					   });
		
	}

	@Override
	public Mono<Book> get(int bookId) {
		Mono<Book> item = bookRepo.findById(bookId)
								  .map(book->{
										book.setName(book.getName().toUpperCase());
										return book;
								  });
		return item;
	}

	@Override
	public Mono<Book> update(Book updatedBook, int bookId) {
		
		Mono<Book> existingBook = bookRepo.findById(bookId);
		existingBook.subscribe(System.out::println);
		
		return existingBook.flatMap(retrievedBook -> {
			retrievedBook.setName(updatedBook.getName());
			retrievedBook.setDescription(updatedBook.getDescription());
			retrievedBook.setPublisher(updatedBook.getPublisher());
			retrievedBook.setAuthor(updatedBook.getAuthor());
			return bookRepo.save(retrievedBook).log(); // this return is part of Function Body within flatMap that return Mono<Book> object
		});
		
		
	}

	@Override
	public Mono<Void> delete(int bookId) {
		
		return bookRepo.findById(bookId)
					   .flatMap(book ->bookRepo.delete(book));
		
	}

	@Override
	public Flux<Book> search(String query) {
		
		return null;
	}

	@Override
	public Flux<Book> searchBook(String titleKeyword) {
		return this.bookRepo.searchBookByTitle("%"+titleKeyword+"%");
	}

}
