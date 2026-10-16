package p2;

import android.content.Context;
import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.ListenableWorker;
import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import de.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public final class m implements Runnable {

    /* renamed from: s, reason: collision with root package name */
    public static final String f17433s = o2.m.i("WorkerWrapper");

    /* renamed from: a, reason: collision with root package name */
    public Context f17434a;

    /* renamed from: b, reason: collision with root package name */
    public String f17435b;

    /* renamed from: c, reason: collision with root package name */
    public List f17436c;

    /* renamed from: d, reason: collision with root package name */
    public x2.h f17437d;
    public ListenableWorker e;

    /* renamed from: f, reason: collision with root package name */
    public o f17438f;

    /* renamed from: g, reason: collision with root package name */
    public o2.l f17439g;

    /* renamed from: h, reason: collision with root package name */
    public o2.b f17440h;

    /* renamed from: i, reason: collision with root package name */
    public b f17441i;

    /* renamed from: j, reason: collision with root package name */
    public WorkDatabase f17442j;

    /* renamed from: k, reason: collision with root package name */
    public p0.f f17443k;

    /* renamed from: l, reason: collision with root package name */
    public o4.e f17444l;

    /* renamed from: m, reason: collision with root package name */
    public o4.c f17445m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f17446n;

    /* renamed from: o, reason: collision with root package name */
    public String f17447o;

    /* renamed from: p, reason: collision with root package name */
    public androidx.work.impl.utils.futures.b f17448p;

    /* renamed from: q, reason: collision with root package name */
    public ob.a f17449q;
    public volatile boolean r;

    public final void a(o2.l lVar) {
        boolean z5 = lVar instanceof o2.k;
        String str = f17433s;
        if (!z5) {
            if (lVar instanceof o2.j) {
                o2.m.g().h(str, l0.n("Worker result RETRY for ", this.f17447o), new Throwable[0]);
                d();
                return;
            }
            o2.m.g().h(str, l0.n("Worker result FAILURE for ", this.f17447o), new Throwable[0]);
            if (this.f17437d.c()) {
                e();
                return;
            } else {
                h();
                return;
            }
        }
        o2.m.g().h(str, l0.n("Worker result SUCCESS for ", this.f17447o), new Throwable[0]);
        if (this.f17437d.c()) {
            e();
            return;
        }
        o4.e eVar = this.f17444l;
        String str2 = this.f17435b;
        p0.f fVar = this.f17443k;
        WorkDatabase workDatabase = this.f17442j;
        workDatabase.c();
        try {
            fVar.m(WorkInfo$State.SUCCEEDED, str2);
            fVar.k(str2, ((o2.k) this.f17439g).f16717a);
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList b3 = eVar.b(str2);
            int size = b3.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = b3.get(i3);
                i3++;
                String str3 = (String) obj;
                if (fVar.f(str3) == WorkInfo$State.BLOCKED) {
                    b2.l b10 = b2.l.b(1, "SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)");
                    if (str3 == null) {
                        b10.bindNull(1);
                    } else {
                        b10.bindString(1, str3);
                    }
                    WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) eVar.f16737a;
                    workDatabase_Impl.b();
                    Cursor g10 = workDatabase_Impl.g(b10);
                    try {
                        if (g10.moveToFirst() && g10.getInt(0) != 0) {
                            o2.m.g().h(str, "Setting status to enqueued for " + str3, new Throwable[0]);
                            fVar.m(WorkInfo$State.ENQUEUED, str3);
                            fVar.l(currentTimeMillis, str3);
                        }
                    } finally {
                        g10.close();
                        b10.c();
                    }
                }
            }
            workDatabase.h();
            workDatabase.f();
            f(false);
        } catch (Throwable th2) {
            workDatabase.f();
            f(false);
            throw th2;
        }
    }

    public final void b(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            p0.f fVar = this.f17443k;
            if (fVar.f(str2) != WorkInfo$State.CANCELLED) {
                fVar.m(WorkInfo$State.FAILED, str2);
            }
            linkedList.addAll(this.f17444l.b(str2));
        }
    }

    public final void c() {
        boolean i3 = i();
        String str = this.f17435b;
        WorkDatabase workDatabase = this.f17442j;
        if (!i3) {
            workDatabase.c();
            try {
                WorkInfo$State f2 = this.f17443k.f(str);
                n.l m10 = workDatabase.m();
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) m10.f16245b;
                workDatabase_Impl.b();
                x2.e eVar = (x2.e) m10.f16246c;
                SupportSQLiteStatement a3 = eVar.a();
                if (str == null) {
                    a3.bindNull(1);
                } else {
                    a3.bindString(1, str);
                }
                workDatabase_Impl.c();
                try {
                    a3.executeUpdateDelete();
                    workDatabase_Impl.h();
                    if (f2 == null) {
                        f(false);
                    } else if (f2 == WorkInfo$State.RUNNING) {
                        a(this.f17439g);
                    } else if (!f2.isFinished()) {
                        d();
                    }
                    workDatabase.h();
                    workDatabase.f();
                } finally {
                    workDatabase_Impl.f();
                    eVar.c(a3);
                }
            } catch (Throwable th2) {
                workDatabase.f();
                throw th2;
            }
        }
        List list = this.f17436c;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((c) it.next()).b(str);
            }
            d.a(this.f17440h, workDatabase, list);
        }
    }

    public final void d() {
        String str = this.f17435b;
        p0.f fVar = this.f17443k;
        WorkDatabase workDatabase = this.f17442j;
        workDatabase.c();
        try {
            fVar.m(WorkInfo$State.ENQUEUED, str);
            fVar.l(System.currentTimeMillis(), str);
            fVar.j(-1L, str);
            workDatabase.h();
        } finally {
            workDatabase.f();
            f(true);
        }
    }

    public final void e() {
        String str = this.f17435b;
        p0.f fVar = this.f17443k;
        WorkDatabase workDatabase = this.f17442j;
        workDatabase.c();
        try {
            fVar.l(System.currentTimeMillis(), str);
            fVar.m(WorkInfo$State.ENQUEUED, str);
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) fVar.f17315a;
            workDatabase_Impl.b();
            x2.e eVar = (x2.e) fVar.f17320g;
            SupportSQLiteStatement a3 = eVar.a();
            if (str == null) {
                a3.bindNull(1);
            } else {
                a3.bindString(1, str);
            }
            workDatabase_Impl.c();
            try {
                a3.executeUpdateDelete();
                workDatabase_Impl.h();
                workDatabase_Impl.f();
                eVar.c(a3);
                fVar.j(-1L, str);
                workDatabase.h();
            } catch (Throwable th2) {
                workDatabase_Impl.f();
                eVar.c(a3);
                throw th2;
            }
        } finally {
            workDatabase.f();
            f(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:3:0x0005, B:10:0x0031, B:12:0x0039, B:14:0x0045, B:15:0x005b, B:17:0x005f, B:19:0x0063, B:21:0x0069, B:22:0x006f, B:30:0x007c, B:32:0x007d, B:38:0x0091, B:39:0x0097, B:24:0x0070, B:25:0x0078, B:5:0x0020, B:7:0x0026), top: B:2:0x0005, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:3:0x0005, B:10:0x0031, B:12:0x0039, B:14:0x0045, B:15:0x005b, B:17:0x005f, B:19:0x0063, B:21:0x0069, B:22:0x006f, B:30:0x007c, B:32:0x007d, B:38:0x0091, B:39:0x0097, B:24:0x0070, B:25:0x0078, B:5:0x0020, B:7:0x0026), top: B:2:0x0005, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(boolean r5) {
        /*
            r4 = this;
            androidx.work.impl.WorkDatabase r0 = r4.f17442j
            r0.c()
            androidx.work.impl.WorkDatabase r0 = r4.f17442j     // Catch: java.lang.Throwable -> L41
            p0.f r0 = r0.n()     // Catch: java.lang.Throwable -> L41
            r0.getClass()     // Catch: java.lang.Throwable -> L41
            java.lang.String r1 = "SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1"
            r2 = 0
            b2.l r1 = b2.l.b(r2, r1)     // Catch: java.lang.Throwable -> L41
            java.lang.Object r0 = r0.f17315a     // Catch: java.lang.Throwable -> L41
            androidx.work.impl.WorkDatabase_Impl r0 = (androidx.work.impl.WorkDatabase_Impl) r0     // Catch: java.lang.Throwable -> L41
            r0.b()     // Catch: java.lang.Throwable -> L41
            android.database.Cursor r0 = r0.g(r1)     // Catch: java.lang.Throwable -> L41
            boolean r3 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L2e
            if (r3 == 0) goto L30
            int r3 = r0.getInt(r2)     // Catch: java.lang.Throwable -> L2e
            if (r3 == 0) goto L30
            r3 = 1
            goto L31
        L2e:
            r5 = move-exception
            goto L91
        L30:
            r3 = r2
        L31:
            r0.close()     // Catch: java.lang.Throwable -> L41
            r1.c()     // Catch: java.lang.Throwable -> L41
            if (r3 != 0) goto L43
            android.content.Context r0 = r4.f17434a     // Catch: java.lang.Throwable -> L41
            java.lang.Class<androidx.work.impl.background.systemalarm.RescheduleReceiver> r1 = androidx.work.impl.background.systemalarm.RescheduleReceiver.class
            y2.g.a(r0, r1, r2)     // Catch: java.lang.Throwable -> L41
            goto L43
        L41:
            r5 = move-exception
            goto L98
        L43:
            if (r5 == 0) goto L5b
            p0.f r0 = r4.f17443k     // Catch: java.lang.Throwable -> L41
            androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo$State.ENQUEUED     // Catch: java.lang.Throwable -> L41
            java.lang.String r2 = r4.f17435b     // Catch: java.lang.Throwable -> L41
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L41
            r0.m(r1, r2)     // Catch: java.lang.Throwable -> L41
            p0.f r0 = r4.f17443k     // Catch: java.lang.Throwable -> L41
            java.lang.String r1 = r4.f17435b     // Catch: java.lang.Throwable -> L41
            r2 = -1
            r0.j(r2, r1)     // Catch: java.lang.Throwable -> L41
        L5b:
            x2.h r0 = r4.f17437d     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L7d
            androidx.work.ListenableWorker r0 = r4.e     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L7d
            boolean r0 = r0.a()     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L7d
            p2.b r0 = r4.f17441i     // Catch: java.lang.Throwable -> L41
            java.lang.String r1 = r4.f17435b     // Catch: java.lang.Throwable -> L41
            java.lang.Object r2 = r0.f17400k     // Catch: java.lang.Throwable -> L41
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L41
            java.util.HashMap r3 = r0.f17395f     // Catch: java.lang.Throwable -> L7a
            r3.remove(r1)     // Catch: java.lang.Throwable -> L7a
            r0.h()     // Catch: java.lang.Throwable -> L7a
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L7a
            goto L7d
        L7a:
            r5 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L7a
            throw r5     // Catch: java.lang.Throwable -> L41
        L7d:
            androidx.work.impl.WorkDatabase r0 = r4.f17442j     // Catch: java.lang.Throwable -> L41
            r0.h()     // Catch: java.lang.Throwable -> L41
            androidx.work.impl.WorkDatabase r0 = r4.f17442j
            r0.f()
            androidx.work.impl.utils.futures.b r0 = r4.f17448p
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r0.j(r5)
            return
        L91:
            r0.close()     // Catch: java.lang.Throwable -> L41
            r1.c()     // Catch: java.lang.Throwable -> L41
            throw r5     // Catch: java.lang.Throwable -> L41
        L98:
            androidx.work.impl.WorkDatabase r0 = r4.f17442j
            r0.f()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.m.f(boolean):void");
    }

    public final void g() {
        p0.f fVar = this.f17443k;
        String str = this.f17435b;
        WorkInfo$State f2 = fVar.f(str);
        WorkInfo$State workInfo$State = WorkInfo$State.RUNNING;
        String str2 = f17433s;
        if (f2 == workInfo$State) {
            o2.m.g().d(str2, l0.o("Status for ", str, " is RUNNING;not doing any work and rescheduling for later execution"), new Throwable[0]);
            f(true);
            return;
        }
        o2.m.g().d(str2, "Status for " + str + " is " + f2 + "; not doing any work", new Throwable[0]);
        f(false);
    }

    public final void h() {
        String str = this.f17435b;
        WorkDatabase workDatabase = this.f17442j;
        workDatabase.c();
        try {
            b(str);
            this.f17443k.k(str, ((o2.i) this.f17439g).f16716a);
            workDatabase.h();
        } finally {
            workDatabase.f();
            f(false);
        }
    }

    public final boolean i() {
        if (!this.r) {
            return false;
        }
        o2.m.g().d(f17433s, l0.n("Work interrupted for ", this.f17447o), new Throwable[0]);
        if (this.f17443k.f(this.f17435b) == null) {
            f(false);
            return true;
        }
        f(!r0.isFinished());
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bd, code lost:
    
        if ((r6.f19750b == r10 && r6.f19758k > 0) != false) goto L35;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 728
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.m.run():void");
    }
}
