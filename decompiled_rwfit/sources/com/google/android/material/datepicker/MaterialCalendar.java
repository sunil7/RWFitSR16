package com.google.android.material.datepicker;

import android.R;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v0;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButton;
import l1.z0;

/* loaded from: classes.dex */
public final class MaterialCalendar<S> extends z {

    /* renamed from: b, reason: collision with root package name */
    public int f10393b;

    /* renamed from: c, reason: collision with root package name */
    public DateSelector f10394c;

    /* renamed from: d, reason: collision with root package name */
    public CalendarConstraints f10395d;
    public Month e;

    /* renamed from: f, reason: collision with root package name */
    public CalendarSelector f10396f;

    /* renamed from: g, reason: collision with root package name */
    public c f10397g;

    /* renamed from: h, reason: collision with root package name */
    public RecyclerView f10398h;

    /* renamed from: i, reason: collision with root package name */
    public RecyclerView f10399i;

    /* renamed from: j, reason: collision with root package name */
    public View f10400j;

    /* renamed from: k, reason: collision with root package name */
    public View f10401k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class CalendarSelector {
        public static final CalendarSelector DAY;
        public static final CalendarSelector YEAR;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CalendarSelector[] f10402a;

        static {
            CalendarSelector calendarSelector = new CalendarSelector("DAY", 0);
            DAY = calendarSelector;
            CalendarSelector calendarSelector2 = new CalendarSelector("YEAR", 1);
            YEAR = calendarSelector2;
            f10402a = new CalendarSelector[]{calendarSelector, calendarSelector2};
        }

        public static CalendarSelector valueOf(String str) {
            return (CalendarSelector) Enum.valueOf(CalendarSelector.class, str);
        }

        public static CalendarSelector[] values() {
            return (CalendarSelector[]) f10402a.clone();
        }
    }

    @Override // com.google.android.material.datepicker.z
    public final void I(r rVar) {
        this.f10484a.add(rVar);
    }

    public final void W(Month month) {
        y yVar = (y) this.f10399i.getAdapter();
        int n4 = yVar.f10481b.n().n(month);
        int n8 = n4 - yVar.f10481b.n().n(this.e);
        boolean z5 = Math.abs(n8) > 3;
        boolean z6 = n8 > 0;
        this.e = month;
        if (z5 && z6) {
            this.f10399i.g0(n4 - 3);
            this.f10399i.post(new androidx.emoji2.text.i(n4, 2, this));
        } else if (!z5) {
            this.f10399i.post(new androidx.emoji2.text.i(n4, 2, this));
        } else {
            this.f10399i.g0(n4 + 3);
            this.f10399i.post(new androidx.emoji2.text.i(n4, 2, this));
        }
    }

    public final void X(CalendarSelector calendarSelector) {
        this.f10396f = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.f10398h.getLayoutManager().s0(this.e.f10406b - ((h0) this.f10398h.getAdapter()).f10432a.f10395d.n().f10406b);
            this.f10400j.setVisibility(0);
            this.f10401k.setVisibility(8);
            return;
        }
        if (calendarSelector == CalendarSelector.DAY) {
            this.f10400j.setVisibility(8);
            this.f10401k.setVisibility(0);
            W(this.e);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f10393b = bundle.getInt("THEME_RES_ID_KEY");
        this.f10394c = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f10395d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.e = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i3;
        int i10;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f10393b);
        this.f10397g = new c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month n4 = this.f10395d.n();
        if (s.Z(contextThemeWrapper, R.attr.windowFullscreen)) {
            i3 = R$layout.mtrl_calendar_vertical;
            i10 = 1;
        } else {
            i3 = R$layout.mtrl_calendar_horizontal;
            i10 = 0;
        }
        View inflate = cloneInContext.inflate(i3, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R$id.mtrl_calendar_days_of_week);
        z0.n(gridView, new androidx.core.widget.j(1));
        gridView.setAdapter((ListAdapter) new k());
        gridView.setNumColumns(n4.f10407c);
        gridView.setEnabled(false);
        this.f10399i = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_months);
        getContext();
        this.f10399i.setLayoutManager(new l(this, i10, i10));
        this.f10399i.setTag("MONTHS_VIEW_GROUP_TAG");
        y yVar = new y(contextThemeWrapper, this.f10394c, this.f10395d, new m(this));
        this.f10399i.setAdapter(yVar);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.f10398h = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f10398h.setLayoutManager(new GridLayoutManager(integer, 0));
            this.f10398h.setAdapter(new h0(this));
            this.f10398h.g(new n(this));
        }
        if (inflate.findViewById(R$id.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(R$id.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            z0.n(materialButton, new com.google.android.material.button.f(this, 1));
            MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R$id.month_navigation_previous);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(R$id.month_navigation_next);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.f10400j = inflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
            this.f10401k = inflate.findViewById(R$id.mtrl_calendar_day_selector_frame);
            X(CalendarSelector.DAY);
            materialButton.setText(this.e.k(inflate.getContext()));
            this.f10399i.addOnScrollListener(new o(this, yVar, materialButton));
            materialButton.setOnClickListener(new q(this, 3));
            materialButton3.setOnClickListener(new p(this, yVar, 0));
            materialButton2.setOnClickListener(new p(this, yVar, 1));
        }
        if (!s.Z(contextThemeWrapper, R.attr.windowFullscreen)) {
            new v0().a(this.f10399i);
        }
        this.f10399i.g0(yVar.f10481b.n().n(this.e));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f10393b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f10394c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f10395d);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.e);
    }
}
