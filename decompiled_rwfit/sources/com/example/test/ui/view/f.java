package com.example.test.ui.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* loaded from: classes.dex */
public final class f implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f8687a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8688b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f8689c;

    public f(EditText editText, int i3) {
        kotlin.jvm.internal.e.f(editText, "editText");
        this.f8687a = editText;
        this.f8688b = i3;
        this.f8689c = new int[2];
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        if (y5.b.m(String.valueOf(editable)).length > this.f8688b && editable != null) {
            int[] iArr = this.f8689c;
            String l3 = android.support.v4.media.session.e.l(editable.subSequence(0, iArr[0]).toString(), editable.subSequence(iArr[1], editable.length()).toString());
            EditText editText = this.f8687a;
            editText.setText(l3);
            editText.setSelection(iArr[0]);
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
        if (y5.b.m(String.valueOf(charSequence)).length <= this.f8688b) {
            return;
        }
        int[] iArr = this.f8689c;
        iArr[0] = i3;
        iArr[1] = i3 + i11;
    }
}
