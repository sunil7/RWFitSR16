package r0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.h f17977a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f17978b;

    public static long a(androidx.constraintlayout.core.widgets.analyzer.a aVar, long j4) {
        androidx.constraintlayout.core.widgets.analyzer.h hVar = aVar.f1617d;
        if (hVar instanceof androidx.constraintlayout.core.widgets.analyzer.c) {
            return j4;
        }
        ArrayList arrayList = aVar.f1623k;
        int size = arrayList.size();
        long j10 = j4;
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = (d) arrayList.get(i3);
            if (dVar instanceof androidx.constraintlayout.core.widgets.analyzer.a) {
                androidx.constraintlayout.core.widgets.analyzer.a aVar2 = (androidx.constraintlayout.core.widgets.analyzer.a) dVar;
                if (aVar2.f1617d != hVar) {
                    j10 = Math.min(j10, a(aVar2, aVar2.f1618f + j4));
                }
            }
        }
        if (aVar != hVar.f1638i) {
            return j10;
        }
        long j11 = hVar.j();
        long j12 = j4 - j11;
        return Math.min(Math.min(j10, a(hVar.f1637h, j12)), j12 - r9.f1618f);
    }

    public static long b(androidx.constraintlayout.core.widgets.analyzer.a aVar, long j4) {
        androidx.constraintlayout.core.widgets.analyzer.h hVar = aVar.f1617d;
        if (hVar instanceof androidx.constraintlayout.core.widgets.analyzer.c) {
            return j4;
        }
        ArrayList arrayList = aVar.f1623k;
        int size = arrayList.size();
        long j10 = j4;
        for (int i3 = 0; i3 < size; i3++) {
            d dVar = (d) arrayList.get(i3);
            if (dVar instanceof androidx.constraintlayout.core.widgets.analyzer.a) {
                androidx.constraintlayout.core.widgets.analyzer.a aVar2 = (androidx.constraintlayout.core.widgets.analyzer.a) dVar;
                if (aVar2.f1617d != hVar) {
                    j10 = Math.max(j10, b(aVar2, aVar2.f1618f + j4));
                }
            }
        }
        if (aVar != hVar.f1637h) {
            return j10;
        }
        long j11 = hVar.j();
        long j12 = j4 + j11;
        return Math.max(Math.max(j10, b(hVar.f1638i, j12)), j12 - r9.f1618f);
    }
}
