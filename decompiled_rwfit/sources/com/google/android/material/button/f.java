package com.google.android.material.button;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.viewpager.widget.ViewPager;
import com.autonavi.aps.amapapi.config.Const;
import com.example.test.ui.device.activity.i0;
import com.google.android.material.R$string;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;

/* loaded from: classes.dex */
public final class f extends l1.c {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f10344d;
    public final /* synthetic */ Object e;

    public /* synthetic */ f(Object obj, int i3) {
        this.f10344d = i3;
        this.e = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
    
        if (r0.c() > 1) goto L12;
     */
    @Override // l1.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(android.view.View r3, android.view.accessibility.AccessibilityEvent r4) {
        /*
            r2 = this;
            int r0 = r2.f10344d
            switch(r0) {
                case 2: goto L47;
                case 3: goto L5;
                case 4: goto L9;
                default: goto L5;
            }
        L5:
            super.c(r3, r4)
            return
        L9:
            super.c(r3, r4)
            java.lang.Class<androidx.viewpager.widget.ViewPager> r3 = androidx.viewpager.widget.ViewPager.class
            java.lang.String r3 = r3.getName()
            r4.setClassName(r3)
            java.lang.Object r3 = r2.e
            androidx.viewpager.widget.ViewPager r3 = (androidx.viewpager.widget.ViewPager) r3
            n2.a r0 = r3.e
            if (r0 == 0) goto L25
            int r0 = r0.c()
            r1 = 1
            if (r0 <= r1) goto L25
            goto L26
        L25:
            r1 = 0
        L26:
            r4.setScrollable(r1)
            int r0 = r4.getEventType()
            r1 = 4096(0x1000, float:5.74E-42)
            if (r0 != r1) goto L46
            n2.a r0 = r3.e
            if (r0 == 0) goto L46
            int r0 = r0.c()
            r4.setItemCount(r0)
            int r0 = r3.f2924f
            r4.setFromIndex(r0)
            int r3 = r3.f2924f
            r4.setToIndex(r3)
        L46:
            return
        L47:
            super.c(r3, r4)
            java.lang.Object r3 = r2.e
            com.google.android.material.internal.CheckableImageButton r3 = (com.google.android.material.internal.CheckableImageButton) r3
            boolean r3 = r3.f10532d
            r4.setChecked(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.f.c(android.view.View, android.view.accessibility.AccessibilityEvent):void");
    }

    @Override // l1.c
    public final void d(View view, m1.d dVar) {
        int i3 = -1;
        boolean z5 = false;
        Object obj = this.e;
        View.AccessibilityDelegate accessibilityDelegate = this.f15682a;
        switch (this.f10344d) {
            case 0:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, dVar.f15938a);
                int i10 = MaterialButtonToggleGroup.f10315k;
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                if (view instanceof MaterialButton) {
                    int i11 = 0;
                    int i12 = 0;
                    while (true) {
                        if (i11 < materialButtonToggleGroup.getChildCount()) {
                            if (materialButtonToggleGroup.getChildAt(i11) == view) {
                                i3 = i12;
                            } else {
                                if ((materialButtonToggleGroup.getChildAt(i11) instanceof MaterialButton) && materialButtonToggleGroup.c(i11)) {
                                    i12++;
                                }
                                i11++;
                            }
                        }
                    }
                }
                dVar.g(i0.o(0, 1, i3, 1, ((MaterialButton) view).f10311n));
                break;
            case 1:
                AccessibilityNodeInfo accessibilityNodeInfo = dVar.f15938a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                MaterialCalendar materialCalendar = (MaterialCalendar) obj;
                accessibilityNodeInfo.setHintText(materialCalendar.f10401k.getVisibility() == 0 ? materialCalendar.getString(R$string.mtrl_picker_toggle_to_year_selection) : materialCalendar.getString(R$string.mtrl_picker_toggle_to_day_selection));
                break;
            case 2:
                AccessibilityNodeInfo accessibilityNodeInfo2 = dVar.f15938a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo2.setCheckable(checkableImageButton.e);
                accessibilityNodeInfo2.setChecked(checkableImageButton.f10532d);
                break;
            case 3:
                AccessibilityNodeInfo accessibilityNodeInfo3 = dVar.f15938a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo3);
                accessibilityNodeInfo3.setCheckable(((NavigationMenuItemView) obj).f10546x);
                break;
            case 4:
                AccessibilityNodeInfo accessibilityNodeInfo4 = dVar.f15938a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo4);
                dVar.f(ViewPager.class.getName());
                ViewPager viewPager = (ViewPager) obj;
                n2.a aVar = viewPager.e;
                if (aVar != null && aVar.c() > 1) {
                    z5 = true;
                }
                accessibilityNodeInfo4.setScrollable(z5);
                if (viewPager.canScrollHorizontally(1)) {
                    dVar.a(4096);
                }
                if (viewPager.canScrollHorizontally(-1)) {
                    dVar.a(8192);
                    break;
                }
                break;
            default:
                AccessibilityNodeInfo accessibilityNodeInfo5 = dVar.f15938a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo5);
                if (!((com.example.test.ui.dialog.c) obj).f7932i) {
                    accessibilityNodeInfo5.setDismissable(false);
                    break;
                } else {
                    dVar.a(Const.I_MAX_OFFLINE_DATA_CACHE);
                    accessibilityNodeInfo5.setDismissable(true);
                    break;
                }
        }
    }

    @Override // l1.c
    public boolean g(View view, int i3, Bundle bundle) {
        switch (this.f10344d) {
            case 4:
                if (!super.g(view, i3, bundle)) {
                    ViewPager viewPager = (ViewPager) this.e;
                    if (i3 == 4096) {
                        if (viewPager.canScrollHorizontally(1)) {
                            viewPager.setCurrentItem(viewPager.f2924f + 1);
                            break;
                        }
                    } else if (i3 == 8192 && viewPager.canScrollHorizontally(-1)) {
                        viewPager.setCurrentItem(viewPager.f2924f - 1);
                        break;
                    }
                    break;
                }
                break;
            case 5:
                if (i3 == 1048576) {
                    com.example.test.ui.dialog.c cVar = (com.example.test.ui.dialog.c) this.e;
                    if (cVar.f7932i) {
                        cVar.cancel();
                        break;
                    }
                }
                break;
        }
        return super.g(view, i3, bundle);
    }
}
