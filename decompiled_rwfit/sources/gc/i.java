package gc;

import androidx.emoji2.text.m;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;

/* loaded from: classes.dex */
public final class i extends PhantomReference {

    /* renamed from: a, reason: collision with root package name */
    public final Set f14039a;

    /* renamed from: b, reason: collision with root package name */
    public final m f14040b;

    public /* synthetic */ i(a aVar, ReferenceQueue referenceQueue, Set set, m mVar) {
        super(aVar, referenceQueue);
        this.f14039a = set;
        this.f14040b = mVar;
    }
}
