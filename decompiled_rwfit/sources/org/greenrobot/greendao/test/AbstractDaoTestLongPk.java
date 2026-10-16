package org.greenrobot.greendao.test;

import android.test.AndroidTestCase;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoLog;

/* loaded from: classes2.dex */
public abstract class AbstractDaoTestLongPk<D extends AbstractDao<T, Long>, T> extends AbstractDaoTestSinglePk<D, T, Long> {
    public AbstractDaoTestLongPk(Class<D> cls) {
        super(cls);
    }

    public void testAssignPk() {
        if (!this.daoAccess.isEntityUpdateable()) {
            DaoLog.d("Skipping testAssignPk for not updateable " + this.daoClass);
            return;
        }
        T createEntity = createEntity(null);
        if (createEntity == null) {
            DaoLog.d("Skipping testAssignPk for " + this.daoClass + " (createEntity returned null for null key)");
            return;
        }
        T createEntity2 = createEntity(null);
        this.dao.insert(createEntity);
        this.dao.insert(createEntity2);
        Long l3 = (Long) this.daoAccess.getKey(createEntity);
        AndroidTestCase.assertNotNull(l3);
        Long l5 = (Long) this.daoAccess.getKey(createEntity2);
        AndroidTestCase.assertNotNull(l5);
        AndroidTestCase.assertFalse(l3.equals(l5));
        AndroidTestCase.assertNotNull(this.dao.load(l3));
        AndroidTestCase.assertNotNull(this.dao.load(l5));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.greenrobot.greendao.test.AbstractDaoTestSinglePk
    public Long createRandomPk() {
        return Long.valueOf(this.random.nextLong());
    }
}
