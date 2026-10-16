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
import com.example.test.presenter.main.x0;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.chart.chart.HrChartData;
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
import f6.l3;
import g7.q;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class HRStatisticsFragment extends BaseFragment<x0, l3> implements q, t7.d {

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f8069c = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.HRStatisticsFragment$statisticsType$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Bundle arguments = HRStatisticsFragment.this.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("statistics_type") : 0);
        }
    });

    public HRStatisticsFragment() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.HRStatisticsFragment$maxBarCount$2
            {
                super(0);
            }

            @Override // oh.a
            public final Integer invoke() {
                int q02 = HRStatisticsFragment.this.q0();
                int i3 = 50;
                if (q02 != 0) {
                    if (q02 == 1) {
                        i3 = 7;
                    } else if (q02 == 2) {
                        i3 = Calendar.getInstance().getActualMaximum(5);
                    } else if (q02 == 3) {
                        i3 = 12;
                    }
                }
                return Integer.valueOf(i3);
            }
        });
    }

    @Override // t7.d
    public final void A() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F(HrChartData hrChartData) {
        l3 l3Var;
        l3 l3Var2;
        Entry entry;
        Object obj;
        Entry entry2;
        Object obj2;
        Entry entry3;
        Object obj3;
        if (q0() == 0) {
            List<Entry> items = hrChartData.getItems();
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
            List<Entry> items2 = hrChartData.getItems();
            if (items2 == null || items2.isEmpty() || entry3 == null) {
                l3 l3Var3 = (l3) this.f7251b;
                LinearLayout linearLayout = l3Var3 != null ? l3Var3.f13107j : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            } else {
                l3 l3Var4 = (l3) this.f7251b;
                LinearLayout linearLayout2 = l3Var4 != null ? l3Var4.f13107j : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
            }
        }
        l3 l3Var5 = (l3) this.f7251b;
        if (l3Var5 != null) {
            LineChart lineChart = l3Var5.f13100b;
            if (lineChart.getData() == 0 || ((o7.j) lineChart.getData()).c() <= 0) {
                List<Entry> items3 = hrChartData.getItems();
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
                List<Entry> items4 = hrChartData.getItems();
                if (items4 == null || items4.isEmpty() || entry == null) {
                    lineChart.setData(null);
                    lineChart.n();
                } else {
                    o7.k kVar = new o7.k(hrChartData.getItems());
                    kVar.B = LineDataSet$Mode.CUBIC_BEZIER;
                    kVar.G = 0.2f;
                    kVar.A = true;
                    kVar.I = false;
                    kVar.f16824t = android.support.v4.media.session.e.a(kVar, 244, 117, 117);
                    kVar.l(getResources().getColor(R$color.color_dc2641));
                    kVar.f16837x = getResources().getColor(R$color.color_dc2641);
                    kVar.f16838y = 60;
                    kVar.f16835v = false;
                    kVar.H = new a(lineChart, 5);
                    o7.j jVar = new o7.j(kVar);
                    jVar.j();
                    jVar.i();
                    lineChart.setData(jVar);
                }
            } else {
                o7.d b3 = ((o7.j) lineChart.getData()).b(0);
                kotlin.jvm.internal.e.d(b3, "null cannot be cast to non-null type com.github.mikephil.charting.data.LineDataSet");
                o7.k kVar2 = (o7.k) b3;
                List<Entry> items5 = hrChartData.getItems();
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
                List<Entry> items6 = hrChartData.getItems();
                if (items6 == null || items6.isEmpty() || entry2 == null) {
                    ((o7.j) lineChart.getData()).h(kVar2);
                    lineChart.setData(null);
                } else {
                    kVar2.m(hrChartData.getItems());
                    ((o7.j) lineChart.getData()).a();
                }
                lineChart.n();
            }
            lineChart.invalidate();
        }
        String valueOf = hrChartData.getCurrentHr() == 0 ? "--" : String.valueOf(hrChartData.getCurrentHr());
        String valueOf2 = hrChartData.getMaxHr() == 0 ? "--" : String.valueOf(hrChartData.getMaxHr());
        String valueOf3 = hrChartData.getMinHr() == 0 ? "--" : String.valueOf(hrChartData.getMinHr());
        String valueOf4 = hrChartData.getAvgHr() != 0 ? String.valueOf(hrChartData.getAvgHr()) : "--";
        l3 l3Var6 = (l3) this.f7251b;
        if (l3Var6 != null) {
            l3Var6.e.setValue(valueOf + " bpm");
        }
        l3 l3Var7 = (l3) this.f7251b;
        if (l3Var7 != null) {
            l3Var7.f13103f.setValue(valueOf2 + " bpm");
        }
        l3 l3Var8 = (l3) this.f7251b;
        if (l3Var8 != null) {
            l3Var8.f13104g.setValue(valueOf3 + " bpm");
        }
        l3 l3Var9 = (l3) this.f7251b;
        if (l3Var9 != null) {
            l3Var9.f13102d.setValue(valueOf4 + " bpm");
        }
        if (q0() == 0) {
            l3 l3Var10 = (l3) this.f7251b;
            TextView textView = l3Var10 != null ? l3Var10.f13108k : null;
            if (textView != null) {
                textView.setText("00:00");
            }
            l3 l3Var11 = (l3) this.f7251b;
            TextView textView2 = l3Var11 != null ? l3Var11.f13105h : null;
            if (textView2 != null) {
                textView2.setText("24:00");
            }
            String startTime = hrChartData.getStartTime();
            if (startTime != null && (l3Var2 = (l3) this.f7251b) != null) {
                l3Var2.f13108k.setText(startTime);
            }
            String endTime = hrChartData.getEndTime();
            if (endTime == null || (l3Var = (l3) this.f7251b) == null) {
                return;
            }
            l3Var.f13105h.setText(endTime);
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new x0(this);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        l3 l3Var = (l3) this.f7251b;
        if (l3Var != null) {
            return l3Var.f13099a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View a3;
        View a10;
        View inflate = layoutInflater.inflate(R$layout.fragment_hr_statistics, viewGroup, false);
        int i3 = R$id.chart1;
        LineChart lineChart = (LineChart) he.a(i3, inflate);
        if (lineChart != null && (a3 = he.a((i3 = R$id.current_line), inflate)) != null) {
            i3 = R$id.dv_avg_hr;
            DataView dataView = (DataView) he.a(i3, inflate);
            if (dataView != null) {
                i3 = R$id.dv_current_hr;
                DataView dataView2 = (DataView) he.a(i3, inflate);
                if (dataView2 != null) {
                    i3 = R$id.dv_max_hr;
                    DataView dataView3 = (DataView) he.a(i3, inflate);
                    if (dataView3 != null) {
                        i3 = R$id.dv_min_hr;
                        DataView dataView4 = (DataView) he.a(i3, inflate);
                        if (dataView4 != null) {
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
                                            return new l3((NestedScrollView) inflate, lineChart, a3, dataView, dataView2, dataView3, dataView4, textView, a10, linearLayout, textView2, dateSelectView);
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
        l3 l3Var = (l3) this.f7251b;
        if (l3Var != null) {
            DateSelectView dateSelectView = l3Var.f13109l;
            dateSelectView.setDateModel(q0());
            dateSelectView.setOnDateSelectedListener(new n(this, 6));
            dateSelectView.c();
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        View view;
        b2.a(this);
        l3 l3Var = (l3) this.f7251b;
        if (l3Var != null) {
            LineChart lineChart = l3Var.f13100b;
            lineChart.setOnChartValueSelectedListener(this);
            lineChart.setDrawGridBackground(false);
            lineChart.getDescription().f16406a = false;
            lineChart.setTouchEnabled(true);
            lineChart.setDragEnabled(true);
            lineChart.setScaleEnabled(false);
            lineChart.setPinchZoom(false);
            MyMarkerView myMarkerView = new MyMarkerView(f0(), R$layout.custom_marker_view);
            l3 l3Var2 = (l3) this.f7251b;
            myMarkerView.setChartView(l3Var2 != null ? l3Var2.f13100b : null);
            lineChart.setMarker(myMarkerView);
            lineChart.getXAxis().I = XAxis$XAxisPosition.BOTTOM;
            lineChart.getXAxis().g();
            lineChart.getXAxis().e = -1;
            int q02 = q0();
            if (q02 == 0) {
                l3 l3Var3 = (l3) this.f7251b;
                LinearLayout linearLayout = l3Var3 != null ? l3Var3.f13107j : null;
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
            l3 l3Var4 = (l3) this.f7251b;
            DataView dataView = l3Var4 != null ? l3Var4.e : null;
            if (dataView != null) {
                dataView.setVisibility(0);
            }
            l3 l3Var5 = (l3) this.f7251b;
            view = l3Var5 != null ? l3Var5.f13101c : null;
            if (view == null) {
                return;
            }
            view.setVisibility(0);
            return;
        }
        l3 l3Var6 = (l3) this.f7251b;
        DataView dataView2 = l3Var6 != null ? l3Var6.e : null;
        if (dataView2 != null) {
            dataView2.setVisibility(8);
        }
        l3 l3Var7 = (l3) this.f7251b;
        view = l3Var7 != null ? l3Var7.f13101c : null;
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
        l3 l3Var = (l3) this.f7251b;
        if (l3Var != null && l3Var.f13109l.d() && syncEvent.getSyncType() == 1) {
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
                    ((x0) X()).k(str);
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
                ((x0) X()).m(j4, j10);
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
                    ((x0) X()).l(str);
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
                ((x0) X()).n(str);
            }
        }
    }

    public final int q0() {
        return ((Number) this.f8069c.getValue()).intValue();
    }

    @Override // t7.d
    public final void x(Entry entry) {
    }
}
