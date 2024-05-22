package com.poly.app.enity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Report implements Serializable {
		@Id
		Serializable group;
		Double sum;
		Long count;

}
