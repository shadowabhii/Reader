package com.digital.reader.services.signup;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.digital.reader.model.Reader;



@Service
public class ReaderSignUpServiceImpl implements IReaderSignupService {
	
	@Autowired
	private IReaderRepositorySignUp readerRepositorySignUp;
	
	@Bean
	public BCryptPasswordEncoder passwordEncode()
	{
		return new BCryptPasswordEncoder();
	}

	@Override
	public Integer createReader(Reader reader) {
		

		  String encodePass=passwordEncode().encode(reader.getPassword());
		  reader.setPassword(encodePass);
		
		Reader savingAuthor=	readerRepositorySignUp.save(reader);
		System.out.println(savingAuthor);
		
		return savingAuthor.getrId();
	}
	
	@Override
	public List<Reader> sigin(String userName, String password) {
		

		
		BCryptPasswordEncoder passdecode = new BCryptPasswordEncoder();
		//passdecode.matches(password, authsignRepository)
		
	
		List<Reader> user= readerRepositorySignUp.findAll().stream().
				filter(e->(e.getUserName().equals(userName)))
				.collect(Collectors.toList());
		
		if(passdecode.matches(password, user.get(0).getPassword()))
		{
			return user;
		}
		return null;
		
		
		
		
		
		
	
		/*
		 * System.out.println(readerRepositorySignUp.findAll()); List<Reader> login=
		 * readerRepositorySignUp.findAll().stream().
		 * filter(e->(e.getUserName().equals(userName))&&(e.getPassword().equals(
		 * password))) .collect(Collectors.toList());
		 * 
		 * System.out.println(login);
		 * 
		 * return login;
		 */}

	

	@Override
	public Optional<Reader> getReaderById(Integer rid) {
		// TODO Auto-generated method stub
		return readerRepositorySignUp.findById(rid);
	}

	@Override
	public List<Reader> getAllReader() {
		// TODO Auto-generated method stub
		return readerRepositorySignUp.findAll();
	}

}
