package com.google.android.material.datepicker;

import android.text.TextUtils;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public abstract class j extends com.google.android.material.internal.v {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f10436a;

    /* renamed from: b, reason: collision with root package name */
    public final SimpleDateFormat f10437b;

    /* renamed from: c, reason: collision with root package name */
    public final CalendarConstraints f10438c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10439d;
    public final h e;

    /* renamed from: f, reason: collision with root package name */
    public i f10440f;

    public j(String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f10437b = simpleDateFormat;
        this.f10436a = textInputLayout;
        this.f10438c = calendarConstraints;
        this.f10439d = textInputLayout.getContext().getString(R$string.mtrl_picker_out_of_range);
        this.e = new h(this, str);
    }

    public abstract void a();

    public abstract void b(Long l3);

    @Override // com.google.android.material.internal.v, android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
        CalendarConstraints calendarConstraints = this.f10438c;
        TextInputLayout textInputLayout = this.f10436a;
        h hVar = this.e;
        textInputLayout.removeCallbacks(hVar);
        textInputLayout.removeCallbacks(this.f10440f);
        textInputLayout.setError(null);
        b(null);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        try {
            Date parse = this.f10437b.parse(charSequence.toString());
            textInputLayout.setError(null);
            long time = parse.getTime();
            if (calendarConstraints.j().g(time) && calendarConstraints.p(time)) {
                b(Long.valueOf(parse.getTime()));
                return;
            }
            i iVar = new i(this, time);
            this.f10440f = iVar;
            textInputLayout.postDelayed(iVar, 1000L);
        } catch (ParseException unused) {
            textInputLayout.postDelayed(hVar, 1000L);
        }
    }
}
