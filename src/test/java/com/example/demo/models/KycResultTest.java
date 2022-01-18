package com.example.demo.models;

import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.example.demo.models.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@ExtendWith(MockitoExtension.class)
public class KycResultTest {
	@InjectMocks
	private ObjectMapper objectMapper;
	
	@Test
	public void shouldGetToken() throws JsonProcessingException{
		//given
		String json = "{\n"
						+ "	\"user_token\": \"demo_test_user\"\n"
						+ "}";
		// when
		KycRequestModel kycrm = objectMapper.readValue(json,KycRequestModel.class);
		
		// then
		assertThat(kycrm.getUserToken()).isEqualTo("demo_test_user");
		
	}

}
