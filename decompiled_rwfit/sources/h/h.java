package h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final k f14138a;

    /* renamed from: b, reason: collision with root package name */
    public int f14139b = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14140c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14141d;
    public final LayoutInflater e;

    /* renamed from: f, reason: collision with root package name */
    public final int f14142f;

    public h(k kVar, LayoutInflater layoutInflater, boolean z5, int i3) {
        this.f14141d = z5;
        this.e = layoutInflater;
        this.f14138a = kVar;
        this.f14142f = i3;
        a();
    }

    public final void a() {
        k kVar = this.f14138a;
        m mVar = kVar.f14163v;
        if (mVar != null) {
            kVar.i();
            ArrayList arrayList = kVar.f14152j;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (((m) arrayList.get(i3)) == mVar) {
                    this.f14139b = i3;
                    return;
                }
            }
        }
        this.f14139b = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final m getItem(int i3) {
        ArrayList l3;
        k kVar = this.f14138a;
        if (this.f14141d) {
            kVar.i();
            l3 = kVar.f14152j;
        } else {
            l3 = kVar.l();
        }
        int i10 = this.f14139b;
        if (i10 >= 0 && i3 >= i10) {
            i3++;
        }
        return (m) l3.get(i3);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList l3;
        k kVar = this.f14138a;
        if (this.f14141d) {
            kVar.i();
            l3 = kVar.f14152j;
        } else {
            l3 = kVar.l();
        }
        return this.f14139b < 0 ? l3.size() : l3.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public final View getView(int i3, View view, ViewGroup viewGroup) {
        boolean z5 = false;
        if (view == null) {
            view = this.e.inflate(this.f14142f, viewGroup, false);
        }
        int i10 = getItem(i3).f14170b;
        int i11 = i3 - 1;
        int i12 = i11 >= 0 ? getItem(i11).f14170b : i10;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f14138a.m() && i10 != i12) {
            z5 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z5);
        y yVar = (y) view;
        if (this.f14140c) {
            listMenuItemView.setForceShowIcon(true);
        }
        yVar.d(getItem(i3));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
