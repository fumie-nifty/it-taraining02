package jp.co.flm.domain.domaCodeGen.dao;

import jp.co.flm.domain.domaCodeGen.entity.Employee;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
public interface EmployeeDao {

    /**
     * @param employeeId
     * @return the Employee entity
     */
    @Select
    Employee selectById(Integer employeeId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Employee entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Employee entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Employee entity);
}
