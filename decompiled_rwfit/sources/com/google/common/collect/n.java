package com.google.common.collect;

/* loaded from: classes.dex */
public final class n extends p {
    public static p d(int i3) {
        return i3 < 0 ? p.f11110b : i3 > 0 ? p.f11111c : p.f11109a;
    }

    @Override // com.google.common.collect.p
    public final p a(int i3, int i10) {
        return d(i3 < i10 ? -1 : i3 > i10 ? 1 : 0);
    }

    @Override // com.google.common.collect.p
    public final p b(long j4, long j10) {
        return d(j4 < j10 ? -1 : j4 > j10 ? 1 : 0);
    }

    @Override // com.google.common.collect.p
    public final int c() {
        return 0;
    }
}
