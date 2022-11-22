package com.digital.reader.service;

import java.util.List;
import java.util.Optional;

import com.digital.reader.model.Book;
import com.digital.reader.model.ReaderBookBuy;

public interface IReaderService {
	
	Integer buyBook(ReaderBookBuy readerBookBuy);
	public List<ReaderBookBuy> readBook(Integer rId);
	public List<ReaderBookBuy> history(String readerEmailId);
	public List<ReaderBookBuy> getInvoice(String paymentid);

}
