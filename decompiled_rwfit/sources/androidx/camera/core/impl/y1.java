package androidx.camera.core.impl;

import java.util.List;

/* loaded from: classes.dex */
public final class y1 {

    /* renamed from: a, reason: collision with root package name */
    public final s1 f1529a;

    /* renamed from: b, reason: collision with root package name */
    public final a2 f1530b;

    /* renamed from: c, reason: collision with root package name */
    public final h f1531c;

    /* renamed from: d, reason: collision with root package name */
    public final List f1532d;
    public boolean e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1533f = false;

    public y1(s1 s1Var, a2 a2Var, h hVar, List list) {
        this.f1529a = s1Var;
        this.f1530b = a2Var;
        this.f1531c = hVar;
        this.f1532d = list;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("UseCaseAttachInfo{mSessionConfig=");
        sb2.append(this.f1529a);
        sb2.append(", mUseCaseConfig=");
        sb2.append(this.f1530b);
        sb2.append(", mStreamSpec=");
        sb2.append(this.f1531c);
        sb2.append(", mCaptureTypes=");
        sb2.append(this.f1532d);
        sb2.append(", mAttached=");
        sb2.append(this.e);
        sb2.append(", mActive=");
        return android.support.v4.media.session.e.o(sb2, this.f1533f, '}');
    }
}
