package t0;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class o extends p {

    /* renamed from: g, reason: collision with root package name */
    public boolean f18461g;

    @Override // t0.p
    public final boolean b(float f2, long j4, View view, p0.e eVar) {
        Method method;
        o oVar;
        float a3;
        if (view instanceof MotionLayout) {
            float a10 = a(f2, j4, view, eVar);
            oVar = this;
            ((MotionLayout) view).setProgress(a10);
        } else {
            if (this.f18461g) {
                return false;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f18461g = true;
                method = null;
            }
            if (method != null) {
                try {
                    a3 = a(f2, j4, view, eVar);
                    oVar = this;
                } catch (IllegalAccessException e) {
                    e = e;
                    oVar = this;
                } catch (InvocationTargetException e10) {
                    e = e10;
                    oVar = this;
                }
                try {
                    method.invoke(view, Float.valueOf(a3));
                } catch (IllegalAccessException e11) {
                    e = e11;
                    Log.e("ViewTimeCycle", "unable to setProgress", e);
                    return oVar.f18465d;
                } catch (InvocationTargetException e12) {
                    e = e12;
                    Log.e("ViewTimeCycle", "unable to setProgress", e);
                    return oVar.f18465d;
                }
            } else {
                oVar = this;
            }
        }
        return oVar.f18465d;
    }
}
