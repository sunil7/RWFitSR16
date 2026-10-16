package com.example.database.api;

import android.database.Cursor;
import android.database.SQLException;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

/* loaded from: classes.dex */
public class SqlCipherDatabase implements Database {
    private final SQLiteDatabase delegate;

    public SqlCipherDatabase(SQLiteDatabase sQLiteDatabase) {
        this.delegate = sQLiteDatabase;
    }

    @Override // org.greenrobot.greendao.database.Database
    public void beginTransaction() {
        this.delegate.beginTransaction();
    }

    @Override // org.greenrobot.greendao.database.Database
    public void close() {
        this.delegate.e();
    }

    @Override // org.greenrobot.greendao.database.Database
    public DatabaseStatement compileStatement(String str) {
        return new SqlCipherStatement(this.delegate.compileStatement(str));
    }

    @Override // org.greenrobot.greendao.database.Database
    public void endTransaction() {
        this.delegate.endTransaction();
    }

    @Override // org.greenrobot.greendao.database.Database
    public void execSQL(String str) throws SQLException {
        this.delegate.j(str, null);
    }

    @Override // org.greenrobot.greendao.database.Database
    public Object getRawDatabase() {
        return this.delegate;
    }

    @Override // org.greenrobot.greendao.database.Database
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override // org.greenrobot.greendao.database.Database
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    @Override // org.greenrobot.greendao.database.Database
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // org.greenrobot.greendao.database.Database
    public Cursor rawQuery(String str, String[] strArr) {
        return this.delegate.I(str, strArr);
    }

    @Override // org.greenrobot.greendao.database.Database
    public void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }

    @Override // org.greenrobot.greendao.database.Database
    public void execSQL(String str, Object[] objArr) throws SQLException {
        this.delegate.execSQL(str, objArr);
    }
}
