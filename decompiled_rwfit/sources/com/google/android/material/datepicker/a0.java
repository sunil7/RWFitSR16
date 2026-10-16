package com.google.android.material.datepicker;

import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public final class a0 extends j {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f10409g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f10410h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f10411i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ r f10412j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ RangeDateSelector f10413k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(RangeDateSelector rangeDateSelector, String str, SimpleDateFormat simpleDateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, r rVar, int i3) {
        super(str, simpleDateFormat, textInputLayout, calendarConstraints);
        this.f10409g = i3;
        this.f10413k = rangeDateSelector;
        this.f10410h = textInputLayout2;
        this.f10411i = textInputLayout3;
        this.f10412j = rVar;
    }

    @Override // com.google.android.material.datepicker.j
    public final void a() {
        switch (this.f10409g) {
            case 0:
                RangeDateSelector rangeDateSelector = this.f10413k;
                rangeDateSelector.proposedTextStart = null;
                RangeDateSelector.b(rangeDateSelector, this.f10410h, this.f10411i, this.f10412j);
                break;
            default:
                RangeDateSelector rangeDateSelector2 = this.f10413k;
                rangeDateSelector2.proposedTextEnd = null;
                RangeDateSelector.b(rangeDateSelector2, this.f10410h, this.f10411i, this.f10412j);
                break;
        }
    }

    @Override // com.google.android.material.datepicker.j
    public final void b(Long l3) {
        switch (this.f10409g) {
            case 0:
                RangeDateSelector rangeDateSelector = this.f10413k;
                rangeDateSelector.proposedTextStart = l3;
                RangeDateSelector.b(rangeDateSelector, this.f10410h, this.f10411i, this.f10412j);
                break;
            default:
                RangeDateSelector rangeDateSelector2 = this.f10413k;
                rangeDateSelector2.proposedTextEnd = l3;
                RangeDateSelector.b(rangeDateSelector2, this.f10410h, this.f10411i, this.f10412j);
                break;
        }
    }
}
