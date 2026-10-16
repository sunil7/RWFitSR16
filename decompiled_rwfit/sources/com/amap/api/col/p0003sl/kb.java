package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.pb;

/* loaded from: classes.dex */
public class kb {

    /* renamed from: a, reason: collision with root package name */
    private mb f4432a;

    /* renamed from: b, reason: collision with root package name */
    private pb f4433b;

    /* renamed from: c, reason: collision with root package name */
    private long f4434c;

    /* renamed from: d, reason: collision with root package name */
    private long f4435d;

    public interface a {
        void onDownload(byte[] bArr, long j4);

        void onException(Throwable th2);

        void onFinish();

        void onStop();
    }

    public kb(pb pbVar) {
        this(pbVar, 0L, -1L);
    }

    public void a(a aVar) {
        try {
            mb mbVar = new mb();
            this.f4432a = mbVar;
            mbVar.b(this.f4435d);
            this.f4432a.a(this.f4434c);
            if (ib.a().c(this.f4433b)) {
                this.f4433b.setDegradeType(pb.b.NEVER_GRADE);
                this.f4432a.a(this.f4433b, aVar);
            } else {
                this.f4433b.setDegradeType(pb.b.DEGRADE_ONLY);
                this.f4432a.a(this.f4433b, aVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public kb(pb pbVar, long j4, long j10) {
        this(pbVar, j4, j10, false);
    }

    public kb(pb pbVar, long j4, long j10, boolean z5) {
        this.f4433b = pbVar;
        this.f4434c = j4;
        this.f4435d = j10;
        pbVar.setHttpProtocol(z5 ? pb.c.HTTPS : pb.c.HTTP);
        this.f4433b.setDegradeAbility(pb.a.SINGLE);
    }

    public void a() {
        mb mbVar = this.f4432a;
        if (mbVar != null) {
            mbVar.a();
        }
    }
}
