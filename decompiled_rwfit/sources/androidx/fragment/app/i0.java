package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i0 implements LayoutInflater.Factory2 {

    /* renamed from: a, reason: collision with root package name */
    public final t0 f2201a;

    public i0(t0 t0Var) {
        this.f2201a = t0Var;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z5;
        a1 f2;
        View view2;
        boolean equals = FragmentContainerView.class.getName().equals(str);
        t0 t0Var = this.f2201a;
        if (equals) {
            FragmentContainerView fragmentContainerView = new FragmentContainerView(context, attributeSet);
            fragmentContainerView.f2098d = true;
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FragmentContainerView);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_name);
            }
            String string = obtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_tag);
            obtainStyledAttributes.recycle();
            int id2 = fragmentContainerView.getId();
            Fragment v6 = t0Var.v(id2);
            if (classAttribute != null && v6 == null) {
                if (id2 <= 0) {
                    throw new IllegalStateException(com.google.android.gms.internal.mlkit_vision_barcode.l0.o("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
                }
                m0 y4 = t0Var.y();
                context.getClassLoader();
                Fragment instantiate = Fragment.instantiate(y4.f2223a.f2283o.f2182b, classAttribute, null);
                instantiate.onInflate(context, attributeSet, (Bundle) null);
                a aVar = new a(t0Var);
                aVar.f2139o = true;
                instantiate.mContainer = fragmentContainerView;
                aVar.e(fragmentContainerView.getId(), instantiate, string, 1);
                if (aVar.f2131g) {
                    throw new IllegalStateException("This transaction is already being added to the back stack");
                }
                aVar.f2140p.t(aVar, true);
            }
            ArrayList d5 = t0Var.f2272c.d();
            int size = d5.size();
            while (r1 < size) {
                Object obj = d5.get(r1);
                r1++;
                a1 a1Var = (a1) obj;
                Fragment fragment = a1Var.f2145c;
                if (fragment.mContainerId == fragmentContainerView.getId() && (view2 = fragment.mView) != null && view2.getParent() == null) {
                    fragment.mContainer = fragmentContainerView;
                    a1Var.a();
                }
            }
            return fragmentContainerView;
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes2.getString(R$styleable.Fragment_android_name);
            }
            int resourceId = obtainStyledAttributes2.getResourceId(R$styleable.Fragment_android_id, -1);
            String string2 = obtainStyledAttributes2.getString(R$styleable.Fragment_android_tag);
            obtainStyledAttributes2.recycle();
            if (attributeValue != null) {
                try {
                    z5 = Fragment.class.isAssignableFrom(m0.a(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    z5 = false;
                }
                if (z5) {
                    r1 = view != null ? view.getId() : 0;
                    if (r1 == -1 && resourceId == -1 && string2 == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    Fragment v9 = resourceId != -1 ? t0Var.v(resourceId) : null;
                    if (v9 == null && string2 != null) {
                        v9 = t0Var.w(string2);
                    }
                    if (v9 == null && r1 != -1) {
                        v9 = t0Var.v(r1);
                    }
                    if (v9 == null) {
                        m0 y10 = t0Var.y();
                        context.getClassLoader();
                        v9 = Fragment.instantiate(y10.f2223a.f2283o.f2182b, attributeValue, null);
                        v9.mFromLayout = true;
                        v9.mFragmentId = resourceId != 0 ? resourceId : r1;
                        v9.mContainerId = r1;
                        v9.mTag = string2;
                        v9.mInLayout = true;
                        v9.mFragmentManager = t0Var;
                        g0 g0Var = t0Var.f2283o;
                        v9.mHost = g0Var;
                        v9.onInflate((Context) g0Var.f2182b, attributeSet, v9.mSavedFragmentState);
                        f2 = t0Var.a(v9);
                        if (t0.B(2)) {
                            Log.v("FragmentManager", "Fragment " + v9 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        if (v9.mInLayout) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(r1) + " with another fragment for " + attributeValue);
                        }
                        v9.mInLayout = true;
                        v9.mFragmentManager = t0Var;
                        g0 g0Var2 = t0Var.f2283o;
                        v9.mHost = g0Var2;
                        v9.onInflate((Context) g0Var2.f2182b, attributeSet, v9.mSavedFragmentState);
                        f2 = t0Var.f(v9);
                        if (t0.B(2)) {
                            Log.v("FragmentManager", "Retained Fragment " + v9 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    }
                    v9.mContainer = (ViewGroup) view;
                    f2.j();
                    f2.i();
                    View view3 = v9.mView;
                    if (view3 == null) {
                        throw new IllegalStateException(com.google.android.gms.internal.mlkit_vision_barcode.l0.o("Fragment ", attributeValue, " did not create a view."));
                    }
                    if (resourceId != 0) {
                        view3.setId(resourceId);
                    }
                    if (v9.mView.getTag() == null) {
                        v9.mView.setTag(string2);
                    }
                    v9.mView.addOnAttachStateChangeListener(new h0(this, f2));
                    return v9.mView;
                }
            }
        }
        return null;
    }
}
