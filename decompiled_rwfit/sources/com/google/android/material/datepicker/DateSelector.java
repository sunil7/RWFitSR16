package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* loaded from: classes.dex */
public interface DateSelector<S> extends Parcelable {
    boolean A();

    ArrayList F();

    Object I();

    void O(long j4);

    View c(LayoutInflater layoutInflater, ViewGroup viewGroup, CalendarConstraints calendarConstraints, r rVar);

    String e(Context context);

    int f(Context context);

    ArrayList y();
}
