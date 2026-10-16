package yh;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes2.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Method f20171a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadMode f20172b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f20173c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20174d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public String f20175f;

    public m(Method method, Class cls, ThreadMode threadMode, int i3, boolean z5) {
        this.f20171a = method;
        this.f20172b = threadMode;
        this.f20173c = cls;
        this.f20174d = i3;
        this.e = z5;
    }

    public final synchronized void a() {
        if (this.f20175f == null) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append(this.f20171a.getDeclaringClass().getName());
            sb2.append('#');
            sb2.append(this.f20171a.getName());
            sb2.append('(');
            sb2.append(this.f20173c.getName());
            this.f20175f = sb2.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        a();
        m mVar = (m) obj;
        mVar.a();
        return this.f20175f.equals(mVar.f20175f);
    }

    public final int hashCode() {
        return this.f20171a.hashCode();
    }
}
