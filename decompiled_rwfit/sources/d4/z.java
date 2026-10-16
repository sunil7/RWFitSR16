package d4;

import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* loaded from: classes.dex */
public final class z implements r, l4.a {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f12303a;

    public /* synthetic */ z(Resources resources) {
        this.f12303a = resources;
    }

    @Override // d4.r
    public q c(x xVar) {
        return new b(this.f12303a, xVar.a(Uri.class, ParcelFileDescriptor.class));
    }

    @Override // l4.a
    public z3.s d(z3.s sVar, x3.f fVar) {
        if (sVar == null) {
            return null;
        }
        return new g4.c(this.f12303a, sVar);
    }
}
