package g8;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class g implements c, h8.b {
    public static final x7.b e = new x7.b("proto");

    /* renamed from: a, reason: collision with root package name */
    public final j f13887a;

    /* renamed from: b, reason: collision with root package name */
    public final i8.a f13888b;

    /* renamed from: c, reason: collision with root package name */
    public final i8.a f13889c;

    /* renamed from: d, reason: collision with root package name */
    public final a f13890d;

    public g(i8.a aVar, i8.a aVar2, a aVar3, j jVar) {
        this.f13887a = jVar;
        this.f13888b = aVar;
        this.f13889c = aVar2;
        this.f13890d = aVar3;
    }

    public static Long c(SQLiteDatabase sQLiteDatabase, a8.b bVar) {
        StringBuilder sb2 = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(bVar.f120a, String.valueOf(j8.a.a(bVar.f122c))));
        byte[] bArr = bVar.f121b;
        if (bArr != null) {
            sb2.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb2.append(" and extras is null");
        }
        Cursor query = sQLiteDatabase.query("transport_contexts", new String[]{FileDownloadModel.ID}, sb2.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            Cursor cursor = query;
            return !cursor.moveToNext() ? null : Long.valueOf(cursor.getLong(0));
        } finally {
            query.close();
        }
    }

    public static String g(Iterable iterable) {
        StringBuilder sb2 = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb2.append(((b) it.next()).f13881a);
            if (it.hasNext()) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public static Object h(Cursor cursor, e eVar) {
        try {
            return eVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public final SQLiteDatabase b() {
        j jVar = this.f13887a;
        jVar.getClass();
        i8.a aVar = this.f13889c;
        long c9 = aVar.c();
        while (true) {
            try {
                return jVar.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e10) {
                if (aVar.c() >= this.f13890d.f13879c + c9) {
                    throw new SynchronizationException("Timed out while trying to open db.", e10);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f13887a.close();
    }

    public final Object e(e eVar) {
        SQLiteDatabase b3 = b();
        b3.beginTransaction();
        try {
            Object apply = eVar.apply(b3);
            b3.setTransactionSuccessful();
            return apply;
        } finally {
            b3.endTransaction();
        }
    }

    public final Object f(h8.a aVar) {
        SQLiteDatabase b3 = b();
        i8.a aVar2 = this.f13889c;
        long c9 = aVar2.c();
        while (true) {
            try {
                b3.beginTransaction();
                try {
                    Object execute = aVar.execute();
                    b3.setTransactionSuccessful();
                    return execute;
                } finally {
                    b3.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e10) {
                if (aVar2.c() >= this.f13890d.f13879c + c9) {
                    throw new SynchronizationException("Timed out while trying to acquire the lock.", e10);
                }
                SystemClock.sleep(50L);
            }
        }
    }
}
