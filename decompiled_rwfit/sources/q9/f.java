package q9;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class f implements com.google.android.gms.common.api.b {

    /* renamed from: b, reason: collision with root package name */
    public static final f f17815b = new f(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f17816a;

    public /* synthetic */ f(String str) {
        this.f17816a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return n.h(this.f17816a, ((f) obj).f17816a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f17816a});
    }
}
