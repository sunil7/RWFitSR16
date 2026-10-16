package h;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ExpandedMenuView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

/* loaded from: classes.dex */
public final class g implements x, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public Context f14132a;

    /* renamed from: b, reason: collision with root package name */
    public LayoutInflater f14133b;

    /* renamed from: c, reason: collision with root package name */
    public k f14134c;

    /* renamed from: d, reason: collision with root package name */
    public ExpandedMenuView f14135d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public w f14136f;

    /* renamed from: g, reason: collision with root package name */
    public f f14137g;

    public g(Context context, int i3) {
        this.e = i3;
        this.f14132a = context;
        this.f14133b = LayoutInflater.from(context);
    }

    @Override // h.x
    public final void b(k kVar, boolean z5) {
        w wVar = this.f14136f;
        if (wVar != null) {
            wVar.b(kVar, z5);
        }
    }

    @Override // h.x
    public final void c(w wVar) {
        throw null;
    }

    @Override // h.x
    public final void e(Parcelable parcelable) {
        SparseArray<Parcelable> sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f14135d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // h.x
    public final void g(boolean z5) {
        f fVar = this.f14137g;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // h.x
    public final int getId() {
        return 0;
    }

    @Override // h.x
    public final void h(Context context, k kVar) {
        if (this.f14132a != null) {
            this.f14132a = context;
            if (this.f14133b == null) {
                this.f14133b = LayoutInflater.from(context);
            }
        }
        this.f14134c = kVar;
        f fVar = this.f14137g;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // h.x
    public final boolean i() {
        return false;
    }

    @Override // h.x
    public final Parcelable j() {
        if (this.f14135d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f14135d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    @Override // h.x
    public final boolean k(m mVar) {
        return false;
    }

    @Override // h.x
    public final boolean l(m mVar) {
        return false;
    }

    @Override // h.x
    public final boolean m(d0 d0Var) {
        if (!d0Var.hasVisibleItems()) {
            return false;
        }
        l lVar = new l();
        lVar.f14166a = d0Var;
        Context context = d0Var.f14144a;
        androidx.appcompat.app.i iVar = new androidx.appcompat.app.i(context);
        g gVar = new g(iVar.getContext(), R$layout.abc_list_menu_item_layout);
        lVar.f14168c = gVar;
        gVar.f14136f = lVar;
        d0Var.b(gVar, context);
        g gVar2 = lVar.f14168c;
        if (gVar2.f14137g == null) {
            gVar2.f14137g = new f(gVar2);
        }
        f fVar = gVar2.f14137g;
        androidx.appcompat.app.e eVar = iVar.f506a;
        eVar.f460k = fVar;
        eVar.f461l = lVar;
        View view = d0Var.f14157o;
        if (view != null) {
            eVar.e = view;
        } else {
            eVar.f453c = d0Var.f14156n;
            iVar.setTitle(d0Var.f14155m);
        }
        eVar.f459j = lVar;
        androidx.appcompat.app.j create = iVar.create();
        lVar.f14167b = create;
        create.setOnDismissListener(lVar);
        WindowManager.LayoutParams attributes = lVar.f14167b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        lVar.f14167b.show();
        w wVar = this.f14136f;
        if (wVar == null) {
            return true;
        }
        wVar.c(d0Var);
        return true;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i3, long j4) {
        this.f14134c.q(this.f14137g.getItem(i3), this, 0);
    }
}
