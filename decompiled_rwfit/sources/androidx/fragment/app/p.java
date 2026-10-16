package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.runtime.R$id;

/* loaded from: classes.dex */
public class p extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public Handler f2236a;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2244j;

    /* renamed from: l, reason: collision with root package name */
    public Dialog f2246l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2247m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2248n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2249o;

    /* renamed from: b, reason: collision with root package name */
    public final f f2237b = new f(this, 3);

    /* renamed from: c, reason: collision with root package name */
    public final m f2238c = new m(this);

    /* renamed from: d, reason: collision with root package name */
    public final n f2239d = new n(this);
    public int e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f2240f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2241g = true;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2242h = true;

    /* renamed from: i, reason: collision with root package name */
    public int f2243i = -1;

    /* renamed from: k, reason: collision with root package name */
    public final s f2245k = new s(this, 2);

    /* renamed from: p, reason: collision with root package name */
    public boolean f2250p = false;

    public final void I(boolean z5, boolean z6) {
        if (this.f2248n) {
            return;
        }
        this.f2248n = true;
        this.f2249o = false;
        Dialog dialog = this.f2246l;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f2246l.dismiss();
            if (!z6) {
                if (Looper.myLooper() == this.f2236a.getLooper()) {
                    onDismiss(this.f2246l);
                } else {
                    this.f2236a.post(this.f2237b);
                }
            }
        }
        this.f2247m = true;
        if (this.f2243i >= 0) {
            t0 parentFragmentManager = getParentFragmentManager();
            int i3 = this.f2243i;
            parentFragmentManager.getClass();
            if (i3 < 0) {
                throw new IllegalArgumentException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "Bad id: "));
            }
            parentFragmentManager.q(new r0(parentFragmentManager, i3), false);
            this.f2243i = -1;
            return;
        }
        t0 parentFragmentManager2 = getParentFragmentManager();
        parentFragmentManager2.getClass();
        a aVar = new a(parentFragmentManager2);
        aVar.g(this);
        if (z5) {
            aVar.d(true);
        } else {
            aVar.d(false);
        }
    }

    public Dialog W() {
        if (t0.B(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(requireContext(), this.f2240f);
    }

    @Override // androidx.fragment.app.Fragment
    public final f0 createFragmentContainer() {
        return new o(this, super.createFragmentContainer());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().f(this.f2245k);
        if (this.f2249o) {
            return;
        }
        this.f2248n = false;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2236a = new Handler();
        this.f2242h = this.mContainerId == 0;
        if (bundle != null) {
            this.e = bundle.getInt("android:style", 0);
            this.f2240f = bundle.getInt("android:theme", 0);
            this.f2241g = bundle.getBoolean("android:cancelable", true);
            this.f2242h = bundle.getBoolean("android:showsDialog", this.f2242h);
            this.f2243i = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.f2246l;
        if (dialog != null) {
            this.f2247m = true;
            dialog.setOnDismissListener(null);
            this.f2246l.dismiss();
            if (!this.f2248n) {
                onDismiss(this.f2246l);
            }
            this.f2246l = null;
            this.f2250p = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        if (!this.f2249o && !this.f2248n) {
            this.f2248n = true;
        }
        getViewLifecycleOwnerLiveData().j(this.f2245k);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f2247m) {
            return;
        }
        if (t0.B(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        I(true, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046 A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:10:0x001a, B:12:0x0026, B:18:0x003e, B:20:0x0046, B:21:0x0050, B:23:0x0030, B:25:0x0036, B:26:0x003b, B:27:0x0068), top: B:9:0x001a }] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.LayoutInflater onGetLayoutInflater(android.os.Bundle r8) {
        /*
            r7 = this;
            android.view.LayoutInflater r8 = super.onGetLayoutInflater(r8)
            boolean r0 = r7.f2242h
            java.lang.String r1 = "FragmentManager"
            r2 = 2
            if (r0 == 0) goto L9a
            boolean r3 = r7.f2244j
            if (r3 == 0) goto L11
            goto L9a
        L11:
            if (r0 != 0) goto L14
            goto L71
        L14:
            boolean r0 = r7.f2250p
            if (r0 != 0) goto L71
            r0 = 0
            r3 = 1
            r7.f2244j = r3     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r4 = r7.W()     // Catch: java.lang.Throwable -> L4e
            r7.f2246l = r4     // Catch: java.lang.Throwable -> L4e
            boolean r5 = r7.f2242h     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L68
            int r5 = r7.e     // Catch: java.lang.Throwable -> L4e
            if (r5 == r3) goto L3b
            if (r5 == r2) goto L3b
            r6 = 3
            if (r5 == r6) goto L30
            goto L3e
        L30:
            android.view.Window r5 = r4.getWindow()     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L3b
            r6 = 24
            r5.addFlags(r6)     // Catch: java.lang.Throwable -> L4e
        L3b:
            r4.requestWindowFeature(r3)     // Catch: java.lang.Throwable -> L4e
        L3e:
            android.content.Context r4 = r7.getContext()     // Catch: java.lang.Throwable -> L4e
            boolean r5 = r4 instanceof android.app.Activity     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L50
            android.app.Dialog r5 = r7.f2246l     // Catch: java.lang.Throwable -> L4e
            android.app.Activity r4 = (android.app.Activity) r4     // Catch: java.lang.Throwable -> L4e
            r5.setOwnerActivity(r4)     // Catch: java.lang.Throwable -> L4e
            goto L50
        L4e:
            r8 = move-exception
            goto L6e
        L50:
            android.app.Dialog r4 = r7.f2246l     // Catch: java.lang.Throwable -> L4e
            boolean r5 = r7.f2241g     // Catch: java.lang.Throwable -> L4e
            r4.setCancelable(r5)     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r4 = r7.f2246l     // Catch: java.lang.Throwable -> L4e
            androidx.fragment.app.m r5 = r7.f2238c     // Catch: java.lang.Throwable -> L4e
            r4.setOnCancelListener(r5)     // Catch: java.lang.Throwable -> L4e
            android.app.Dialog r4 = r7.f2246l     // Catch: java.lang.Throwable -> L4e
            androidx.fragment.app.n r5 = r7.f2239d     // Catch: java.lang.Throwable -> L4e
            r4.setOnDismissListener(r5)     // Catch: java.lang.Throwable -> L4e
            r7.f2250p = r3     // Catch: java.lang.Throwable -> L4e
            goto L6b
        L68:
            r3 = 0
            r7.f2246l = r3     // Catch: java.lang.Throwable -> L4e
        L6b:
            r7.f2244j = r0
            goto L71
        L6e:
            r7.f2244j = r0
            throw r8
        L71:
            boolean r0 = androidx.fragment.app.t0.B(r2)
            if (r0 == 0) goto L8d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "get layout inflater for DialogFragment "
            r0.<init>(r2)
            r0.append(r7)
            java.lang.String r2 = " from dialog context"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L8d:
            android.app.Dialog r0 = r7.f2246l
            if (r0 == 0) goto Ld5
            android.content.Context r0 = r0.getContext()
            android.view.LayoutInflater r8 = r8.cloneInContext(r0)
            return r8
        L9a:
            boolean r0 = androidx.fragment.app.t0.B(r2)
            if (r0 == 0) goto Ld5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "getting layout inflater for DialogFragment "
            r0.<init>(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            boolean r2 = r7.f2242h
            if (r2 != 0) goto Lc4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "mShowsDialog = false: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.d(r1, r0)
            return r8
        Lc4:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "mCreatingDialog = true: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.d(r1, r0)
        Ld5:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.p.onGetLayoutInflater(android.os.Bundle):android.view.LayoutInflater");
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.f2246l;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i3 = this.e;
        if (i3 != 0) {
            bundle.putInt("android:style", i3);
        }
        int i10 = this.f2240f;
        if (i10 != 0) {
            bundle.putInt("android:theme", i10);
        }
        boolean z5 = this.f2241g;
        if (!z5) {
            bundle.putBoolean("android:cancelable", z5);
        }
        boolean z6 = this.f2242h;
        if (!z6) {
            bundle.putBoolean("android:showsDialog", z6);
        }
        int i11 = this.f2243i;
        if (i11 != -1) {
            bundle.putInt("android:backStackId", i11);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = this.f2246l;
        if (dialog != null) {
            this.f2247m = false;
            dialog.show();
            View decorView = this.f2246l.getWindow().getDecorView();
            decorView.setTag(R$id.view_tree_lifecycle_owner, this);
            decorView.setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this);
            decorView.setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog dialog = this.f2246l;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.f2246l == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f2246l.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.Fragment
    public final void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.f2246l == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f2246l.onRestoreInstanceState(bundle2);
    }
}
