package com.dh.keeplive.workmanager;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.dh.keeplive.entity.KeepLiveConfig;
import com.dh.keeplive.ext.a;
import com.google.android.gms.internal.mlkit_vision_barcode.af;
import eh.g;
import kotlin.jvm.internal.e;
import o2.f;
import o2.k;

/* loaded from: classes.dex */
public final class KeepLiveWorker extends Worker {

    /* renamed from: g, reason: collision with root package name */
    public final Context f7244g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7245h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeepLiveWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        e.f(context, "context");
        e.f(workerParams, "workerParams");
        this.f7244g = context;
        a.g(context, new oh.a() { // from class: com.dh.keeplive.workmanager.KeepLiveWorker.1
            {
                super(0);
            }

            @Override // oh.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m51invoke();
                return g.f12633a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m51invoke() {
                KeepLiveWorker.this.f7245h = true;
            }
        });
    }

    @Override // androidx.work.Worker
    public final k g() {
        Context context = this.f7244g;
        KeepLiveConfig a3 = af.a(context);
        a.d(this + "-doWork");
        if (!a.c(context) && !this.f7245h && !this.f2994c) {
            a.e(context, a3);
        }
        return new k(f.f16710c);
    }
}
