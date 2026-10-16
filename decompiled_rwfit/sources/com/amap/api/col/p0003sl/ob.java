package com.amap.api.col.p0003sl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.col.p0003sl.pb;
import com.amap.api.col.p0003sl.pc;
import java.util.Map;

/* loaded from: classes.dex */
public class ob extends ib {
    private static ob e;

    /* renamed from: d, reason: collision with root package name */
    private qc f4779d;

    public static class a extends Handler {
        public /* synthetic */ a(Looper looper, byte b3) {
            this(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i3 = message.what;
                if (i3 == 0) {
                    ((tb) message.obj).getClass();
                    throw null;
                }
                if (i3 != 1) {
                    return;
                }
                ((tb) message.obj).getClass();
                throw null;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        private a(Looper looper) {
            super(looper);
        }

        public a() {
        }
    }

    private ob(boolean z5) {
        if (z5) {
            try {
                this.f4779d = qc.a(new pc.a().a("amap-netmanger-threadpool-%d").a());
            } catch (Throwable th2) {
                ka.a(th2, "NetManger", "NetManger1");
                th2.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            new a(Looper.getMainLooper(), (byte) 0);
        } else {
            new a();
        }
    }

    private static synchronized ob a(boolean z5) {
        synchronized (ob.class) {
            try {
                ob obVar = e;
                if (obVar == null) {
                    e = new ob(z5);
                } else if (z5 && obVar.f4779d == null) {
                    obVar.f4779d = qc.a(new pc.a().a("amap-netmanger-threadpool-%d").a());
                }
            } finally {
                return e;
            }
        }
        return e;
    }

    public static ob b() {
        return a(true);
    }

    private qb c(pb pbVar, pb.b bVar, int i3) throws a9 {
        try {
            d(pbVar);
            pbVar.setDegradeType(bVar);
            pbVar.setReal_max_timeout(i3);
            return new mb().b(pbVar);
        } catch (a9 e10) {
            throw e10;
        } catch (Throwable th2) {
            th2.printStackTrace();
            throw new a9("未知的错误");
        }
    }

    @Deprecated
    public Map<String, String> d(pb pbVar, boolean z5) throws a9 {
        boolean z6;
        d(pbVar);
        pbVar.setHttpProtocol(z5 ? pb.c.HTTPS : pb.c.HTTP);
        Map<String, String> map = null;
        long j4 = 0;
        if (c(pbVar)) {
            boolean b3 = b(pbVar);
            try {
                j4 = SystemClock.elapsedRealtime();
                map = b(pbVar, b(pbVar, b3), c(pbVar, b3));
            } catch (a9 e10) {
                if (!b3) {
                    throw e10;
                }
                z6 = true;
            }
        }
        z6 = false;
        return map == null ? b(pbVar, a(pbVar, z6), a(pbVar, j4)) : map;
    }

    public qb e(pb pbVar) throws a9 {
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
                qbVar = c(pbVar, b(pbVar, b3), c(pbVar, b3));
            } catch (a9 e10) {
                if (e10.c() == 21 && pbVar.getDegradeAbility() == pb.a.INTERRUPT_IO) {
                    throw e10;
                }
                if (!b3) {
                    throw e10;
                }
                z5 = true;
            }
        }
        z5 = false;
        return (qbVar == null || (bArr = qbVar.f4927a) == null || bArr.length <= 0) ? c(pbVar, a(pbVar, z5), a(pbVar, j4)) : qbVar;
    }

    public static ob b(boolean z5) {
        return a(z5);
    }

    private Map<String, String> b(pb pbVar, pb.b bVar, int i3) throws a9 {
        try {
            d(pbVar);
            pbVar.setDegradeType(bVar);
            pbVar.setReal_max_timeout(i3);
            return new mb().a(pbVar);
        } catch (a9 e10) {
            throw e10;
        } catch (Throwable th2) {
            th2.printStackTrace();
            throw new a9("未知的错误");
        }
    }
}
