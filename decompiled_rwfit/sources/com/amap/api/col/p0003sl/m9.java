package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;

@ua(tableName = Const.INTENT_KEY_APIKEY)
/* loaded from: classes.dex */
public class m9 {

    /* renamed from: a, reason: collision with root package name */
    @va(fieldName = SdCardDbCreator.FIELD_LASTLOC_ID, fieldType = 6)
    private String f4591a;

    /* renamed from: b, reason: collision with root package name */
    @va(fieldName = SdCardDbCreator.FIELD_LASTLOC_INFO, fieldType = 6)
    private String f4592b;

    /* renamed from: c, reason: collision with root package name */
    @va(fieldName = "a6", fieldType = 2)
    private int f4593c;

    /* renamed from: d, reason: collision with root package name */
    @va(fieldName = SdCardDbCreator.FIELD_LASTLOC_NB, fieldType = 6)
    private String f4594d;

    @va(fieldName = "a5", fieldType = 6)
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private String f4595f;

    /* renamed from: g, reason: collision with root package name */
    private String f4596g;

    /* renamed from: h, reason: collision with root package name */
    private String f4597h;

    /* renamed from: i, reason: collision with root package name */
    private String f4598i;

    /* renamed from: j, reason: collision with root package name */
    private String f4599j;

    /* renamed from: k, reason: collision with root package name */
    private String[] f4600k;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f4601a;

        /* renamed from: b, reason: collision with root package name */
        private String f4602b;

        /* renamed from: c, reason: collision with root package name */
        private String f4603c;

        /* renamed from: d, reason: collision with root package name */
        private String f4604d;
        private boolean e = true;

        /* renamed from: f, reason: collision with root package name */
        private String[] f4605f = null;

        public a(String str, String str2, String str3) {
            this.f4601a = str2;
            this.f4602b = str2;
            this.f4604d = str3;
            this.f4603c = str;
        }

        public static /* synthetic */ String f(a aVar) {
            aVar.getClass();
            return "standard";
        }

        public a a(boolean z5) {
            this.e = z5;
            return this;
        }

        public a a(String[] strArr) {
            if (strArr != null) {
                this.f4605f = (String[]) strArr.clone();
            }
            return this;
        }

        public a a(String str) {
            this.f4602b = str;
            return this;
        }

        public m9 a() throws a9 {
            if (this.f4605f != null) {
                return new m9(this, (byte) 0);
            }
            throw new a9("sdk packages is null");
        }
    }

    public /* synthetic */ m9(a aVar, byte b3) {
        this(aVar);
    }

    public void a(boolean z5) {
        this.f4593c = z5 ? 1 : 0;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f4596g) && !TextUtils.isEmpty(this.f4592b)) {
            this.f4596g = n9.b(this.f4592b);
        }
        return this.f4596g;
    }

    public String[] c() {
        String[] strArr;
        String[] strArr2 = this.f4600k;
        if ((strArr2 == null || strArr2.length == 0) && !TextUtils.isEmpty(this.f4594d)) {
            try {
                strArr = n9.b(this.f4594d).split(Const.STR_MART_SEMICOLON);
            } catch (Throwable th2) {
                th2.printStackTrace();
                strArr = null;
            }
            this.f4600k = strArr;
        }
        return (String[]) this.f4600k.clone();
    }

    public String d() {
        if (TextUtils.isEmpty(this.f4598i) && !TextUtils.isEmpty(this.f4591a)) {
            this.f4598i = n9.b(this.f4591a);
        }
        return this.f4598i;
    }

    public String e() {
        return this.f4595f;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (m9.class != obj.getClass()) {
            return false;
        }
        try {
            if (this.f4598i.equals(((m9) obj).f4598i) && this.f4595f.equals(((m9) obj).f4595f)) {
                if (this.f4596g.equals(((m9) obj).f4596g)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public boolean f() {
        return this.f4593c == 1;
    }

    private m9() {
        this.f4593c = 1;
        this.f4600k = null;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f4599j) && !TextUtils.isEmpty(this.e)) {
            this.f4599j = n9.b(this.e);
        }
        if (TextUtils.isEmpty(this.f4599j)) {
            this.f4599j = "standard";
        }
        return this.f4599j;
    }

    private m9(a aVar) {
        this.f4593c = 1;
        this.f4600k = null;
        this.f4595f = aVar.f4601a;
        this.f4596g = aVar.f4602b;
        this.f4598i = aVar.f4603c;
        this.f4597h = aVar.f4604d;
        this.f4593c = aVar.e ? 1 : 0;
        a.f(aVar);
        this.f4599j = "standard";
        this.f4600k = aVar.f4605f;
        this.f4592b = n9.f(this.f4596g);
        this.f4591a = n9.f(this.f4598i);
        n9.f(this.f4597h);
        this.f4594d = n9.f(a(this.f4600k));
        this.e = n9.f(this.f4599j);
    }

    private static String a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            for (String str : strArr) {
                sb2.append(str);
                sb2.append(Const.STR_MART_SEMICOLON);
            }
            return sb2.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }
}
