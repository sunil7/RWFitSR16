package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import java.util.HashMap;
import q0.f;
import q0.l;
import r5.a;
import w0.e;
import w0.j;
import w0.k;
import w0.p;

/* loaded from: classes.dex */
public abstract class ConstraintHelper extends View {

    /* renamed from: a, reason: collision with root package name */
    public int[] f1849a;

    /* renamed from: b, reason: collision with root package name */
    public int f1850b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f1851c;

    /* renamed from: d, reason: collision with root package name */
    public l f1852d;
    public String e;

    /* renamed from: f, reason: collision with root package name */
    public String f1853f;

    /* renamed from: g, reason: collision with root package name */
    public View[] f1854g;

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f1855h;

    public ConstraintHelper(Context context) {
        super(context);
        this.f1849a = new int[32];
        this.f1854g = null;
        this.f1855h = new HashMap();
        this.f1851c = context;
        k(null);
    }

    public final void b(String str) {
        if (str == null || str.length() == 0 || this.f1851c == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int i3 = i(trim);
        if (i3 != 0) {
            this.f1855h.put(Integer.valueOf(i3), trim);
            c(i3);
        } else {
            StringBuilder sb2 = new StringBuilder(a.a(23, trim));
            sb2.append("Could not find id of \"");
            sb2.append(trim);
            sb2.append("\"");
            Log.w("ConstraintHelper", sb2.toString());
        }
    }

    public final void c(int i3) {
        if (i3 == getId()) {
            return;
        }
        int i10 = this.f1850b + 1;
        int[] iArr = this.f1849a;
        if (i10 > iArr.length) {
            this.f1849a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1849a;
        int i11 = this.f1850b;
        iArr2[i11] = i3;
        this.f1850b = i11 + 1;
    }

    public final void d(String str) {
        if (str == null || str.length() == 0 || this.f1851c == null) {
            return;
        }
        String trim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof e) && trim.equals(((e) layoutParams).X)) {
                if (childAt.getId() == -1) {
                    String simpleName = childAt.getClass().getSimpleName();
                    StringBuilder sb2 = new StringBuilder(simpleName.length() + 42);
                    sb2.append("to use ConstraintTag view ");
                    sb2.append(simpleName);
                    sb2.append(" must have an ID");
                    Log.w("ConstraintHelper", sb2.toString());
                } else {
                    c(childAt.getId());
                }
            }
        }
    }

    public final void e() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        f((ConstraintLayout) parent);
    }

    public final void f(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i3 = 0; i3 < this.f1850b; i3++) {
            View d5 = constraintLayout.d(this.f1849a[i3]);
            if (d5 != null) {
                d5.setVisibility(visibility);
                if (elevation > 0.0f) {
                    d5.setTranslationZ(d5.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void g(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1849a, this.f1850b);
    }

    public final int h(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str != null && (resources = this.f1851c.getResources()) != null) {
            int childCount = constraintLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = constraintLayout.getChildAt(i3);
                if (childAt.getId() != -1) {
                    try {
                        str2 = resources.getResourceEntryName(childAt.getId());
                    } catch (Resources.NotFoundException unused) {
                        str2 = null;
                    }
                    if (str.equals(str2)) {
                        return childAt.getId();
                    }
                }
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(java.lang.String r5) {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.constraintlayout.widget.ConstraintLayout
            r1 = 0
            if (r0 == 0) goto L10
            android.view.ViewParent r0 = r4.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            goto L11
        L10:
            r0 = r1
        L11:
            boolean r2 = r4.isInEditMode()
            if (r2 == 0) goto L38
            if (r0 == 0) goto L38
            if (r5 == 0) goto L2c
            java.util.HashMap r2 = r0.f1867m
            if (r2 == 0) goto L2c
            boolean r2 = r2.containsKey(r5)
            if (r2 == 0) goto L2c
            java.util.HashMap r2 = r0.f1867m
            java.lang.Object r2 = r2.get(r5)
            goto L2d
        L2c:
            r2 = r1
        L2d:
            boolean r3 = r2 instanceof java.lang.Integer
            if (r3 == 0) goto L38
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            goto L39
        L38:
            r2 = 0
        L39:
            if (r2 != 0) goto L41
            if (r0 == 0) goto L41
            int r2 = r4.h(r0, r5)
        L41:
            if (r2 != 0) goto L4d
            java.lang.Class<androidx.constraintlayout.widget.R$id> r0 = androidx.constraintlayout.widget.R$id.class
            java.lang.reflect.Field r0 = r0.getField(r5)     // Catch: java.lang.Exception -> L4d
            int r2 = r0.getInt(r1)     // Catch: java.lang.Exception -> L4d
        L4d:
            if (r2 != 0) goto L5f
            android.content.Context r0 = r4.f1851c
            android.content.res.Resources r1 = r0.getResources()
            java.lang.String r2 = "id"
            java.lang.String r0 = r0.getPackageName()
            int r2 = r1.getIdentifier(r5, r2, r0)
        L5f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintHelper.i(java.lang.String):int");
    }

    public final View[] j(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f1854g;
        if (viewArr == null || viewArr.length != this.f1850b) {
            this.f1854g = new View[this.f1850b];
        }
        for (int i3 = 0; i3 < this.f1850b; i3++) {
            this.f1854g[i3] = constraintLayout.d(this.f1849a[i3]);
        }
        return this.f1854g;
    }

    public void k(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.e = string;
                    setIds(string);
                } else if (index == R$styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f1853f = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void l(j jVar, l lVar, p pVar, SparseArray sparseArray) {
        k kVar = jVar.e;
        int[] iArr = kVar.i0;
        int i3 = 0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = kVar.f19385j0;
            if (str != null) {
                if (str.length() > 0) {
                    String[] split = kVar.f19385j0.split(Const.STR_MART_COMMA);
                    getContext();
                    int[] iArr2 = new int[split.length];
                    int i10 = 0;
                    for (String str2 : split) {
                        int i11 = i(str2.trim());
                        if (i11 != 0) {
                            iArr2[i10] = i11;
                            i10++;
                        }
                    }
                    if (i10 != split.length) {
                        iArr2 = Arrays.copyOf(iArr2, i10);
                    }
                    kVar.i0 = iArr2;
                } else {
                    kVar.i0 = null;
                }
            }
        }
        lVar.f17721t0 = 0;
        Arrays.fill(lVar.f17720s0, (Object) null);
        if (kVar.i0 == null) {
            return;
        }
        while (true) {
            int[] iArr3 = kVar.i0;
            if (i3 >= iArr3.length) {
                return;
            }
            f fVar = (f) sparseArray.get(iArr3[i3]);
            if (fVar != null) {
                lVar.N(fVar);
            }
            i3++;
        }
    }

    public void m(f fVar, boolean z5) {
    }

    public void n() {
    }

    public void o(ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.e;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f1853f;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i10) {
        setMeasuredDimension(0, 0);
    }

    public void p(l lVar, SparseArray sparseArray) {
        lVar.f17721t0 = 0;
        Arrays.fill(lVar.f17720s0, (Object) null);
        for (int i3 = 0; i3 < this.f1850b; i3++) {
            lVar.N((f) sparseArray.get(this.f1849a[i3]));
        }
    }

    public final void q() {
        if (this.f1852d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof e) {
            ((e) layoutParams).f19323p0 = this.f1852d;
        }
    }

    public void setIds(String str) {
        this.e = str;
        if (str == null) {
            return;
        }
        int i3 = 0;
        this.f1850b = 0;
        while (true) {
            int indexOf = str.indexOf(44, i3);
            if (indexOf == -1) {
                b(str.substring(i3));
                return;
            } else {
                b(str.substring(i3, indexOf));
                i3 = indexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f1853f = str;
        if (str == null) {
            return;
        }
        int i3 = 0;
        this.f1850b = 0;
        while (true) {
            int indexOf = str.indexOf(44, i3);
            if (indexOf == -1) {
                d(str.substring(i3));
                return;
            } else {
                d(str.substring(i3, indexOf));
                i3 = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.e = null;
        this.f1850b = 0;
        for (int i3 : iArr) {
            c(i3);
        }
    }

    @Override // android.view.View
    public final void setTag(int i3, Object obj) {
        super.setTag(i3, obj);
        if (obj == null && this.e == null) {
            c(i3);
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1849a = new int[32];
        this.f1854g = null;
        this.f1855h = new HashMap();
        this.f1851c = context;
        k(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1849a = new int[32];
        this.f1854g = null;
        this.f1855h = new HashMap();
        this.f1851c = context;
        k(attributeSet);
    }
}
