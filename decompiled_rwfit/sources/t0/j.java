package t0;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class j extends k {

    /* renamed from: f, reason: collision with root package name */
    public boolean f18450f;

    @Override // t0.k
    public final void c(View view, float f2) {
        Method method;
        if (view instanceof MotionLayout) {
            ((MotionLayout) view).setProgress(a(f2));
            return;
        }
        if (this.f18450f) {
            return;
        }
        try {
            method = view.getClass().getMethod("setProgress", Float.TYPE);
        } catch (NoSuchMethodException unused) {
            this.f18450f = true;
            method = null;
        }
        if (method != null) {
            try {
                method.invoke(view, Float.valueOf(a(f2)));
            } catch (IllegalAccessException e) {
                Log.e("ViewSpline", "unable to setProgress", e);
            } catch (InvocationTargetException e10) {
                Log.e("ViewSpline", "unable to setProgress", e10);
            }
        }
    }
}
