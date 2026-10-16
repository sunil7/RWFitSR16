package com.example.blesdk.service;

import android.app.Instrumentation;
import com.example.test.ui.testui.TRingMuslinStatisticsActivity;
import com.example.test.ui.testui.TRingPCycleStatisticsActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7362a;

    public /* synthetic */ z(int i3) {
        this.f7362a = i3;
    }

    private final void a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7362a) {
            case 0:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "TelinkOtaService", "OTA超时");
                b0.b();
                com.example.test.presenter.device.e eVar = b0.f7299h;
                if (eVar != null) {
                    eVar.a(3);
                    return;
                }
                return;
            case 1:
                new Instrumentation().sendKeyDownUpSync(27);
                return;
            case 2:
                new Instrumentation().sendKeyDownUpSync(27);
                return;
            case 3:
                int i3 = TRingMuslinStatisticsActivity.F;
                return;
            case 4:
                int i10 = TRingPCycleStatisticsActivity.I;
                return;
            case 5:
                throw null;
            default:
                return;
        }
    }
}
