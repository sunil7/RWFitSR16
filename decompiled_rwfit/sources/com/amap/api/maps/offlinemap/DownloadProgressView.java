package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.map3d.R;

/* loaded from: classes.dex */
public class DownloadProgressView extends View {

    /* renamed from: a, reason: collision with root package name */
    private String f5776a;

    /* renamed from: b, reason: collision with root package name */
    private int f5777b;

    /* renamed from: c, reason: collision with root package name */
    private int f5778c;

    /* renamed from: d, reason: collision with root package name */
    private float f5779d;
    private float e;

    /* renamed from: f, reason: collision with root package name */
    private TextPaint f5780f;

    /* renamed from: g, reason: collision with root package name */
    private TextPaint f5781g;

    public DownloadProgressView(Context context) {
        super(context);
        this.f5777b = -65536;
        this.f5778c = -65536;
        this.f5779d = 0.0f;
        this.e = 0.6f;
        a(null, 0);
    }

    private void a(AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.amap_map3d_DownloadProgressView, i3, 0);
        this.f5776a = obtainStyledAttributes.getString(R.styleable.amap_map3d_DownloadProgressView_amap_map3d_progressText);
        this.f5777b = obtainStyledAttributes.getColor(R.styleable.amap_map3d_DownloadProgressView_amap_map3d_progressTextColor, this.f5777b);
        this.f5779d = obtainStyledAttributes.getDimension(R.styleable.amap_map3d_DownloadProgressView_amap_map3d_progressTextSize, this.f5779d);
        this.f5778c = obtainStyledAttributes.getColor(R.styleable.amap_map3d_DownloadProgressView_amap_map3d_progressColor, this.f5778c);
        obtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.f5780f = textPaint;
        textPaint.setFlags(1);
        this.f5780f.setTextAlign(Paint.Align.RIGHT);
        TextPaint textPaint2 = new TextPaint();
        this.f5781g = textPaint2;
        textPaint2.setStyle(Paint.Style.FILL);
        this.f5780f.setTextSize(this.f5779d);
        this.f5780f.setColor(this.f5777b);
        this.f5781g.setColor(this.f5778c);
        this.f5780f.measureText(this.f5776a);
        float f2 = this.f5780f.getFontMetrics().bottom;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingTop) - paddingBottom;
        String str = String.valueOf((int) (this.e * 100.0f)) + "%";
        canvas.drawRect(new Rect(0, (int) (height * 0.8f), (int) (width * this.e), height), this.f5781g);
        canvas.drawText(str, (int) (this.e * r3), (int) (r1 - 3.0d), this.f5780f);
    }

    public void setProgress(int i3) {
        if (i3 > 100 || i3 < 0) {
            return;
        }
        this.e = i3 / 100.0f;
        invalidate();
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5777b = -65536;
        this.f5778c = -65536;
        this.f5779d = 0.0f;
        this.e = 0.6f;
        a(attributeSet, 0);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f5777b = -65536;
        this.f5778c = -65536;
        this.f5779d = 0.0f;
        this.e = 0.6f;
        a(attributeSet, i3);
    }
}
