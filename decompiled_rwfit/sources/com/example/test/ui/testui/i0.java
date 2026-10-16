package com.example.test.ui.testui;

import android.content.Intent;
import android.util.Log;
import com.example.test.R$id;

/* loaded from: classes.dex */
public final class i0 implements a7.b, a7.f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingMuslinStatisticsActivity f8283a;

    @Override // a7.b
    public void a(String year) {
        kotlin.jvm.internal.e.f(year, "year");
    }

    @Override // a7.b
    public void b(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        Log.e("qob", "onSelectDate ".concat(date));
        int i3 = TRingMuslinStatisticsActivity.F;
        ((com.example.test.presenter.main.b1) this.f8283a.I0()).k(date);
    }

    @Override // a7.b
    public void c(String month) {
        kotlin.jvm.internal.e.f(month, "month");
    }

    @Override // a7.b
    public void d(String str, String str2) {
    }

    @Override // a7.f
    public void j(int i3) {
        int i10 = R$id.barStatusIv;
        TRingMuslinStatisticsActivity tRingMuslinStatisticsActivity = this.f8283a;
        if (i3 == i10) {
            tRingMuslinStatisticsActivity.finish();
            return;
        }
        if (i3 == R$id.option1) {
            tRingMuslinStatisticsActivity.getClass();
            tRingMuslinStatisticsActivity.startActivity(new Intent(tRingMuslinStatisticsActivity, (Class<?>) TRingMuslinTargetActivity.class));
        } else if (i3 == R$id.option2) {
            tRingMuslinStatisticsActivity.getClass();
            tRingMuslinStatisticsActivity.startActivity(new Intent(tRingMuslinStatisticsActivity, (Class<?>) TRingMuslinTargetActivity.class));
        }
    }
}
