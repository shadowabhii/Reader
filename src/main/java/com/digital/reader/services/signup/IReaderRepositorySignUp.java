package com.digital.reader.services.signup;

import org.springframework.data.jpa.repository.JpaRepository;


import com.digital.reader.model.Reader;

public interface IReaderRepositorySignUp extends JpaRepository<Reader, Integer> {

}
