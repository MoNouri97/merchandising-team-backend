package com.example.merchteam.gms;

import java.util.List;

import com.example.merchteam.gms.model.AddProductsRequest;

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

@RestController
@CrossOrigin(origins = "*" )
@RequestMapping(path = "/api/v1/gms")
public class GMSController {
	private final GMSService gmsService;

	@Autowired
	public GMSController(GMSService gmsService) {
		this.gmsService = gmsService;
	}

	@PostMapping(path = "/add-products")
	public GMS addProducts(@RequestBody AddProductsRequest body) {
		System.out.println(body);
		return gmsService.addProductsToGms(body.getGms(), body.getProducts());
	}

	// CRUD
	@GetMapping
	public List<GMS> getGMS() {
		return gmsService.getGMS();
	}

	@GetMapping(path = "{gmsId}")
	public GMS getGMSParId(@PathVariable("gmsId") Long gmsId) {
		return gmsService.getGMSParId(gmsId);
	}

	@PostMapping
	public void addGMS(@RequestBody GMS gms) {
		gmsService.addGMS(gms);
	}

	@DeleteMapping(path = "{gmsId}")
	public void deleteGMS(@PathVariable("gmsId") Long gmsId) {
		gmsService.deleteGMS(gmsId);
	}

	@PutMapping("{gmsId}")
	public void updateGMS(@PathVariable("gmsId") Long gmsId, @RequestBody GMS gms) {
		gmsService.updateGMS(gmsId, gms);
	}
}
