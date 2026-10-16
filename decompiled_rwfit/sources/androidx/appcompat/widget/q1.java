package androidx.appcompat.widget;

import android.widget.AbsListView;

/* loaded from: classes.dex */
public abstract class q1 {
    public static boolean a(AbsListView absListView) {
        return absListView.isSelectedChildViewEnabled();
    }

    public static void b(AbsListView absListView, boolean z5) {
        absListView.setSelectedChildViewEnabled(z5);
    }
}
