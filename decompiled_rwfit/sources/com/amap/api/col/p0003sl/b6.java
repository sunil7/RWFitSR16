package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class b6 {

    /* renamed from: a, reason: collision with root package name */
    private Context f3780a;

    public b6(Context context) {
        this.f3780a = context.getApplicationContext();
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder("personal_switch=off&autodiv=ANDA0605000");
        if (!TextUtils.isEmpty("")) {
            sb2.append("&tid=");
        }
        String f2 = f9.f(this.f3780a);
        if (!TextUtils.isEmpty(f2)) {
            sb2.append("&adiu=");
            sb2.append(f2);
        }
        if (!TextUtils.isEmpty("9.7.4")) {
            sb2.append("&app_version=9.7.4");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&cifa=");
        }
        String b3 = f9.b();
        if (!TextUtils.isEmpty(b3)) {
            sb2.append("&deviceid=");
            sb2.append(b3);
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&did=");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&didv=");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&dic=");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&dip=");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&diu=");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&diu2=");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&diu3=");
        }
        if (!TextUtils.isEmpty("ANDH070308")) {
            sb2.append("&div=ANDH070308");
        }
        if (!TextUtils.isEmpty("android")) {
            sb2.append("&os=android");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&stepid=");
        }
        if (!TextUtils.isEmpty("")) {
            sb2.append("&session=");
        }
        return sb2.toString();
    }
}
