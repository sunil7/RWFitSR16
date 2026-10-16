package com.dh.imagepick.preview;

import android.view.View;
import androidx.recyclerview.widget.z1;
import com.dh.imagepick.R;

/* loaded from: classes.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageViewerDialogFragment f7140a;

    public e(ImageViewerDialogFragment imageViewerDialogFragment) {
        this.f7140a = imageViewerDialogFragment;
    }

    @Override // com.dh.imagepick.preview.d
    public final void e(z1 viewHolder, View view, float f2) {
        kotlin.jvm.internal.e.f(viewHolder, "viewHolder");
        kotlin.jvm.internal.e.f(view, "view");
        ImageViewerDialogFragment imageViewerDialogFragment = this.f7140a;
        e5.a aVar = imageViewerDialogFragment.f7122q;
        kotlin.jvm.internal.e.c(aVar);
        aVar.f12464b.q(-16777216, f2, 0);
        imageViewerDialogFragment.e0().e(viewHolder, view, f2);
    }

    @Override // com.dh.imagepick.preview.d
    public final void g(z1 viewHolder, View view) {
        kotlin.jvm.internal.e.f(viewHolder, "viewHolder");
        kotlin.jvm.internal.e.f(view, "view");
        Object tag = view.getTag(R.id.viewer_adapter_item_key);
        Long l3 = tag instanceof Long ? (Long) tag : null;
        ImageViewerDialogFragment imageViewerDialogFragment = this.f7140a;
        if (l3 != null) {
            ((j5.f) imageViewerDialogFragment.f7126v.getValue()).getClass();
        }
        com.dh.imagepick.preview.utils.d.a(imageViewerDialogFragment, viewHolder);
        e5.a aVar = imageViewerDialogFragment.f7122q;
        kotlin.jvm.internal.e.c(aVar);
        aVar.f12464b.p(0);
        imageViewerDialogFragment.e0().g(viewHolder, view);
    }

    @Override // com.dh.imagepick.preview.d
    public final void i(z1 viewHolder, View view, float f2) {
        kotlin.jvm.internal.e.f(viewHolder, "viewHolder");
        kotlin.jvm.internal.e.f(view, "view");
        ImageViewerDialogFragment imageViewerDialogFragment = this.f7140a;
        e5.a aVar = imageViewerDialogFragment.f7122q;
        kotlin.jvm.internal.e.c(aVar);
        aVar.f12464b.p(-16777216);
        imageViewerDialogFragment.e0().i(viewHolder, view, f2);
    }
}
