/**
 * AllDaoTests.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.domain.dao;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * jp.co.flm.domain.dao パッケージ配下のテストクラスを
 * まとめて実行するテストスイートクラス
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@Suite
@SpringBootTest
@SelectClasses({
	EmployeeDaoSelectByIdTest.class,
	EmployeeDaoSelectAllTest.class,
	EmployeeDaoInsertTest.class,
	EmployeeDaoUpdateTest.class,
	EmployeeDaoDeleteTest.class
})
public class AllDaoTests {
    
}
