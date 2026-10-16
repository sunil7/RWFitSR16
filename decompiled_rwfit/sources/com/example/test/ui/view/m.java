package com.example.test.ui.view;

import com.scwang.smart.refresh.layout.constant.RefreshState;

/* loaded from: classes.dex */
public abstract /* synthetic */ class m {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f8700a;

    static {
        int[] iArr = new int[RefreshState.values().length];
        f8700a = iArr;
        try {
            iArr[RefreshState.None.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f8700a[RefreshState.PullDownToRefresh.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f8700a[RefreshState.Refreshing.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f8700a[RefreshState.ReleaseToRefresh.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
