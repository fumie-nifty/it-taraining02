package jp.co.flm.domain.service;

import org.springframework.stereotype.Service;

import jp.co.flm.common.exception.BusinessException;
import jp.co.flm.domain.dao.EmployeeDao;
import jp.co.flm.domain.dto.EmployeeDto;
import jp.co.flm.domain.entity.Employee;

/**
 * 従業員検索Serviceの実装クラス
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@Service
public class SearchEmpServiceImpl implements SearchEmpService {

	/** DAO */
	private EmployeeDao employeeDao;

	/** コンストラクターインジェクション */
	public SearchEmpServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	/**
	 * @see jp.co.flm.domain.service.SearchEmpService#getEmployee(java.lang.Integer)
	 */
	@Override
	public EmployeeDto getEmployee(Integer employeeId) {

		// 戻り値用の従業員DTOの変数を初期化する
		EmployeeDto employeeDto = null;

		// DAOのメソッド呼び出し従業員Entityを取得する
		Employee employee = employeeDao.selectById(employeeId);

		// 検索結果が存在しない場合
		if (employee == null) {
			// 業務エラーを明示的に発生させる
			throw new BusinessException("該当する従業員情報がありません。");
		}

		// 従業員Entityを従業員DTOに変換する
		employeeDto = new EmployeeDto(employee.getEmployeeId(),
				employee.getEmployeeName(),
				employee.getSection(),
				employee.getPhone(),
				employee.getVersion());

		// 従業員DTOを返却する
		return employeeDto;
	}

}
