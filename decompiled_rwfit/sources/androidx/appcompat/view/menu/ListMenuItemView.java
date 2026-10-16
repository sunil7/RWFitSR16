package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import de.o;
import h.m;
import h.y;
import java.util.WeakHashMap;
import l1.h0;
import l1.z0;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements y, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    public m f590a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f591b;

    /* renamed from: c, reason: collision with root package name */
    public RadioButton f592c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f593d;
    public CheckBox e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f594f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f595g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f596h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f597i;

    /* renamed from: j, reason: collision with root package name */
    public final Drawable f598j;

    /* renamed from: k, reason: collision with root package name */
    public final int f599k;

    /* renamed from: l, reason: collision with root package name */
    public final Context f600l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f601m;

    /* renamed from: n, reason: collision with root package name */
    public final Drawable f602n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f603o;

    /* renamed from: p, reason: collision with root package name */
    public LayoutInflater f604p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f605q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.f604p == null) {
            this.f604p = LayoutInflater.from(getContext());
        }
        return this.f604p;
    }

    private void setSubMenuArrowVisible(boolean z5) {
        ImageView imageView = this.f595g;
        if (imageView != null) {
            imageView.setVisibility(z5 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f596h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f596h.getLayoutParams();
        rect.top = this.f596h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        if (r0 == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011b  */
    @Override // h.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(h.m r11) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.d(h.m):void");
    }

    @Override // h.y
    public m getItemData() {
        return this.f590a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        WeakHashMap weakHashMap = z0.f15748a;
        h0.q(this, this.f598j);
        TextView textView = (TextView) findViewById(R$id.title);
        this.f593d = textView;
        int i3 = this.f599k;
        if (i3 != -1) {
            textView.setTextAppearance(this.f600l, i3);
        }
        this.f594f = (TextView) findViewById(R$id.shortcut);
        ImageView imageView = (ImageView) findViewById(R$id.submenuarrow);
        this.f595g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f602n);
        }
        this.f596h = (ImageView) findViewById(R$id.group_divider);
        this.f597i = (LinearLayout) findViewById(R$id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        if (this.f591b != null && this.f601m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f591b.getLayoutParams();
            int i11 = layoutParams.height;
            if (i11 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i11;
            }
        }
        super.onMeasure(i3, i10);
    }

    public void setCheckable(boolean z5) {
        CompoundButton compoundButton;
        View view;
        if (!z5 && this.f592c == null && this.e == null) {
            return;
        }
        if ((this.f590a.f14190x & 4) != 0) {
            if (this.f592c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f592c = radioButton;
                LinearLayout linearLayout = this.f597i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f592c;
            view = this.e;
        } else {
            if (this.e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.e = checkBox;
                LinearLayout linearLayout2 = this.f597i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.e;
            view = this.f592c;
        }
        if (z5) {
            compoundButton.setChecked(this.f590a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.e;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f592c;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z5) {
        CompoundButton compoundButton;
        if ((this.f590a.f14190x & 4) != 0) {
            if (this.f592c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f592c = radioButton;
                LinearLayout linearLayout = this.f597i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f592c;
        } else {
            if (this.e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.e = checkBox;
                LinearLayout linearLayout2 = this.f597i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.e;
        }
        compoundButton.setChecked(z5);
    }

    public void setForceShowIcon(boolean z5) {
        this.f605q = z5;
        this.f601m = z5;
    }

    public void setGroupDividerEnabled(boolean z5) {
        ImageView imageView = this.f596h;
        if (imageView != null) {
            imageView.setVisibility((this.f603o || !z5) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f590a.f14181n.getClass();
        boolean z5 = this.f605q;
        if (z5 || this.f601m) {
            ImageView imageView = this.f591b;
            if (imageView == null && drawable == null && !this.f601m) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R$layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f591b = imageView2;
                LinearLayout linearLayout = this.f597i;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f601m) {
                this.f591b.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f591b;
            if (!z5) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f591b.getVisibility() != 0) {
                this.f591b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f593d.getVisibility() != 8) {
                this.f593d.setVisibility(8);
            }
        } else {
            this.f593d.setText(charSequence);
            if (this.f593d.getVisibility() != 0) {
                this.f593d.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        o I = o.I(getContext(), attributeSet, R$styleable.MenuView, i3);
        this.f598j = I.w(R$styleable.MenuView_android_itemBackground);
        int i10 = R$styleable.MenuView_android_itemTextAppearance;
        TypedArray typedArray = (TypedArray) I.f12378c;
        this.f599k = typedArray.getResourceId(i10, -1);
        this.f601m = typedArray.getBoolean(R$styleable.MenuView_preserveIconSpacing, false);
        this.f600l = context;
        this.f602n = I.w(R$styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, R$attr.dropDownListViewStyle, 0);
        this.f603o = obtainStyledAttributes.hasValue(0);
        I.K();
        obtainStyledAttributes.recycle();
    }
}
