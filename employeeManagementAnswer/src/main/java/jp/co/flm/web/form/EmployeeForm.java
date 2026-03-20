/**
 * EmployeeForm.java
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package jp.co.flm.web.form;

import java.io.Serializable;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 従業員情報入力フォーム
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeForm implements Serializable {

	/** 従業員ID */
	@Min(100000)
	@Max(999999)
	@NotNull
	private Integer employeeId;

	/** 従業員名 */
	@Size(max = 20)
	@NotBlank
	private String employeeName;

	/** 部署名 */
	@Size(max = 5)
	@NotBlank
	private String section;

	/** 内線番号 */
	@Pattern(regexp = "\\d{4}-\\d{4}")
	@NotBlank
	private String phone;

}
