package com.example.baselibrary.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.baselibrary.preseneter.b;
import com.example.baselibrary.utils.d;
import java.util.WeakHashMap;
import kotlin.a;
import kotlin.jvm.internal.e;
import l1.n0;
import l1.z0;

/* loaded from: classes.dex */
public abstract class BaseFragment<P extends b, B> extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public final eh.b f7250a = a.b(new oh.a(this) { // from class: com.example.baselibrary.base.fragment.BaseFragment$presenter$2
        final /* synthetic */ BaseFragment<P, B> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TP; */
        @Override // oh.a
        public final b invoke() {
            return this.this$0.I();
        }
    });

    /* renamed from: b, reason: collision with root package name */
    public Object f7251b;

    public abstract b I();

    public void V() {
    }

    public abstract View W();

    public final b X() {
        return (b) this.f7250a.getValue();
    }

    public abstract Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void b0() {
    }

    public abstract void e0();

    public abstract void h0();

    public abstract void m0();

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e0();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        e.f(inflater, "inflater");
        this.f7251b = Z(inflater, viewGroup);
        View W = W();
        m0();
        return W;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        X().i();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        h0();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        e.f(view, "view");
        super.onViewCreated(view, bundle);
        b9.a aVar = new b9.a(2);
        WeakHashMap weakHashMap = z0.f15748a;
        n0.u(view, aVar);
    }

    public final void w0(int i3) {
        d.a(i3);
    }
}
