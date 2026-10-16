package wf;

import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class e implements c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19630a;

    @Override // wf.c
    public final List a(List list) {
        switch (this.f19630a) {
            case 0:
                Collections.sort(list);
                Collections.reverse(list);
                break;
            default:
                Collections.sort(list);
                break;
        }
        return list;
    }
}
