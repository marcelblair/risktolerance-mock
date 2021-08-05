package com.jnbank.jnfunds.risktolerance.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jnbank.jnfunds.risktolerance.dto.RiskForm;
import com.jnbank.jnfunds.risktolerance.dto.RiskQuestion;


@Service
public class RiskFormService {

	public RiskForm getFormTrn(String trn) {
		// TODO Auto-generated method stub
		return null;
	}

	public RiskForm saveForm(RiskForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	public RiskForm getForm(int formId) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<RiskQuestion> getAllQuestions() {
		ObjectMapper om = new ObjectMapper();
		List<RiskQuestion> results = new ArrayList<>();
		
		Resource json = new ClassPathResource("questions.json");
		
		try {
			results = om.readValue(json.getInputStream(), results.getClass());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

}
