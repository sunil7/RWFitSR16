package j2;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R$id;
import com.google.android.gms.internal.mlkit_vision_barcode.id;

/* loaded from: classes.dex */
public final class z extends ViewGroup implements w {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f15311g = 0;

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f15312a;

    /* renamed from: b, reason: collision with root package name */
    public View f15313b;

    /* renamed from: c, reason: collision with root package name */
    public final View f15314c;

    /* renamed from: d, reason: collision with root package name */
    public int f15315d;
    public Matrix e;

    /* renamed from: f, reason: collision with root package name */
    public final y f15316f;

    public z(View view) {
        super(view.getContext());
        this.f15316f = new y(this, 0);
        this.f15314c = view;
        setWillNotDraw(false);
        setClipChildren(false);
        setLayerType(2, null);
    }

    @Override // j2.w
    public final void a(ViewGroup viewGroup, View view) {
        this.f15312a = viewGroup;
        this.f15313b = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i3 = R$id.ghost_view;
        View view = this.f15314c;
        view.setTag(i3, this);
        view.getViewTreeObserver().addOnPreDrawListener(this.f15316f);
        o0.c(4, view);
        if (view.getParent() != null) {
            ((View) view.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        View view = this.f15314c;
        view.getViewTreeObserver().removeOnPreDrawListener(this.f15316f);
        o0.c(0, view);
        view.setTag(R$id.ghost_view, null);
        if (view.getParent() != null) {
            ((View) view.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        id.a(canvas, true);
        canvas.setMatrix(this.e);
        View view = this.f15314c;
        o0.c(0, view);
        view.invalidate();
        o0.c(4, view);
        drawChild(canvas, view, getDrawingTime());
        id.a(canvas, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
    }

    @Override // android.view.View, j2.w
    public final void setVisibility(int i3) {
        super.setVisibility(i3);
        int i10 = R$id.ghost_view;
        View view = this.f15314c;
        if (((z) view.getTag(i10)) == this) {
            o0.c(i3 == 0 ? 4 : 0, view);
        }
    }
}
