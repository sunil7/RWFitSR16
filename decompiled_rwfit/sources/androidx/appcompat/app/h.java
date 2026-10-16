package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class h {
    public final int A;
    public final int B;
    public final boolean C;
    public final f D;

    /* renamed from: a, reason: collision with root package name */
    public final Context f482a;

    /* renamed from: b, reason: collision with root package name */
    public final j f483b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f484c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f485d;
    public AlertController$RecycleListView e;

    /* renamed from: f, reason: collision with root package name */
    public View f486f;

    /* renamed from: h, reason: collision with root package name */
    public Button f488h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f489i;

    /* renamed from: j, reason: collision with root package name */
    public Message f490j;

    /* renamed from: k, reason: collision with root package name */
    public Button f491k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f492l;

    /* renamed from: m, reason: collision with root package name */
    public Message f493m;

    /* renamed from: n, reason: collision with root package name */
    public Button f494n;

    /* renamed from: o, reason: collision with root package name */
    public CharSequence f495o;

    /* renamed from: p, reason: collision with root package name */
    public Message f496p;

    /* renamed from: q, reason: collision with root package name */
    public NestedScrollView f497q;
    public Drawable r;

    /* renamed from: s, reason: collision with root package name */
    public ImageView f498s;

    /* renamed from: t, reason: collision with root package name */
    public TextView f499t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f500u;

    /* renamed from: v, reason: collision with root package name */
    public View f501v;

    /* renamed from: w, reason: collision with root package name */
    public ListAdapter f502w;

    /* renamed from: y, reason: collision with root package name */
    public final int f504y;

    /* renamed from: z, reason: collision with root package name */
    public final int f505z;

    /* renamed from: g, reason: collision with root package name */
    public boolean f487g = false;

    /* renamed from: x, reason: collision with root package name */
    public int f503x = -1;
    public final c E = new c(this, 0);

    public h(Context context, j jVar, Window window) {
        this.f482a = context;
        this.f483b = jVar;
        this.f484c = window;
        f fVar = new f();
        fVar.f470b = new WeakReference(jVar);
        this.D = fVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.AlertDialog, R$attr.alertDialogStyle, 0);
        this.f504y = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_android_layout, 0);
        obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.f505z = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listLayout, 0);
        obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.A = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.B = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listItemLayout, 0);
        this.C = obtainStyledAttributes.getBoolean(R$styleable.AlertDialog_showTitle, true);
        obtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        jVar.b().h(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static ViewGroup b(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void c(int i3, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message obtainMessage = onClickListener != null ? this.D.obtainMessage(i3, onClickListener) : null;
        if (i3 == -3) {
            this.f495o = charSequence;
            this.f496p = obtainMessage;
        } else if (i3 == -2) {
            this.f492l = charSequence;
            this.f493m = obtainMessage;
        } else {
            if (i3 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f489i = charSequence;
            this.f490j = obtainMessage;
        }
    }
}
