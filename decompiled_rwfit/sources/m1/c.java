package m1;

import android.R;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import okhttp3.internal.http2.Http2;

/* loaded from: classes.dex */
public final class c {
    public static final c e = new c(1);

    /* renamed from: f, reason: collision with root package name */
    public static final c f15924f = new c(2);

    /* renamed from: g, reason: collision with root package name */
    public static final c f15925g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f15926h;

    /* renamed from: i, reason: collision with root package name */
    public static final c f15927i;

    /* renamed from: j, reason: collision with root package name */
    public static final c f15928j;

    /* renamed from: k, reason: collision with root package name */
    public static final c f15929k;

    /* renamed from: l, reason: collision with root package name */
    public static final c f15930l;

    /* renamed from: m, reason: collision with root package name */
    public static final c f15931m;

    /* renamed from: n, reason: collision with root package name */
    public static final c f15932n;

    /* renamed from: o, reason: collision with root package name */
    public static final c f15933o;

    /* renamed from: a, reason: collision with root package name */
    public final Object f15934a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15935b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f15936c;

    /* renamed from: d, reason: collision with root package name */
    public final o f15937d;

    static {
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
        new c(4);
        new c(8);
        f15925g = new c(16);
        new c(32);
        new c(64);
        new c(128);
        new c(h.class, 256);
        new c(h.class, 512);
        new c(i.class, 1024);
        new c(i.class, 2048);
        f15926h = new c(4096);
        f15927i = new c(8192);
        new c(Http2.INITIAL_MAX_FRAME_SIZE);
        new c(32768);
        new c(WXMediaMessage.THUMB_LENGTH_LIMIT);
        new c(m.class, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        f15928j = new c(262144);
        f15929k = new c(524288);
        f15930l = new c(Const.I_MAX_OFFLINE_DATA_CACHE);
        new c(n.class, 2097152);
        int i3 = Build.VERSION.SDK_INT;
        new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
        new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, k.class);
        f15931m = new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
        new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
        f15932n = new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
        new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
        if (i3 >= 29) {
            accessibilityAction16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
            accessibilityAction = accessibilityAction16;
        } else {
            accessibilityAction = null;
        }
        new c(accessibilityAction, R.id.accessibilityActionPageUp, null, null, null);
        if (i3 >= 29) {
            accessibilityAction15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
            accessibilityAction2 = accessibilityAction15;
        } else {
            accessibilityAction2 = null;
        }
        new c(accessibilityAction2, R.id.accessibilityActionPageDown, null, null, null);
        new c(i3 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
        if (i3 >= 29) {
            accessibilityAction14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
            accessibilityAction3 = accessibilityAction14;
        } else {
            accessibilityAction3 = null;
        }
        new c(accessibilityAction3, R.id.accessibilityActionPageRight, null, null, null);
        new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
        f15933o = new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, l.class);
        new c(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, j.class);
        if (i3 >= 28) {
            accessibilityAction13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
            accessibilityAction4 = accessibilityAction13;
        } else {
            accessibilityAction4 = null;
        }
        new c(accessibilityAction4, R.id.accessibilityActionShowTooltip, null, null, null);
        if (i3 >= 28) {
            accessibilityAction12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            accessibilityAction5 = accessibilityAction12;
        } else {
            accessibilityAction5 = null;
        }
        new c(accessibilityAction5, R.id.accessibilityActionHideTooltip, null, null, null);
        new c(i3 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
        if (i3 >= 30) {
            accessibilityAction11 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            accessibilityAction6 = accessibilityAction11;
        } else {
            accessibilityAction6 = null;
        }
        new c(accessibilityAction6, R.id.accessibilityActionImeEnter, null, null, null);
        new c(i3 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
        if (i3 >= 32) {
            accessibilityAction10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
            accessibilityAction7 = accessibilityAction10;
        } else {
            accessibilityAction7 = null;
        }
        new c(accessibilityAction7, R.id.accessibilityActionDragDrop, null, null, null);
        if (i3 >= 32) {
            accessibilityAction9 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
            accessibilityAction8 = accessibilityAction9;
        } else {
            accessibilityAction8 = null;
        }
        new c(accessibilityAction8, R.id.accessibilityActionDragCancel, null, null, null);
        new c(i3 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
    }

    public c(int i3) {
        this(null, i3, null, null, null);
    }

    public final int a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.f15934a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        Object obj2 = ((c) obj).f15934a;
        Object obj3 = this.f15934a;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f15934a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public c(Class cls, int i3) {
        this(null, i3, null, null, cls);
    }

    public c(Object obj, int i3, String str, o oVar, Class cls) {
        this.f15935b = i3;
        this.f15937d = oVar;
        if (obj == null) {
            this.f15934a = new AccessibilityNodeInfo.AccessibilityAction(i3, str);
        } else {
            this.f15934a = obj;
        }
        this.f15936c = cls;
    }
}
