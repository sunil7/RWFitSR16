package d4;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class g0 implements q {

    /* renamed from: b, reason: collision with root package name */
    public static final Set f12265b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a, reason: collision with root package name */
    public final q f12266a;

    public g0(q qVar) {
        this.f12266a = qVar;
    }

    @Override // d4.q
    public final p a(Object obj, int i3, int i10, x3.f fVar) {
        return this.f12266a.a(new g(((Uri) obj).toString()), i3, i10, fVar);
    }

    @Override // d4.q
    public final boolean b(Object obj) {
        return f12265b.contains(((Uri) obj).getScheme());
    }
}
