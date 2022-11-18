package com.digital.reader.services.signup;

import java.util.List;
import java.util.Optional;

import com.digital.reader.model.Reader;



public interface IReaderSignupService {
	
	
	public Optional<Reader> getReaderById(Integer rid);
	public List<Reader> getAllReader();
	Integer createReader(Reader reader);
	List<Reader> sigin(String userName, String password);

}
