package androidx.lifecycle;

/* loaded from: classes.dex */
public abstract /* synthetic */ class m {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2379a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f2380b;

    static {
        int[] iArr = new int[Lifecycle$Event.values().length];
        f2380b = iArr;
        try {
            iArr[Lifecycle$Event.ON_CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f2380b[Lifecycle$Event.ON_STOP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f2380b[Lifecycle$Event.ON_START.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f2380b[Lifecycle$Event.ON_PAUSE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f2380b[Lifecycle$Event.ON_RESUME.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f2380b[Lifecycle$Event.ON_DESTROY.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f2380b[Lifecycle$Event.ON_ANY.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        int[] iArr2 = new int[Lifecycle$State.values().length];
        f2379a = iArr2;
        try {
            iArr2[Lifecycle$State.CREATED.ordinal()] = 1;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f2379a[Lifecycle$State.STARTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f2379a[Lifecycle$State.RESUMED.ordinal()] = 3;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f2379a[Lifecycle$State.DESTROYED.ordinal()] = 4;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f2379a[Lifecycle$State.INITIALIZED.ordinal()] = 5;
        } catch (NoSuchFieldError unused12) {
        }
    }
}
