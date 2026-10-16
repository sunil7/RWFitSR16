package com.dh.imagepick.preview.utils;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.fragment.app.p;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.d0;
import androidx.lifecycle.r;
import androidx.recyclerview.widget.z1;
import com.dh.imagepick.R;
import com.dh.imagepick.preview.widgets.PhotoView2;
import com.dh.imagepick.preview.widgets.SubsamplingScaleImageView2;
import com.dh.imagepick.preview.widgets.video.ExoVideoView2;
import eh.g;
import j2.f;
import j2.f0;
import j2.i;
import j2.i0;
import j2.j0;
import j2.n;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f7152a;

    public static void a(final p fragment, final z1 holder) {
        kotlin.jvm.internal.e.f(fragment, "fragment");
        kotlin.jvm.internal.e.f(holder, "holder");
        if (holder instanceof k5.e) {
            e5.d dVar = ((k5.e) holder).f15510a;
            ImageView imageView = dVar.f12471b;
            ExoVideoView2 exoVideoView2 = dVar.f12472c;
            imageView.setTranslationX(exoVideoView2.getTranslationX());
            ImageView imageView2 = dVar.f12471b;
            imageView2.setTranslationY(exoVideoView2.getTranslationY());
            imageView2.setScaleX(exoVideoView2.getScaleX());
            imageView2.setScaleY(exoVideoView2.getScaleY());
            imageView2.setVisibility(0);
            exoVideoView2.setVisibility(8);
        }
        final View view = null;
        final oh.a aVar = new oh.a() { // from class: com.dh.imagepick.preview.utils.TransitionEndHelper$end$doTransition$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // oh.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m45invoke();
                return g.f12633a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m45invoke() {
                ImageView.ScaleType scaleType;
                View view2 = z1.this.itemView;
                kotlin.jvm.internal.e.d(view2, "null cannot be cast to non-null type android.view.ViewGroup");
                j0 j0Var = new j0();
                j0Var.I(new f());
                j0Var.I(new i());
                n nVar = new n();
                nVar.f15266x = true;
                nVar.f15267y = true;
                nVar.f15268z = new Matrix();
                j0Var.I(nVar);
                j0Var.A(250L);
                j0Var.C(new DecelerateInterpolator());
                j0Var.a(new c(fragment, 0));
                i0.a((ViewGroup) view2, j0Var);
                View view3 = view;
                z1 z1Var = z1.this;
                if (z1Var instanceof k5.a) {
                    k5.a aVar2 = (k5.a) z1Var;
                    PhotoView2 photoView2 = aVar2.f15506a.f12467b;
                    ImageView imageView3 = view3 instanceof ImageView ? (ImageView) view3 : null;
                    if (imageView3 == null || (scaleType = imageView3.getScaleType()) == null) {
                        scaleType = ImageView.ScaleType.FIT_CENTER;
                    }
                    photoView2.setScaleType(scaleType);
                    e5.b bVar = aVar2.f15506a;
                    bVar.f12467b.setTranslationX(0.0f);
                    PhotoView2 photoView22 = bVar.f12467b;
                    photoView22.setTranslationY(0.0f);
                    photoView22.setScaleX(view3 != null ? 1.0f : 2.0f);
                    photoView22.setScaleY(view3 == null ? 2.0f : 1.0f);
                    d.b(z1Var, view3);
                    ViewGroup.LayoutParams layoutParams = photoView22.getLayoutParams();
                    layoutParams.width = view3 != null ? view3.getWidth() : layoutParams.width;
                    layoutParams.height = view3 != null ? view3.getHeight() : layoutParams.height;
                    int[] iArr = new int[2];
                    d.c(view3, iArr);
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        marginLayoutParams.setMarginStart(iArr[0]);
                        marginLayoutParams.topMargin = iArr[1];
                    }
                    photoView22.setLayoutParams(layoutParams);
                    return;
                }
                if (z1Var instanceof k5.b) {
                    k5.b bVar2 = (k5.b) z1Var;
                    bVar2.f15507a.f12469b.setTranslationX(0.0f);
                    e5.c cVar = bVar2.f15507a;
                    cVar.f12469b.setTranslationY(0.0f);
                    SubsamplingScaleImageView2 subsamplingScaleImageView2 = cVar.f12469b;
                    subsamplingScaleImageView2.setScaleX(2.0f);
                    subsamplingScaleImageView2.setScaleY(2.0f);
                    d.b(z1Var, null);
                    ViewGroup.LayoutParams layoutParams2 = subsamplingScaleImageView2.getLayoutParams();
                    layoutParams2.width = view3 != null ? view3.getWidth() : layoutParams2.width;
                    layoutParams2.height = view3 != null ? view3.getHeight() : layoutParams2.height;
                    int[] iArr2 = new int[2];
                    d.c(view3, iArr2);
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                        marginLayoutParams2.setMarginStart(iArr2[0]);
                        marginLayoutParams2.topMargin = iArr2[1];
                    }
                    subsamplingScaleImageView2.setLayoutParams(layoutParams2);
                    return;
                }
                if (z1Var instanceof k5.e) {
                    k5.e eVar = (k5.e) z1Var;
                    eVar.f15510a.f12471b.setTranslationX(0.0f);
                    e5.d dVar2 = eVar.f15510a;
                    dVar2.f12471b.setTranslationY(0.0f);
                    float f2 = view3 != null ? 1.0f : 2.0f;
                    ImageView imageView4 = dVar2.f12471b;
                    imageView4.setScaleX(f2);
                    imageView4.setScaleY(view3 == null ? 2.0f : 1.0f);
                    d.b(z1Var, view3);
                    dVar2.f12472c.a();
                    ViewGroup.LayoutParams layoutParams3 = imageView4.getLayoutParams();
                    layoutParams3.width = view3 != null ? view3.getWidth() : layoutParams3.width;
                    layoutParams3.height = view3 != null ? view3.getHeight() : layoutParams3.height;
                    int[] iArr3 = new int[2];
                    d.c(view3, iArr3);
                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                        marginLayoutParams3.setMarginStart(iArr3[0]);
                        marginLayoutParams3.topMargin = iArr3[1];
                    }
                    imageView4.setLayoutParams(layoutParams3);
                }
            }
        };
        holder.itemView.post(new b(aVar, 0));
        fragment.getLifecycle().a(new r() { // from class: com.dh.imagepick.preview.utils.TransitionEndHelper$end$1
            @d0(Lifecycle$Event.ON_DESTROY)
            public final void onDestroy() {
                p.this.getLifecycle().b(this);
                d.f7152a = false;
                z1 z1Var = holder;
                z1Var.itemView.removeCallbacks(new b(aVar, 1));
                View view2 = z1Var.itemView;
                kotlin.jvm.internal.e.d(view2, "null cannot be cast to non-null type android.view.ViewGroup");
                ViewGroup viewGroup = (ViewGroup) view2;
                i0.f15232c.remove(viewGroup);
                ArrayList arrayList = (ArrayList) i0.b().getOrDefault(viewGroup, null);
                if (arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                ArrayList arrayList2 = new ArrayList(arrayList);
                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                    ((f0) arrayList2.get(size)).n(viewGroup);
                }
            }
        });
    }

    public static void b(z1 z1Var, View view) {
        if (z1Var instanceof k5.a) {
            if (view != null) {
                ((k5.a) z1Var).f15506a.f12467b.animate().setDuration(0L).setStartDelay(Math.max(250 - 20, 0L)).alpha(0.0f).start();
                return;
            } else {
                ((k5.a) z1Var).f15506a.f12467b.animate().setDuration(250L).alpha(0.0f).start();
                return;
            }
        }
        if (z1Var instanceof k5.b) {
            ((k5.b) z1Var).f15507a.f12469b.animate().setDuration(250L).alpha(0.0f).start();
        } else if (z1Var instanceof k5.e) {
            if (view != null) {
                ((k5.e) z1Var).f15510a.f12471b.animate().setDuration(0L).setStartDelay(Math.max(250 - 20, 0L)).alpha(0.0f).start();
            } else {
                ((k5.e) z1Var).f15510a.f12471b.animate().setDuration(250L).alpha(0.0f).start();
            }
        }
    }

    public static void c(View view, int[] iArr) {
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        if (iArr[0] == 0) {
            Object tag = view != null ? view.getTag(R.id.viewer_start_view_location_0) : null;
            Integer num = tag instanceof Integer ? (Integer) tag : null;
            iArr[0] = num != null ? num.intValue() : 0;
        }
        if (iArr[1] == 0) {
            Object tag2 = view != null ? view.getTag(R.id.viewer_start_view_location_1) : null;
            Integer num2 = tag2 instanceof Integer ? (Integer) tag2 : null;
            iArr[1] = num2 != null ? num2.intValue() : 0;
        }
        if (view == null || view.getLayoutDirection() != 1) {
            return;
        }
        iArr[0] = (view.getContext().getResources().getDisplayMetrics().widthPixels - iArr[0]) - view.getWidth();
    }
}
