package org.greenrobot.greendao.test;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;

/* loaded from: classes2.dex */
public abstract class AbstractDaoSessionTest<T extends AbstractDaoMaster, S extends AbstractDaoSession> extends DbTest {
    protected T daoMaster;
    private final Class<T> daoMasterClass;
    protected S daoSession;

    public AbstractDaoSessionTest(Class<T> cls) {
        this(cls, true);
    }

    @Override // org.greenrobot.greendao.test.DbTest
    public void setUp() throws Exception {
        super.setUp();
        try {
            this.daoMaster = this.daoMasterClass.getConstructor(Database.class).newInstance(this.f16961db);
            this.daoMasterClass.getMethod("createAllTables", Database.class, Boolean.TYPE).invoke(null, this.f16961db, Boolean.FALSE);
            this.daoSession = (S) this.daoMaster.newSession();
        } catch (Exception e) {
            throw new RuntimeException("Could not prepare DAO session test", e);
        }
    }

    public AbstractDaoSessionTest(Class<T> cls, boolean z5) {
        super(z5);
        this.daoMasterClass = cls;
    }
}
