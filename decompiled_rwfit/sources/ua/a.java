package ua;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import com.google.android.gms.internal.mlkit_vision_barcode.s0;
import com.google.android.gms.internal.mlkit_vision_common.x;
import com.google.android.material.R$attr;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f19028a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19029b;

    /* renamed from: c, reason: collision with root package name */
    public final int f19030c;

    /* renamed from: d, reason: collision with root package name */
    public final float f19031d;

    public a(Context context) {
        TypedValue a3 = s0.a(context, R$attr.elevationOverlayEnabled);
        this.f19028a = (a3 == null || a3.type != 18 || a3.data == 0) ? false : true;
        TypedValue a10 = s0.a(context, R$attr.elevationOverlayColor);
        this.f19029b = a10 != null ? a10.data : 0;
        TypedValue a11 = s0.a(context, R$attr.colorSurface);
        this.f19030c = a11 != null ? a11.data : 0;
        this.f19031d = context.getResources().getDisplayMetrics().density;
    }

    public final int a(float f2, int i3) {
        if (!this.f19028a || c1.a.e(i3, 255) != this.f19030c) {
            return i3;
        }
        float f10 = 0.0f;
        if (this.f19031d > 0.0f && f2 > 0.0f) {
            f10 = Math.min(((((float) Math.log1p(f2 / r1)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        }
        return c1.a.e(x.d(c1.a.e(i3, 255), f10, this.f19029b), Color.alpha(i3));
    }
}
