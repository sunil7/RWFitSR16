package com.example.test.ui.testui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.view.TabView;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class TMainBottomTabView extends LinearLayout implements View.OnClickListener {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f8198g = 0;

    /* renamed from: a, reason: collision with root package name */
    public ViewPager f8199a;

    /* renamed from: b, reason: collision with root package name */
    public final TabView f8200b;

    /* renamed from: c, reason: collision with root package name */
    public final TabView f8201c;

    /* renamed from: d, reason: collision with root package name */
    public final TabView f8202d;
    public final TabView e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearLayout f8203f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TMainBottomTabView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTabPosition(int i3) {
        TabView tabView = this.f8200b;
        if (tabView == null) {
            kotlin.jvm.internal.e.m("tabHome");
            throw null;
        }
        tabView.setTabSelected(i3 == 0);
        TabView tabView2 = this.f8201c;
        if (tabView2 == null) {
            kotlin.jvm.internal.e.m("tabActivity");
            throw null;
        }
        tabView2.setTabSelected(i3 == 1);
        TabView tabView3 = this.f8202d;
        if (tabView3 == null) {
            kotlin.jvm.internal.e.m("tabSleep");
            throw null;
        }
        tabView3.setTabSelected(i3 == 2);
        TabView tabView4 = this.e;
        if (tabView4 != null) {
            tabView4.setTabSelected(i3 == 3);
        } else {
            kotlin.jvm.internal.e.m("tabDevice");
            throw null;
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ViewPager viewPager;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.tabHome;
        if (valueOf != null && valueOf.intValue() == i3) {
            ViewPager viewPager2 = this.f8199a;
            if (viewPager2 != null) {
                viewPager2.v(0, false);
                return;
            }
            return;
        }
        int i10 = R$id.tabSport;
        if (valueOf != null && valueOf.intValue() == i10) {
            ViewPager viewPager3 = this.f8199a;
            if (viewPager3 != null) {
                viewPager3.v(1, false);
                return;
            }
            return;
        }
        int i11 = R$id.tabDevice;
        if (valueOf != null && valueOf.intValue() == i11) {
            ViewPager viewPager4 = this.f8199a;
            if (viewPager4 != null) {
                viewPager4.v(2, false);
                return;
            }
            return;
        }
        int i12 = R$id.tabMine;
        if (valueOf == null || valueOf.intValue() != i12 || (viewPager = this.f8199a) == null) {
            return;
        }
        viewPager.v(3, false);
    }

    public final void setLayoutColor(int i3) {
        LinearLayout linearLayout = this.f8203f;
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(i3);
        } else {
            kotlin.jvm.internal.e.m("parent");
            throw null;
        }
    }

    public final void setViewPager(ViewPager viewPager) {
        kotlin.jvm.internal.e.f(viewPager, "viewPager");
        this.f8199a = viewPager;
        viewPager.addOnPageChangeListener(new f(this, 1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TMainBottomTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public /* synthetic */ TMainBottomTabView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TMainBottomTabView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        kotlin.jvm.internal.e.f(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_main_bottom_tabs, this);
        View findViewById = findViewById(R$id.tabParent);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.f8203f = linearLayout;
        b9.a aVar = new b9.a(17);
        WeakHashMap weakHashMap = l1.z0.f15748a;
        l1.n0.u(linearLayout, aVar);
        View findViewById2 = findViewById(R$id.tabHome);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8200b = (TabView) findViewById2;
        View findViewById3 = findViewById(R$id.tabSport);
        kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
        this.f8201c = (TabView) findViewById3;
        View findViewById4 = findViewById(R$id.tabDevice);
        kotlin.jvm.internal.e.e(findViewById4, "findViewById(...)");
        this.f8202d = (TabView) findViewById4;
        View findViewById5 = findViewById(R$id.tabMine);
        kotlin.jvm.internal.e.e(findViewById5, "findViewById(...)");
        this.e = (TabView) findViewById5;
        TabView tabView = this.f8200b;
        if (tabView != null) {
            tabView.setTabName(R$string.str_tab_home);
            TabView tabView2 = this.f8201c;
            if (tabView2 != null) {
                tabView2.setTabName(R$string.str_ring_home_activity);
                TabView tabView3 = this.f8202d;
                if (tabView3 != null) {
                    tabView3.setTabName(R$string.str_sleep_title);
                    TabView tabView4 = this.e;
                    if (tabView4 != null) {
                        tabView4.setTabName(R$string.str_tab_device);
                        TabView tabView5 = this.f8200b;
                        if (tabView5 != null) {
                            tabView5.a(R$mipmap.ic_bottom_home_focus, R$mipmap.ic_bottom_home_nor);
                            TabView tabView6 = this.f8201c;
                            if (tabView6 != null) {
                                tabView6.a(R$mipmap.ic_bottom_activity_focus, R$mipmap.ic_bottom_activity_nor);
                                TabView tabView7 = this.f8202d;
                                if (tabView7 != null) {
                                    tabView7.a(R$mipmap.ic_bottom_sleep_focus, R$mipmap.ic_bottom_sleep_nor);
                                    TabView tabView8 = this.e;
                                    if (tabView8 != null) {
                                        tabView8.a(R$mipmap.ic_bottom_device_focus, R$mipmap.ic_bottom_device_nor);
                                        TabView tabView9 = this.f8200b;
                                        if (tabView9 != null) {
                                            tabView9.setOnClickListener(this);
                                            TabView tabView10 = this.f8201c;
                                            if (tabView10 != null) {
                                                tabView10.setOnClickListener(this);
                                                TabView tabView11 = this.f8202d;
                                                if (tabView11 != null) {
                                                    tabView11.setOnClickListener(this);
                                                    TabView tabView12 = this.e;
                                                    if (tabView12 != null) {
                                                        tabView12.setOnClickListener(this);
                                                        if (com.example.test.utils.k.f8731b == null) {
                                                            synchronized (com.example.test.utils.k.class) {
                                                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                                            }
                                                        }
                                                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                                                        Integer valueOf = kVar != null ? Integer.valueOf(kVar.D()) : null;
                                                        if (valueOf != null && valueOf.intValue() == 15) {
                                                            LinearLayout linearLayout2 = this.f8203f;
                                                            if (linearLayout2 != null) {
                                                                linearLayout2.setBackgroundColor(a1.d.a(context, R$color.ring_leftmenu_bg));
                                                                return;
                                                            } else {
                                                                kotlin.jvm.internal.e.m("parent");
                                                                throw null;
                                                            }
                                                        }
                                                        if (valueOf != null && valueOf.intValue() == 0) {
                                                            LinearLayout linearLayout3 = this.f8203f;
                                                            if (linearLayout3 != null) {
                                                                linearLayout3.setBackgroundColor(a1.d.a(context, R$color.ring_leftmenu_bg));
                                                                return;
                                                            } else {
                                                                kotlin.jvm.internal.e.m("parent");
                                                                throw null;
                                                            }
                                                        }
                                                        if (valueOf != null && valueOf.intValue() == 1) {
                                                            LinearLayout linearLayout4 = this.f8203f;
                                                            if (linearLayout4 != null) {
                                                                linearLayout4.setBackgroundColor(a1.d.a(context, R$color.color_white));
                                                                return;
                                                            } else {
                                                                kotlin.jvm.internal.e.m("parent");
                                                                throw null;
                                                            }
                                                        }
                                                        if (valueOf != null && valueOf.intValue() == 2) {
                                                            LinearLayout linearLayout5 = this.f8203f;
                                                            if (linearLayout5 != null) {
                                                                linearLayout5.setBackgroundColor(a1.d.a(context, R$color.color_white));
                                                                return;
                                                            } else {
                                                                kotlin.jvm.internal.e.m("parent");
                                                                throw null;
                                                            }
                                                        }
                                                        return;
                                                    }
                                                    kotlin.jvm.internal.e.m("tabDevice");
                                                    throw null;
                                                }
                                                kotlin.jvm.internal.e.m("tabSleep");
                                                throw null;
                                            }
                                            kotlin.jvm.internal.e.m("tabActivity");
                                            throw null;
                                        }
                                        kotlin.jvm.internal.e.m("tabHome");
                                        throw null;
                                    }
                                    kotlin.jvm.internal.e.m("tabDevice");
                                    throw null;
                                }
                                kotlin.jvm.internal.e.m("tabSleep");
                                throw null;
                            }
                            kotlin.jvm.internal.e.m("tabActivity");
                            throw null;
                        }
                        kotlin.jvm.internal.e.m("tabHome");
                        throw null;
                    }
                    kotlin.jvm.internal.e.m("tabDevice");
                    throw null;
                }
                kotlin.jvm.internal.e.m("tabSleep");
                throw null;
            }
            kotlin.jvm.internal.e.m("tabActivity");
            throw null;
        }
        kotlin.jvm.internal.e.m("tabHome");
        throw null;
    }
}
