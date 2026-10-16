package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import oh.r;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements SQLiteDatabase.CursorFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2825a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2826b;

    public /* synthetic */ a(Object obj, int i3) {
        this.f2825a = i3;
        this.f2826b = obj;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        Cursor query$lambda$1;
        Cursor query$lambda$0;
        switch (this.f2825a) {
            case 0:
                query$lambda$1 = FrameworkSQLiteDatabase.query$lambda$1((SupportSQLiteQuery) this.f2826b, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                return query$lambda$1;
            default:
                query$lambda$0 = FrameworkSQLiteDatabase.query$lambda$0((r) this.f2826b, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                return query$lambda$0;
        }
    }
}
