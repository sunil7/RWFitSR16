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
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.BpChartData;
import com.example.test.ui.model.chart.formatter.DayFormatter;
import com.example.test.ui.model.chart.formatter.MonthFormatter;
import com.example.test.ui.model.chart.formatter.WeekFormatter;
import com.example.test.ui.model.chart.formatter.YearFormatter;
import com.example.test.ui.view.DataView;
import com.example.test.ui.view.DateSelectView;
import com.example.test.ui.view.MyMarkerView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import com.github.mikephil.charting.components.YAxis$YAxisLabelPosition;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet$Mode;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.b3;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class BPStatisticsFragment extends BaseFragment<com.example.test.presenter.main.c, b3> implements g7.c, t7.d {

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f8037c = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.BPStatisticsFragment$statisticsType$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Bundle arguments = BPStatisticsFragment.this.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("statistics_type") : 0);
        }
    });

    @Override // t7.d
    public final void A() {
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new com.example.test.presenter.main.c(this);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        b3 b3Var = (b3) this.f7251b;
        if (b3Var != null) {
            return b3Var.f12732a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View a3;
        View a10;
        View inflate = layoutInflater.inflate(R$layout.fragment_bp_statistics, viewGroup, false);
        int i3 = R$id.chart1;
        LineChart lineChart = (LineChart) he.a(i3, inflate);
        if (lineChart != null && (a3 = he.a((i3 = R$id.current_line), inflate)) != null) {
            i3 = R$id.dv_avg_dp;
            DataView dataView = (DataView) he.a(i3, inflate);
            if (dataView != null) {
                i3 = R$id.dv_current_bp;
                DataView dataView2 = (DataView) he.a(i3, inflate);
                if (dataView2 != null) {
                    i3 = R$id.dv_max_bp_dp;
                    DataView dataView3 = (DataView) he.a(i3, inflate);
                    if (dataView3 != null) {
                        i3 = R$id.dv_max_bp_sp;
                        DataView dataView4 = (DataView) he.a(i3, inflate);
                        if (dataView4 != null) {
                            i3 = R$id.dv_min_bp_dp;
                            DataView dataView5 = (DataView) he.a(i3, inflate);
                            if (dataView5 != null) {
                                i3 = R$id.dv_min_bp_sp;
                                DataView dataView6 = (DataView) he.a(i3, inflate);
                                if (dataView6 != null) {
                                    i3 = R$id.end_time;
                                    TextView textView = (TextView) he.a(i3, inflate);
                                    if (textView != null && (a10 = he.a((i3 = R$id.line_sleep), inflate)) != null) {
                                        i3 = R$id.ll_time;
                                        LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
                                        if (linearLayout != null) {
                                            i3 = R$id.start_time;
                                            TextView textView2 = (TextView) he.a(i3, inflate);
                                            if (textView2 != null) {
                                                i3 = R$id.view_date_select;
                                                DateSelectView dateSelectView = (DateSelectView) he.a(i3, inflate);
                                                if (dateSelectView != null) {
                                                    return new b3((NestedScrollView) inflate, lineChart, a3, dataView, dataView2, dataView3, dataView4, dataView5, dataView6, textView, a10, linearLayout, textView2, dateSelectView);
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
        b3 b3Var = (b3) this.f7251b;
        if (b3Var != null) {
            DateSelectView dateSelectView = b3Var.f12744n;
            dateSelectView.setDateModel(q0());
            dateSelectView.setOnDateSelectedListener(new n(this, 2));
            dateSelectView.c();
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        View view;
        b2.a(this);
        b3 b3Var = (b3) this.f7251b;
        if (b3Var != null) {
            LineChart lineChart = b3Var.f12733b;
            lineChart.setOnChartValueSelectedListener(this);
            lineChart.setDrawGridBackground(false);
            lineChart.getDescription().f16406a = false;
            lineChart.setTouchEnabled(true);
            lineChart.setDragEnabled(true);
            lineChart.setScaleEnabled(false);
            lineChart.setPinchZoom(false);
            MyMarkerView myMarkerView = new MyMarkerView(f0(), R$layout.custom_marker_view);
            b3 b3Var2 = (b3) this.f7251b;
            myMarkerView.setChartView(b3Var2 != null ? b3Var2.f12733b : null);
            lineChart.setMarker(myMarkerView);
            lineChart.getXAxis().H = true;
            lineChart.getXAxis().I = XAxis$XAxisPosition.BOTTOM;
            lineChart.getXAxis().e = -1;
            lineChart.getXAxis().f(0.0f);
            int q02 = q0();
            if (q02 == 0) {
                b3 b3Var3 = (b3) this.f7251b;
                LinearLayout linearLayout = b3Var3 != null ? b3Var3.f12742l : null;
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
            lineChart.getAxisLeft().B = 30.0f;
            lineChart.setNoDataText(getString(R$string.str_no_data));
            lineChart.setNoDataTextColor(-1);
            lineChart.getLegend().f16406a = false;
            lineChart.d(1000);
            lineChart.invalidate();
        }
        if (q0() == 0) {
            b3 b3Var4 = (b3) this.f7251b;
            DataView dataView = b3Var4 != null ? b3Var4.e : null;
            if (dataView != null) {
                dataView.setVisibility(0);
            }
            b3 b3Var5 = (b3) this.f7251b;
            view = b3Var5 != null ? b3Var5.f12734c : null;
            if (view == null) {
                return;
            }
            view.setVisibility(0);
            return;
        }
        b3 b3Var6 = (b3) this.f7251b;
        DataView dataView2 = b3Var6 != null ? b3Var6.e : null;
        if (dataView2 != null) {
            dataView2.setVisibility(8);
        }
        b3 b3Var7 = (b3) this.f7251b;
        view = b3Var7 != null ? b3Var7.f12734c : null;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncEvent(EventBusBeans.SyncEvent syncEvent) {
        kotlin.jvm.internal.e.f(syncEvent, "syncEvent");
        b3 b3Var = (b3) this.f7251b;
        if (b3Var != null && b3Var.f12744n.d() && syncEvent.getSyncType() == 2) {
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
                    ((com.example.test.presenter.main.c) X()).k(str);
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
                ((com.example.test.presenter.main.c) X()).m(j4, j10);
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
                    ((com.example.test.presenter.main.c) X()).l(str);
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
                ((com.example.test.presenter.main.c) X()).n(str);
            }
        }
    }

    public final int q0() {
        return ((Number) this.f8037c.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u0(BpChartData bpChartData) {
        String str;
        b3 b3Var;
        b3 b3Var2;
        Entry entry;
        Entry entry2;
        List<Entry> itemSps;
        Object obj;
        Object obj2;
        Entry entry3;
        Entry entry4;
        List<Entry> itemSps2;
        Object obj3;
        Object obj4;
        Entry entry5;
        Entry entry6;
        List<Entry> itemSps3;
        Object obj5;
        Object obj6;
        if (q0() == 0) {
            List<Entry> itemDps = bpChartData.getItemDps();
            if (itemDps != null) {
                Iterator<T> it = itemDps.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj6 = null;
                        break;
                    } else {
                        obj6 = it.next();
                        if (((Entry) obj6).d() > 0.0f) {
                            break;
                        }
                    }
                }
                entry5 = (Entry) obj6;
            } else {
                entry5 = null;
            }
            List<Entry> itemSps4 = bpChartData.getItemSps();
            if (itemSps4 != null) {
                Iterator<T> it2 = itemSps4.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj5 = null;
                        break;
                    } else {
                        obj5 = it2.next();
                        if (((Entry) obj5).d() > 0.0f) {
                            break;
                        }
                    }
                }
                entry6 = (Entry) obj5;
            } else {
                entry6 = null;
            }
            List<Entry> itemDps2 = bpChartData.getItemDps();
            if (itemDps2 == null || itemDps2.isEmpty() || (itemSps3 = bpChartData.getItemSps()) == null || itemSps3.isEmpty() || entry5 == null || entry6 == null) {
                b3 b3Var3 = (b3) this.f7251b;
                LinearLayout linearLayout = b3Var3 != null ? b3Var3.f12742l : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            } else {
                b3 b3Var4 = (b3) this.f7251b;
                LinearLayout linearLayout2 = b3Var4 != null ? b3Var4.f12742l : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
            }
        }
        b3 b3Var5 = (b3) this.f7251b;
        if (b3Var5 != null) {
            LineChart lineChart = b3Var5.f12733b;
            if (lineChart.getData() == 0 || ((o7.j) lineChart.getData()).c() <= 0) {
                List<Entry> itemDps3 = bpChartData.getItemDps();
                if (itemDps3 != null) {
                    Iterator<T> it3 = itemDps3.iterator();
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
                    entry = (Entry) obj2;
                } else {
                    entry = null;
                }
                List<Entry> itemSps5 = bpChartData.getItemSps();
                if (itemSps5 != null) {
                    Iterator<T> it4 = itemSps5.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            obj = null;
                            break;
                        } else {
                            obj = it4.next();
                            if (((Entry) obj).d() > 0.0f) {
                                break;
                            }
                        }
                    }
                    entry2 = (Entry) obj;
                } else {
                    entry2 = null;
                }
                List<Entry> itemDps4 = bpChartData.getItemDps();
                if (itemDps4 == null || itemDps4.isEmpty() || (itemSps = bpChartData.getItemSps()) == null || itemSps.isEmpty() || entry == null || entry2 == null) {
                    lineChart.setData(null);
                    lineChart.n();
                } else {
                    o7.k kVar = new o7.k(bpChartData.getItemSps());
                    LineDataSet$Mode lineDataSet$Mode = LineDataSet$Mode.CUBIC_BEZIER;
                    kVar.B = lineDataSet$Mode;
                    kVar.G = 0.2f;
                    kVar.A = true;
                    kVar.I = false;
                    kVar.f16824t = android.support.v4.media.session.e.a(kVar, 244, 117, 117);
                    kVar.l(getResources().getColor(R$color.color_d90fd2));
                    kVar.f16837x = getResources().getColor(R$color.color_d90fd2);
                    kVar.f16838y = 60;
                    kVar.f16835v = false;
                    kVar.H = new a(lineChart, 1);
                    o7.k kVar2 = new o7.k(bpChartData.getItemDps());
                    kVar2.B = lineDataSet$Mode;
                    kVar2.G = 0.2f;
                    kVar2.A = true;
                    kVar2.I = false;
                    kVar2.f16824t = android.support.v4.media.session.e.a(kVar2, 244, 117, 117);
                    kVar2.l(getResources().getColor(R$color.color_29b7cb));
                    kVar2.f16837x = getResources().getColor(R$color.color_29b7cb);
                    kVar2.f16838y = 60;
                    kVar2.f16835v = false;
                    kVar2.H = new a(lineChart, 2);
                    o7.j jVar = new o7.j(kVar, kVar2);
                    jVar.j();
                    jVar.i();
                    lineChart.setData(jVar);
                }
            } else {
                List<Entry> itemDps5 = bpChartData.getItemDps();
                if (itemDps5 != null) {
                    Iterator<T> it5 = itemDps5.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            obj4 = null;
                            break;
                        } else {
                            obj4 = it5.next();
                            if (((Entry) obj4).d() > 0.0f) {
                                break;
                            }
                        }
                    }
                    entry3 = (Entry) obj4;
                } else {
                    entry3 = null;
                }
                List<Entry> itemSps6 = bpChartData.getItemSps();
                if (itemSps6 != null) {
                    Iterator<T> it6 = itemSps6.iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            obj3 = null;
                            break;
                        } else {
                            obj3 = it6.next();
                            if (((Entry) obj3).d() > 0.0f) {
                                break;
                            }
                        }
                    }
                    entry4 = (Entry) obj3;
                } else {
                    entry4 = null;
                }
                List<Entry> itemDps6 = bpChartData.getItemDps();
                if (itemDps6 == null || itemDps6.isEmpty() || (itemSps2 = bpChartData.getItemSps()) == null || itemSps2.isEmpty() || entry3 == null || entry4 == null) {
                    lineChart.setData(null);
                } else {
                    o7.d b3 = ((o7.j) lineChart.getData()).b(0);
                    kotlin.jvm.internal.e.d(b3, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
                    ((o7.k) b3).m(bpChartData.getItemSps());
                    o7.d b10 = ((o7.j) lineChart.getData()).b(1);
                    kotlin.jvm.internal.e.d(b10, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
                    ((o7.k) b10).m(bpChartData.getItemDps());
                    ((o7.j) lineChart.getData()).a();
                }
                lineChart.n();
            }
            lineChart.invalidate();
        }
        String str2 = "-- / --";
        if (bpChartData.getCurrentSp() == 0) {
            str = "-- / --";
        } else {
            str = bpChartData.getCurrentSp() + "/" + bpChartData.getCurrentDp();
        }
        if (bpChartData.getAvgSp() != 0) {
            str2 = bpChartData.getAvgSp() + "/" + bpChartData.getAvgDp();
        }
        String valueOf = bpChartData.getMaxSp() == 0 ? "--" : String.valueOf(bpChartData.getMaxSp());
        String valueOf2 = bpChartData.getMinSp() == 0 ? "--" : String.valueOf(bpChartData.getMinSp());
        String valueOf3 = bpChartData.getMaxDp() == 0 ? "--" : String.valueOf(bpChartData.getMaxDp());
        String valueOf4 = bpChartData.getMinDp() != 0 ? String.valueOf(bpChartData.getMinDp()) : "--";
        b3 b3Var6 = (b3) this.f7251b;
        if (b3Var6 != null) {
            b3Var6.e.setValue(str + " mmHg");
        }
        b3 b3Var7 = (b3) this.f7251b;
        if (b3Var7 != null) {
            b3Var7.f12735d.setValue(str2 + " mmHg");
        }
        b3 b3Var8 = (b3) this.f7251b;
        if (b3Var8 != null) {
            b3Var8.f12737g.setValue(valueOf + " mmHg");
        }
        b3 b3Var9 = (b3) this.f7251b;
        if (b3Var9 != null) {
            b3Var9.f12739i.setValue(valueOf2 + " mmHg");
        }
        b3 b3Var10 = (b3) this.f7251b;
        if (b3Var10 != null) {
            b3Var10.f12736f.setValue(valueOf3 + " mmHg");
        }
        b3 b3Var11 = (b3) this.f7251b;
        if (b3Var11 != null) {
            b3Var11.f12738h.setValue(valueOf4 + " mmHg");
        }
        if (q0() == 0) {
            b3 b3Var12 = (b3) this.f7251b;
            TextView textView = b3Var12 != null ? b3Var12.f12743m : null;
            if (textView != null) {
                textView.setText("00:00");
            }
            b3 b3Var13 = (b3) this.f7251b;
            TextView textView2 = b3Var13 != null ? b3Var13.f12740j : null;
            if (textView2 != null) {
                textView2.setText("24:00");
            }
            String startTime = bpChartData.getStartTime();
            if (startTime != null && (b3Var2 = (b3) this.f7251b) != null) {
                b3Var2.f12743m.setText(startTime);
            }
            String endTime = bpChartData.getEndTime();
            if (endTime == null || (b3Var = (b3) this.f7251b) == null) {
                return;
            }
            b3Var.f12740j.setText(endTime);
        }
    }

    @Override // t7.d
    public final void x(Entry entry) {
    }
}
