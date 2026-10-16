package a4;

/* loaded from: classes.dex */
public final class f extends a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f87b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(int i3) {
        super(0);
        this.f87b = i3;
    }

    public final i j() {
        switch (this.f87b) {
            case 0:
                return new e(this);
            default:
                return new k(this);
        }
    }
}
