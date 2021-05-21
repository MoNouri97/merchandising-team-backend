package com.example.merchteam.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/report")
public class ReportController {
	@Autowired
	private ReportService reportService;

	@GetMapping(value = "/")
	public List<Report> getAll(@RequestBody Report report) {
		return reportService.getAll();
	}

	@GetMapping(value = "/{id}")
	public Report getOne(@PathVariable Long id) {
		return reportService.getOne(id);
	}

	@PostMapping(value = "/")
	public Report create(@RequestBody Report report) {
		return reportService.create(report);
	}

}
