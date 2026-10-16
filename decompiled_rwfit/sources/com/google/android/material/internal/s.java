package com.google.android.material.internal;

import android.content.Context;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: c, reason: collision with root package name */
    public float f10634c;
    public final WeakReference e;

    /* renamed from: f, reason: collision with root package name */
    public bb.e f10636f;

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f10632a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    public final q f10633b = new q(this, 0);

    /* renamed from: d, reason: collision with root package name */
    public boolean f10635d = true;

    public s(r rVar) {
        this.e = new WeakReference(null);
        this.e = new WeakReference(rVar);
    }

    public final float a(String str) {
        if (!this.f10635d) {
            return this.f10634c;
        }
        float measureText = str == null ? 0.0f : this.f10632a.measureText((CharSequence) str, 0, str.length());
        this.f10634c = measureText;
        this.f10635d = false;
        return measureText;
    }

    public final void b(bb.e eVar, Context context) {
        if (this.f10636f != eVar) {
            this.f10636f = eVar;
            if (eVar != null) {
                TextPaint textPaint = this.f10632a;
                q qVar = this.f10633b;
                eVar.f(context, textPaint, qVar);
                r rVar = (r) this.e.get();
                if (rVar != null) {
                    textPaint.drawableState = rVar.getState();
                }
                eVar.e(context, textPaint, qVar);
                this.f10635d = true;
            }
            r rVar2 = (r) this.e.get();
            if (rVar2 != null) {
                rVar2.a();
                rVar2.onStateChange(rVar2.getState());
            }
        }
    }
}
