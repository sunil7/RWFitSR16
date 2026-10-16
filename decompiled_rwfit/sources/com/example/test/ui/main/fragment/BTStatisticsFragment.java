package com.example.test.ui.main.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.example.baselibrary.base.fragment.BaseFragment;
import com.example.database.table.User;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.TempChartData;
import com.example.test.ui.model.chart.formatter.DayFormatter;
import com.example.test.ui.model.chart.formatter.MonthFormatter;
import com.example.test.ui.model.chart.formatter.WeekFormatter;
import com.example.test.ui.model.chart.formatter.YearFormatter;
import com.example.test.ui.view.DataView;
import com.example.test.ui.view.DateSelectView;
import com.example.test.ui.view.MyFloatMarkerView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import com.github.mikephil.charting.components.YAxis$YAxisLabelPosition;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet$Mode;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.v1;
import f6.f3;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class BTStatisticsFragment extends BaseFragment<com.example.test.presenter.main.h, f3> implements g7.e, t7.d {

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f8039c = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.BTStatisticsFragment$statisticsType$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Bundle arguments = BTStatisticsFragment.this.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("statistics_type") : 0);
        }
    });

    @Override // t7.d
    public final void A() {
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new com.example.test.presenter.main.h(this);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        f3 f3Var = (f3) this.f7251b;
        if (f3Var != null) {
            return f3Var.f12878a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View a3;
        View a10;
        View inflate = layoutInflater.inflate(R$layout.fragment_bt_statistics, viewGroup, false);
        int i3 = R$id.chart1;
        LineChart lineChart = (LineChart) he.a(i3, inflate);
        if (lineChart != null && (a3 = he.a((i3 = R$id.current_line), inflate)) != null) {
            i3 = R$id.dv_avg_temp;
            DataView dataView = (DataView) he.a(i3, inflate);
            if (dataView != null) {
                i3 = R$id.dv_current_temp;
                DataView dataView2 = (DataView) he.a(i3, inflate);
                if (dataView2 != null) {
                    i3 = R$id.dv_max_temp;
                    DataView dataView3 = (DataView) he.a(i3, inflate);
                    if (dataView3 != null) {
                        i3 = R$id.dv_min_temp;
                        DataView dataView4 = (DataView) he.a(i3, inflate);
                        if (dataView4 != null) {
                            i3 = R$id.end_time;
                            TextView textView = (TextView) he.a(i3, inflate);
                            if (textView != null) {
                                i3 = R$id.high_temp_tips;
                                DataView dataView5 = (DataView) he.a(i3, inflate);
                                if (dataView5 != null && (a10 = he.a((i3 = R$id.line_sleep), inflate)) != null) {
                                    i3 = R$id.ll_time;
                                    LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
                                    if (linearLayout != null) {
                                        i3 = R$id.middle_temp_tips;
                                        DataView dataView6 = (DataView) he.a(i3, inflate);
                                        if (dataView6 != null) {
                                            i3 = R$id.normal_temp_tips;
                                            DataView dataView7 = (DataView) he.a(i3, inflate);
                                            if (dataView7 != null) {
                                                i3 = R$id.slow_temp_tips;
                                                DataView dataView8 = (DataView) he.a(i3, inflate);
                                                if (dataView8 != null) {
                                                    i3 = R$id.start_time;
                                                    TextView textView2 = (TextView) he.a(i3, inflate);
                                                    if (textView2 != null) {
                                                        i3 = R$id.view_date_select;
                                                        DateSelectView dateSelectView = (DateSelectView) he.a(i3, inflate);
                                                        if (dateSelectView != null) {
                                                            return new f3((NestedScrollView) inflate, lineChart, a3, dataView, dataView2, dataView3, dataView4, textView, dataView5, a10, linearLayout, dataView6, dataView7, dataView8, textView2, dateSelectView);
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

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void e0() {
    }

    @Override // p5.a
    public final Context f0() {
        FragmentActivity activity = getActivity();
        kotlin.jvm.internal.e.d(activity, "null cannot be cast to non-null type android.content.Context");
        return activity;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void h0() {
        f3 f3Var = (f3) this.f7251b;
        if (f3Var != null) {
            DateSelectView dateSelectView = f3Var.f12892p;
            dateSelectView.setDateModel(q0());
            dateSelectView.setOnDateSelectedListener(new n(this, 4));
            dateSelectView.c();
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        b2.a(this);
        f3 f3Var = (f3) this.f7251b;
        if (f3Var != null) {
            LineChart lineChart = f3Var.f12879b;
            lineChart.setOnChartValueSelectedListener(this);
            lineChart.setDrawGridBackground(false);
            lineChart.getDescription().f16406a = false;
            lineChart.setTouchEnabled(true);
            lineChart.setDragEnabled(true);
            lineChart.setScaleEnabled(false);
            lineChart.setPinchZoom(false);
            MyFloatMarkerView myFloatMarkerView = new MyFloatMarkerView((FragmentActivity) f0(), R$layout.custom_marker_view);
            f3 f3Var2 = (f3) this.f7251b;
            myFloatMarkerView.setChartView(f3Var2 != null ? f3Var2.f12879b : null);
            lineChart.setMarker(myFloatMarkerView);
            lineChart.getXAxis().H = true;
            lineChart.getXAxis().I = XAxis$XAxisPosition.BOTTOM;
            lineChart.getXAxis().e = -1;
            lineChart.getXAxis().f(0.0f);
            int q02 = q0();
            if (q02 == 0) {
                f3 f3Var3 = (f3) this.f7251b;
                LinearLayout linearLayout = f3Var3 != null ? f3Var3.f12887k : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                lineChart.getXAxis().f16386f = new DayFormatter(f0());
            } else if (q02 == 1) {
                lineChart.getXAxis().f16386f = new WeekFormatter(f0());
            } else if (q02 == 2) {
                lineChart.getXAxis().f16386f = new MonthFormatter(f0());
            } else if (q02 == 3) {
                lineChart.getXAxis().f16386f = new YearFormatter(f0());
            }
            lineChart.getAxisLeft().getClass();
            lineChart.getAxisLeft().f(0.0f);
            lineChart.getAxisRight().f16406a = false;
            lineChart.getAxisLeft().h(6, false);
            lineChart.getAxisLeft().e = -1;
            lineChart.getAxisLeft().J = YAxis$YAxisLabelPosition.OUTSIDE_CHART;
            lineChart.getAxisLeft().B = 35.0f;
            lineChart.setNoDataText(getString(R$string.str_no_data));
            lineChart.setNoDataTextColor(-1);
            lineChart.getLegend().f16406a = false;
            lineChart.d(800);
            lineChart.invalidate();
        }
        if (q0() == 0) {
            f3 f3Var4 = (f3) this.f7251b;
            DataView dataView = f3Var4 != null ? f3Var4.e : null;
            if (dataView != null) {
                dataView.setVisibility(0);
            }
            f3 f3Var5 = (f3) this.f7251b;
            View view = f3Var5 != null ? f3Var5.f12880c : null;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            f3 f3Var6 = (f3) this.f7251b;
            DataView dataView2 = f3Var6 != null ? f3Var6.e : null;
            if (dataView2 != null) {
                dataView2.setVisibility(8);
            }
            f3 f3Var7 = (f3) this.f7251b;
            View view2 = f3Var7 != null ? f3Var7.f12880c : null;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        User d5 = kVar != null ? kVar.d() : null;
        if (d5 != null) {
            if (d5.getTempUnit() == 0) {
                f3 f3Var8 = (f3) this.f7251b;
                if (f3Var8 != null) {
                    f3Var8.f12889m.setValue("36.0-37.0℃");
                }
                f3 f3Var9 = (f3) this.f7251b;
                if (f3Var9 != null) {
                    f3Var9.f12890n.setValue("37.1-38℃");
                }
                f3 f3Var10 = (f3) this.f7251b;
                if (f3Var10 != null) {
                    f3Var10.f12888l.setValue("38.1-39℃");
                }
                f3 f3Var11 = (f3) this.f7251b;
                if (f3Var11 != null) {
                    f3Var11.f12885i.setValue("39.1-41℃");
                    return;
                }
                return;
            }
            f3 f3Var12 = (f3) this.f7251b;
            if (f3Var12 != null) {
                float f2 = 10;
                f3Var12.f12889m.setValue(String.format(Locale.ENGLISH, "%.1f-%.1f℉", Arrays.copyOf(new Object[]{Float.valueOf(((int) (v1.a(36.0f) * f2)) / 10.0f), Float.valueOf(((int) (v1.a(37.0f) * f2)) / 10.0f)}, 2)));
            }
            f3 f3Var13 = (f3) this.f7251b;
            if (f3Var13 != null) {
                float f10 = 10;
                f3Var13.f12890n.setValue(String.format(Locale.ENGLISH, "%.1f-%.1f℉", Arrays.copyOf(new Object[]{Float.valueOf(((int) (v1.a(37.1f) * f10)) / 10.0f), Float.valueOf(((int) (v1.a(38.0f) * f10)) / 10.0f)}, 2)));
            }
            f3 f3Var14 = (f3) this.f7251b;
            if (f3Var14 != null) {
                float f11 = 10;
                f3Var14.f12888l.setValue(String.format(Locale.ENGLISH, "%.1f-%.1f℉", Arrays.copyOf(new Object[]{Float.valueOf(((int) (v1.a(38.1f) * f11)) / 10.0f), Float.valueOf(((int) (v1.a(39.0f) * f11)) / 10.0f)}, 2)));
            }
            f3 f3Var15 = (f3) this.f7251b;
            if (f3Var15 != null) {
                float f12 = 10;
                f3Var15.f12885i.setValue(String.format(Locale.ENGLISH, "%.1f-%.1f℉", Arrays.copyOf(new Object[]{Float.valueOf(((int) (v1.a(39.1f) * f12)) / 10.0f), Float.valueOf(((int) (v1.a(41.0f) * f12)) / 10.0f)}, 2)));
            }
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncEvent(EventBusBeans.SyncEvent syncEvent) {
        kotlin.jvm.internal.e.f(syncEvent, "syncEvent");
        f3 f3Var = (f3) this.f7251b;
        if (f3Var != null && f3Var.f12892p.d() && syncEvent.getSyncType() == 5) {
            Calendar calendar = Calendar.getInstance();
            int q02 = q0();
            String str = null;
            if (q02 == 0) {
                long timeInMillis = calendar.getTimeInMillis();
                try {
                    str = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
                } catch (Exception e) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                }
                if (str != null) {
                    ((com.example.test.presenter.main.h) X()).k(str);
                    return;
                }
                return;
            }
            if (q02 == 1) {
                Date time = calendar.getTime();
                kotlin.jvm.internal.e.e(time, "getTime(...)");
                Locale locale = Locale.ENGLISH;
                Date v6 = android.support.v4.media.session.e.v(Calendar.getInstance(locale), time, 7, 7, "getTime(...)");
                Date time2 = calendar.getTime();
                kotlin.jvm.internal.e.e(time2, "getTime(...)");
                Calendar calendar2 = Calendar.getInstance(locale);
                calendar2.setTime(time2);
                calendar2.set(7, calendar2.getActualMaximum(7));
                Date time3 = calendar2.getTime();
                kotlin.jvm.internal.e.e(time3, "getTime(...)");
                String j4 = ca.j(v6.getTime());
                String j10 = ca.j(time3.getTime());
                if (j4 == null || j10 == null) {
                    return;
                }
                ((com.example.test.presenter.main.h) X()).m(j4, j10);
                return;
            }
            if (q02 == 2) {
                long timeInMillis2 = calendar.getTimeInMillis();
                try {
                    str = new SimpleDateFormat("yyyy/MM", Locale.ENGLISH).format(Long.valueOf(timeInMillis2));
                } catch (Exception e10) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis2, " date translate error ", e10.getMessage()));
                }
                if (str != null) {
                    ((com.example.test.presenter.main.h) X()).l(str);
                    return;
                }
                return;
            }
            if (q02 != 3) {
                return;
            }
            long timeInMillis3 = calendar.getTimeInMillis();
            try {
                str = new SimpleDateFormat("yyyy", Locale.ENGLISH).format(Long.valueOf(timeInMillis3));
            } catch (Exception e11) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis3, " date translate error ", e11.getMessage()));
            }
            if (str != null) {
                ((com.example.test.presenter.main.h) X()).n(str);
            }
        }
    }

    public final int q0() {
        return ((Number) this.f8039c.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u0(TempChartData tempChartData) {
        String format;
        String format2;
        String format3;
        String format4;
        f3 f3Var;
        f3 f3Var2;
        Entry entry;
        Object obj;
        Entry entry2;
        Object obj2;
        Entry entry3;
        Object obj3;
        if (q0() == 0) {
            List<Entry> items = tempChartData.getItems();
            if (items != null) {
                Iterator<T> it = items.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj3 = null;
                        break;
                    } else {
                        obj3 = it.next();
                        if (((Entry) obj3).d() > 0.0f) {
                            break;
                        }
                    }
                }
                entry3 = (Entry) obj3;
            } else {
                entry3 = null;
            }
            List<Entry> items2 = tempChartData.getItems();
            if (items2 == null || items2.isEmpty() || entry3 == null) {
                f3 f3Var3 = (f3) this.f7251b;
                LinearLayout linearLayout = f3Var3 != null ? f3Var3.f12887k : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            } else {
                f3 f3Var4 = (f3) this.f7251b;
                LinearLayout linearLayout2 = f3Var4 != null ? f3Var4.f12887k : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
            }
        }
        f3 f3Var5 = (f3) this.f7251b;
        if (f3Var5 != null) {
            LineChart lineChart = f3Var5.f12879b;
            if (lineChart.getData() == 0 || ((o7.j) lineChart.getData()).c() <= 0) {
                List<Entry> items3 = tempChartData.getItems();
                if (items3 != null) {
                    Iterator<T> it2 = items3.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        } else {
                            obj = it2.next();
                            if (((Entry) obj).d() > 0.0f) {
                                break;
                            }
                        }
                    }
                    entry = (Entry) obj;
                } else {
                    entry = null;
                }
                List<Entry> items4 = tempChartData.getItems();
                if (items4 == null || items4.isEmpty() || entry == null) {
                    lineChart.setData(null);
                    lineChart.n();
                } else {
                    o7.k kVar = new o7.k(tempChartData.getItems());
                    kVar.B = LineDataSet$Mode.CUBIC_BEZIER;
                    kVar.G = 0.2f;
                    kVar.A = true;
                    kVar.I = false;
                    kVar.f16824t = android.support.v4.media.session.e.a(kVar, 244, 117, 117);
                    kVar.l(getResources().getColor(R$color.color_94ff4c));
                    kVar.f16837x = getResources().getColor(R$color.color_94ff4c);
                    kVar.f16838y = 60;
                    kVar.f16835v = false;
                    kVar.H = new a(lineChart, 4);
                    o7.j jVar = new o7.j(kVar);
                    jVar.j();
                    jVar.i();
                    lineChart.setData(jVar);
                }
            } else {
                List<Entry> items5 = tempChartData.getItems();
                if (items5 != null) {
                    Iterator<T> it3 = items5.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            obj2 = null;
                            break;
                        } else {
                            obj2 = it3.next();
                            if (((Entry) obj2).d() > 0.0f) {
                                break;
                            }
                        }
                    }
                    entry2 = (Entry) obj2;
                } else {
                    entry2 = null;
                }
                List<Entry> items6 = tempChartData.getItems();
                if (items6 == null || items6.isEmpty() || entry2 == null) {
                    lineChart.setData(null);
                } else {
                    o7.d b3 = ((o7.j) lineChart.getData()).b(0);
                    kotlin.jvm.internal.e.d(b3, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
                    ((o7.k) b3).m(tempChartData.getItems());
                    ((o7.j) lineChart.getData()).a();
                }
                lineChart.n();
            }
            lineChart.invalidate();
        }
        String str = "℃";
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        User d5 = kVar2 != null ? kVar2.d() : null;
        if (d5 != null && d5.getTempUnit() == 1) {
            str = "℉";
        }
        if (tempChartData.getCurrentTemp() == 0.0f) {
            format = "-- " + ((Object) str);
        } else {
            format = String.format(Locale.ENGLISH, "%.1f%s", Arrays.copyOf(new Object[]{Float.valueOf(((int) (tempChartData.getCurrentTemp() * 10)) / 10.0f), str}, 2));
        }
        if (tempChartData.getMaxTemp() == 0.0f) {
            format2 = "-- " + ((Object) str);
        } else {
            format2 = String.format(Locale.ENGLISH, "%.1f%s", Arrays.copyOf(new Object[]{Float.valueOf(((int) (tempChartData.getMaxTemp() * 10)) / 10.0f), str}, 2));
        }
        if (tempChartData.getMinTemp() == 0.0f) {
            format3 = "-- " + ((Object) str);
        } else {
            format3 = String.format(Locale.ENGLISH, "%.1f%s", Arrays.copyOf(new Object[]{Float.valueOf(((int) (tempChartData.getMinTemp() * 10)) / 10.0f), str}, 2));
        }
        if (tempChartData.getAvgTemp() == 0.0f) {
            format4 = "-- " + ((Object) str);
        } else {
            format4 = String.format(Locale.ENGLISH, "%.1f%s", Arrays.copyOf(new Object[]{Float.valueOf(((int) (tempChartData.getAvgTemp() * 10)) / 10.0f), str}, 2));
        }
        f3 f3Var6 = (f3) this.f7251b;
        if (f3Var6 != null) {
            f3Var6.e.setValue(format);
        }
        f3 f3Var7 = (f3) this.f7251b;
        if (f3Var7 != null) {
            f3Var7.f12881d.setValue(format4);
        }
        f3 f3Var8 = (f3) this.f7251b;
        if (f3Var8 != null) {
            f3Var8.f12882f.setValue(format2);
        }
        f3 f3Var9 = (f3) this.f7251b;
        if (f3Var9 != null) {
            f3Var9.f12883g.setValue(format3);
        }
        if (q0() == 0) {
            f3 f3Var10 = (f3) this.f7251b;
            TextView textView = f3Var10 != null ? f3Var10.f12891o : null;
            if (textView != null) {
                textView.setText("00:00");
            }
            f3 f3Var11 = (f3) this.f7251b;
            TextView textView2 = f3Var11 != null ? f3Var11.f12884h : null;
            if (textView2 != null) {
                textView2.setText("24:00");
            }
            String startTime = tempChartData.getStartTime();
            if (startTime != null && (f3Var2 = (f3) this.f7251b) != null) {
                f3Var2.f12891o.setText(startTime);
            }
            String endTime = tempChartData.getEndTime();
            if (endTime == null || (f3Var = (f3) this.f7251b) == null) {
                return;
            }
            f3Var.f12884h.setText(endTime);
        }
    }

    @Override // t7.d
    public final void x(Entry entry) {
    }
}
