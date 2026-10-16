package com.example.test.ui.testui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import androidx.core.widget.NestedScrollView;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.test.R$id;
import com.google.android.gms.internal.mlkit_vision_barcode.aa;
import com.google.android.gms.internal.mlkit_vision_barcode.c2;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;

/* loaded from: classes.dex */
public final class a0 implements a7.f, a7.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingHeartRateStatisticsActivity f8256a;

    @Override // a7.b
    public void a(String year) {
        kotlin.jvm.internal.e.f(year, "year");
    }

    @Override // a7.b
    public void b(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        TRingHeartRateStatisticsActivity tRingHeartRateStatisticsActivity = this.f8256a;
        tRingHeartRateStatisticsActivity.I = date;
        if (tRingHeartRateStatisticsActivity.H == 0) {
            ((com.example.test.presenter.main.u0) tRingHeartRateStatisticsActivity.I0()).l(date);
        } else {
            ((com.example.test.presenter.main.u0) tRingHeartRateStatisticsActivity.I0()).m(date);
        }
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
        int i10 = R$id.option1;
        final TRingHeartRateStatisticsActivity tRingHeartRateStatisticsActivity = this.f8256a;
        if (i3 != i10) {
            if (i3 == R$id.option2 || i3 != R$id.barStatusIv) {
                return;
            }
            tRingHeartRateStatisticsActivity.finish();
            return;
        }
        Object obj = com.example.test.utils.m.f8734b;
        SupportMenuBean supportMenuBean = d2.a().f8735a;
        if ((supportMenuBean != null ? supportMenuBean.isSupportHrReminder() : false) && tRingHeartRateStatisticsActivity.H != 1) {
            tRingHeartRateStatisticsActivity.startActivity(new Intent(tRingHeartRateStatisticsActivity, (Class<?>) HrReminderActivity.class));
            return;
        }
        tRingHeartRateStatisticsActivity.V();
        f6.k0 k0Var = (f6.k0) tRingHeartRateStatisticsActivity.f7247z.getValue();
        if (k0Var != null) {
            com.example.baselibrary.utils.b.x(k0Var.f13031f, new oh.l() { // from class: com.example.test.ui.testui.TRingHeartRateStatisticsActivity$initView$1$onAction$1$1
                {
                    super(1);
                }

                @Override // oh.l
                public final String invoke(NestedScrollView nestedScrollView) {
                    Bitmap bitmap;
                    kotlin.jvm.internal.e.f(nestedScrollView, "nestedScrollView");
                    int childCount = nestedScrollView.getChildCount();
                    int i11 = 0;
                    for (int i12 = 0; i12 < childCount; i12++) {
                        i11 += nestedScrollView.getChildAt(i12).getHeight();
                    }
                    int f2 = com.example.baselibrary.utils.b.f(nestedScrollView.getContext(), 20.0f) + i11;
                    if (f2 > 0) {
                        bitmap = Bitmap.createBitmap(nestedScrollView.getWidth(), f2, Bitmap.Config.RGB_565);
                        kotlin.jvm.internal.e.e(bitmap, "createBitmap(...)");
                        nestedScrollView.draw(new Canvas(bitmap));
                    } else {
                        bitmap = null;
                    }
                    if (bitmap == null) {
                        return null;
                    }
                    TRingHeartRateStatisticsActivity tRingHeartRateStatisticsActivity2 = TRingHeartRateStatisticsActivity.this;
                    tRingHeartRateStatisticsActivity2.getClass();
                    Object obj2 = com.example.test.utils.l.f8733a;
                    return c2.a().b(tRingHeartRateStatisticsActivity2, bitmap, System.currentTimeMillis() + ".jpg");
                }
            }, new oh.l() { // from class: com.example.test.ui.testui.TRingHeartRateStatisticsActivity$initView$1$onAction$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((String) obj2);
                    return eh.g.f12633a;
                }

                public final void invoke(String str) {
                    TRingHeartRateStatisticsActivity.this.b0();
                    if (str != null) {
                        TRingHeartRateStatisticsActivity tRingHeartRateStatisticsActivity2 = TRingHeartRateStatisticsActivity.this;
                        tRingHeartRateStatisticsActivity2.getClass();
                        aa.a(tRingHeartRateStatisticsActivity2, str);
                    }
                }
            });
        }
    }
}
