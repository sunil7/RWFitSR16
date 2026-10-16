package com.example.test.ui.sport.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.example.baselibrary.base.fragment.BaseFragment;
import com.example.database.table.User;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.presenter.sport.z;
import com.example.test.ui.device.activity.e0;
import com.example.test.ui.device.activity.f0;
import com.example.test.ui.dialog.r;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.SelectView;
import com.example.test.utils.k;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import eh.b;
import f6.r3;
import i7.j;
import java.util.ArrayList;
import kotlin.collections.i;
import kotlin.jvm.internal.e;
import nd.c;
import org.greenrobot.eventbus.ThreadMode;
import v2.h;

/* loaded from: classes.dex */
public final class SportTypeFragment extends BaseFragment<z, r3> implements j, View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final b f8188c = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.fragment.SportTypeFragment$sportType$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Bundle arguments = SportTypeFragment.this.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("sport_type") : 5);
        }
    });

    /* renamed from: d, reason: collision with root package name */
    public int f8189d = 4;
    public final b e = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.fragment.SportTypeFragment$permissionTips$2
        {
            super(0);
        }

        @Override // oh.a
        public final r invoke() {
            r rVar = new r(SportTypeFragment.this.f0());
            rVar.setOnDialogListener(new f0(SportTypeFragment.this, 5));
            return rVar;
        }
    });

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new z(this);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        r3 r3Var = (r3) this.f7251b;
        if (r3Var != null) {
            return r3Var.f13280a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R$layout.fragment_sport_type, viewGroup, false);
        int i3 = R$id.f7399bg;
        View a3 = he.a(i3, inflate);
        if (a3 != null) {
            i3 = R$id.sv;
            SelectView selectView = (SelectView) he.a(i3, inflate);
            if (selectView != null) {
                i3 = R$id.tvDistanceEntry;
                TextView textView = (TextView) he.a(i3, inflate);
                if (textView != null) {
                    i3 = R$id.tv_distance_unit;
                    TextView textView2 = (TextView) he.a(i3, inflate);
                    if (textView2 != null) {
                        i3 = R$id.tv_start;
                        TextView textView3 = (TextView) he.a(i3, inflate);
                        if (textView3 != null) {
                            i3 = R$id.tvTotalDistance;
                            TextView textView4 = (TextView) he.a(i3, inflate);
                            if (textView4 != null) {
                                return new r3((ConstraintLayout) inflate, a3, selectView, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void e0() {
    }

    @Override // p5.a
    public final Context f0() {
        FragmentActivity activity = getActivity();
        e.d(activity, "null cannot be cast to non-null type android.content.Context");
        return activity;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void h0() {
        Log.e("qob", "SportTypeFragment initData sportType " + q0());
        if (q0() == 0) {
            ((z) X()).k(this.f8189d);
        } else {
            ((z) X()).k(q0());
        }
        if (k.f8731b == null) {
            synchronized (k.class) {
                k.f8731b = new k();
            }
        }
        k kVar = k.f8731b;
        User d5 = kVar != null ? kVar.d() : null;
        if (d5 != null) {
            int i3 = d5.getMeterUnit() == 0 ? R$string.str_km : R$string.str_mile;
            r3 r3Var = (r3) this.f7251b;
            if (r3Var != null) {
                r3Var.e.setText(i3);
            }
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        Log.e("qob", "SportTypeFragment initView sportType " + q0());
        b2.a(this);
        int q02 = q0();
        if (q02 == 0) {
            r3 r3Var = (r3) this.f7251b;
            TextView textView = r3Var != null ? r3Var.f13283d : null;
            if (textView != null) {
                textView.setText(getString(R$string.str_run_total_distance));
            }
            r3 r3Var2 = (r3) this.f7251b;
            SelectView selectView = r3Var2 != null ? r3Var2.f13282c : null;
            if (selectView != null) {
                selectView.setVisibility(0);
            }
            r3 r3Var3 = (r3) this.f7251b;
            View view = r3Var3 != null ? r3Var3.f13281b : null;
            if (view != null) {
                view.setVisibility(0);
            }
            r3 r3Var4 = (r3) this.f7251b;
            if (r3Var4 != null) {
                this.f8189d = r3Var4.f13282c.getSelectedType();
                ((z) X()).k(this.f8189d);
                if (this.f8189d == 4) {
                    r3 r3Var5 = (r3) this.f7251b;
                    TextView textView2 = r3Var5 != null ? r3Var5.f13283d : null;
                    if (textView2 != null) {
                        textView2.setText(getString(R$string.str_run_indoor_total_distance));
                    }
                } else {
                    r3 r3Var6 = (r3) this.f7251b;
                    TextView textView3 = r3Var6 != null ? r3Var6.f13283d : null;
                    if (textView3 != null) {
                        textView3.setText(getString(R$string.str_run_outdoor_total_distance));
                    }
                }
            }
        } else if (q02 == 2) {
            r3 r3Var7 = (r3) this.f7251b;
            TextView textView4 = r3Var7 != null ? r3Var7.f13283d : null;
            if (textView4 != null) {
                textView4.setText(getString(R$string.str_bike_total_distance));
            }
            r3 r3Var8 = (r3) this.f7251b;
            SelectView selectView2 = r3Var8 != null ? r3Var8.f13282c : null;
            if (selectView2 != null) {
                selectView2.setVisibility(8);
            }
            r3 r3Var9 = (r3) this.f7251b;
            View view2 = r3Var9 != null ? r3Var9.f13281b : null;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.f8189d = 2;
        } else if (q02 == 7) {
            r3 r3Var10 = (r3) this.f7251b;
            TextView textView5 = r3Var10 != null ? r3Var10.f13283d : null;
            if (textView5 != null) {
                textView5.setText(getString(R$string.str_walk_total_distance));
            }
            r3 r3Var11 = (r3) this.f7251b;
            SelectView selectView3 = r3Var11 != null ? r3Var11.f13282c : null;
            if (selectView3 != null) {
                selectView3.setVisibility(8);
            }
            r3 r3Var12 = (r3) this.f7251b;
            View view3 = r3Var12 != null ? r3Var12.f13281b : null;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            this.f8189d = 1;
        } else if (q02 == 14) {
            r3 r3Var13 = (r3) this.f7251b;
            TextView textView6 = r3Var13 != null ? r3Var13.f13283d : null;
            if (textView6 != null) {
                textView6.setText(getString(R$string.str_cli_total_distance));
            }
            r3 r3Var14 = (r3) this.f7251b;
            SelectView selectView4 = r3Var14 != null ? r3Var14.f13282c : null;
            if (selectView4 != null) {
                selectView4.setVisibility(8);
            }
            r3 r3Var15 = (r3) this.f7251b;
            View view4 = r3Var15 != null ? r3Var15.f13281b : null;
            if (view4 != null) {
                view4.setVisibility(8);
            }
            this.f8189d = 3;
        }
        r3 r3Var16 = (r3) this.f7251b;
        if (r3Var16 != null) {
            r3Var16.f13284f.setOnClickListener(this);
        }
        r3 r3Var17 = (r3) this.f7251b;
        if (r3Var17 != null) {
            r3Var17.f13282c.setViewChildListener(new e0(this, 7));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.tv_start;
        if (valueOf != null && valueOf.intValue() == i3) {
            int i10 = this.f8189d;
            b bVar = this.e;
            if (i10 == 4) {
                if (!c.j(f0(), i.b("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACTIVITY_RECOGNITION", "android.permission.BODY_SENSORS"))) {
                    ((r) bVar.getValue()).b(R$string.str_sport_permisson_tips);
                    ((r) bVar.getValue()).show();
                    return;
                }
                if (Build.VERSION.SDK_INT >= 30) {
                    h hVar = new h(f0());
                    hVar.o("android.permission.ACTIVITY_RECOGNITION");
                    hVar.o("android.permission.BODY_SENSORS");
                    hVar.p(new a(this, 2));
                    return;
                }
                h hVar2 = new h(f0());
                hVar2.o("android.permission.ACTIVITY_RECOGNITION");
                hVar2.o("android.permission.BODY_SENSORS");
                hVar2.o("android.permission.WRITE_EXTERNAL_STORAGE");
                hVar2.o("android.permission.READ_EXTERNAL_STORAGE");
                hVar2.p(new a(this, 3));
                return;
            }
            Context f02 = f0();
            ArrayList b3 = i.b("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACTIVITY_RECOGNITION", "android.permission.BODY_SENSORS");
            b3.add("android.permission.ACCESS_BACKGROUND_LOCATION");
            if (!c.j(f02, b3)) {
                ((r) bVar.getValue()).b(R$string.str_sport_permisson_tips);
                ((r) bVar.getValue()).show();
                return;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                h hVar3 = new h(f0());
                hVar3.o("android.permission.ACTIVITY_RECOGNITION");
                hVar3.o("android.permission.BODY_SENSORS");
                hVar3.p(new a(this, 0));
                return;
            }
            h hVar4 = new h(f0());
            hVar4.o("android.permission.ACTIVITY_RECOGNITION");
            hVar4.o("android.permission.BODY_SENSORS");
            hVar4.o("android.permission.WRITE_EXTERNAL_STORAGE");
            hVar4.o("android.permission.READ_EXTERNAL_STORAGE");
            hVar4.p(new a(this, 1));
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
        r5.a.h(q0(), "SportTypeFragment onDestroy sportType ", "qob");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        b2.b(this);
        r5.a.h(q0(), "SportTypeFragment onDestroyView sportType ", "qob");
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSportEvent(EventBusBeans.SyncEvent syncEvent) {
        e.f(syncEvent, "syncEvent");
        if (syncEvent.getSyncType() == 8) {
            h0();
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onUnitEvent(EventBusBeans.UnitEvent unitEvent) {
        e.f(unitEvent, "unitEvent");
        if (unitEvent.getUnitType() == 0) {
            h0();
        }
    }

    public final int q0() {
        return ((Number) this.f8188c.getValue()).intValue();
    }
}
