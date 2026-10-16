package x0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.R$styleable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class f extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public c f19716a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f19717b;

    /* renamed from: c, reason: collision with root package name */
    public final int f19718c;

    /* renamed from: d, reason: collision with root package name */
    public int f19719d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f19720f;

    /* renamed from: g, reason: collision with root package name */
    public final int f19721g;

    /* renamed from: h, reason: collision with root package name */
    public int f19722h;

    /* renamed from: i, reason: collision with root package name */
    public int f19723i;

    /* renamed from: j, reason: collision with root package name */
    public int f19724j;

    /* renamed from: k, reason: collision with root package name */
    public View f19725k;

    /* renamed from: l, reason: collision with root package name */
    public View f19726l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f19727m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f19728n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f19729o;

    /* renamed from: p, reason: collision with root package name */
    public final Rect f19730p;

    public f() {
        super(-2, -2);
        this.f19717b = false;
        this.f19718c = 0;
        this.f19719d = 0;
        this.e = -1;
        this.f19720f = -1;
        this.f19721g = 0;
        this.f19722h = 0;
        this.f19730p = new Rect();
    }

    public final boolean a(int i3) {
        if (i3 == 0) {
            return this.f19727m;
        }
        if (i3 != 1) {
            return false;
        }
        return this.f19728n;
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c cVar;
        this.f19717b = false;
        this.f19718c = 0;
        this.f19719d = 0;
        this.e = -1;
        this.f19720f = -1;
        this.f19721g = 0;
        this.f19722h = 0;
        this.f19730p = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
        this.f19718c = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
        this.f19720f = obtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_Layout_layout_anchor, -1);
        this.f19719d = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
        this.e = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_keyline, -1);
        this.f19721g = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
        this.f19722h = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
        boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.CoordinatorLayout_Layout_layout_behavior);
        this.f19717b = hasValue;
        if (hasValue) {
            String string = obtainStyledAttributes.getString(R$styleable.CoordinatorLayout_Layout_layout_behavior);
            String str = CoordinatorLayout.f1882t;
            if (TextUtils.isEmpty(string)) {
                cVar = null;
            } else {
                if (string.startsWith(".")) {
                    string = context.getPackageName() + string;
                } else if (string.indexOf(46) < 0) {
                    String str2 = CoordinatorLayout.f1882t;
                    if (!TextUtils.isEmpty(str2)) {
                        string = str2 + '.' + string;
                    }
                }
                try {
                    ThreadLocal threadLocal = CoordinatorLayout.f1884v;
                    Map map = (Map) threadLocal.get();
                    if (map == null) {
                        map = new HashMap();
                        threadLocal.set(map);
                    }
                    Constructor<?> constructor = (Constructor) map.get(string);
                    if (constructor == null) {
                        constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.f1883u);
                        constructor.setAccessible(true);
                        map.put(string, constructor);
                    }
                    cVar = (c) constructor.newInstance(context, attributeSet);
                } catch (Exception e) {
                    throw new RuntimeException(l0.n("Could not inflate Behavior subclass ", string), e);
                }
            }
            this.f19716a = cVar;
        }
        obtainStyledAttributes.recycle();
        c cVar2 = this.f19716a;
        if (cVar2 != null) {
            cVar2.c(this);
        }
    }

    public f(f fVar) {
        super((ViewGroup.MarginLayoutParams) fVar);
        this.f19717b = false;
        this.f19718c = 0;
        this.f19719d = 0;
        this.e = -1;
        this.f19720f = -1;
        this.f19721g = 0;
        this.f19722h = 0;
        this.f19730p = new Rect();
    }

    public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f19717b = false;
        this.f19718c = 0;
        this.f19719d = 0;
        this.e = -1;
        this.f19720f = -1;
        this.f19721g = 0;
        this.f19722h = 0;
        this.f19730p = new Rect();
    }

    public f(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f19717b = false;
        this.f19718c = 0;
        this.f19719d = 0;
        this.e = -1;
        this.f19720f = -1;
        this.f19721g = 0;
        this.f19722h = 0;
        this.f19730p = new Rect();
    }
}
