package androidx.camera.camera2.internal.compat;

/* loaded from: classes.dex */
public final /* synthetic */ class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1216a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f1217b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f1218c;

    public /* synthetic */ s(t tVar, String str, int i3) {
        this.f1216a = i3;
        this.f1217b = tVar;
        this.f1218c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1216a) {
            case 0:
                this.f1217b.f1220b.onCameraAvailable(this.f1218c);
                break;
            default:
                this.f1217b.f1220b.onCameraUnavailable(this.f1218c);
                break;
        }
    }
}
