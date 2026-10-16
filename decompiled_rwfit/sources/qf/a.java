package qf;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final class a implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f17935a;

    public a(long j4) {
        this.f17935a = j4;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        wf.b bVar = (wf.b) obj;
        wf.b bVar2 = (wf.b) obj2;
        long j4 = bVar.f19627a * bVar.f19628b;
        long j10 = this.f17935a;
        long abs = Math.abs(j4 - j10);
        long abs2 = Math.abs((bVar2.f19627a * bVar2.f19628b) - j10);
        if (abs < abs2) {
            return -1;
        }
        return abs == abs2 ? 0 : 1;
    }
}
