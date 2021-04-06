package com.example.Merchandising.concurrent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Merchandising.categorie.Categorie;
import com.example.Merchandising.categorie.CategorieService;

@RestController
@CrossOrigin(origins = "*" /*"http://localhost:3000"*/)
@RequestMapping(path="/concurrents")
public class ConcurrentController {
	private final ConcurrentService concurrentService;
	@Autowired
	public ConcurrentController(ConcurrentService concurrentService) {
		this.concurrentService = concurrentService;
	}
	@GetMapping
	public List<Concurrent> getConcurrents() {
		return  concurrentService.getConcurrents();
	}
	@GetMapping(path="{concurrentId}")
	public Concurrent getConcurrentParId(@PathVariable("concurrentId") Long concurrentId) {
		return  concurrentService.getConcurrentParId(concurrentId);
	}
	@PostMapping
	public void addConcurrent(@RequestBody Concurrent concurrent) {
		concurrentService.addConcurrent(concurrent);
	}
	@DeleteMapping(path="{concurrentId}")
	public void deleteConcurrent(@PathVariable("concurrentId") Long concurrentId) {
		concurrentService.deleteConcurrent(concurrentId);
	}
	@PutMapping("{concurrentId}")
	public void updateConcurrent(@PathVariable("concurrentId") Long concurrentId,
							  @RequestBody Concurrent concurrent) {
		concurrentService.updateConcurrent(concurrentId,concurrent);	
	}
}
