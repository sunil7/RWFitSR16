package com.example.test.ui.view;

import android.os.AsyncTask;
import androidx.core.app.JobIntentService;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class k extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8698a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8699b;

    public /* synthetic */ k(Object obj, int i3) {
        this.f8698a = i3;
        this.f8699b = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0065 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doInBackground(java.lang.Object[] r5) {
        /*
            r4 = this;
            int r0 = r4.f8698a
            switch(r0) {
                case 0: goto L68;
                default: goto L5;
            }
        L5:
            java.lang.Void[] r5 = (java.lang.Void[]) r5
        L7:
            java.lang.Object r5 = r4.f8699b
            androidx.core.app.JobIntentService r5 = (androidx.core.app.JobIntentService) r5
            y0.i r0 = r5.f1906a
            r0.getClass()
            y0.i r5 = r5.f1906a
            java.lang.Object r0 = r5.f19870b
            monitor-enter(r0)
            android.app.job.JobParameters r1 = r5.f19871c     // Catch: java.lang.Throwable -> L1d
            r2 = 0
            if (r1 != 0) goto L1f
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1d
        L1b:
            r0 = r2
            goto L38
        L1d:
            r5 = move-exception
            goto L66
        L1f:
            android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L1b
            android.content.Intent r0 = r1.getIntent()
            androidx.core.app.JobIntentService r3 = r5.f19869a
            java.lang.ClassLoader r3 = r3.getClassLoader()
            r0.setExtrasClassLoader(r3)
            o4.e r0 = new o4.e
            r0.<init>(r5, r1)
        L38:
            if (r0 == 0) goto L65
            java.lang.Object r5 = r4.f8699b
            androidx.core.app.JobIntentService r5 = (androidx.core.app.JobIntentService) r5
            java.lang.Object r1 = r0.f16737a
            android.app.job.JobWorkItem r1 = (android.app.job.JobWorkItem) r1
            r1.getIntent()
            r5.a()
            java.lang.Object r5 = r0.f16738b
            y0.i r5 = (y0.i) r5
            java.lang.Object r5 = r5.f19870b
            monitor-enter(r5)
            java.lang.Object r1 = r0.f16738b     // Catch: java.lang.Throwable -> L5f
            y0.i r1 = (y0.i) r1     // Catch: java.lang.Throwable -> L5f
            android.app.job.JobParameters r1 = r1.f19871c     // Catch: java.lang.Throwable -> L5f
            if (r1 == 0) goto L61
            java.lang.Object r0 = r0.f16737a     // Catch: java.lang.Throwable -> L5f
            android.app.job.JobWorkItem r0 = (android.app.job.JobWorkItem) r0     // Catch: java.lang.Throwable -> L5f
            r1.completeWork(r0)     // Catch: java.lang.Throwable -> L5f
            goto L61
        L5f:
            r0 = move-exception
            goto L63
        L61:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L5f
            goto L7
        L63:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L5f
            throw r0
        L65:
            return r2
        L66:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1d
            throw r5
        L68:
            java.lang.Void[] r5 = (java.lang.Void[]) r5
            java.lang.Object r5 = r4.f8699b
            com.example.test.ui.view.LongClickView r5 = (com.example.test.ui.view.LongClickView) r5
            java.util.Timer r5 = r5.f8474f
            if (r5 == 0) goto L75
            r5.cancel()
        L75:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.view.k.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    public void onCancelled(Object obj) {
        switch (this.f8698a) {
            case 1:
                ((JobIntentService) this.f8699b).getClass();
                break;
            default:
                super.onCancelled(obj);
                break;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        switch (this.f8698a) {
            case 0:
                LongClickView longClickView = (LongClickView) this.f8699b;
                long j4 = longClickView.f8479k - longClickView.f8478j;
                long j10 = (longClickView.f8480l * 1000) + 500;
                AtomicInteger atomicInteger = longClickView.f8475g;
                if (j4 <= j10) {
                    atomicInteger.set(0);
                    longClickView.invalidate();
                    Timer timer = longClickView.f8474f;
                    if (timer != null) {
                        timer.cancel();
                    }
                } else if (!longClickView.f8477i && longClickView.f8476h != null) {
                    Timer timer2 = longClickView.f8474f;
                    if (timer2 != null) {
                        timer2.cancel();
                    }
                    atomicInteger.set(0);
                    longClickView.invalidate();
                    longClickView.f8476h.a();
                }
                longClickView.f8477i = true;
                break;
            default:
                ((JobIntentService) this.f8699b).getClass();
                break;
        }
    }
}
