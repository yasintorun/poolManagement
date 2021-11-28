package com.yasintorun.poolManagement.entities.concretes;

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

@Table(name = "pool_images")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoolImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	

	@Column(name="image_id")
	private int imageId;
	
	@ManyToOne()
	@JoinColumn(name="pool_id")
	private Pool pool;
}
