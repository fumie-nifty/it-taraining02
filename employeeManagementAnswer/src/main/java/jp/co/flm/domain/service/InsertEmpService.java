package jp.co.flm.domain.service;

import jp.co.flm.domain.dto.EmployeeDto;

/**
 * 従業員登録Service インターフェイス
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
public interface InsertEmpService {

	/**
	 * 従業員情報の確認をする
	 * @param employeeDto 従業員DTO
	 * @return employeeDto 従業員DTO
	 */
	public EmployeeDto confirmEmployee(EmployeeDto employeeDto) ;

	/**
	 * 従業員情報の登録をする
	 * @param employeeDto 従業員DTO
	 */
	public void registEmployee(EmployeeDto employeeDto) ;

}
