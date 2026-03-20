package jp.co.flm.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.flm.common.exception.BusinessException;
import jp.co.flm.domain.dao.EmployeeDao;
import jp.co.flm.domain.dto.EmployeeDto;
import jp.co.flm.domain.entity.Employee;

/**
 * 従業員一覧Serviceの実装クラス
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@Service
public class AllEmpServiceImpl implements AllEmpService {

	/** DAO */
	private EmployeeDao employeeDao;

	/** コンストラクターインジェクション */
	public AllEmpServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	/**
	 * @see jp.co.flm.domain.service.AllEmpService#getAllEmployee()
	 */
	@Override
	public List<EmployeeDto> getAllEmployee() {
		
		// 戻り値用の従業員DTOの空のリストを生成する
		List<EmployeeDto> employeeDtoList = new ArrayList<>();

		// DAOのメソッド呼び出し、従業員Entityリストを取得する
		List<Employee> employeeList = employeeDao.selectAll();

		// 検索結果が存在しない場合
		if(employeeList.isEmpty()) {
			// 業務エラーを明示的に発生させる
			throw new BusinessException("該当する従業員情報がありません。");
		}
		
		// 取得した従業員Entityリストを従業員DTOリストに変換する
		for ( Employee employee : employeeList) {
			employeeDtoList.add(
						new EmployeeDto(employee.getEmployeeId(),
										employee.getEmployeeName(),
										employee.getSection(),
										employee.getPhone(),
										employee.getVersion())
					);
		}

		// 従業員DTOリストを返却する
		return employeeDtoList;

	}

}
