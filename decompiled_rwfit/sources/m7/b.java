package m7;

import android.graphics.Bitmap;
import android.graphics.Paint;

/* loaded from: classes.dex */
public abstract /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f15983a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f15984b;

    static {
        int[] iArr = new int[Bitmap.CompressFormat.values().length];
        f15984b = iArr;
        try {
            iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15984b[Bitmap.CompressFormat.WEBP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f15984b[Bitmap.CompressFormat.JPEG.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[Paint.Align.values().length];
        f15983a = iArr2;
        try {
            iArr2[Paint.Align.LEFT.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f15983a[Paint.Align.RIGHT.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
