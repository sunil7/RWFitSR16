package p001if;

import com.otaliastudios.cameraview.controls.Flash;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f14425a;

    static {
        int[] iArr = new int[Flash.values().length];
        f14425a = iArr;
        try {
            iArr[Flash.ON.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f14425a[Flash.AUTO.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f14425a[Flash.OFF.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f14425a[Flash.TORCH.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
