package g5;

import android.graphics.Bitmap;
import java.io.File;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: b, reason: collision with root package name */
    public File f13868b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap f13869c;

    public final String toString() {
        File file = this.f13872a;
        File file2 = this.f13868b;
        Bitmap bitmap = this.f13869c;
        if (bitmap == null) {
            e.m("cropBitmap");
            throw null;
        }
        return "CropResult(savedFile=" + file + ",\n extra=null,\noriginFile=" + file2 + ", \ncompressBitmap=" + bitmap + ")";
    }
}
