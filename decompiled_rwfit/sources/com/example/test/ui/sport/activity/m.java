package com.example.test.ui.sport.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import androidx.core.widget.NestedScrollView;
import com.amap.api.maps.AMap;
import com.example.test.ui.XXBaseActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.aa;
import com.google.android.gms.internal.mlkit_vision_barcode.c2;
import f6.f2;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class m implements a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8179a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XXBaseActivity f8180b;

    public /* synthetic */ m(XXBaseActivity xXBaseActivity, int i3) {
        this.f8179a = i3;
        this.f8180b = xXBaseActivity;
    }

    @Override // a7.e
    public final void B() {
        switch (this.f8179a) {
            case 0:
                final SportNewRecordDetailActivity sportNewRecordDetailActivity = (SportNewRecordDetailActivity) this.f8180b;
                sportNewRecordDetailActivity.V();
                h6.b bVar = sportNewRecordDetailActivity.G;
                ArrayList arrayList = bVar != null ? bVar.f14275k : null;
                if (arrayList != null && !arrayList.isEmpty()) {
                    com.example.baselibrary.utils.b.x("", new oh.l() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$initView$1$onRightEvent$3
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public final Boolean invoke(String it) {
                            kotlin.jvm.internal.e.f(it, "it");
                            SportNewRecordDetailActivity sportNewRecordDetailActivity2 = SportNewRecordDetailActivity.this;
                            AMap aMap = sportNewRecordDetailActivity2.F;
                            if (aMap != null) {
                                aMap.getMapScreenShot(sportNewRecordDetailActivity2);
                            }
                            SportNewRecordDetailActivity sportNewRecordDetailActivity3 = SportNewRecordDetailActivity.this;
                            sportNewRecordDetailActivity3.L = false;
                            return Boolean.valueOf(((com.example.baselibrary.utils.e) sportNewRecordDetailActivity3.E.getValue()).sendEmptyMessageDelayed(2, 50000L));
                        }
                    }, new oh.l() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$initView$1$onRightEvent$4
                        public final void invoke(boolean z5) {
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Boolean) obj).booleanValue());
                            return eh.g.f12633a;
                        }
                    });
                    break;
                } else {
                    com.example.baselibrary.utils.b.x("", new oh.l() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$initView$1$onRightEvent$1
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public final String invoke(String it) {
                            Bitmap bitmap;
                            kotlin.jvm.internal.e.f(it, "it");
                            SportNewRecordDetailActivity sportNewRecordDetailActivity2 = SportNewRecordDetailActivity.this;
                            int i3 = SportNewRecordDetailActivity.M;
                            NestedScrollView nestedScrollView = ((f2) sportNewRecordDetailActivity2.f7247z.getValue()).f12858f;
                            int childCount = nestedScrollView.getChildCount();
                            int i10 = 0;
                            for (int i11 = 0; i11 < childCount; i11++) {
                                i10 += nestedScrollView.getChildAt(i11).getHeight();
                            }
                            int f2 = com.example.baselibrary.utils.b.f(nestedScrollView.getContext(), 20.0f) + i10;
                            if (f2 > 0) {
                                bitmap = Bitmap.createBitmap(nestedScrollView.getWidth(), f2, Bitmap.Config.RGB_565);
                                kotlin.jvm.internal.e.e(bitmap, "createBitmap(...)");
                                nestedScrollView.draw(new Canvas(bitmap));
                            } else {
                                bitmap = null;
                            }
                            if (bitmap == null) {
                                return null;
                            }
                            SportNewRecordDetailActivity sportNewRecordDetailActivity3 = SportNewRecordDetailActivity.this;
                            Object obj = com.example.test.utils.l.f8733a;
                            return c2.a().b(sportNewRecordDetailActivity3, bitmap, System.currentTimeMillis() + ".jpg");
                        }
                    }, new oh.l() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$initView$1$onRightEvent$2
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((String) obj);
                            return eh.g.f12633a;
                        }

                        public final void invoke(String str) {
                            SportNewRecordDetailActivity.this.b0();
                            if (str != null) {
                                aa.a(SportNewRecordDetailActivity.this, str);
                            }
                        }
                    });
                    break;
                }
                break;
            default:
                final SportRecordDetailActivity sportRecordDetailActivity = (SportRecordDetailActivity) this.f8180b;
                sportRecordDetailActivity.V();
                h6.b bVar2 = sportRecordDetailActivity.G;
                ArrayList arrayList2 = bVar2 != null ? bVar2.f14275k : null;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    com.example.baselibrary.utils.b.x("", new oh.l() { // from class: com.example.test.ui.sport.activity.SportRecordDetailActivity$initView$1$onRightEvent$3
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public final Boolean invoke(String it) {
                            kotlin.jvm.internal.e.f(it, "it");
                            SportRecordDetailActivity sportRecordDetailActivity2 = SportRecordDetailActivity.this;
                            AMap aMap = sportRecordDetailActivity2.F;
                            if (aMap != null) {
                                aMap.getMapScreenShot(sportRecordDetailActivity2);
                            }
                            SportRecordDetailActivity sportRecordDetailActivity3 = SportRecordDetailActivity.this;
                            sportRecordDetailActivity3.L = false;
                            return Boolean.valueOf(((com.example.baselibrary.utils.e) sportRecordDetailActivity3.E.getValue()).sendEmptyMessageDelayed(2, 50000L));
                        }
                    }, new oh.l() { // from class: com.example.test.ui.sport.activity.SportRecordDetailActivity$initView$1$onRightEvent$4
                        public final void invoke(boolean z5) {
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Boolean) obj).booleanValue());
                            return eh.g.f12633a;
                        }
                    });
                    break;
                } else {
                    com.example.baselibrary.utils.b.x("", new oh.l() { // from class: com.example.test.ui.sport.activity.SportRecordDetailActivity$initView$1$onRightEvent$1
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public final String invoke(String it) {
                            Bitmap bitmap;
                            kotlin.jvm.internal.e.f(it, "it");
                            SportRecordDetailActivity sportRecordDetailActivity2 = SportRecordDetailActivity.this;
                            int i3 = SportRecordDetailActivity.M;
                            NestedScrollView nestedScrollView = ((f2) sportRecordDetailActivity2.f7247z.getValue()).f12858f;
                            int childCount = nestedScrollView.getChildCount();
                            int i10 = 0;
                            for (int i11 = 0; i11 < childCount; i11++) {
                                i10 += nestedScrollView.getChildAt(i11).getHeight();
                            }
                            int f2 = com.example.baselibrary.utils.b.f(nestedScrollView.getContext(), 20.0f) + i10;
                            if (f2 > 0) {
                                bitmap = Bitmap.createBitmap(nestedScrollView.getWidth(), f2, Bitmap.Config.RGB_565);
                                kotlin.jvm.internal.e.e(bitmap, "createBitmap(...)");
                                nestedScrollView.draw(new Canvas(bitmap));
                            } else {
                                bitmap = null;
                            }
                            if (bitmap == null) {
                                return null;
                            }
                            SportRecordDetailActivity sportRecordDetailActivity3 = SportRecordDetailActivity.this;
                            Object obj = com.example.test.utils.l.f8733a;
                            return c2.a().b(sportRecordDetailActivity3, bitmap, System.currentTimeMillis() + ".jpg");
                        }
                    }, new oh.l() { // from class: com.example.test.ui.sport.activity.SportRecordDetailActivity$initView$1$onRightEvent$2
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((String) obj);
                            return eh.g.f12633a;
                        }

                        public final void invoke(String str) {
                            SportRecordDetailActivity.this.b0();
                            if (str != null) {
                                aa.a(SportRecordDetailActivity.this, str);
                            }
                        }
                    });
                    break;
                }
                break;
        }
    }

    @Override // a7.e
    public final void u0() {
        switch (this.f8179a) {
            case 0:
                ((SportNewRecordDetailActivity) this.f8180b).finish();
                break;
            default:
                ((SportRecordDetailActivity) this.f8180b).onBackPressed();
                break;
        }
    }
}
