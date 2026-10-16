package com.dh.imagepick.preview;

import a2.k;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.z1;
import androidx.viewpager2.widget.ViewPager2;
import com.dh.imagepick.R;
import com.dh.imagepick.preview.widgets.BackgroundView;
import com.dh.imagepick.preview.widgets.InterceptLayout;
import com.google.android.gms.internal.mlkit_vision_barcode.g1;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import de.o;
import java.util.ArrayList;
import oh.l;

/* loaded from: classes.dex */
public class ImageViewerDialogFragment extends b {

    /* renamed from: q, reason: collision with root package name */
    public e5.a f7122q;
    public final eh.b r = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.ImageViewerDialogFragment$events$2
        {
            super(0);
        }

        @Override // oh.a
        public final c invoke() {
            return (c) new o(ImageViewerDialogFragment.this.requireActivity()).q(c.class);
        }
    });

    /* renamed from: s, reason: collision with root package name */
    public final eh.b f7123s = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.ImageViewerDialogFragment$viewModel$2
        {
            super(0);
        }

        @Override // oh.a
        public final g invoke() {
            return (g) new o(ImageViewerDialogFragment.this).q(g.class);
        }
    });

    /* renamed from: t, reason: collision with root package name */
    public final eh.b f7124t = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.ImageViewerDialogFragment$userCallback$2
        @Override // oh.a
        public final j5.g invoke() {
            return new j5.c();
        }
    });

    /* renamed from: u, reason: collision with root package name */
    public final eh.b f7125u = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.ImageViewerDialogFragment$initKey$2
        @Override // oh.a
        public final Long invoke() {
            return 0L;
        }
    });

    /* renamed from: v, reason: collision with root package name */
    public final eh.b f7126v = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.ImageViewerDialogFragment$transformer$2
        @Override // oh.a
        public final j5.f invoke() {
            return new j5.b();
        }
    });

    /* renamed from: w, reason: collision with root package name */
    public final eh.b f7127w = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.ImageViewerDialogFragment$adapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final h5.a invoke() {
            return new h5.a(((Number) ImageViewerDialogFragment.this.f7125u.getValue()).longValue());
        }
    });

    /* renamed from: x, reason: collision with root package name */
    public int f7128x = -1;

    /* renamed from: y, reason: collision with root package name */
    public final eh.b f7129y = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.ImageViewerDialogFragment$adapterListener$2
        {
            super(0);
        }

        @Override // oh.a
        public final e invoke() {
            return new e(ImageViewerDialogFragment.this);
        }
    });

    /* renamed from: z, reason: collision with root package name */
    public final eh.b f7130z = kotlin.a.b(new oh.a() { // from class: com.dh.imagepick.preview.ImageViewerDialogFragment$pagerCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final f invoke() {
            return new f(ImageViewerDialogFragment.this);
        }
    });

    @Override // com.dh.imagepick.preview.b
    public final void X() {
        if (com.dh.imagepick.preview.utils.d.f7152a) {
            return;
        }
        e5.a aVar = this.f7122q;
        kotlin.jvm.internal.e.c(aVar);
        Log.i("viewer", "onBackPressed " + aVar.f12465c.getCurrentItem());
        h5.a Z = Z();
        e5.a aVar2 = this.f7122q;
        kotlin.jvm.internal.e.c(aVar2);
        Z.getItemId(aVar2.f12465c.getCurrentItem());
        e5.a aVar3 = this.f7122q;
        kotlin.jvm.internal.e.c(aVar3);
        View a3 = g1.a(aVar3.f12465c, R.id.viewer_adapter_item_key);
        if (a3 != null) {
            ((j5.f) this.f7126v.getValue()).getClass();
            e5.a aVar4 = this.f7122q;
            kotlin.jvm.internal.e.c(aVar4);
            aVar4.f12464b.p(0);
            Object tag = a3.getTag(R.id.viewer_adapter_item_holder);
            z1 z1Var = tag instanceof z1 ? (z1) tag : null;
            if (z1Var != null) {
                com.dh.imagepick.preview.utils.d.a(this, z1Var);
                e0().g(z1Var, a3);
            }
        }
    }

    public final h5.a Z() {
        return (h5.a) this.f7127w.getValue();
    }

    public final j5.g e0() {
        return (j5.g) this.f7124t.getValue();
    }

    @Override // androidx.fragment.app.p, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        I(true, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.e.f(inflater, "inflater");
        e5.a aVar = this.f7122q;
        if (aVar == null) {
            View inflate = inflater.inflate(R.layout.fragment_image_viewer_dialog, viewGroup, false);
            int i3 = R.id.background;
            BackgroundView backgroundView = (BackgroundView) he.a(i3, inflate);
            if (backgroundView != null) {
                i3 = R.id.overlayView;
                ConstraintLayout constraintLayout = (ConstraintLayout) he.a(i3, inflate);
                if (constraintLayout != null) {
                    i3 = R.id.viewer;
                    ViewPager2 viewPager2 = (ViewPager2) he.a(i3, inflate);
                    if (viewPager2 != null) {
                        aVar = new e5.a((InterceptLayout) inflate, backgroundView, constraintLayout, viewPager2);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
        }
        this.f7122q = aVar;
        return aVar.f12463a;
    }

    @Override // com.dh.imagepick.preview.b, androidx.fragment.app.p, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Z().f14261b = null;
        e5.a aVar = this.f7122q;
        kotlin.jvm.internal.e.c(aVar);
        ((ArrayList) aVar.f12465c.f2949c.f2987b).remove((f) this.f7130z.getValue());
        e5.a aVar2 = this.f7122q;
        kotlin.jvm.internal.e.c(aVar2);
        aVar2.f12465c.setAdapter(null);
        this.f7122q = null;
        Log.i("viewer", "Components release");
    }

    @Override // com.dh.imagepick.preview.b, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.e.f(view, "view");
        super.onViewCreated(view, bundle);
        Z().f14261b = (e) this.f7129y.getValue();
        e5.a aVar = this.f7122q;
        kotlin.jvm.internal.e.c(aVar);
        View childAt = aVar.f12465c.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        if (recyclerView != null) {
            recyclerView.setClipChildren(false);
            recyclerView.setItemAnimator(null);
        }
        e5.a aVar2 = this.f7122q;
        kotlin.jvm.internal.e.c(aVar2);
        aVar2.f12465c.setOrientation(0);
        e5.a aVar3 = this.f7122q;
        kotlin.jvm.internal.e.c(aVar3);
        ((ArrayList) aVar3.f12465c.f2949c.f2987b).add((f) this.f7130z.getValue());
        e5.a aVar4 = this.f7122q;
        kotlin.jvm.internal.e.c(aVar4);
        aVar4.f12465c.setOffscreenPageLimit(1);
        e5.a aVar5 = this.f7122q;
        kotlin.jvm.internal.e.c(aVar5);
        aVar5.f12465c.setAdapter(Z());
        kotlin.jvm.internal.e.c(this.f7122q);
        eh.b bVar = this.f7123s;
        ((g) bVar.getValue()).f7142a.e(getViewLifecycleOwner(), new androidx.camera.lifecycle.d(new l() { // from class: com.dh.imagepick.preview.ImageViewerDialogFragment$onViewCreated$3
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((k) obj);
                return eh.g.f12633a;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x00ca  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x00e2  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke(a2.k r10) {
                /*
                    Method dump skipped, instructions count: 247
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.dh.imagepick.preview.ImageViewerDialogFragment$onViewCreated$3.invoke(a2.k):void");
            }
        }, 2));
        ((g) bVar.getValue()).f7143b.e(getViewLifecycleOwner(), new androidx.camera.lifecycle.d(new l() { // from class: com.dh.imagepick.preview.ImageViewerDialogFragment$onViewCreated$4
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return eh.g.f12633a;
            }

            public final void invoke(Boolean bool) {
                e5.a aVar6 = ImageViewerDialogFragment.this.f7122q;
                kotlin.jvm.internal.e.c(aVar6);
                aVar6.f12465c.setUserInputEnabled(bool == null ? true : bool.booleanValue());
            }
        }, 3));
        ((c) this.r.getValue()).f7133a.e(getViewLifecycleOwner(), new af.a(this, 3));
    }
}
