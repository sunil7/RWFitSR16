package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.support.v4.media.session.e;
import java.util.HashMap;
import o2.m;
import p2.a;
import p2.l;

/* loaded from: classes.dex */
public class SystemJobService extends JobService implements a {

    /* renamed from: c, reason: collision with root package name */
    public static final String f3019c = m.i("SystemJobService");

    /* renamed from: a, reason: collision with root package name */
    public l f3020a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f3021b = new HashMap();

    @Override // p2.a
    public final void a(String str, boolean z5) {
        JobParameters jobParameters;
        m.g().d(f3019c, e.l(str, " executed on JobScheduler"), new Throwable[0]);
        synchronized (this.f3021b) {
            jobParameters = (JobParameters) this.f3021b.remove(str);
        }
        if (jobParameters != null) {
            jobFinished(jobParameters, z5);
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        try {
            l a3 = l.a(getApplicationContext());
            this.f3020a = a3;
            a3.f17429f.b(this);
        } catch (IllegalStateException unused) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            }
            m.g().k(f3019c, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        l lVar = this.f3020a;
        if (lVar != null) {
            lVar.f17429f.e(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    @Override // android.app.job.JobService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onStartJob(android.app.job.JobParameters r9) {
        /*
            r8 = this;
            java.lang.String r0 = "onStartJob for "
            java.lang.String r1 = "Job is already being executed by SystemJobService: "
            p2.l r2 = r8.f3020a
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L1b
            o2.m r0 = o2.m.g()
            java.lang.String r1 = androidx.work.impl.background.systemjob.SystemJobService.f3019c
            java.lang.String r2 = "WorkManager is not initialized; requesting retry."
            java.lang.Throwable[] r5 = new java.lang.Throwable[r4]
            r0.d(r1, r2, r5)
            r8.jobFinished(r9, r3)
            return r4
        L1b:
            java.lang.String r2 = "EXTRA_WORK_SPEC_ID"
            android.os.PersistableBundle r5 = r9.getExtras()     // Catch: java.lang.NullPointerException -> L2e
            if (r5 == 0) goto L2e
            boolean r6 = r5.containsKey(r2)     // Catch: java.lang.NullPointerException -> L2e
            if (r6 == 0) goto L2e
            java.lang.String r2 = r5.getString(r2)     // Catch: java.lang.NullPointerException -> L2e
            goto L2f
        L2e:
            r2 = 0
        L2f:
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 == 0) goto L43
            o2.m r9 = o2.m.g()
            java.lang.String r0 = androidx.work.impl.background.systemjob.SystemJobService.f3019c
            java.lang.String r1 = "WorkSpec id not found!"
            java.lang.Throwable[] r2 = new java.lang.Throwable[r4]
            r9.f(r0, r1, r2)
            return r4
        L43:
            java.util.HashMap r5 = r8.f3021b
            monitor-enter(r5)
            java.util.HashMap r6 = r8.f3021b     // Catch: java.lang.Throwable -> L67
            boolean r6 = r6.containsKey(r2)     // Catch: java.lang.Throwable -> L67
            if (r6 == 0) goto L69
            o2.m r9 = o2.m.g()     // Catch: java.lang.Throwable -> L67
            java.lang.String r0 = androidx.work.impl.background.systemjob.SystemJobService.f3019c     // Catch: java.lang.Throwable -> L67
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L67
            r3.append(r2)     // Catch: java.lang.Throwable -> L67
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L67
            java.lang.Throwable[] r2 = new java.lang.Throwable[r4]     // Catch: java.lang.Throwable -> L67
            r9.d(r0, r1, r2)     // Catch: java.lang.Throwable -> L67
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L67
            return r4
        L67:
            r9 = move-exception
            goto Lb4
        L69:
            o2.m r1 = o2.m.g()     // Catch: java.lang.Throwable -> L67
            java.lang.String r6 = androidx.work.impl.background.systemjob.SystemJobService.f3019c     // Catch: java.lang.Throwable -> L67
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L67
            r7.append(r2)     // Catch: java.lang.Throwable -> L67
            java.lang.String r0 = r7.toString()     // Catch: java.lang.Throwable -> L67
            java.lang.Throwable[] r4 = new java.lang.Throwable[r4]     // Catch: java.lang.Throwable -> L67
            r1.d(r6, r0, r4)     // Catch: java.lang.Throwable -> L67
            java.util.HashMap r0 = r8.f3021b     // Catch: java.lang.Throwable -> L67
            r0.put(r2, r9)     // Catch: java.lang.Throwable -> L67
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L67
            int r0 = android.os.Build.VERSION.SDK_INT
            eb.e r1 = new eb.e
            r1.<init>()
            android.net.Uri[] r4 = r9.getTriggeredContentUris()
            if (r4 == 0) goto L9a
            android.net.Uri[] r4 = r9.getTriggeredContentUris()
            java.util.Arrays.asList(r4)
        L9a:
            java.lang.String[] r4 = r9.getTriggeredContentAuthorities()
            if (r4 == 0) goto La7
            java.lang.String[] r4 = r9.getTriggeredContentAuthorities()
            java.util.Arrays.asList(r4)
        La7:
            r4 = 28
            if (r0 < r4) goto Lae
            l1.r1.l(r9)
        Lae:
            p2.l r9 = r8.f3020a
            r9.d(r2, r1)
            return r3
        Lb4:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L67
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    @Override // android.app.job.JobService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onStopJob(android.app.job.JobParameters r7) {
        /*
            r6 = this;
            p2.l r0 = r6.f3020a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L14
            o2.m r7 = o2.m.g()
            java.lang.String r0 = androidx.work.impl.background.systemjob.SystemJobService.f3019c
            java.lang.String r3 = "WorkManager is not initialized; requesting retry."
            java.lang.Throwable[] r2 = new java.lang.Throwable[r2]
            r7.d(r0, r3, r2)
            return r1
        L14:
            java.lang.String r0 = "EXTRA_WORK_SPEC_ID"
            android.os.PersistableBundle r7 = r7.getExtras()     // Catch: java.lang.NullPointerException -> L27
            if (r7 == 0) goto L27
            boolean r3 = r7.containsKey(r0)     // Catch: java.lang.NullPointerException -> L27
            if (r3 == 0) goto L27
            java.lang.String r7 = r7.getString(r0)     // Catch: java.lang.NullPointerException -> L27
            goto L28
        L27:
            r7 = 0
        L28:
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L3c
            o2.m r7 = o2.m.g()
            java.lang.String r0 = androidx.work.impl.background.systemjob.SystemJobService.f3019c
            java.lang.String r1 = "WorkSpec id not found!"
            java.lang.Throwable[] r3 = new java.lang.Throwable[r2]
            r7.f(r0, r1, r3)
            return r2
        L3c:
            o2.m r0 = o2.m.g()
            java.lang.String r3 = androidx.work.impl.background.systemjob.SystemJobService.f3019c
            java.lang.String r4 = "onStopJob for "
            java.lang.String r4 = com.google.android.gms.internal.mlkit_vision_barcode.l0.n(r4, r7)
            java.lang.Throwable[] r5 = new java.lang.Throwable[r2]
            r0.d(r3, r4, r5)
            java.util.HashMap r0 = r6.f3021b
            monitor-enter(r0)
            java.util.HashMap r3 = r6.f3021b     // Catch: java.lang.Throwable -> L75
            r3.remove(r7)     // Catch: java.lang.Throwable -> L75
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L75
            p2.l r0 = r6.f3020a
            de.o r3 = r0.f17428d
            y2.j r4 = new y2.j
            r4.<init>(r0, r7, r2)
            r3.p(r4)
            p2.l r0 = r6.f3020a
            p2.b r0 = r0.f17429f
            java.lang.Object r2 = r0.f17400k
            monitor-enter(r2)
            java.util.HashSet r0 = r0.f17398i     // Catch: java.lang.Throwable -> L72
            boolean r7 = r0.contains(r7)     // Catch: java.lang.Throwable -> L72
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L72
            r7 = r7 ^ r1
            return r7
        L72:
            r7 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L72
            throw r7
        L75:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L75
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStopJob(android.app.job.JobParameters):boolean");
    }
}
