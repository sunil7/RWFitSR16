package t;

import androidx.camera.core.ImageProcessingUtil;

/* loaded from: classes.dex */
public final /* synthetic */ class o0 implements w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18371a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p0 f18372b;

    public /* synthetic */ o0(p0 p0Var, p0 p0Var2, int i3) {
        this.f18371a = i3;
        this.f18372b = p0Var2;
    }

    @Override // t.w
    public final void a(x xVar) {
        p0 p0Var = this.f18372b;
        switch (this.f18371a) {
            case 0:
                int i3 = ImageProcessingUtil.f1285a;
                if (p0Var != null) {
                    p0Var.close();
                    break;
                }
                break;
            default:
                int i10 = ImageProcessingUtil.f1285a;
                p0Var.close();
                break;
        }
    }
}
