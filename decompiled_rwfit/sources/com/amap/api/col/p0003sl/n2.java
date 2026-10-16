package com.amap.api.col.p0003sl;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;

@ua(tableName = "update_item")
/* loaded from: classes.dex */
public class n2 {

    /* renamed from: h, reason: collision with root package name */
    @va(fieldName = "localPath", fieldType = 6)
    protected String f4682h;

    /* renamed from: j, reason: collision with root package name */
    @va(fieldName = "mCompleteCode", fieldType = 2)
    protected int f4684j;

    /* renamed from: l, reason: collision with root package name */
    @va(fieldName = "mState", fieldType = 2)
    public int f4686l;

    /* renamed from: a, reason: collision with root package name */
    @va(fieldName = "title", fieldType = 6)
    protected String f4676a = null;

    /* renamed from: b, reason: collision with root package name */
    @va(fieldName = "url", fieldType = 6)
    protected String f4677b = null;

    /* renamed from: c, reason: collision with root package name */
    @va(fieldName = "mAdcode", fieldType = 6)
    protected String f4678c = null;

    /* renamed from: d, reason: collision with root package name */
    @va(fieldName = "fileName", fieldType = 6)
    protected String f4679d = null;

    @va(fieldName = "version", fieldType = 6)
    protected String e = "";

    /* renamed from: f, reason: collision with root package name */
    @va(fieldName = "lLocalLength", fieldType = 5)
    protected long f4680f = 0;

    /* renamed from: g, reason: collision with root package name */
    @va(fieldName = "lRemoteLength", fieldType = 5)
    protected long f4681g = 0;

    /* renamed from: i, reason: collision with root package name */
    @va(fieldName = "isProvince", fieldType = 2)
    protected int f4683i = 0;

    /* renamed from: k, reason: collision with root package name */
    @va(fieldName = "mCityCode", fieldType = 6)
    protected String f4685k = "";

    /* renamed from: m, reason: collision with root package name */
    @va(fieldName = "mPinyin", fieldType = 6)
    public String f4687m = "";

    public String a() {
        return this.f4678c;
    }

    public int b() {
        return this.f4684j;
    }

    public String c() {
        return this.f4676a;
    }

    public String d() {
        return this.f4677b;
    }

    public String e() {
        return this.e;
    }

    public static String a(String str) {
        return l0.o("mPinyin='", str, "'");
    }

    public static String b(String str) {
        return l0.o("mAdcode='", str, "'");
    }

    public void c(String str) {
        this.f4678c = str;
    }

    public void d(String str) {
        this.f4685k = str;
    }
}
