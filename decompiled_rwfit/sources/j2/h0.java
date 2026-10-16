package j2;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public f0 f15225a;

    /* renamed from: b, reason: collision with root package name */
    public ViewGroup f15226b;

    /* JADX WARN: Removed duplicated region for block: B:119:0x01ed A[EDGE_INSN: B:119:0x01ed->B:120:0x01ed BREAK  A[LOOP:1: B:16:0x0086->B:28:0x01e3], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onPreDraw() {
        /*
            Method dump skipped, instructions count: 698
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.h0.onPreDraw():boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        ViewGroup viewGroup = this.f15226b;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        viewGroup.removeOnAttachStateChangeListener(this);
        ArrayList arrayList = i0.f15232c;
        ViewGroup viewGroup2 = this.f15226b;
        arrayList.remove(viewGroup2);
        ArrayList arrayList2 = (ArrayList) i0.b().getOrDefault(viewGroup2, null);
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                ((f0) obj).y(viewGroup2);
            }
        }
        this.f15225a.i(true);
    }
}
