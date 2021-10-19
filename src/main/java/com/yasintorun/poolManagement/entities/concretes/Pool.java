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
@Table(name = "pools")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pool {
	@Id
	@Column(name="pool_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int poolId;
	
	@Column(name="pool_name")
	private String poolName;
	
	@Column(name="pool_address")
	private String poolAddress;
}
