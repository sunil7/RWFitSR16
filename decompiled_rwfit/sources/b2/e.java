package b2;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f3099j = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: b, reason: collision with root package name */
    public final String[] f3101b;

    /* renamed from: c, reason: collision with root package name */
    public final WorkDatabase_Impl f3102c;

    /* renamed from: f, reason: collision with root package name */
    public volatile SupportSQLiteStatement f3104f;

    /* renamed from: g, reason: collision with root package name */
    public final c f3105g;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f3103d = new AtomicBoolean(false);
    public volatile boolean e = false;

    /* renamed from: h, reason: collision with root package name */
    public final j.f f3106h = new j.f();

    /* renamed from: i, reason: collision with root package name */
    public final androidx.activity.e f3107i = new androidx.activity.e(this, 7);

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3100a = new HashMap();

    public e(WorkDatabase_Impl workDatabase_Impl, HashMap hashMap, HashMap hashMap2, String... strArr) {
        this.f3102c = workDatabase_Impl;
        this.f3105g = new c(strArr.length);
        Collections.newSetFromMap(new IdentityHashMap());
        int length = strArr.length;
        this.f3101b = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr[i3];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.f3100a.put(lowerCase, Integer.valueOf(i3));
            String str2 = (String) hashMap.get(strArr[i3]);
            if (str2 != null) {
                this.f3101b[i3] = str2.toLowerCase(locale);
            } else {
                this.f3101b[i3] = lowerCase;
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            String lowerCase2 = str3.toLowerCase(locale2);
            if (this.f3100a.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) entry.getKey()).toLowerCase(locale2);
                HashMap hashMap3 = this.f3100a;
                hashMap3.put(lowerCase3, hashMap3.get(lowerCase2));
            }
        }
    }

    public final boolean a() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.f3102c.f3121a;
        if (!(supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen())) {
            return false;
        }
        if (!this.e) {
            this.f3102c.f3123c.getWritableDatabase();
        }
        if (this.e) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final void b(SupportSQLiteDatabase supportSQLiteDatabase, int i3) {
        supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i3 + ", 0)");
        String str = this.f3101b[i3];
        StringBuilder sb2 = new StringBuilder();
        String[] strArr = f3099j;
        for (int i10 = 0; i10 < 3; i10++) {
            String str2 = strArr[i10];
            sb2.setLength(0);
            sb2.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            sb2.append("`");
            sb2.append("room_table_modification_trigger_");
            android.support.v4.media.session.e.z(sb2, str, "_", str2, "`");
            android.support.v4.media.session.e.z(sb2, " AFTER ", str2, " ON `", str);
            android.support.v4.media.session.e.z(sb2, "` BEGIN UPDATE ", "room_table_modification_log", " SET ", "invalidated");
            android.support.v4.media.session.e.z(sb2, " = 1", " WHERE ", "table_id", " = ");
            sb2.append(i3);
            sb2.append(" AND ");
            sb2.append("invalidated");
            sb2.append(" = 0");
            sb2.append("; END");
            supportSQLiteDatabase.execSQL(sb2.toString());
        }
    }

    public final void c(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (supportSQLiteDatabase.inTransaction()) {
            return;
        }
        while (true) {
            try {
                ReentrantReadWriteLock.ReadLock readLock = this.f3102c.f3127h.readLock();
                readLock.lock();
                try {
                    int[] a3 = this.f3105g.a();
                    if (a3 == null) {
                        readLock.unlock();
                        return;
                    }
                    int length = a3.length;
                    supportSQLiteDatabase.beginTransaction();
                    for (int i3 = 0; i3 < length; i3++) {
                        try {
                            int i10 = a3[i3];
                            if (i10 == 1) {
                                b(supportSQLiteDatabase, i3);
                            } else if (i10 == 2) {
                                String str = this.f3101b[i3];
                                StringBuilder sb2 = new StringBuilder();
                                String[] strArr = f3099j;
                                for (int i11 = 0; i11 < 3; i11++) {
                                    String str2 = strArr[i11];
                                    sb2.setLength(0);
                                    sb2.append("DROP TRIGGER IF EXISTS ");
                                    sb2.append("`");
                                    sb2.append("room_table_modification_trigger_");
                                    sb2.append(str);
                                    sb2.append("_");
                                    sb2.append(str2);
                                    sb2.append("`");
                                    supportSQLiteDatabase.execSQL(sb2.toString());
                                }
                            }
                        } catch (Throwable th2) {
                            supportSQLiteDatabase.endTransaction();
                            throw th2;
                        }
                    }
                    supportSQLiteDatabase.setTransactionSuccessful();
                    supportSQLiteDatabase.endTransaction();
                    c cVar = this.f3105g;
                    synchronized (cVar) {
                        cVar.e = false;
                    }
                    readLock.unlock();
                } catch (Throwable th3) {
                    readLock.unlock();
                    throw th3;
                }
            } catch (SQLiteException | IllegalStateException e) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                return;
            }
        }
    }
}
