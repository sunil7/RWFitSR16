package u0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final int f18783a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f18784b;

    /* renamed from: c, reason: collision with root package name */
    public int f18785c;

    /* renamed from: d, reason: collision with root package name */
    public int f18786d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public String f18787f;

    /* renamed from: g, reason: collision with root package name */
    public int f18788g;

    /* renamed from: h, reason: collision with root package name */
    public int f18789h;

    /* renamed from: i, reason: collision with root package name */
    public final float f18790i;

    /* renamed from: j, reason: collision with root package name */
    public final androidx.constraintlayout.motion.widget.c f18791j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f18792k;

    /* renamed from: l, reason: collision with root package name */
    public androidx.constraintlayout.motion.widget.d f18793l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f18794m;

    /* renamed from: n, reason: collision with root package name */
    public final int f18795n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f18796o;

    /* renamed from: p, reason: collision with root package name */
    public int f18797p;

    /* renamed from: q, reason: collision with root package name */
    public final int f18798q;
    public final int r;

    public x(androidx.constraintlayout.motion.widget.c cVar, x xVar) {
        this.f18783a = -1;
        this.f18784b = false;
        this.f18785c = -1;
        this.f18786d = -1;
        this.e = 0;
        this.f18787f = null;
        this.f18788g = -1;
        this.f18789h = 400;
        this.f18790i = 0.0f;
        this.f18792k = new ArrayList();
        this.f18793l = null;
        this.f18794m = new ArrayList();
        this.f18795n = 0;
        this.f18796o = false;
        this.f18797p = -1;
        this.f18798q = 0;
        this.r = 0;
        this.f18791j = cVar;
        this.f18789h = cVar.f1740j;
        if (xVar != null) {
            this.f18797p = xVar.f18797p;
            this.e = xVar.e;
            this.f18787f = xVar.f18787f;
            this.f18788g = xVar.f18788g;
            this.f18789h = xVar.f18789h;
            this.f18792k = xVar.f18792k;
            this.f18790i = xVar.f18790i;
            this.f18798q = xVar.f18798q;
        }
    }

    public x(androidx.constraintlayout.motion.widget.c cVar, int i3, int i10) {
        this.f18783a = -1;
        this.f18784b = false;
        this.f18785c = -1;
        this.f18786d = -1;
        this.e = 0;
        this.f18787f = null;
        this.f18788g = -1;
        this.f18789h = 400;
        this.f18790i = 0.0f;
        this.f18792k = new ArrayList();
        this.f18793l = null;
        this.f18794m = new ArrayList();
        this.f18795n = 0;
        this.f18796o = false;
        this.f18797p = -1;
        this.f18798q = 0;
        this.r = 0;
        this.f18783a = -1;
        this.f18791j = cVar;
        this.f18786d = i3;
        this.f18785c = i10;
        this.f18789h = cVar.f1740j;
        this.f18798q = cVar.f1741k;
    }

    public x(androidx.constraintlayout.motion.widget.c cVar, Context context, XmlResourceParser xmlResourceParser) {
        this.f18783a = -1;
        this.f18784b = false;
        this.f18785c = -1;
        this.f18786d = -1;
        this.e = 0;
        this.f18787f = null;
        this.f18788g = -1;
        this.f18789h = 400;
        this.f18790i = 0.0f;
        this.f18792k = new ArrayList();
        this.f18793l = null;
        this.f18794m = new ArrayList();
        this.f18795n = 0;
        this.f18796o = false;
        this.f18797p = -1;
        this.f18798q = 0;
        this.r = 0;
        this.f18789h = cVar.f1740j;
        this.f18798q = cVar.f1741k;
        this.f18791j = cVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.Transition);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            int i10 = R$styleable.Transition_constraintSetEnd;
            SparseArray sparseArray = cVar.f1737g;
            if (index == i10) {
                this.f18785c = obtainStyledAttributes.getResourceId(index, -1);
                String resourceTypeName = context.getResources().getResourceTypeName(this.f18785c);
                if ("layout".equals(resourceTypeName)) {
                    w0.o oVar = new w0.o();
                    oVar.j(context, this.f18785c);
                    sparseArray.append(this.f18785c, oVar);
                } else if ("xml".equals(resourceTypeName)) {
                    this.f18785c = cVar.j(context, this.f18785c);
                }
            } else if (index == R$styleable.Transition_constraintSetStart) {
                this.f18786d = obtainStyledAttributes.getResourceId(index, this.f18786d);
                String resourceTypeName2 = context.getResources().getResourceTypeName(this.f18786d);
                if ("layout".equals(resourceTypeName2)) {
                    w0.o oVar2 = new w0.o();
                    oVar2.j(context, this.f18786d);
                    sparseArray.append(this.f18786d, oVar2);
                } else if ("xml".equals(resourceTypeName2)) {
                    this.f18786d = cVar.j(context, this.f18786d);
                }
            } else if (index == R$styleable.Transition_motionInterpolator) {
                int i11 = obtainStyledAttributes.peekValue(index).type;
                if (i11 == 1) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                    this.f18788g = resourceId;
                    if (resourceId != -1) {
                        this.e = -2;
                    }
                } else if (i11 == 3) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f18787f = string;
                    if (string != null) {
                        if (string.indexOf("/") > 0) {
                            this.f18788g = obtainStyledAttributes.getResourceId(index, -1);
                            this.e = -2;
                        } else {
                            this.e = -1;
                        }
                    }
                } else {
                    this.e = obtainStyledAttributes.getInteger(index, this.e);
                }
            } else if (index == R$styleable.Transition_duration) {
                int i12 = obtainStyledAttributes.getInt(index, this.f18789h);
                this.f18789h = i12;
                if (i12 < 8) {
                    this.f18789h = 8;
                }
            } else if (index == R$styleable.Transition_staggered) {
                this.f18790i = obtainStyledAttributes.getFloat(index, this.f18790i);
            } else if (index == R$styleable.Transition_autoTransition) {
                this.f18795n = obtainStyledAttributes.getInteger(index, this.f18795n);
            } else if (index == R$styleable.Transition_android_id) {
                this.f18783a = obtainStyledAttributes.getResourceId(index, this.f18783a);
            } else if (index == R$styleable.Transition_transitionDisable) {
                this.f18796o = obtainStyledAttributes.getBoolean(index, this.f18796o);
            } else if (index == R$styleable.Transition_pathMotionArc) {
                this.f18797p = obtainStyledAttributes.getInteger(index, -1);
            } else if (index == R$styleable.Transition_layoutDuringTransition) {
                this.f18798q = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R$styleable.Transition_transitionFlags) {
                this.r = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        if (this.f18786d == -1) {
            this.f18784b = true;
        }
        obtainStyledAttributes.recycle();
    }
}
