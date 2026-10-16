package p1;

import android.graphics.Rect;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class c implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f17364a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    public final Rect f17365b = new Rect();

    /* renamed from: c, reason: collision with root package name */
    public final boolean f17366c;

    /* renamed from: d, reason: collision with root package name */
    public final gc.b f17367d;

    public c(boolean z5, gc.b bVar) {
        this.f17366c = z5;
        this.f17367d = bVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        this.f17367d.getClass();
        Rect rect = this.f17364a;
        ((m1.d) obj).d(rect);
        Rect rect2 = this.f17365b;
        ((m1.d) obj2).d(rect2);
        int i3 = rect.top;
        int i10 = rect2.top;
        if (i3 < i10) {
            return -1;
        }
        if (i3 > i10) {
            return 1;
        }
        int i11 = rect.left;
        int i12 = rect2.left;
        boolean z5 = this.f17366c;
        if (i11 < i12) {
            return z5 ? 1 : -1;
        }
        if (i11 > i12) {
            return z5 ? -1 : 1;
        }
        int i13 = rect.bottom;
        int i14 = rect2.bottom;
        if (i13 < i14) {
            return -1;
        }
        if (i13 > i14) {
            return 1;
        }
        int i15 = rect.right;
        int i16 = rect2.right;
        if (i15 < i16) {
            return z5 ? 1 : -1;
        }
        if (i15 > i16) {
            return z5 ? -1 : 1;
        }
        return 0;
    }
}
