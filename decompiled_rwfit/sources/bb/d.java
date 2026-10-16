package bb;

import android.graphics.Typeface;
import android.text.TextPaint;
import com.google.android.gms.internal.mlkit_vision_barcode.x0;

/* loaded from: classes.dex */
public final class d extends x0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextPaint f3187a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x0 f3188b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f3189c;

    public d(e eVar, TextPaint textPaint, x0 x0Var) {
        this.f3189c = eVar;
        this.f3187a = textPaint;
        this.f3188b = x0Var;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.x0
    public final void a(int i3) {
        this.f3188b.a(i3);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.x0
    public final void b(Typeface typeface, boolean z5) {
        this.f3189c.g(this.f3187a, typeface);
        this.f3188b.b(typeface, z5);
    }
}
