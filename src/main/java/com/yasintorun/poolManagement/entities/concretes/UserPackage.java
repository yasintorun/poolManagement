package com.yasintorun.poolManagement.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_packages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPackage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_package_id")
	private int userPackageId;
	
	@Column(name="created_at")
	private LocalDate createdAt;
	
	@Column(name="status")
	private boolean status;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User user;

	@ManyToOne()
	@JoinColumn(name="package_id")
	private PoolPackage poolPackage;
}
