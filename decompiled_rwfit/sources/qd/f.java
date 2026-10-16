package qd;

import androidx.recyclerview.widget.x;
import com.google.android.gms.internal.mlkit_vision_common.i0;

/* loaded from: classes.dex */
public final class f implements rd.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17919a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k6.b f17920b;

    public /* synthetic */ f(k6.b bVar, int i3) {
        this.f17919a = i3;
        this.f17920b = bVar;
    }

    @Override // rd.b
    public final void a(x xVar) {
        switch (this.f17919a) {
            case 0:
                this.f17920b.p("upgradeStep03", xVar);
                break;
            default:
                this.f17920b.E = true;
                this.f17920b.p("exitUpdateMode", xVar);
                break;
        }
    }

    @Override // rd.b
    public final void onSuccess(Object obj) {
        switch (this.f17919a) {
            case 0:
                Integer num = (Integer) obj;
                k6.b bVar = this.f17920b;
                ee.c.b(3, bVar.f17897a, "Step3.请求进入升级模式, 结果码: " + num);
                if (num.intValue() != 0) {
                    a(i0.c(16385, "Device is not allowed to enter the upgrade mode : " + num));
                    break;
                } else {
                    bVar.V();
                    break;
                }
            default:
                Integer num2 = (Integer) obj;
                k6.b bVar2 = this.f17920b;
                ee.c.c(bVar2.f17897a, "exitUpdateMode", "onSuccess >>> " + num2);
                if (num2.intValue() != 0) {
                    a(i0.b(16385, num2.intValue(), "Device return a bad code : " + num2));
                    break;
                } else {
                    bVar2.z();
                    break;
                }
        }
    }
}
