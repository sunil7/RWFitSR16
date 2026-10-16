package c1;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_barcode.d1;
import com.google.android.gms.internal.mlkit_vision_barcode.e1;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class g extends d1 {

    /* renamed from: h, reason: collision with root package name */
    public static Class f3361h = null;

    /* renamed from: i, reason: collision with root package name */
    public static Constructor f3362i = null;

    /* renamed from: j, reason: collision with root package name */
    public static Method f3363j = null;

    /* renamed from: k, reason: collision with root package name */
    public static Method f3364k = null;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f3365l = false;

    /* renamed from: a, reason: collision with root package name */
    public final Class f3366a;

    /* renamed from: b, reason: collision with root package name */
    public final Constructor f3367b;

    /* renamed from: c, reason: collision with root package name */
    public final Method f3368c;

    /* renamed from: d, reason: collision with root package name */
    public final Method f3369d;
    public final Method e;

    /* renamed from: f, reason: collision with root package name */
    public final Method f3370f;

    /* renamed from: g, reason: collision with root package name */
    public final Method f3371g;

    public g() {
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            method2 = l(cls2);
            Class cls3 = Integer.TYPE;
            method3 = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method4 = cls2.getMethod("freeze", null);
            method5 = cls2.getMethod("abortCreation", null);
            method = m(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e.getClass().getName()), e);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f3366a = cls;
        this.f3367b = constructor;
        this.f3368c = method2;
        this.f3369d = method3;
        this.e = method4;
        this.f3370f = method5;
        this.f3371g = method;
    }

    public static boolean g(Object obj, String str, int i3, boolean z5) {
        j();
        try {
            return ((Boolean) f3363j.invoke(obj, str, Integer.valueOf(i3), Boolean.valueOf(z5))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void j() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f3365l) {
            return;
        }
        f3365l = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
            method = null;
            cls = null;
            method2 = null;
        }
        f3362i = constructor;
        f3361h = cls;
        f3363j = method2;
        f3364k = method;
    }

    public static Method l(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.d1
    public final Typeface a(Context context, b1.f fVar, Resources resources, int i3) {
        Method method = this.f3368c;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method != null) {
            Object k10 = k();
            if (k10 != null) {
                b1.g[] gVarArr = fVar.f3058a;
                int length = gVarArr.length;
                int i10 = 0;
                while (i10 < length) {
                    b1.g gVar = gVarArr[i10];
                    Context context2 = context;
                    if (!f(context2, k10, gVar.f3059a, gVar.e, gVar.f3060b, gVar.f3061c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(gVar.f3062d))) {
                        e(k10);
                        return null;
                    }
                    i10++;
                    context = context2;
                }
                if (i(k10)) {
                    return h(k10);
                }
            }
            return null;
        }
        j();
        try {
            Object newInstance = f3362i.newInstance(null);
            for (b1.g gVar2 : fVar.f3058a) {
                File d5 = e1.d(context);
                if (d5 == null) {
                    return null;
                }
                try {
                    if (e1.b(d5, resources, gVar2.f3063f) && g(newInstance, d5.getPath(), gVar2.f3060b, gVar2.f3061c)) {
                        d5.delete();
                    }
                } catch (RuntimeException unused) {
                } catch (Throwable th2) {
                    d5.delete();
                    throw th2;
                }
                d5.delete();
                return null;
            }
            j();
            try {
                Object newInstance2 = Array.newInstance((Class<?>) f3361h, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) f3364k.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.d1
    public final Typeface b(Context context, i1.f[] fVarArr, int i3) {
        Typeface h4;
        boolean z5;
        if (fVarArr.length >= 1) {
            Method method = this.f3368c;
            if (method == null) {
                Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
            }
            if (method != null) {
                HashMap hashMap = new HashMap();
                for (i1.f fVar : fVarArr) {
                    if (fVar.e == 0) {
                        Uri uri = fVar.f14344a;
                        if (!hashMap.containsKey(uri)) {
                            hashMap.put(uri, e1.e(context, uri));
                        }
                    }
                }
                Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
                Object k10 = k();
                if (k10 != null) {
                    int length = fVarArr.length;
                    int i10 = 0;
                    boolean z6 = false;
                    while (i10 < length) {
                        i1.f fVar2 = fVarArr[i10];
                        ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(fVar2.f14344a);
                        if (byteBuffer != null) {
                            try {
                                z5 = ((Boolean) this.f3369d.invoke(k10, byteBuffer, Integer.valueOf(fVar2.f14345b), null, Integer.valueOf(fVar2.f14346c), Integer.valueOf(fVar2.f14347d ? 1 : 0))).booleanValue();
                            } catch (IllegalAccessException | InvocationTargetException unused) {
                                z5 = false;
                            }
                            if (!z5) {
                                e(k10);
                                return null;
                            }
                            z6 = true;
                        }
                        i10++;
                        z6 = z6;
                    }
                    if (!z6) {
                        e(k10);
                        return null;
                    }
                    if (i(k10) && (h4 = h(k10)) != null) {
                        return Typeface.create(h4, i3);
                    }
                }
            } else {
                i1.f d5 = d(fVarArr, i3);
                try {
                    ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(d5.f14344a, "r", null);
                    if (openFileDescriptor != null) {
                        try {
                            Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(d5.f14346c).setItalic(d5.f14347d).build();
                            openFileDescriptor.close();
                            return build;
                        } finally {
                        }
                    }
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                        return null;
                    }
                } catch (IOException unused2) {
                }
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.d1
    public final Typeface c(Context context, Resources resources, int i3, String str, int i10) {
        Method method = this.f3368c;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.c(context, resources, i3, str, i10);
        }
        Object k10 = k();
        if (k10 != null) {
            if (!f(context, k10, str, 0, -1, -1, null)) {
                e(k10);
                return null;
            }
            if (i(k10)) {
                return h(k10);
            }
        }
        return null;
    }

    public final void e(Object obj) {
        try {
            this.f3370f.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean f(Context context, Object obj, String str, int i3, int i10, int i11, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f3368c.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i3), Integer.valueOf(i10), Integer.valueOf(i11), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface h(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) this.f3366a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f3371g.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean i(Object obj) {
        try {
            return ((Boolean) this.e.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final Object k() {
        try {
            return this.f3367b.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method m(Class cls) {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
