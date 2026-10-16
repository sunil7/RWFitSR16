package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ListPopupWindow implements h.b0 {
    public static final Method A;
    public static final Method B;

    /* renamed from: a, reason: collision with root package name */
    public final Context f756a;

    /* renamed from: b, reason: collision with root package name */
    public ListAdapter f757b;

    /* renamed from: c, reason: collision with root package name */
    public t1 f758c;

    /* renamed from: d, reason: collision with root package name */
    public final int f759d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f760f;

    /* renamed from: g, reason: collision with root package name */
    public int f761g;

    /* renamed from: h, reason: collision with root package name */
    public final int f762h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f763i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f764j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f765k;

    /* renamed from: l, reason: collision with root package name */
    public int f766l;

    /* renamed from: m, reason: collision with root package name */
    public final int f767m;

    /* renamed from: n, reason: collision with root package name */
    public d2 f768n;

    /* renamed from: o, reason: collision with root package name */
    public View f769o;

    /* renamed from: p, reason: collision with root package name */
    public AdapterView.OnItemClickListener f770p;

    /* renamed from: q, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f771q;
    public final c2 r;

    /* renamed from: s, reason: collision with root package name */
    public final f2 f772s;

    /* renamed from: t, reason: collision with root package name */
    public final e2 f773t;

    /* renamed from: u, reason: collision with root package name */
    public final c2 f774u;

    /* renamed from: v, reason: collision with root package name */
    public final Handler f775v;

    /* renamed from: w, reason: collision with root package name */
    public final Rect f776w;

    /* renamed from: x, reason: collision with root package name */
    public Rect f777x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f778y;

    /* renamed from: z, reason: collision with root package name */
    public final c0 f779z;

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                A = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                B = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R$attr.listPopupWindowStyle);
    }

    @Override // h.b0
    public final boolean a() {
        return this.f779z.isShowing();
    }

    public final int b() {
        return this.f760f;
    }

    public final Drawable c() {
        return this.f779z.getBackground();
    }

    @Override // h.b0
    public final void d() {
        int i3;
        int paddingBottom;
        t1 t1Var;
        t1 t1Var2 = this.f758c;
        c0 c0Var = this.f779z;
        Context context = this.f756a;
        if (t1Var2 == null) {
            t1 q5 = q(context, !this.f778y);
            this.f758c = q5;
            q5.setAdapter(this.f757b);
            this.f758c.setOnItemClickListener(this.f770p);
            this.f758c.setFocusable(true);
            this.f758c.setFocusableInTouchMode(true);
            this.f758c.setOnItemSelectedListener(new z1(this, 0));
            this.f758c.setOnScrollListener(this.f773t);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f771q;
            if (onItemSelectedListener != null) {
                this.f758c.setOnItemSelectedListener(onItemSelectedListener);
            }
            c0Var.setContentView(this.f758c);
        }
        Drawable background = c0Var.getBackground();
        Rect rect = this.f776w;
        if (background != null) {
            background.getPadding(rect);
            int i10 = rect.top;
            i3 = rect.bottom + i10;
            if (!this.f763i) {
                this.f761g = -i10;
            }
        } else {
            rect.setEmpty();
            i3 = 0;
        }
        int a3 = a2.a(c0Var, this.f769o, this.f761g, c0Var.getInputMethodMode() == 2);
        int i11 = this.f759d;
        if (i11 == -1) {
            paddingBottom = a3 + i3;
        } else {
            int i12 = this.e;
            int a10 = this.f758c.a(i12 != -2 ? i12 != -1 ? View.MeasureSpec.makeMeasureSpec(i12, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), a3);
            paddingBottom = a10 + (a10 > 0 ? this.f758c.getPaddingBottom() + this.f758c.getPaddingTop() + i3 : 0);
        }
        boolean z5 = this.f779z.getInputMethodMode() == 2;
        androidx.core.widget.o.d(c0Var, this.f762h);
        if (c0Var.isShowing()) {
            View view = this.f769o;
            WeakHashMap weakHashMap = l1.z0.f15748a;
            if (l1.k0.b(view)) {
                int i13 = this.e;
                if (i13 == -1) {
                    i13 = -1;
                } else if (i13 == -2) {
                    i13 = this.f769o.getWidth();
                }
                if (i11 == -1) {
                    i11 = z5 ? paddingBottom : -1;
                    if (z5) {
                        c0Var.setWidth(this.e == -1 ? -1 : 0);
                        c0Var.setHeight(0);
                    } else {
                        c0Var.setWidth(this.e == -1 ? -1 : 0);
                        c0Var.setHeight(-1);
                    }
                } else if (i11 == -2) {
                    i11 = paddingBottom;
                }
                c0Var.setOutsideTouchable(true);
                int i14 = i13;
                c0Var.update(this.f769o, this.f760f, this.f761g, i14 < 0 ? -1 : i14, i11 < 0 ? -1 : i11);
                return;
            }
            return;
        }
        int i15 = this.e;
        if (i15 == -1) {
            i15 = -1;
        } else if (i15 == -2) {
            i15 = this.f769o.getWidth();
        }
        if (i11 == -1) {
            i11 = -1;
        } else if (i11 == -2) {
            i11 = paddingBottom;
        }
        c0Var.setWidth(i15);
        c0Var.setHeight(i11);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = A;
            if (method != null) {
                try {
                    method.invoke(c0Var, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            b2.b(c0Var, true);
        }
        c0Var.setOutsideTouchable(true);
        c0Var.setTouchInterceptor(this.f772s);
        if (this.f765k) {
            androidx.core.widget.o.c(c0Var, this.f764j);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = B;
            if (method2 != null) {
                try {
                    method2.invoke(c0Var, this.f777x);
                } catch (Exception e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
        } else {
            b2.a(c0Var, this.f777x);
        }
        androidx.core.widget.n.a(c0Var, this.f769o, this.f760f, this.f761g, this.f766l);
        this.f758c.setSelection(-1);
        if ((!this.f778y || this.f758c.isInTouchMode()) && (t1Var = this.f758c) != null) {
            t1Var.setListSelectionHidden(true);
            t1Var.requestLayout();
        }
        if (this.f778y) {
            return;
        }
        this.f775v.post(this.f774u);
    }

    @Override // h.b0
    public final void dismiss() {
        c0 c0Var = this.f779z;
        c0Var.dismiss();
        c0Var.setContentView(null);
        this.f758c = null;
        this.f775v.removeCallbacks(this.r);
    }

    @Override // h.b0
    public final t1 f() {
        return this.f758c;
    }

    public final void g(Drawable drawable) {
        this.f779z.setBackgroundDrawable(drawable);
    }

    public final void h(int i3) {
        this.f761g = i3;
        this.f763i = true;
    }

    public final void j(int i3) {
        this.f760f = i3;
    }

    public final int l() {
        if (this.f763i) {
            return this.f761g;
        }
        return 0;
    }

    public void p(ListAdapter listAdapter) {
        d2 d2Var = this.f768n;
        if (d2Var == null) {
            this.f768n = new d2(this, 0);
        } else {
            ListAdapter listAdapter2 = this.f757b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(d2Var);
            }
        }
        this.f757b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f768n);
        }
        t1 t1Var = this.f758c;
        if (t1Var != null) {
            t1Var.setAdapter(this.f757b);
        }
    }

    public t1 q(Context context, boolean z5) {
        return new t1(context, z5);
    }

    public final void r(int i3) {
        Drawable background = this.f779z.getBackground();
        if (background == null) {
            this.e = i3;
            return;
        }
        Rect rect = this.f776w;
        background.getPadding(rect);
        this.e = rect.left + rect.right + i3;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f779z.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f770p = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f771q = onItemSelectedListener;
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i3, int i10) {
        Drawable drawable;
        int resourceId;
        this.f759d = -2;
        this.e = -2;
        this.f762h = 1002;
        this.f766l = 0;
        this.f767m = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.r = new c2(this, 1);
        this.f772s = new f2(this, 0);
        this.f773t = new e2(this);
        this.f774u = new c2(this, 0);
        this.f776w = new Rect();
        this.f756a = context;
        this.f775v = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i3, 0);
        this.f760f = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f761g = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f763i = true;
        }
        obtainStyledAttributes.recycle();
        c0 c0Var = new c0(context, attributeSet, i3, 0);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.PopupWindow, i3, 0);
        if (obtainStyledAttributes2.hasValue(R$styleable.PopupWindow_overlapAnchor)) {
            androidx.core.widget.o.c(c0Var, obtainStyledAttributes2.getBoolean(R$styleable.PopupWindow_overlapAnchor, false));
        }
        int i11 = R$styleable.PopupWindow_android_popupBackground;
        if (obtainStyledAttributes2.hasValue(i11) && (resourceId = obtainStyledAttributes2.getResourceId(i11, 0)) != 0) {
            drawable = pb.b(context, resourceId);
        } else {
            drawable = obtainStyledAttributes2.getDrawable(i11);
        }
        c0Var.setBackgroundDrawable(drawable);
        obtainStyledAttributes2.recycle();
        this.f779z = c0Var;
        c0Var.setInputMethodMode(1);
    }
}
