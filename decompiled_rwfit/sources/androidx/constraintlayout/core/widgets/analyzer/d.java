package androidx.constraintlayout.core.widgets.analyzer;

/* loaded from: classes.dex */
public abstract /* synthetic */ class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f1626a;

    static {
        int[] iArr = new int[WidgetRun$RunType.values().length];
        f1626a = iArr;
        try {
            iArr[WidgetRun$RunType.START.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1626a[WidgetRun$RunType.END.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1626a[WidgetRun$RunType.CENTER.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
