package x1;

import androidx.lifecycle.q0;
import androidx.lifecycle.s;

/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f19735a;

    public c(s sVar, q0 q0Var) {
        this.f19735a = sVar;
    }

    public final String toString() {
        int lastIndexOf;
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Object obj = this.f19735a;
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        sb2.append(simpleName);
        sb2.append('{');
        sb2.append(Integer.toHexString(System.identityHashCode(obj)));
        sb2.append("}}");
        return sb2.toString();
    }
}
