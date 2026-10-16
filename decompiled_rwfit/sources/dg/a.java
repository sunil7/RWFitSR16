package dg;

import com.scwang.smart.refresh.layout.constant.RefreshState;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f12384a;

    static {
        int[] iArr = new int[RefreshState.values().length];
        f12384a = iArr;
        try {
            iArr[RefreshState.None.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f12384a[RefreshState.PullDownToRefresh.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f12384a[RefreshState.PullUpToLoad.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f12384a[RefreshState.PullDownCanceled.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f12384a[RefreshState.PullUpCanceled.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f12384a[RefreshState.ReleaseToRefresh.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f12384a[RefreshState.ReleaseToLoad.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f12384a[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f12384a[RefreshState.RefreshReleased.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f12384a[RefreshState.LoadReleased.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f12384a[RefreshState.Refreshing.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f12384a[RefreshState.Loading.ordinal()] = 12;
        } catch (NoSuchFieldError unused12) {
        }
    }
}
