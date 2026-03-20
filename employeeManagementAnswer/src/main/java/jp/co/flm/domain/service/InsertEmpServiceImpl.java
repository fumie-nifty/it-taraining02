package jp.co.flm.domain.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import jp.co.flm.common.exception.BusinessException;
import jp.co.flm.domain.dao.EmployeeDao;
import jp.co.flm.domain.dto.EmployeeDto;
import jp.co.flm.domain.entity.Employee;

/**
 * 従業員登録Serviceの実装クラス
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@Service
public class InsertEmpServiceImpl implements InsertEmpService {

	/** DAO */
	private EmployeeDao employeeDao;

	/** コンストラクターインジェクション */
	public InsertEmpServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	/**
	 * @see jp.co.flm.domain.service.InsertEmpService#registEmployee(jp.co.flm.domain.dto.EmployeeDto)
	 */
	@Override
	public void registEmployee(EmployeeDto employeeDto) {

		// 従業員DTOを従業員Entityに変換する
		Employee employee = new Employee();
		employee.setEmployeeId(employeeDto.getEmployeeId());
		employee.setEmployeeName(employeeDto.getEmployeeName());
		employee.setSection(employeeDto.getSection());
		employee.setPhone(employeeDto.getPhone());
		employee.setVersion(employeeDto.getVersion());

		// 従業員Entityを引数で渡しDAOのメソッド呼び出す
		employeeDao.insert(employee);

	}

	/**
	 * @see jp.co.flm.service.InsertEmpService#confirmEmployee(jp.co.flm.EmployeeDto.Employee)
	 */
	@Override
	public EmployeeDto confirmEmployee(EmployeeDto employeeDto) {

		// 部署リスト作成する
		ArrayList<String> sectionList = new ArrayList<>();
		sectionList.add("研修部");
		sectionList.add("開発部");
		sectionList.add("営業部");

		// 従業員DTOの部署が部署リストにない部署だった場合
		if (!sectionList.contains(employeeDto.getSection())) {
			// 業務エラーを明示的に発生させる
			throw new BusinessException("部署名は、「研修部・開発部・営業部」のいずれかを入力してください。");
		}

		// 従業員DTOを返却する
		return employeeDto;
	}
}
