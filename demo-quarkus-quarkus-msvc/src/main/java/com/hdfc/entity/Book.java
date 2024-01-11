package com.hdfc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data

public class Book{
	

	private long id;
	private String title;
	private String author;
	private double price;
	
	
	
}
