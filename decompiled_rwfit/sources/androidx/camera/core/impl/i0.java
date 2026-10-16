package androidx.camera.core.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class i0 implements x.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1419a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ androidx.concurrent.futures.b f1420b;

    public /* synthetic */ i0(androidx.concurrent.futures.b bVar, int i3) {
        this.f1419a = i3;
        this.f1420b = bVar;
    }

    @Override // x.c
    public final void C(Throwable th2) {
        switch (this.f1419a) {
            case 0:
                boolean z5 = th2 instanceof TimeoutException;
                androidx.concurrent.futures.b bVar = this.f1420b;
                if (!z5) {
                    bVar.a(Collections.EMPTY_LIST);
                    break;
                } else {
                    bVar.b(th2);
                    break;
                }
            default:
                this.f1420b.b(th2);
                break;
        }
    }

    @Override // x.c
    public final void onSuccess(Object obj) {
        switch (this.f1419a) {
            case 0:
                List list = (List) obj;
                list.getClass();
                this.f1420b.a(new ArrayList(list));
                break;
            default:
                androidx.concurrent.futures.b bVar = this.f1420b;
                try {
                    bVar.a(obj);
                    break;
                } catch (Throwable th2) {
                    bVar.b(th2);
                }
        }
    }
}
