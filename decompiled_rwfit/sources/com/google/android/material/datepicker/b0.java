package com.google.android.material.datepicker;

import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public final class b0 extends j {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ r f10417g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ SingleDateSelector f10418h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(SingleDateSelector singleDateSelector, String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, r rVar) {
        super(str, simpleDateFormat, textInputLayout, calendarConstraints);
        this.f10418h = singleDateSelector;
        this.f10417g = rVar;
    }

    @Override // com.google.android.material.datepicker.j
    public final void a() {
        this.f10417g.a();
    }

    @Override // com.google.android.material.datepicker.j
    public final void b(Long l3) {
        SingleDateSelector singleDateSelector = this.f10418h;
        if (l3 == null) {
            SingleDateSelector.a(singleDateSelector);
        } else {
            singleDateSelector.O(l3.longValue());
        }
        this.f10417g.b(singleDateSelector.d());
    }
}
