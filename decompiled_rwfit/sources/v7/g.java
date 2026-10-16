package v7;

import android.graphics.Matrix;

/* loaded from: classes.dex */
public final class g extends de.i {
    @Override // de.i
    public final void q() {
        Matrix matrix = (Matrix) this.f12358c;
        matrix.reset();
        i iVar = (i) this.f12359d;
        matrix.postTranslate(iVar.f19202b.left, iVar.f19204d - iVar.j());
    }
}
