package jp.co.flm.domain.service;

import java.util.List;

import jp.co.flm.domain.dto.EmployeeDto;


/**
 * 従業員一覧Service インターフェイス
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
public interface AllEmpService {

	/**
	 * 従業員情報一覧を取得する
	 * @return employeeDtoList 従業員DTO一覧
	 */
	public List<EmployeeDto> getAllEmployee();

}
