package vh;

import ef.i;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class f implements Iterable, ph.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f19269a;

    public f(i iVar) {
        this.f19269a = iVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new kotlin.text.b(this.f19269a);
    }
}
