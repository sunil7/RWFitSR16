package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import com.autonavi.aps.amapapi.config.Const;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import he.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import n.l;
import o0.c;
import okhttp3.internal.http2.Http2Connection;
import org.xmlpull.v1.XmlPullParserException;
import q0.a;
import q0.g;
import q0.k;
import q0.m;
import w0.e;
import w0.f;
import w0.h;
import w0.o;
import w0.q;
import w0.s;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    public static s r;

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f1856a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1857b;

    /* renamed from: c, reason: collision with root package name */
    public final g f1858c;

    /* renamed from: d, reason: collision with root package name */
    public int f1859d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f1860f;

    /* renamed from: g, reason: collision with root package name */
    public int f1861g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1862h;

    /* renamed from: i, reason: collision with root package name */
    public int f1863i;

    /* renamed from: j, reason: collision with root package name */
    public o f1864j;

    /* renamed from: k, reason: collision with root package name */
    public b f1865k;

    /* renamed from: l, reason: collision with root package name */
    public int f1866l;

    /* renamed from: m, reason: collision with root package name */
    public HashMap f1867m;

    /* renamed from: n, reason: collision with root package name */
    public final SparseArray f1868n;

    /* renamed from: o, reason: collision with root package name */
    public final f f1869o;

    /* renamed from: p, reason: collision with root package name */
    public int f1870p;

    /* renamed from: q, reason: collision with root package name */
    public int f1871q;

    public ConstraintLayout(Context context) {
        super(context);
        this.f1856a = new SparseArray();
        this.f1857b = new ArrayList(4);
        this.f1858c = new g();
        this.f1859d = 0;
        this.e = 0;
        this.f1860f = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f1861g = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f1862h = true;
        this.f1863i = 257;
        this.f1864j = null;
        this.f1865k = null;
        this.f1866l = -1;
        this.f1867m = new HashMap();
        this.f1868n = new SparseArray();
        this.f1869o = new f(this, this);
        this.f1870p = 0;
        this.f1871q = 0;
        h(null, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return max2 > 0 ? max2 : max;
    }

    public static s getSharedValues() {
        if (r == null) {
            s sVar = new s();
            new SparseIntArray();
            sVar.f19455a = new HashMap();
            r = sVar;
        }
        return r;
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0193  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x02ba -> B:79:0x02bb). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(boolean r17, android.view.View r18, q0.f r19, w0.e r20, android.util.SparseArray r21) {
        /*
            Method dump skipped, instructions count: 807
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.c(boolean, android.view.View, q0.f, w0.e, android.util.SparseArray):void");
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    public final View d(int i3) {
        return (View) this.f1856a.get(i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f1857b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                ((ConstraintHelper) arrayList.get(i3)).o(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(Const.STR_MART_COMMA);
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i11 = (int) ((parseInt / 1080.0f) * width);
                        int i12 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f2 = i11;
                        float f10 = i12;
                        float f11 = i11 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f2, f10, f11, f10, paint);
                        float parseInt4 = i12 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f11, f10, f11, parseInt4, paint);
                        canvas.drawLine(f11, parseInt4, f2, parseInt4, paint);
                        canvas.drawLine(f2, parseInt4, f2, f10, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f2, f10, f11, parseInt4, paint);
                        canvas.drawLine(f2, parseInt4, f11, f10, paint);
                    }
                }
            }
        }
    }

    public final q0.f e(View view) {
        if (view == this) {
            return this.f1858c;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof e) {
            return ((e) view.getLayoutParams()).f19323p0;
        }
        view.setLayoutParams(new e(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof e) {
            return ((e) view.getLayoutParams()).f19323p0;
        }
        return null;
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f1862h = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public int getMaxHeight() {
        return this.f1861g;
    }

    public int getMaxWidth() {
        return this.f1860f;
    }

    public int getMinHeight() {
        return this.e;
    }

    public int getMinWidth() {
        return this.f1859d;
    }

    public int getOptimizationLevel() {
        return this.f1858c.F0;
    }

    public final void h(AttributeSet attributeSet, int i3) {
        g gVar = this.f1858c;
        gVar.f17656g0 = this;
        f fVar = this.f1869o;
        gVar.f17689w0 = fVar;
        gVar.f17687u0.f17973f = fVar;
        this.f1856a.put(getId(), this);
        this.f1864j = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout, i3, 0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.f1859d = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1859d);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.e = obtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.f1860f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1860f);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.f1861g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1861g);
                } else if (index == R$styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f1863i = obtainStyledAttributes.getInt(index, this.f1863i);
                } else if (index == R$styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            l(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f1865k = null;
                        }
                    }
                } else if (index == R$styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        o oVar = new o();
                        this.f1864j = oVar;
                        oVar.j(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f1864j = null;
                    }
                    this.f1866l = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        gVar.F0 = this.f1863i;
        c.f16650p = gVar.S(512);
    }

    public final boolean k() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    public void l(int i3) {
        int eventType;
        w0.g gVar;
        Context context = getContext();
        b bVar = new b();
        bVar.f14314a = -1;
        bVar.f14315b = -1;
        bVar.f14317d = new SparseArray();
        bVar.e = new SparseArray();
        bVar.f14316c = this;
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            eventType = xml.getEventType();
            gVar = null;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        }
        while (true) {
            char c9 = 1;
            if (eventType == 1) {
                this.f1865k = bVar;
                return;
            }
            if (eventType == 0) {
                xml.getName();
            } else if (eventType == 2) {
                String name = xml.getName();
                switch (name.hashCode()) {
                    case -1349929691:
                        if (name.equals("ConstraintSet")) {
                            c9 = 4;
                            break;
                        }
                        c9 = 65535;
                        break;
                    case 80204913:
                        if (name.equals("State")) {
                            c9 = 2;
                            break;
                        }
                        c9 = 65535;
                        break;
                    case 1382829617:
                        if (name.equals("StateSet")) {
                            break;
                        }
                        c9 = 65535;
                        break;
                    case 1657696882:
                        if (name.equals("layoutDescription")) {
                            c9 = 0;
                            break;
                        }
                        c9 = 65535;
                        break;
                    case 1901439077:
                        if (name.equals("Variant")) {
                            c9 = 3;
                            break;
                        }
                        c9 = 65535;
                        break;
                    default:
                        c9 = 65535;
                        break;
                }
                if (c9 == 2) {
                    gVar = new w0.g(context, xml);
                    ((SparseArray) bVar.f14317d).put(gVar.f19340a, gVar);
                } else if (c9 == 3) {
                    h hVar = new h(context, xml);
                    if (gVar != null) {
                        gVar.f19341b.add(hVar);
                    }
                } else if (c9 == 4) {
                    bVar.e(context, xml);
                }
            }
            eventType = xml.next();
        }
    }

    public final void m(int i3, int i10, int i11, int i12, boolean z5, boolean z6) {
        f fVar = this.f1869o;
        int i13 = fVar.e;
        int resolveSizeAndState = View.resolveSizeAndState(i11 + fVar.f19336d, i3, 0);
        int resolveSizeAndState2 = View.resolveSizeAndState(i12 + i13, i10, 0) & 16777215;
        int min = Math.min(this.f1860f, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.f1861g, resolveSizeAndState2);
        if (z5) {
            min |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        if (z6) {
            min2 |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        setMeasuredDimension(min, min2);
    }

    public final void n(g gVar, int i3, int i10, int i11) {
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2;
        int i12;
        int i13;
        int max;
        int max2;
        boolean z5;
        int i14;
        boolean z6;
        int i15;
        int i16;
        boolean z8;
        ArrayList arrayList;
        int i17;
        int i18;
        boolean z10;
        boolean z11;
        androidx.constraintlayout.core.widgets.analyzer.e eVar;
        androidx.constraintlayout.core.widgets.analyzer.g gVar2;
        boolean z12;
        int i19;
        int i20;
        int i21;
        boolean z13;
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        int max3 = Math.max(0, getPaddingTop());
        int max4 = Math.max(0, getPaddingBottom());
        int i22 = max3 + max4;
        int paddingWidth = getPaddingWidth();
        f fVar = this.f1869o;
        fVar.f19334b = max3;
        fVar.f19335c = max4;
        fVar.f19336d = paddingWidth;
        fVar.e = i22;
        fVar.f19337f = i10;
        fVar.f19338g = i11;
        int max5 = Math.max(0, getPaddingStart());
        int max6 = Math.max(0, getPaddingEnd());
        if (max5 <= 0 && max6 <= 0) {
            max5 = Math.max(0, getPaddingLeft());
        } else if (k()) {
            max5 = max6;
        }
        int i23 = size - paddingWidth;
        int i24 = size2 - i22;
        int i25 = fVar.e;
        int i26 = fVar.f19336d;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.FIXED;
        int childCount = getChildCount();
        if (mode == Integer.MIN_VALUE) {
            constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                max = Math.max(0, this.f1859d);
                int i27 = max;
                constraintWidget$DimensionBehaviour2 = constraintWidget$DimensionBehaviour;
                i13 = i27;
                i12 = Integer.MIN_VALUE;
            } else {
                constraintWidget$DimensionBehaviour2 = constraintWidget$DimensionBehaviour;
                i12 = Integer.MIN_VALUE;
                i13 = i23;
            }
        } else if (mode != 0) {
            i13 = mode != 1073741824 ? 0 : Math.min(this.f1860f - i26, i23);
            i12 = Integer.MIN_VALUE;
            constraintWidget$DimensionBehaviour2 = constraintWidget$DimensionBehaviour3;
        } else {
            constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                max = Math.max(0, this.f1859d);
                int i272 = max;
                constraintWidget$DimensionBehaviour2 = constraintWidget$DimensionBehaviour;
                i13 = i272;
                i12 = Integer.MIN_VALUE;
            } else {
                i13 = 0;
                i12 = Integer.MIN_VALUE;
                constraintWidget$DimensionBehaviour2 = constraintWidget$DimensionBehaviour;
            }
        }
        if (mode2 == i12) {
            constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            max2 = childCount == 0 ? Math.max(0, this.e) : i24;
        } else if (mode2 != 0) {
            if (mode2 == 1073741824) {
                max2 = Math.min(this.f1861g - i25, i24);
            }
            max2 = 0;
        } else {
            constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                max2 = Math.max(0, this.e);
            }
            max2 = 0;
        }
        int o3 = gVar.o();
        r0.e eVar2 = gVar.f17687u0;
        if (i13 != o3 || max2 != gVar.l()) {
            eVar2.f17971c = true;
        }
        gVar.Z = 0;
        gVar.f17645a0 = 0;
        int i28 = this.f1860f - i26;
        int[] iArr = gVar.B;
        iArr[0] = i28;
        iArr[1] = this.f1861g - i25;
        gVar.f17649c0 = 0;
        gVar.f17651d0 = 0;
        gVar.I(constraintWidget$DimensionBehaviour2);
        gVar.K(i13);
        gVar.J(constraintWidget$DimensionBehaviour3);
        gVar.H(max2);
        int i29 = this.f1859d - i26;
        if (i29 < 0) {
            gVar.f17649c0 = 0;
        } else {
            gVar.f17649c0 = i29;
        }
        int i30 = this.e - i25;
        if (i30 < 0) {
            gVar.f17651d0 = 0;
        } else {
            gVar.f17651d0 = i30;
        }
        gVar.f17692z0 = max5;
        gVar.A0 = max3;
        l lVar = gVar.f17686t0;
        lVar.getClass();
        f fVar2 = gVar.f17689w0;
        int size3 = gVar.f17685s0.size();
        int o8 = gVar.o();
        int l3 = gVar.l();
        boolean c9 = m.c(i3, 128);
        boolean z14 = c9 || m.c(i3, 64);
        if (z14) {
            int i31 = 0;
            while (i31 < size3) {
                q0.f fVar3 = (q0.f) gVar.f17685s0.get(i31);
                ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr = fVar3.T;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = constraintWidget$DimensionBehaviourArr[0];
                boolean z15 = z14;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour5 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z16 = (constraintWidget$DimensionBehaviour4 == constraintWidget$DimensionBehaviour5) && (constraintWidget$DimensionBehaviourArr[1] == constraintWidget$DimensionBehaviour5) && fVar3.X > 0.0f;
                if ((fVar3.v() && z16) || ((fVar3.w() && z16) || (fVar3 instanceof q0.o) || fVar3.v() || fVar3.w())) {
                    i14 = 1073741824;
                    z5 = false;
                    break;
                } else {
                    i31++;
                    z14 = z15;
                }
            }
        }
        z5 = z14;
        i14 = 1073741824;
        boolean z17 = z5 & ((mode == i14 && mode2 == i14) || c9);
        if (z17) {
            int min = Math.min(gVar.B[0], i23);
            int min2 = Math.min(gVar.B[1], i24);
            if (mode != 1073741824 || gVar.o() == min) {
                z12 = true;
            } else {
                gVar.K(min);
                z12 = true;
                gVar.f17687u0.f17970b = true;
            }
            if (mode2 == 1073741824 && gVar.l() != min2) {
                gVar.H(min2);
                gVar.f17687u0.f17970b = z12;
            }
            if (mode == 1073741824 && mode2 == 1073741824) {
                boolean z18 = eVar2.f17970b;
                g gVar3 = eVar2.f17969a;
                if (z18 || eVar2.f17971c) {
                    ArrayList arrayList2 = gVar3.f17685s0;
                    int size4 = arrayList2.size();
                    int i32 = 0;
                    while (i32 < size4) {
                        Object obj = arrayList2.get(i32);
                        i32++;
                        q0.f fVar4 = (q0.f) obj;
                        fVar4.i();
                        fVar4.f17644a = false;
                        fVar4.f17650d.n();
                        fVar4.e.m();
                        z17 = z17;
                    }
                    z6 = z17;
                    gVar3.i();
                    i21 = 0;
                    gVar3.f17644a = false;
                    gVar3.f17650d.n();
                    gVar3.e.m();
                    eVar2.f17971c = false;
                } else {
                    z6 = z17;
                    i21 = 0;
                }
                eVar2.b(eVar2.f17972d);
                gVar3.Z = i21;
                gVar3.f17645a0 = i21;
                ConstraintWidget$DimensionBehaviour k10 = gVar3.k(i21);
                ConstraintWidget$DimensionBehaviour k11 = gVar3.k(1);
                if (eVar2.f17970b) {
                    eVar2.c();
                }
                int p8 = gVar3.p();
                int q5 = gVar3.q();
                gVar3.f17650d.f1637h.d(p8);
                gVar3.e.f1637h.d(q5);
                eVar2.g();
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour6 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                ArrayList arrayList3 = eVar2.e;
                if (k10 == constraintWidget$DimensionBehaviour6 || k11 == constraintWidget$DimensionBehaviour6) {
                    if (c9) {
                        int size5 = arrayList3.size();
                        i15 = size3;
                        int i33 = 0;
                        while (true) {
                            if (i33 >= size5) {
                                break;
                            }
                            Object obj2 = arrayList3.get(i33);
                            i33++;
                            if (!((androidx.constraintlayout.core.widgets.analyzer.h) obj2).k()) {
                                c9 = false;
                                break;
                            }
                        }
                    } else {
                        i15 = size3;
                    }
                    if (c9 && k10 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) {
                        gVar3.I(ConstraintWidget$DimensionBehaviour.FIXED);
                        gVar3.K(eVar2.d(gVar3, 0));
                        gVar3.f17650d.e.d(gVar3.o());
                    }
                    if (c9 && k11 == ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) {
                        gVar3.J(ConstraintWidget$DimensionBehaviour.FIXED);
                        gVar3.H(eVar2.d(gVar3, 1));
                        gVar3.e.e.d(gVar3.l());
                    }
                } else {
                    i15 = size3;
                }
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour7 = gVar3.T[0];
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour8 = ConstraintWidget$DimensionBehaviour.FIXED;
                if (constraintWidget$DimensionBehaviour7 == constraintWidget$DimensionBehaviour8 || constraintWidget$DimensionBehaviour7 == ConstraintWidget$DimensionBehaviour.MATCH_PARENT) {
                    int o10 = gVar3.o() + p8;
                    gVar3.f17650d.f1638i.d(o10);
                    gVar3.f17650d.e.d(o10 - p8);
                    eVar2.g();
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour9 = gVar3.T[1];
                    if (constraintWidget$DimensionBehaviour9 == constraintWidget$DimensionBehaviour8 || constraintWidget$DimensionBehaviour9 == ConstraintWidget$DimensionBehaviour.MATCH_PARENT) {
                        int l5 = gVar3.l() + q5;
                        gVar3.e.f1638i.d(l5);
                        gVar3.e.e.d(l5 - q5);
                    }
                    eVar2.g();
                    z13 = true;
                } else {
                    z13 = false;
                }
                int size6 = arrayList3.size();
                int i34 = 0;
                while (i34 < size6) {
                    Object obj3 = arrayList3.get(i34);
                    i34++;
                    androidx.constraintlayout.core.widgets.analyzer.h hVar = (androidx.constraintlayout.core.widgets.analyzer.h) obj3;
                    if (hVar.f1632b != gVar3 || hVar.f1636g) {
                        hVar.e();
                    }
                }
                int size7 = arrayList3.size();
                int i35 = 0;
                while (i35 < size7) {
                    Object obj4 = arrayList3.get(i35);
                    i35++;
                    androidx.constraintlayout.core.widgets.analyzer.h hVar2 = (androidx.constraintlayout.core.widgets.analyzer.h) obj4;
                    if (z13 || hVar2.f1632b != gVar3) {
                        if (!hVar2.f1637h.f1622j || ((!hVar2.f1638i.f1622j && !(hVar2 instanceof r0.g)) || (!hVar2.e.f1622j && !(hVar2 instanceof r0.c) && !(hVar2 instanceof r0.g)))) {
                            z8 = false;
                            break;
                        }
                    }
                }
                z8 = true;
                gVar3.I(k10);
                gVar3.J(k11);
                i20 = 1073741824;
                i16 = 2;
            } else {
                z6 = z17;
                i15 = size3;
                boolean z19 = eVar2.f17970b;
                g gVar4 = eVar2.f17969a;
                if (z19) {
                    ArrayList arrayList4 = gVar4.f17685s0;
                    int size8 = arrayList4.size();
                    int i36 = 0;
                    while (i36 < size8) {
                        Object obj5 = arrayList4.get(i36);
                        i36++;
                        q0.f fVar5 = (q0.f) obj5;
                        fVar5.i();
                        fVar5.f17644a = false;
                        androidx.constraintlayout.core.widgets.analyzer.e eVar3 = fVar5.f17650d;
                        ArrayList arrayList5 = arrayList4;
                        eVar3.e.f1622j = false;
                        eVar3.f1636g = false;
                        eVar3.n();
                        androidx.constraintlayout.core.widgets.analyzer.g gVar5 = fVar5.e;
                        gVar5.e.f1622j = false;
                        gVar5.f1636g = false;
                        gVar5.m();
                        arrayList4 = arrayList5;
                    }
                    i19 = 0;
                    gVar4.i();
                    gVar4.f17644a = false;
                    androidx.constraintlayout.core.widgets.analyzer.e eVar4 = gVar4.f17650d;
                    eVar4.e.f1622j = false;
                    eVar4.f1636g = false;
                    eVar4.n();
                    androidx.constraintlayout.core.widgets.analyzer.g gVar6 = gVar4.e;
                    gVar6.e.f1622j = false;
                    gVar6.f1636g = false;
                    gVar6.m();
                    eVar2.c();
                } else {
                    i19 = 0;
                }
                eVar2.b(eVar2.f17972d);
                gVar4.Z = i19;
                gVar4.f17645a0 = i19;
                gVar4.f17650d.f1637h.d(i19);
                gVar4.e.f1637h.d(i19);
                i20 = 1073741824;
                if (mode == 1073741824) {
                    z8 = gVar.P(i19, c9);
                    i16 = 1;
                } else {
                    i16 = 0;
                    z8 = true;
                }
                if (mode2 == 1073741824) {
                    z8 &= gVar.P(1, c9);
                    i16++;
                }
            }
            if (z8) {
                gVar.L(mode == i20, mode2 == i20);
            }
        } else {
            z6 = z17;
            i15 = size3;
            i16 = 0;
            z8 = false;
        }
        if (z8 && i16 == 2) {
            return;
        }
        int i37 = gVar.F0;
        if (i15 > 0) {
            int size9 = gVar.f17685s0.size();
            boolean S = gVar.S(64);
            f fVar6 = gVar.f17689w0;
            for (int i38 = 0; i38 < size9; i38++) {
                q0.f fVar7 = (q0.f) gVar.f17685s0.get(i38);
                if (!(fVar7 instanceof k) && !(fVar7 instanceof a) && !fVar7.F && (!S || (eVar = fVar7.f17650d) == null || (gVar2 = fVar7.e) == null || !eVar.e.f1622j || !gVar2.e.f1622j)) {
                    ConstraintWidget$DimensionBehaviour k12 = fVar7.k(0);
                    ConstraintWidget$DimensionBehaviour k13 = fVar7.k(1);
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour10 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                    boolean z20 = k12 == constraintWidget$DimensionBehaviour10 && fVar7.f17674q != 1 && k13 == constraintWidget$DimensionBehaviour10 && fVar7.r != 1;
                    if (!z20 && gVar.S(1) && !(fVar7 instanceof q0.o)) {
                        if (k12 == constraintWidget$DimensionBehaviour10 && fVar7.f17674q == 0 && k13 != constraintWidget$DimensionBehaviour10 && !fVar7.v()) {
                            z20 = true;
                        }
                        if (k13 == constraintWidget$DimensionBehaviour10 && fVar7.r == 0 && k12 != constraintWidget$DimensionBehaviour10 && !fVar7.v()) {
                            z20 = true;
                        }
                        if ((k12 == constraintWidget$DimensionBehaviour10 || k13 == constraintWidget$DimensionBehaviour10) && fVar7.X > 0.0f) {
                            z20 = true;
                        }
                    }
                    if (!z20) {
                        lVar.m(0, fVar7, fVar6);
                    }
                }
            }
            ConstraintLayout constraintLayout = fVar6.f19333a;
            int childCount2 = constraintLayout.getChildCount();
            for (int i39 = 0; i39 < childCount2; i39++) {
                View childAt = constraintLayout.getChildAt(i39);
                if (childAt instanceof Placeholder) {
                    Placeholder placeholder = (Placeholder) childAt;
                    if (placeholder.f1874b != null) {
                        e eVar5 = (e) placeholder.getLayoutParams();
                        e eVar6 = (e) placeholder.f1874b.getLayoutParams();
                        q0.f fVar8 = eVar6.f19323p0;
                        fVar8.f17658h0 = 0;
                        q0.f fVar9 = eVar5.f19323p0;
                        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour11 = fVar9.T[0];
                        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour12 = ConstraintWidget$DimensionBehaviour.FIXED;
                        if (constraintWidget$DimensionBehaviour11 != constraintWidget$DimensionBehaviour12) {
                            fVar9.K(fVar8.o());
                        }
                        q0.f fVar10 = eVar5.f19323p0;
                        if (fVar10.T[1] != constraintWidget$DimensionBehaviour12) {
                            fVar10.H(eVar6.f19323p0.l());
                        }
                        eVar6.f19323p0.f17658h0 = 8;
                    }
                }
            }
            ArrayList arrayList6 = constraintLayout.f1857b;
            int size10 = arrayList6.size();
            if (size10 > 0) {
                for (int i40 = 0; i40 < size10; i40++) {
                    ((ConstraintHelper) arrayList6.get(i40)).getClass();
                }
            }
        }
        lVar.u(gVar);
        ArrayList arrayList7 = (ArrayList) lVar.f16245b;
        int size11 = arrayList7.size();
        if (i15 > 0) {
            lVar.t(gVar, 0, o8, l3);
        }
        if (size11 > 0) {
            ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArr2 = gVar.T;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour13 = constraintWidget$DimensionBehaviourArr2[0];
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour14 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            boolean z21 = constraintWidget$DimensionBehaviour13 == constraintWidget$DimensionBehaviour14;
            boolean z22 = constraintWidget$DimensionBehaviourArr2[1] == constraintWidget$DimensionBehaviour14;
            int o11 = gVar.o();
            g gVar7 = (g) lVar.f16247d;
            int max7 = Math.max(o11, gVar7.f17649c0);
            int max8 = Math.max(gVar.l(), gVar7.f17651d0);
            int i41 = 0;
            boolean z23 = false;
            while (i41 < size11) {
                q0.f fVar11 = (q0.f) arrayList7.get(i41);
                if (fVar11 instanceof q0.o) {
                    int o12 = fVar11.o();
                    z10 = z22;
                    int l8 = fVar11.l();
                    z11 = z21;
                    boolean m10 = z23 | lVar.m(1, fVar11, fVar2);
                    int o13 = fVar11.o();
                    boolean z24 = m10;
                    int l9 = fVar11.l();
                    if (o13 != o12) {
                        fVar11.K(o13);
                        if (z11 && fVar11.p() + fVar11.V > max7) {
                            max7 = Math.max(max7, fVar11.j(ConstraintAnchor$Type.RIGHT).e() + fVar11.p() + fVar11.V);
                        }
                        z24 = true;
                    }
                    if (l9 != l8) {
                        fVar11.H(l9);
                        if (z10 && fVar11.q() + fVar11.W > max8) {
                            max8 = Math.max(max8, fVar11.j(ConstraintAnchor$Type.BOTTOM).e() + fVar11.q() + fVar11.W);
                        }
                        z24 = true;
                    }
                    z23 = z24 | ((q0.o) fVar11).A0;
                } else {
                    z10 = z22;
                    z11 = z21;
                }
                i41++;
                z22 = z10;
                z21 = z11;
            }
            boolean z25 = z22;
            boolean z26 = z21;
            int i42 = 0;
            while (i42 < 2) {
                boolean z27 = z23;
                int i43 = 0;
                while (i43 < size11) {
                    q0.f fVar12 = (q0.f) arrayList7.get(i43);
                    if ((!(fVar12 instanceof q0.l) || (fVar12 instanceof q0.o)) && !(fVar12 instanceof k)) {
                        if (fVar12.f17658h0 != 8 && ((!z6 || !fVar12.f17650d.e.f1622j || !fVar12.e.e.f1622j) && !(fVar12 instanceof q0.o))) {
                            int o14 = fVar12.o();
                            int l10 = fVar12.l();
                            arrayList = arrayList7;
                            int i44 = fVar12.f17647b0;
                            i17 = size11;
                            z27 |= lVar.m(i42 == 1 ? 2 : 1, fVar12, fVar2);
                            int o15 = fVar12.o();
                            i18 = i43;
                            int l11 = fVar12.l();
                            if (o15 != o14) {
                                fVar12.K(o15);
                                if (z26 && fVar12.p() + fVar12.V > max7) {
                                    max7 = Math.max(max7, fVar12.j(ConstraintAnchor$Type.RIGHT).e() + fVar12.p() + fVar12.V);
                                }
                                z27 = true;
                            }
                            if (l11 != l10) {
                                fVar12.H(l11);
                                if (z25 && fVar12.q() + fVar12.W > max8) {
                                    max8 = Math.max(max8, fVar12.j(ConstraintAnchor$Type.BOTTOM).e() + fVar12.q() + fVar12.W);
                                }
                                z27 = true;
                            }
                            if (fVar12.D && i44 != fVar12.f17647b0) {
                                z27 = true;
                            }
                            i43 = i18 + 1;
                            arrayList7 = arrayList;
                            size11 = i17;
                        }
                    }
                    arrayList = arrayList7;
                    i17 = size11;
                    i18 = i43;
                    i43 = i18 + 1;
                    arrayList7 = arrayList;
                    size11 = i17;
                }
                ArrayList arrayList8 = arrayList7;
                int i45 = size11;
                if (!z27) {
                    break;
                }
                i42++;
                lVar.t(gVar, i42, o8, l3);
                arrayList7 = arrayList8;
                size11 = i45;
                z23 = false;
            }
        }
        gVar.F0 = i37;
        c.f16650p = gVar.S(512);
    }

    public final void o(q0.f fVar, e eVar, SparseArray sparseArray, int i3, ConstraintAnchor$Type constraintAnchor$Type) {
        View view = (View) this.f1856a.get(i3);
        q0.f fVar2 = (q0.f) sparseArray.get(i3);
        if (fVar2 == null || view == null || !(view.getLayoutParams() instanceof e)) {
            return;
        }
        eVar.f19297b0 = true;
        ConstraintAnchor$Type constraintAnchor$Type2 = ConstraintAnchor$Type.BASELINE;
        if (constraintAnchor$Type == constraintAnchor$Type2) {
            e eVar2 = (e) view.getLayoutParams();
            eVar2.f19297b0 = true;
            eVar2.f19323p0.D = true;
        }
        fVar.j(constraintAnchor$Type2).b(fVar2.j(constraintAnchor$Type), eVar.C, eVar.B, true);
        fVar.D = true;
        fVar.j(ConstraintAnchor$Type.TOP).j();
        fVar.j(ConstraintAnchor$Type.BOTTOM).j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            e eVar = (e) childAt.getLayoutParams();
            q0.f fVar = eVar.f19323p0;
            if ((childAt.getVisibility() != 8 || eVar.f19299c0 || eVar.f19301d0 || isInEditMode) && !eVar.f19302e0) {
                int p8 = fVar.p();
                int q5 = fVar.q();
                int o3 = fVar.o() + p8;
                int l3 = fVar.l() + q5;
                childAt.layout(p8, q5, o3, l3);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(p8, q5, o3, l3);
                }
            }
        }
        ArrayList arrayList = this.f1857b;
        int size = arrayList.size();
        if (size > 0) {
            for (int i14 = 0; i14 < size; i14++) {
                ((ConstraintHelper) arrayList.get(i14)).n();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i10) {
        boolean z5;
        String resourceName;
        int id2;
        q0.f fVar;
        if (this.f1870p == i3) {
            int i11 = this.f1871q;
        }
        int i12 = 0;
        if (!this.f1862h) {
            int childCount = getChildCount();
            int i13 = 0;
            while (true) {
                if (i13 >= childCount) {
                    break;
                }
                if (getChildAt(i13).isLayoutRequested()) {
                    this.f1862h = true;
                    break;
                }
                i13++;
            }
        }
        this.f1870p = i3;
        this.f1871q = i10;
        boolean k10 = k();
        g gVar = this.f1858c;
        gVar.f17690x0 = k10;
        if (this.f1862h) {
            this.f1862h = false;
            int childCount2 = getChildCount();
            int i14 = 0;
            while (true) {
                if (i14 >= childCount2) {
                    z5 = false;
                    break;
                } else {
                    if (getChildAt(i14).isLayoutRequested()) {
                        z5 = true;
                        break;
                    }
                    i14++;
                }
            }
            if (z5) {
                boolean isInEditMode = isInEditMode();
                int childCount3 = getChildCount();
                for (int i15 = 0; i15 < childCount3; i15++) {
                    q0.f e = e(getChildAt(i15));
                    if (e != null) {
                        e.A();
                    }
                }
                Object obj = null;
                if (isInEditMode) {
                    for (int i16 = 0; i16 < childCount3; i16++) {
                        View childAt = getChildAt(i16);
                        try {
                            resourceName = getResources().getResourceName(childAt.getId());
                            Integer valueOf = Integer.valueOf(childAt.getId());
                            if (resourceName != null) {
                                if (this.f1867m == null) {
                                    this.f1867m = new HashMap();
                                }
                                int indexOf = resourceName.indexOf("/");
                                this.f1867m.put(indexOf != -1 ? resourceName.substring(indexOf + 1) : resourceName, valueOf);
                            }
                            int indexOf2 = resourceName.indexOf(47);
                            if (indexOf2 != -1) {
                                resourceName = resourceName.substring(indexOf2 + 1);
                            }
                            id2 = childAt.getId();
                        } catch (Resources.NotFoundException unused) {
                        }
                        if (id2 != 0) {
                            View view = (View) this.f1856a.get(id2);
                            if (view == null && (view = findViewById(id2)) != null && view != this && view.getParent() == this) {
                                onViewAdded(view);
                            }
                            if (view != this) {
                                fVar = view == null ? null : ((e) view.getLayoutParams()).f19323p0;
                                fVar.i0 = resourceName;
                            }
                        }
                        fVar = gVar;
                        fVar.i0 = resourceName;
                    }
                }
                if (this.f1866l != -1) {
                    for (int i17 = 0; i17 < childCount3; i17++) {
                        View childAt2 = getChildAt(i17);
                        if (childAt2.getId() == this.f1866l && (childAt2 instanceof Constraints)) {
                            this.f1864j = ((Constraints) childAt2).getConstraintSet();
                        }
                    }
                }
                o oVar = this.f1864j;
                if (oVar != null) {
                    oVar.c(this);
                }
                gVar.f17685s0.clear();
                ArrayList arrayList = this.f1857b;
                int size = arrayList.size();
                if (size > 0) {
                    int i18 = 0;
                    while (i18 < size) {
                        ConstraintHelper constraintHelper = (ConstraintHelper) arrayList.get(i18);
                        if (constraintHelper.isInEditMode()) {
                            constraintHelper.setIds(constraintHelper.e);
                        }
                        q0.l lVar = constraintHelper.f1852d;
                        if (lVar != null) {
                            lVar.f17721t0 = i12;
                            Arrays.fill(lVar.f17720s0, obj);
                            for (int i19 = i12; i19 < constraintHelper.f1850b; i19++) {
                                int i20 = constraintHelper.f1849a[i19];
                                View d5 = d(i20);
                                if (d5 == null) {
                                    Integer valueOf2 = Integer.valueOf(i20);
                                    HashMap hashMap = constraintHelper.f1855h;
                                    String str = (String) hashMap.get(valueOf2);
                                    int h4 = constraintHelper.h(this, str);
                                    if (h4 != 0) {
                                        constraintHelper.f1849a[i19] = h4;
                                        hashMap.put(Integer.valueOf(h4), str);
                                        d5 = d(h4);
                                    }
                                }
                                View view2 = d5;
                                if (view2 != null) {
                                    constraintHelper.f1852d.N(e(view2));
                                }
                            }
                            constraintHelper.f1852d.P();
                        }
                        i18++;
                        i12 = 0;
                        obj = null;
                    }
                }
                for (int i21 = 0; i21 < childCount3; i21++) {
                    View childAt3 = getChildAt(i21);
                    if (childAt3 instanceof Placeholder) {
                        Placeholder placeholder = (Placeholder) childAt3;
                        if (placeholder.f1873a == -1 && !placeholder.isInEditMode()) {
                            placeholder.setVisibility(placeholder.f1875c);
                        }
                        View findViewById = findViewById(placeholder.f1873a);
                        placeholder.f1874b = findViewById;
                        if (findViewById != null) {
                            ((e) findViewById.getLayoutParams()).f19302e0 = true;
                            placeholder.f1874b.setVisibility(0);
                            placeholder.setVisibility(0);
                        }
                    }
                }
                SparseArray sparseArray = this.f1868n;
                sparseArray.clear();
                sparseArray.put(0, gVar);
                sparseArray.put(getId(), gVar);
                for (int i22 = 0; i22 < childCount3; i22++) {
                    View childAt4 = getChildAt(i22);
                    sparseArray.put(childAt4.getId(), e(childAt4));
                }
                for (int i23 = 0; i23 < childCount3; i23++) {
                    View childAt5 = getChildAt(i23);
                    q0.f e10 = e(childAt5);
                    if (e10 != null) {
                        e eVar = (e) childAt5.getLayoutParams();
                        gVar.f17685s0.add(e10);
                        q0.f fVar2 = e10.U;
                        if (fVar2 != null) {
                            ((g) fVar2).f17685s0.remove(e10);
                            e10.A();
                        }
                        e10.U = gVar;
                        c(isInEditMode, childAt5, e10, eVar, sparseArray);
                    }
                }
            }
            if (z5) {
                gVar.f17686t0.u(gVar);
            }
        }
        n(gVar, this.f1863i, i3, i10);
        m(i3, i10, gVar.o(), gVar.l(), gVar.G0, gVar.H0);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        q0.f e = e(view);
        if ((view instanceof Guideline) && !(e instanceof k)) {
            e eVar = (e) view.getLayoutParams();
            k kVar = new k();
            eVar.f19323p0 = kVar;
            eVar.f19299c0 = true;
            kVar.O(eVar.U);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.q();
            ((e) view.getLayoutParams()).f19301d0 = true;
            ArrayList arrayList = this.f1857b;
            if (!arrayList.contains(constraintHelper)) {
                arrayList.add(constraintHelper);
            }
        }
        this.f1856a.put(view.getId(), view);
        this.f1862h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f1856a.remove(view.getId());
        q0.f e = e(view);
        this.f1858c.f17685s0.remove(e);
        e.A();
        this.f1857b.remove(view);
        this.f1862h = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f1862h = true;
        super.requestLayout();
    }

    public void setConstraintSet(o oVar) {
        this.f1864j = oVar;
    }

    @Override // android.view.View
    public void setId(int i3) {
        int id2 = getId();
        SparseArray sparseArray = this.f1856a;
        sparseArray.remove(id2);
        super.setId(i3);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i3) {
        if (i3 == this.f1861g) {
            return;
        }
        this.f1861g = i3;
        requestLayout();
    }

    public void setMaxWidth(int i3) {
        if (i3 == this.f1860f) {
            return;
        }
        this.f1860f = i3;
        requestLayout();
    }

    public void setMinHeight(int i3) {
        if (i3 == this.e) {
            return;
        }
        this.e = i3;
        requestLayout();
    }

    public void setMinWidth(int i3) {
        if (i3 == this.f1859d) {
            return;
        }
        this.f1859d = i3;
        requestLayout();
    }

    public void setOnConstraintsChanged(q qVar) {
        b bVar = this.f1865k;
        if (bVar != null) {
            bVar.getClass();
        }
    }

    public void setOptimizationLevel(int i3) {
        this.f1863i = i3;
        g gVar = this.f1858c;
        gVar.F0 = i3;
        c.f16650p = gVar.S(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1856a = new SparseArray();
        this.f1857b = new ArrayList(4);
        this.f1858c = new g();
        this.f1859d = 0;
        this.e = 0;
        this.f1860f = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f1861g = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f1862h = true;
        this.f1863i = 257;
        this.f1864j = null;
        this.f1865k = null;
        this.f1866l = -1;
        this.f1867m = new HashMap();
        this.f1868n = new SparseArray();
        this.f1869o = new f(this, this);
        this.f1870p = 0;
        this.f1871q = 0;
        h(attributeSet, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1856a = new SparseArray();
        this.f1857b = new ArrayList(4);
        this.f1858c = new g();
        this.f1859d = 0;
        this.e = 0;
        this.f1860f = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f1861g = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f1862h = true;
        this.f1863i = 257;
        this.f1864j = null;
        this.f1865k = null;
        this.f1866l = -1;
        this.f1867m = new HashMap();
        this.f1868n = new SparseArray();
        this.f1869o = new f(this, this);
        this.f1870p = 0;
        this.f1871q = 0;
        h(attributeSet, i3);
    }
}
