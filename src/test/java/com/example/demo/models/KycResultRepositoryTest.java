package com.example.demo.models;

import com.example.demo.models.KycResult;
import com.example.demo.models.KycResultRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest // By default, @DataJpaTest will configure Hibernate to create the database schema for us automatically
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=validate"
})

public class KycResultRepositoryTest {
	
	@Autowired
	private KycResultRepository kycResultRepository;
	
	@Test
	void injectedComponentsAreNotNull(){
		assertThat(kycResultRepository).isNotNull();
	}
	
	@Test
	void whenSaved_thenFindsByName() {
		KycResult kycr = new KycResult();
		kycr.setToken("demo_test_token");
		kycr.setUserToken("demo_test_user");
		kycr.setKycResult("SUCCESS");
		
		kycResultRepository.save(kycr);
	  
	  assertThat(kycResultRepository.findByToken("demo_test_token")).isNotNull();
	}
	
	@Test
	void whenSaved_thenFindAll() {
		KycResult kycr = new KycResult();
		kycr.setToken("demo_test_token");
		kycr.setUserToken("demo_test_user");
		kycr.setKycResult("SUCCESS");
		
		kycResultRepository.save(kycr);
	  
		assertThat(kycResultRepository.findAll().size()).isEqualTo(1);
	}
	
	@Test
	void whenSaved_thenUpdate() {
		KycResult kycr = new KycResult();
		kycr.setToken("demo_test_token");
		kycr.setUserToken("demo_test_user");
		kycr.setKycResult("SUCCESS");
		kycResultRepository.save(kycr);
		
		Optional<KycResult> okycr = kycResultRepository.findByToken("demo_test_token");
		kycr = okycr.get();
		kycr.setKycResult("FAILURE");
		kycResultRepository.save(kycr);
		
		assertThat(kycResultRepository.findByToken("demo_test_token").get().getKycResult()).isEqualTo("FAILURE");
	}
	
	@Test
	void whenSaved_thenDelete() {
		KycResult kycr = new KycResult();
		kycr.setToken("demo_test_token");
		kycr.setUserToken("demo_test_user");
		kycr.setKycResult("SUCCESS");
		kycResultRepository.save(kycr);
		
		kycResultRepository.deleteByToken("demo_test_token");
		assertThat(kycResultRepository.findAll().size()).isEqualTo(0);
		
	}
}
