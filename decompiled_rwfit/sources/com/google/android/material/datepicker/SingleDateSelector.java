package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.gms.internal.mlkit_vision_barcode.cb;
import com.google.android.gms.internal.mlkit_vision_barcode.db;
import com.google.android.gms.internal.mlkit_vision_barcode.s0;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new u(4);
    private Long selectedItem;

    public static void a(SingleDateSelector singleDateSelector) {
        singleDateSelector.selectedItem = null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final boolean A() {
        return this.selectedItem != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList F() {
        ArrayList arrayList = new ArrayList();
        Long l3 = this.selectedItem;
        if (l3 != null) {
            arrayList.add(l3);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final Object I() {
        return this.selectedItem;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final void O(long j4) {
        this.selectedItem = Long.valueOf(j4);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final View c(LayoutInflater layoutInflater, ViewGroup viewGroup, CalendarConstraints calendarConstraints, r rVar) {
        View inflate = layoutInflater.inflate(R$layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R$id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (db.a()) {
            editText.setInputType(17);
        }
        SimpleDateFormat c9 = e0.c();
        String d5 = e0.d(inflate.getResources(), c9);
        textInputLayout.setPlaceholderText(d5);
        Long l3 = this.selectedItem;
        if (l3 != null) {
            editText.setText(c9.format(l3));
        }
        editText.addTextChangedListener(new b0(this, d5, c9, textInputLayout, calendarConstraints, rVar));
        editText.requestFocus();
        editText.post(new androidx.activity.e(editText, 14));
        return inflate;
    }

    public final Long d() {
        return this.selectedItem;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final String e(Context context) {
        Resources resources = context.getResources();
        Long l3 = this.selectedItem;
        if (l3 == null) {
            return resources.getString(R$string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R$string.mtrl_picker_date_header_selected, cb.c(l3.longValue(), Locale.getDefault()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final int f(Context context) {
        return s0.b(context, R$attr.materialCalendarTheme, s.class.getCanonicalName());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeValue(this.selectedItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public final ArrayList y() {
        return new ArrayList();
    }
}
