package y0;

import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.os.AsyncTask;
import androidx.core.app.JobIntentService;

/* loaded from: classes.dex */
public final class i extends JobServiceEngine {

    /* renamed from: a, reason: collision with root package name */
    public final JobIntentService f19869a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f19870b;

    /* renamed from: c, reason: collision with root package name */
    public JobParameters f19871c;

    public i(JobIntentService jobIntentService) {
        super(jobIntentService);
        this.f19870b = new Object();
        this.f19869a = jobIntentService;
    }

    @Override // android.app.job.JobServiceEngine
    public final boolean onStartJob(JobParameters jobParameters) {
        this.f19871c = jobParameters;
        JobIntentService jobIntentService = this.f19869a;
        if (jobIntentService.f1907b != null) {
            return true;
        }
        com.example.test.ui.view.k kVar = new com.example.test.ui.view.k(jobIntentService, 1);
        jobIntentService.f1907b = kVar;
        kVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return true;
    }

    @Override // android.app.job.JobServiceEngine
    public final boolean onStopJob(JobParameters jobParameters) {
        com.example.test.ui.view.k kVar = this.f19869a.f1907b;
        if (kVar != null) {
            kVar.cancel(false);
        }
        synchronized (this.f19870b) {
            this.f19871c = null;
        }
        return true;
    }
}
