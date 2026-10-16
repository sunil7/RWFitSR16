package o9;

import com.google.android.gms.common.Feature;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final a f16881a;

    /* renamed from: b, reason: collision with root package name */
    public final Feature f16882b;

    public /* synthetic */ o(a aVar, Feature feature) {
        this.f16881a = aVar;
        this.f16882b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof o)) {
            o oVar = (o) obj;
            if (q9.n.h(this.f16881a, oVar.f16881a) && q9.n.h(this.f16882b, oVar.f16882b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f16881a, this.f16882b});
    }

    public final String toString() {
        org.joda.time.format.p pVar = new org.joda.time.format.p(this);
        pVar.a(this.f16881a, "key");
        pVar.a(this.f16882b, "feature");
        return pVar.toString();
    }
}
