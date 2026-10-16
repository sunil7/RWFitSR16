package l1;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R$id;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f15681c = new View.AccessibilityDelegate();

    /* renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f15682a;

    /* renamed from: b, reason: collision with root package name */
    public final a f15683b;

    public c() {
        this(f15681c);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f15682a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public com.example.test.ui.device.activity.e0 b(View view) {
        AccessibilityNodeProvider a3 = b.a(this.f15682a, view);
        if (a3 != null) {
            return new com.example.test.ui.device.activity.e0(a3, 25);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f15682a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, m1.d dVar) {
        this.f15682a.onInitializeAccessibilityNodeInfo(view, dVar.f15938a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.f15682a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f15682a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean g(View view, int i3, Bundle bundle) {
        boolean z5;
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List list = (List) view.getTag(R$id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        boolean z6 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= list.size()) {
                break;
            }
            m1.c cVar = (m1.c) list.get(i10);
            if (cVar.a() == i3) {
                m1.o oVar = cVar.f15937d;
                if (oVar != null) {
                    Class cls = cVar.f15936c;
                    if (cls != null) {
                        try {
                            if (cls.getDeclaredConstructor(null).newInstance(null) == null) {
                                throw null;
                            }
                            throw new ClassCastException();
                        } catch (Exception e) {
                            Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(cls.getName()), e);
                        }
                    }
                    z5 = oVar.g(view);
                }
            } else {
                i10++;
            }
        }
        z5 = false;
        if (!z5) {
            z5 = b.b(this.f15682a, view, i3, bundle);
        }
        if (z5 || i3 != R$id.accessibility_action_clickable_span || bundle == null) {
            return z5;
        }
        int i11 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i11)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
            CharSequence text = view.createAccessibilityNodeInfo().getText();
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            int i12 = 0;
            while (true) {
                if (clickableSpanArr == null || i12 >= clickableSpanArr.length) {
                    break;
                }
                if (clickableSpan.equals(clickableSpanArr[i12])) {
                    clickableSpan.onClick(view);
                    z6 = true;
                    break;
                }
                i12++;
            }
        }
        return z6;
    }

    public void h(View view, int i3) {
        this.f15682a.sendAccessibilityEvent(view, i3);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.f15682a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public c(View.AccessibilityDelegate accessibilityDelegate) {
        this.f15682a = accessibilityDelegate;
        this.f15683b = new a(this);
    }
}
