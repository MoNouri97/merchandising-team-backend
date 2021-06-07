package com.example.merchteam.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/report")
public class ReportController {
	@Autowired
	private ReportService reportService;

	@GetMapping
	public List<Report> getAll() {
		return reportService.getAll();
	}

	@GetMapping(value = "/{id}")
	public Report getOne(@PathVariable Long id) {
		return reportService.getOne(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public Report create(@RequestBody Report report) {
		System.out.println("report: " + report);
		return reportService.create(report);
	}
	@DeleteMapping(path = "{id}")
	public void deleteById(@PathVariable("id") Long id) {
		reportService.delete(id);
	}

}
