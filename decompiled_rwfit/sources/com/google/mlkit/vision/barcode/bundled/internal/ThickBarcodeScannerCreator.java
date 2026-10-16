package com.google.mlkit.vision.barcode.bundled.internal;

import android.content.Context;
import ba.a;
import ba.b;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.h;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.j;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzba;

@DynamiteApi
/* loaded from: classes.dex */
public class ThickBarcodeScannerCreator extends j {
    public ThickBarcodeScannerCreator() {
        super("com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.k
    public h newBarcodeScanner(a aVar, zzba zzbaVar) {
        return new jc.a((Context) b.B(aVar), zzbaVar);
    }
}
