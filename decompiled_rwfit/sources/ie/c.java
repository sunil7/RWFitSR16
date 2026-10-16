package ie;

import android.view.GestureDetector;
import android.view.ViewConfiguration;
import androidx.activity.ComponentActivity;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f14409a;

    /* renamed from: b, reason: collision with root package name */
    public final fe.b f14410b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14411c = true;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14412d = true;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f14413f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14414g;

    /* renamed from: h, reason: collision with root package name */
    public float f14415h;

    /* renamed from: i, reason: collision with root package name */
    public float f14416i;

    /* renamed from: j, reason: collision with root package name */
    public float f14417j;

    /* renamed from: k, reason: collision with root package name */
    public int f14418k;

    /* renamed from: l, reason: collision with root package name */
    public final GestureDetector f14419l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f14420m;

    public c(ComponentActivity componentActivity, fe.b bVar) {
        this.f14409a = ViewConfiguration.get(componentActivity).getScaledTouchSlop() * 2;
        this.f14410b = bVar;
        this.f14419l = new GestureDetector(componentActivity, new com.dh.imagepick.preview.widgets.video.c(this, 3));
    }

    public final float a() {
        if (!b()) {
            float f2 = this.f14413f;
            if (f2 > 0.0f) {
                return this.e / f2;
            }
            return 1.0f;
        }
        boolean z5 = this.f14420m;
        boolean z6 = (z5 && this.e < this.f14413f) || (!z5 && this.e > this.f14413f);
        float abs = Math.abs(1 - (this.e / this.f14413f)) * 0.5f;
        if (this.f14413f <= this.f14409a) {
            return 1.0f;
        }
        return z6 ? abs + 1.0f : 1.0f - abs;
    }

    public final boolean b() {
        return this.f14418k != 0;
    }
}
