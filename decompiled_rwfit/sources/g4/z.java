package g4;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.io.File;

/* loaded from: classes.dex */
public final class z implements x3.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13867a;

    public /* synthetic */ z(int i3) {
        this.f13867a = i3;
    }

    @Override // x3.g
    public final /* bridge */ /* synthetic */ boolean a(Object obj, x3.f fVar) {
        switch (this.f13867a) {
            case 0:
                break;
            case 1:
                break;
            default:
                break;
        }
        return true;
    }

    @Override // x3.g
    public final z3.s b(Object obj, int i3, int i10, x3.f fVar) {
        switch (this.f13867a) {
            case 0:
                return new y((Bitmap) obj);
            case 1:
                Drawable drawable = (Drawable) obj;
                if (drawable != null) {
                    return new i4.a(drawable, 0);
                }
                return null;
            default:
                return new y((File) obj);
        }
    }
}
