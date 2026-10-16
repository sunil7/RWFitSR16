package d4;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;

/* loaded from: classes.dex */
public final class y implements r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12301a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f12302b;

    public /* synthetic */ y(Resources resources, int i3) {
        this.f12301a = i3;
        this.f12302b = resources;
    }

    @Override // d4.r
    public final q c(x xVar) {
        switch (this.f12301a) {
            case 0:
                return new b(this.f12302b, xVar.a(Uri.class, AssetFileDescriptor.class));
            default:
                return new b(this.f12302b, d0.f12251b);
        }
    }
}
