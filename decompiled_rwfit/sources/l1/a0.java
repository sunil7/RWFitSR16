package l1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;

/* loaded from: classes.dex */
public abstract class a0 {
    public static PointerIcon a(Bitmap bitmap, float f2, float f10) {
        return PointerIcon.create(bitmap, f2, f10);
    }

    public static PointerIcon b(Context context, int i3) {
        return PointerIcon.getSystemIcon(context, i3);
    }

    public static PointerIcon c(Resources resources, int i3) {
        return PointerIcon.load(resources, i3);
    }
}
