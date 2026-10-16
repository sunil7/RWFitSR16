package eb;

import com.google.android.gms.internal.mlkit_vision_barcode.qb;

/* loaded from: classes.dex */
public final class d extends qb {
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.qb
    public final void a(w wVar, float f2, float f10) {
        wVar.e(0.0f, f10 * f2, 180.0f, 90.0f);
        double d5 = f10;
        double d8 = f2;
        wVar.d((float) (Math.sin(Math.toRadians(90.0f)) * d5 * d8), (float) (Math.sin(Math.toRadians(0.0f)) * d5 * d8));
    }
}
