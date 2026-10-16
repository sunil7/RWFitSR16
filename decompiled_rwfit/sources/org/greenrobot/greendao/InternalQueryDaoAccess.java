package org.greenrobot.greendao;

import android.database.Cursor;
import java.util.List;
import org.greenrobot.greendao.internal.TableStatements;

/* loaded from: classes2.dex */
public final class InternalQueryDaoAccess<T> {
    private final AbstractDao<T, ?> dao;

    public InternalQueryDaoAccess(AbstractDao<T, ?> abstractDao) {
        this.dao = abstractDao;
    }

    public TableStatements getStatements() {
        return this.dao.getStatements();
    }

    public List<T> loadAllAndCloseCursor(Cursor cursor) {
        return this.dao.loadAllAndCloseCursor(cursor);
    }

    public T loadCurrent(Cursor cursor, int i3, boolean z5) {
        return this.dao.loadCurrent(cursor, i3, z5);
    }

    public T loadUniqueAndCloseCursor(Cursor cursor) {
        return this.dao.loadUniqueAndCloseCursor(cursor);
    }

    public static <T2> TableStatements getStatements(AbstractDao<T2, ?> abstractDao) {
        return abstractDao.getStatements();
    }
}
