package com.amap.api.col.p0003sl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.pb;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes.dex */
public class ib {

    /* renamed from: a, reason: collision with root package name */
    public static int f4306a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static String f4307b = "";

    /* renamed from: c, reason: collision with root package name */
    private static ib f4308c;

    public interface a {
        URLConnection a(Proxy proxy, URL url);
    }

    public ib() {
        c9.h();
    }

    public static ib a() {
        if (f4308c == null) {
            f4308c = new ib();
        }
        return f4308c;
    }

    public pb.b b(pb pbVar, boolean z5) {
        return pbVar.getDegradeAbility() == pb.a.FIX ? pb.b.FIX_NONDEGRADE : pbVar.getDegradeAbility() == pb.a.SINGLE ? pb.b.NEVER_GRADE : z5 ? pb.b.FIRST_NONDEGRADE : pb.b.NEVER_GRADE;
    }

    public boolean c(pb pbVar) throws a9 {
        d(pbVar);
        try {
            String ipv6url = pbVar.getIPV6URL();
            if (TextUtils.isEmpty(ipv6url)) {
                return false;
            }
            String host = new URL(ipv6url).getHost();
            if (!TextUtils.isEmpty(pbVar.getIPDNSName())) {
                host = pbVar.getIPDNSName();
            }
            return c9.g(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    public void d(pb pbVar) throws a9 {
        if (pbVar == null) {
            throw new a9("requeust is null");
        }
        if (pbVar.getURL() == null || "".equals(pbVar.getURL())) {
            throw new a9("request url is empty");
        }
    }

    public qb a(pb pbVar) throws a9 {
        boolean z5;
        byte[] bArr;
        boolean isHttps = pbVar.isHttps();
        d(pbVar);
        pbVar.setHttpProtocol(isHttps ? pb.c.HTTPS : pb.c.HTTP);
        qb qbVar = null;
        long j4 = 0;
        if (c(pbVar)) {
            boolean b3 = b(pbVar);
            try {
                j4 = SystemClock.elapsedRealtime();
                qbVar = a(pbVar, b(pbVar, b3), c(pbVar, b3));
            } catch (a9 e) {
                if (e.c() == 21 && pbVar.getDegradeAbility() == pb.a.INTERRUPT_IO) {
                    throw e;
                }
                if (!b3) {
                    throw e;
                }
                z5 = true;
            }
        }
        z5 = false;
        return (qbVar == null || (bArr = qbVar.f4927a) == null || bArr.length <= 0) ? a(pbVar, a(pbVar, z5), a(pbVar, j4)) : qbVar;
    }

    public boolean b(pb pbVar) throws a9 {
        d(pbVar);
        if (!c(pbVar)) {
            return true;
        }
        if (pbVar.getURL().equals(pbVar.getIPV6URL()) || pbVar.getDegradeAbility() == pb.a.SINGLE) {
            return false;
        }
        return c9.f3833s;
    }

    public int c(pb pbVar, boolean z5) {
        try {
            d(pbVar);
            int conntectionTimeout = pbVar.getConntectionTimeout();
            int i3 = c9.f3830o;
            if (pbVar.getDegradeAbility() != pb.a.FIX) {
                if (pbVar.getDegradeAbility() != pb.a.SINGLE && conntectionTimeout >= i3 && z5) {
                    return i3;
                }
            }
            return conntectionTimeout;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    private qb a(pb pbVar, pb.b bVar, int i3) throws a9 {
        try {
            d(pbVar);
            pbVar.setDegradeType(bVar);
            pbVar.setReal_max_timeout(i3);
            return new mb().c(pbVar);
        } catch (a9 e) {
            throw e;
        } catch (Throwable th2) {
            th2.printStackTrace();
            throw new a9("未知的错误");
        }
    }

    public pb.b a(pb pbVar, boolean z5) {
        return pbVar.getDegradeAbility() == pb.a.FIX ? z5 ? pb.b.FIX_DEGRADE_BYERROR : pb.b.FIX_DEGRADE_ONLY : z5 ? pb.b.DEGRADE_BYERROR : pb.b.DEGRADE_ONLY;
    }

    public int a(pb pbVar, long j4) {
        try {
            d(pbVar);
            long j10 = 0;
            if (j4 != 0) {
                j10 = SystemClock.elapsedRealtime() - j4;
            }
            int conntectionTimeout = pbVar.getConntectionTimeout();
            if (pbVar.getDegradeAbility() != pb.a.FIX && pbVar.getDegradeAbility() != pb.a.SINGLE) {
                long j11 = conntectionTimeout;
                if (j10 < j11) {
                    long j12 = j11 - j10;
                    if (j12 >= 1000) {
                        return (int) j12;
                    }
                }
                return Math.min(1000, pbVar.getConntectionTimeout());
            }
            return conntectionTimeout;
        } catch (Throwable unused) {
            return 5000;
        }
    }
}
