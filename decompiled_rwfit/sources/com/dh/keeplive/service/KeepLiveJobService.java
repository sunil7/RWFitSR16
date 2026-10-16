package com.dh.keeplive.service;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Process;
import com.dh.keeplive.entity.KeepLiveConfig;
import com.dh.keeplive.entity.KeepLiveConstant;
import com.dh.keeplive.receiver.StopReceiver;
import com.google.android.gms.internal.mlkit_vision_barcode.af;
import com.google.android.gms.internal.mlkit_vision_barcode.cf;
import eh.g;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class KeepLiveJobService extends JobService {

    /* renamed from: a, reason: collision with root package name */
    public JobScheduler f7220a;

    /* renamed from: b, reason: collision with root package name */
    public KeepLiveConfig f7221b;

    /* renamed from: c, reason: collision with root package name */
    public int f7222c = 100;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7223d;

    /* JADX WARN: Type inference failed for: r0v10, types: [com.dh.keeplive.service.KeepLiveJobService$onCreate$1, kotlin.jvm.internal.Lambda] */
    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f7221b = af.a(this);
        Object systemService = getSystemService("jobscheduler");
        e.d(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
        this.f7220a = (JobScheduler) systemService;
        int i3 = getSharedPreferences(KeepLiveConstant.KEEP_LIVE_TAG, 0).getInt(KeepLiveConstant.KEEP_LIVE_JOB_ID, -1);
        this.f7222c = i3;
        if (i3 != -1) {
            JobScheduler jobScheduler = this.f7220a;
            if (jobScheduler == null) {
                e.m("mJobScheduler");
                throw null;
            }
            jobScheduler.cancel(i3);
        }
        int myPid = Process.myUid() <= 0 ? Process.myPid() : Process.myUid();
        this.f7222c = myPid;
        getSharedPreferences(KeepLiveConstant.KEEP_LIVE_TAG, 0).edit().putInt(KeepLiveConstant.KEEP_LIVE_JOB_ID, myPid).apply();
        JobInfo.Builder builder = new JobInfo.Builder(this.f7222c, new ComponentName(getPackageName(), KeepLiveJobService.class.getName()));
        try {
            builder.setMinimumLatency(30000L);
            builder.setOverrideDeadline(30000L);
            builder.setBackoffCriteria(30000L, 0);
            builder.setRequiredNetworkType(1);
            builder.setRequiresCharging(true);
            builder.setPersisted(true);
        } catch (Exception unused) {
        }
        JobScheduler jobScheduler2 = this.f7220a;
        if (jobScheduler2 == null) {
            e.m("mJobScheduler");
            throw null;
        }
        jobScheduler2.schedule(builder.build());
        new StopReceiver(this).f7217b = new oh.a() { // from class: com.dh.keeplive.service.KeepLiveJobService$onCreate$1
            {
                super(0);
            }

            @Override // oh.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m46invoke();
                return g.f12633a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m46invoke() {
                KeepLiveJobService keepLiveJobService = KeepLiveJobService.this;
                keepLiveJobService.f7223d = true;
                com.dh.keeplive.ext.a.j(keepLiveJobService);
            }
        };
    }

    @Override // android.app.Service
    public final void onDestroy() {
        stopForeground(true);
        JobScheduler jobScheduler = this.f7220a;
        if (jobScheduler == null) {
            e.m("mJobScheduler");
            throw null;
        }
        jobScheduler.cancel(this.f7222c);
        getSharedPreferences(KeepLiveConstant.KEEP_LIVE_TAG, 0).edit().putInt(KeepLiveConstant.KEEP_LIVE_JOB_ID, -1).apply();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i10) {
        KeepLiveConfig keepLiveConfig;
        if (intent != null && (keepLiveConfig = (KeepLiveConfig) intent.getParcelableExtra(KeepLiveConstant.KEEP_LIVE_CONFIG)) != null) {
            this.f7221b = keepLiveConfig;
        }
        KeepLiveConfig keepLiveConfig2 = this.f7221b;
        if (keepLiveConfig2 == null) {
            e.m("mKeepLiveConfig");
            throw null;
        }
        cf.b(this, keepLiveConfig2.getNotificationConfig());
        KeepLiveConfig keepLiveConfig3 = this.f7221b;
        if (keepLiveConfig3 != null) {
            com.dh.keeplive.ext.a.f(this, keepLiveConfig3);
            return 1;
        }
        e.m("mKeepLiveConfig");
        throw null;
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        e.f(jobParameters, "jobParameters");
        com.dh.keeplive.ext.a.d("onStartJob");
        if (com.dh.keeplive.ext.a.c(this) || this.f7223d) {
            return false;
        }
        KeepLiveConfig keepLiveConfig = this.f7221b;
        if (keepLiveConfig != null) {
            com.dh.keeplive.ext.a.f(this, keepLiveConfig);
            return false;
        }
        e.m("mKeepLiveConfig");
        throw null;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        e.f(jobParameters, "jobParameters");
        com.dh.keeplive.ext.a.d("onStopJob");
        if (com.dh.keeplive.ext.a.c(this) || this.f7223d) {
            return false;
        }
        KeepLiveConfig keepLiveConfig = this.f7221b;
        if (keepLiveConfig != null) {
            com.dh.keeplive.ext.a.f(this, keepLiveConfig);
            return false;
        }
        e.m("mKeepLiveConfig");
        throw null;
    }
}
