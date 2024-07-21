package in.api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table("book_details")
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	@Id
	private int bookId;
	
	private String name;
	
	@Column("book_desc")
	private String description;
	
	private String publisher;
	
	private String author;
	

}
