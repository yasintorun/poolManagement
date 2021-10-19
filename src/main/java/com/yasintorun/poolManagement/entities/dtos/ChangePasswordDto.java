package com.yasintorun.poolManagement.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDto {
	private int accountId;
	private String oldPassword;
	private String newPassword;
	private String newPasswordRepeat;
}
