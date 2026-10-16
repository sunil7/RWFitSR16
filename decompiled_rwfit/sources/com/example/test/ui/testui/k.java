package com.example.test.ui.testui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import androidx.core.widget.NestedScrollView;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.test.R$id;
import com.google.android.gms.internal.mlkit_vision_barcode.aa;
import com.google.android.gms.internal.mlkit_vision_barcode.c2;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;

/* loaded from: classes.dex */
public final class k implements a7.f, a7.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingBloodOxygenStatisticsActivity f8286a;

    @Override // a7.b
    public void a(String year) {
        kotlin.jvm.internal.e.f(year, "year");
    }

    @Override // a7.b
    public void b(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        TRingBloodOxygenStatisticsActivity tRingBloodOxygenStatisticsActivity = this.f8286a;
        tRingBloodOxygenStatisticsActivity.G = date;
        ((com.example.test.presenter.main.k) tRingBloodOxygenStatisticsActivity.I0()).l(date);
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
        if (i3 != R$id.option2) {
            int i10 = R$id.option1;
            final TRingBloodOxygenStatisticsActivity tRingBloodOxygenStatisticsActivity = this.f8286a;
            if (i3 != i10) {
                if (i3 == R$id.barStatusIv) {
                    Log.d("tong", "click menu");
                    tRingBloodOxygenStatisticsActivity.finish();
                    return;
                }
                return;
            }
            Object obj = com.example.test.utils.m.f8734b;
            SupportMenuBean supportMenuBean = d2.a().f8735a;
            if (supportMenuBean != null ? supportMenuBean.isSupportBoReminder() : false) {
                tRingBloodOxygenStatisticsActivity.getClass();
                tRingBloodOxygenStatisticsActivity.startActivity(new Intent(tRingBloodOxygenStatisticsActivity, (Class<?>) BoReminderActivity.class));
                return;
            }
            tRingBloodOxygenStatisticsActivity.V();
            f6.h hVar = (f6.h) tRingBloodOxygenStatisticsActivity.f7247z.getValue();
            if (hVar != null) {
                com.example.baselibrary.utils.b.x(hVar.f12932f, new oh.l() { // from class: com.example.test.ui.testui.TRingBloodOxygenStatisticsActivity$initView$1$onAction$1$1
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
                        TRingBloodOxygenStatisticsActivity tRingBloodOxygenStatisticsActivity2 = TRingBloodOxygenStatisticsActivity.this;
                        tRingBloodOxygenStatisticsActivity2.getClass();
                        Object obj2 = com.example.test.utils.l.f8733a;
                        return c2.a().b(tRingBloodOxygenStatisticsActivity2, bitmap, System.currentTimeMillis() + ".jpg");
                    }
                }, new oh.l() { // from class: com.example.test.ui.testui.TRingBloodOxygenStatisticsActivity$initView$1$onAction$1$2
                    {
                        super(1);
                    }

                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((String) obj2);
                        return eh.g.f12633a;
                    }

                    public final void invoke(String str) {
                        TRingBloodOxygenStatisticsActivity.this.b0();
                        if (str != null) {
                            TRingBloodOxygenStatisticsActivity tRingBloodOxygenStatisticsActivity2 = TRingBloodOxygenStatisticsActivity.this;
                            tRingBloodOxygenStatisticsActivity2.getClass();
                            aa.a(tRingBloodOxygenStatisticsActivity2, str);
                        }
                    }
                });
            }
        }
    }
}
