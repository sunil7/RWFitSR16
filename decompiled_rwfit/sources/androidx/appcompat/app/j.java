package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.widget.y1;
import androidx.core.widget.NestedScrollView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.WeakHashMap;
import l1.z0;

/* loaded from: classes.dex */
public final class j extends e0 implements DialogInterface {
    public final h e;

    public j(ContextThemeWrapper contextThemeWrapper, int i3) {
        super(contextThemeWrapper, f(contextThemeWrapper, i3));
        this.e = new h(getContext(), this, getWindow());
    }

    public static int f(Context context, int i3) {
        if (((i3 >>> 24) & 255) >= 1) {
            return i3;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // androidx.appcompat.app.e0, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        char c9;
        int i3;
        ListAdapter listAdapter;
        View findViewById;
        super.onCreate(bundle);
        h hVar = this.e;
        hVar.f483b.setContentView(hVar.f504y);
        int i10 = R$id.parentPanel;
        Window window = hVar.f484c;
        View findViewById2 = window.findViewById(i10);
        View findViewById3 = findViewById2.findViewById(R$id.topPanel);
        View findViewById4 = findViewById2.findViewById(R$id.contentPanel);
        View findViewById5 = findViewById2.findViewById(R$id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(R$id.customPanel);
        View view = hVar.f486f;
        if (view == null) {
            view = null;
        }
        boolean z5 = view != null;
        if (!z5 || !h.a(view)) {
            window.setFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        }
        if (z5) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R$id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (hVar.f487g) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (hVar.e != null) {
                ((LinearLayout.LayoutParams) ((y1) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById6 = viewGroup.findViewById(R$id.topPanel);
        View findViewById7 = viewGroup.findViewById(R$id.contentPanel);
        View findViewById8 = viewGroup.findViewById(R$id.buttonPanel);
        ViewGroup b3 = h.b(findViewById6, findViewById3);
        ViewGroup b10 = h.b(findViewById7, findViewById4);
        ViewGroup b11 = h.b(findViewById8, findViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R$id.scrollView);
        hVar.f497q = nestedScrollView;
        nestedScrollView.setFocusable(false);
        hVar.f497q.setNestedScrollingEnabled(false);
        TextView textView = (TextView) b10.findViewById(R.id.message);
        hVar.f500u = textView;
        if (textView == null) {
            c9 = 4;
        } else {
            textView.setVisibility(8);
            hVar.f497q.removeView(hVar.f500u);
            if (hVar.e != null) {
                ViewGroup viewGroup2 = (ViewGroup) hVar.f497q.getParent();
                int indexOfChild = viewGroup2.indexOfChild(hVar.f497q);
                viewGroup2.removeViewAt(indexOfChild);
                c9 = 4;
                viewGroup2.addView(hVar.e, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
            } else {
                c9 = 4;
                b10.setVisibility(8);
            }
        }
        Button button = (Button) b11.findViewById(R.id.button1);
        hVar.f488h = button;
        c cVar = hVar.E;
        button.setOnClickListener(cVar);
        if (TextUtils.isEmpty(hVar.f489i)) {
            hVar.f488h.setVisibility(8);
            i3 = 0;
        } else {
            hVar.f488h.setText(hVar.f489i);
            hVar.f488h.setVisibility(0);
            i3 = 1;
        }
        Button button2 = (Button) b11.findViewById(R.id.button2);
        hVar.f491k = button2;
        button2.setOnClickListener(cVar);
        if (TextUtils.isEmpty(hVar.f492l)) {
            hVar.f491k.setVisibility(8);
        } else {
            hVar.f491k.setText(hVar.f492l);
            hVar.f491k.setVisibility(0);
            i3 |= 2;
        }
        Button button3 = (Button) b11.findViewById(R.id.button3);
        hVar.f494n = button3;
        button3.setOnClickListener(cVar);
        if (TextUtils.isEmpty(hVar.f495o)) {
            hVar.f494n.setVisibility(8);
        } else {
            hVar.f494n.setText(hVar.f495o);
            hVar.f494n.setVisibility(0);
            i3 |= 4;
        }
        TypedValue typedValue = new TypedValue();
        hVar.f482a.getTheme().resolveAttribute(R$attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i3 == 1) {
                Button button4 = hVar.f488h;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (i3 == 2) {
                Button button5 = hVar.f491k;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i3 == c9) {
                Button button6 = hVar.f494n;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i3 == 0) {
            b11.setVisibility(8);
        }
        if (hVar.f501v != null) {
            b3.addView(hVar.f501v, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R$id.title_template).setVisibility(8);
        } else {
            hVar.f498s = (ImageView) window.findViewById(R.id.icon);
            if (TextUtils.isEmpty(hVar.f485d) || !hVar.C) {
                window.findViewById(R$id.title_template).setVisibility(8);
                hVar.f498s.setVisibility(8);
                b3.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(R$id.alertTitle);
                hVar.f499t = textView2;
                textView2.setText(hVar.f485d);
                Drawable drawable = hVar.r;
                if (drawable != null) {
                    hVar.f498s.setImageDrawable(drawable);
                } else {
                    hVar.f499t.setPadding(hVar.f498s.getPaddingLeft(), hVar.f498s.getPaddingTop(), hVar.f498s.getPaddingRight(), hVar.f498s.getPaddingBottom());
                    hVar.f498s.setVisibility(8);
                }
            }
        }
        boolean z6 = viewGroup.getVisibility() != 8;
        int i11 = (b3 == null || b3.getVisibility() == 8) ? 0 : 1;
        boolean z8 = b11.getVisibility() != 8;
        if (!z8 && (findViewById = b10.findViewById(R$id.textSpacerNoButtons)) != null) {
            findViewById.setVisibility(0);
        }
        if (i11 != 0) {
            NestedScrollView nestedScrollView2 = hVar.f497q;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View findViewById9 = hVar.e != null ? b3.findViewById(R$id.titleDividerNoCustom) : null;
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        } else {
            View findViewById10 = b10.findViewById(R$id.textSpacerNoTitle);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = hVar.e;
        if (alertController$RecycleListView != null && (!z8 || i11 == 0)) {
            alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i11 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.f397a, alertController$RecycleListView.getPaddingRight(), z8 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.f398b);
        }
        if (!z6) {
            View view2 = hVar.e;
            if (view2 == null) {
                view2 = hVar.f497q;
            }
            if (view2 != null) {
                int i12 = z8 ? 2 : 0;
                View findViewById11 = window.findViewById(R$id.scrollIndicatorUp);
                View findViewById12 = window.findViewById(R$id.scrollIndicatorDown);
                WeakHashMap weakHashMap = z0.f15748a;
                l1.o0.d(view2, i11 | i12, 3);
                if (findViewById11 != null) {
                    b10.removeView(findViewById11);
                }
                if (findViewById12 != null) {
                    b10.removeView(findViewById12);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = hVar.e;
        if (alertController$RecycleListView2 == null || (listAdapter = hVar.f502w) == null) {
            return;
        }
        alertController$RecycleListView2.setAdapter(listAdapter);
        int i13 = hVar.f503x;
        if (i13 > -1) {
            alertController$RecycleListView2.setItemChecked(i13, true);
            alertController$RecycleListView2.setSelection(i13);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i3, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.e.f497q;
        if (nestedScrollView == null || !nestedScrollView.h(keyEvent)) {
            return super.onKeyDown(i3, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i3, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.e.f497q;
        if (nestedScrollView == null || !nestedScrollView.h(keyEvent)) {
            return super.onKeyUp(i3, keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.app.e0, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        h hVar = this.e;
        hVar.f485d = charSequence;
        TextView textView = hVar.f499t;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
