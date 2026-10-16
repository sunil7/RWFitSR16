package n;

import android.R;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$drawable;
import androidx.appcompat.widget.l3;
import androidx.appcompat.widget.m2;
import androidx.appcompat.widget.n1;
import androidx.camera.core.impl.o1;
import androidx.camera.core.impl.q1;
import androidx.camera.core.impl.s1;
import com.example.test.ui.view.divider.FlexibleDividerDecoration$DividerType;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class g0 implements c8.b {

    /* renamed from: a, reason: collision with root package name */
    public Object f16174a;

    /* renamed from: b, reason: collision with root package name */
    public Object f16175b;

    /* renamed from: c, reason: collision with root package name */
    public Object f16176c;

    /* renamed from: d, reason: collision with root package name */
    public Object f16177d;
    public Object e;

    /* renamed from: f, reason: collision with root package name */
    public Object f16178f;

    public /* synthetic */ g0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        this.f16174a = obj;
        this.f16175b = obj2;
        this.f16176c = obj3;
        this.f16177d = obj4;
        this.e = obj5;
        this.f16178f = obj6;
    }

    public static boolean b(int i3, int[] iArr) {
        for (int i10 : iArr) {
            if (i10 == i3) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList f(Context context, int i3) {
        int c9 = l3.c(context, R$attr.colorControlHighlight);
        int b3 = l3.b(context, R$attr.colorButtonNormal);
        int[] iArr = l3.f984b;
        int[] iArr2 = l3.f986d;
        int c10 = c1.a.c(c9, i3);
        return new ColorStateList(new int[][]{iArr, iArr2, l3.f985c, l3.f987f}, new int[]{b3, c10, c1.a.c(c9, i3), i3});
    }

    public static LayerDrawable k(m2 m2Var, Context context, int i3) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i3);
        Drawable c9 = m2Var.c(context, R$drawable.abc_star_black_48dp);
        Drawable c10 = m2Var.c(context, R$drawable.abc_star_half_black_48dp);
        if ((c9 instanceof BitmapDrawable) && c9.getIntrinsicWidth() == dimensionPixelSize && c9.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) c9;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            c9.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c9.draw(canvas);
            bitmapDrawable = new BitmapDrawable(createBitmap);
            bitmapDrawable2 = new BitmapDrawable(createBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((c10 instanceof BitmapDrawable) && c10.getIntrinsicWidth() == dimensionPixelSize && c10.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) c10;
        } else {
            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            c10.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c10.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.secondaryProgress);
        layerDrawable.setId(2, R.id.progress);
        return layerDrawable;
    }

    public static void n(Drawable drawable, int i3, PorterDuff.Mode mode) {
        int[] iArr = n1.f1001a;
        Drawable mutate = drawable.mutate();
        if (mode == null) {
            mode = androidx.appcompat.widget.y.f1123b;
        }
        mutate.setColorFilter(androidx.appcompat.widget.y.c(i3, mode));
    }

    public void a(String str, String str2) {
        HashMap hashMap = (HashMap) this.f16178f;
        if (hashMap == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        hashMap.put(str, str2);
    }

    public a8.a c() {
        String str = ((String) this.f16174a) == null ? " transportName" : "";
        if (((a8.e) this.f16176c) == null) {
            str = str.concat(" encodedPayload");
        }
        if (((Long) this.f16177d) == null) {
            str = android.support.v4.media.session.e.l(str, " eventMillis");
        }
        if (((Long) this.e) == null) {
            str = android.support.v4.media.session.e.l(str, " uptimeMillis");
        }
        if (((HashMap) this.f16178f) == null) {
            str = android.support.v4.media.session.e.l(str, " autoMetadata");
        }
        if (str.isEmpty()) {
            return new a8.a((String) this.f16174a, (Integer) this.f16175b, (a8.e) this.f16176c, ((Long) this.f16177d).longValue(), ((Long) this.e).longValue(), (HashMap) this.f16178f);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public y6.d d() {
        y6.d dVar = new y6.d();
        FlexibleDividerDecoration$DividerType flexibleDividerDecoration$DividerType = FlexibleDividerDecoration$DividerType.DRAWABLE;
        dVar.f20015a = flexibleDividerDecoration$DividerType;
        o2.m mVar = (o2.m) this.f16176c;
        if (mVar != null) {
            dVar.f20015a = FlexibleDividerDecoration$DividerType.COLOR;
            dVar.f20017c = mVar;
            dVar.f20019f = new Paint();
            o2.m mVar2 = (o2.m) this.f16177d;
            dVar.e = mVar2;
            if (mVar2 == null) {
                dVar.e = new com.google.android.gms.internal.mlkit_common.o(25);
            }
        } else {
            dVar.f20015a = flexibleDividerDecoration$DividerType;
            TypedArray obtainStyledAttributes = ((Context) this.f16174a).obtainStyledAttributes(y6.d.f20014h);
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            dVar.f20018d = new xg.b(drawable);
            dVar.e = (o2.m) this.f16177d;
        }
        dVar.f20016b = (eb.e) this.e;
        dVar.f20020g = (ec.a) this.f16178f;
        return dVar;
    }

    public void e(int i3) {
        this.f16176c = new o2.m((byte) 0, i3, 14);
    }

    public s1 g() {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        Size size = (Size) this.f16177d;
        surfaceTexture.setDefaultBufferSize(size.getWidth(), size.getHeight());
        Surface surface = new Surface(surfaceTexture);
        androidx.camera.core.impl.n1 d5 = androidx.camera.core.impl.n1.d((f0) this.f16176c, size);
        d5.f1442b.f1356c = 1;
        androidx.camera.core.impl.s0 s0Var = new androidx.camera.core.impl.s0(surface);
        this.f16174a = s0Var;
        ob.a d8 = x.i.d(s0Var.e);
        ef.i iVar = new ef.i(28, surface, surfaceTexture);
        d8.a(new x.h(0, d8, iVar), a6.a());
        d5.b((androidx.camera.core.impl.s0) this.f16174a, t.t.f18406d, -1);
        o1 o1Var = (o1) this.f16178f;
        if (o1Var != null) {
            o1Var.b();
        }
        o1 o1Var2 = new o1(new q1(this, 1));
        this.f16178f = o1Var2;
        d5.f1445f = o1Var2;
        return d5.c();
    }

    @Override // dh.a
    public Object get() {
        return new f8.g((Context) ((yh.i) this.f16174a).f20163a, (b8.f) ((dh.a) this.f16175b).get(), (g8.c) ((dh.a) this.f16176c).get(), (f8.d) ((de.o) this.f16177d).get(), (Executor) ((dh.a) this.e).get(), (h8.b) ((dh.a) this.f16178f).get(), new gc.b(13));
    }

    public void h() {
        Messenger messenger;
        android.support.v4.media.e eVar = ((android.support.v4.media.g) this.f16178f).f311a;
        ef.i iVar = eVar.f307f;
        if (iVar != null && (messenger = eVar.f308g) != null) {
            try {
                iVar.K(messenger, 7, null);
            } catch (RemoteException unused) {
                Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
            }
        }
        eVar.f304b.disconnect();
        ((BroadcastReceiver.PendingResult) this.e).finish();
    }

    public void i(n0 n0Var) {
        ArrayList l3 = l();
        int size = l3.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = l3.get(i3);
            i3++;
            n0 n0Var2 = (n0) obj;
            if (n0Var2 == n0Var) {
                return;
            }
            synchronized (n0Var2.f16257a) {
                try {
                    List list = n0Var2.f16266k;
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((androidx.camera.core.impl.g0) it.next()).b();
                        }
                        n0Var2.f16266k = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            n0Var2.f16275u.h();
        }
    }

    public ArrayList j() {
        ArrayList arrayList;
        synchronized (this.f16175b) {
            arrayList = new ArrayList((LinkedHashSet) this.f16176c);
        }
        return arrayList;
    }

    public ArrayList l() {
        ArrayList arrayList;
        ArrayList arrayList2;
        synchronized (this.f16175b) {
            arrayList = new ArrayList();
            arrayList.addAll(j());
            synchronized (this.f16175b) {
                arrayList2 = new ArrayList((LinkedHashSet) this.e);
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    public ColorStateList m(Context context, int i3) {
        if (i3 == R$drawable.abc_edit_text_material) {
            return pb.a(context, R$color.abc_tint_edittext);
        }
        if (i3 == R$drawable.abc_switch_track_mtrl_alpha) {
            return pb.a(context, R$color.abc_tint_switch_track);
        }
        if (i3 != R$drawable.abc_switch_thumb_material) {
            if (i3 == R$drawable.abc_btn_default_mtrl_shape) {
                return f(context, l3.c(context, R$attr.colorButtonNormal));
            }
            if (i3 == R$drawable.abc_btn_borderless_material) {
                return f(context, 0);
            }
            if (i3 == R$drawable.abc_btn_colored_material) {
                return f(context, l3.c(context, R$attr.colorAccent));
            }
            if (i3 == R$drawable.abc_spinner_mtrl_am_alpha || i3 == R$drawable.abc_spinner_textfield_background_material) {
                return pb.a(context, R$color.abc_tint_spinner);
            }
            if (b(i3, (int[]) this.f16175b)) {
                return l3.d(context, R$attr.colorControlNormal);
            }
            if (b(i3, (int[]) this.e)) {
                return pb.a(context, R$color.abc_tint_default);
            }
            if (b(i3, (int[]) this.f16178f)) {
                return pb.a(context, R$color.abc_tint_btn_checkable);
            }
            if (i3 == R$drawable.abc_seekbar_thumb_material) {
                return pb.a(context, R$color.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList d5 = l3.d(context, R$attr.colorSwitchThumbNormal);
        if (d5 == null || !d5.isStateful()) {
            iArr[0] = l3.f984b;
            iArr2[0] = l3.b(context, R$attr.colorSwitchThumbNormal);
            iArr[1] = l3.e;
            iArr2[1] = l3.c(context, R$attr.colorControlActivated);
            iArr[2] = l3.f987f;
            iArr2[2] = l3.c(context, R$attr.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = l3.f984b;
            iArr[0] = iArr3;
            iArr2[0] = d5.getColorForState(iArr3, 0);
            iArr[1] = l3.e;
            iArr2[1] = l3.c(context, R$attr.colorControlActivated);
            iArr[2] = l3.f987f;
            iArr2[2] = d5.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public void o(int i3) {
        this.f16177d = new o2.m((byte) 0, ((Resources) this.f16175b).getDimensionPixelSize(i3), 15);
    }

    public g0(Set set, String str, String str2) {
        ga.a aVar = ga.a.f14020a;
        Set unmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f16174a = unmodifiableSet;
        Map map = Collections.EMPTY_MAP;
        this.f16176c = str;
        this.f16177d = str2;
        this.e = aVar;
        HashSet hashSet = new HashSet(unmodifiableSet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.session.e.d(it);
        }
        this.f16175b = Collections.unmodifiableSet(hashSet);
    }

    public g0() {
        this.f16174a = new int[]{R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};
        this.f16175b = new int[]{R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_seekbar_tick_mark_material, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha};
        this.f16176c = new int[]{R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material, R$drawable.abc_text_select_handle_left_mtrl, R$drawable.abc_text_select_handle_middle_mtrl, R$drawable.abc_text_select_handle_right_mtrl};
        this.f16177d = new int[]{R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};
        this.e = new int[]{R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material};
        this.f16178f = new int[]{R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material, R$drawable.abc_btn_check_material_anim, R$drawable.abc_btn_radio_material_anim};
    }

    public g0(Context context) {
        this.e = new eb.e(25);
        this.f16174a = context;
        this.f16175b = context.getResources();
        this.f16178f = new ec.a(25);
    }
}
