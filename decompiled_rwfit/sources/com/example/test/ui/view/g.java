package com.example.test.ui.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* loaded from: classes.dex */
public final class g implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8690a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InputView f8691b;

    public /* synthetic */ g(InputView inputView, int i3) {
        this.f8690a = i3;
        this.f8691b = inputView;
    }

    private final void a(int i3, int i10, int i11, CharSequence charSequence) {
    }

    private final void b(int i3, int i10, int i11, CharSequence charSequence) {
    }

    private final void c(int i3, int i10, int i11, CharSequence charSequence) {
    }

    private final void d(int i3, int i10, int i11, CharSequence charSequence) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        switch (this.f8690a) {
            case 0:
                if (editable == null || editable.length() <= 16) {
                    return;
                }
                CharSequence subSequence = editable.subSequence(0, 16);
                InputView inputView = this.f8691b;
                EditText editText = inputView.f8453m;
                if (editText == null) {
                    kotlin.jvm.internal.e.m("etInputET");
                    throw null;
                }
                editText.setText((Editable) subSequence);
                EditText editText2 = inputView.f8453m;
                if (editText2 == null) {
                    kotlin.jvm.internal.e.m("etInputET");
                    throw null;
                }
                if (editText2 != null) {
                    editText2.setSelection(editText2.getText().length());
                    return;
                } else {
                    kotlin.jvm.internal.e.m("etInputET");
                    throw null;
                }
            default:
                boolean l3 = editable != null ? kotlin.text.m.l(editable) : true;
                a7.c cVar = this.f8691b.f8448h;
                if (cVar != null) {
                    cVar.c(String.valueOf(editable), true ^ l3);
                    return;
                }
                return;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
        int i12 = this.f8690a;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
        int i12 = this.f8690a;
    }
}
