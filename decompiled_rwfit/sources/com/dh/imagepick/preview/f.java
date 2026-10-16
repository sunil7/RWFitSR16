package com.dh.imagepick.preview;

import android.view.View;
import androidx.recyclerview.widget.z1;
import androidx.viewpager2.widget.j;
import com.dh.imagepick.R;
import com.google.android.gms.internal.mlkit_vision_barcode.g1;

/* loaded from: classes.dex */
public final class f extends j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageViewerDialogFragment f7141a;

    public f(ImageViewerDialogFragment imageViewerDialogFragment) {
        this.f7141a = imageViewerDialogFragment;
    }

    @Override // androidx.viewpager2.widget.j
    public final void a(int i3) {
        this.f7141a.e0().getClass();
    }

    @Override // androidx.viewpager2.widget.j
    public final void b(int i3, float f2, int i10) {
        this.f7141a.e0().getClass();
    }

    @Override // androidx.viewpager2.widget.j
    public final void c(int i3) {
        ImageViewerDialogFragment imageViewerDialogFragment = this.f7141a;
        imageViewerDialogFragment.Z().getItemId(i3);
        e5.a aVar = imageViewerDialogFragment.f7122q;
        kotlin.jvm.internal.e.c(aVar);
        View a3 = g1.a(aVar.f12465c, R.id.viewer_adapter_item_key);
        Object tag = a3 != null ? a3.getTag(R.id.viewer_adapter_item_holder) : null;
        z1 z1Var = tag instanceof z1 ? (z1) tag : null;
        if (z1Var == null) {
            return;
        }
        imageViewerDialogFragment.e0().a(z1Var, i3);
    }
}
