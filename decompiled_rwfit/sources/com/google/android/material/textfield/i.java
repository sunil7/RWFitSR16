package com.google.android.material.textfield;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;

/* loaded from: classes.dex */
public final class i extends r {
    public final /* synthetic */ l e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(l lVar, TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.e = lVar;
    }

    @Override // com.google.android.material.textfield.r, l1.c
    public final void d(View view, m1.d dVar) {
        super.d(view, dVar);
        if (!l.f(this.e.f10921a.getEditText())) {
            dVar.f(Spinner.class.getName());
        }
        AccessibilityNodeInfo accessibilityNodeInfo = dVar.f15938a;
        if (accessibilityNodeInfo.isShowingHintText()) {
            accessibilityNodeInfo.setHintText(null);
        }
    }

    @Override // l1.c
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        super.e(view, accessibilityEvent);
        l lVar = this.e;
        EditText editText = lVar.f10921a.getEditText();
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        if (accessibilityEvent.getEventType() == 1 && lVar.f10918n.isTouchExplorationEnabled() && !l.f(lVar.f10921a.getEditText())) {
            l.d(lVar, autoCompleteTextView);
        }
    }
}
