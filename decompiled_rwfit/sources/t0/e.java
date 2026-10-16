package t0;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class e extends f {

    /* renamed from: d, reason: collision with root package name */
    public boolean f18443d;

    @Override // t0.f
    public final void c(View view, float f2) {
        Method method;
        if (view instanceof MotionLayout) {
            ((MotionLayout) view).setProgress(a(f2));
            return;
        }
        if (this.f18443d) {
            return;
        }
        try {
            method = view.getClass().getMethod("setProgress", Float.TYPE);
        } catch (NoSuchMethodException unused) {
            this.f18443d = true;
            method = null;
        }
        if (method != null) {
            try {
                method.invoke(view, Float.valueOf(a(f2)));
            } catch (IllegalAccessException e) {
                Log.e("ViewOscillator", "unable to setProgress", e);
            } catch (InvocationTargetException e10) {
                Log.e("ViewOscillator", "unable to setProgress", e10);
            }
        }
    }
}
