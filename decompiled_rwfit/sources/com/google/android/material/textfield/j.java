package com.google.android.material.textfield;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;

/* loaded from: classes.dex */
public final class j implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AutoCompleteTextView f10906a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f10907b;

    public j(l lVar, AutoCompleteTextView autoCompleteTextView) {
        this.f10907b = lVar;
        this.f10906a = autoCompleteTextView;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            l lVar = this.f10907b;
            lVar.getClass();
            long currentTimeMillis = System.currentTimeMillis() - lVar.f10915k;
            if (currentTimeMillis < 0 || currentTimeMillis > 300) {
                lVar.f10913i = false;
            }
            l.d(lVar, this.f10906a);
        }
        return false;
    }
}
