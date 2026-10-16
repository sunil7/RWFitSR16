package androidx.work;

import d4.t;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import o2.f;
import o2.h;

/* loaded from: classes.dex */
public final class ArrayCreatingInputMerger extends h {
    @Override // o2.h
    public final f a(ArrayList arrayList) {
        Object newInstance;
        Object newInstance2;
        t tVar = new t(2);
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            for (Map.Entry entry : Collections.unmodifiableMap(((f) obj).f16711a).entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                Class<?> cls = value.getClass();
                Object obj2 = hashMap.get(str);
                if (obj2 != null) {
                    Class<?> cls2 = obj2.getClass();
                    if (!cls2.equals(cls)) {
                        if (cls2.isArray() && cls2.getComponentType().equals(cls)) {
                            int length = Array.getLength(obj2);
                            newInstance = Array.newInstance(value.getClass(), length + 1);
                            System.arraycopy(obj2, 0, newInstance, 0, length);
                            Array.set(newInstance, length, value);
                        } else {
                            if (!cls.isArray() || !cls.getComponentType().equals(cls2)) {
                                throw new IllegalArgumentException();
                            }
                            int length2 = Array.getLength(value);
                            newInstance = Array.newInstance(obj2.getClass(), length2 + 1);
                            System.arraycopy(value, 0, newInstance, 0, length2);
                            Array.set(newInstance, length2, obj2);
                        }
                        value = newInstance;
                    } else if (cls2.isArray()) {
                        int length3 = Array.getLength(obj2);
                        int length4 = Array.getLength(value);
                        Object newInstance3 = Array.newInstance(obj2.getClass().getComponentType(), length3 + length4);
                        System.arraycopy(obj2, 0, newInstance3, 0, length3);
                        System.arraycopy(value, 0, newInstance3, length3, length4);
                        value = newInstance3;
                    } else {
                        newInstance2 = Array.newInstance(obj2.getClass(), 2);
                        Array.set(newInstance2, 0, obj2);
                        Array.set(newInstance2, 1, value);
                        value = newInstance2;
                    }
                    hashMap.put(str, value);
                } else if (cls.isArray()) {
                    hashMap.put(str, value);
                } else {
                    newInstance2 = Array.newInstance(value.getClass(), 1);
                    Array.set(newInstance2, 0, value);
                    value = newInstance2;
                    hashMap.put(str, value);
                }
            }
        }
        tVar.b(hashMap);
        f fVar = new f(tVar.f12284a);
        f.b(fVar);
        return fVar;
    }
}
