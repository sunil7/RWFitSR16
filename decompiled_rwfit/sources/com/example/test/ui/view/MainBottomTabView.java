package com.example.test.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.example.database.table.Devices;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import java.util.WeakHashMap;
import l1.n0;
import l1.z0;

/* loaded from: classes.dex */
public final class MainBottomTabView extends LinearLayout implements View.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f8484f = 0;

    /* renamed from: a, reason: collision with root package name */
    public ViewPager f8485a;

    /* renamed from: b, reason: collision with root package name */
    public final TabView f8486b;

    /* renamed from: c, reason: collision with root package name */
    public final TabView f8487c;

    /* renamed from: d, reason: collision with root package name */
    public final TabView f8488d;
    public final TabView e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MainBottomTabView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    private final int getProductType() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTabPosition(int i3) {
        r5.a.h(i3, "MainBottomTabView setTabPosition ", "qob");
        if (getProductType() == 2) {
            TabView tabView = this.f8486b;
            if (tabView == null) {
                kotlin.jvm.internal.e.m("tabHome");
                throw null;
            }
            tabView.setTabSelected(i3 == 0);
            TabView tabView2 = this.e;
            if (tabView2 != null) {
                tabView2.setTabSelected(i3 == 1);
                return;
            } else {
                kotlin.jvm.internal.e.m("tabMine");
                throw null;
            }
        }
        TabView tabView3 = this.f8486b;
        if (tabView3 == null) {
            kotlin.jvm.internal.e.m("tabHome");
            throw null;
        }
        tabView3.setTabSelected(i3 == 0);
        TabView tabView4 = this.f8487c;
        if (tabView4 == null) {
            kotlin.jvm.internal.e.m("tabSport");
            throw null;
        }
        tabView4.setTabSelected(i3 == 1);
        TabView tabView5 = this.f8488d;
        if (tabView5 == null) {
            kotlin.jvm.internal.e.m("tabDevice");
            throw null;
        }
        tabView5.setTabSelected(i3 == 2);
        TabView tabView6 = this.e;
        if (tabView6 != null) {
            tabView6.setTabSelected(i3 == 3);
        } else {
            kotlin.jvm.internal.e.m("tabMine");
            throw null;
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf;
        ViewPager viewPager;
        ViewPager viewPager2;
        if (getProductType() >= 2) {
            valueOf = view != null ? Integer.valueOf(view.getId()) : null;
            int i3 = R$id.tabHome;
            if (valueOf != null && valueOf.intValue() == i3) {
                ViewPager viewPager3 = this.f8485a;
                if (viewPager3 != null) {
                    viewPager3.v(0, false);
                    return;
                }
                return;
            }
            int i10 = R$id.tabMine;
            if (valueOf == null || valueOf.intValue() != i10 || (viewPager = this.f8485a) == null) {
                return;
            }
            viewPager.v(1, false);
            return;
        }
        valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i11 = R$id.tabHome;
        if (valueOf != null && valueOf.intValue() == i11) {
            ViewPager viewPager4 = this.f8485a;
            if (viewPager4 != null) {
                viewPager4.v(0, false);
                return;
            }
            return;
        }
        int i12 = R$id.tabSport;
        if (valueOf != null && valueOf.intValue() == i12) {
            ViewPager viewPager5 = this.f8485a;
            if (viewPager5 != null) {
                viewPager5.v(1, false);
                return;
            }
            return;
        }
        int i13 = R$id.tabDevice;
        if (valueOf != null && valueOf.intValue() == i13) {
            ViewPager viewPager6 = this.f8485a;
            if (viewPager6 != null) {
                viewPager6.v(2, false);
                return;
            }
            return;
        }
        int i14 = R$id.tabMine;
        if (valueOf == null || valueOf.intValue() != i14 || (viewPager2 = this.f8485a) == null) {
            return;
        }
        viewPager2.v(3, false);
    }

    public final void setTabProductType(int i3) {
        if (getProductType() == 2) {
            TabView tabView = this.f8487c;
            if (tabView == null) {
                kotlin.jvm.internal.e.m("tabSport");
                throw null;
            }
            tabView.setVisibility(8);
            TabView tabView2 = this.f8488d;
            if (tabView2 != null) {
                tabView2.setVisibility(8);
                return;
            } else {
                kotlin.jvm.internal.e.m("tabDevice");
                throw null;
            }
        }
        TabView tabView3 = this.f8487c;
        if (tabView3 == null) {
            kotlin.jvm.internal.e.m("tabSport");
            throw null;
        }
        tabView3.setVisibility(0);
        TabView tabView4 = this.f8488d;
        if (tabView4 != null) {
            tabView4.setVisibility(0);
        } else {
            kotlin.jvm.internal.e.m("tabDevice");
            throw null;
        }
    }

    public final void setViewPager(ViewPager viewPager) {
        kotlin.jvm.internal.e.f(viewPager, "viewPager");
        this.f8485a = viewPager;
        viewPager.addOnPageChangeListener(new b7.a(this, 1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MainBottomTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public /* synthetic */ MainBottomTabView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainBottomTabView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        kotlin.jvm.internal.e.f(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_main_bottom_tabs, this);
        View findViewById = findViewById(R$id.tabParent);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        b9.a aVar = new b9.a(21);
        WeakHashMap weakHashMap = z0.f15748a;
        n0.u((LinearLayout) findViewById, aVar);
        View findViewById2 = findViewById(R$id.tabHome);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8486b = (TabView) findViewById2;
        View findViewById3 = findViewById(R$id.tabSport);
        kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
        this.f8487c = (TabView) findViewById3;
        View findViewById4 = findViewById(R$id.tabDevice);
        kotlin.jvm.internal.e.e(findViewById4, "findViewById(...)");
        this.f8488d = (TabView) findViewById4;
        View findViewById5 = findViewById(R$id.tabMine);
        kotlin.jvm.internal.e.e(findViewById5, "findViewById(...)");
        this.e = (TabView) findViewById5;
        TabView tabView = this.f8486b;
        if (tabView != null) {
            tabView.setTabName(R$string.str_tab_home);
            TabView tabView2 = this.f8487c;
            if (tabView2 != null) {
                tabView2.setTabName(R$string.str_tab_sport);
                TabView tabView3 = this.f8488d;
                if (tabView3 != null) {
                    tabView3.setTabName(R$string.str_tab_device);
                    TabView tabView4 = this.e;
                    if (tabView4 != null) {
                        tabView4.setTabName(R$string.str_tab_mine);
                        TabView tabView5 = this.f8486b;
                        if (tabView5 != null) {
                            tabView5.a(R$mipmap.ic_home_selected, R$mipmap.ic_home);
                            TabView tabView6 = this.f8487c;
                            if (tabView6 != null) {
                                tabView6.a(R$mipmap.ic_sport_selected, R$mipmap.ic_sport);
                                TabView tabView7 = this.f8488d;
                                if (tabView7 != null) {
                                    tabView7.a(R$mipmap.ic_device_selected, R$mipmap.ic_device);
                                    TabView tabView8 = this.e;
                                    if (tabView8 != null) {
                                        tabView8.a(R$mipmap.ic_mine_selected, R$mipmap.ic_mine);
                                        TabView tabView9 = this.f8486b;
                                        if (tabView9 != null) {
                                            tabView9.setOnClickListener(this);
                                            TabView tabView10 = this.f8487c;
                                            if (tabView10 != null) {
                                                tabView10.setOnClickListener(this);
                                                TabView tabView11 = this.f8488d;
                                                if (tabView11 != null) {
                                                    tabView11.setOnClickListener(this);
                                                    TabView tabView12 = this.e;
                                                    if (tabView12 != null) {
                                                        tabView12.setOnClickListener(this);
                                                        if (getProductType() == 2) {
                                                            TabView tabView13 = this.f8487c;
                                                            if (tabView13 != null) {
                                                                tabView13.setVisibility(8);
                                                                TabView tabView14 = this.f8488d;
                                                                if (tabView14 != null) {
                                                                    tabView14.setVisibility(8);
                                                                    return;
                                                                } else {
                                                                    kotlin.jvm.internal.e.m("tabDevice");
                                                                    throw null;
                                                                }
                                                            }
                                                            kotlin.jvm.internal.e.m("tabSport");
                                                            throw null;
                                                        }
                                                        return;
                                                    }
                                                    kotlin.jvm.internal.e.m("tabMine");
                                                    throw null;
                                                }
                                                kotlin.jvm.internal.e.m("tabDevice");
                                                throw null;
                                            }
                                            kotlin.jvm.internal.e.m("tabSport");
                                            throw null;
                                        }
                                        kotlin.jvm.internal.e.m("tabHome");
                                        throw null;
                                    }
                                    kotlin.jvm.internal.e.m("tabMine");
                                    throw null;
                                }
                                kotlin.jvm.internal.e.m("tabDevice");
                                throw null;
                            }
                            kotlin.jvm.internal.e.m("tabSport");
                            throw null;
                        }
                        kotlin.jvm.internal.e.m("tabHome");
                        throw null;
                    }
                    kotlin.jvm.internal.e.m("tabMine");
                    throw null;
                }
                kotlin.jvm.internal.e.m("tabDevice");
                throw null;
            }
            kotlin.jvm.internal.e.m("tabSport");
            throw null;
        }
        kotlin.jvm.internal.e.m("tabHome");
        throw null;
    }
}
