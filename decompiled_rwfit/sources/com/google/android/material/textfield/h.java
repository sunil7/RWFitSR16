package com.google.android.material.textfield;

import android.text.Editable;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import com.google.android.material.internal.v;

/* loaded from: classes.dex */
public final class h extends v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10904a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f10905b;

    public /* synthetic */ h(m mVar, int i3) {
        this.f10904a = i3;
        this.f10905b = mVar;
    }

    @Override // com.google.android.material.internal.v, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        switch (this.f10904a) {
            case 0:
                l lVar = (l) this.f10905b;
                EditText editText = lVar.f10921a.getEditText();
                if (!(editText instanceof AutoCompleteTextView)) {
                    throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
                }
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
                if (lVar.f10918n.isTouchExplorationEnabled() && l.f(autoCompleteTextView) && !lVar.f10923c.hasFocus()) {
                    autoCompleteTextView.dismissDropDown();
                }
                autoCompleteTextView.post(new x.h(this, 5, autoCompleteTextView, false));
                return;
            default:
                return;
        }
    }

    @Override // com.google.android.material.internal.v, android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
        switch (this.f10904a) {
            case 1:
                ((p) this.f10905b).f10923c.setChecked(!p.d(r1));
                break;
        }
    }
}
