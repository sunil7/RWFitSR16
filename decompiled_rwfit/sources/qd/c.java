package qd;

import com.google.android.gms.internal.mlkit_vision_common.i0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17909a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k6.b f17910b;

    public /* synthetic */ c(k6.b bVar, int i3) {
        this.f17909a = i3;
        this.f17910b = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f17909a) {
            case 0:
                ((ArrayList) this.f17910b.C.f36a).clear();
                break;
            case 1:
                ((ArrayList) this.f17910b.C.f36a).clear();
                break;
            case 2:
                ((ArrayList) this.f17910b.C.f36a).clear();
                break;
            default:
                this.f17910b.p("startReadFileThread", i0.a(20484));
                break;
        }
    }
}
