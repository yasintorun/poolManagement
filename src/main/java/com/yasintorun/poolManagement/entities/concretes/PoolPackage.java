package com.yasintorun.poolManagement.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pool_packages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoolPackage {
	@Id
	@Column(name="package_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int packageId;
	
	@Column(name="package_name")
	private String packageName;

	@Column(name="package_price")
	private int packagePrice;
	
	@Column(name="package_period")
	private int packagePeriod;
	
	@Column(name="package_image")
	private String packageImage;
	
	@Column(name="package_color")
	private String packageColor;
	
	@Column(name="package_type")
	private String packageType; //Öğrenci, bireysel, aile vs.
}
