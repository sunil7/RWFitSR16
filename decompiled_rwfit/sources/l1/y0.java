package l1;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.R$id;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: d, reason: collision with root package name */
    public static final ArrayList f15739d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f15740a;

    /* renamed from: b, reason: collision with root package name */
    public SparseArray f15741b;

    /* renamed from: c, reason: collision with root package name */
    public WeakReference f15742c;

    public final View a(View view) {
        int size;
        WeakHashMap weakHashMap = this.f15740a;
        if (weakHashMap == null || !weakHashMap.containsKey(view)) {
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View a3 = a(viewGroup.getChildAt(childCount));
                if (a3 != null) {
                    return a3;
                }
            }
        }
        ArrayList arrayList = (ArrayList) view.getTag(R$id.tag_unhandled_key_listeners);
        if (arrayList == null || arrayList.size() - 1 < 0) {
            return null;
        }
        throw android.support.v4.media.session.e.c(size, arrayList);
    }
}
