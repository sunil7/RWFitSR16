package ja;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import m0.k;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final k f15390a = new k();

    /* renamed from: b, reason: collision with root package name */
    public final k f15391b = new k();

    public static e a(Context context, TypedArray typedArray, int i3) {
        int resourceId;
        if (!typedArray.hasValue(i3) || (resourceId = typedArray.getResourceId(i3, 0)) == 0) {
            return null;
        }
        return b(context, resourceId);
    }

    public static e b(Context context, int i3) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i3);
            if (loadAnimator instanceof AnimatorSet) {
                return c(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return c(arrayList);
        } catch (Exception e) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i3), e);
            return null;
        }
    }

    public static e c(ArrayList arrayList) {
        e eVar = new e();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Animator animator = (Animator) arrayList.get(i3);
            if (!(animator instanceof ObjectAnimator)) {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            eVar.h(objectAnimator.getPropertyName(), objectAnimator.getValues());
            String propertyName = objectAnimator.getPropertyName();
            long startDelay = objectAnimator.getStartDelay();
            long duration = objectAnimator.getDuration();
            TimeInterpolator interpolator = objectAnimator.getInterpolator();
            if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                interpolator = a.f15384b;
            } else if (interpolator instanceof AccelerateInterpolator) {
                interpolator = a.f15385c;
            } else if (interpolator instanceof DecelerateInterpolator) {
                interpolator = a.f15386d;
            }
            f fVar = new f();
            fVar.f15395d = 0;
            fVar.e = 1;
            fVar.f15392a = startDelay;
            fVar.f15393b = duration;
            fVar.f15394c = interpolator;
            fVar.f15395d = objectAnimator.getRepeatCount();
            fVar.e = objectAnimator.getRepeatMode();
            eVar.f15390a.put(propertyName, fVar);
        }
        return eVar;
    }

    public final ObjectAnimator d(String str, Object obj, Property property) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(obj, e(str));
        ofPropertyValuesHolder.setProperty(property);
        f(str).a(ofPropertyValuesHolder);
        return ofPropertyValuesHolder;
    }

    public final PropertyValuesHolder[] e(String str) {
        if (!g(str)) {
            throw new IllegalArgumentException();
        }
        PropertyValuesHolder[] propertyValuesHolderArr = (PropertyValuesHolder[]) this.f15391b.getOrDefault(str, null);
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i3 = 0; i3 < propertyValuesHolderArr.length; i3++) {
            propertyValuesHolderArr2[i3] = propertyValuesHolderArr[i3].clone();
        }
        return propertyValuesHolderArr2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f15390a.equals(((e) obj).f15390a);
        }
        return false;
    }

    public final f f(String str) {
        k kVar = this.f15390a;
        if (kVar.getOrDefault(str, null) != null) {
            return (f) kVar.getOrDefault(str, null);
        }
        throw new IllegalArgumentException();
    }

    public final boolean g(String str) {
        return this.f15391b.getOrDefault(str, null) != null;
    }

    public final void h(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f15391b.put(str, propertyValuesHolderArr);
    }

    public final int hashCode() {
        return this.f15390a.hashCode();
    }

    public final String toString() {
        return "\n" + e.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f15390a + "}\n";
    }
}
