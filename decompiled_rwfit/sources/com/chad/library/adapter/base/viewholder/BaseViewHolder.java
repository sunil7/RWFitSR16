package com.chad.library.adapter.base.viewholder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.databinding.d;
import androidx.databinding.i;
import androidx.databinding.library.R$id;
import androidx.recyclerview.widget.z1;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import kotlin.jvm.internal.e;

@Keep
/* loaded from: classes.dex */
public class BaseViewHolder extends z1 {
    private final SparseArray<View> views;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewHolder(View view) {
        super(view);
        e.g(view, "view");
        this.views = new SparseArray<>();
    }

    public <T extends View> T findView(int i3) {
        return (T) this.itemView.findViewById(i3);
    }

    public <B extends i> B getBinding() {
        View view = this.itemView;
        int i3 = d.f1985a;
        int i10 = i.f1992a;
        if (view == null || view.getTag(R$id.dataBinding) == null) {
            return null;
        }
        throw new ClassCastException();
    }

    public <T extends View> T getView(int i3) {
        T t8 = (T) getViewOrNull(i3);
        if (t8 != null) {
            return t8;
        }
        throw new IllegalStateException(l0.j(i3, "No view found with id ").toString());
    }

    public <T extends View> T getViewOrNull(int i3) {
        T t8;
        T t10 = (T) this.views.get(i3);
        if (t10 == null && (t8 = (T) this.itemView.findViewById(i3)) != null) {
            this.views.put(i3, t8);
            return t8;
        }
        if (t10 == null) {
            return null;
        }
        return t10;
    }

    public BaseViewHolder setBackgroundColor(int i3, int i10) {
        getView(i3).setBackgroundColor(i10);
        return this;
    }

    public BaseViewHolder setBackgroundResource(int i3, int i10) {
        getView(i3).setBackgroundResource(i10);
        return this;
    }

    public BaseViewHolder setEnabled(int i3, boolean z5) {
        getView(i3).setEnabled(z5);
        return this;
    }

    public BaseViewHolder setGone(int i3, boolean z5) {
        getView(i3).setVisibility(z5 ? 8 : 0);
        return this;
    }

    public BaseViewHolder setImageBitmap(int i3, Bitmap bitmap) {
        ((ImageView) getView(i3)).setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setImageDrawable(int i3, Drawable drawable) {
        ((ImageView) getView(i3)).setImageDrawable(drawable);
        return this;
    }

    public BaseViewHolder setImageResource(int i3, int i10) {
        ((ImageView) getView(i3)).setImageResource(i10);
        return this;
    }

    public BaseViewHolder setText(int i3, CharSequence charSequence) {
        ((TextView) getView(i3)).setText(charSequence);
        return this;
    }

    public BaseViewHolder setTextColor(int i3, int i10) {
        ((TextView) getView(i3)).setTextColor(i10);
        return this;
    }

    public BaseViewHolder setTextColorRes(int i3, int i10) {
        TextView textView = (TextView) getView(i3);
        View itemView = this.itemView;
        e.b(itemView, "itemView");
        textView.setTextColor(itemView.getResources().getColor(i10));
        return this;
    }

    public BaseViewHolder setVisible(int i3, boolean z5) {
        getView(i3).setVisibility(z5 ? 0 : 4);
        return this;
    }

    public BaseViewHolder setText(int i3, int i10) {
        ((TextView) getView(i3)).setText(i10);
        return this;
    }
}
