package p2;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.room.RoomDatabase$JournalMode;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.work.R$bool;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.background.systemjob.SystemJobService;
import com.google.android.gms.internal.mlkit_vision_barcode.Cif;
import de.o;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class l extends Cif {

    /* renamed from: j, reason: collision with root package name */
    public static l f17422j;

    /* renamed from: k, reason: collision with root package name */
    public static l f17423k;

    /* renamed from: l, reason: collision with root package name */
    public static final Object f17424l;

    /* renamed from: a, reason: collision with root package name */
    public final Context f17425a;

    /* renamed from: b, reason: collision with root package name */
    public final o2.b f17426b;

    /* renamed from: c, reason: collision with root package name */
    public final WorkDatabase f17427c;

    /* renamed from: d, reason: collision with root package name */
    public final o f17428d;
    public final List e;

    /* renamed from: f, reason: collision with root package name */
    public final b f17429f;

    /* renamed from: g, reason: collision with root package name */
    public final n6.a f17430g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f17431h;

    /* renamed from: i, reason: collision with root package name */
    public BroadcastReceiver.PendingResult f17432i;

    static {
        o2.m.i("WorkManagerImpl");
        f17422j = null;
        f17423k = null;
        f17424l = new Object();
    }

    public l(Context context, o2.b bVar, o oVar) {
        b2.g gVar;
        Executor executor;
        String str;
        boolean z5 = context.getResources().getBoolean(R$bool.workmanager_test_configuration);
        Context applicationContext = context.getApplicationContext();
        y2.i iVar = (y2.i) oVar.f12377b;
        int i3 = WorkDatabase.f3006k;
        if (z5) {
            gVar = new b2.g(applicationContext, null);
            gVar.f3114g = true;
        } else {
            String str2 = k.f17420a;
            gVar = new b2.g(applicationContext, "androidx.work.workdb");
            gVar.f3113f = new f(applicationContext);
        }
        gVar.f3112d = iVar;
        g gVar2 = new g();
        if (gVar.f3111c == null) {
            gVar.f3111c = new ArrayList();
        }
        gVar.f3111c.add(gVar2);
        gVar.a(j.f17414a);
        gVar.a(new i(applicationContext, 2, 3));
        gVar.a(j.f17415b);
        gVar.a(j.f17416c);
        gVar.a(new i(applicationContext, 5, 6));
        gVar.a(j.f17417d);
        gVar.a(j.e);
        gVar.a(j.f17418f);
        gVar.a(new i(applicationContext));
        gVar.a(new i(applicationContext, 10, 11));
        gVar.a(j.f17419g);
        gVar.f3116i = false;
        gVar.f3117j = true;
        if (gVar.f3110b == null) {
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }
        Executor executor2 = gVar.f3112d;
        if (executor2 == null && gVar.e == null) {
            w.a aVar = i.a.f14328d;
            gVar.e = aVar;
            gVar.f3112d = aVar;
        } else if (executor2 != null && gVar.e == null) {
            gVar.e = executor2;
        } else if (executor2 == null && (executor = gVar.e) != null) {
            gVar.f3112d = executor;
        }
        if (gVar.f3113f == null) {
            gVar.f3113f = new FrameworkSQLiteOpenHelperFactory();
        }
        SupportSQLiteOpenHelper.Factory factory = gVar.f3113f;
        ArrayList arrayList = gVar.f3111c;
        boolean z6 = gVar.f3114g;
        RoomDatabase$JournalMode roomDatabase$JournalMode = gVar.f3115h;
        Context context2 = gVar.f3110b;
        RoomDatabase$JournalMode resolve = roomDatabase$JournalMode.resolve(context2);
        Executor executor3 = gVar.f3112d;
        b2.a aVar2 = new b2.a(context2, gVar.f3109a, factory, gVar.f3118k, arrayList, z6, resolve, executor3, gVar.e, gVar.f3116i, gVar.f3117j);
        String name = WorkDatabase.class.getPackage().getName();
        String canonicalName = WorkDatabase.class.getCanonicalName();
        String str3 = (name.isEmpty() ? canonicalName : canonicalName.substring(name.length() + 1)).replace('.', '_') + "_Impl";
        try {
            if (name.isEmpty()) {
                str = str3;
            } else {
                str = name + "." + str3;
            }
            b2.i iVar2 = (b2.i) Class.forName(str).newInstance();
            SupportSQLiteOpenHelper e = iVar2.e(aVar2);
            iVar2.f3123c = e;
            if (e instanceof b2.m) {
                ((b2.m) e).getClass();
            }
            boolean z8 = resolve == RoomDatabase$JournalMode.WRITE_AHEAD_LOGGING;
            e.setWriteAheadLoggingEnabled(z8);
            iVar2.f3126g = arrayList;
            iVar2.f3122b = executor3;
            new ArrayDeque();
            iVar2.e = z6;
            iVar2.f3125f = z8;
            WorkDatabase workDatabase = (WorkDatabase) iVar2;
            Context applicationContext2 = context.getApplicationContext();
            o2.m mVar = new o2.m((byte) 0, bVar.f16695f, 0);
            synchronized (o2.m.class) {
                o2.m.f16718c = mVar;
            }
            String str4 = d.f17401a;
            s2.c cVar = new s2.c(applicationContext2, this);
            y2.g.a(applicationContext2, SystemJobService.class, true);
            o2.m.g().d(d.f17401a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            List asList = Arrays.asList(cVar, new q2.b(applicationContext2, bVar, oVar, this));
            b bVar2 = new b(context, bVar, oVar, workDatabase, asList);
            Context applicationContext3 = context.getApplicationContext();
            this.f17425a = applicationContext3;
            this.f17426b = bVar;
            this.f17428d = oVar;
            this.f17427c = workDatabase;
            this.e = asList;
            this.f17429f = bVar2;
            this.f17430g = new n6.a(workDatabase, 29);
            this.f17431h = false;
            if (applicationContext3.isDeviceProtectedStorage()) {
                throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
            }
            this.f17428d.p(new y2.e(applicationContext3, this));
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("cannot find implementation for " + WorkDatabase.class.getCanonicalName() + ". " + str3 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor" + WorkDatabase.class.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + WorkDatabase.class.getCanonicalName());
        }
    }

    public static l a(Context context) {
        l lVar;
        Object obj = f17424l;
        synchronized (obj) {
            try {
                synchronized (obj) {
                    lVar = f17422j;
                    if (lVar == null) {
                        lVar = f17423k;
                    }
                }
                return lVar;
            } catch (Throwable th2) {
                throw th2;
            } finally {
            }
        }
        if (lVar != null) {
            return lVar;
        }
        context.getApplicationContext();
        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
    }

    public final void b() {
        synchronized (f17424l) {
            try {
                this.f17431h = true;
                BroadcastReceiver.PendingResult pendingResult = this.f17432i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.f17432i = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c() {
        ArrayList c9;
        WorkDatabase workDatabase = this.f17427c;
        Context context = this.f17425a;
        String str = s2.c.e;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (c9 = s2.c.c(context, jobScheduler)) != null && !c9.isEmpty()) {
            int size = c9.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = c9.get(i3);
                i3++;
                s2.c.a(jobScheduler, ((JobInfo) obj).getId());
            }
        }
        p0.f n4 = workDatabase.n();
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) n4.f17315a;
        workDatabase_Impl.b();
        x2.e eVar = (x2.e) n4.f17322i;
        SupportSQLiteStatement a3 = eVar.a();
        workDatabase_Impl.c();
        try {
            a3.executeUpdateDelete();
            workDatabase_Impl.h();
            workDatabase_Impl.f();
            eVar.c(a3);
            d.a(this.f17426b, workDatabase, this.e);
        } catch (Throwable th2) {
            workDatabase_Impl.f();
            eVar.c(a3);
            throw th2;
        }
    }

    public final void d(String str, eb.e eVar) {
        o oVar = this.f17428d;
        e8.a aVar = new e8.a(11);
        aVar.f12474b = this;
        aVar.f12475c = str;
        aVar.f12476d = eVar;
        oVar.p(aVar);
    }
}
