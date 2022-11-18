package com.digital.reader.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital.reader.model.ReaderBookBuy;

public interface IReaderRepository extends JpaRepository<ReaderBookBuy, Integer> {
	
	

}
