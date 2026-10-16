package androidx.appcompat.widget;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

/* loaded from: classes.dex */
public final class k0 implements q0, DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public androidx.appcompat.app.j f947a;

    /* renamed from: b, reason: collision with root package name */
    public l0 f948b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f949c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppCompatSpinner f950d;

    public k0(AppCompatSpinner appCompatSpinner) {
        this.f950d = appCompatSpinner;
    }

    @Override // androidx.appcompat.widget.q0
    public final boolean a() {
        androidx.appcompat.app.j jVar = this.f947a;
        if (jVar != null) {
            return jVar.isShowing();
        }
        return false;
    }

    @Override // androidx.appcompat.widget.q0
    public final int b() {
        return 0;
    }

    @Override // androidx.appcompat.widget.q0
    public final Drawable c() {
        return null;
    }

    @Override // androidx.appcompat.widget.q0
    public final void dismiss() {
        androidx.appcompat.app.j jVar = this.f947a;
        if (jVar != null) {
            jVar.dismiss();
            this.f947a = null;
        }
    }

    @Override // androidx.appcompat.widget.q0
    public final void e(CharSequence charSequence) {
        this.f949c = charSequence;
    }

    @Override // androidx.appcompat.widget.q0
    public final void g(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.q0
    public final void h(int i3) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.q0
    public final void i(int i3) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.q0
    public final void j(int i3) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // androidx.appcompat.widget.q0
    public final void k(int i3, int i10) {
        if (this.f948b == null) {
            return;
        }
        AppCompatSpinner appCompatSpinner = this.f950d;
        androidx.appcompat.app.i iVar = new androidx.appcompat.app.i(appCompatSpinner.getPopupContext());
        CharSequence charSequence = this.f949c;
        if (charSequence != null) {
            iVar.setTitle(charSequence);
        }
        l0 l0Var = this.f948b;
        int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
        androidx.appcompat.app.e eVar = iVar.f506a;
        eVar.f460k = l0Var;
        eVar.f461l = this;
        eVar.f464o = selectedItemPosition;
        eVar.f463n = true;
        androidx.appcompat.app.j create = iVar.create();
        this.f947a = create;
        AlertController$RecycleListView alertController$RecycleListView = create.e.e;
        i0.d(alertController$RecycleListView, i3);
        i0.c(alertController$RecycleListView, i10);
        this.f947a.show();
    }

    @Override // androidx.appcompat.widget.q0
    public final int l() {
        return 0;
    }

    @Override // androidx.appcompat.widget.q0
    public final CharSequence o() {
        return this.f949c;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        AppCompatSpinner appCompatSpinner = this.f950d;
        appCompatSpinner.setSelection(i3);
        if (appCompatSpinner.getOnItemClickListener() != null) {
            appCompatSpinner.performItemClick(null, i3, this.f948b.getItemId(i3));
        }
        dismiss();
    }

    @Override // androidx.appcompat.widget.q0
    public final void p(ListAdapter listAdapter) {
        this.f948b = (l0) listAdapter;
    }
}
