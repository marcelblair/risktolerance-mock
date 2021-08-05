package com.jnbank.jnfunds.risktolerance.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jnbank.jnfunds.risktolerance.dto.RiskForm;
import com.jnbank.jnfunds.risktolerance.dto.RiskQuestion;
import com.jnbank.jnfunds.risktolerance.service.RiskFormService;

@RestController
@RequestMapping(path = "/api/v1/risktolerance")
public class RiskFormController {

	@Autowired
	RiskFormService service;
	
	@PostMapping("/form")
	public ResponseEntity<?> save(@RequestBody RiskForm form){
		if(form != null) {
			form = service.saveForm(form);
		} else {
			ResponseEntity.badRequest().body("The risk form cannot be empty");
		}
		return ResponseEntity.ok(form);
	}
	
	@GetMapping("/form/{formid}")
	public ResponseEntity<?> getForm(@PathVariable("formid")int formId) {
		RiskForm form = null;
		
		form = service.getForm(formId);
		
		return ResponseEntity.ok(form);
	}
	
	@GetMapping("/form/{trn}")
	public ResponseEntity<?> getFormByTrn(@PathVariable("trn")String trn) {
		RiskForm form = null;
		
		form = service.getFormTrn(trn);
		
		return ResponseEntity.ok(form);
	}
	
	@GetMapping("/questions")
	public ResponseEntity<?> getQuestions(){
		List<RiskQuestion> questions = new ArrayList<RiskQuestion>();
		
		questions = service.getAllQuestions();
		return ResponseEntity.ok(questions);
	}
}
