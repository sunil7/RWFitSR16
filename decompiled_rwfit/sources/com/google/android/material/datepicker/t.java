package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class t<S> extends z {

    /* renamed from: b, reason: collision with root package name */
    public int f10467b;

    /* renamed from: c, reason: collision with root package name */
    public DateSelector f10468c;

    /* renamed from: d, reason: collision with root package name */
    public CalendarConstraints f10469d;

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f10467b = bundle.getInt("THEME_RES_ID_KEY");
        this.f10468c = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f10469d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f10468c.c(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f10467b)), viewGroup, this.f10469d, new r(this, 1));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f10467b);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f10468c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f10469d);
    }
}
