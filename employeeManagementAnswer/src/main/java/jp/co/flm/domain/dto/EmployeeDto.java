/**
 * EmployeeDto.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.domain.dto;

import org.seasar.doma.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 従業員情報を扱うDTOクラス
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto{

    /** 従業員ID */
    @Id
    Integer employeeId;

    /** 従業員名 */
    String employeeName;

    /** 部署名 */
    String section;

    /** 内線番号 */
    String phone;

    /** バージョン */
    Integer version;

}
