package com.amap.api.col.p0003sl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes.dex */
public final class wa extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private sa f5243a;

    public wa(Context context, String str, int i3, sa saVar) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i3);
        this.f5243a = saVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f5243a.onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i10) {
        this.f5243a.onUpgrade(sQLiteDatabase, i3, i10);
    }
}
