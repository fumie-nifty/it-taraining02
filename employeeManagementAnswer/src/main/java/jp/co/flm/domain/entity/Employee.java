/**
 * Employee.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.domain.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Metamodel;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * employeeテーブルに対するエンティティクラス
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@Entity(metamodel = @Metamodel)
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee{

    /** 従業員ID */
    @Id
    @Column(name = "employee_id")
    Integer employeeId;

    /** 従業員名 */
    @Column(name = "employee_name")
    String employeeName;

    /** 部署名 */
    @Column(name = "section")
    String section;

    /** 内線番号 */
    @Column(name = "phone")
    String phone;

    /** バージョン */
    @Version
    @Column(name = "version")
    Integer version;

}
