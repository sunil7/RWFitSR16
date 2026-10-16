package p1;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.example.test.ui.device.activity.e0;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.WeakHashMap;
import l1.h0;
import l1.z0;

/* loaded from: classes.dex */
public final class a extends e0 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f17351c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(25);
        this.f17351c = bVar;
    }

    @Override // com.example.test.ui.device.activity.e0
    public final m1.d A(int i3) {
        return new m1.d(AccessibilityNodeInfo.obtain(this.f17351c.r(i3).f15938a));
    }

    @Override // com.example.test.ui.device.activity.e0
    public final m1.d D(int i3) {
        b bVar = this.f17351c;
        int i10 = i3 == 2 ? bVar.f17361k : bVar.f17362l;
        if (i10 == Integer.MIN_VALUE) {
            return null;
        }
        return A(i10);
    }

    @Override // com.example.test.ui.device.activity.e0
    public final boolean G(int i3, int i10, Bundle bundle) {
        int i11;
        b bVar = this.f17351c;
        View view = bVar.f17359i;
        if (i3 == -1) {
            WeakHashMap weakHashMap = z0.f15748a;
            return h0.j(view, i10, bundle);
        }
        if (i10 == 1) {
            return bVar.w(i3);
        }
        if (i10 == 2) {
            return bVar.j(i3);
        }
        if (i10 != 64) {
            if (i10 != 128) {
                return bVar.s(i3, i10, bundle);
            }
            if (bVar.f17361k != i3) {
                return false;
            }
            bVar.f17361k = Integer.MIN_VALUE;
            view.invalidate();
            bVar.x(i3, WXMediaMessage.THUMB_LENGTH_LIMIT);
            return true;
        }
        AccessibilityManager accessibilityManager = bVar.f17358h;
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i11 = bVar.f17361k) == i3) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            bVar.f17361k = Integer.MIN_VALUE;
            bVar.f17359i.invalidate();
            bVar.x(i11, WXMediaMessage.THUMB_LENGTH_LIMIT);
        }
        bVar.f17361k = i3;
        view.invalidate();
        bVar.x(i3, 32768);
        return true;
    }
}
