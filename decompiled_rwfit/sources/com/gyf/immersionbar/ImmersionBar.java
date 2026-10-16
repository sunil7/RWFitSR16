package com.gyf.immersionbar;

import a1.d;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.p;
import c1.a;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.util.HashMap;
import java.util.Map;

@TargetApi(19)
/* loaded from: classes.dex */
public final class ImmersionBar implements ImmersionCallback {
    private int mActionBarHeight;
    private Activity mActivity;
    private BarConfig mBarConfig;
    private BarParams mBarParams;
    private ViewGroup mContentView;
    private ViewGroup mDecorView;
    private Dialog mDialog;
    private FitsKeyboard mFitsKeyboard;
    private int mFitsStatusBarType;
    private Fragment mFragment;
    private boolean mInitialized;
    private boolean mIsActionBarBelowLOLLIPOP;
    private boolean mIsActivity;
    private boolean mIsDialog;
    private boolean mIsDialogFragment;
    private boolean mIsFragment;
    private boolean mKeyboardTempEnable;
    private int mNavigationBarHeight;
    private int mNavigationBarWidth;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private ImmersionBar mParentBar;
    private androidx.fragment.app.Fragment mSupportFragment;
    private Map<String, BarParams> mTagMap;
    private Window mWindow;

    /* renamed from: com.gyf.immersionbar.ImmersionBar$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$gyf$immersionbar$BarHide;

        static {
            int[] iArr = new int[BarHide.values().length];
            $SwitchMap$com$gyf$immersionbar$BarHide = iArr;
            try {
                iArr[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$gyf$immersionbar$BarHide[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$gyf$immersionbar$BarHide[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$gyf$immersionbar$BarHide[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ImmersionBar(Activity activity) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsActivity = true;
        this.mActivity = activity;
        initCommonParameter(activity.getWindow());
    }

    private void adjustDarkModeParams() {
        int i3;
        int i10;
        BarParams barParams = this.mBarParams;
        if (barParams.autoStatusBarDarkModeEnable && (i10 = barParams.statusBarColor) != 0) {
            statusBarDarkFont(i10 > -4539718, barParams.autoStatusBarDarkModeAlpha);
        }
        BarParams barParams2 = this.mBarParams;
        if (!barParams2.autoNavigationBarDarkModeEnable || (i3 = barParams2.navigationBarColor) == 0) {
            return;
        }
        navigationBarDarkIcon(i3 > -4539718, barParams2.autoNavigationBarDarkModeAlpha);
    }

    private void cancelListener() {
        if (this.mActivity != null) {
            FitsKeyboard fitsKeyboard = this.mFitsKeyboard;
            if (fitsKeyboard != null) {
                fitsKeyboard.cancel();
                this.mFitsKeyboard = null;
            }
            EMUI3NavigationBarObserver.getInstance().removeOnNavigationBarListener(this);
            NavigationBarObserver.getInstance().removeOnNavigationBarListener(this.mBarParams.onNavigationBarListener);
        }
    }

    public static boolean checkFitsSystemWindows(View view) {
        if (view == null) {
            return false;
        }
        if (view.getFitsSystemWindows()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (((childAt instanceof DrawerLayout) && checkFitsSystemWindows(childAt)) || childAt.getFitsSystemWindows()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkInitWithActivity() {
        if (this.mParentBar == null) {
            this.mParentBar = with(this.mActivity);
        }
        ImmersionBar immersionBar = this.mParentBar;
        if (immersionBar == null || immersionBar.mInitialized) {
            return;
        }
        immersionBar.init();
    }

    public static void destroy(androidx.fragment.app.Fragment fragment) {
        getRetriever().destroy(fragment, false);
    }

    private void fitsKeyboard() {
        if (!this.mIsFragment) {
            if (this.mBarParams.keyboardEnable) {
                if (this.mFitsKeyboard == null) {
                    this.mFitsKeyboard = new FitsKeyboard(this);
                }
                this.mFitsKeyboard.enable(this.mBarParams.keyboardMode);
                return;
            } else {
                FitsKeyboard fitsKeyboard = this.mFitsKeyboard;
                if (fitsKeyboard != null) {
                    fitsKeyboard.disable();
                    return;
                }
                return;
            }
        }
        ImmersionBar immersionBar = this.mParentBar;
        if (immersionBar != null) {
            if (immersionBar.mBarParams.keyboardEnable) {
                if (immersionBar.mFitsKeyboard == null) {
                    immersionBar.mFitsKeyboard = new FitsKeyboard(immersionBar);
                }
                ImmersionBar immersionBar2 = this.mParentBar;
                immersionBar2.mFitsKeyboard.enable(immersionBar2.mBarParams.keyboardMode);
                return;
            }
            FitsKeyboard fitsKeyboard2 = immersionBar.mFitsKeyboard;
            if (fitsKeyboard2 != null) {
                fitsKeyboard2.disable();
            }
        }
    }

    private void fitsLayoutOverlap() {
        int statusBarHeight = this.mBarParams.fitsLayoutOverlapEnable ? getStatusBarHeight(this.mActivity) : 0;
        int i3 = this.mFitsStatusBarType;
        if (i3 == 1) {
            setTitleBar(this.mActivity, statusBarHeight, this.mBarParams.titleBarView);
        } else if (i3 == 2) {
            setTitleBarMarginTop(this.mActivity, statusBarHeight, this.mBarParams.titleBarView);
        } else {
            if (i3 != 3) {
                return;
            }
            setStatusBarView(this.mActivity, statusBarHeight, this.mBarParams.statusBarView);
        }
    }

    private void fitsNotchScreen() {
        if (Build.VERSION.SDK_INT < 28 || this.mInitialized) {
            return;
        }
        WindowManager.LayoutParams attributes = this.mWindow.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        this.mWindow.setAttributes(attributes);
    }

    private void fitsWindows() {
        if (OSUtils.isEMUI3_x()) {
            fitsWindowsBelowLOLLIPOP();
        } else {
            fitsWindowsAboveLOLLIPOP();
        }
        fitsLayoutOverlap();
    }

    private void fitsWindowsAboveLOLLIPOP() {
        updateBarConfig();
        if (checkFitsSystemWindows(this.mDecorView.findViewById(android.R.id.content))) {
            setPadding(0, 0, 0, 0);
            return;
        }
        int statusBarHeight = (this.mBarParams.fits && this.mFitsStatusBarType == 4) ? this.mBarConfig.getStatusBarHeight() : 0;
        if (this.mBarParams.isSupportActionBar) {
            statusBarHeight = this.mBarConfig.getStatusBarHeight() + this.mActionBarHeight;
        }
        setPadding(0, statusBarHeight, 0, 0);
    }

    private void fitsWindowsBelowLOLLIPOP() {
        if (this.mBarParams.isSupportActionBar) {
            this.mIsActionBarBelowLOLLIPOP = true;
            this.mContentView.post(this);
        } else {
            this.mIsActionBarBelowLOLLIPOP = false;
            postFitsWindowsBelowLOLLIPOP();
        }
    }

    private void fitsWindowsEMUI() {
        View findViewById = this.mDecorView.findViewById(Constants.IMMERSION_ID_NAVIGATION_BAR_VIEW);
        BarParams barParams = this.mBarParams;
        if (!barParams.navigationBarEnable || !barParams.navigationBarWithKitkatEnable) {
            EMUI3NavigationBarObserver.getInstance().removeOnNavigationBarListener(this);
            findViewById.setVisibility(8);
        } else if (findViewById != null) {
            EMUI3NavigationBarObserver.getInstance().addOnNavigationBarListener(this);
            EMUI3NavigationBarObserver.getInstance().register(this.mActivity.getApplication());
        }
    }

    private void fitsWindowsKITKAT() {
        int i3;
        int i10;
        if (checkFitsSystemWindows(this.mDecorView.findViewById(android.R.id.content))) {
            setPadding(0, 0, 0, 0);
            return;
        }
        int statusBarHeight = (this.mBarParams.fits && this.mFitsStatusBarType == 4) ? this.mBarConfig.getStatusBarHeight() : 0;
        if (this.mBarParams.isSupportActionBar) {
            statusBarHeight = this.mBarConfig.getStatusBarHeight() + this.mActionBarHeight;
        }
        if (this.mBarConfig.hasNavigationBar()) {
            BarParams barParams = this.mBarParams;
            if (barParams.navigationBarEnable && barParams.navigationBarWithKitkatEnable) {
                if (barParams.fullScreen) {
                    i3 = 0;
                    i10 = 0;
                } else if (this.mBarConfig.isNavigationAtBottom()) {
                    i10 = this.mBarConfig.getNavigationBarHeight();
                    i3 = 0;
                } else {
                    i3 = this.mBarConfig.getNavigationBarWidth();
                    i10 = 0;
                }
                if (this.mBarParams.hideNavigationBar) {
                    if (this.mBarConfig.isNavigationAtBottom()) {
                        i10 = 0;
                    } else {
                        i3 = 0;
                    }
                } else if (!this.mBarConfig.isNavigationAtBottom()) {
                    i3 = this.mBarConfig.getNavigationBarWidth();
                }
                setPadding(0, statusBarHeight, i3, i10);
            }
        }
        i3 = 0;
        i10 = 0;
        setPadding(0, statusBarHeight, i3, i10);
    }

    @TargetApi(14)
    public static int getNavigationBarHeight(Activity activity) {
        return new BarConfig(activity).getNavigationBarHeight();
    }

    @TargetApi(14)
    public static int getNavigationBarWidth(Activity activity) {
        return new BarConfig(activity).getNavigationBarWidth();
    }

    public static int getNotchHeight(Activity activity) {
        if (hasNotchScreen(activity)) {
            return NotchUtils.getNotchHeight(activity);
        }
        return 0;
    }

    private static RequestManagerRetriever getRetriever() {
        return RequestManagerRetriever.getInstance();
    }

    @TargetApi(14)
    public static int getStatusBarHeight(Activity activity) {
        return new BarConfig(activity).getStatusBarHeight();
    }

    @TargetApi(14)
    public static boolean hasNavigationBar(Activity activity) {
        return new BarConfig(activity).hasNavigationBar();
    }

    public static boolean hasNotchScreen(Activity activity) {
        return NotchUtils.hasNotchScreen(activity);
    }

    private int hideBar(int i3) {
        int i10 = AnonymousClass2.$SwitchMap$com$gyf$immersionbar$BarHide[this.mBarParams.barHide.ordinal()];
        if (i10 == 1) {
            i3 |= 518;
        } else if (i10 == 2) {
            i3 |= 1028;
        } else if (i10 == 3) {
            i3 |= 514;
        }
        return i3 | 4096;
    }

    public static void hideStatusBar(Window window) {
        window.setFlags(1024, 1024);
    }

    private int initBarAboveLOLLIPOP(int i3) {
        if (!this.mInitialized) {
            this.mBarParams.defaultNavigationBarColor = this.mWindow.getNavigationBarColor();
        }
        int i10 = i3 | 1024;
        BarParams barParams = this.mBarParams;
        if (barParams.fullScreen && barParams.navigationBarEnable) {
            i10 = i3 | 1536;
        }
        this.mWindow.clearFlags(67108864);
        if (this.mBarConfig.hasNavigationBar()) {
            this.mWindow.clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        }
        this.mWindow.addFlags(Integer.MIN_VALUE);
        BarParams barParams2 = this.mBarParams;
        if (barParams2.statusBarColorEnabled) {
            this.mWindow.setStatusBarColor(a.b(barParams2.statusBarColor, barParams2.statusBarAlpha, barParams2.statusBarColorTransform));
        } else {
            this.mWindow.setStatusBarColor(a.b(barParams2.statusBarColor, barParams2.statusBarAlpha, 0));
        }
        BarParams barParams3 = this.mBarParams;
        if (!barParams3.navigationBarEnable) {
            this.mWindow.setNavigationBarColor(barParams3.defaultNavigationBarColor);
            return i10;
        }
        this.mWindow.setNavigationBarColor(a.b(barParams3.navigationBarColor, barParams3.navigationBarAlpha, barParams3.navigationBarColorTransform));
        return i10;
    }

    private void initBarBelowLOLLIPOP() {
        this.mWindow.addFlags(67108864);
        setupStatusBarView();
        if (this.mBarConfig.hasNavigationBar() || OSUtils.isEMUI3_x()) {
            BarParams barParams = this.mBarParams;
            if (barParams.navigationBarEnable && barParams.navigationBarWithKitkatEnable) {
                this.mWindow.addFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
            } else {
                this.mWindow.clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
            }
            if (this.mNavigationBarHeight == 0) {
                this.mNavigationBarHeight = this.mBarConfig.getNavigationBarHeight();
            }
            if (this.mNavigationBarWidth == 0) {
                this.mNavigationBarWidth = this.mBarConfig.getNavigationBarWidth();
            }
            setupNavBarView();
        }
    }

    private void initCommonParameter(Window window) {
        this.mWindow = window;
        this.mBarParams = new BarParams();
        ViewGroup viewGroup = (ViewGroup) this.mWindow.getDecorView();
        this.mDecorView = viewGroup;
        this.mContentView = (ViewGroup) viewGroup.findViewById(android.R.id.content);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    @TargetApi(14)
    public static boolean isNavigationAtBottom(Activity activity) {
        return new BarConfig(activity).isNavigationAtBottom();
    }

    public static boolean isSupportNavigationIconDark() {
        OSUtils.isMIUI6Later();
        return true;
    }

    public static boolean isSupportStatusBarDarkFont() {
        if (OSUtils.isMIUI6Later()) {
            return true;
        }
        OSUtils.isFlymeOS4Later();
        return true;
    }

    private void postFitsWindowsBelowLOLLIPOP() {
        updateBarConfig();
        fitsWindowsKITKAT();
        if (this.mIsFragment || !OSUtils.isEMUI3_x()) {
            return;
        }
        fitsWindowsEMUI();
    }

    public static void setFitsSystemWindows(Activity activity, boolean z5) {
        if (activity == null) {
            return;
        }
        setFitsSystemWindows(((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0), z5);
    }

    private int setNavigationIconDark(int i3) {
        return this.mBarParams.navigationBarDarkIcon ? i3 | 16 : i3;
    }

    private void setPadding(int i3, int i10, int i11, int i12) {
        ViewGroup viewGroup = this.mContentView;
        if (viewGroup != null) {
            viewGroup.setPadding(i3, i10, i11, i12);
        }
        this.mPaddingLeft = i3;
        this.mPaddingTop = i10;
        this.mPaddingRight = i11;
        this.mPaddingBottom = i12;
    }

    private void setSpecialBarDarkMode() {
        if (OSUtils.isMIUI6Later()) {
            SpecialBarFontUtils.setMIUIBarDark(this.mWindow, "EXTRA_FLAG_STATUS_BAR_DARK_MODE", this.mBarParams.statusBarDarkFont);
            BarParams barParams = this.mBarParams;
            if (barParams.navigationBarEnable) {
                SpecialBarFontUtils.setMIUIBarDark(this.mWindow, "EXTRA_FLAG_NAVIGATION_BAR_DARK_MODE", barParams.navigationBarDarkIcon);
            }
        }
        if (OSUtils.isFlymeOS4Later()) {
            BarParams barParams2 = this.mBarParams;
            int i3 = barParams2.flymeOSStatusBarFontColor;
            if (i3 != 0) {
                SpecialBarFontUtils.setStatusBarDarkIcon(this.mActivity, i3);
            } else {
                SpecialBarFontUtils.setStatusBarDarkIcon(this.mActivity, barParams2.statusBarDarkFont);
            }
        }
    }

    private int setStatusBarDarkFont(int i3) {
        return this.mBarParams.statusBarDarkFont ? i3 | 8192 : i3;
    }

    public static void setStatusBarView(Activity activity, int i3, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        for (View view : viewArr) {
            if (view != null) {
                Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i3) {
                    view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i3));
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, 0);
                    }
                    layoutParams.height = i3;
                    view.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public static void setTitleBar(Activity activity, final int i3, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        for (final View view : viewArr) {
            if (view != null) {
                final Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i3) {
                    view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i3));
                    final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, -2);
                    }
                    int i10 = layoutParams.height;
                    if (i10 == -2 || i10 == -1) {
                        view.post(new Runnable() { // from class: com.gyf.immersionbar.ImmersionBar.1
                            @Override // java.lang.Runnable
                            public void run() {
                                layoutParams.height = (view.getHeight() + i3) - num.intValue();
                                View view2 = view;
                                view2.setPadding(view2.getPaddingLeft(), (view.getPaddingTop() + i3) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                                view.setLayoutParams(layoutParams);
                            }
                        });
                    } else {
                        layoutParams.height = (i3 - num.intValue()) + i10;
                        view.setPadding(view.getPaddingLeft(), (view.getPaddingTop() + i3) - num.intValue(), view.getPaddingRight(), view.getPaddingBottom());
                        view.setLayoutParams(layoutParams);
                    }
                }
            }
        }
    }

    public static void setTitleBarMarginTop(Activity activity, int i3, View... viewArr) {
        if (activity == null) {
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        for (View view : viewArr) {
            if (view != null) {
                Integer num = (Integer) view.getTag(R.id.immersion_fits_layout_overlap);
                if (num == null) {
                    num = 0;
                }
                if (num.intValue() != i3) {
                    view.setTag(R.id.immersion_fits_layout_overlap, Integer.valueOf(i3));
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (marginLayoutParams.topMargin + i3) - num.intValue(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    private void setupNavBarView() {
        FrameLayout.LayoutParams layoutParams;
        ViewGroup viewGroup = this.mDecorView;
        int i3 = Constants.IMMERSION_ID_NAVIGATION_BAR_VIEW;
        View findViewById = viewGroup.findViewById(i3);
        if (findViewById == null) {
            findViewById = new View(this.mActivity);
            findViewById.setId(i3);
            this.mDecorView.addView(findViewById);
        }
        if (this.mBarConfig.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.mBarConfig.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.mBarConfig.getNavigationBarWidth(), -1);
            layoutParams.gravity = 8388613;
        }
        findViewById.setLayoutParams(layoutParams);
        BarParams barParams = this.mBarParams;
        findViewById.setBackgroundColor(a.b(barParams.navigationBarColor, barParams.navigationBarAlpha, barParams.navigationBarColorTransform));
        BarParams barParams2 = this.mBarParams;
        if (barParams2.navigationBarEnable && barParams2.navigationBarWithKitkatEnable && !barParams2.hideNavigationBar) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    private void setupStatusBarView() {
        ViewGroup viewGroup = this.mDecorView;
        int i3 = Constants.IMMERSION_ID_STATUS_BAR_VIEW;
        View findViewById = viewGroup.findViewById(i3);
        if (findViewById == null) {
            findViewById = new View(this.mActivity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.mBarConfig.getStatusBarHeight());
            layoutParams.gravity = 48;
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
            findViewById.setId(i3);
            this.mDecorView.addView(findViewById);
        }
        BarParams barParams = this.mBarParams;
        if (!barParams.statusBarColorEnabled) {
            findViewById.setBackgroundColor(a.b(barParams.statusBarColor, barParams.statusBarAlpha, 0));
            return;
        }
        findViewById.setBackgroundColor(a.b(barParams.statusBarColor, barParams.statusBarAlpha, barParams.statusBarColorTransform));
    }

    public static void showStatusBar(Window window) {
        window.clearFlags(1024);
    }

    private void transformView() {
        if (this.mBarParams.viewMap.size() != 0) {
            for (Map.Entry<View, Map<Integer, Integer>> entry : this.mBarParams.viewMap.entrySet()) {
                View key = entry.getKey();
                Map<Integer, Integer> value = entry.getValue();
                Integer valueOf = Integer.valueOf(this.mBarParams.statusBarColor);
                Integer valueOf2 = Integer.valueOf(this.mBarParams.statusBarColorTransform);
                for (Map.Entry<Integer, Integer> entry2 : value.entrySet()) {
                    Integer key2 = entry2.getKey();
                    valueOf2 = entry2.getValue();
                    valueOf = key2;
                }
                if (key != null) {
                    if (Math.abs(this.mBarParams.viewAlpha - 0.0f) == 0.0f) {
                        key.setBackgroundColor(a.b(valueOf.intValue(), this.mBarParams.statusBarAlpha, valueOf2.intValue()));
                    } else {
                        key.setBackgroundColor(a.b(valueOf.intValue(), this.mBarParams.viewAlpha, valueOf2.intValue()));
                    }
                }
            }
        }
    }

    private void updateBarConfig() {
        BarConfig barConfig = new BarConfig(this.mActivity);
        this.mBarConfig = barConfig;
        if (!this.mInitialized || this.mIsActionBarBelowLOLLIPOP) {
            this.mActionBarHeight = barConfig.getActionBarHeight();
        }
    }

    private void updateBarParams() {
        adjustDarkModeParams();
        updateBarConfig();
        ImmersionBar immersionBar = this.mParentBar;
        if (immersionBar != null) {
            if (this.mIsFragment) {
                immersionBar.mBarParams = this.mBarParams;
            }
            if (this.mIsDialog && immersionBar.mKeyboardTempEnable) {
                immersionBar.mBarParams.keyboardEnable = false;
            }
        }
    }

    public static ImmersionBar with(Activity activity) {
        return getRetriever().get(activity);
    }

    public ImmersionBar addTag(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("tag不能为空");
        }
        this.mTagMap.put(str, this.mBarParams.m72clone());
        return this;
    }

    public ImmersionBar addViewSupportTransformColor(View view) {
        return addViewSupportTransformColorInt(view, this.mBarParams.statusBarColorTransform);
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, int i3) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(this.mBarParams.statusBarColor), Integer.valueOf(i3));
        this.mBarParams.viewMap.put(view, hashMap);
        return this;
    }

    public ImmersionBar applySystemFits(boolean z5) {
        this.mBarParams.fitsLayoutOverlapEnable = !z5;
        setFitsSystemWindows(this.mActivity, z5);
        return this;
    }

    public ImmersionBar autoDarkModeEnable(boolean z5) {
        return autoDarkModeEnable(z5, 0.2f);
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean z5) {
        return autoNavigationBarDarkModeEnable(z5, 0.2f);
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean z5) {
        return autoStatusBarDarkModeEnable(z5, 0.2f);
    }

    public ImmersionBar barAlpha(float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarAlpha = f2;
        barParams.statusBarTempAlpha = f2;
        barParams.navigationBarAlpha = f2;
        barParams.navigationBarTempAlpha = f2;
        return this;
    }

    public ImmersionBar barColor(int i3) {
        return barColorInt(d.a(this.mActivity, i3));
    }

    public ImmersionBar barColorInt(int i3) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i3;
        barParams.navigationBarColor = i3;
        return this;
    }

    public ImmersionBar barColorTransform(int i3) {
        return barColorTransformInt(d.a(this.mActivity, i3));
    }

    public ImmersionBar barColorTransformInt(int i3) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColorTransform = i3;
        barParams.navigationBarColorTransform = i3;
        return this;
    }

    public ImmersionBar barEnable(boolean z5) {
        this.mBarParams.barEnable = z5;
        return this;
    }

    public ImmersionBar fitsLayoutOverlapEnable(boolean z5) {
        this.mBarParams.fitsLayoutOverlapEnable = z5;
        return this;
    }

    public ImmersionBar fitsSystemWindows(boolean z5) {
        this.mBarParams.fits = z5;
        if (!z5) {
            this.mFitsStatusBarType = 0;
            return this;
        }
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 4;
        }
        return this;
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z5, int i3) {
        return fitsSystemWindowsInt(z5, i3, -16777216, 0.0f);
    }

    public ImmersionBar flymeOSStatusBarFontColor(int i3) {
        this.mBarParams.flymeOSStatusBarFontColor = d.a(this.mActivity, i3);
        BarParams barParams = this.mBarParams;
        barParams.flymeOSStatusBarFontTempColor = barParams.flymeOSStatusBarFontColor;
        return this;
    }

    public ImmersionBar flymeOSStatusBarFontColorInt(int i3) {
        BarParams barParams = this.mBarParams;
        barParams.flymeOSStatusBarFontColor = i3;
        barParams.flymeOSStatusBarFontTempColor = i3;
        return this;
    }

    public ImmersionBar fullScreen(boolean z5) {
        this.mBarParams.fullScreen = z5;
        return this;
    }

    public int getActionBarHeight() {
        return this.mActionBarHeight;
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public BarConfig getBarConfig() {
        if (this.mBarConfig == null) {
            this.mBarConfig = new BarConfig(this.mActivity);
        }
        return this.mBarConfig;
    }

    public BarParams getBarParams() {
        return this.mBarParams;
    }

    public Fragment getFragment() {
        return this.mFragment;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public androidx.fragment.app.Fragment getSupportFragment() {
        return this.mSupportFragment;
    }

    public ImmersionBar getTag(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("tag不能为空");
        }
        BarParams barParams = this.mTagMap.get(str);
        if (barParams != null) {
            this.mBarParams = barParams.m72clone();
        }
        return this;
    }

    public Window getWindow() {
        return this.mWindow;
    }

    public void init() {
        if (this.mBarParams.barEnable) {
            updateBarParams();
            setBar();
            fitsWindows();
            fitsKeyboard();
            transformView();
            this.mInitialized = true;
        }
    }

    public boolean initialized() {
        return this.mInitialized;
    }

    public boolean isDialogFragment() {
        return this.mIsDialogFragment;
    }

    public boolean isFragment() {
        return this.mIsFragment;
    }

    public ImmersionBar keyboardEnable(boolean z5) {
        return keyboardEnable(z5, this.mBarParams.keyboardMode);
    }

    public ImmersionBar keyboardMode(int i3) {
        this.mBarParams.keyboardMode = i3;
        return this;
    }

    public ImmersionBar navigationBarAlpha(float f2) {
        BarParams barParams = this.mBarParams;
        barParams.navigationBarAlpha = f2;
        barParams.navigationBarTempAlpha = f2;
        return this;
    }

    public ImmersionBar navigationBarColor(int i3) {
        return navigationBarColorInt(d.a(this.mActivity, i3));
    }

    public ImmersionBar navigationBarColorInt(int i3) {
        this.mBarParams.navigationBarColor = i3;
        return this;
    }

    public ImmersionBar navigationBarColorTransform(int i3) {
        return navigationBarColorTransformInt(d.a(this.mActivity, i3));
    }

    public ImmersionBar navigationBarColorTransformInt(int i3) {
        this.mBarParams.navigationBarColorTransform = i3;
        return this;
    }

    public ImmersionBar navigationBarDarkIcon(boolean z5) {
        return navigationBarDarkIcon(z5, 0.2f);
    }

    public ImmersionBar navigationBarEnable(boolean z5) {
        this.mBarParams.navigationBarEnable = z5;
        return this;
    }

    public ImmersionBar navigationBarWithEMUI3Enable(boolean z5) {
        if (OSUtils.isEMUI3_x()) {
            BarParams barParams = this.mBarParams;
            barParams.navigationBarWithEMUI3Enable = z5;
            barParams.navigationBarWithKitkatEnable = z5;
        }
        return this;
    }

    public ImmersionBar navigationBarWithKitkatEnable(boolean z5) {
        this.mBarParams.navigationBarWithKitkatEnable = z5;
        return this;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!OSUtils.isEMUI3_x()) {
            fitsWindows();
        } else if (this.mInitialized && !this.mIsFragment && this.mBarParams.navigationBarWithKitkatEnable) {
            init();
        } else {
            fitsWindows();
        }
    }

    public void onDestroy() {
        ImmersionBar immersionBar;
        cancelListener();
        if (this.mIsDialog && (immersionBar = this.mParentBar) != null) {
            BarParams barParams = immersionBar.mBarParams;
            barParams.keyboardEnable = immersionBar.mKeyboardTempEnable;
            if (barParams.barHide != BarHide.FLAG_SHOW_BAR) {
                immersionBar.setBar();
            }
        }
        this.mInitialized = false;
    }

    @Override // com.gyf.immersionbar.OnNavigationBarListener
    public void onNavigationBarChange(boolean z5) {
        View findViewById = this.mDecorView.findViewById(Constants.IMMERSION_ID_NAVIGATION_BAR_VIEW);
        if (findViewById != null) {
            this.mBarConfig = new BarConfig(this.mActivity);
            int paddingBottom = this.mContentView.getPaddingBottom();
            int paddingRight = this.mContentView.getPaddingRight();
            if (z5) {
                findViewById.setVisibility(0);
                if (!checkFitsSystemWindows(this.mDecorView.findViewById(android.R.id.content))) {
                    if (this.mNavigationBarHeight == 0) {
                        this.mNavigationBarHeight = this.mBarConfig.getNavigationBarHeight();
                    }
                    if (this.mNavigationBarWidth == 0) {
                        this.mNavigationBarWidth = this.mBarConfig.getNavigationBarWidth();
                    }
                    if (!this.mBarParams.hideNavigationBar) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) findViewById.getLayoutParams();
                        if (this.mBarConfig.isNavigationAtBottom()) {
                            layoutParams.gravity = 80;
                            paddingBottom = this.mNavigationBarHeight;
                            layoutParams.height = paddingBottom;
                            if (this.mBarParams.fullScreen) {
                                paddingBottom = 0;
                            }
                            paddingRight = 0;
                        } else {
                            layoutParams.gravity = 8388613;
                            int i3 = this.mNavigationBarWidth;
                            layoutParams.width = i3;
                            if (this.mBarParams.fullScreen) {
                                i3 = 0;
                            }
                            paddingRight = i3;
                            paddingBottom = 0;
                        }
                        findViewById.setLayoutParams(layoutParams);
                    }
                    setPadding(0, this.mContentView.getPaddingTop(), paddingRight, paddingBottom);
                }
            } else {
                findViewById.setVisibility(8);
            }
            paddingBottom = 0;
            paddingRight = 0;
            setPadding(0, this.mContentView.getPaddingTop(), paddingRight, paddingBottom);
        }
    }

    public void onResume() {
        if (this.mIsFragment || !this.mInitialized || this.mBarParams == null) {
            return;
        }
        if (OSUtils.isEMUI3_x() && this.mBarParams.navigationBarWithEMUI3Enable) {
            init();
        } else if (this.mBarParams.barHide != BarHide.FLAG_SHOW_BAR) {
            setBar();
        }
    }

    public ImmersionBar removeSupportAllView() {
        if (this.mBarParams.viewMap.size() != 0) {
            this.mBarParams.viewMap.clear();
        }
        return this;
    }

    public ImmersionBar removeSupportView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View参数不能为空");
        }
        Map<Integer, Integer> map = this.mBarParams.viewMap.get(view);
        if (map != null && map.size() != 0) {
            this.mBarParams.viewMap.remove(view);
        }
        return this;
    }

    public ImmersionBar reset() {
        this.mBarParams = new BarParams();
        this.mFitsStatusBarType = 0;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        postFitsWindowsBelowLOLLIPOP();
    }

    public void setBar() {
        int i3 = 256;
        if (OSUtils.isEMUI3_x()) {
            initBarBelowLOLLIPOP();
        } else {
            fitsNotchScreen();
            i3 = setNavigationIconDark(setStatusBarDarkFont(initBarAboveLOLLIPOP(256)));
        }
        this.mDecorView.setSystemUiVisibility(hideBar(i3));
        setSpecialBarDarkMode();
        if (this.mBarParams.onNavigationBarListener != null) {
            NavigationBarObserver.getInstance().register(this.mActivity.getApplication());
        }
    }

    public ImmersionBar setOnBarListener(OnBarListener onBarListener) {
        if (onBarListener != null) {
            BarParams barParams = this.mBarParams;
            if (barParams.onBarListener == null) {
                barParams.onBarListener = onBarListener;
                return this;
            }
        } else {
            BarParams barParams2 = this.mBarParams;
            if (barParams2.onBarListener != null) {
                barParams2.onBarListener = null;
            }
        }
        return this;
    }

    public ImmersionBar setOnKeyboardListener(OnKeyboardListener onKeyboardListener) {
        BarParams barParams = this.mBarParams;
        if (barParams.onKeyboardListener == null) {
            barParams.onKeyboardListener = onKeyboardListener;
        }
        return this;
    }

    public ImmersionBar setOnNavigationBarListener(OnNavigationBarListener onNavigationBarListener) {
        if (onNavigationBarListener != null) {
            BarParams barParams = this.mBarParams;
            if (barParams.onNavigationBarListener == null) {
                barParams.onNavigationBarListener = onNavigationBarListener;
                NavigationBarObserver.getInstance().addOnNavigationBarListener(this.mBarParams.onNavigationBarListener);
                return this;
            }
        } else if (this.mBarParams.onNavigationBarListener != null) {
            NavigationBarObserver.getInstance().removeOnNavigationBarListener(this.mBarParams.onNavigationBarListener);
            this.mBarParams.onNavigationBarListener = null;
        }
        return this;
    }

    public ImmersionBar statusBarAlpha(float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarAlpha = f2;
        barParams.statusBarTempAlpha = f2;
        return this;
    }

    public ImmersionBar statusBarColor(int i3) {
        return statusBarColorInt(d.a(this.mActivity, i3));
    }

    public ImmersionBar statusBarColorInt(int i3) {
        this.mBarParams.statusBarColor = i3;
        return this;
    }

    public ImmersionBar statusBarColorTransform(int i3) {
        return statusBarColorTransformInt(d.a(this.mActivity, i3));
    }

    public ImmersionBar statusBarColorTransformEnable(boolean z5) {
        this.mBarParams.statusBarColorEnabled = z5;
        return this;
    }

    public ImmersionBar statusBarColorTransformInt(int i3) {
        this.mBarParams.statusBarColorTransform = i3;
        return this;
    }

    public ImmersionBar statusBarDarkFont(boolean z5) {
        return statusBarDarkFont(z5, 0.2f);
    }

    public ImmersionBar statusBarView(View view) {
        if (view != null) {
            this.mBarParams.statusBarView = view;
            if (this.mFitsStatusBarType == 0) {
                this.mFitsStatusBarType = 3;
            }
        }
        return this;
    }

    public ImmersionBar supportActionBar(boolean z5) {
        this.mBarParams.isSupportActionBar = z5;
        return this;
    }

    public ImmersionBar titleBar(View view) {
        return view == null ? this : titleBar(view, true);
    }

    public ImmersionBar titleBarMarginTop(int i3) {
        androidx.fragment.app.Fragment fragment = this.mSupportFragment;
        if (fragment != null && fragment.getView() != null) {
            return titleBarMarginTop(this.mSupportFragment.getView().findViewById(i3));
        }
        Fragment fragment2 = this.mFragment;
        return (fragment2 == null || fragment2.getView() == null) ? titleBarMarginTop(this.mActivity.findViewById(i3)) : titleBarMarginTop(this.mFragment.getView().findViewById(i3));
    }

    public ImmersionBar transparentBar() {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = 0;
        barParams.navigationBarColor = 0;
        barParams.fullScreen = true;
        return this;
    }

    public ImmersionBar transparentNavigationBar() {
        BarParams barParams = this.mBarParams;
        barParams.navigationBarColor = 0;
        barParams.fullScreen = true;
        return this;
    }

    public ImmersionBar transparentStatusBar() {
        this.mBarParams.statusBarColor = 0;
        return this;
    }

    public ImmersionBar viewAlpha(float f2) {
        this.mBarParams.viewAlpha = f2;
        return this;
    }

    public static void destroy(androidx.fragment.app.Fragment fragment, boolean z5) {
        getRetriever().destroy(fragment, z5);
    }

    @TargetApi(14)
    public static int getActionBarHeight(Activity activity) {
        return new BarConfig(activity).getActionBarHeight();
    }

    public static boolean hasNotchScreen(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNotchScreen(fragment.getActivity());
    }

    public static void setFitsSystemWindows(Activity activity) {
        setFitsSystemWindows(activity, true);
    }

    public static ImmersionBar with(androidx.fragment.app.Fragment fragment) {
        return getRetriever().get(fragment, false);
    }

    public ImmersionBar addViewSupportTransformColor(View view, int i3) {
        return addViewSupportTransformColorInt(view, d.a(this.mActivity, i3));
    }

    public ImmersionBar autoDarkModeEnable(boolean z5, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.autoStatusBarDarkModeEnable = z5;
        barParams.autoStatusBarDarkModeAlpha = f2;
        barParams.autoNavigationBarDarkModeEnable = z5;
        barParams.autoNavigationBarDarkModeAlpha = f2;
        return this;
    }

    public ImmersionBar autoNavigationBarDarkModeEnable(boolean z5, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.autoNavigationBarDarkModeEnable = z5;
        barParams.autoNavigationBarDarkModeAlpha = f2;
        return this;
    }

    public ImmersionBar autoStatusBarDarkModeEnable(boolean z5, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.autoStatusBarDarkModeEnable = z5;
        barParams.autoStatusBarDarkModeAlpha = f2;
        return this;
    }

    public ImmersionBar fitsSystemWindowsInt(boolean z5, int i3, int i10, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.fits = z5;
        barParams.contentColor = i3;
        barParams.contentColorTransform = i10;
        barParams.contentAlpha = f2;
        if (!z5) {
            this.mFitsStatusBarType = 0;
        } else if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 4;
        }
        this.mContentView.setBackgroundColor(a.b(i3, f2, i10));
        return this;
    }

    public ImmersionBar hideBar(BarHide barHide) {
        this.mBarParams.barHide = barHide;
        if (OSUtils.isEMUI3_x()) {
            BarParams barParams = this.mBarParams;
            BarHide barHide2 = barParams.barHide;
            barParams.hideNavigationBar = barHide2 == BarHide.FLAG_HIDE_NAVIGATION_BAR || barHide2 == BarHide.FLAG_HIDE_BAR;
        }
        return this;
    }

    public ImmersionBar keyboardEnable(boolean z5, int i3) {
        BarParams barParams = this.mBarParams;
        barParams.keyboardEnable = z5;
        barParams.keyboardMode = i3;
        this.mKeyboardTempEnable = z5;
        return this;
    }

    public ImmersionBar navigationBarColorInt(int i3, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.navigationBarColor = i3;
        barParams.navigationBarAlpha = f2;
        return this;
    }

    public ImmersionBar navigationBarDarkIcon(boolean z5, float f2) {
        this.mBarParams.navigationBarDarkIcon = z5;
        if (z5 && !isSupportNavigationIconDark()) {
            this.mBarParams.navigationBarAlpha = f2;
            return this;
        }
        BarParams barParams = this.mBarParams;
        barParams.navigationBarAlpha = barParams.navigationBarTempAlpha;
        return this;
    }

    public ImmersionBar statusBarColorInt(int i3, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i3;
        barParams.statusBarAlpha = f2;
        return this;
    }

    public ImmersionBar statusBarDarkFont(boolean z5, float f2) {
        this.mBarParams.statusBarDarkFont = z5;
        if (z5 && !isSupportStatusBarDarkFont()) {
            this.mBarParams.statusBarAlpha = f2;
            return this;
        }
        BarParams barParams = this.mBarParams;
        barParams.flymeOSStatusBarFontColor = barParams.flymeOSStatusBarFontTempColor;
        barParams.statusBarAlpha = barParams.statusBarTempAlpha;
        return this;
    }

    public ImmersionBar titleBar(View view, boolean z5) {
        if (view == null) {
            return this;
        }
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 1;
        }
        BarParams barParams = this.mBarParams;
        barParams.titleBarView = view;
        barParams.statusBarColorEnabled = z5;
        return this;
    }

    public static void destroy(Activity activity, Dialog dialog) {
        getRetriever().destroy(activity, dialog);
    }

    @TargetApi(14)
    public static int getNavigationBarHeight(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarHeight(fragment.getActivity());
    }

    @TargetApi(14)
    public static int getNavigationBarWidth(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarWidth(fragment.getActivity());
    }

    public static int getNotchHeight(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNotchHeight(fragment.getActivity());
    }

    @TargetApi(14)
    public static int getStatusBarHeight(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getStatusBarHeight(fragment.getActivity());
    }

    @TargetApi(14)
    public static boolean hasNavigationBar(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNavigationBar(fragment.getActivity());
    }

    @TargetApi(14)
    public static boolean isNavigationAtBottom(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return isNavigationAtBottom(fragment.getActivity());
    }

    public static void setFitsSystemWindows(androidx.fragment.app.Fragment fragment, boolean z5) {
        if (fragment == null) {
            return;
        }
        setFitsSystemWindows(fragment.getActivity(), z5);
    }

    public static ImmersionBar with(androidx.fragment.app.Fragment fragment, boolean z5) {
        return getRetriever().get(fragment, z5);
    }

    public ImmersionBar barColorInt(int i3, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i3;
        barParams.navigationBarColor = i3;
        barParams.statusBarAlpha = f2;
        barParams.navigationBarAlpha = f2;
        return this;
    }

    @TargetApi(14)
    public static int getActionBarHeight(androidx.fragment.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getActionBarHeight(fragment.getActivity());
    }

    public static boolean hasNotchScreen(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNotchScreen(fragment.getActivity());
    }

    public static void setFitsSystemWindows(androidx.fragment.app.Fragment fragment) {
        if (fragment == null) {
            return;
        }
        setFitsSystemWindows(fragment.getActivity());
    }

    public static ImmersionBar with(Fragment fragment) {
        return getRetriever().get(fragment, false);
    }

    public ImmersionBar barColor(int i3, float f2) {
        return barColorInt(d.a(this.mActivity, i3), i3);
    }

    public ImmersionBar barColorTransform(String str) {
        return barColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar navigationBarColor(int i3, float f2) {
        return navigationBarColorInt(d.a(this.mActivity, i3), f2);
    }

    public ImmersionBar navigationBarColorInt(int i3, int i10, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.navigationBarColor = i3;
        barParams.navigationBarColorTransform = i10;
        barParams.navigationBarAlpha = f2;
        return this;
    }

    public ImmersionBar navigationBarColorTransform(String str) {
        return navigationBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarColor(int i3, float f2) {
        return statusBarColorInt(d.a(this.mActivity, i3), f2);
    }

    public ImmersionBar statusBarColorInt(int i3, int i10, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i3;
        barParams.statusBarColorTransform = i10;
        barParams.statusBarAlpha = f2;
        return this;
    }

    public ImmersionBar statusBarColorTransform(String str) {
        return statusBarColorTransformInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarView(int i3) {
        return statusBarView(this.mActivity.findViewById(i3));
    }

    @TargetApi(14)
    public static int getNavigationBarHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarHeight(fragment.getActivity());
    }

    @TargetApi(14)
    public static int getNavigationBarWidth(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNavigationBarWidth(fragment.getActivity());
    }

    public static int getNotchHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getNotchHeight(fragment.getActivity());
    }

    @TargetApi(14)
    public static int getStatusBarHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getStatusBarHeight(fragment.getActivity());
    }

    @TargetApi(14)
    public static boolean hasNavigationBar(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return hasNavigationBar(fragment.getActivity());
    }

    @TargetApi(14)
    public static boolean isNavigationAtBottom(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return false;
        }
        return isNavigationAtBottom(fragment.getActivity());
    }

    public static void setFitsSystemWindows(Fragment fragment, boolean z5) {
        if (fragment == null) {
            return;
        }
        setFitsSystemWindows(fragment.getActivity(), z5);
    }

    public static ImmersionBar with(Fragment fragment, boolean z5) {
        return getRetriever().get(fragment, z5);
    }

    public ImmersionBar addViewSupportTransformColor(View view, int i3, int i10) {
        return addViewSupportTransformColorInt(view, d.a(this.mActivity, i3), d.a(this.mActivity, i10));
    }

    public ImmersionBar addViewSupportTransformColorInt(View view, int i3, int i10) {
        if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Integer.valueOf(i3), Integer.valueOf(i10));
            this.mBarParams.viewMap.put(view, hashMap);
            return this;
        }
        throw new IllegalArgumentException("View参数不能为空");
    }

    public ImmersionBar fitsSystemWindows(boolean z5, int i3) {
        return fitsSystemWindowsInt(z5, d.a(this.mActivity, i3));
    }

    public ImmersionBar flymeOSStatusBarFontColor(String str) {
        this.mBarParams.flymeOSStatusBarFontColor = Color.parseColor(str);
        BarParams barParams = this.mBarParams;
        barParams.flymeOSStatusBarFontTempColor = barParams.flymeOSStatusBarFontColor;
        return this;
    }

    public ImmersionBar statusBarView(int i3, View view) {
        return statusBarView(view.findViewById(i3));
    }

    @TargetApi(14)
    public static int getActionBarHeight(Fragment fragment) {
        if (fragment.getActivity() == null) {
            return 0;
        }
        return getActionBarHeight(fragment.getActivity());
    }

    public static boolean hasNotchScreen(View view) {
        return NotchUtils.hasNotchScreen(view);
    }

    public static void setFitsSystemWindows(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        setFitsSystemWindows(fragment.getActivity());
    }

    public static ImmersionBar with(p pVar) {
        return getRetriever().get((androidx.fragment.app.Fragment) pVar, false);
    }

    public ImmersionBar titleBar(int i3) {
        return titleBar(i3, true);
    }

    public ImmersionBar titleBarMarginTop(int i3, View view) {
        return titleBarMarginTop(view.findViewById(i3));
    }

    private static void setFitsSystemWindows(View view, boolean z5) {
        if (view == null) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup instanceof DrawerLayout) {
                setFitsSystemWindows(viewGroup.getChildAt(0), z5);
                return;
            } else {
                viewGroup.setFitsSystemWindows(z5);
                viewGroup.setClipToPadding(true);
                return;
            }
        }
        view.setFitsSystemWindows(z5);
    }

    public static ImmersionBar with(DialogFragment dialogFragment) {
        return getRetriever().get((Fragment) dialogFragment, false);
    }

    public ImmersionBar barColor(int i3, int i10, float f2) {
        return barColorInt(d.a(this.mActivity, i3), d.a(this.mActivity, i10), f2);
    }

    public ImmersionBar barColorInt(int i3, int i10, float f2) {
        BarParams barParams = this.mBarParams;
        barParams.statusBarColor = i3;
        barParams.navigationBarColor = i3;
        barParams.statusBarColorTransform = i10;
        barParams.navigationBarColorTransform = i10;
        barParams.statusBarAlpha = f2;
        barParams.navigationBarAlpha = f2;
        return this;
    }

    public ImmersionBar navigationBarColor(int i3, int i10, float f2) {
        return navigationBarColorInt(d.a(this.mActivity, i3), d.a(this.mActivity, i10), f2);
    }

    public ImmersionBar statusBarColor(int i3, int i10, float f2) {
        return statusBarColorInt(d.a(this.mActivity, i3), d.a(this.mActivity, i10), f2);
    }

    public ImmersionBar titleBar(int i3, boolean z5) {
        androidx.fragment.app.Fragment fragment = this.mSupportFragment;
        if (fragment != null && fragment.getView() != null) {
            return titleBar(this.mSupportFragment.getView().findViewById(i3), z5);
        }
        Fragment fragment2 = this.mFragment;
        if (fragment2 != null && fragment2.getView() != null) {
            return titleBar(this.mFragment.getView().findViewById(i3), z5);
        }
        return titleBar(this.mActivity.findViewById(i3), z5);
    }

    public ImmersionBar titleBarMarginTop(View view) {
        if (view == null) {
            return this;
        }
        if (this.mFitsStatusBarType == 0) {
            this.mFitsStatusBarType = 2;
        }
        this.mBarParams.titleBarView = view;
        return this;
    }

    public static ImmersionBar with(Activity activity, Dialog dialog) {
        return getRetriever().get(activity, dialog);
    }

    public ImmersionBar fitsSystemWindows(boolean z5, int i3, int i10, float f2) {
        return fitsSystemWindowsInt(z5, d.a(this.mActivity, i3), d.a(this.mActivity, i10), f2);
    }

    public static void setStatusBarView(Activity activity, View... viewArr) {
        setStatusBarView(activity, getStatusBarHeight(activity), viewArr);
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str));
    }

    public static void setStatusBarView(androidx.fragment.app.Fragment fragment, int i3, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setStatusBarView(fragment.getActivity(), i3, viewArr);
    }

    public ImmersionBar addViewSupportTransformColor(View view, String str, String str2) {
        return addViewSupportTransformColorInt(view, Color.parseColor(str), Color.parseColor(str2));
    }

    public static void setStatusBarView(androidx.fragment.app.Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setStatusBarView(fragment.getActivity(), viewArr);
    }

    public ImmersionBar barColor(String str) {
        return barColorInt(Color.parseColor(str));
    }

    public ImmersionBar navigationBarColor(String str) {
        return navigationBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar statusBarColor(String str) {
        return statusBarColorInt(Color.parseColor(str));
    }

    public ImmersionBar titleBar(int i3, View view) {
        return titleBar(view.findViewById(i3), true);
    }

    public static void setStatusBarView(Fragment fragment, int i3, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setStatusBarView(fragment.getActivity(), i3, viewArr);
    }

    public static void setTitleBarMarginTop(Activity activity, View... viewArr) {
        setTitleBarMarginTop(activity, getStatusBarHeight(activity), viewArr);
    }

    public ImmersionBar barColor(String str, float f2) {
        return barColorInt(Color.parseColor(str), f2);
    }

    public ImmersionBar navigationBarColor(String str, float f2) {
        return navigationBarColorInt(Color.parseColor(str), f2);
    }

    public ImmersionBar statusBarColor(String str, float f2) {
        return statusBarColorInt(Color.parseColor(str), f2);
    }

    public ImmersionBar titleBar(int i3, View view, boolean z5) {
        return titleBar(view.findViewById(i3), z5);
    }

    public static void setStatusBarView(Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setStatusBarView(fragment.getActivity(), viewArr);
    }

    public static void setTitleBarMarginTop(androidx.fragment.app.Fragment fragment, int i3, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBarMarginTop(fragment.getActivity(), i3, viewArr);
    }

    public ImmersionBar barColor(String str, String str2, float f2) {
        return barColorInt(Color.parseColor(str), Color.parseColor(str2), f2);
    }

    public ImmersionBar navigationBarColor(String str, String str2, float f2) {
        return navigationBarColorInt(Color.parseColor(str), Color.parseColor(str2), f2);
    }

    public ImmersionBar statusBarColor(String str, String str2, float f2) {
        return statusBarColorInt(Color.parseColor(str), Color.parseColor(str2), f2);
    }

    public static void setTitleBar(Activity activity, View... viewArr) {
        setTitleBar(activity, getStatusBarHeight(activity), viewArr);
    }

    public static void setTitleBarMarginTop(androidx.fragment.app.Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBarMarginTop(fragment.getActivity(), viewArr);
    }

    public static void setTitleBar(androidx.fragment.app.Fragment fragment, int i3, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBar(fragment.getActivity(), i3, viewArr);
    }

    public static void setTitleBarMarginTop(Fragment fragment, int i3, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBarMarginTop(fragment.getActivity(), i3, viewArr);
    }

    public static void setTitleBar(androidx.fragment.app.Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBar(fragment.getActivity(), viewArr);
    }

    public static void setTitleBarMarginTop(Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBarMarginTop(fragment.getActivity(), viewArr);
    }

    public static void setTitleBar(Fragment fragment, int i3, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBar(fragment.getActivity(), i3, viewArr);
    }

    public ImmersionBar(androidx.fragment.app.Fragment fragment) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsFragment = true;
        this.mActivity = fragment.getActivity();
        this.mSupportFragment = fragment;
        checkInitWithActivity();
        initCommonParameter(this.mActivity.getWindow());
    }

    public static void setTitleBar(Fragment fragment, View... viewArr) {
        if (fragment == null) {
            return;
        }
        setTitleBar(fragment.getActivity(), viewArr);
    }

    public ImmersionBar(Fragment fragment) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsFragment = true;
        this.mActivity = fragment.getActivity();
        this.mFragment = fragment;
        checkInitWithActivity();
        initCommonParameter(this.mActivity.getWindow());
    }

    public ImmersionBar(p pVar) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsDialog = true;
        this.mIsDialogFragment = true;
        this.mActivity = pVar.getActivity();
        this.mSupportFragment = pVar;
        this.mDialog = pVar.f2246l;
        checkInitWithActivity();
        initCommonParameter(this.mDialog.getWindow());
    }

    public ImmersionBar(DialogFragment dialogFragment) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsDialog = true;
        this.mIsDialogFragment = true;
        this.mActivity = dialogFragment.getActivity();
        this.mFragment = dialogFragment;
        this.mDialog = dialogFragment.getDialog();
        checkInitWithActivity();
        initCommonParameter(this.mDialog.getWindow());
    }

    public ImmersionBar(Activity activity, Dialog dialog) {
        this.mIsActivity = false;
        this.mIsFragment = false;
        this.mIsDialogFragment = false;
        this.mIsDialog = false;
        this.mNavigationBarHeight = 0;
        this.mNavigationBarWidth = 0;
        this.mActionBarHeight = 0;
        this.mFitsKeyboard = null;
        this.mTagMap = new HashMap();
        this.mFitsStatusBarType = 0;
        this.mInitialized = false;
        this.mIsActionBarBelowLOLLIPOP = false;
        this.mKeyboardTempEnable = false;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mIsDialog = true;
        this.mActivity = activity;
        this.mDialog = dialog;
        checkInitWithActivity();
        initCommonParameter(this.mDialog.getWindow());
    }
}
