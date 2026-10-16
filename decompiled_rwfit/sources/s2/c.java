package s2;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import com.google.android.gms.internal.mlkit_vision_barcode.ic;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import o2.m;
import p2.l;
import x2.d;
import x2.h;
import y2.f;

/* loaded from: classes.dex */
public final class c implements p2.c {
    public static final String e = m.i("SystemJobScheduler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f18159a;

    /* renamed from: b, reason: collision with root package name */
    public final JobScheduler f18160b;

    /* renamed from: c, reason: collision with root package name */
    public final l f18161c;

    /* renamed from: d, reason: collision with root package name */
    public final b f18162d;

    public c(Context context, l lVar) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        b bVar = new b(context);
        this.f18159a = context;
        this.f18161c = lVar;
        this.f18160b = jobScheduler;
        this.f18162d = bVar;
    }

    public static void a(JobScheduler jobScheduler, int i3) {
        try {
            jobScheduler.cancel(i3);
        } catch (Throwable th2) {
            m.g().f(e, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i3)), th2);
        }
    }

    public static ArrayList c(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th2) {
            m.g().f(e, "getAllPendingJobs() is not reliable on this device.", th2);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : list) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0018 A[SYNTHETIC] */
    @Override // p2.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.String r12) {
        /*
            r11 = this;
            android.content.Context r0 = r11.f18159a
            android.app.job.JobScheduler r1 = r11.f18160b
            java.util.ArrayList r0 = c(r0, r1)
            r2 = 0
            r3 = 0
            if (r0 != 0) goto Ld
            goto L49
        Ld:
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 2
            r4.<init>(r5)
            int r5 = r0.size()
            r6 = r2
        L18:
            if (r6 >= r5) goto L48
            java.lang.Object r7 = r0.get(r6)
            int r6 = r6 + 1
            android.app.job.JobInfo r7 = (android.app.job.JobInfo) r7
            java.lang.String r8 = "EXTRA_WORK_SPEC_ID"
            android.os.PersistableBundle r9 = r7.getExtras()
            if (r9 == 0) goto L35
            boolean r10 = r9.containsKey(r8)     // Catch: java.lang.NullPointerException -> L35
            if (r10 == 0) goto L35
            java.lang.String r8 = r9.getString(r8)     // Catch: java.lang.NullPointerException -> L35
            goto L36
        L35:
            r8 = r3
        L36:
            boolean r8 = r12.equals(r8)
            if (r8 == 0) goto L18
            int r7 = r7.getId()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r4.add(r7)
            goto L18
        L48:
            r3 = r4
        L49:
            if (r3 == 0) goto L72
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L72
            int r0 = r3.size()
        L55:
            if (r2 >= r0) goto L67
            java.lang.Object r4 = r3.get(r2)
            int r2 = r2 + 1
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            a(r1, r4)
            goto L55
        L67:
            p2.l r0 = r11.f18161c
            androidx.work.impl.WorkDatabase r0 = r0.f17427c
            n.l r0 = r0.k()
            r0.r(r12)
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.c.b(java.lang.String):void");
    }

    @Override // p2.c
    public final void d(h... hVarArr) {
        int c9;
        l lVar = this.f18161c;
        WorkDatabase workDatabase = lVar.f17427c;
        f fVar = new f(workDatabase, 0);
        for (h hVar : hVarArr) {
            workDatabase.c();
            try {
                h h4 = workDatabase.n().h(hVar.f19749a);
                String str = e;
                if (h4 == null) {
                    m.g().k(str, "Skipping scheduling " + hVar.f19749a + " because it's no longer in the DB", new Throwable[0]);
                    workDatabase.h();
                } else if (h4.f19750b != WorkInfo$State.ENQUEUED) {
                    m.g().k(str, "Skipping scheduling " + hVar.f19749a + " because it is no longer enqueued", new Throwable[0]);
                    workDatabase.h();
                } else {
                    d j4 = workDatabase.k().j(hVar.f19749a);
                    if (j4 != null) {
                        c9 = j4.f19742b;
                    } else {
                        lVar.f17426b.getClass();
                        c9 = fVar.c(lVar.f17426b.f16696g);
                    }
                    if (j4 == null) {
                        lVar.f17427c.k().l(new d(hVar.f19749a, c9));
                    }
                    e(hVar, c9);
                    workDatabase.h();
                }
            } finally {
                workDatabase.f();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(h hVar, int i3) {
        int i10;
        JobScheduler jobScheduler = this.f18160b;
        b bVar = this.f18162d;
        bVar.getClass();
        o2.c cVar = hVar.f19757j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", hVar.f19749a);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", hVar.c());
        JobInfo.Builder extras = new JobInfo.Builder(i3, bVar.f18158a).setRequiresCharging(cVar.f16700b).setRequiresDeviceIdle(cVar.f16701c).setExtras(persistableBundle);
        NetworkType networkType = cVar.f16699a;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 30 || networkType != NetworkType.TEMPORARILY_UNMETERED) {
            int i12 = a.f18156a[networkType.ordinal()];
            if (i12 != 1) {
                i10 = 2;
                if (i12 != 2) {
                    if (i12 != 3) {
                        i10 = 4;
                        if (i12 == 4) {
                            i10 = 3;
                        } else if (i12 != 5) {
                            m.g().d(b.f18157b, "API version too low. Cannot convert network type value " + networkType, new Throwable[0]);
                        }
                    }
                }
                i10 = 1;
            } else {
                i10 = 0;
            }
            extras.setRequiredNetworkType(i10);
        } else {
            extras.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
        if (!cVar.f16701c) {
            extras.setBackoffCriteria(hVar.f19760m, hVar.f19759l == BackoffPolicy.LINEAR ? 0 : 1);
        }
        long max = Math.max(hVar.a() - System.currentTimeMillis(), 0L);
        if (i11 <= 28) {
            extras.setMinimumLatency(max);
        } else if (max > 0) {
            extras.setMinimumLatency(max);
        } else if (!hVar.f19764q) {
            extras.setImportantWhileForeground(true);
        }
        if (cVar.f16705h.f16708a.size() > 0) {
            Iterator it = cVar.f16705h.f16708a.iterator();
            while (it.hasNext()) {
                o2.d dVar = (o2.d) it.next();
                extras.addTriggerContentUri(new JobInfo.TriggerContentUri(dVar.f16706a, dVar.f16707b ? 1 : 0));
            }
            extras.setTriggerContentUpdateDelay(cVar.f16703f);
            extras.setTriggerContentMaxDelay(cVar.f16704g);
        }
        extras.setPersisted(false);
        extras.setRequiresBatteryNotLow(cVar.f16702d);
        extras.setRequiresStorageNotLow(cVar.e);
        Object[] objArr = hVar.f19758k > 0;
        boolean z5 = max > 0;
        if (ic.a() && hVar.f19764q && objArr == false && !z5) {
            extras.setExpedited(true);
        }
        JobInfo build = extras.build();
        m g10 = m.g();
        String str = hVar.f19749a;
        String str2 = e;
        g10.d(str2, "Scheduling work ID " + str + " Job ID " + i3, new Throwable[0]);
        try {
            if (jobScheduler.schedule(build) == 0) {
                m.g().k(str2, "Unable to schedule work ID " + hVar.f19749a, new Throwable[0]);
                if (hVar.f19764q && hVar.r == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    hVar.f19764q = false;
                    m.g().d(str2, "Scheduling a non-expedited job (work ID " + hVar.f19749a + ")", new Throwable[0]);
                    e(hVar, i3);
                }
            }
        } catch (IllegalStateException e10) {
            ArrayList c9 = c(this.f18159a, jobScheduler);
            int size = c9 != null ? c9.size() : 0;
            Locale locale = Locale.getDefault();
            Integer valueOf = Integer.valueOf(size);
            l lVar = this.f18161c;
            String format = String.format(locale, "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", valueOf, Integer.valueOf(lVar.f17427c.n().e().size()), Integer.valueOf(lVar.f17426b.f16697h));
            m.g().f(str2, format, new Throwable[0]);
            throw new IllegalStateException(format, e10);
        } catch (Throwable th2) {
            m.g().f(str2, "Unable to schedule " + hVar, th2);
        }
    }

    @Override // p2.c
    public final boolean f() {
        return true;
    }
}
