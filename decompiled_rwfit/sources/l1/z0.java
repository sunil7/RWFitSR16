package l1;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.R$id;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class z0 {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap f15748a;

    /* renamed from: b, reason: collision with root package name */
    public static Field f15749b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f15750c;

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f15751d;
    public static final c0 e;

    /* renamed from: f, reason: collision with root package name */
    public static final e0 f15752f;

    static {
        new AtomicInteger(1);
        f15748a = null;
        f15750c = false;
        f15751d = new int[]{R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31};
        e = new c0();
        f15752f = new e0();
    }

    public static g1 a(View view) {
        if (f15748a == null) {
            f15748a = new WeakHashMap();
        }
        g1 g1Var = (g1) f15748a.get(view);
        if (g1Var != null) {
            return g1Var;
        }
        g1 g1Var2 = new g1(view);
        f15748a.put(view, g1Var2);
        return g1Var2;
    }

    public static x1 b(View view, x1 x1Var) {
        WindowInsets g10 = x1Var.g();
        if (g10 != null) {
            WindowInsets a3 = l0.a(view, g10);
            if (!a3.equals(g10)) {
                return x1.h(a3, view);
            }
        }
        return x1Var;
    }

    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = y0.f15739d;
        y0 y0Var = (y0) view.getTag(R$id.tag_unhandled_key_event_manager);
        if (y0Var == null) {
            y0Var = new y0();
            y0Var.f15740a = null;
            y0Var.f15741b = null;
            y0Var.f15742c = null;
            view.setTag(R$id.tag_unhandled_key_event_manager, y0Var);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = y0Var.f15740a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = y0.f15739d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (y0Var.f15740a == null) {
                            y0Var.f15740a = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = y0.f15739d;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                y0Var.f15740a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    y0Var.f15740a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }
        View a3 = y0Var.a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (a3 != null && !KeyEvent.isModifierKey(keyCode)) {
                if (y0Var.f15741b == null) {
                    y0Var.f15741b = new SparseArray();
                }
                y0Var.f15741b.put(keyCode, new WeakReference(a3));
            }
        }
        return a3 != null;
    }

    public static View.AccessibilityDelegate d(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return t0.a(view);
        }
        if (f15750c) {
            return null;
        }
        if (f15749b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f15749b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f15750c = true;
                return null;
            }
        }
        try {
            Object obj = f15749b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f15750c = true;
            return null;
        }
    }

    public static ArrayList e(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R$id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R$id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static String[] f(AppCompatEditText appCompatEditText) {
        return Build.VERSION.SDK_INT >= 31 ? v0.a(appCompatEditText) : (String[]) appCompatEditText.getTag(R$id.tag_on_receive_content_mime_types);
    }

    public static void g(int i3, View view) {
        Object tag;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            int i10 = R$id.tag_accessibility_pane_title;
            int i11 = Build.VERSION.SDK_INT;
            CharSequence charSequence = null;
            if (i11 >= 28) {
                tag = s0.b(view);
            } else {
                tag = view.getTag(i10);
                if (!CharSequence.class.isInstance(tag)) {
                    tag = null;
                }
            }
            boolean z5 = ((CharSequence) tag) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (k0.a(view) != 0 || z5) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z5 ? 32 : 2048);
                k0.g(obtain, i3);
                if (z5) {
                    List<CharSequence> text = obtain.getText();
                    int i12 = R$id.tag_accessibility_pane_title;
                    if (i11 >= 28) {
                        charSequence = s0.b(view);
                    } else {
                        Object tag2 = view.getTag(i12);
                        if (CharSequence.class.isInstance(tag2)) {
                            charSequence = tag2;
                        }
                    }
                    text.add(charSequence);
                    if (h0.c(view) == 0) {
                        h0.s(view, 1);
                    }
                    ViewParent parent = view.getParent();
                    while (true) {
                        if (!(parent instanceof View)) {
                            break;
                        }
                        if (h0.c((View) parent) == 4) {
                            h0.s(view, 2);
                            break;
                        }
                        parent = parent.getParent();
                    }
                }
                view.sendAccessibilityEventUnchecked(obtain);
                return;
            }
            if (i3 != 32) {
                if (view.getParent() != null) {
                    try {
                        k0.e(view.getParent(), view, view, i3);
                        return;
                    } catch (AbstractMethodError e10) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e10);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(obtain2);
            obtain2.setEventType(32);
            k0.g(obtain2, i3);
            obtain2.setSource(view);
            view.onPopulateAccessibilityEvent(obtain2);
            List<CharSequence> text2 = obtain2.getText();
            int i13 = R$id.tag_accessibility_pane_title;
            if (i11 >= 28) {
                charSequence = s0.b(view);
            } else {
                Object tag3 = view.getTag(i13);
                if (CharSequence.class.isInstance(tag3)) {
                    charSequence = tag3;
                }
            }
            text2.add(charSequence);
            accessibilityManager.sendAccessibilityEvent(obtain2);
        }
    }

    public static x1 h(View view, x1 x1Var) {
        WindowInsets g10 = x1Var.g();
        if (g10 != null) {
            WindowInsets b3 = l0.b(view, g10);
            if (!b3.equals(g10)) {
                return x1.h(b3, view);
            }
        }
        return x1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static h i(View view, h hVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + hVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return v0.b(view, hVar);
        }
        x xVar = (x) view.getTag(R$id.tag_on_receive_content_listener);
        y yVar = e;
        if (xVar == null) {
            if (view instanceof y) {
                yVar = (y) view;
            }
            return yVar.a(hVar);
        }
        h a3 = ((androidx.core.widget.v) xVar).a(view, hVar);
        if (a3 == null) {
            return null;
        }
        if (view instanceof y) {
            yVar = (y) view;
        }
        return yVar.a(a3);
    }

    public static void j(int i3, View view) {
        k(i3, view);
        g(0, view);
    }

    public static void k(int i3, View view) {
        ArrayList e10 = e(view);
        for (int i10 = 0; i10 < e10.size(); i10++) {
            if (((m1.c) e10.get(i10)).a() == i3) {
                e10.remove(i10);
                return;
            }
        }
    }

    public static void l(View view, m1.c cVar, m1.o oVar) {
        if (oVar == null) {
            j(cVar.a(), view);
            return;
        }
        m1.c cVar2 = new m1.c(null, cVar.f15935b, null, oVar, cVar.f15936c);
        View.AccessibilityDelegate d5 = d(view);
        c cVar3 = d5 == null ? null : d5 instanceof a ? ((a) d5).f15676a : new c(d5);
        if (cVar3 == null) {
            cVar3 = new c();
        }
        n(view, cVar3);
        k(cVar2.a(), view);
        e(view).add(cVar2);
        g(0, view);
    }

    public static void m(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            t0.c(view, context, iArr, attributeSet, typedArray, i3, 0);
        }
    }

    public static void n(View view, c cVar) {
        if (cVar == null && (d(view) instanceof a)) {
            cVar = new c();
        }
        view.setAccessibilityDelegate(cVar == null ? null : cVar.f15683b);
    }

    public static void o(View view, CharSequence charSequence) {
        new d0(R$id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).d(view, charSequence);
        e0 e0Var = f15752f;
        if (charSequence == null) {
            e0Var.f15685a.remove(view);
            view.removeOnAttachStateChangeListener(e0Var);
            h0.o(view.getViewTreeObserver(), e0Var);
        } else {
            e0Var.f15685a.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(e0Var);
            if (k0.b(view)) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(e0Var);
            }
        }
    }
}
