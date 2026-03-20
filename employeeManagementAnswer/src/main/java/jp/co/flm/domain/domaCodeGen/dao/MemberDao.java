package jp.co.flm.domain.domaCodeGen.dao;

import jp.co.flm.domain.domaCodeGen.entity.Member;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
public interface MemberDao {

    /**
     * @param memberId
     * @return the Member entity
     */
    @Select
    Member selectById(String memberId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Member entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Member entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Member entity);
}
