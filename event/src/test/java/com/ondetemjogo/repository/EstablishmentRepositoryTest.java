package com.ondetemjogo.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.ondetemjogo.model.Establishment;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
   TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
public class EstablishmentRepositoryTest {

	@Autowired
	private EstablishmentRepository repository;
	
	@Test
	public void shouldSaveEstablishment(){
		Establishment establishment = new Establishment();
		establishment.setName("Bar da Pinga");
		establishment.setAddress("Rua Rio Barreiro");
		Establishment newEstablishment = repository.saveAndFlush(establishment);
		Assert.assertNotNull(newEstablishment);
	}
}
