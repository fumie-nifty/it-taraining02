package jp.co.flm.domain.domaCodeGen.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class StockListener implements EntityListener<Stock> {

    @Override
    public void preInsert(Stock entity, PreInsertContext<Stock> context) {
    }

    @Override
    public void preUpdate(Stock entity, PreUpdateContext<Stock> context) {
    }

    @Override
    public void preDelete(Stock entity, PreDeleteContext<Stock> context) {
    }

    @Override
    public void postInsert(Stock entity, PostInsertContext<Stock> context) {
    }

    @Override
    public void postUpdate(Stock entity, PostUpdateContext<Stock> context) {
    }

    @Override
    public void postDelete(Stock entity, PostDeleteContext<Stock> context) {
    }
}
