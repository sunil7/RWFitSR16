package kotlin.collections;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes2.dex */
public final class a {
    public static void a(int i3, int i10) {
        if (i3 < 0 || i3 >= i10) {
            throw new IndexOutOfBoundsException(l0.i(i3, i10, "index: ", ", size: "));
        }
    }
}
