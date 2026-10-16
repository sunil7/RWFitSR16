package androidx.camera.camera2.internal;

import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.s1;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f1136a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1137b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s1 f1138c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a2 f1139d;
    public final /* synthetic */ androidx.camera.core.impl.h e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ List f1140f;

    public /* synthetic */ b(i iVar, String str, s1 s1Var, a2 a2Var, androidx.camera.core.impl.h hVar, List list) {
        this.f1136a = iVar;
        this.f1137b = str;
        this.f1138c = s1Var;
        this.f1139d = a2Var;
        this.e = hVar;
        this.f1140f = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar = this.f1136a;
        String str = this.f1137b;
        s1 s1Var = this.f1138c;
        a2 a2Var = this.f1139d;
        androidx.camera.core.impl.h hVar = this.e;
        List list = this.f1140f;
        iVar.getClass();
        iVar.s("Use case " + str + " RESET", null);
        iVar.f1238a.J(str, s1Var, a2Var, hVar, list);
        iVar.o();
        iVar.C();
        iVar.J();
        if (iVar.e == Camera2CameraImpl$InternalState.OPENED) {
            iVar.A();
        }
    }
}
