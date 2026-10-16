package com.example.test.ui.testui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f0 extends androidx.fragment.app.x0 {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f8274g;

    /* renamed from: h, reason: collision with root package name */
    public final TMainRingActivity f8275h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f8276i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(TMainRingActivity tMainRingActivity, androidx.fragment.app.u0 u0Var, int i3) {
        super(u0Var);
        this.f8274g = i3;
        switch (i3) {
            case 1:
                super(u0Var);
                this.f8275h = tMainRingActivity;
                TRringHomeFragment tRringHomeFragment = new TRringHomeFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("section_number", 1);
                tRringHomeFragment.setArguments(bundle);
                TRingActivityFragment tRingActivityFragment = new TRingActivityFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("section_number", 2);
                tRingActivityFragment.setArguments(bundle2);
                TRingDeviceFragment tRingDeviceFragment = new TRingDeviceFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putInt("section_number", 3);
                tRingDeviceFragment.setArguments(bundle3);
                ArrayList arrayList = new ArrayList();
                arrayList.add(tRringHomeFragment);
                arrayList.add(tRingActivityFragment);
                arrayList.add(tRingDeviceFragment);
                this.f8276i = arrayList;
                break;
            default:
                this.f8275h = tMainRingActivity;
                TRringHomeFragment tRringHomeFragment2 = new TRringHomeFragment();
                Bundle bundle4 = new Bundle();
                bundle4.putInt("section_number", 1);
                tRringHomeFragment2.setArguments(bundle4);
                TRingActivityFragment tRingActivityFragment2 = new TRingActivityFragment();
                Bundle bundle5 = new Bundle();
                bundle5.putInt("section_number", 2);
                tRingActivityFragment2.setArguments(bundle5);
                TRingSleepFragment tRingSleepFragment = new TRingSleepFragment();
                Bundle bundle6 = new Bundle();
                bundle6.putInt("section_number", 3);
                tRingSleepFragment.setArguments(bundle6);
                TRingDeviceFragment tRingDeviceFragment2 = new TRingDeviceFragment();
                Bundle bundle7 = new Bundle();
                bundle7.putInt("section_number", 4);
                tRingDeviceFragment2.setArguments(bundle7);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(tRringHomeFragment2);
                arrayList2.add(tRingActivityFragment2);
                arrayList2.add(tRingSleepFragment);
                arrayList2.add(tRingDeviceFragment2);
                this.f8276i = arrayList2;
                break;
        }
    }

    @Override // n2.a
    public final int c() {
        switch (this.f8274g) {
            case 0:
                Integer[] numArr = g0.f8279a;
                return 4;
            default:
                Integer[] numArr2 = h0.f8281a;
                return 3;
        }
    }

    @Override // n2.a
    public final CharSequence e(int i3) {
        switch (this.f8274g) {
            case 0:
                return this.f8275h.getResources().getString(g0.f8279a[i3].intValue());
            default:
                return this.f8275h.getResources().getString(h0.f8281a[i3].intValue());
        }
    }

    @Override // androidx.fragment.app.x0
    public final Fragment k(int i3) {
        switch (this.f8274g) {
            case 0:
                Object obj = this.f8276i.get(i3);
                kotlin.jvm.internal.e.e(obj, "get(...)");
                return (Fragment) obj;
            default:
                Object obj2 = this.f8276i.get(i3);
                kotlin.jvm.internal.e.e(obj2, "get(...)");
                return (Fragment) obj2;
        }
    }

    @Override // androidx.fragment.app.x0
    public final long l(int i3) {
        switch (this.f8274g) {
        }
        return ((Fragment) this.f8276i.get(i3)).hashCode();
    }
}
