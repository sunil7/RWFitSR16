package y5;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f20008a = "0123456789ABCDEF".toCharArray();

    public static HashMap a(String str, List list) {
        HashMap hashMap = new HashMap();
        for (Object obj : list) {
            String str2 = null;
            try {
                Field field = null;
                for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                    try {
                        field = cls.getDeclaredField(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (field != null) {
                        break;
                    }
                }
                field.setAccessible(true);
                str2 = (String) field.get(obj);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (hashMap.containsKey(str2)) {
                ((List) hashMap.get(str2)).add(obj);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(obj);
                hashMap.put(str2, arrayList);
            }
        }
        return hashMap;
    }
}
