package y6;

import com.example.test.ui.view.divider.FlexibleDividerDecoration$DividerType;

/* loaded from: classes.dex */
public abstract /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f20009a;

    static {
        int[] iArr = new int[FlexibleDividerDecoration$DividerType.values().length];
        f20009a = iArr;
        try {
            iArr[FlexibleDividerDecoration$DividerType.DRAWABLE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20009a[FlexibleDividerDecoration$DividerType.PAINT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f20009a[FlexibleDividerDecoration$DividerType.COLOR.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
