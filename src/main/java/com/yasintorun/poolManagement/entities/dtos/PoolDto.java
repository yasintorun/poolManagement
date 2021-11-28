package com.yasintorun.poolManagement.entities.dtos;

import java.util.List;

import com.yasintorun.poolManagement.entities.concretes.Pool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoolDto {
	private Pool pool;
	private List<String> poolImages;
}
