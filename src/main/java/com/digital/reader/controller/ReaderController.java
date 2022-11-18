package com.digital.reader.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.digital.reader.model.Book;
import com.digital.reader.model.Reader;
import com.digital.reader.model.ReaderBookBuy;
import com.digital.reader.service.IReaderService;

import com.digital.reader.services.signup.IReaderSignupService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReaderController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private IReaderSignupService readerSignupService;
	@Autowired
	private IReaderService readerService;

	@PostMapping("/readersignup")
	Integer createAuthor(@RequestBody Reader reader) {

		Integer id = readerSignupService.createReader(reader);

		System.out.println(id);

		return id;

	}
	
	@GetMapping("/sigin/{userName}/{password}")
	public List<Reader> signin(@PathVariable("userName") String userName,@PathVariable("password") String password)
	{
		List<Reader> signedIn=readerSignupService.sigin(userName, password);
		return signedIn;
		
	}

//	@GetMapping("/reader/{rid}")
//	public Optional<Reader> getAuthorById(@PathVariable Integer rid) {
//		Optional<Reader> reader = readerSignupService.getReaderById(rid);
//		return reader;
//	}

//	@GetMapping("/reader")
//	public List<Reader> getAllAuthor() {
//		return readerSignupService.getAllReader();
//	}

	@GetMapping("/reader/{bId}")
	public Optional<Book> getBookById(@PathVariable("bId") int i) {

		System.out.println("inside reader");
		// code for linking 2 microservice where record list will be set to Book

		Optional<Book> book = this.restTemplate.getForObject("http://localhost:8084/bookbyid/" + i, Optional.class);
		

		return book;
	}

	@GetMapping("/reader/category/{category}")
	public List<Book> getBookByCategory(@PathVariable("category") String category) {

		System.out.println("inside reader");
		// code for linking 2 microservice where record list will be set to Book

		List<Book> book = this.restTemplate.getForObject("http://localhost:8084/Book/category/" + category, List.class);
		// List record =
		// this.restTemplate.getForObject("http://RECORD-SERVICE/record/emp/"+eId,
		// List.class);

		return book;
	}
	
	@GetMapping("/reader/author/{author}")
	public List<Book> getBookByAuthor(@PathVariable("author") String author) {

		System.out.println("inside reader");
		// code for linking 2 microservice where record list will be set to Book

		List<Book> book = this.restTemplate.getForObject("http://localhost:8084/Book/author/" + author, List.class);
		// List record =
		// this.restTemplate.getForObject("http://RECORD-SERVICE/record/emp/"+eId,
		// List.class);

		return book;
	}

	@GetMapping("/reader/price/{price}")
	public List<Book> getBookByPrice(@PathVariable("price") Double price) {

		System.out.println("inside reader");
		// code for linking 2 microservice where record list will be set to Book

		List<Book> book = this.restTemplate.getForObject("http://localhost:8084/Book/price/" + price, List.class);
		// List record =
		// this.restTemplate.getForObject("http://RECORD-SERVICE/record/emp/"+eId,
		// List.class);

		System.out.println(book);

		return book;
	}

	@GetMapping("/reader/pricecategory/{price}/{category}")
	public List<Book> getBookByPriceCategory(@PathVariable("price") Double price,
			@PathVariable("category") String category) {

		System.out.println("inside reader");
		// code for linking 2 microservice where record list will be set to Book

		List<Book> book = this.restTemplate
				.getForObject("http://localhost:8084/Book/pricecategory/" + price + "/" + category, List.class);
		// List record =
		// this.restTemplate.getForObject("http://RECORD-SERVICE/record/emp/"+eId,
		// List.class);

		System.out.println(book);

		return book;
	}

	@PostMapping("/buybook")
	public Integer buyBook(@RequestBody ReaderBookBuy readerBookBuy) {

		Integer id = readerService.buyBook(readerBookBuy);
		return id;
	}


	@GetMapping("/reader/history/{readerEmailId}")
	public List<ReaderBookBuy> getReaderHistory(@PathVariable String readerEmailId) {


		return readerService.history(readerEmailId);

	}
	
	
	@GetMapping("/reader/invoice/{paymentid}")
	public List<ReaderBookBuy> getReaderInvoice(@PathVariable String paymentid) {


		return readerService.getInvoice(paymentid);

	}
	
	@GetMapping("/reader/purchasedbook/{readerName}/{readerEmailId}")
	public List<Optional<Book>> getReaderBook(@PathVariable("readerName") String readerName,
			@PathVariable("readerEmailId") String readerEmailId) {
		List<Optional<Book>> book = new ArrayList<>();
		
		System.out.println("purchased");
		
		List<ReaderBookBuy> readingBook = readerService.readBook(readerName, readerEmailId);
		for (int i = 0; i < readingBook.size(); i++) {

			Optional<Book> read = getBookById((readingBook.get(i).getbId()));
			book.add(read);

		}
		
			
		

		return book;
	}

}
