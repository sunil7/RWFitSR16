package bb;

import android.graphics.Typeface;
import com.google.android.gms.internal.mlkit_vision_barcode.x0;

/* loaded from: classes.dex */
public final class b extends x0 {

    /* renamed from: a, reason: collision with root package name */
    public final Typeface f3182a;

    /* renamed from: b, reason: collision with root package name */
    public final a f3183b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3184c;

    public b(a aVar, Typeface typeface) {
        this.f3182a = typeface;
        this.f3183b = aVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.x0
    public final void a(int i3) {
        if (this.f3184c) {
            return;
        }
        this.f3183b.x(this.f3182a);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.x0
    public final void b(Typeface typeface, boolean z5) {
        if (this.f3184c) {
            return;
        }
        this.f3183b.x(typeface);
    }
}
