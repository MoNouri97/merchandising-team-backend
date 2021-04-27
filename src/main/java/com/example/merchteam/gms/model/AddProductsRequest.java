package com.example.merchteam.gms.model;

import lombok.Data;

@Data
public class AddProductsRequest {
	private Long gms;
	private Long[] products;
}
