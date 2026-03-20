package jp.co.flm.domain.service;

import jp.co.flm.domain.dto.EmployeeDto;

/**
 * 従業員検索Service インターフェイス
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
public interface SearchEmpService {

	/**
	 * 従業員IDに一致する従業員情報の取得をする
	 * @param employeeId 従業員ID
	 * @return employeeDto 従業員DTO
	 */
	public EmployeeDto getEmployee(Integer employeeId);

}
