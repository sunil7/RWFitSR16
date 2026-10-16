package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import a8.b;
import a8.i;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import de.o;
import f8.e;
import f8.g;
import j8.a;
import x.h;

/* loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f8840a = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i3 = jobParameters.getExtras().getInt("priority");
        int i10 = jobParameters.getExtras().getInt("attemptNumber");
        i.b(getApplicationContext());
        o a3 = b.a();
        if (string == null) {
            throw new NullPointerException("Null backendName");
        }
        a3.f12377b = string;
        a3.f12378c = a.b(i3);
        if (string2 != null) {
            a3.f12379d = Base64.decode(string2, 0);
        }
        g gVar = i.a().f140d;
        b i11 = a3.i();
        h hVar = new h(14, this, jobParameters);
        gVar.getClass();
        gVar.e.execute(new e(gVar, i11, i10, hVar));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
