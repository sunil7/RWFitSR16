package wa;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.example.test.ui.device.activity.i0;
import com.google.android.gms.internal.mlkit_vision_barcode.nd;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import eb.x;
import j2.q;
import j2.y;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class n {
    public static final v1.a E = ja.a.f15385c;
    public static final int[] F = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] G = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    public static final int[] H = {R.attr.state_focused, R.attr.state_enabled};
    public static final int[] I = {R.attr.state_hovered, R.attr.state_enabled};
    public static final int[] J = {R.attr.state_enabled};
    public static final int[] K = new int[0];
    public y D;

    /* renamed from: a, reason: collision with root package name */
    public eb.m f19565a;

    /* renamed from: b, reason: collision with root package name */
    public eb.h f19566b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f19567c;

    /* renamed from: d, reason: collision with root package name */
    public b f19568d;
    public LayerDrawable e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f19569f;

    /* renamed from: h, reason: collision with root package name */
    public float f19571h;

    /* renamed from: i, reason: collision with root package name */
    public float f19572i;

    /* renamed from: j, reason: collision with root package name */
    public float f19573j;

    /* renamed from: k, reason: collision with root package name */
    public int f19574k;

    /* renamed from: l, reason: collision with root package name */
    public ja.e f19575l;

    /* renamed from: m, reason: collision with root package name */
    public ja.e f19576m;

    /* renamed from: n, reason: collision with root package name */
    public Animator f19577n;

    /* renamed from: o, reason: collision with root package name */
    public ja.e f19578o;

    /* renamed from: p, reason: collision with root package name */
    public ja.e f19579p;

    /* renamed from: q, reason: collision with root package name */
    public float f19580q;

    /* renamed from: s, reason: collision with root package name */
    public int f19581s;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList f19583u;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList f19584v;

    /* renamed from: w, reason: collision with root package name */
    public ArrayList f19585w;

    /* renamed from: x, reason: collision with root package name */
    public final FloatingActionButton f19586x;

    /* renamed from: y, reason: collision with root package name */
    public final mc.g f19587y;

    /* renamed from: g, reason: collision with root package name */
    public boolean f19570g = true;
    public float r = 1.0f;

    /* renamed from: t, reason: collision with root package name */
    public int f19582t = 0;

    /* renamed from: z, reason: collision with root package name */
    public final Rect f19588z = new Rect();
    public final RectF A = new RectF();
    public final RectF B = new RectF();
    public final Matrix C = new Matrix();

    public n(FloatingActionButton floatingActionButton, mc.g gVar) {
        this.f19586x = floatingActionButton;
        this.f19587y = gVar;
        de.o oVar = new de.o(14);
        p pVar = (p) this;
        oVar.e(F, c(new l(pVar, 1)));
        oVar.e(G, c(new l(pVar, 0)));
        oVar.e(H, c(new l(pVar, 0)));
        oVar.e(I, c(new l(pVar, 0)));
        oVar.e(J, c(new l(pVar, 2)));
        oVar.e(K, c(new k(pVar)));
        this.f19580q = floatingActionButton.getRotation();
    }

    public static ValueAnimator c(m mVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(E);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(mVar);
        valueAnimator.addUpdateListener(mVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public final void a(float f2, Matrix matrix) {
        matrix.reset();
        if (this.f19586x.getDrawable() == null || this.f19581s == 0) {
            return;
        }
        RectF rectF = this.A;
        RectF rectF2 = this.B;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        float f10 = this.f19581s;
        rectF2.set(0.0f, 0.0f, f10, f10);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        float f11 = this.f19581s / 2.0f;
        matrix.postScale(f2, f2, f11, f11);
    }

    public final AnimatorSet b(ja.e eVar, float f2, float f10, float f11) {
        ArrayList arrayList = new ArrayList();
        Property property = View.ALPHA;
        int i3 = 1;
        float[] fArr = {f2};
        FloatingActionButton floatingActionButton = this.f19586x;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) property, fArr);
        eVar.f("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_X, f10);
        eVar.f("scale").a(ofFloat2);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 == 26) {
            q qVar = new q(i3);
            qVar.f15281b = new FloatEvaluator();
            ofFloat2.setEvaluator(qVar);
        }
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_Y, f10);
        eVar.f("scale").a(ofFloat3);
        if (i10 == 26) {
            q qVar2 = new q(i3);
            qVar2.f15281b = new FloatEvaluator();
            ofFloat3.setEvaluator(qVar2);
        }
        arrayList.add(ofFloat3);
        Matrix matrix = this.C;
        a(f11, matrix);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(floatingActionButton, new j2.b(), new j(this), new Matrix(matrix));
        eVar.f("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        nd.a(animatorSet, arrayList);
        return animatorSet;
    }

    public abstract float d();

    public void e(Rect rect) {
        int sizeDimension = this.f19569f ? (this.f19574k - this.f19586x.getSizeDimension()) / 2 : 0;
        int max = Math.max(sizeDimension, (int) Math.ceil(this.f19570g ? d() + this.f19573j : 0.0f));
        int max2 = Math.max(sizeDimension, (int) Math.ceil(r1 * 1.5f));
        rect.set(max, max2, max, max2);
    }

    public abstract void f(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i3);

    public abstract void g();

    public abstract void h();

    public abstract void i(int[] iArr);

    public abstract void j(float f2, float f10, float f11);

    public final void k() {
        ArrayList arrayList = this.f19585w;
        if (arrayList != null) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                h hVar = (h) obj;
                i0 i0Var = hVar.f19550a;
                i0Var.getClass();
                eb.h hVar2 = ((BottomAppBar) i0Var.f7866b).S;
                FloatingActionButton floatingActionButton = hVar.f19551b;
                hVar2.m(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
            }
        }
    }

    public final void l() {
        com.google.android.material.bottomappbar.h topEdgeTreatment;
        com.google.android.material.bottomappbar.h topEdgeTreatment2;
        com.google.android.material.bottomappbar.h topEdgeTreatment3;
        com.google.android.material.bottomappbar.h topEdgeTreatment4;
        ArrayList arrayList = this.f19585w;
        if (arrayList != null) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                h hVar = (h) obj;
                i0 i0Var = hVar.f19550a;
                i0Var.getClass();
                FloatingActionButton floatingActionButton = hVar.f19551b;
                float translationX = floatingActionButton.getTranslationX();
                BottomAppBar bottomAppBar = (BottomAppBar) i0Var.f7866b;
                topEdgeTreatment = bottomAppBar.getTopEdgeTreatment();
                float f2 = topEdgeTreatment.f10265g;
                eb.h hVar2 = bottomAppBar.S;
                if (f2 != translationX) {
                    topEdgeTreatment4 = bottomAppBar.getTopEdgeTreatment();
                    topEdgeTreatment4.f10265g = translationX;
                    hVar2.invalidateSelf();
                }
                float f10 = 0.0f;
                float max = Math.max(0.0f, -floatingActionButton.getTranslationY());
                topEdgeTreatment2 = bottomAppBar.getTopEdgeTreatment();
                if (topEdgeTreatment2.f10264f != max) {
                    topEdgeTreatment3 = bottomAppBar.getTopEdgeTreatment();
                    topEdgeTreatment3.u(max);
                    hVar2.invalidateSelf();
                }
                if (floatingActionButton.getVisibility() == 0) {
                    f10 = floatingActionButton.getScaleY();
                }
                hVar2.m(f10);
            }
        }
    }

    public void m(ColorStateList colorStateList) {
        Drawable drawable = this.f19567c;
        if (drawable != null) {
            d1.b.h(drawable, cb.a.b(colorStateList));
        }
    }

    public final void n(eb.m mVar) {
        this.f19565a = mVar;
        eb.h hVar = this.f19566b;
        if (hVar != null) {
            hVar.setShapeAppearanceModel(mVar);
        }
        Object obj = this.f19567c;
        if (obj instanceof x) {
            ((x) obj).setShapeAppearanceModel(mVar);
        }
        b bVar = this.f19568d;
        if (bVar != null) {
            bVar.f19542o = mVar;
            bVar.invalidateSelf();
        }
    }

    public abstract boolean o();

    public abstract void p();

    public final void q() {
        Rect rect = this.f19588z;
        e(rect);
        pd.e(this.e, "Didn't initialize content background");
        boolean o3 = o();
        mc.g gVar = this.f19587y;
        if (o3) {
            super/*android.view.View*/.setBackgroundDrawable(new InsetDrawable((Drawable) this.e, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            LayerDrawable layerDrawable = this.e;
            if (layerDrawable != null) {
                super/*android.view.View*/.setBackgroundDrawable(layerDrawable);
            } else {
                gVar.getClass();
            }
        }
        int i3 = rect.left;
        int i10 = rect.top;
        int i11 = rect.right;
        int i12 = rect.bottom;
        FloatingActionButton floatingActionButton = (FloatingActionButton) gVar.f16022b;
        floatingActionButton.f10505l.set(i3, i10, i11, i12);
        int i13 = floatingActionButton.f10502i;
        floatingActionButton.setPadding(i3 + i13, i10 + i13, i11 + i13, i12 + i13);
    }
}
