package com.amap.api.col.p0003sl;

import android.content.Context;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.a2;
import com.amap.api.col.p0003sl.a3;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapStatus;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.File;

/* loaded from: classes.dex */
public class z1 extends OfflineMapCity implements z2, i2 {
    public static final Parcelable.Creator<z1> CREATOR = new a();
    private long A;

    /* renamed from: k, reason: collision with root package name */
    public final d3 f5524k;

    /* renamed from: l, reason: collision with root package name */
    public final d3 f5525l;

    /* renamed from: m, reason: collision with root package name */
    public final d3 f5526m;

    /* renamed from: n, reason: collision with root package name */
    public final d3 f5527n;

    /* renamed from: o, reason: collision with root package name */
    public final d3 f5528o;

    /* renamed from: p, reason: collision with root package name */
    public final d3 f5529p;

    /* renamed from: q, reason: collision with root package name */
    public final d3 f5530q;
    public final d3 r;

    /* renamed from: s, reason: collision with root package name */
    public final d3 f5531s;

    /* renamed from: t, reason: collision with root package name */
    public final d3 f5532t;

    /* renamed from: u, reason: collision with root package name */
    public final d3 f5533u;

    /* renamed from: v, reason: collision with root package name */
    d3 f5534v;

    /* renamed from: w, reason: collision with root package name */
    Context f5535w;

    /* renamed from: x, reason: collision with root package name */
    private String f5536x;

    /* renamed from: y, reason: collision with root package name */
    private String f5537y;

    /* renamed from: z, reason: collision with root package name */
    boolean f5538z;

    public static class a implements Parcelable.Creator<z1> {
        @Override // android.os.Parcelable.Creator
        public z1 createFromParcel(Parcel parcel) {
            return new z1(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public z1[] newArray(int i3) {
            return new z1[i3];
        }
    }

    public z1(Context context, OfflineMapCity offlineMapCity) {
        this(context, offlineMapCity.getState());
        setCity(offlineMapCity.getCity());
        setUrl(offlineMapCity.getUrl());
        setState(offlineMapCity.getState());
        setCompleteCode(offlineMapCity.getcompleteCode());
        setAdcode(offlineMapCity.getAdcode());
        setVersion(offlineMapCity.getVersion());
        setSize(offlineMapCity.getSize());
        setCode(offlineMapCity.getCode());
        setJianpin(offlineMapCity.getJianpin());
        setPinyin(offlineMapCity.getPinyin());
        o();
    }

    public void b(String str) {
        this.f5537y = str;
    }

    @Override // com.amap.api.col.p0003sl.z2
    public void c() {
        p();
    }

    @Override // com.amap.api.col.p0003sl.z2
    public String d() {
        StringBuffer stringBuffer = new StringBuffer();
        String b3 = x2.b(getUrl());
        if (b3 != null) {
            stringBuffer.append(b3);
        } else {
            stringBuffer.append(getPinyin());
        }
        stringBuffer.append(".zip");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.col.p0003sl.z2
    public void e() {
        this.f5534v.equals(this.f5528o);
        this.f5534v.a(this.r.e());
    }

    @Override // com.amap.api.col.p0003sl.z2
    public boolean f() {
        x2.a();
        getSize();
        getcompleteCode();
        getSize();
        return false;
    }

    @Override // com.amap.api.col.p0003sl.a3
    public void g() {
        this.A = 0L;
        this.f5534v.equals(this.f5525l);
        this.f5534v.h();
    }

    @Override // com.amap.api.col.p0003sl.z2
    public String getId() {
        return getAdcode();
    }

    @Override // com.amap.api.col.p0003sl.s2
    public String h() {
        return l();
    }

    public void i() {
        a2 a3 = a2.a(this.f5535w);
        if (a3 != null) {
            e2 e2Var = a3.f3581k;
            if (e2Var != null) {
                e2Var.a(this);
            }
            a2.e eVar = a3.f3580j;
            if (eVar != null) {
                Message obtainMessage = eVar.obtainMessage();
                obtainMessage.obj = this;
                a3.f3580j.sendMessage(obtainMessage);
            }
        }
    }

    public void j() {
        this.f5534v.e();
        if (this.f5534v.equals(this.f5527n)) {
            this.f5534v.b();
            return;
        }
        if (this.f5534v.equals(this.f5526m)) {
            this.f5534v.g();
            return;
        }
        if (this.f5534v.equals(this.f5530q) || this.f5534v.equals(this.r)) {
            a2 a3 = a2.a(this.f5535w);
            if (a3 != null) {
                a3.c(this);
            }
            this.f5538z = true;
            return;
        }
        if (this.f5534v.equals(this.f5532t) || this.f5534v.equals(this.f5531s) || this.f5534v.a(this.f5533u)) {
            this.f5534v.h();
        } else {
            this.f5534v.d();
        }
    }

    public d3 k() {
        return this.f5534v;
    }

    public String l() {
        if (TextUtils.isEmpty(this.f5536x)) {
            return null;
        }
        String m10 = m();
        return m10.substring(0, m10.lastIndexOf(46));
    }

    public String m() {
        if (TextUtils.isEmpty(this.f5536x)) {
            return null;
        }
        String str = this.f5536x;
        return str.substring(0, str.lastIndexOf("."));
    }

    public String n() {
        return this.f5537y;
    }

    public void o() {
        String str = a2.f3568n;
        String b3 = x2.b(getUrl());
        if (b3 != null) {
            this.f5536x = r5.a.c(str, b3, ".zip.tmp");
            return;
        }
        StringBuilder t8 = l0.t(str);
        t8.append(getPinyin());
        t8.append(".zip.tmp");
        this.f5536x = t8.toString();
    }

    @Override // com.amap.api.col.p0003sl.a3
    public void onCancel() {
        p();
    }

    @Override // com.amap.api.col.p0003sl.a3
    public void onFinish() {
        this.f5534v.equals(this.f5526m);
        this.f5534v.a();
    }

    public void p() {
        a2 a3 = a2.a(this.f5535w);
        if (a3 != null) {
            a3.a(this);
            i();
        }
    }

    public void q() {
        a2 a3 = a2.a(this.f5535w);
        if (a3 != null) {
            a3.b(this);
        }
    }

    public void r() {
        a2 a3 = a2.a(this.f5535w);
        if (a3 != null) {
            a3.d(this);
        }
    }

    public k2 s() {
        setState(this.f5534v.e());
        k2 k2Var = new k2(this, this.f5535w);
        k2Var.f(this.f5537y);
        return k2Var;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f5537y);
    }

    public void b(int i3) {
        if (i3 == 6) {
            this.f5534v = this.f5524k;
        } else if (i3 == 7) {
            this.f5534v = this.f5530q;
        } else if (i3 == -1) {
            this.f5534v = this.r;
        } else if (i3 == 0) {
            this.f5534v = this.f5526m;
        } else if (i3 == 1) {
            this.f5534v = this.f5528o;
        } else if (i3 == 2) {
            this.f5534v = this.f5525l;
        } else if (i3 == 3) {
            this.f5534v = this.f5527n;
        } else if (i3 != 4) {
            switch (i3) {
                case 101:
                    this.f5534v = this.f5531s;
                    break;
                case 102:
                    this.f5534v = this.f5532t;
                    break;
                case OfflineMapStatus.EXCEPTION_SDCARD /* 103 */:
                    this.f5534v = this.f5533u;
                    break;
                default:
                    if (i3 < 0) {
                        this.f5534v = this.r;
                        break;
                    }
                    break;
            }
        } else {
            this.f5534v = this.f5529p;
        }
        setState(i3);
    }

    public void a(d3 d3Var) {
        this.f5534v = d3Var;
        setState(d3Var.e());
    }

    @Override // com.amap.api.col.p0003sl.a3
    public void a(long j4, long j10) {
        int i3 = (int) ((j10 * 100) / j4);
        if (i3 != getcompleteCode()) {
            setCompleteCode(i3);
            i();
        }
    }

    @Override // com.amap.api.col.p0003sl.a3
    public void a(a3.a aVar) {
        int e;
        int ordinal = aVar.ordinal();
        if (ordinal == 0) {
            e = this.f5532t.e();
        } else if (ordinal != 1) {
            e = ordinal != 2 ? 6 : this.f5533u.e();
        } else {
            e = this.f5531s.e();
        }
        if (this.f5534v.equals(this.f5526m) || this.f5534v.equals(this.f5525l)) {
            this.f5534v.a(e);
        }
    }

    public z1(Context context, int i3) {
        this.f5524k = new f3(6, this);
        this.f5525l = new l3(2, this);
        this.f5526m = new h3(0, this);
        this.f5527n = new j3(3, this);
        this.f5528o = new k3(1, this);
        this.f5529p = new e3(4, this);
        this.f5530q = new i3(7, this);
        this.r = new g3(-1, this);
        this.f5531s = new g3(101, this);
        this.f5532t = new g3(102, this);
        this.f5533u = new g3(OfflineMapStatus.EXCEPTION_SDCARD, this);
        this.f5536x = null;
        this.f5537y = "";
        this.f5538z = false;
        this.A = 0L;
        this.f5535w = context;
        b(i3);
    }

    @Override // com.amap.api.col.p0003sl.z2
    public void a() {
        this.A = 0L;
        setCompleteCode(0);
        this.f5534v.equals(this.f5528o);
        this.f5534v.h();
    }

    @Override // com.amap.api.col.p0003sl.s2
    public String b() {
        return m();
    }

    @Override // com.amap.api.col.p0003sl.z2
    public void a(long j4) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.A > 500) {
            int i3 = (int) j4;
            if (i3 > getcompleteCode()) {
                setCompleteCode(i3);
                i();
            }
            this.A = currentTimeMillis;
        }
    }

    @Override // com.amap.api.col.p0003sl.z2
    public void a(String str) {
        this.f5534v.equals(this.f5528o);
        this.f5537y = str;
        String m10 = m();
        String l3 = l();
        if (!TextUtils.isEmpty(m10) && !TextUtils.isEmpty(l3)) {
            File file = new File(e.l(l3, "/"));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(v4.c(this.f5535w));
            File file2 = new File(r5.a.f(sb2, File.separator, "map/"));
            File file3 = new File(v4.c(this.f5535w));
            if (file3.exists() || file3.mkdir()) {
                if (file2.exists() || file2.mkdir()) {
                    new r2().a(file, file2, -1L, x2.b(file), new y1(this, m10, file));
                    return;
                }
                return;
            }
            return;
        }
        e();
    }

    public z1(Parcel parcel) {
        super(parcel);
        this.f5524k = new f3(6, this);
        this.f5525l = new l3(2, this);
        this.f5526m = new h3(0, this);
        this.f5527n = new j3(3, this);
        this.f5528o = new k3(1, this);
        this.f5529p = new e3(4, this);
        this.f5530q = new i3(7, this);
        this.r = new g3(-1, this);
        this.f5531s = new g3(101, this);
        this.f5532t = new g3(102, this);
        this.f5533u = new g3(OfflineMapStatus.EXCEPTION_SDCARD, this);
        this.f5536x = null;
        this.f5537y = "";
        this.f5538z = false;
        this.A = 0L;
        this.f5537y = parcel.readString();
    }

    public d3 a(int i3) {
        switch (i3) {
            case 101:
                return this.f5531s;
            case 102:
                return this.f5532t;
            case OfflineMapStatus.EXCEPTION_SDCARD /* 103 */:
                return this.f5533u;
            default:
                return this.r;
        }
    }
}
