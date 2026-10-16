package gc;

import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final ReferenceQueue f14023a = new ReferenceQueue();

    /* renamed from: b, reason: collision with root package name */
    public final Set f14024b = Collections.synchronizedSet(new HashSet());
}
