package com.cg.ndp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.ndp.entity.DonorEntity;
import com.cg.ndp.exception.DuplicateDonorException;
import com.cg.ndp.exception.NoSuchDonorException;
import com.cg.ndp.model.AddressModel;
import com.cg.ndp.model.DonorModel;
import com.cg.ndp.repo.DonorRepo;

@ExtendWith(MockitoExtension.class)
public class DonorServiceImplTest {
	@Mock
	private DonorRepo donorRepo;

	
	@InjectMocks
	private DonorServiceImpl dsImpl;
	
	

	@Test
	@DisplayName("DonorServiceImpl::getById should return an existing DonorModel given existing id")
	void testGetById() throws NoSuchDonorException {
		AddressModel a1= new AddressModel(10001,"chennai","TamilNadu","677676","Gandhi Hospital");
		DonorEntity testdata=new DonorEntity(1001,"meghana","meghana@gmail.com","9090700123","meghana","meg2123456",a1);
		DonorModel expected=new DonorModel(1001,"meghana","meghana@gmail.com","9090700123","meghana","meg2123456",a1);		
		Mockito.when(donorRepo.existsById(1001)).thenReturn(true);
		Mockito.when(donorRepo.findById(1001)).thenReturn(Optional.of(testdata));
		DonorModel actual = dsImpl.getById(1001);
		assertEquals(expected, actual);
	}
	

	@Test
	@DisplayName("DonorServiceImpl::create donor will return donor given donorModel")
	void testCreateDonor() throws DuplicateDonorException {
		AddressModel a1= new AddressModel(10001,"chennai","TamilNadu","677676","Gandhi Hospital");
		DonorEntity testdata=new DonorEntity(1002,"teja","teja@gmail.com","9091700123","teja","tej2123456",a1);
		Mockito.when(donorRepo.save(testdata)).thenReturn(testdata);
		DonorModel expected=new DonorModel(1002,"teja","teja@gmail.com","9091700123","teja","tej2123456",a1);
		
		DonorModel actual = dsImpl.add(dsImpl.getParser().parse(testdata));
		assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("DonorServiceImpl::getById should throw NoSuchDonorException given non.existing id")
	void testGetById2() throws NoSuchDonorException {
		Mockito.when(donorRepo.existsById(1001)).thenReturn(false);
		assertThrows(NoSuchDonorException.class, () -> {
			dsImpl.getById(1001);
		});
	}

}
