package b2;

import android.database.Cursor;
import android.os.Looper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public volatile SupportSQLiteDatabase f3121a;

    /* renamed from: b, reason: collision with root package name */
    public Executor f3122b;

    /* renamed from: c, reason: collision with root package name */
    public SupportSQLiteOpenHelper f3123c;

    /* renamed from: d, reason: collision with root package name */
    public final e f3124d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3125f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f3126g;

    /* renamed from: h, reason: collision with root package name */
    public final ReentrantReadWriteLock f3127h = new ReentrantReadWriteLock();

    /* renamed from: i, reason: collision with root package name */
    public final ThreadLocal f3128i = new ThreadLocal();

    public i() {
        new ConcurrentHashMap();
        this.f3124d = d();
    }

    public final void a() {
        if (!this.e && Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void b() {
        if (!this.f3123c.getWritableDatabase().inTransaction() && this.f3128i.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public final void c() {
        a();
        SupportSQLiteDatabase writableDatabase = this.f3123c.getWritableDatabase();
        this.f3124d.c(writableDatabase);
        writableDatabase.beginTransaction();
    }

    public abstract e d();

    public abstract SupportSQLiteOpenHelper e(a aVar);

    public final void f() {
        this.f3123c.getWritableDatabase().endTransaction();
        if (this.f3123c.getWritableDatabase().inTransaction()) {
            return;
        }
        e eVar = this.f3124d;
        if (eVar.f3103d.compareAndSet(false, true)) {
            eVar.f3102c.f3122b.execute(eVar.f3107i);
        }
    }

    public final Cursor g(SupportSQLiteQuery supportSQLiteQuery) {
        a();
        b();
        return this.f3123c.getWritableDatabase().query(supportSQLiteQuery);
    }

    public final void h() {
        this.f3123c.getWritableDatabase().setTransactionSuccessful();
    }
}
