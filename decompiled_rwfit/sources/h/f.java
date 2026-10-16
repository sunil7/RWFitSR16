package h;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public int f14130a = -1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f14131b;

    public f(g gVar) {
        this.f14131b = gVar;
        a();
    }

    public final void a() {
        k kVar = this.f14131b.f14134c;
        m mVar = kVar.f14163v;
        if (mVar != null) {
            kVar.i();
            ArrayList arrayList = kVar.f14152j;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (((m) arrayList.get(i3)) == mVar) {
                    this.f14130a = i3;
                    return;
                }
            }
        }
        this.f14130a = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final m getItem(int i3) {
        g gVar = this.f14131b;
        k kVar = gVar.f14134c;
        kVar.i();
        ArrayList arrayList = kVar.f14152j;
        gVar.getClass();
        int i10 = this.f14130a;
        if (i10 >= 0 && i3 >= i10) {
            i3++;
        }
        return (m) arrayList.get(i3);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        g gVar = this.f14131b;
        k kVar = gVar.f14134c;
        kVar.i();
        int size = kVar.f14152j.size();
        gVar.getClass();
        return this.f14130a < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public final View getView(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            g gVar = this.f14131b;
            view = gVar.f14133b.inflate(gVar.e, viewGroup, false);
        }
        ((y) view).d(getItem(i3));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
