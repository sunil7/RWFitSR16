package b8;

import android.content.Context;
import g8.j;
import java.util.List;
import yh.i;

/* loaded from: classes.dex */
public final class e implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3174a;

    /* renamed from: b, reason: collision with root package name */
    public final i f3175b;

    public /* synthetic */ e(i iVar, int i3) {
        this.f3174a = i3;
        this.f3175b = iVar;
    }

    @Override // dh.a
    public final Object get() {
        i iVar = this.f3175b;
        switch (this.f3174a) {
            case 0:
                return new d((Context) iVar.f20163a, new gc.b(13), new ec.a(13));
            default:
                Context context = (Context) iVar.f20163a;
                List list = j.f13895c;
                return new j(context, "com.google.android.datatransport.events", 4);
        }
    }
}
