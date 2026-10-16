package com.google.android.gms.internal.mlkit_vision_barcode;

import android.util.Base64;
import androidx.camera.core.impl.SurfaceConfig$ConfigSize;
import androidx.camera.core.impl.SurfaceConfig$ConfigType;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract /* synthetic */ class l0 {
    public static void A(int i3, String str, String str2, IUiListener iUiListener) {
        iUiListener.onError(new UiError(i3, str, str2));
    }

    public static void B(SurfaceConfig$ConfigType surfaceConfig$ConfigType, SurfaceConfig$ConfigSize surfaceConfig$ConfigSize, long j4, androidx.camera.core.impl.v1 v1Var) {
        v1Var.a(new androidx.camera.core.impl.i(surfaceConfig$ConfigType, surfaceConfig$ConfigSize, j4));
    }

    public static void C(String str, int i3, StringBuilder sb2, StringBuffer stringBuffer) {
        sb2.append(Base64.encodeToString(com.tencent.open.utils.m.j(str), i3));
        stringBuffer.append(sb2.toString());
    }

    public static void D(HashMap hashMap) {
        Collections.unmodifiableMap(new HashMap(hashMap));
    }

    public static float a(float f2, float f10, float f11, float f12) {
        return ((f2 - f10) * f11) + f12;
    }

    public static int b(int i3, int i10, int i11) {
        return com.google.android.gms.internal.mlkit_vision_barcode_bundled.z.a(i3) + i10 + i11;
    }

    public static int c(int i3, int i10, int i11, int i12) {
        return com.google.android.gms.internal.mlkit_vision_barcode_bundled.z.a(i3) + i10 + i11 + i12;
    }

    public static int d(int i3, int i10, String str) {
        return (str.hashCode() + i3) * i10;
    }

    public static androidx.camera.core.impl.v1 e(ArrayList arrayList, androidx.camera.core.impl.v1 v1Var) {
        arrayList.add(v1Var);
        return new androidx.camera.core.impl.v1();
    }

    public static ClassCastException f(Object obj) {
        obj.getClass();
        return new ClassCastException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object g(int i3, Object obj) {
        return obj.get(obj.size() - i3);
    }

    public static Object h(int i3, ArrayList arrayList) {
        return arrayList.get(arrayList.size() - i3);
    }

    public static String i(int i3, int i10, String str, String str2) {
        return str + i3 + str2 + i10;
    }

    public static String j(int i3, String str) {
        return str + i3;
    }

    public static String k(int i3, String str, String str2) {
        return str + i3 + str2;
    }

    public static String l(long j4, String str) {
        return str + j4;
    }

    public static String m(String str, float f2) {
        return str + f2;
    }

    public static String n(String str, String str2) {
        return str + str2;
    }

    public static String o(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String p(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String q(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static String r(StringBuilder sb2, List list, char c9) {
        sb2.append(list);
        sb2.append(c9);
        return sb2.toString();
    }

    public static StringBuilder s(int i3, String str, int i10, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(i3);
        sb2.append(str2);
        sb2.append(i10);
        sb2.append(str3);
        return sb2;
    }

    public static StringBuilder t(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        return sb2;
    }

    public static StringBuilder u(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        return sb2;
    }

    public static StringBuilder v(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str4);
        sb2.append(str5);
        return sb2;
    }

    public static HashMap w(Class cls, g0 g0Var) {
        HashMap hashMap = new HashMap();
        hashMap.put(cls, g0Var);
        return hashMap;
    }

    public static HashMap x(Class cls, com.google.android.gms.internal.mlkit_vision_common.c cVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(cls, cVar);
        return hashMap;
    }

    public static Map y(HashMap hashMap) {
        return Collections.unmodifiableMap(new HashMap(hashMap));
    }

    public static rb.b z(int i3, zzfd zzfdVar, o4.c cVar) {
        cVar.p(new g0(i3, zzfdVar));
        return cVar.a();
    }
}
