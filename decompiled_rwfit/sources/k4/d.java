package k4;

import android.content.Context;
import android.graphics.Bitmap;
import java.security.MessageDigest;
import z3.s;

/* loaded from: classes.dex */
public final class d implements x3.i {

    /* renamed from: b, reason: collision with root package name */
    public final x3.i f15479b;

    public d(x3.i iVar) {
        t4.f.c(iVar, "Argument must not be null");
        this.f15479b = iVar;
    }

    @Override // x3.i
    public final s a(Context context, s sVar, int i3, int i10) {
        c cVar = (c) sVar.get();
        s cVar2 = new g4.c(com.bumptech.glide.b.b(context).f6908a, ((h) cVar.f15470a.f15469b).f15496l);
        x3.i iVar = this.f15479b;
        s a3 = iVar.a(context, cVar2, i3, i10);
        if (!cVar2.equals(a3)) {
            cVar2.recycle();
        }
        ((h) cVar.f15470a.f15469b).c(iVar, (Bitmap) a3.get());
        return sVar;
    }

    @Override // x3.c
    public final void b(MessageDigest messageDigest) {
        this.f15479b.b(messageDigest);
    }

    @Override // x3.c
    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f15479b.equals(((d) obj).f15479b);
        }
        return false;
    }

    @Override // x3.c
    public final int hashCode() {
        return this.f15479b.hashCode();
    }
}
