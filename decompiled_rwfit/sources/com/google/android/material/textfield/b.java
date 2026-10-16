package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

/* loaded from: classes.dex */
public final class b implements t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10889a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f10890b;

    public /* synthetic */ b(m mVar, int i3) {
        this.f10889a = i3;
        this.f10890b = mVar;
    }

    @Override // com.google.android.material.textfield.t
    public final void a(TextInputLayout textInputLayout, int i3) {
        switch (this.f10889a) {
            case 0:
                EditText editText = textInputLayout.getEditText();
                if (editText != null && i3 == 2) {
                    editText.post(new x.h(this, 4, editText, false));
                    if (editText.getOnFocusChangeListener() == ((e) this.f10890b).e) {
                        editText.setOnFocusChangeListener(null);
                        break;
                    }
                }
                break;
            case 1:
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
                if (autoCompleteTextView != null && i3 == 3) {
                    autoCompleteTextView.post(new x.h(this, 6, autoCompleteTextView, false));
                    if (autoCompleteTextView.getOnFocusChangeListener() == ((l) this.f10890b).e) {
                        autoCompleteTextView.setOnFocusChangeListener(null);
                    }
                    autoCompleteTextView.setOnTouchListener(null);
                    autoCompleteTextView.setOnDismissListener(null);
                    break;
                }
                break;
            default:
                EditText editText2 = textInputLayout.getEditText();
                if (editText2 != null && i3 == 1) {
                    editText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    editText2.post(new x.h(this, 7, editText2, false));
                    break;
                }
                break;
        }
    }
}
