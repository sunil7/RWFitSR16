package r1;

import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;
import m0.k;
import n.l;

/* loaded from: classes.dex */
public final class a implements Choreographer.FrameCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f17985a;

    public a(l lVar) {
        this.f17985a = lVar;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j4) {
        ArrayList arrayList;
        boolean z5;
        long j10;
        float f2;
        boolean z6;
        mc.g gVar = (mc.g) this.f17985a.f16245b;
        gVar.getClass();
        long uptimeMillis = SystemClock.uptimeMillis();
        b bVar = (b) gVar.f16022b;
        bVar.getClass();
        long uptimeMillis2 = SystemClock.uptimeMillis();
        int i3 = 0;
        while (true) {
            arrayList = bVar.f17988b;
            if (i3 >= arrayList.size()) {
                break;
            }
            g gVar2 = (g) arrayList.get(i3);
            if (gVar2 != null) {
                k kVar = bVar.f17987a;
                Long l3 = (Long) kVar.getOrDefault(gVar2, null);
                if (l3 != null) {
                    if (l3.longValue() < uptimeMillis2) {
                        kVar.remove(gVar2);
                    }
                }
                long j11 = gVar2.f18005h;
                if (j11 == 0) {
                    gVar2.f18005h = uptimeMillis;
                    gVar2.b(gVar2.f18000b);
                } else {
                    long j12 = uptimeMillis - j11;
                    gVar2.f18005h = uptimeMillis;
                    h hVar = (h) gVar2;
                    if (hVar.f18009s != Float.MAX_VALUE) {
                        i iVar = hVar.r;
                        z5 = true;
                        double d5 = iVar.f18017i;
                        long j13 = j12 / 2;
                        d a3 = iVar.a(j13, hVar.f18000b, hVar.f17999a);
                        i iVar2 = hVar.r;
                        iVar2.f18017i = hVar.f18009s;
                        hVar.f18009s = Float.MAX_VALUE;
                        d a10 = iVar2.a(j13, a3.f17991a, a3.f17992b);
                        hVar.f18000b = a10.f17991a;
                        hVar.f17999a = a10.f17992b;
                        j10 = uptimeMillis;
                        f2 = Float.MAX_VALUE;
                    } else {
                        z5 = true;
                        j10 = uptimeMillis;
                        f2 = Float.MAX_VALUE;
                        d a11 = hVar.r.a(j12, hVar.f18000b, hVar.f17999a);
                        hVar.f18000b = a11.f17991a;
                        hVar.f17999a = a11.f17992b;
                    }
                    float max = Math.max(hVar.f18000b, hVar.f18004g);
                    hVar.f18000b = max;
                    hVar.f18000b = Math.min(max, f2);
                    float f10 = hVar.f17999a;
                    i iVar3 = hVar.r;
                    iVar3.getClass();
                    if (Math.abs(f10) >= iVar3.e || Math.abs(r3 - ((float) iVar3.f18017i)) >= iVar3.f18013d) {
                        z6 = false;
                    } else {
                        hVar.f18000b = (float) hVar.r.f18017i;
                        hVar.f17999a = 0.0f;
                        z6 = z5;
                    }
                    float min = Math.min(gVar2.f18000b, f2);
                    gVar2.f18000b = min;
                    float max2 = Math.max(min, gVar2.f18004g);
                    gVar2.f18000b = max2;
                    gVar2.b(max2);
                    if (z6) {
                        gVar2.a();
                    }
                    i3++;
                    uptimeMillis = j10;
                }
            }
            j10 = uptimeMillis;
            i3++;
            uptimeMillis = j10;
        }
        if (bVar.e) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size) == null) {
                    arrayList.remove(size);
                }
            }
            bVar.e = false;
        }
        if (arrayList.size() > 0) {
            if (bVar.f17990d == null) {
                bVar.f17990d = new l(bVar.f17989c);
            }
            l lVar = bVar.f17990d;
            ((Choreographer) lVar.f16246c).postFrameCallback((a) lVar.f16247d);
        }
    }
}
