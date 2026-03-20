/**
 * EmployeeDaoUpdateTest.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.domain.dao;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.jdbc.Sql;

import jp.co.flm.domain.entity.Employee;

/**
 * EmployeeDao.update()：int に対するテストクラス
 *   UT1-104-001 従業員情報の更新が成功する（存在する従業員ID）
 *   UT1-104-002 従業員情報の更新が失敗する（存在しない従業員ID）
 *   UT1-104-003 従業員情報の更新が失敗する（version不整合）
 *   UT1-104-004 DataAccessException（テーブル未存在）
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@SpringBootTest
@Sql(scripts = "/sql/test/testDataInit.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
@Sql(scripts = "/sql/test/testDataInit.sql",
		executionPhase = Sql.ExecutionPhase.AFTER_TEST_CLASS)
@DisplayName("UT1-104: EmployeeDao.update()のテスト")
public class EmployeeDaoUpdateTest {

    @Autowired
    EmployeeDao employeeDao;

    /**
     * UT1-104-001 従業員情報の更新が成功する（存在する従業員ID）
     *
     * 引数で渡されたEntityが存在する従業員IDかつ正しいversionを指定した場合、
     * 従業員情報が1件更新され、更新件数として1が返却されることを確認する。
     */
    @Test
    @Sql(scripts = "/sql/test/testData01.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @DisplayName("UT1-104-001 従業員情報の更新が成功する（存在する従業員ID）")
    void testUpdate001() {

        // 入力値
        Employee param = inputData();

        // テスト対象の実行
        int actual = employeeDao.update(param);

        // 検証
        // 更新件数が1であることを確認
        assertThat(actual).isEqualTo(1);

    }

    /**
     * UT1-104-002 従業員情報の更新が失敗する（存在しない従業員ID）
     *
     * 存在しない従業員IDを指定した場合、更新対象レコードが存在しないため更新は
     * 行われず、OptimisticLockingFailureExceptionが発生することを確認する。
     */
    @Test
    @Sql(scripts = "/sql/test/testData01.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @DisplayName("UT1-104-002 従業員情報の更新が失敗する（存在しない従業員ID）")
    void testUpdate002() {

        // 入力値
        Employee param = inputData();
        param.setEmployeeId(999999);

        // テスト対象の実行
        assertThatThrownBy(() -> {
        	employeeDao.update(param);
        })
        .isInstanceOf(org.springframework.dao.OptimisticLockingFailureException.class);

    }

    /**
     * UT1-104-003 従業員情報の更新が失敗する（version不整合）
     *
     * versionが不整合な状態で更新を行った場合、楽観ロックにより更新が行われず、
     * OptimisticLockingFailureExceptionが発生することを確認する。
     */
    @Test
    @Sql(scripts = "/sql/test/testData01.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @DisplayName("UT1-104-003 従業員情報の更新が失敗する（version不整合）")
    void testUpdate003() {

        // 入力値
        Employee param = inputData();
       param.setVersion(2);

        // 検証
        // 更新件数が1であることを確認
        assertThatThrownBy(() -> {
        	employeeDao.update(param);
        })
        .isInstanceOf(org.springframework.dao.OptimisticLockingFailureException.class);

    }

    /**
     * UT1-104-004 DataAccessException（テーブル未存在）
     *
	 * 【補足テスト（標準対象外）】
	 * 本テストはDAO単体テストの責務として必須なものではありません。
	 * テーブル未存在時の例外処理はDoma/Spring Framework側で実装済みのため、
	 * 通常のDAO単体テストでは検証対象外とします。
	 * 本テストは、テーブルが存在しない状態でSQLを実行した場合に、DataAccessExceptionが
	 * 発生することを確認するための【挙動確認用の補足テスト】です。
     */
    @Test
    @Sql(scripts = "/sql/test/testData03.sql",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "/sql/test/testDataInit.sql",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @DisplayName("UT1-104-004 DataAccessException（テーブル未存在）")
    void testUpdate004() {

        // 入力値
        Employee param = inputData();

        // 検証
        assertThatThrownBy(() -> {
            // テスト対象の実行
        	employeeDao.update(param);
        })
        .isInstanceOf(DataAccessException.class);
    }

    /**
     * 従業員ID「922102」の従業員オブジェクトを返す
     * @return Employee 従業員オブジェクト
     */
    private static Employee inputData() {

    	Employee expected = new Employee();
    	expected.setEmployeeId(922102);
    	expected.setEmployeeName("富士通　花子");
    	expected.setSection("開発部");
    	expected.setPhone("7700-9999");
    	expected.setVersion(1);
     	
        return expected;
    }
}
