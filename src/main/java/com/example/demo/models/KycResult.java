package com.example.demo.models;

import lombok.Data;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Column;

@Data
@Entity
public class KycResult {
	
	@Id
	@Column(name = "token", nullable = false)
	private String token;
	
	@Column(name = "user_token", nullable = false)
	private String userToken;
	
	@Column(name = "kyc_result", nullable = false)
	private String kycResult;
}
