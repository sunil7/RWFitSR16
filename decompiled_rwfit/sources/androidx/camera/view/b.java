package androidx.camera.view;

import androidx.camera.view.PreviewView;

/* loaded from: classes.dex */
public abstract /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1588a;

    static {
        int[] iArr = new int[PreviewView.ScaleType.values().length];
        f1588a = iArr;
        try {
            iArr[PreviewView.ScaleType.FIT_CENTER.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1588a[PreviewView.ScaleType.FILL_CENTER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1588a[PreviewView.ScaleType.FIT_END.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f1588a[PreviewView.ScaleType.FILL_END.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f1588a[PreviewView.ScaleType.FIT_START.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f1588a[PreviewView.ScaleType.FILL_START.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
