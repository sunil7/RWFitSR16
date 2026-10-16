package androidx.core.widget;

import android.widget.ListView;

/* loaded from: classes.dex */
public abstract class i {
    public static boolean a(ListView listView, int i3) {
        return listView.canScrollList(i3);
    }

    public static void b(ListView listView, int i3) {
        listView.scrollListBy(i3);
    }
}
