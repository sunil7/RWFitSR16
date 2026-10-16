package org.greenrobot.greendao.database;

/* loaded from: classes2.dex */
public interface DatabaseStatement {
    void bindBlob(int i3, byte[] bArr);

    void bindDouble(int i3, double d5);

    void bindLong(int i3, long j4);

    void bindNull(int i3);

    void bindString(int i3, String str);

    void clearBindings();

    void close();

    void execute();

    long executeInsert();

    Object getRawStatement();

    long simpleQueryForLong();
}
