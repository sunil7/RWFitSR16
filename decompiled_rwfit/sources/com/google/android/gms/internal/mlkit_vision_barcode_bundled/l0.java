package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class l0 extends p {
    private static final Map zzb = new ConcurrentHashMap();
    protected s1 zzc;
    private int zzd;

    public l0() {
        this.zza = 0;
        this.zzd = -1;
        this.zzc = s1.f9829f;
    }

    public static l0 e(Class cls) {
        Map map = zzb;
        l0 l0Var = (l0) map.get(cls);
        if (l0Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                l0Var = (l0) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (l0Var != null) {
            return l0Var;
        }
        l0 l0Var2 = (l0) ((l0) x1.f(cls)).m(6, null);
        if (l0Var2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, l0Var2);
        return l0Var2;
    }

    public static Object f(Method method, a1 a1Var, Object... objArr) {
        try {
            return method.invoke(a1Var, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static void h(Class cls, l0 l0Var) {
        l0Var.g();
        zzb.put(cls, l0Var);
    }

    public static final boolean j(l0 l0Var, boolean z5) {
        byte byteValue = ((Byte) l0Var.m(1, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean h4 = g1.f9786c.a(l0Var.getClass()).h(l0Var);
        if (z5) {
            l0Var.m(2, true == h4 ? l0Var : null);
        }
        return h4;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.b1
    public final boolean a() {
        return j(this, true);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.p
    public final int b(m1 m1Var) {
        if (k()) {
            int d5 = m1Var.d(this);
            if (d5 >= 0) {
                return d5;
            }
            throw new IllegalStateException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(d5, "serialized size must be non-negative, was "));
        }
        int i3 = this.zzd & SubsamplingScaleImageView.TILE_SIZE_AUTO;
        if (i3 != Integer.MAX_VALUE) {
            return i3;
        }
        int d8 = m1Var.d(this);
        if (d8 < 0) {
            throw new IllegalStateException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(d8, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | d8;
        return d8;
    }

    public final int c() {
        if (k()) {
            int d5 = g1.f9786c.a(getClass()).d(this);
            if (d5 >= 0) {
                return d5;
            }
            throw new IllegalStateException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(d5, "serialized size must be non-negative, was "));
        }
        int i3 = this.zzd & SubsamplingScaleImageView.TILE_SIZE_AUTO;
        if (i3 != Integer.MAX_VALUE) {
            return i3;
        }
        int d8 = g1.f9786c.a(getClass()).d(this);
        if (d8 < 0) {
            throw new IllegalStateException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(d8, "serialized size must be non-negative, was "));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | d8;
        return d8;
    }

    public final h0 d() {
        return (h0) m(5, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return g1.f9786c.a(getClass()).f(this, (l0) obj);
    }

    public final void g() {
        this.zzd &= SubsamplingScaleImageView.TILE_SIZE_AUTO;
    }

    public final int hashCode() {
        if (k()) {
            return g1.f9786c.a(getClass()).g(this);
        }
        int i3 = this.zza;
        if (i3 != 0) {
            return i3;
        }
        int g10 = g1.f9786c.a(getClass()).g(this);
        this.zza = g10;
        return g10;
    }

    public final void i() {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | SubsamplingScaleImageView.TILE_SIZE_AUTO;
    }

    public final boolean k() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final void l(z zVar) {
        m1 a3 = g1.f9786c.a(getClass());
        x0 x0Var = zVar.f9851a;
        if (x0Var == null) {
            x0Var = new x0(zVar);
        }
        a3.i(this, x0Var);
    }

    public abstract Object m(int i3, l0 l0Var);

    public final String toString() {
        String obj = super.toString();
        char[] cArr = c1.f9759a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(obj);
        c1.c(this, sb2, 0);
        return sb2.toString();
    }
}
