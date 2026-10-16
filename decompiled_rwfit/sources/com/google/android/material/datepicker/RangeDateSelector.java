package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.gms.internal.mlkit_vision_barcode.cb;
import com.google.android.gms.internal.mlkit_vision_barcode.db;
import com.google.android.gms.internal.mlkit_vision_barcode.s0;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public class RangeDateSelector implements DateSelector<k1.c> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new u(3);
    private String invalidRangeStartError;
    private final String invalidRangeEndError = " ";
    private Long selectedStartItem = null;
    private Long selectedEndItem = null;
    private Long proposedTextStart = null;
    private Long proposedTextEnd = null;

    public static void b(RangeDateSelector rangeDateSelector, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, r rVar) {
        Long l3 = rangeDateSelector.proposedTextStart;
        if (l3 == null || rangeDateSelector.proposedTextEnd == null) {
            if (textInputLayout.getError() != null && rangeDateSelector.invalidRangeStartError.contentEquals(textInputLayout.getError())) {
                textInputLayout.setError(null);
            }
            if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
                textInputLayout2.setError(null);
            }
            rVar.a();
            return;
        }
        if (l3.longValue() > rangeDateSelector.proposedTextEnd.longValue()) {
            textInputLayout.setError(rangeDateSelector.invalidRangeStartError);
            textInputLayout2.setError(" ");
            rVar.a();
        } else {
            Long l5 = rangeDateSelector.proposedTextStart;
            rangeDateSelector.selectedStartItem = l5;
            Long l8 = rangeDateSelector.proposedTextEnd;
            rangeDateSelector.selectedEndItem = l8;
            rVar.b(new k1.c(l5, l8));
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final boolean A() {
        Long l3 = this.selectedStartItem;
        return (l3 == null || this.selectedEndItem == null || l3.longValue() > this.selectedEndItem.longValue()) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList F() {
        ArrayList arrayList = new ArrayList();
        Long l3 = this.selectedStartItem;
        if (l3 != null) {
            arrayList.add(l3);
        }
        Long l5 = this.selectedEndItem;
        if (l5 != null) {
            arrayList.add(l5);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final Object I() {
        return new k1.c(this.selectedStartItem, this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void O(long j4) {
        Long l3 = this.selectedStartItem;
        if (l3 == null) {
            this.selectedStartItem = Long.valueOf(j4);
        } else if (this.selectedEndItem == null && l3.longValue() <= j4) {
            this.selectedEndItem = Long.valueOf(j4);
        } else {
            this.selectedEndItem = null;
            this.selectedStartItem = Long.valueOf(j4);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final View c(LayoutInflater layoutInflater, ViewGroup viewGroup, CalendarConstraints calendarConstraints, r rVar) {
        View inflate = layoutInflater.inflate(R$layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R$id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R$id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (db.a()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.invalidRangeStartError = inflate.getResources().getString(R$string.mtrl_picker_invalid_range);
        SimpleDateFormat c9 = e0.c();
        Long l3 = this.selectedStartItem;
        if (l3 != null) {
            editText.setText(c9.format(l3));
            this.proposedTextStart = this.selectedStartItem;
        }
        Long l5 = this.selectedEndItem;
        if (l5 != null) {
            editText2.setText(c9.format(l5));
            this.proposedTextEnd = this.selectedEndItem;
        }
        String d5 = e0.d(inflate.getResources(), c9);
        textInputLayout.setPlaceholderText(d5);
        textInputLayout2.setPlaceholderText(d5);
        editText.addTextChangedListener(new a0(this, d5, c9, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, rVar, 0));
        editText2.addTextChangedListener(new a0(this, d5, c9, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, rVar, 1));
        editText.requestFocus();
        editText.post(new androidx.activity.e(editText, 14));
        return inflate;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String e(Context context) {
        Resources resources = context.getResources();
        Long l3 = this.selectedStartItem;
        if (l3 == null && this.selectedEndItem == null) {
            return resources.getString(R$string.mtrl_picker_range_header_unselected);
        }
        Long l5 = this.selectedEndItem;
        if (l5 == null) {
            return resources.getString(R$string.mtrl_picker_range_header_only_start_selected, cb.a(l3.longValue()));
        }
        if (l3 == null) {
            return resources.getString(R$string.mtrl_picker_range_header_only_end_selected, cb.a(l5.longValue()));
        }
        Calendar e = e0.e();
        Calendar f2 = e0.f(null);
        f2.setTimeInMillis(l3.longValue());
        Calendar f10 = e0.f(null);
        f10.setTimeInMillis(l5.longValue());
        k1.c cVar = f2.get(1) == f10.get(1) ? f2.get(1) == e.get(1) ? new k1.c(cb.b(l3.longValue(), Locale.getDefault()), cb.b(l5.longValue(), Locale.getDefault())) : new k1.c(cb.b(l3.longValue(), Locale.getDefault()), cb.c(l5.longValue(), Locale.getDefault())) : new k1.c(cb.c(l3.longValue(), Locale.getDefault()), cb.c(l5.longValue(), Locale.getDefault()));
        return resources.getString(R$string.mtrl_picker_range_header_selected, cVar.f15450a, cVar.f15451b);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final int f(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return s0.b(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R$dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R$attr.materialCalendarTheme : R$attr.materialCalendarFullscreenTheme, s.class.getCanonicalName());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList y() {
        if (this.selectedStartItem == null || this.selectedEndItem == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new k1.c(this.selectedStartItem, this.selectedEndItem));
        return arrayList;
    }
}
