package com.amap.api.maps;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.amap.api.col.p0003sl.b0;
import com.amap.api.maps.AMap;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AMap.OnMapSnapshotListener f5710a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AMap.c f5711b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Runnable f5712c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AMap f5713d;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5714a;

        /* renamed from: com.amap.api.maps.c$a$a, reason: collision with other inner class name */
        public class C0009a implements AMap.OnMapScreenShotListener {
            public C0009a() {
            }

            @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
            public void onMapScreenShot(Bitmap bitmap) {
            }

            @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
            public void onMapScreenShot(Bitmap bitmap, int i3) {
                a aVar = a.this;
                c cVar = c.this;
                ViewGroup viewGroup = aVar.f5714a;
                cVar.getClass();
                ImageView imageView = new ImageView(viewGroup.getContext());
                imageView.setImageBitmap(bitmap);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                viewGroup.addView(imageView);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.2f, 0.2f, 0.2f, 0.2f);
                TranslateAnimation translateAnimation = new TranslateAnimation((float) (viewGroup.getWidth() * 0.05d), -((float) (viewGroup.getWidth() * 0.5d)), (float) (viewGroup.getHeight() * 0.75d), (float) (viewGroup.getHeight() * 0.75d));
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.setStartOffset(Const.L_MIN_WIFI_RESULT);
                animationSet.setDuration(200L);
                animationSet.setFillBefore(true);
                animationSet.setFillAfter(true);
                animationSet.setInterpolator(new AccelerateInterpolator());
                viewGroup.startAnimation(animationSet);
                animationSet.setAnimationListener(new b(cVar, viewGroup));
                c cVar2 = c.this;
                cVar2.f5710a.onMapTile(cVar2.f5711b.b(), bitmap, i3);
                if (!c.this.f5711b.e()) {
                    c.this.f5712c.run();
                    return;
                }
                c cVar3 = c.this;
                AMap aMap = cVar3.f5713d;
                AMap.c cVar4 = cVar3.f5711b;
                AMap.OnMapSnapshotListener onMapSnapshotListener = cVar3.f5710a;
                Runnable runnable = cVar3.f5712c;
                aMap.getClass();
                aMap.animateCamera(cVar4.a(), new d(aMap, new c(aMap, onMapSnapshotListener, cVar4, runnable), runnable));
            }
        }

        public a(ViewGroup viewGroup) {
            this.f5714a = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f5713d.mapDelegate.getMapScreenShot(new C0009a(), c.this.f5711b.d());
        }
    }

    public c(AMap aMap, AMap.OnMapSnapshotListener onMapSnapshotListener, AMap.c cVar, Runnable runnable) {
        this.f5713d = aMap;
        this.f5710a = onMapSnapshotListener;
        this.f5711b = cVar;
        this.f5712c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        if (this.f5713d.mapDelegate instanceof b0) {
            ViewGroup viewGroup = (ViewGroup) ((b0) this.f5713d.mapDelegate).getGLMapView().getParent();
            frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setBackgroundColor(-1);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            int width = viewGroup.getWidth() / 20;
            frameLayout.setPadding(width, width, width, width);
            viewGroup.addView(frameLayout);
        } else {
            frameLayout = null;
        }
        a aVar = new a(frameLayout);
        ViewGroup viewGroup2 = (ViewGroup) frameLayout.getParent();
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.2f, 1.0f, 0.2f);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (float) (viewGroup2.getWidth() * 0.05d), 0.0f, (float) (viewGroup2.getHeight() * 0.75d));
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setDuration(600L);
        animationSet.setFillAfter(true);
        animationSet.setInterpolator(new DecelerateInterpolator());
        frameLayout.startAnimation(animationSet);
        animationSet.setAnimationListener(new com.amap.api.maps.a(this, aVar));
    }
}
