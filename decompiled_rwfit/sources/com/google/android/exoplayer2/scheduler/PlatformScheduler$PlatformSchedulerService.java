package com.google.android.exoplayer2.scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.PersistableBundle;
import android.util.Log;
import i9.g;

/* loaded from: classes.dex */
public final class PlatformScheduler$PlatformSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        PersistableBundle extras = jobParameters.getExtras();
        int a3 = new Requirements(extras.getInt("requirements")).a(this);
        if (a3 != 0) {
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("Requirements not met: ");
            sb2.append(a3);
            Log.w("PlatformScheduler", sb2.toString());
            jobFinished(jobParameters, true);
            return false;
        }
        String string = extras.getString("service_action");
        string.getClass();
        String string2 = extras.getString("service_package");
        string2.getClass();
        Intent intent = new Intent(string).setPackage(string2);
        if (g.f14378a >= 26) {
            startForegroundService(intent);
            return false;
        }
        startService(intent);
        return false;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
