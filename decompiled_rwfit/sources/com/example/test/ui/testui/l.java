package com.example.test.ui.testui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import androidx.core.widget.NestedScrollView;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.test.R$id;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.service.u1;
import com.google.android.gms.internal.mlkit_vision_barcode.aa;
import com.google.android.gms.internal.mlkit_vision_barcode.c2;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.q1;

/* loaded from: classes.dex */
public final class l implements a7.f, a7.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingBloodPressureStatisticsActivity f8288a;

    public /* synthetic */ l(TRingBloodPressureStatisticsActivity tRingBloodPressureStatisticsActivity) {
        this.f8288a = tRingBloodPressureStatisticsActivity;
    }

    @Override // a7.b
    public void a(String year) {
        kotlin.jvm.internal.e.f(year, "year");
    }

    @Override // a7.b
    public void b(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        TRingBloodPressureStatisticsActivity tRingBloodPressureStatisticsActivity = this.f8288a;
        tRingBloodPressureStatisticsActivity.G = date;
        ((com.example.test.presenter.main.n) tRingBloodPressureStatisticsActivity.I0()).l(date);
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
        int i10 = R$id.option2;
        final TRingBloodPressureStatisticsActivity tRingBloodPressureStatisticsActivity = this.f8288a;
        if (i3 == i10) {
            if (!com.example.test.service.e.h().i()) {
                tRingBloodPressureStatisticsActivity.w0(R$string.str_device_disconnected);
                return;
            }
            XXApplication xXApplication = XXApplication.f7400h;
            j1.a().e = false;
            Object obj = u1.f7811u;
            q1.a().g();
            return;
        }
        if (i3 != R$id.option1) {
            if (i3 == R$id.barStatusIv) {
                Log.d("tong", "click menu");
                tRingBloodPressureStatisticsActivity.finish();
                return;
            }
            return;
        }
        Object obj2 = com.example.test.utils.m.f8734b;
        SupportMenuBean supportMenuBean = d2.a().f8735a;
        if (supportMenuBean != null ? supportMenuBean.isSupportBoReminder() : false) {
            tRingBloodPressureStatisticsActivity.getClass();
            tRingBloodPressureStatisticsActivity.startActivity(new Intent(tRingBloodPressureStatisticsActivity, (Class<?>) BoReminderActivity.class));
            return;
        }
        tRingBloodPressureStatisticsActivity.V();
        f6.i iVar = (f6.i) tRingBloodPressureStatisticsActivity.f7247z.getValue();
        if (iVar != null) {
            com.example.baselibrary.utils.b.x(iVar.f12962f, new oh.l() { // from class: com.example.test.ui.testui.TRingBloodPressureStatisticsActivity$initView$1$onAction$1$1
                {
                    super(1);
                }

                @Override // oh.l
                public final String invoke(NestedScrollView scrollview) {
                    Bitmap bitmap;
                    kotlin.jvm.internal.e.f(scrollview, "scrollview");
                    int childCount = scrollview.getChildCount();
                    int i11 = 0;
                    for (int i12 = 0; i12 < childCount; i12++) {
                        i11 += scrollview.getChildAt(i12).getHeight();
                    }
                    int f2 = com.example.baselibrary.utils.b.f(scrollview.getContext(), 20.0f) + i11;
                    if (f2 > 0) {
                        bitmap = Bitmap.createBitmap(scrollview.getWidth(), f2, Bitmap.Config.RGB_565);
                        kotlin.jvm.internal.e.e(bitmap, "createBitmap(...)");
                        scrollview.draw(new Canvas(bitmap));
                    } else {
                        bitmap = null;
                    }
                    if (bitmap == null) {
                        return null;
                    }
                    TRingBloodPressureStatisticsActivity tRingBloodPressureStatisticsActivity2 = TRingBloodPressureStatisticsActivity.this;
                    tRingBloodPressureStatisticsActivity2.getClass();
                    Object obj3 = com.example.test.utils.l.f8733a;
                    return c2.a().b(tRingBloodPressureStatisticsActivity2, bitmap, System.currentTimeMillis() + ".jpg");
                }
            }, new oh.l() { // from class: com.example.test.ui.testui.TRingBloodPressureStatisticsActivity$initView$1$onAction$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                    invoke((String) obj3);
                    return eh.g.f12633a;
                }

                public final void invoke(String str) {
                    TRingBloodPressureStatisticsActivity.this.b0();
                    if (str != null) {
                        TRingBloodPressureStatisticsActivity tRingBloodPressureStatisticsActivity2 = TRingBloodPressureStatisticsActivity.this;
                        tRingBloodPressureStatisticsActivity2.getClass();
                        aa.a(tRingBloodPressureStatisticsActivity2, str);
                    }
                }
            });
        }
    }
}
