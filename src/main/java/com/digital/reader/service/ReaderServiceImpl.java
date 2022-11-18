package com.digital.reader.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.reader.model.ReaderBookBuy;

@Service
public class ReaderServiceImpl implements IReaderService {

	@Autowired
	private IReaderRepository readerRepository;
	
	

	@Override
	public Integer buyBook(ReaderBookBuy readerBookBuy) {
	

		ReaderBookBuy readerBuyingBook = readerRepository.save(readerBookBuy);
		return readerBuyingBook.getpId();
	}

	@Override
	public List<ReaderBookBuy> readBook(String readerName, String readerEmailId) {
		
	List<ReaderBookBuy> getBook=	readerRepository.findAll().stream().filter(e-> (e.getReaderName().equalsIgnoreCase(readerName))
				&&(e.getReaderEmailId().equalsIgnoreCase(readerEmailId))).collect(Collectors.toList());
		
		
		
		return getBook;
	}

	@Override
	public List<ReaderBookBuy> history(String readerEmailId) {

		List<ReaderBookBuy> getBook = readerRepository.findAll().stream()
				.filter(e -> (e.getReaderEmailId().equalsIgnoreCase(readerEmailId))).collect(Collectors.toList());
System.out.println(getBook);
		
		return getBook;
	}

	@Override
	public List<ReaderBookBuy> getInvoice(String paymentid) {

		List<ReaderBookBuy> getBook = readerRepository.findAll().stream()
				.filter(e -> (e.getPaymentid().equalsIgnoreCase(paymentid))).collect(Collectors.toList());
System.out.println(getBook);
		
		return getBook;
	}

}
