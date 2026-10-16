package d4;

import android.net.Uri;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class f0 implements q {

    /* renamed from: b, reason: collision with root package name */
    public static final Set f12257b = Collections.unmodifiableSet(new HashSet(Arrays.asList(Const.STR_FILE, "android.resource", "content")));

    /* renamed from: a, reason: collision with root package name */
    public final Object f12258a;

    public f0(e0 e0Var) {
        this.f12258a = e0Var;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [d4.e0, java.lang.Object] */
    @Override // d4.q
    public final p a(Object obj, int i3, int i10, x3.f fVar) {
        Uri uri = (Uri) obj;
        return new p(new s4.d(uri), this.f12258a.f(uri));
    }

    @Override // d4.q
    public final boolean b(Object obj) {
        return f12257b.contains(((Uri) obj).getScheme());
    }
}
