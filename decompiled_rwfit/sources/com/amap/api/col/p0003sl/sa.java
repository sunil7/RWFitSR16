package com.amap.api.col.p0003sl;

import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes.dex */
public interface sa {
    String getDBName();

    int getVersion();

    void onCreate(SQLiteDatabase sQLiteDatabase);

    void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i10);
}
