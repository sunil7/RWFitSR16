package com.example.test.ui.testui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.example.test.R$id;
import com.google.android.gms.internal.mlkit_vision_barcode.aa;
import com.google.android.gms.internal.mlkit_vision_barcode.c2;
import f6.z2;
import java.util.List;

/* loaded from: classes.dex */
public final class j implements a7.f, a7.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingActivityFragment f8284a;

    public /* synthetic */ j(TRingActivityFragment tRingActivityFragment) {
        this.f8284a = tRingActivityFragment;
    }

    @Override // a7.b
    public void a(String year) {
        kotlin.jvm.internal.e.f(year, "year");
    }

    @Override // a7.b
    public void b(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        TRingActivityFragment tRingActivityFragment = this.f8284a;
        z2 z2Var = (z2) tRingActivityFragment.f7251b;
        TextView textView = z2Var != null ? z2Var.r : null;
        if (textView != null) {
            textView.setText("--:--");
        }
        z2 z2Var2 = (z2) tRingActivityFragment.f7251b;
        TextView textView2 = z2Var2 != null ? z2Var2.f13496q : null;
        if (textView2 != null) {
            textView2.setText("--");
        }
        tRingActivityFragment.f8204c = date;
        List u10 = kotlin.text.m.u(date, new String[]{"/"});
        String str = (String) u10.get(0);
        String str2 = (String) u10.get(1);
        String str3 = (String) u10.get(2);
        z2 z2Var3 = (z2) tRingActivityFragment.f7251b;
        if (z2Var3 != null) {
            z2Var3.f13501w.b(Integer.parseInt(str), Integer.parseInt(str2), Integer.parseInt(str3));
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
        FragmentActivity activity;
        if (i3 != R$id.option1) {
            int i10 = R$id.option2;
            final TRingActivityFragment tRingActivityFragment = this.f8284a;
            if (i3 != i10) {
                if (i3 != R$id.barStatusIv || (activity = tRingActivityFragment.getActivity()) == null) {
                    return;
                }
                activity.finish();
                return;
            }
            tRingActivityFragment.getClass();
            z2 z2Var = (z2) tRingActivityFragment.f7251b;
            if (z2Var != null) {
                com.example.baselibrary.utils.b.x(z2Var.f13490k, new oh.l() { // from class: com.example.test.ui.testui.TRingActivityFragment$initView$2$onAction$1$1
                    {
                        super(1);
                    }

                    @Override // oh.l
                    public final String invoke(ScrollView scrollview) {
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
                        Context f02 = TRingActivityFragment.this.f0();
                        Object obj = com.example.test.utils.l.f8733a;
                        return c2.a().b(f02, bitmap, System.currentTimeMillis() + ".jpg");
                    }
                }, new oh.l() { // from class: com.example.test.ui.testui.TRingActivityFragment$initView$2$onAction$1$2
                    {
                        super(1);
                    }

                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return eh.g.f12633a;
                    }

                    public final void invoke(String str) {
                        TRingActivityFragment.this.getClass();
                        if (str != null) {
                            aa.a(TRingActivityFragment.this.f0(), str);
                        }
                    }
                });
            }
        }
    }
}
