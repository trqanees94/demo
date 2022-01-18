package com.example.demo.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.models.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class KycRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private KycResultRepository repository;
    
    @BeforeEach
    public void createTestKycResult() {
    	KycResult kycr = new KycResult();
		kycr.setKycResult("SUCCESS");
		kycr.setUserToken("demo_user_token1");
		kycr.setToken("demo_token_test123");
		repository.save(kycr);
    }
    
    @AfterEach
    public void deleteTestKycResult() {
    	repository.deleteByToken("demo_token_test123");
    }
    
    @Test
    public void givenKycResult_whenGetAll_thenStatus200() throws Exception {    	
    	
	    mvc.perform(get("/kycresults")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	}
    
    @Test
    public void givenKycResult_whenGetKycResult_thenToken() throws Exception {    	
    	
	    mvc.perform(get("/kycresult/demo_token_test123")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(jsonPath("$.kycResult").value("SUCCESS"));
    }
    
    @Test
    public void givenKycResult_whenUpdateKycResult_thenToken() throws Exception {    	
    	
	    mvc.perform(put("/kycresult/demo_token_test123")
	      .content("{\"kyc_result\": \"UPDATE\"}")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(jsonPath("$.kycResult").value("UPDATE"));
    }
    
    @Test
    public void givenKycResult_whenDeleteKycResult_thenToken() throws Exception {
      mvc.perform(delete("/kycresult/demo_token_test123"))
            .andExpect(status().isOk());
    }
}
