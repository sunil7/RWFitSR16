package pf;

import android.media.Image;

/* loaded from: classes2.dex */
public final class d extends c {
    @Override // pf.c
    public final void b(Object obj, boolean z5) {
        try {
            ((Image) obj).close();
        } catch (Exception unused) {
        }
    }
}
