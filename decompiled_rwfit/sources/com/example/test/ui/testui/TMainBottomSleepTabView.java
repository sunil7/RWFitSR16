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
public final class TMainBottomSleepTabView extends LinearLayout implements View.OnClickListener {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f8193f = 0;

    /* renamed from: a, reason: collision with root package name */
    public ViewPager f8194a;

    /* renamed from: b, reason: collision with root package name */
    public final TabView f8195b;

    /* renamed from: c, reason: collision with root package name */
    public final TabView f8196c;

    /* renamed from: d, reason: collision with root package name */
    public final TabView f8197d;
    public final LinearLayout e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TMainBottomSleepTabView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTabPosition(int i3) {
        TabView tabView = this.f8195b;
        if (tabView == null) {
            kotlin.jvm.internal.e.m("tabHome");
            throw null;
        }
        tabView.setTabSelected(i3 == 0);
        TabView tabView2 = this.f8196c;
        if (tabView2 == null) {
            kotlin.jvm.internal.e.m("tabActivity");
            throw null;
        }
        tabView2.setTabSelected(i3 == 1);
        TabView tabView3 = this.f8197d;
        if (tabView3 != null) {
            tabView3.setTabSelected(i3 == 2);
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
            ViewPager viewPager2 = this.f8194a;
            if (viewPager2 != null) {
                viewPager2.v(0, false);
                return;
            }
            return;
        }
        int i10 = R$id.tabSport;
        if (valueOf != null && valueOf.intValue() == i10) {
            ViewPager viewPager3 = this.f8194a;
            if (viewPager3 != null) {
                viewPager3.v(1, false);
                return;
            }
            return;
        }
        int i11 = R$id.tabMine;
        if (valueOf == null || valueOf.intValue() != i11 || (viewPager = this.f8194a) == null) {
            return;
        }
        viewPager.v(2, false);
    }

    public final void setLayoutColor(int i3) {
        LinearLayout linearLayout = this.e;
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(i3);
        } else {
            kotlin.jvm.internal.e.m("parent");
            throw null;
        }
    }

    public final void setViewPager(ViewPager viewPager) {
        kotlin.jvm.internal.e.f(viewPager, "viewPager");
        this.f8194a = viewPager;
        viewPager.addOnPageChangeListener(new f(this, 0));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TMainBottomSleepTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public /* synthetic */ TMainBottomSleepTabView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TMainBottomSleepTabView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        kotlin.jvm.internal.e.f(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_main_bottom_tabs_sleep, this);
        View findViewById = findViewById(R$id.tabParent);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.e = linearLayout;
        b9.a aVar = new b9.a(16);
        WeakHashMap weakHashMap = l1.z0.f15748a;
        l1.n0.u(linearLayout, aVar);
        View findViewById2 = findViewById(R$id.tabHome);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8195b = (TabView) findViewById2;
        View findViewById3 = findViewById(R$id.tabSport);
        kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
        this.f8196c = (TabView) findViewById3;
        View findViewById4 = findViewById(R$id.tabMine);
        kotlin.jvm.internal.e.e(findViewById4, "findViewById(...)");
        this.f8197d = (TabView) findViewById4;
        TabView tabView = this.f8195b;
        if (tabView != null) {
            tabView.setTabName(R$string.str_tab_home);
            TabView tabView2 = this.f8196c;
            if (tabView2 != null) {
                tabView2.setTabName(R$string.str_ring_home_activity);
                TabView tabView3 = this.f8197d;
                if (tabView3 != null) {
                    tabView3.setTabName(R$string.str_tab_device);
                    TabView tabView4 = this.f8195b;
                    if (tabView4 != null) {
                        tabView4.a(R$mipmap.ic_bottom_home_focus, R$mipmap.ic_bottom_home_nor);
                        TabView tabView5 = this.f8196c;
                        if (tabView5 != null) {
                            tabView5.a(R$mipmap.ic_bottom_activity_focus, R$mipmap.ic_bottom_activity_nor);
                            TabView tabView6 = this.f8197d;
                            if (tabView6 != null) {
                                tabView6.a(R$mipmap.ic_bottom_device_focus, R$mipmap.ic_bottom_device_nor);
                                TabView tabView7 = this.f8195b;
                                if (tabView7 != null) {
                                    tabView7.setOnClickListener(this);
                                    TabView tabView8 = this.f8196c;
                                    if (tabView8 != null) {
                                        tabView8.setOnClickListener(this);
                                        TabView tabView9 = this.f8197d;
                                        if (tabView9 != null) {
                                            tabView9.setOnClickListener(this);
                                            if (com.example.test.utils.k.f8731b == null) {
                                                synchronized (com.example.test.utils.k.class) {
                                                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                                                }
                                            }
                                            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                                            Integer valueOf = kVar != null ? Integer.valueOf(kVar.D()) : null;
                                            if (valueOf != null && valueOf.intValue() == 15) {
                                                LinearLayout linearLayout2 = this.e;
                                                if (linearLayout2 != null) {
                                                    linearLayout2.setBackgroundColor(a1.d.a(context, R$color.ring_leftmenu_bg));
                                                    return;
                                                } else {
                                                    kotlin.jvm.internal.e.m("parent");
                                                    throw null;
                                                }
                                            }
                                            if (valueOf != null && valueOf.intValue() == 0) {
                                                LinearLayout linearLayout3 = this.e;
                                                if (linearLayout3 != null) {
                                                    linearLayout3.setBackgroundColor(a1.d.a(context, R$color.ring_leftmenu_bg));
                                                    return;
                                                } else {
                                                    kotlin.jvm.internal.e.m("parent");
                                                    throw null;
                                                }
                                            }
                                            if (valueOf != null && valueOf.intValue() == 1) {
                                                LinearLayout linearLayout4 = this.e;
                                                if (linearLayout4 != null) {
                                                    linearLayout4.setBackgroundColor(a1.d.a(context, R$color.color_white));
                                                    return;
                                                } else {
                                                    kotlin.jvm.internal.e.m("parent");
                                                    throw null;
                                                }
                                            }
                                            if (valueOf != null && valueOf.intValue() == 2) {
                                                LinearLayout linearLayout5 = this.e;
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
                                    kotlin.jvm.internal.e.m("tabActivity");
                                    throw null;
                                }
                                kotlin.jvm.internal.e.m("tabHome");
                                throw null;
                            }
                            kotlin.jvm.internal.e.m("tabDevice");
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
            kotlin.jvm.internal.e.m("tabActivity");
            throw null;
        }
        kotlin.jvm.internal.e.m("tabHome");
        throw null;
    }
}
