package com.example.demo.models;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KycUpdateRequestModel {
	
	@JsonProperty("kyc_result")
	public String kycResult;
}
