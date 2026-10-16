package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public int f1071a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1072b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1073c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1074d;
    public Object e;

    /* renamed from: f, reason: collision with root package name */
    public Object f1075f;

    public w(View view) {
        this.f1071a = -1;
        this.f1072b = view;
        this.f1073c = y.a();
    }

    public static w e(Context context, int i3) {
        pd.a("Cannot create a CalendarItemStyle with a styleResId of 0", i3 != 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i3, R$styleable.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList a3 = com.google.android.gms.internal.mlkit_vision_barcode.t0.a(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList a10 = com.google.android.gms.internal.mlkit_vision_barcode.t0.a(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList a11 = com.google.android.gms.internal.mlkit_vision_barcode.t0.a(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        eb.m a12 = eb.m.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0), new eb.a(0)).a();
        obtainStyledAttributes.recycle();
        return new w(a3, a10, a11, dimensionPixelSize, a12, rect);
    }

    public void a() {
        View view = (View) this.f1072b;
        Drawable background = view.getBackground();
        if (background != null) {
            if (((n3) this.f1074d) != null) {
                if (((n3) this.f1075f) == null) {
                    this.f1075f = new n3();
                }
                n3 n3Var = (n3) this.f1075f;
                n3Var.f1004a = null;
                n3Var.f1007d = false;
                n3Var.f1005b = null;
                n3Var.f1006c = false;
                WeakHashMap weakHashMap = l1.z0.f15748a;
                ColorStateList g10 = l1.n0.g(view);
                if (g10 != null) {
                    n3Var.f1007d = true;
                    n3Var.f1004a = g10;
                }
                PorterDuff.Mode h4 = l1.n0.h(view);
                if (h4 != null) {
                    n3Var.f1006c = true;
                    n3Var.f1005b = h4;
                }
                if (n3Var.f1007d || n3Var.f1006c) {
                    y.e(background, n3Var, view.getDrawableState());
                    return;
                }
            }
            n3 n3Var2 = (n3) this.e;
            if (n3Var2 != null) {
                y.e(background, n3Var2, view.getDrawableState());
                return;
            }
            n3 n3Var3 = (n3) this.f1074d;
            if (n3Var3 != null) {
                y.e(background, n3Var3, view.getDrawableState());
            }
        }
    }

    public boolean b(int i3) {
        ArrayList arrayList = (ArrayList) this.f1074d;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            androidx.recyclerview.widget.a aVar = (androidx.recyclerview.widget.a) arrayList.get(i10);
            int i11 = aVar.f2509a;
            if (i11 != 8) {
                if (i11 == 1) {
                    int i12 = aVar.f2510b;
                    int i13 = aVar.f2512d + i12;
                    while (i12 < i13) {
                        if (h(i12, i10 + 1) == i3) {
                            return true;
                        }
                        i12++;
                    }
                } else {
                    continue;
                }
            } else {
                if (h(aVar.f2512d, i10 + 1) == i3) {
                    return true;
                }
            }
        }
        return false;
    }

    public void c() {
        ArrayList arrayList = (ArrayList) this.f1074d;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((androidx.recyclerview.widget.x0) this.e).a((androidx.recyclerview.widget.a) arrayList.get(i3));
        }
        r(arrayList);
        this.f1071a = 0;
    }

    public void d() {
        c();
        ArrayList arrayList = (ArrayList) this.f1073c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            androidx.recyclerview.widget.a aVar = (androidx.recyclerview.widget.a) arrayList.get(i3);
            int i10 = aVar.f2509a;
            androidx.recyclerview.widget.x0 x0Var = (androidx.recyclerview.widget.x0) this.e;
            if (i10 == 1) {
                x0Var.a(aVar);
                x0Var.c(aVar.f2510b, aVar.f2512d);
            } else if (i10 == 2) {
                x0Var.a(aVar);
                int i11 = aVar.f2510b;
                int i12 = aVar.f2512d;
                RecyclerView recyclerView = x0Var.f2801a;
                recyclerView.R(i11, i12, true);
                recyclerView.f2467j0 = true;
                recyclerView.f2460g0.f2786c += i12;
            } else if (i10 == 4) {
                x0Var.a(aVar);
                x0Var.b(aVar.f2510b, aVar.f2512d, aVar.f2511c);
            } else if (i10 == 8) {
                x0Var.a(aVar);
                x0Var.d(aVar.f2510b, aVar.f2512d);
            }
        }
        r(arrayList);
        this.f1071a = 0;
    }

    public void f(androidx.recyclerview.widget.a aVar) {
        int i3;
        int i10 = aVar.f2509a;
        if (i10 == 1 || i10 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int w8 = w(aVar.f2510b, i10);
        int i11 = aVar.f2510b;
        int i12 = aVar.f2509a;
        if (i12 == 2) {
            i3 = 0;
        } else {
            if (i12 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + aVar);
            }
            i3 = 1;
        }
        int i13 = 1;
        for (int i14 = 1; i14 < aVar.f2512d; i14++) {
            int w9 = w((i3 * i14) + aVar.f2510b, aVar.f2509a);
            int i15 = aVar.f2509a;
            if (i15 == 2 ? w9 != w8 : !(i15 == 4 && w9 == w8 + 1)) {
                androidx.recyclerview.widget.a m10 = m(aVar.f2511c, i15, w8, i13);
                g(m10, i11);
                m10.f2511c = null;
                ((k1.d) this.f1072b).c(m10);
                if (aVar.f2509a == 4) {
                    i11 += i13;
                }
                i13 = 1;
                w8 = w9;
            } else {
                i13++;
            }
        }
        Object obj = aVar.f2511c;
        aVar.f2511c = null;
        ((k1.d) this.f1072b).c(aVar);
        if (i13 > 0) {
            androidx.recyclerview.widget.a m11 = m(obj, aVar.f2509a, w8, i13);
            g(m11, i11);
            m11.f2511c = null;
            ((k1.d) this.f1072b).c(m11);
        }
    }

    public void g(androidx.recyclerview.widget.a aVar, int i3) {
        androidx.recyclerview.widget.x0 x0Var = (androidx.recyclerview.widget.x0) this.e;
        x0Var.a(aVar);
        int i10 = aVar.f2509a;
        if (i10 != 2) {
            if (i10 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            x0Var.b(i3, aVar.f2512d, aVar.f2511c);
        } else {
            int i11 = aVar.f2512d;
            RecyclerView recyclerView = x0Var.f2801a;
            recyclerView.R(i3, i11, true);
            recyclerView.f2467j0 = true;
            recyclerView.f2460g0.f2786c += i11;
        }
    }

    public int h(int i3, int i10) {
        ArrayList arrayList = (ArrayList) this.f1074d;
        int size = arrayList.size();
        while (i10 < size) {
            androidx.recyclerview.widget.a aVar = (androidx.recyclerview.widget.a) arrayList.get(i10);
            int i11 = aVar.f2509a;
            if (i11 == 8) {
                int i12 = aVar.f2510b;
                if (i12 == i3) {
                    i3 = aVar.f2512d;
                } else {
                    if (i12 < i3) {
                        i3--;
                    }
                    if (aVar.f2512d <= i3) {
                        i3++;
                    }
                }
            } else {
                int i13 = aVar.f2510b;
                if (i13 > i3) {
                    continue;
                } else if (i11 == 2) {
                    int i14 = aVar.f2512d;
                    if (i3 < i13 + i14) {
                        return -1;
                    }
                    i3 -= i14;
                } else if (i11 == 1) {
                    i3 += aVar.f2512d;
                }
            }
            i10++;
        }
        return i3;
    }

    public ColorStateList i() {
        n3 n3Var = (n3) this.e;
        if (n3Var != null) {
            return n3Var.f1004a;
        }
        return null;
    }

    public PorterDuff.Mode j() {
        n3 n3Var = (n3) this.e;
        if (n3Var != null) {
            return n3Var.f1005b;
        }
        return null;
    }

    public boolean k() {
        return ((ArrayList) this.f1073c).size() > 0;
    }

    public void l(AttributeSet attributeSet, int i3) {
        ColorStateList f2;
        View view = (View) this.f1072b;
        de.o I = de.o.I(view.getContext(), attributeSet, androidx.appcompat.R$styleable.ViewBackgroundHelper, i3);
        TypedArray typedArray = (TypedArray) I.f12378c;
        View view2 = (View) this.f1072b;
        l1.z0.m(view2, view2.getContext(), androidx.appcompat.R$styleable.ViewBackgroundHelper, attributeSet, (TypedArray) I.f12378c, i3);
        try {
            if (typedArray.hasValue(androidx.appcompat.R$styleable.ViewBackgroundHelper_android_background)) {
                this.f1071a = typedArray.getResourceId(androidx.appcompat.R$styleable.ViewBackgroundHelper_android_background, -1);
                y yVar = (y) this.f1073c;
                Context context = view.getContext();
                int i10 = this.f1071a;
                synchronized (yVar) {
                    f2 = yVar.f1125a.f(context, i10);
                }
                if (f2 != null) {
                    s(f2);
                }
            }
            if (typedArray.hasValue(androidx.appcompat.R$styleable.ViewBackgroundHelper_backgroundTint)) {
                l1.n0.q(view, I.v(androidx.appcompat.R$styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (typedArray.hasValue(androidx.appcompat.R$styleable.ViewBackgroundHelper_backgroundTintMode)) {
                l1.n0.r(view, n1.c(typedArray.getInt(androidx.appcompat.R$styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            I.K();
        } catch (Throwable th2) {
            I.K();
            throw th2;
        }
    }

    public androidx.recyclerview.widget.a m(Object obj, int i3, int i10, int i11) {
        androidx.recyclerview.widget.a aVar = (androidx.recyclerview.widget.a) ((k1.d) this.f1072b).a();
        if (aVar != null) {
            aVar.f2509a = i3;
            aVar.f2510b = i10;
            aVar.f2512d = i11;
            aVar.f2511c = obj;
            return aVar;
        }
        androidx.recyclerview.widget.a aVar2 = new androidx.recyclerview.widget.a();
        aVar2.f2509a = i3;
        aVar2.f2510b = i10;
        aVar2.f2512d = i11;
        aVar2.f2511c = obj;
        return aVar2;
    }

    public void n() {
        this.f1071a = -1;
        s(null);
        a();
    }

    public void o(int i3) {
        ColorStateList colorStateList;
        this.f1071a = i3;
        y yVar = (y) this.f1073c;
        if (yVar != null) {
            Context context = ((View) this.f1072b).getContext();
            synchronized (yVar) {
                colorStateList = yVar.f1125a.f(context, i3);
            }
        } else {
            colorStateList = null;
        }
        s(colorStateList);
        a();
    }

    public void p(androidx.recyclerview.widget.a aVar) {
        ((ArrayList) this.f1074d).add(aVar);
        int i3 = aVar.f2509a;
        androidx.recyclerview.widget.x0 x0Var = (androidx.recyclerview.widget.x0) this.e;
        if (i3 == 1) {
            x0Var.c(aVar.f2510b, aVar.f2512d);
            return;
        }
        if (i3 == 2) {
            int i10 = aVar.f2510b;
            int i11 = aVar.f2512d;
            RecyclerView recyclerView = x0Var.f2801a;
            recyclerView.R(i10, i11, false);
            recyclerView.f2467j0 = true;
            return;
        }
        if (i3 == 4) {
            x0Var.b(aVar.f2510b, aVar.f2512d, aVar.f2511c);
        } else if (i3 == 8) {
            x0Var.d(aVar.f2510b, aVar.f2512d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + aVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:157:0x0216, code lost:
    
        if (((java.util.ArrayList) r8.e.f12379d).contains(r10.itemView) != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0287, code lost:
    
        if (((java.util.ArrayList) r12.e.f12379d).contains(r14.itemView) != false) goto L164;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x000d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0135 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0121 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q() {
        /*
            Method dump skipped, instructions count: 750
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.w.q():void");
    }

    public void r(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            androidx.recyclerview.widget.a aVar = (androidx.recyclerview.widget.a) arrayList.get(i3);
            aVar.f2511c = null;
            ((k1.d) this.f1072b).c(aVar);
        }
        arrayList.clear();
    }

    public void s(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((n3) this.f1074d) == null) {
                this.f1074d = new n3();
            }
            n3 n3Var = (n3) this.f1074d;
            n3Var.f1004a = colorStateList;
            n3Var.f1007d = true;
        } else {
            this.f1074d = null;
        }
        a();
    }

    public void t(ColorStateList colorStateList) {
        if (((n3) this.e) == null) {
            this.e = new n3();
        }
        n3 n3Var = (n3) this.e;
        n3Var.f1004a = colorStateList;
        n3Var.f1007d = true;
        a();
    }

    public void u(PorterDuff.Mode mode) {
        if (((n3) this.e) == null) {
            this.e = new n3();
        }
        n3 n3Var = (n3) this.e;
        n3Var.f1005b = mode;
        n3Var.f1006c = true;
        a();
    }

    public void v(TextView textView) {
        eb.h hVar = new eb.h();
        eb.h hVar2 = new eb.h();
        eb.m mVar = (eb.m) this.f1075f;
        hVar.setShapeAppearanceModel(mVar);
        hVar2.setShapeAppearanceModel(mVar);
        hVar.l((ColorStateList) this.f1074d);
        hVar.f12505a.f12496j = this.f1071a;
        hVar.invalidateSelf();
        hVar.q((ColorStateList) this.e);
        ColorStateList colorStateList = (ColorStateList) this.f1073c;
        textView.setTextColor(colorStateList);
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateList.withAlpha(30), hVar, hVar2);
        Rect rect = (Rect) this.f1072b;
        InsetDrawable insetDrawable = new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
        WeakHashMap weakHashMap = l1.z0.f15748a;
        l1.h0.q(textView, insetDrawable);
    }

    public int w(int i3, int i10) {
        int i11;
        int i12;
        ArrayList arrayList = (ArrayList) this.f1074d;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            androidx.recyclerview.widget.a aVar = (androidx.recyclerview.widget.a) arrayList.get(size);
            int i13 = aVar.f2509a;
            if (i13 == 8) {
                int i14 = aVar.f2510b;
                int i15 = aVar.f2512d;
                if (i14 < i15) {
                    i12 = i14;
                    i11 = i15;
                } else {
                    i11 = i14;
                    i12 = i15;
                }
                if (i3 < i12 || i3 > i11) {
                    if (i3 < i14) {
                        if (i10 == 1) {
                            aVar.f2510b = i14 + 1;
                            aVar.f2512d = i15 + 1;
                        } else if (i10 == 2) {
                            aVar.f2510b = i14 - 1;
                            aVar.f2512d = i15 - 1;
                        }
                    }
                } else if (i12 == i14) {
                    if (i10 == 1) {
                        aVar.f2512d = i15 + 1;
                    } else if (i10 == 2) {
                        aVar.f2512d = i15 - 1;
                    }
                    i3++;
                } else {
                    if (i10 == 1) {
                        aVar.f2510b = i14 + 1;
                    } else if (i10 == 2) {
                        aVar.f2510b = i14 - 1;
                    }
                    i3--;
                }
            } else {
                int i16 = aVar.f2510b;
                if (i16 <= i3) {
                    if (i13 == 1) {
                        i3 -= aVar.f2512d;
                    } else if (i13 == 2) {
                        i3 += aVar.f2512d;
                    }
                } else if (i10 == 1) {
                    aVar.f2510b = i16 + 1;
                } else if (i10 == 2) {
                    aVar.f2510b = i16 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            androidx.recyclerview.widget.a aVar2 = (androidx.recyclerview.widget.a) arrayList.get(size2);
            if (aVar2.f2509a == 8) {
                int i17 = aVar2.f2512d;
                if (i17 == aVar2.f2510b || i17 < 0) {
                    arrayList.remove(size2);
                    aVar2.f2511c = null;
                    ((k1.d) this.f1072b).c(aVar2);
                }
            } else if (aVar2.f2512d <= 0) {
                arrayList.remove(size2);
                aVar2.f2511c = null;
                ((k1.d) this.f1072b).c(aVar2);
            }
        }
        return i3;
    }

    public w(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i3, eb.m mVar, Rect rect) {
        pd.d(rect.left);
        pd.d(rect.top);
        pd.d(rect.right);
        pd.d(rect.bottom);
        this.f1072b = rect;
        this.f1073c = colorStateList2;
        this.f1074d = colorStateList;
        this.e = colorStateList3;
        this.f1071a = i3;
        this.f1075f = mVar;
    }

    public w(androidx.recyclerview.widget.x0 x0Var) {
        this.f1072b = new k1.d(30);
        this.f1073c = new ArrayList();
        this.f1074d = new ArrayList();
        this.f1071a = 0;
        this.e = x0Var;
        this.f1075f = new androidx.recyclerview.widget.b(this);
    }
}
