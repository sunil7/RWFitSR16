package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.internal.mlkit_vision_barcode.wa;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public abstract class c1 {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f9759a;

    static {
        char[] cArr = new char[80];
        f9759a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static void a(StringBuilder sb2, int i3, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(sb2, i3, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                a(sb2, i3, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb2.append('\n');
        b(sb2, i3);
        if (!str.isEmpty()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(Character.toLowerCase(str.charAt(0)));
            for (int i10 = 1; i10 < str.length(); i10++) {
                char charAt = str.charAt(i10);
                if (Character.isUpperCase(charAt)) {
                    sb3.append("_");
                }
                sb3.append(Character.toLowerCase(charAt));
            }
            str = sb3.toString();
        }
        sb2.append(str);
        if (obj instanceof String) {
            sb2.append(": \"");
            sb2.append(wa.a(new zzde(((String) obj).getBytes(s0.f9827a))));
            sb2.append('\"');
            return;
        }
        if (obj instanceof zzdf) {
            sb2.append(": \"");
            sb2.append(wa.a((zzdf) obj));
            sb2.append('\"');
            return;
        }
        if (obj instanceof l0) {
            sb2.append(" {");
            c((l0) obj, sb2, i3 + 2);
            sb2.append("\n");
            b(sb2, i3);
            sb2.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb2.append(": ");
            sb2.append(obj);
            return;
        }
        int i11 = i3 + 2;
        sb2.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        a(sb2, i11, "key", entry.getKey());
        a(sb2, i11, "value", entry.getValue());
        sb2.append("\n");
        b(sb2, i3);
        sb2.append("}");
    }

    public static void b(StringBuilder sb2, int i3) {
        while (i3 > 0) {
            int i10 = 80;
            if (i3 <= 80) {
                i10 = i3;
            }
            sb2.append(f9759a, 0, i10);
            i3 -= i10;
        }
    }

    public static void c(l0 l0Var, StringBuilder sb2, int i3) {
        int i10;
        int i11;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = l0Var.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i12 = 0;
        while (true) {
            i10 = 3;
            if (i12 >= length) {
                break;
            }
            Method method3 = declaredMethods[i12];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i12++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i10);
            if (!substring.endsWith("List") || substring.endsWith("OrBuilderList") || substring.equals("List") || (method2 = (Method) entry.getValue()) == null) {
                i11 = i10;
            } else {
                i11 = i10;
                if (method2.getReturnType().equals(List.class)) {
                    a(sb2, i3, substring.substring(0, substring.length() - 4), l0.f(method2, l0Var, new Object[0]));
                    i10 = i11;
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                a(sb2, i3, substring.substring(0, substring.length() - 3), l0.f(method, l0Var, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object f2 = l0.f(method4, l0Var, new Object[0]);
                    if (method5 != null) {
                        if (!((Boolean) l0.f(method5, l0Var, new Object[0])).booleanValue()) {
                        }
                        a(sb2, i3, substring, f2);
                    } else if (f2 instanceof Boolean) {
                        if (!((Boolean) f2).booleanValue()) {
                        }
                        a(sb2, i3, substring, f2);
                    } else if (f2 instanceof Integer) {
                        if (((Integer) f2).intValue() == 0) {
                        }
                        a(sb2, i3, substring, f2);
                    } else if (f2 instanceof Float) {
                        if (Float.floatToRawIntBits(((Float) f2).floatValue()) == 0) {
                        }
                        a(sb2, i3, substring, f2);
                    } else if (f2 instanceof Double) {
                        if (Double.doubleToRawLongBits(((Double) f2).doubleValue()) == 0) {
                        }
                        a(sb2, i3, substring, f2);
                    } else {
                        if (f2 instanceof String) {
                            equals = f2.equals("");
                        } else if (f2 instanceof zzdf) {
                            equals = f2.equals(zzdf.zzb);
                        } else if (f2 instanceof a1) {
                            if (f2 == ((l0) ((l0) ((a1) f2)).m(6, null))) {
                            }
                            a(sb2, i3, substring, f2);
                        } else {
                            if ((f2 instanceof Enum) && ((Enum) f2).ordinal() == 0) {
                            }
                            a(sb2, i3, substring, f2);
                        }
                        if (equals) {
                        }
                        a(sb2, i3, substring, f2);
                    }
                }
            }
            i10 = i11;
        }
        if (l0Var instanceof i0) {
            Iterator c9 = ((i0) l0Var).zzb.c();
            while (c9.hasNext()) {
                Map.Entry entry2 = (Map.Entry) c9.next();
                ((j0) entry2.getKey()).getClass();
                a(sb2, i3, com.google.android.gms.internal.mlkit_vision_barcode.l0.k(0, "[", "]"), entry2.getValue());
            }
        }
        s1 s1Var = l0Var.zzc;
        if (s1Var != null) {
            for (int i13 = 0; i13 < s1Var.f9830a; i13++) {
                a(sb2, i3, String.valueOf(s1Var.f9831b[i13] >>> 3), s1Var.f9832c[i13]);
            }
        }
    }
}
