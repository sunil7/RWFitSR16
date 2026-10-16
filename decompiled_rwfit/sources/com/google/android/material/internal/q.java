package com.google.android.material.internal;

import android.graphics.Typeface;
import com.google.android.gms.internal.mlkit_vision_barcode.x0;
import com.google.android.material.chip.Chip;

/* loaded from: classes.dex */
public final class q extends x0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10630a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10631b;

    public /* synthetic */ q(Object obj, int i3) {
        this.f10630a = i3;
        this.f10631b = obj;
    }

    private final void c(int i3) {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.x0
    public final void a(int i3) {
        switch (this.f10630a) {
            case 0:
                s sVar = (s) this.f10631b;
                sVar.f10635d = true;
                r rVar = (r) sVar.e.get();
                if (rVar != null) {
                    rVar.a();
                    break;
                }
                break;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.x0
    public final void b(Typeface typeface, boolean z5) {
        switch (this.f10630a) {
            case 0:
                if (!z5) {
                    s sVar = (s) this.f10631b;
                    sVar.f10635d = true;
                    r rVar = (r) sVar.e.get();
                    if (rVar != null) {
                        rVar.a();
                        break;
                    }
                }
                break;
            default:
                Chip chip = (Chip) this.f10631b;
                qa.c cVar = chip.e;
                chip.setText(cVar.f17883l1 ? cVar.E : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
        }
    }
}
