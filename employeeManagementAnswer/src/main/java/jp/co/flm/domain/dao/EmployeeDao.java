/**
 * EmployeeDao.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */
package jp.co.flm.domain.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.flm.domain.entity.Employee;

/**
 * employeeテーブルに対するデータアクセスを提供するクラス
 * @author FLM
 * @version 3.0.0 2026/03/25  Spring Boot 3.4.2 / Doma 3.5.0
 */
@Dao
@ConfigAutowireable
public interface EmployeeDao {

    /**
     * 従業員IDを元に従業員情報を検索する
     * @param employeeId 従業員ID
     * @return {@link Employee} 従業員Entity
     */
    @Select
    Employee selectById(Integer employeeId);

    /**
     * すべての従業員情報を検索する
     * @return {@link Employee} 従業員Entityのリスト
     */
    @Select
    List<Employee> selectAll();

    /**
     * 従業員情報を登録する
     * @param entity {@link Employee} 従業員Entity
     * @return affected rows 更新行数
     */
    @Insert
    int insert(Employee entity);

    /**
     * 従業員情報を更新する
     * @param entity {@link Employee} 従業員Entity
     * @return affected rows 更新行数
     */
    @Update
    int update(Employee entity);

    /**
     * 従業員情報を削除する
     * @param entity {@link Employee} 従業員Entity
     * @return affected rows 更新行数
     */
    @Delete
    int delete(Employee entity);
}
