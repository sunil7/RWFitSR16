package com.example.test.ui.testui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import androidx.core.widget.NestedScrollView;
import com.example.test.R$id;
import com.google.android.gms.internal.mlkit_vision_barcode.aa;
import com.google.android.gms.internal.mlkit_vision_barcode.c2;

/* loaded from: classes.dex */
public final class m implements a7.f, a7.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingBloodSugarStatisticsActivity f8290a;

    public /* synthetic */ m(TRingBloodSugarStatisticsActivity tRingBloodSugarStatisticsActivity) {
        this.f8290a = tRingBloodSugarStatisticsActivity;
    }

    @Override // a7.b
    public void a(String year) {
        kotlin.jvm.internal.e.f(year, "year");
    }

    @Override // a7.b
    public void b(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        TRingBloodSugarStatisticsActivity tRingBloodSugarStatisticsActivity = this.f8290a;
        tRingBloodSugarStatisticsActivity.H = date;
        ((com.example.test.presenter.main.r) tRingBloodSugarStatisticsActivity.I0()).l(date);
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
        final TRingBloodSugarStatisticsActivity tRingBloodSugarStatisticsActivity = this.f8290a;
        if (i3 != i10) {
            if (i3 == R$id.option2 || i3 != R$id.barStatusIv) {
                return;
            }
            tRingBloodSugarStatisticsActivity.finish();
            return;
        }
        tRingBloodSugarStatisticsActivity.V();
        f6.j jVar = (f6.j) tRingBloodSugarStatisticsActivity.f7247z.getValue();
        if (jVar != null) {
            com.example.baselibrary.utils.b.x(jVar.f13002f, new oh.l() { // from class: com.example.test.ui.testui.TRingBloodSugarStatisticsActivity$initView$1$onAction$1$1
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
                    TRingBloodSugarStatisticsActivity tRingBloodSugarStatisticsActivity2 = TRingBloodSugarStatisticsActivity.this;
                    tRingBloodSugarStatisticsActivity2.getClass();
                    Object obj = com.example.test.utils.l.f8733a;
                    return c2.a().b(tRingBloodSugarStatisticsActivity2, bitmap, System.currentTimeMillis() + ".jpg");
                }
            }, new oh.l() { // from class: com.example.test.ui.testui.TRingBloodSugarStatisticsActivity$initView$1$onAction$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return eh.g.f12633a;
                }

                public final void invoke(String str) {
                    TRingBloodSugarStatisticsActivity.this.b0();
                    if (str != null) {
                        TRingBloodSugarStatisticsActivity tRingBloodSugarStatisticsActivity2 = TRingBloodSugarStatisticsActivity.this;
                        tRingBloodSugarStatisticsActivity2.getClass();
                        aa.a(tRingBloodSugarStatisticsActivity2, str);
                    }
                }
            });
        }
    }
}
