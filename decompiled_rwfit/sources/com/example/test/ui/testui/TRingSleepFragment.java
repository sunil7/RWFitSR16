package com.example.test.ui.testui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.example.baselibrary.base.fragment.BaseFragment;
import com.example.test.R$color;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.model.chart.chart.SleepChartData;
import com.example.test.ui.view.NoThumbCircleProgressView;
import com.example.test.ui.view.TRingSleepChartView;
import com.example.test.ui.view.WaveView;
import com.github.mikephil.charting.data.Entry;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.material.timepicker.TimeModel;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;
import f6.o3;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class TRingSleepFragment extends BaseFragment<com.example.test.presenter.main.c1, o3> implements g7.v, t7.d, md.k {

    /* renamed from: c, reason: collision with root package name */
    public final String f8235c = "TRingSleepFragment";

    /* renamed from: d, reason: collision with root package name */
    public String f8236d = "";
    public boolean e;

    public TRingSleepFragment() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingSleepFragment$statisticsType$2
            @Override // oh.a
            public final Integer invoke() {
                return 0;
            }
        });
    }

    @Override // t7.d
    public final void A() {
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new com.example.test.presenter.main.c1(this);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        o3 o3Var = (o3) this.f7251b;
        if (o3Var != null) {
            return o3Var.f13183a;
        }
        return null;
    }

    @Override // g7.v
    public final void Y(SleepChartData sleepChartData) {
        TextView textView;
        Log.e(this.f8235c, "onSleepDayData");
        Log.e("qob", "TRingSleepFragment updateUI " + sleepChartData.getItems());
        if (sleepChartData.getRing_rapidSleepTime() > 0) {
            this.e = true;
        } else {
            this.e = false;
        }
        if (sleepChartData.getItems() == null || sleepChartData.getItems().size() < 1) {
            o3 o3Var = (o3) this.f7251b;
            TextView textView2 = o3Var != null ? o3Var.F : null;
            if (textView2 != null) {
                textView2.setText("--");
            }
            o3 o3Var2 = (o3) this.f7251b;
            if (o3Var2 != null) {
                o3Var2.f13196o.setProgress(0.0f);
            }
            o3 o3Var3 = (o3) this.f7251b;
            TextView textView3 = o3Var3 != null ? o3Var3.E : null;
            if (textView3 != null) {
                textView3.setVisibility(4);
            }
            o3 o3Var4 = (o3) this.f7251b;
            TextView textView4 = o3Var4 != null ? o3Var4.f13203w : null;
            if (textView4 != null) {
                textView4.setText("--");
            }
            o3 o3Var5 = (o3) this.f7251b;
            TextView textView5 = o3Var5 != null ? o3Var5.f13206z : null;
            if (textView5 != null) {
                textView5.setText("--");
            }
            o3 o3Var6 = (o3) this.f7251b;
            TRingSleepChartView tRingSleepChartView = o3Var6 != null ? o3Var6.f13185c : null;
            if (tRingSleepChartView != null) {
                tRingSleepChartView.setVisibility(4);
            }
            o3 o3Var7 = (o3) this.f7251b;
            TextView textView6 = o3Var7 != null ? o3Var7.J : null;
            if (textView6 != null) {
                textView6.setText("--");
            }
            o3 o3Var8 = (o3) this.f7251b;
            TextView textView7 = o3Var8 != null ? o3Var8.L : null;
            if (textView7 != null) {
                textView7.setText("--");
            }
            o3 o3Var9 = (o3) this.f7251b;
            TextView textView8 = o3Var9 != null ? o3Var9.S : null;
            if (textView8 != null) {
                textView8.setText("--");
            }
            o3 o3Var10 = (o3) this.f7251b;
            TextView textView9 = o3Var10 != null ? o3Var10.N : null;
            if (textView9 != null) {
                textView9.setText("--");
            }
            o3 o3Var11 = (o3) this.f7251b;
            TextView textView10 = o3Var11 != null ? o3Var11.Q : null;
            if (textView10 != null) {
                textView10.setText("--");
            }
            o3 o3Var12 = (o3) this.f7251b;
            TextView textView11 = o3Var12 != null ? o3Var12.P : null;
            if (textView11 != null) {
                textView11.setText("--");
            }
            o3 o3Var13 = (o3) this.f7251b;
            TextView textView12 = o3Var13 != null ? o3Var13.C : null;
            if (textView12 != null) {
                textView12.setText("--");
            }
            o3 o3Var14 = (o3) this.f7251b;
            TextView textView13 = o3Var14 != null ? o3Var14.r : null;
            if (textView13 != null) {
                textView13.setText("--");
            }
            o3 o3Var15 = (o3) this.f7251b;
            TextView textView14 = o3Var15 != null ? o3Var15.f13205y : null;
            if (textView14 != null) {
                textView14.setText("--");
            }
            o3 o3Var16 = (o3) this.f7251b;
            TextView textView15 = o3Var16 != null ? o3Var16.f13202v : null;
            if (textView15 != null) {
                textView15.setText("--");
            }
            o3 o3Var17 = (o3) this.f7251b;
            TextView textView16 = o3Var17 != null ? o3Var17.G : null;
            if (textView16 != null) {
                textView16.setText("--");
            }
            o3 o3Var18 = (o3) this.f7251b;
            TextView textView17 = o3Var18 != null ? o3Var18.H : null;
            if (textView17 != null) {
                textView17.setText("--");
            }
            o3 o3Var19 = (o3) this.f7251b;
            if (o3Var19 != null) {
                o3Var19.f13189h.setProgress(0);
            }
            o3 o3Var20 = (o3) this.f7251b;
            if (o3Var20 != null) {
                o3Var20.e.setProgress(0);
            }
            o3 o3Var21 = (o3) this.f7251b;
            if (o3Var21 != null) {
                o3Var21.f13188g.setProgress(0);
            }
            o3 o3Var22 = (o3) this.f7251b;
            if (o3Var22 != null) {
                o3Var22.f13187f.setProgress(0);
            }
            o3 o3Var23 = (o3) this.f7251b;
            if (o3Var23 != null) {
                o3Var23.f13190i.setProgress(0);
            }
            o3 o3Var24 = (o3) this.f7251b;
            TextView textView18 = o3Var24 != null ? o3Var24.f13201u : null;
            if (textView18 != null) {
                textView18.setText("--:--");
            }
            o3 o3Var25 = (o3) this.f7251b;
            textView = o3Var25 != null ? o3Var25.f13200t : null;
            if (textView == null) {
                return;
            }
            textView.setText("--:--");
            return;
        }
        float ring_totalMin = sleepChartData.getRing_totalMin() + (sleepChartData.getRing_totalHour() * 60);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.A()) : null;
        kotlin.jvm.internal.e.c(valueOf);
        float intValue = (100 * ring_totalMin) / valueOf.intValue();
        if (intValue > 100.0f) {
            intValue = 100.0f;
        }
        o3 o3Var26 = (o3) this.f7251b;
        if (o3Var26 != null) {
            o3Var26.f13196o.setProgress(intValue);
        }
        o3 o3Var27 = (o3) this.f7251b;
        TextView textView19 = o3Var27 != null ? o3Var27.F : null;
        if (textView19 != null) {
            textView19.setText(String.valueOf((int) intValue));
        }
        o3 o3Var28 = (o3) this.f7251b;
        TextView textView20 = o3Var28 != null ? o3Var28.E : null;
        if (textView20 != null) {
            textView20.setVisibility(0);
        }
        if (intValue < 40.0f) {
            o3 o3Var29 = (o3) this.f7251b;
            TextView textView21 = o3Var29 != null ? o3Var29.E : null;
            if (textView21 != null) {
                textView21.setText(getString(R$string.str_ring_sleep_level5));
            }
        } else if (intValue >= 40.0f && intValue < 60.0f) {
            o3 o3Var30 = (o3) this.f7251b;
            TextView textView22 = o3Var30 != null ? o3Var30.E : null;
            if (textView22 != null) {
                textView22.setText(getString(R$string.str_ring_sleep_level4));
            }
        } else if (intValue >= 60.0f && intValue < 80.0f) {
            o3 o3Var31 = (o3) this.f7251b;
            TextView textView23 = o3Var31 != null ? o3Var31.E : null;
            if (textView23 != null) {
                textView23.setText(getString(R$string.str_ring_sleep_level3));
            }
        } else if (intValue < 80.0f || intValue >= 100.0f) {
            o3 o3Var32 = (o3) this.f7251b;
            TextView textView24 = o3Var32 != null ? o3Var32.E : null;
            if (textView24 != null) {
                textView24.setText(getString(R$string.str_ring_sleep_level1));
            }
        } else {
            o3 o3Var33 = (o3) this.f7251b;
            TextView textView25 = o3Var33 != null ? o3Var33.E : null;
            if (textView25 != null) {
                textView25.setText(getString(R$string.str_ring_sleep_level2));
            }
        }
        o3 o3Var34 = (o3) this.f7251b;
        TextView textView26 = o3Var34 != null ? o3Var34.f13203w : null;
        if (textView26 != null) {
            textView26.setText(String.valueOf(sleepChartData.getRing_totalHour()));
        }
        o3 o3Var35 = (o3) this.f7251b;
        TextView textView27 = o3Var35 != null ? o3Var35.f13206z : null;
        if (textView27 != null) {
            textView27.setText(String.valueOf(sleepChartData.getRing_totalMin()));
        }
        o3 o3Var36 = (o3) this.f7251b;
        TRingSleepChartView tRingSleepChartView2 = o3Var36 != null ? o3Var36.f13185c : null;
        if (tRingSleepChartView2 != null) {
            tRingSleepChartView2.setVisibility(0);
        }
        o3 o3Var37 = (o3) this.f7251b;
        if (o3Var37 != null) {
            o3Var37.f13185c.post(new androidx.appcompat.app.i0(13, this, sleepChartData));
        }
        int ring_wakeSleepTime = (int) ((sleepChartData.getRing_wakeSleepTime() * 1000) / ring_totalMin);
        int ring_deepSleepTime = (int) ((sleepChartData.getRing_deepSleepTime() * 1000) / ring_totalMin);
        int ring_rapidSleepTime = (int) ((sleepChartData.getRing_rapidSleepTime() * 1000) / ring_totalMin);
        int i3 = ((1000 - ring_deepSleepTime) - ring_wakeSleepTime) - ring_rapidSleepTime;
        int i10 = ring_wakeSleepTime / 10;
        if (i10 == 0 && sleepChartData.getRing_wakeSleepTime() > 0) {
            i10 = 1;
        }
        o3 o3Var38 = (o3) this.f7251b;
        if (o3Var38 != null) {
            o3Var38.e.setProgress(i10);
        }
        o3 o3Var39 = (o3) this.f7251b;
        if (o3Var39 != null) {
            o3Var39.f13188g.setProgress(i3 / 10);
        }
        o3 o3Var40 = (o3) this.f7251b;
        if (o3Var40 != null) {
            o3Var40.f13187f.setProgress(ring_deepSleepTime / 10);
        }
        int i11 = ring_rapidSleepTime / 10;
        if (i11 == 0 && sleepChartData.getRing_rapidSleepTime() > 0) {
            i11 = 1;
        }
        o3 o3Var41 = (o3) this.f7251b;
        if (o3Var41 != null) {
            o3Var41.f13189h.setProgress(i11);
        }
        o3 o3Var42 = (o3) this.f7251b;
        TextView textView28 = o3Var42 != null ? o3Var42.r : null;
        if (textView28 != null) {
            textView28.setText(String.format(Locale.US, "%.1f%%", Arrays.copyOf(new Object[]{Float.valueOf(ring_wakeSleepTime / 10.0f)}, 1)));
        }
        o3 o3Var43 = (o3) this.f7251b;
        TextView textView29 = o3Var43 != null ? o3Var43.f13205y : null;
        if (textView29 != null) {
            textView29.setText(String.format(Locale.US, "%.1f%%", Arrays.copyOf(new Object[]{Float.valueOf(i3 / 10.0f)}, 1)));
        }
        o3 o3Var44 = (o3) this.f7251b;
        TextView textView30 = o3Var44 != null ? o3Var44.f13202v : null;
        if (textView30 != null) {
            textView30.setText(String.format(Locale.US, "%.1f%%", Arrays.copyOf(new Object[]{Float.valueOf(ring_deepSleepTime / 10.0f)}, 1)));
        }
        o3 o3Var45 = (o3) this.f7251b;
        TextView textView31 = o3Var45 != null ? o3Var45.C : null;
        if (textView31 != null) {
            textView31.setText(String.format(Locale.US, "%.1f%%", Arrays.copyOf(new Object[]{Float.valueOf(ring_rapidSleepTime / 10.0f)}, 1)));
        }
        int ring_wakeSleepTime2 = sleepChartData.getRing_wakeSleepTime() / 60;
        int ring_wakeSleepTime3 = sleepChartData.getRing_wakeSleepTime() % 60;
        if (ring_wakeSleepTime2 <= 0) {
            o3 o3Var46 = (o3) this.f7251b;
            TextView textView32 = o3Var46 != null ? o3Var46.N : null;
            if (textView32 != null) {
                textView32.setText(ring_wakeSleepTime3 + "M");
            }
        } else {
            o3 o3Var47 = (o3) this.f7251b;
            TextView textView33 = o3Var47 != null ? o3Var47.N : null;
            if (textView33 != null) {
                textView33.setText(ring_wakeSleepTime2 + "H" + ring_wakeSleepTime3 + "M");
            }
        }
        int ring_lightSleepTime = sleepChartData.getRing_lightSleepTime() / 60;
        int ring_lightSleepTime2 = sleepChartData.getRing_lightSleepTime() % 60;
        if (ring_lightSleepTime <= 0) {
            o3 o3Var48 = (o3) this.f7251b;
            TextView textView34 = o3Var48 != null ? o3Var48.Q : null;
            if (textView34 != null) {
                textView34.setText(ring_lightSleepTime2 + "M");
            }
        } else {
            o3 o3Var49 = (o3) this.f7251b;
            TextView textView35 = o3Var49 != null ? o3Var49.Q : null;
            if (textView35 != null) {
                textView35.setText(ring_lightSleepTime + "H" + ring_lightSleepTime2 + "M");
            }
        }
        int ring_deepSleepTime2 = sleepChartData.getRing_deepSleepTime() / 60;
        int ring_deepSleepTime3 = sleepChartData.getRing_deepSleepTime() % 60;
        if (ring_deepSleepTime2 <= 0) {
            o3 o3Var50 = (o3) this.f7251b;
            TextView textView36 = o3Var50 != null ? o3Var50.P : null;
            if (textView36 != null) {
                textView36.setText(ring_deepSleepTime3 + "M");
            }
        } else {
            o3 o3Var51 = (o3) this.f7251b;
            TextView textView37 = o3Var51 != null ? o3Var51.P : null;
            if (textView37 != null) {
                textView37.setText(ring_deepSleepTime2 + "H" + ring_deepSleepTime3 + "M");
            }
        }
        int ring_rapidSleepTime2 = sleepChartData.getRing_rapidSleepTime() / 60;
        int ring_rapidSleepTime3 = sleepChartData.getRing_rapidSleepTime() % 60;
        if (ring_rapidSleepTime2 <= 0) {
            o3 o3Var52 = (o3) this.f7251b;
            TextView textView38 = o3Var52 != null ? o3Var52.S : null;
            if (textView38 != null) {
                textView38.setText(ring_rapidSleepTime3 + "M");
            }
        } else {
            o3 o3Var53 = (o3) this.f7251b;
            TextView textView39 = o3Var53 != null ? o3Var53.S : null;
            if (textView39 != null) {
                textView39.setText(ring_rapidSleepTime2 + "H" + ring_rapidSleepTime3 + "M");
            }
        }
        if (this.e) {
            o3 o3Var54 = (o3) this.f7251b;
            TextView textView40 = o3Var54 != null ? o3Var54.C : null;
            if (textView40 != null) {
                textView40.setVisibility(0);
            }
            o3 o3Var55 = (o3) this.f7251b;
            TextView textView41 = o3Var55 != null ? o3Var55.D : null;
            if (textView41 != null) {
                textView41.setVisibility(0);
            }
            o3 o3Var56 = (o3) this.f7251b;
            ProgressBar progressBar = o3Var56 != null ? o3Var56.f13189h : null;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            o3 o3Var57 = (o3) this.f7251b;
            TextView textView42 = o3Var57 != null ? o3Var57.S : null;
            if (textView42 != null) {
                textView42.setVisibility(0);
            }
            o3 o3Var58 = (o3) this.f7251b;
            LinearLayout linearLayout = o3Var58 != null ? o3Var58.f13191j : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            o3 o3Var59 = (o3) this.f7251b;
            TextView textView43 = o3Var59 != null ? o3Var59.C : null;
            if (textView43 != null) {
                textView43.setVisibility(8);
            }
            o3 o3Var60 = (o3) this.f7251b;
            TextView textView44 = o3Var60 != null ? o3Var60.D : null;
            if (textView44 != null) {
                textView44.setVisibility(8);
            }
            o3 o3Var61 = (o3) this.f7251b;
            ProgressBar progressBar2 = o3Var61 != null ? o3Var61.f13189h : null;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
            o3 o3Var62 = (o3) this.f7251b;
            TextView textView45 = o3Var62 != null ? o3Var62.S : null;
            if (textView45 != null) {
                textView45.setVisibility(8);
            }
            o3 o3Var63 = (o3) this.f7251b;
            LinearLayout linearLayout2 = o3Var63 != null ? o3Var63.f13191j : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        int intValue2 = valueOf.intValue() / 60;
        int intValue3 = valueOf.intValue() % 60;
        o3 o3Var64 = (o3) this.f7251b;
        TextView textView46 = o3Var64 != null ? o3Var64.J : null;
        if (textView46 != null) {
            textView46.setText(String.valueOf(intValue2));
        }
        o3 o3Var65 = (o3) this.f7251b;
        TextView textView47 = o3Var65 != null ? o3Var65.L : null;
        if (textView47 != null) {
            textView47.setText(String.valueOf(intValue3));
        }
        o3 o3Var66 = (o3) this.f7251b;
        TextView textView48 = o3Var66 != null ? o3Var66.G : null;
        if (textView48 != null) {
            textView48.setText(String.valueOf(sleepChartData.getRing_totalHour()));
        }
        o3 o3Var67 = (o3) this.f7251b;
        textView = o3Var67 != null ? o3Var67.H : null;
        if (textView != null) {
            textView.setText(String.valueOf(sleepChartData.getRing_totalMin()));
        }
        o3 o3Var68 = (o3) this.f7251b;
        if (o3Var68 != null) {
            o3Var68.f13190i.setProgress((int) intValue);
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View a3;
        View inflate = layoutInflater.inflate(R$layout.fragment_sleep, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        int i3 = R$id.daySleepChart;
        TRingSleepChartView tRingSleepChartView = (TRingSleepChartView) he.a(i3, inflate);
        if (tRingSleepChartView != null) {
            i3 = R$id.ll_desc;
            if (((LinearLayout) he.a(i3, inflate)) != null) {
                i3 = R$id.ll_sleep_time;
                if (((LinearLayout) he.a(i3, inflate)) != null) {
                    i3 = R$id.ll_sleeptime;
                    if (((LinearLayout) he.a(i3, inflate)) != null) {
                        i3 = R$id.ll_target_time;
                        if (((LinearLayout) he.a(i3, inflate)) != null) {
                            i3 = R$id.nsv_data;
                            NestedScrollView nestedScrollView = (NestedScrollView) he.a(i3, inflate);
                            if (nestedScrollView != null) {
                                i3 = R$id.pb_awake;
                                ProgressBar progressBar = (ProgressBar) he.a(i3, inflate);
                                if (progressBar != null) {
                                    i3 = R$id.pb_deepsleep;
                                    ProgressBar progressBar2 = (ProgressBar) he.a(i3, inflate);
                                    if (progressBar2 != null) {
                                        i3 = R$id.pb_lightsleep;
                                        ProgressBar progressBar3 = (ProgressBar) he.a(i3, inflate);
                                        if (progressBar3 != null) {
                                            i3 = R$id.pb_rapid_sleep;
                                            ProgressBar progressBar4 = (ProgressBar) he.a(i3, inflate);
                                            if (progressBar4 != null) {
                                                i3 = R$id.pb_st;
                                                ProgressBar progressBar5 = (ProgressBar) he.a(i3, inflate);
                                                if (progressBar5 != null) {
                                                    i3 = R$id.rapidCircle;
                                                    LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
                                                    if (linearLayout != null) {
                                                        i3 = R$id.rl_sleep_info;
                                                        RelativeLayout relativeLayout = (RelativeLayout) he.a(i3, inflate);
                                                        if (relativeLayout != null) {
                                                            i3 = R$id.rl_sleep_target_info;
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) he.a(i3, inflate);
                                                            if (relativeLayout2 != null) {
                                                                i3 = R$id.rl_target_time;
                                                                TextView textView = (TextView) he.a(i3, inflate);
                                                                if (textView != null) {
                                                                    i3 = R$id.rl_title;
                                                                    TextView textView2 = (TextView) he.a(i3, inflate);
                                                                    if (textView2 != null) {
                                                                        i3 = R$id.sleep_progress;
                                                                        NoThumbCircleProgressView noThumbCircleProgressView = (NoThumbCircleProgressView) he.a(i3, inflate);
                                                                        if (noThumbCircleProgressView != null) {
                                                                            i3 = R$id.toolbar;
                                                                            TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
                                                                            if (tRingToolBarView != null) {
                                                                                i3 = R$id.tv_awake;
                                                                                TextView textView3 = (TextView) he.a(i3, inflate);
                                                                                if (textView3 != null) {
                                                                                    i3 = R$id.tv_awake_percent;
                                                                                    TextView textView4 = (TextView) he.a(i3, inflate);
                                                                                    if (textView4 != null) {
                                                                                        i3 = R$id.tv_awake_time;
                                                                                        TextView textView5 = (TextView) he.a(i3, inflate);
                                                                                        if (textView5 != null) {
                                                                                            i3 = R$id.tv_bottom_endtime;
                                                                                            TextView textView6 = (TextView) he.a(i3, inflate);
                                                                                            if (textView6 != null) {
                                                                                                i3 = R$id.tv_bottom_starttime;
                                                                                                TextView textView7 = (TextView) he.a(i3, inflate);
                                                                                                if (textView7 != null) {
                                                                                                    i3 = R$id.tv_deepsleep_percent;
                                                                                                    TextView textView8 = (TextView) he.a(i3, inflate);
                                                                                                    if (textView8 != null) {
                                                                                                        i3 = R$id.tv_deepsleep_title;
                                                                                                        if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                            i3 = R$id.tv_distance;
                                                                                                            if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                                i3 = R$id.tv_hour;
                                                                                                                TextView textView9 = (TextView) he.a(i3, inflate);
                                                                                                                if (textView9 != null) {
                                                                                                                    i3 = R$id.tv_hour_unit;
                                                                                                                    TextView textView10 = (TextView) he.a(i3, inflate);
                                                                                                                    if (textView10 != null) {
                                                                                                                        i3 = R$id.tv_lightsleep_percent;
                                                                                                                        TextView textView11 = (TextView) he.a(i3, inflate);
                                                                                                                        if (textView11 != null) {
                                                                                                                            i3 = R$id.tv_lightsleep_title;
                                                                                                                            if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                                                i3 = R$id.tv_min;
                                                                                                                                TextView textView12 = (TextView) he.a(i3, inflate);
                                                                                                                                if (textView12 != null) {
                                                                                                                                    i3 = R$id.tv_min_text;
                                                                                                                                    TextView textView13 = (TextView) he.a(i3, inflate);
                                                                                                                                    if (textView13 != null) {
                                                                                                                                        i3 = R$id.tv_min_unit;
                                                                                                                                        TextView textView14 = (TextView) he.a(i3, inflate);
                                                                                                                                        if (textView14 != null) {
                                                                                                                                            i3 = R$id.tv_rapid_sleep_percent;
                                                                                                                                            TextView textView15 = (TextView) he.a(i3, inflate);
                                                                                                                                            if (textView15 != null) {
                                                                                                                                                i3 = R$id.tv_rapid_sleep_title;
                                                                                                                                                TextView textView16 = (TextView) he.a(i3, inflate);
                                                                                                                                                if (textView16 != null) {
                                                                                                                                                    i3 = R$id.tv_sleep_desc;
                                                                                                                                                    TextView textView17 = (TextView) he.a(i3, inflate);
                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                        i3 = R$id.tv_sleep_progress;
                                                                                                                                                        TextView textView18 = (TextView) he.a(i3, inflate);
                                                                                                                                                        if (textView18 != null) {
                                                                                                                                                            i3 = R$id.tv_sleeptime_title;
                                                                                                                                                            if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                                                                                i3 = R$id.tv_st_hour;
                                                                                                                                                                TextView textView19 = (TextView) he.a(i3, inflate);
                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                    i3 = R$id.tv_st_hour_unit;
                                                                                                                                                                    if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                                                                                        i3 = R$id.tv_st_min;
                                                                                                                                                                        TextView textView20 = (TextView) he.a(i3, inflate);
                                                                                                                                                                        if (textView20 != null) {
                                                                                                                                                                            i3 = R$id.tv_st_min_unit;
                                                                                                                                                                            if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                                                                                                i3 = R$id.tv_start_time;
                                                                                                                                                                                TextView textView21 = (TextView) he.a(i3, inflate);
                                                                                                                                                                                if (textView21 != null) {
                                                                                                                                                                                    i3 = R$id.tv_target;
                                                                                                                                                                                    if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                                                                                                        i3 = R$id.tv_target_hour;
                                                                                                                                                                                        TextView textView22 = (TextView) he.a(i3, inflate);
                                                                                                                                                                                        if (textView22 != null) {
                                                                                                                                                                                            i3 = R$id.tv_target_hour_unit;
                                                                                                                                                                                            TextView textView23 = (TextView) he.a(i3, inflate);
                                                                                                                                                                                            if (textView23 != null) {
                                                                                                                                                                                                i3 = R$id.tv_target_min;
                                                                                                                                                                                                TextView textView24 = (TextView) he.a(i3, inflate);
                                                                                                                                                                                                if (textView24 != null) {
                                                                                                                                                                                                    i3 = R$id.tv_target_min_unit;
                                                                                                                                                                                                    TextView textView25 = (TextView) he.a(i3, inflate);
                                                                                                                                                                                                    if (textView25 != null) {
                                                                                                                                                                                                        i3 = R$id.v_awake_title;
                                                                                                                                                                                                        if (((TextView) he.a(i3, inflate)) != null) {
                                                                                                                                                                                                            i3 = R$id.v_awake_value;
                                                                                                                                                                                                            TextView textView26 = (TextView) he.a(i3, inflate);
                                                                                                                                                                                                            if (textView26 != null) {
                                                                                                                                                                                                                i3 = R$id.v_bottom;
                                                                                                                                                                                                                RelativeLayout relativeLayout3 = (RelativeLayout) he.a(i3, inflate);
                                                                                                                                                                                                                if (relativeLayout3 != null) {
                                                                                                                                                                                                                    i3 = R$id.v_deepsleep_value;
                                                                                                                                                                                                                    TextView textView27 = (TextView) he.a(i3, inflate);
                                                                                                                                                                                                                    if (textView27 != null) {
                                                                                                                                                                                                                        i3 = R$id.v_lightsleep_value;
                                                                                                                                                                                                                        TextView textView28 = (TextView) he.a(i3, inflate);
                                                                                                                                                                                                                        if (textView28 != null && (a3 = he.a((i3 = R$id.v_middle), inflate)) != null) {
                                                                                                                                                                                                                            i3 = R$id.v_rapid_sleep_value;
                                                                                                                                                                                                                            TextView textView29 = (TextView) he.a(i3, inflate);
                                                                                                                                                                                                                            if (textView29 != null) {
                                                                                                                                                                                                                                i3 = R$id.view_date_select;
                                                                                                                                                                                                                                TRingDateSelectView tRingDateSelectView = (TRingDateSelectView) he.a(i3, inflate);
                                                                                                                                                                                                                                if (tRingDateSelectView != null) {
                                                                                                                                                                                                                                    i3 = R$id.week_calendar_2;
                                                                                                                                                                                                                                    if (((CalendarLayout) he.a(i3, inflate)) != null) {
                                                                                                                                                                                                                                        i3 = R$id.weekCalendarView;
                                                                                                                                                                                                                                        CalendarView calendarView = (CalendarView) he.a(i3, inflate);
                                                                                                                                                                                                                                        if (calendarView != null) {
                                                                                                                                                                                                                                            i3 = R$id.wv_progress;
                                                                                                                                                                                                                                            WaveView waveView = (WaveView) he.a(i3, inflate);
                                                                                                                                                                                                                                            if (waveView != null) {
                                                                                                                                                                                                                                                return new o3(constraintLayout, constraintLayout, tRingSleepChartView, nestedScrollView, progressBar, progressBar2, progressBar3, progressBar4, progressBar5, linearLayout, relativeLayout, relativeLayout2, textView, textView2, noThumbCircleProgressView, tRingToolBarView, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, relativeLayout3, textView27, textView28, a3, textView29, tRingDateSelectView, calendarView, waveView);
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // g7.v
    public final void c0(List list) {
        Log.d(this.f8235c, "----onSleepChartPath----");
        Object obj = this.f7251b;
        kotlin.jvm.internal.e.c(obj);
        boolean z5 = this.e;
        TRingSleepChartView tRingSleepChartView = ((o3) obj).f13185c;
        Log.d("chart", "------setData");
        tRingSleepChartView.f8625d = z5;
        tRingSleepChartView.f8622a = list;
        tRingSleepChartView.invalidate();
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void e0() {
    }

    @Override // p5.a
    public final Context f0() {
        Context context = getContext();
        kotlin.jvm.internal.e.d(context, "null cannot be cast to non-null type android.content.Context");
        return context;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void h0() {
        o3 o3Var = (o3) this.f7251b;
        if (o3Var != null) {
            TRingDateSelectView tRingDateSelectView = o3Var.T;
            tRingDateSelectView.setDateModel(0);
            tRingDateSelectView.setOnDateSelectedListener(new p0(this));
            tRingDateSelectView.c();
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        Log.e(this.f8235c, "initView");
        u0();
        o3 o3Var = (o3) this.f7251b;
        TextView textView = o3Var != null ? o3Var.f13198q : null;
        if (textView != null) {
            textView.setVisibility(4);
        }
        o3 o3Var2 = (o3) this.f7251b;
        TextView textView2 = o3Var2 != null ? o3Var2.A : null;
        if (textView2 != null) {
            textView2.setVisibility(4);
        }
        o3 o3Var3 = (o3) this.f7251b;
        TextView textView3 = o3Var3 != null ? o3Var3.f13199s : null;
        if (textView3 != null) {
            textView3.setText("--");
        }
        o3 o3Var4 = (o3) this.f7251b;
        TextView textView4 = o3Var4 != null ? o3Var4.I : null;
        if (textView4 != null) {
            textView4.setVisibility(4);
        }
        o3 o3Var5 = (o3) this.f7251b;
        if (o3Var5 != null) {
            o3Var5.f13196o.setWidth(com.example.baselibrary.utils.b.f(f0(), 200.0f));
        }
        o3 o3Var6 = (o3) this.f7251b;
        if (o3Var6 != null) {
            o3Var6.f13197p.setbarStatusIvVisiable(4);
        }
        o3 o3Var7 = (o3) this.f7251b;
        if (o3Var7 != null) {
            o3Var7.V.setHideText(true);
        }
        Calendar calendar = Calendar.getInstance();
        o3 o3Var8 = (o3) this.f7251b;
        if (o3Var8 != null) {
            o3Var8.U.d(PlaybackException.ERROR_CODE_IO_BAD_HTTP_STATUS, calendar.get(1), calendar.get(2) + 1, calendar.get(5));
        }
        o3 o3Var9 = (o3) this.f7251b;
        if (o3Var9 != null) {
            o3Var9.U.setOnCalendarSelectListener(this);
        }
        o3 o3Var10 = (o3) this.f7251b;
        if (o3Var10 != null) {
            o3Var10.U.e();
        }
        o3 o3Var11 = (o3) this.f7251b;
        if (o3Var11 != null) {
            o3Var11.f13185c.setSleepChartChangeListener(new p0(this));
        }
        o3 o3Var12 = (o3) this.f7251b;
        if (o3Var12 != null) {
            o3Var12.f13197p.setOnViewChildListener(new p0(this));
        }
    }

    @Override // md.k
    public final void o(com.haibin.calendarview.Calendar calendar) {
        if (calendar != null) {
            int year = calendar.getYear();
            Locale locale = Locale.US;
            String str = year + "/" + String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(calendar.getMonth())}, 1)) + "/" + String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(calendar.getDay())}, 1));
            this.f8236d = str;
            o3 o3Var = (o3) this.f7251b;
            if (o3Var != null) {
                o3Var.T.setDate(str);
            }
            Log.e(this.f8235c, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onCalendarSelect ", this.f8236d));
            u0();
            ((com.example.test.presenter.main.c1) X()).k(this.f8236d);
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Log.e(this.f8235c, "TRingSleepFragment onDestroy");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Log.e(this.f8235c, "TRingSleepFragment onDestroyView");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        Log.e(this.f8235c, "TRingSleepFragment onPause");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Log.e(this.f8235c, "TRingSleepFragment onResume");
        ((com.example.test.presenter.main.c1) X()).k(this.f8236d);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.e.f(outState, "outState");
        super.onSaveInstanceState(outState);
    }

    public final void q0() {
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        ConstraintLayout constraintLayout3;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.D()) : null;
        Log.d("tong", "mainActivity app style = " + valueOf);
        if (valueOf != null && valueOf.intValue() == 0) {
            o3 o3Var = (o3) this.f7251b;
            if (o3Var != null) {
                o3Var.f13197p.setBarTitleColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var2 = (o3) this.f7251b;
            if (o3Var2 != null && (constraintLayout3 = o3Var2.f13184b) != null) {
                constraintLayout3.setBackgroundColor(a1.d.a(f0(), R$color.color_black));
            }
            Drawable b3 = a1.c.b(f0(), R$drawable.svg_ic_activitypage_share);
            kotlin.jvm.internal.e.d(b3, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
            VectorDrawable vectorDrawable = (VectorDrawable) b3;
            vectorDrawable.setTint(a1.d.a(f0(), R$color.color_white));
            o3 o3Var3 = (o3) this.f7251b;
            if (o3Var3 != null) {
                o3Var3.f13197p.setBarOption1Iv(vectorDrawable);
            }
            o3 o3Var4 = (o3) this.f7251b;
            if (o3Var4 != null) {
                o3Var4.T.setDateColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var5 = (o3) this.f7251b;
            if (o3Var5 != null) {
                o3Var5.U.f(a1.d.a(f0(), R$color.color_white), a1.d.a(f0(), R$color.color_white), a1.d.a(f0(), R$color.color_828282), a1.d.a(f0(), R$color.color_white), a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var6 = (o3) this.f7251b;
            if (o3Var6 != null) {
                o3Var6.U.g(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var7 = (o3) this.f7251b;
            if (o3Var7 != null) {
                o3Var7.f13192k.setBackgroundResource(R$drawable.shape_cell_background_grey);
            }
            o3 o3Var8 = (o3) this.f7251b;
            if (o3Var8 != null) {
                o3Var8.O.setBackgroundResource(R$drawable.shape_cell_background_grey);
            }
            o3 o3Var9 = (o3) this.f7251b;
            if (o3Var9 != null) {
                o3Var9.f13193l.setBackgroundResource(R$drawable.shape_cell_background_grey);
            }
            o3 o3Var10 = (o3) this.f7251b;
            if (o3Var10 != null) {
                o3Var10.f13195n.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var11 = (o3) this.f7251b;
            if (o3Var11 != null) {
                o3Var11.F.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var12 = (o3) this.f7251b;
            if (o3Var12 != null) {
                o3Var12.f13199s.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var13 = (o3) this.f7251b;
            if (o3Var13 != null) {
                o3Var13.I.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var14 = (o3) this.f7251b;
            if (o3Var14 != null) {
                o3Var14.f13194m.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var15 = (o3) this.f7251b;
            if (o3Var15 != null) {
                o3Var15.J.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var16 = (o3) this.f7251b;
            if (o3Var16 != null) {
                o3Var16.K.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var17 = (o3) this.f7251b;
            if (o3Var17 != null) {
                o3Var17.L.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var18 = (o3) this.f7251b;
            if (o3Var18 != null) {
                o3Var18.M.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var19 = (o3) this.f7251b;
            if (o3Var19 != null) {
                o3Var19.f13203w.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var20 = (o3) this.f7251b;
            if (o3Var20 != null) {
                o3Var20.f13204x.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var21 = (o3) this.f7251b;
            if (o3Var21 != null) {
                o3Var21.f13206z.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var22 = (o3) this.f7251b;
            if (o3Var22 != null) {
                o3Var22.B.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var23 = (o3) this.f7251b;
            if (o3Var23 != null) {
                o3Var23.N.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var24 = (o3) this.f7251b;
            if (o3Var24 != null) {
                o3Var24.Q.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var25 = (o3) this.f7251b;
            if (o3Var25 != null) {
                o3Var25.P.setTextColor(a1.d.a(f0(), R$color.color_white));
            }
            o3 o3Var26 = (o3) this.f7251b;
            if (o3Var26 != null) {
                o3Var26.S.setTextColor(a1.d.a(f0(), R$color.color_white));
                return;
            }
            return;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            o3 o3Var27 = (o3) this.f7251b;
            if (o3Var27 != null) {
                o3Var27.f13197p.setBarTitleColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var28 = (o3) this.f7251b;
            if (o3Var28 != null && (constraintLayout2 = o3Var28.f13184b) != null) {
                constraintLayout2.setBackgroundColor(a1.d.a(f0(), R$color.color_greywhite));
            }
            Drawable b10 = a1.c.b(f0(), R$drawable.svg_ic_activitypage_share);
            kotlin.jvm.internal.e.d(b10, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
            VectorDrawable vectorDrawable2 = (VectorDrawable) b10;
            vectorDrawable2.setTint(a1.d.a(f0(), R$color.color_black));
            o3 o3Var29 = (o3) this.f7251b;
            if (o3Var29 != null) {
                o3Var29.f13197p.setBarOption1Iv(vectorDrawable2);
            }
            o3 o3Var30 = (o3) this.f7251b;
            if (o3Var30 != null) {
                o3Var30.T.setDateColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var31 = (o3) this.f7251b;
            if (o3Var31 != null) {
                o3Var31.U.f(a1.d.a(f0(), R$color.color_black), a1.d.a(f0(), R$color.color_black), a1.d.a(f0(), R$color.color_828282), a1.d.a(f0(), R$color.color_black), a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var32 = (o3) this.f7251b;
            if (o3Var32 != null) {
                o3Var32.U.g(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var33 = (o3) this.f7251b;
            if (o3Var33 != null) {
                o3Var33.f13192k.setBackgroundResource(R$drawable.shape_cell_background_white);
            }
            o3 o3Var34 = (o3) this.f7251b;
            if (o3Var34 != null) {
                o3Var34.O.setBackgroundResource(R$drawable.shape_cell_background_white);
            }
            o3 o3Var35 = (o3) this.f7251b;
            if (o3Var35 != null) {
                o3Var35.f13193l.setBackgroundResource(R$drawable.shape_cell_background_white);
            }
            o3 o3Var36 = (o3) this.f7251b;
            if (o3Var36 != null) {
                o3Var36.f13195n.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var37 = (o3) this.f7251b;
            if (o3Var37 != null) {
                o3Var37.F.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var38 = (o3) this.f7251b;
            if (o3Var38 != null) {
                o3Var38.f13199s.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var39 = (o3) this.f7251b;
            if (o3Var39 != null) {
                o3Var39.I.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var40 = (o3) this.f7251b;
            if (o3Var40 != null) {
                o3Var40.f13194m.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var41 = (o3) this.f7251b;
            if (o3Var41 != null) {
                o3Var41.J.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var42 = (o3) this.f7251b;
            if (o3Var42 != null) {
                o3Var42.K.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var43 = (o3) this.f7251b;
            if (o3Var43 != null) {
                o3Var43.L.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var44 = (o3) this.f7251b;
            if (o3Var44 != null) {
                o3Var44.M.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var45 = (o3) this.f7251b;
            if (o3Var45 != null) {
                o3Var45.f13203w.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var46 = (o3) this.f7251b;
            if (o3Var46 != null) {
                o3Var46.f13204x.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var47 = (o3) this.f7251b;
            if (o3Var47 != null) {
                o3Var47.f13206z.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var48 = (o3) this.f7251b;
            if (o3Var48 != null) {
                o3Var48.B.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var49 = (o3) this.f7251b;
            if (o3Var49 != null) {
                o3Var49.N.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var50 = (o3) this.f7251b;
            if (o3Var50 != null) {
                o3Var50.Q.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var51 = (o3) this.f7251b;
            if (o3Var51 != null) {
                o3Var51.P.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var52 = (o3) this.f7251b;
            if (o3Var52 != null) {
                o3Var52.S.setTextColor(a1.d.a(f0(), R$color.color_black));
                return;
            }
            return;
        }
        if (valueOf != null && valueOf.intValue() == 2) {
            o3 o3Var53 = (o3) this.f7251b;
            if (o3Var53 != null) {
                o3Var53.f13197p.setBarTitleColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var54 = (o3) this.f7251b;
            if (o3Var54 != null && (constraintLayout = o3Var54.f13184b) != null) {
                constraintLayout.setBackgroundColor(a1.d.a(f0(), R$color.color_pink));
            }
            Drawable b11 = a1.c.b(f0(), R$drawable.svg_ic_activitypage_share);
            kotlin.jvm.internal.e.d(b11, "null cannot be cast to non-null type android.graphics.drawable.VectorDrawable");
            VectorDrawable vectorDrawable3 = (VectorDrawable) b11;
            vectorDrawable3.setTint(a1.d.a(f0(), R$color.color_black));
            o3 o3Var55 = (o3) this.f7251b;
            if (o3Var55 != null) {
                o3Var55.f13197p.setBarOption1Iv(vectorDrawable3);
            }
            o3 o3Var56 = (o3) this.f7251b;
            if (o3Var56 != null) {
                o3Var56.T.setDateColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var57 = (o3) this.f7251b;
            if (o3Var57 != null) {
                o3Var57.U.f(a1.d.a(f0(), R$color.color_black), a1.d.a(f0(), R$color.color_black), a1.d.a(f0(), R$color.color_828282), a1.d.a(f0(), R$color.color_black), a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var58 = (o3) this.f7251b;
            if (o3Var58 != null) {
                o3Var58.U.g(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var59 = (o3) this.f7251b;
            if (o3Var59 != null) {
                o3Var59.f13192k.setBackgroundResource(R$drawable.shape_cell_background_white);
            }
            o3 o3Var60 = (o3) this.f7251b;
            if (o3Var60 != null) {
                o3Var60.O.setBackgroundResource(R$drawable.shape_cell_background_white);
            }
            o3 o3Var61 = (o3) this.f7251b;
            if (o3Var61 != null) {
                o3Var61.f13193l.setBackgroundResource(R$drawable.shape_cell_background_white);
            }
            o3 o3Var62 = (o3) this.f7251b;
            if (o3Var62 != null) {
                o3Var62.f13195n.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var63 = (o3) this.f7251b;
            if (o3Var63 != null) {
                o3Var63.F.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var64 = (o3) this.f7251b;
            if (o3Var64 != null) {
                o3Var64.f13199s.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var65 = (o3) this.f7251b;
            if (o3Var65 != null) {
                o3Var65.I.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var66 = (o3) this.f7251b;
            if (o3Var66 != null) {
                o3Var66.f13194m.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var67 = (o3) this.f7251b;
            if (o3Var67 != null) {
                o3Var67.J.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var68 = (o3) this.f7251b;
            if (o3Var68 != null) {
                o3Var68.K.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var69 = (o3) this.f7251b;
            if (o3Var69 != null) {
                o3Var69.L.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var70 = (o3) this.f7251b;
            if (o3Var70 != null) {
                o3Var70.M.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var71 = (o3) this.f7251b;
            if (o3Var71 != null) {
                o3Var71.f13203w.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var72 = (o3) this.f7251b;
            if (o3Var72 != null) {
                o3Var72.f13204x.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var73 = (o3) this.f7251b;
            if (o3Var73 != null) {
                o3Var73.f13206z.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var74 = (o3) this.f7251b;
            if (o3Var74 != null) {
                o3Var74.B.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var75 = (o3) this.f7251b;
            if (o3Var75 != null) {
                o3Var75.N.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var76 = (o3) this.f7251b;
            if (o3Var76 != null) {
                o3Var76.Q.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var77 = (o3) this.f7251b;
            if (o3Var77 != null) {
                o3Var77.P.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
            o3 o3Var78 = (o3) this.f7251b;
            if (o3Var78 != null) {
                o3Var78.S.setTextColor(a1.d.a(f0(), R$color.color_black));
            }
        }
    }

    public final void u0() {
        o3 o3Var = (o3) this.f7251b;
        TextView textView = o3Var != null ? o3Var.C : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        o3 o3Var2 = (o3) this.f7251b;
        TextView textView2 = o3Var2 != null ? o3Var2.D : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        o3 o3Var3 = (o3) this.f7251b;
        ProgressBar progressBar = o3Var3 != null ? o3Var3.f13189h : null;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        o3 o3Var4 = (o3) this.f7251b;
        TextView textView3 = o3Var4 != null ? o3Var4.S : null;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        o3 o3Var5 = (o3) this.f7251b;
        LinearLayout linearLayout = o3Var5 != null ? o3Var5.f13191j : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    @Override // t7.d
    public final void x(Entry entry) {
    }
}
