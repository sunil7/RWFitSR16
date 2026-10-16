package u6;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.t0;
import androidx.fragment.app.u0;
import androidx.fragment.app.x0;
import com.example.baselibrary.base.fragment.BaseFragment;
import com.example.database.table.Devices;
import com.example.test.MainActivity;
import com.example.test.ui.main.fragment.DeviceFragment;
import com.example.test.ui.main.fragment.DeviceScanFragment;
import com.example.test.ui.main.fragment.HeadsetFragment;
import com.example.test.ui.main.fragment.HomeFragment;
import com.example.test.ui.main.fragment.MineFragment;
import com.example.test.ui.sport.fragment.SportTypeFragment;
import com.google.android.gms.internal.mlkit_vision_barcode.t1;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class p extends x0 {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f18914g = 1;

    /* renamed from: h, reason: collision with root package name */
    public final Context f18915h;

    /* renamed from: i, reason: collision with root package name */
    public final BaseFragment f18916i;

    /* renamed from: j, reason: collision with root package name */
    public final BaseFragment f18917j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f18918k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f18919l;

    public p(Context context, t0 t0Var) {
        super(t0Var);
        this.f18915h = context;
        this.f18916i = t1.a(0);
        this.f18917j = t1.a(7);
        this.f18918k = t1.a(2);
        this.f18919l = t1.a(14);
    }

    public static int m() {
        Devices c9;
        String name;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || kVar.c() == null) {
            return 0;
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        return (kVar2 == null || (c9 = kVar2.c()) == null || (name = c9.getName()) == null || !kotlin.text.m.c(name, "SmartBox", false)) ? 1 : 2;
    }

    @Override // n2.a
    public final int c() {
        switch (this.f18914g) {
            case 0:
                if (m() <= 1) {
                    Integer[] numArr = q.f18920a;
                    break;
                } else {
                    Integer[] numArr2 = q.f18920a;
                    break;
                }
        }
        return 4;
    }

    @Override // n2.a
    public int d(Object object) {
        switch (this.f18914g) {
            case 0:
                kotlin.jvm.internal.e.f(object, "object");
                return -2;
            default:
                return super.d(object);
        }
    }

    @Override // n2.a
    public final CharSequence e(int i3) {
        Resources resources;
        switch (this.f18914g) {
            case 0:
                int m10 = m();
                MainActivity mainActivity = (MainActivity) this.f18915h;
                return m10 > 1 ? mainActivity.getResources().getString(q.f18921b[i3].intValue()) : mainActivity.getResources().getString(q.f18920a[i3].intValue());
            default:
                Context context = this.f18915h;
                if (context == null || (resources = context.getResources()) == null) {
                    return null;
                }
                return resources.getString(w6.a.f19518a[i3].intValue());
        }
    }

    @Override // androidx.fragment.app.x0
    public final Fragment k(int i3) {
        switch (this.f18914g) {
            case 0:
                Log.e("qob", "getItem");
                if (m() > 1) {
                    Object obj = ((ArrayList) this.f18919l).get(i3);
                    kotlin.jvm.internal.e.c(obj);
                    return (Fragment) obj;
                }
                Object obj2 = ((ArrayList) this.f18918k).get(i3);
                kotlin.jvm.internal.e.c(obj2);
                return (Fragment) obj2;
            default:
                r5.a.h(i3, "SportTypePagerAdapter getItem ", "qob");
                if (i3 == 0) {
                    return (SportTypeFragment) this.f18916i;
                }
                if (i3 == 1) {
                    return (SportTypeFragment) this.f18917j;
                }
                if (i3 == 2) {
                    return (SportTypeFragment) this.f18918k;
                }
                if (i3 == 3) {
                    return (SportTypeFragment) this.f18919l;
                }
                SportTypeFragment sportTypeFragment = new SportTypeFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("sport_type", i3);
                sportTypeFragment.setArguments(bundle);
                return sportTypeFragment;
        }
    }

    @Override // androidx.fragment.app.x0
    public long l(int i3) {
        switch (this.f18914g) {
            case 0:
                return m() > 1 ? ((Fragment) ((ArrayList) this.f18919l).get(i3)).hashCode() : ((Fragment) ((ArrayList) this.f18918k).get(i3)).hashCode();
            default:
                return super.l(i3);
        }
    }

    public void n() {
        int m10 = m();
        ArrayList arrayList = (ArrayList) this.f18918k;
        DeviceScanFragment deviceScanFragment = (DeviceScanFragment) this.f18916i;
        DeviceFragment deviceFragment = (DeviceFragment) this.f18917j;
        if (m10 == 0) {
            if (arrayList.contains(deviceFragment)) {
                arrayList.remove(deviceFragment);
                arrayList.add(2, deviceScanFragment);
            }
        } else if (m() == 1 && arrayList.contains(deviceScanFragment)) {
            arrayList.remove(deviceScanFragment);
            arrayList.add(2, deviceFragment);
            deviceFragment.f8044g = true;
        }
        h();
    }

    public p(MainActivity mainActivity, u0 u0Var) {
        super(u0Var);
        this.f18915h = mainActivity;
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("section_number", 1);
        homeFragment.setArguments(bundle);
        com.example.test.ui.main.fragment.o oVar = new com.example.test.ui.main.fragment.o();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("section_number", 2);
        oVar.setArguments(bundle2);
        DeviceScanFragment deviceScanFragment = new DeviceScanFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putInt("section_number", 3);
        deviceScanFragment.setArguments(bundle3);
        this.f18916i = deviceScanFragment;
        MineFragment mineFragment = new MineFragment();
        Bundle bundle4 = new Bundle();
        bundle4.putInt("section_number", 4);
        mineFragment.setArguments(bundle4);
        DeviceFragment deviceFragment = new DeviceFragment();
        Bundle bundle5 = new Bundle();
        bundle5.putInt("section_number", 5);
        deviceFragment.setArguments(bundle5);
        this.f18917j = deviceFragment;
        HeadsetFragment headsetFragment = new HeadsetFragment();
        Bundle bundle6 = new Bundle();
        bundle6.putInt("section_number", 6);
        headsetFragment.setArguments(bundle6);
        ArrayList arrayList = new ArrayList();
        arrayList.add(homeFragment);
        arrayList.add(oVar);
        arrayList.add(deviceScanFragment);
        arrayList.add(mineFragment);
        this.f18918k = arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(headsetFragment);
        arrayList2.add(mineFragment);
        this.f18919l = arrayList2;
    }
}
