package jp.co.flm.web.form;

import java.io.Serializable;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 従業員ID入力フォーム
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeIdForm implements Serializable {

	/** 従業員ID */
	@Min(100000)
	@Max(999999)
	@NotNull
	private Integer employeeId;

}

