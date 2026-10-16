package com.example.database.api;

import net.zetetic.database.sqlcipher.SQLiteStatement;
import org.greenrobot.greendao.database.DatabaseStatement;

/* loaded from: classes.dex */
public class SqlCipherStatement implements DatabaseStatement {
    private final SQLiteStatement delegate;

    public SqlCipherStatement(SQLiteStatement sQLiteStatement) {
        this.delegate = sQLiteStatement;
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public void bindBlob(int i3, byte[] bArr) {
        this.delegate.bindBlob(i3, bArr);
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public void bindDouble(int i3, double d5) {
        this.delegate.bindDouble(i3, d5);
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public void bindLong(int i3, long j4) {
        this.delegate.bindLong(i3, j4);
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public void bindNull(int i3) {
        this.delegate.f(i3, null);
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public void bindString(int i3, String str) {
        this.delegate.bindString(i3, str);
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public void clearBindings() {
        this.delegate.clearBindings();
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public void close() {
        this.delegate.e();
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public void execute() {
        this.delegate.execute();
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public long executeInsert() {
        return this.delegate.executeInsert();
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public Object getRawStatement() {
        return this.delegate;
    }

    @Override // org.greenrobot.greendao.database.DatabaseStatement
    public long simpleQueryForLong() {
        return this.delegate.simpleQueryForLong();
    }
}
