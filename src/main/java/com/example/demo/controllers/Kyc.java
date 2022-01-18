package com.example.demo.controllers;

import com.example.demo.models.KycResult;
import com.example.demo.models.KycRequestModel;
import com.example.demo.models.KycResultRepository;
import com.example.demo.models.KycUpdateRequestModel;
import com.example.demo.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class Kyc {
	
	@Autowired
	private KycResultRepository kycResultRepository;
	
	@GetMapping("/kycresult/{token}")
	KycResult getKyResult(@PathVariable String token) throws Exception {
		Optional<KycResult> okycr = kycResultRepository.findByToken(token);
		if(okycr.isPresent()) {
			return okycr.get();
		} else {
			throw new ObjectNotFoundException(token);
		}
	}
	
	@GetMapping("/kycresults")
	List<KycResult> getKyResults() throws Exception {
		List<KycResult> lkycr = kycResultRepository.findAll();
		return lkycr;	
	}
	
	@PostMapping("/kycresult")
	@ResponseStatus(HttpStatus.OK)
	KycResult postKycResult(@RequestBody KycRequestModel kycRequestModel) throws Exception {
		KycResult kycr = new KycResult();
		kycr.setToken(UUID.randomUUID().toString());
		kycr.setUserToken(kycRequestModel.getUserToken());
		kycr.setKycResult("SUCCESS");
		
		kycResultRepository.save(kycr);
		return kycr;
	}
	
	@PutMapping("/kycresult/{token}")
	@ResponseStatus(HttpStatus.OK)
	KycResult putKycResult(@PathVariable String token, @RequestBody KycUpdateRequestModel kycUpdateRequestModel) throws Exception {
		String updatedKycResult = kycUpdateRequestModel.getKycResult();
		
		//Check if the token exists
		Optional<KycResult> okycr = kycResultRepository.findByToken(token);
		if(okycr.isPresent()) {
			KycResult kycr = okycr.get();
			kycr.setKycResult(updatedKycResult);
			kycResultRepository.save(kycr);
			return kycr;
		} else {
			throw new ObjectNotFoundException(token);
		}
	}
	
	@DeleteMapping("/kycresult/{token}")
	@ResponseStatus(HttpStatus.OK)
	String deleteKycResult(@PathVariable String token) throws Exception {
		Optional<KycResult> okycr = kycResultRepository.findByToken(token);
		if(okycr.isPresent()) {
			kycResultRepository.deleteByToken(token);
			return token;
		} else {
			throw new ObjectNotFoundException(token);
		}
		
	}
}
