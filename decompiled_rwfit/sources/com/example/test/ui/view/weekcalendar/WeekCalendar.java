package com.example.test.ui.view.weekcalendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.appcompat.widget.p2;
import androidx.viewpager.widget.ViewPager;
import c7.b;
import com.example.test.R$dimen;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$styleable;
import d7.a;
import d7.c;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/* loaded from: classes.dex */
public class WeekCalendar extends LinearLayout {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f8709j = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f8710a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8711b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8712c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8713d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f8714f;

    /* renamed from: g, reason: collision with root package name */
    public GridView f8715g;

    /* renamed from: h, reason: collision with root package name */
    public ViewPager f8716h;

    /* renamed from: i, reason: collision with root package name */
    public b f8717i;

    public WeekCalendar(Context context) {
        this(context, null);
    }

    public DateTime getCurrentFirstDay() {
        return this.f8717i.f3398g.plusWeeks(this.f8716h.getCurrentItem() - this.f8711b);
    }

    public DateTime getSelectDateTime() {
        return this.f8717i.f3399h;
    }

    public void setDateSelectListener(a aVar) {
        this.f8717i.getClass();
    }

    public void setGetViewHelper(d7.b bVar) {
        setOrientation(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_calender_header, (ViewGroup) this, false);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f8712c));
        inflate.setBackgroundColor(this.f8713d);
        this.f8715g = (GridView) inflate.findViewById(R$id.grid_week);
        addView(inflate);
        GridView gridView = this.f8715g;
        p2 p2Var = new p2();
        ArrayList arrayList = new ArrayList(Arrays.asList(DateFormatSymbols.getInstance().getWeekdays()));
        p2Var.f1025b = arrayList;
        arrayList.remove(0);
        gridView.setAdapter((ListAdapter) p2Var);
        inflate.setVisibility(this.f8714f ? 0 : 8);
        View inflate2 = LayoutInflater.from(getContext()).inflate(R$layout.layout_calendar_content, (ViewGroup) this, false);
        inflate2.setLayoutParams(new ViewGroup.LayoutParams(-1, this.e));
        this.f8716h = (ViewPager) inflate2.findViewById(R$id.viewpager_calendar);
        addView(inflate2);
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        b bVar2 = new b(getContext(), this.f8710a, dateTime.minusDays(dateTime.getDayOfWeek() % 7));
        this.f8717i = bVar2;
        this.f8716h.setAdapter(bVar2);
        this.f8716h.setCurrentItem(this.f8711b);
        this.f8716h.addOnPageChangeListener(new b7.a(this, 0));
    }

    public void setSelectDateTime(DateTime dateTime) {
        this.f8717i.f3399h = dateTime;
        ViewPager viewPager = this.f8716h;
        int i3 = this.f8711b;
        viewPager.v(i3, true);
        DateTime minusDays = dateTime.minusDays(dateTime.getDayOfWeek() % 7);
        b bVar = this.f8717i;
        bVar.f3398g = minusDays;
        bVar.h();
        this.f8717i.f3398g.plusWeeks(i3 - this.f8711b);
    }

    public void setWeekChangedListener(c cVar) {
    }

    public WeekCalendar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WeekCalendar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8710a = 1000;
        this.f8711b = 1000 / 2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.WeekCalendar);
        try {
            this.f8712c = (int) obtainStyledAttributes.getDimension(R$styleable.WeekCalendar_wc_headerHeight, getResources().getDimension(R$dimen.calender_header_height));
            this.f8713d = obtainStyledAttributes.getColor(R$styleable.WeekCalendar_wc_headerBgColor, -1);
            this.e = (int) obtainStyledAttributes.getDimension(R$styleable.WeekCalendar_wc_calendarHeight, getResources().getDimension(R$dimen.calender_content_height));
            this.f8714f = obtainStyledAttributes.getBoolean(R$styleable.WeekCalendar_wc_show_week, true);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
