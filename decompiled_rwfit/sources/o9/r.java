package o9;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.zzk;

/* loaded from: classes.dex */
public final class r implements ia.b {

    /* renamed from: a, reason: collision with root package name */
    public final c f16884a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16885b;

    /* renamed from: c, reason: collision with root package name */
    public final a f16886c;

    /* renamed from: d, reason: collision with root package name */
    public final long f16887d;
    public final long e;

    public r(c cVar, int i3, a aVar, long j4, long j10) {
        this.f16884a = cVar;
        this.f16885b = i3;
        this.f16886c = aVar;
        this.f16887d = j4;
        this.e = j10;
    }

    public static ConnectionTelemetryConfiguration a(n nVar, com.google.android.gms.common.internal.a aVar, int i3) {
        zzk zzkVar = aVar.f9131u;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzkVar == null ? null : zzkVar.f9142d;
        if (connectionTelemetryConfiguration != null && connectionTelemetryConfiguration.j()) {
            int[] h4 = connectionTelemetryConfiguration.h();
            int i10 = 0;
            if (h4 == null) {
                int[] i11 = connectionTelemetryConfiguration.i();
                if (i11 != null) {
                    while (i10 < i11.length) {
                        if (i11[i10] == i3) {
                            return null;
                        }
                        i10++;
                    }
                }
            } else {
                while (i10 < h4.length) {
                    if (h4[i10] != i3) {
                        i10++;
                    }
                }
            }
            if (nVar.f16879l < connectionTelemetryConfiguration.b()) {
                return connectionTelemetryConfiguration;
            }
        }
        return null;
    }

    @Override // ia.b
    public final void j(ia.f fVar) {
        int i3;
        int i10;
        int i11;
        int i12;
        long j4;
        long j10;
        if (this.f16884a.a()) {
            RootTelemetryConfiguration rootTelemetryConfiguration = (RootTelemetryConfiguration) q9.e.b().f17814a;
            if (rootTelemetryConfiguration == null || rootTelemetryConfiguration.i()) {
                n nVar = (n) this.f16884a.f16859j.get(this.f16886c);
                if (nVar != null) {
                    com.google.android.gms.common.api.c cVar = nVar.f16870b;
                    if (cVar instanceof com.google.android.gms.common.internal.a) {
                        com.google.android.gms.common.internal.a aVar = (com.google.android.gms.common.internal.a) cVar;
                        int i13 = 0;
                        boolean z5 = this.f16887d > 0;
                        int i14 = aVar.f9127p;
                        int i15 = 100;
                        if (rootTelemetryConfiguration != null) {
                            z5 &= rootTelemetryConfiguration.j();
                            int b3 = rootTelemetryConfiguration.b();
                            int h4 = rootTelemetryConfiguration.h();
                            i3 = rootTelemetryConfiguration.getVersion();
                            if (aVar.f9131u != null && !aVar.h()) {
                                ConnectionTelemetryConfiguration a3 = a(nVar, aVar, this.f16885b);
                                if (a3 == null) {
                                    return;
                                }
                                boolean z6 = a3.k() && this.f16887d > 0;
                                h4 = a3.b();
                                z5 = z6;
                            }
                            i11 = b3;
                            i10 = h4;
                        } else {
                            i3 = 0;
                            i10 = 100;
                            i11 = 5000;
                        }
                        c cVar2 = this.f16884a;
                        int i16 = -1;
                        if (fVar.f()) {
                            i12 = 0;
                        } else {
                            if (!((ia.m) fVar).f14401d) {
                                Exception c9 = fVar.c();
                                if (c9 instanceof ApiException) {
                                    Status status = ((ApiException) c9).getStatus();
                                    i15 = status.i();
                                    ConnectionResult b10 = status.b();
                                    if (b10 != null) {
                                        i13 = b10.b();
                                        i12 = i15;
                                    }
                                } else {
                                    i12 = 101;
                                    i13 = -1;
                                }
                            }
                            i12 = i15;
                            i13 = -1;
                        }
                        if (z5) {
                            long j11 = this.f16887d;
                            long j12 = this.e;
                            long currentTimeMillis = System.currentTimeMillis();
                            i16 = (int) (SystemClock.elapsedRealtime() - j12);
                            j10 = currentTimeMillis;
                            j4 = j11;
                        } else {
                            j4 = 0;
                            j10 = 0;
                        }
                        int i17 = i16;
                        cVar2.getClass();
                        s sVar = new s(new MethodInvocation(this.f16885b, i12, i13, j4, j10, null, null, i14, i17), i3, i11, i10);
                        c5.b bVar = cVar2.f16862m;
                        bVar.sendMessage(bVar.obtainMessage(18, sVar));
                    }
                }
            }
        }
    }
}
