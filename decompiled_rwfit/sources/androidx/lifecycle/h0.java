package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;

/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f2360f = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f2361a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f2362b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f2363c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f2364d;
    public final e2.c e;

    public h0(HashMap hashMap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f2361a = linkedHashMap;
        this.f2362b = new LinkedHashMap();
        this.f2363c = new LinkedHashMap();
        this.f2364d = new LinkedHashMap();
        this.e = new androidx.activity.c(this, 1);
        linkedHashMap.putAll(hashMap);
    }

    public static Bundle a(h0 this$0) {
        String key;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        LinkedHashMap linkedHashMap = this$0.f2362b;
        kotlin.jvm.internal.e.f(linkedHashMap, "<this>");
        int size = linkedHashMap.size();
        Iterator it = (size != 0 ? size != 1 ? new LinkedHashMap(linkedHashMap) : kotlin.collections.p.d(linkedHashMap) : kotlin.collections.p.a()).entrySet().iterator();
        do {
            boolean hasNext = it.hasNext();
            LinkedHashMap linkedHashMap2 = this$0.f2361a;
            int i3 = 0;
            if (!hasNext) {
                Set<String> keySet = linkedHashMap2.keySet();
                ArrayList arrayList = new ArrayList(keySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String str : keySet) {
                    arrayList.add(str);
                    arrayList2.add(linkedHashMap2.get(str));
                }
                Pair[] pairArr = {new Pair("keys", arrayList), new Pair("values", arrayList2)};
                Bundle bundle = new Bundle(2);
                while (i3 < 2) {
                    Pair pair = pairArr[i3];
                    String str2 = (String) pair.component1();
                    Object component2 = pair.component2();
                    if (component2 == null) {
                        bundle.putString(str2, null);
                    } else if (component2 instanceof Boolean) {
                        bundle.putBoolean(str2, ((Boolean) component2).booleanValue());
                    } else if (component2 instanceof Byte) {
                        bundle.putByte(str2, ((Number) component2).byteValue());
                    } else if (component2 instanceof Character) {
                        bundle.putChar(str2, ((Character) component2).charValue());
                    } else if (component2 instanceof Double) {
                        bundle.putDouble(str2, ((Number) component2).doubleValue());
                    } else if (component2 instanceof Float) {
                        bundle.putFloat(str2, ((Number) component2).floatValue());
                    } else if (component2 instanceof Integer) {
                        bundle.putInt(str2, ((Number) component2).intValue());
                    } else if (component2 instanceof Long) {
                        bundle.putLong(str2, ((Number) component2).longValue());
                    } else if (component2 instanceof Short) {
                        bundle.putShort(str2, ((Number) component2).shortValue());
                    } else if (component2 instanceof Bundle) {
                        bundle.putBundle(str2, (Bundle) component2);
                    } else if (component2 instanceof CharSequence) {
                        bundle.putCharSequence(str2, (CharSequence) component2);
                    } else if (component2 instanceof Parcelable) {
                        bundle.putParcelable(str2, (Parcelable) component2);
                    } else if (component2 instanceof boolean[]) {
                        bundle.putBooleanArray(str2, (boolean[]) component2);
                    } else if (component2 instanceof byte[]) {
                        bundle.putByteArray(str2, (byte[]) component2);
                    } else if (component2 instanceof char[]) {
                        bundle.putCharArray(str2, (char[]) component2);
                    } else if (component2 instanceof double[]) {
                        bundle.putDoubleArray(str2, (double[]) component2);
                    } else if (component2 instanceof float[]) {
                        bundle.putFloatArray(str2, (float[]) component2);
                    } else if (component2 instanceof int[]) {
                        bundle.putIntArray(str2, (int[]) component2);
                    } else if (component2 instanceof long[]) {
                        bundle.putLongArray(str2, (long[]) component2);
                    } else if (component2 instanceof short[]) {
                        bundle.putShortArray(str2, (short[]) component2);
                    } else if (component2 instanceof Object[]) {
                        Class<?> componentType = component2.getClass().getComponentType();
                        kotlin.jvm.internal.e.c(componentType);
                        if (Parcelable.class.isAssignableFrom(componentType)) {
                            bundle.putParcelableArray(str2, (Parcelable[]) component2);
                        } else if (String.class.isAssignableFrom(componentType)) {
                            bundle.putStringArray(str2, (String[]) component2);
                        } else if (CharSequence.class.isAssignableFrom(componentType)) {
                            bundle.putCharSequenceArray(str2, (CharSequence[]) component2);
                        } else {
                            if (!Serializable.class.isAssignableFrom(componentType)) {
                                throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str2 + '\"');
                            }
                            bundle.putSerializable(str2, (Serializable) component2);
                        }
                    } else if (component2 instanceof Serializable) {
                        bundle.putSerializable(str2, (Serializable) component2);
                    } else if (component2 instanceof IBinder) {
                        h1.a.a(bundle, str2, (IBinder) component2);
                    } else if (component2 instanceof Size) {
                        h1.b.a(bundle, str2, (Size) component2);
                    } else {
                        if (!(component2 instanceof SizeF)) {
                            throw new IllegalArgumentException("Illegal value type " + component2.getClass().getCanonicalName() + " for key \"" + str2 + '\"');
                        }
                        h1.b.b(bundle, str2, (SizeF) component2);
                    }
                    i3++;
                }
                return bundle;
            }
            Map.Entry entry = (Map.Entry) it.next();
            key = (String) entry.getKey();
            Bundle a3 = ((e2.c) entry.getValue()).a();
            kotlin.jvm.internal.e.f(key, "key");
            if (a3 != null) {
                Class[] clsArr = f2360f;
                while (i3 < 29) {
                    Class cls = clsArr[i3];
                    kotlin.jvm.internal.e.c(cls);
                    if (!cls.isInstance(a3)) {
                        i3++;
                    }
                }
                throw new IllegalArgumentException("Can't put value with type " + a3.getClass() + " into saved state");
            }
            Object obj = this$0.f2363c.get(key);
            b0 b0Var = obj instanceof b0 ? (b0) obj : null;
            if (b0Var != null) {
                b0Var.k(a3);
            } else {
                linkedHashMap2.put(key, a3);
            }
        } while (this$0.f2364d.get(key) == null);
        throw new ClassCastException();
    }

    public h0() {
        this.f2361a = new LinkedHashMap();
        this.f2362b = new LinkedHashMap();
        this.f2363c = new LinkedHashMap();
        this.f2364d = new LinkedHashMap();
        this.e = new androidx.activity.c(this, 1);
    }
}
