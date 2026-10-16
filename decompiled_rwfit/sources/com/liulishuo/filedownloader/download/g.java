package com.liulishuo.filedownloader.download;

import android.os.SystemClock;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import n.l;
import n.m0;

/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final d f11449a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11450b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11451c;

    /* renamed from: d, reason: collision with root package name */
    public final e f11452d;
    public final m0 e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11453f;

    /* renamed from: g, reason: collision with root package name */
    public final long f11454g;

    /* renamed from: h, reason: collision with root package name */
    public final long f11455h;

    /* renamed from: i, reason: collision with root package name */
    public final long f11456i;

    /* renamed from: j, reason: collision with root package name */
    public final String f11457j;

    /* renamed from: k, reason: collision with root package name */
    public long f11458k;

    /* renamed from: l, reason: collision with root package name */
    public l f11459l;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f11460m;

    /* renamed from: o, reason: collision with root package name */
    public volatile long f11462o = 0;

    /* renamed from: p, reason: collision with root package name */
    public volatile long f11463p = 0;

    /* renamed from: n, reason: collision with root package name */
    public final re.a f11461n = c.f11405a.e();

    public g(m0 m0Var, b bVar, e eVar, int i3, int i10, boolean z5, d dVar, String str) {
        this.f11449a = dVar;
        this.f11457j = str;
        this.e = m0Var;
        this.f11453f = z5;
        this.f11452d = eVar;
        this.f11451c = i10;
        this.f11450b = i3;
        this.f11454g = bVar.f11400a;
        this.f11455h = bVar.f11402c;
        this.f11458k = bVar.f11401b;
        this.f11456i = bVar.f11403d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x02aa, code lost:
    
        throw new com.liulishuo.filedownloader.exception.FileDownloadNetworkPolicyException();
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 766
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.g.a():void");
    }

    public final void b() {
        SystemClock.uptimeMillis();
        try {
            l lVar = this.f11459l;
            ((BufferedOutputStream) lVar.f16245b).flush();
            ((FileDescriptor) lVar.f16246c).sync();
            int i3 = this.f11451c;
            if (i3 >= 0) {
                this.f11461n.G(this.f11450b, i3, this.f11458k);
                return;
            }
            d dVar = this.f11449a;
            FileDownloadModel fileDownloadModel = dVar.f11408b;
            dVar.f11411f.H(fileDownloadModel.h(), fileDownloadModel.j());
        } catch (IOException unused) {
        }
    }
}
