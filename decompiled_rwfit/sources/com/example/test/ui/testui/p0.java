package com.example.test.ui.testui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.example.test.R$id;
import com.example.test.R$string;
import com.google.android.gms.internal.mlkit_vision_barcode.aa;
import com.google.android.gms.internal.mlkit_vision_barcode.c2;
import f6.o3;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class p0 implements a7.f, a7.b, com.example.test.ui.view.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingSleepFragment f8302a;

    @Override // a7.b
    public void a(String year) {
        kotlin.jvm.internal.e.f(year, "year");
    }

    @Override // a7.b
    public void b(String date) {
        kotlin.jvm.internal.e.f(date, "date");
        TRingSleepFragment tRingSleepFragment = this.f8302a;
        Log.d(tRingSleepFragment.f8235c, "--- >getDaySleepData data = ".concat(date));
        tRingSleepFragment.f8236d = date;
        List u10 = kotlin.text.m.u(date, new String[]{"/"});
        String str = (String) u10.get(0);
        String str2 = (String) u10.get(1);
        String str3 = (String) u10.get(2);
        o3 o3Var = (o3) tRingSleepFragment.f7251b;
        if (o3Var != null) {
            o3Var.U.b(Integer.parseInt(str), Integer.parseInt(str2), Integer.parseInt(str3));
        }
    }

    @Override // a7.b
    public void c(String month) {
        kotlin.jvm.internal.e.f(month, "month");
    }

    @Override // a7.b
    public void d(String str, String str2) {
    }

    public void e(x6.a aVar) {
        String str;
        String str2;
        TRingSleepFragment tRingSleepFragment = this.f8302a;
        o3 o3Var = (o3) tRingSleepFragment.f7251b;
        if (o3Var != null && o3Var.f13198q.getVisibility() == 4) {
            o3 o3Var2 = (o3) tRingSleepFragment.f7251b;
            TextView textView = o3Var2 != null ? o3Var2.f13198q : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
            o3 o3Var3 = (o3) tRingSleepFragment.f7251b;
            TextView textView2 = o3Var3 != null ? o3Var3.A : null;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            o3 o3Var4 = (o3) tRingSleepFragment.f7251b;
            TextView textView3 = o3Var4 != null ? o3Var4.I : null;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
        }
        int i3 = aVar.f19813a;
        if (i3 == 1) {
            o3 o3Var5 = (o3) tRingSleepFragment.f7251b;
            TextView textView4 = o3Var5 != null ? o3Var5.f13198q : null;
            if (textView4 != null) {
                textView4.setText(tRingSleepFragment.getString(R$string.str_light_sleep));
            }
        } else if (i3 == 2) {
            o3 o3Var6 = (o3) tRingSleepFragment.f7251b;
            TextView textView5 = o3Var6 != null ? o3Var6.f13198q : null;
            if (textView5 != null) {
                textView5.setText(tRingSleepFragment.getString(R$string.str_deep_sleep));
            }
        } else if (i3 == 3) {
            o3 o3Var7 = (o3) tRingSleepFragment.f7251b;
            TextView textView6 = o3Var7 != null ? o3Var7.f13198q : null;
            if (textView6 != null) {
                textView6.setText(tRingSleepFragment.getString(R$string.str_rapid_eye));
            }
        } else {
            o3 o3Var8 = (o3) tRingSleepFragment.f7251b;
            TextView textView7 = o3Var8 != null ? o3Var8.f13198q : null;
            if (textView7 != null) {
                textView7.setText(tRingSleepFragment.getString(R$string.str_wake_up));
            }
        }
        o3 o3Var9 = (o3) tRingSleepFragment.f7251b;
        TextView textView8 = o3Var9 != null ? o3Var9.f13199s : null;
        if (textView8 != null) {
            String num = Integer.valueOf(aVar.f19815c).toString();
            if (num == null) {
                num = "";
            }
            textView8.setText(num);
        }
        long j4 = aVar.f19816d;
        try {
            str = new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(Long.valueOf(j4));
        } catch (Exception e) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(j4, " getTimeStr translate error ", e.getMessage()));
            str = null;
        }
        long j10 = aVar.f19816d + (aVar.f19815c * 60000);
        try {
            str2 = new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(Long.valueOf(j10));
        } catch (Exception e10) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(j10, " getTimeStr translate error ", e10.getMessage()));
            str2 = null;
        }
        o3 o3Var10 = (o3) tRingSleepFragment.f7251b;
        TextView textView9 = o3Var10 != null ? o3Var10.I : null;
        if (textView9 == null) {
            return;
        }
        textView9.setText(str + "-" + str2);
    }

    public void f() {
        TRingSleepFragment tRingSleepFragment = this.f8302a;
        o3 o3Var = (o3) tRingSleepFragment.f7251b;
        TextView textView = o3Var != null ? o3Var.f13198q : null;
        if (textView != null) {
            textView.setVisibility(4);
        }
        o3 o3Var2 = (o3) tRingSleepFragment.f7251b;
        TextView textView2 = o3Var2 != null ? o3Var2.A : null;
        if (textView2 != null) {
            textView2.setVisibility(4);
        }
        o3 o3Var3 = (o3) tRingSleepFragment.f7251b;
        TextView textView3 = o3Var3 != null ? o3Var3.f13199s : null;
        if (textView3 != null) {
            textView3.setText("--");
        }
        o3 o3Var4 = (o3) tRingSleepFragment.f7251b;
        TextView textView4 = o3Var4 != null ? o3Var4.I : null;
        if (textView4 == null) {
            return;
        }
        textView4.setVisibility(4);
    }

    @Override // a7.f
    public void j(int i3) {
        FragmentActivity activity;
        int i10 = R$id.option2;
        final TRingSleepFragment tRingSleepFragment = this.f8302a;
        if (i3 == i10) {
            tRingSleepFragment.getClass();
            o3 o3Var = (o3) tRingSleepFragment.f7251b;
            if (o3Var != null) {
                com.example.baselibrary.utils.b.x(o3Var.f13186d, new oh.l() { // from class: com.example.test.ui.testui.TRingSleepFragment$initView$2$onAction$1$1
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
                        Context f02 = TRingSleepFragment.this.f0();
                        Object obj = com.example.test.utils.l.f8733a;
                        return c2.a().b(f02, bitmap, System.currentTimeMillis() + ".jpg");
                    }
                }, new oh.l() { // from class: com.example.test.ui.testui.TRingSleepFragment$initView$2$onAction$1$2
                    {
                        super(1);
                    }

                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return eh.g.f12633a;
                    }

                    public final void invoke(String str) {
                        TRingSleepFragment.this.getClass();
                        if (str != null) {
                            aa.a(TRingSleepFragment.this.f0(), str);
                        }
                    }
                });
                return;
            }
            return;
        }
        if (i3 == R$id.option1) {
            tRingSleepFragment.startActivity(new Intent(tRingSleepFragment.f0(), (Class<?>) TRingSleepTargetActivity.class));
        } else {
            if (i3 != R$id.barStatusIv || (activity = tRingSleepFragment.getActivity()) == null) {
                return;
            }
            activity.finish();
        }
    }
}
