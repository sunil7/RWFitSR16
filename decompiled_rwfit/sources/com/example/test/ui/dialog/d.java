package com.example.test.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.loper7.date_time_picker.R$style;
import com.loper7.date_time_picker.number_picker.NumberPicker;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d extends Dialog implements View.OnClickListener, cf.e {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7949a;

    /* renamed from: b, reason: collision with root package name */
    public int f7950b;

    /* renamed from: c, reason: collision with root package name */
    public int f7951c;

    /* renamed from: d, reason: collision with root package name */
    public int f7952d;
    public t6.e e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, ArrayList arrayList, int i3) {
        super(context, R$style.DateTimePicker_BottomSheetDialog);
        kotlin.jvm.internal.e.f(context, "context");
        setContentView(R$layout.dialog_custom_option_picker);
        this.f7949a = arrayList;
        this.f7950b = i3;
        this.f7951c = i3;
        this.f7952d = i3;
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = 0;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setGravity(80);
            window.setBackgroundDrawableResource(R$color.transparent);
        }
    }

    public final void a(int i3) {
        this.f7950b = i3;
        NumberPicker numberPicker = (NumberPicker) findViewById(R$id.content_picker);
        numberPicker.setOnValueChangedListener(this);
        ArrayList arrayList = this.f7949a;
        numberPicker.setMaxValue(arrayList.size() - 1);
        numberPicker.setMinValue(0);
        numberPicker.setValue(this.f7950b);
        numberPicker.setDisplayedValues((String[]) arrayList.toArray(new String[0]));
    }

    @Override // cf.e
    public final void g(int i3, int i10) {
        this.f7951c = i3;
        this.f7952d = i10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.dialog_submit;
        if (valueOf != null && valueOf.intValue() == i3) {
            dismiss();
            t6.e eVar = this.e;
            if (eVar != null) {
                eVar.a(this.f7951c, this.f7952d);
                return;
            }
            return;
        }
        int i10 = R$id.dialog_cancel;
        if (valueOf != null && valueOf.intValue() == i10) {
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((TextView) findViewById(R$id.dialog_submit)).setOnClickListener(this);
        ((TextView) findViewById(R$id.dialog_cancel)).setOnClickListener(this);
        NumberPicker numberPicker = (NumberPicker) findViewById(R$id.content_picker);
        numberPicker.setOnValueChangedListener(this);
        ArrayList arrayList = this.f7949a;
        numberPicker.setMaxValue(arrayList.size() - 1);
        numberPicker.setMinValue(0);
        numberPicker.setValue(this.f7950b);
        numberPicker.setDisplayedValues((String[]) arrayList.toArray(new String[0]));
    }

    public final void setOnOptionSelectListener(t6.e optionSelectListener) {
        kotlin.jvm.internal.e.f(optionSelectListener, "optionSelectListener");
        this.e = optionSelectListener;
    }
}
