package eb;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class g extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public m f12488a;

    /* renamed from: b, reason: collision with root package name */
    public ua.a f12489b;

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f12490c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f12491d;
    public ColorStateList e;

    /* renamed from: f, reason: collision with root package name */
    public PorterDuff.Mode f12492f;

    /* renamed from: g, reason: collision with root package name */
    public Rect f12493g;

    /* renamed from: h, reason: collision with root package name */
    public float f12494h;

    /* renamed from: i, reason: collision with root package name */
    public float f12495i;

    /* renamed from: j, reason: collision with root package name */
    public float f12496j;

    /* renamed from: k, reason: collision with root package name */
    public int f12497k;

    /* renamed from: l, reason: collision with root package name */
    public float f12498l;

    /* renamed from: m, reason: collision with root package name */
    public float f12499m;

    /* renamed from: n, reason: collision with root package name */
    public int f12500n;

    /* renamed from: o, reason: collision with root package name */
    public int f12501o;

    /* renamed from: p, reason: collision with root package name */
    public int f12502p;

    /* renamed from: q, reason: collision with root package name */
    public int f12503q;
    public Paint.Style r;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        h hVar = new h(this);
        hVar.e = true;
        return hVar;
    }
}
