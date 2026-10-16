package com.example.test.ui.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.z1;
import com.example.network.bean.MemberFriendBean;
import com.example.test.R$id;
import com.example.test.presenter.main.l0;
import com.example.test.ui.testui.TRingFamilyActivity;
import com.example.test.ui.testui.TRingFamilySportsActivity;
import com.example.test.ui.testui.w;

/* loaded from: classes.dex */
public class FamilyFriendRecyclerView extends RecyclerView {

    /* renamed from: l1, reason: collision with root package name */
    public final Scroller f8414l1;

    /* renamed from: m1, reason: collision with root package name */
    public final VelocityTracker f8415m1;

    /* renamed from: n1, reason: collision with root package name */
    public int f8416n1;

    /* renamed from: o1, reason: collision with root package name */
    public LinearLayout f8417o1;

    /* renamed from: p1, reason: collision with root package name */
    public int f8418p1;

    /* renamed from: q1, reason: collision with root package name */
    public Button f8419q1;

    /* renamed from: r1, reason: collision with root package name */
    public int f8420r1;

    /* renamed from: s1, reason: collision with root package name */
    public int f8421s1;

    /* renamed from: t1, reason: collision with root package name */
    public int f8422t1;

    /* renamed from: u1, reason: collision with root package name */
    public boolean f8423u1;

    /* renamed from: v1, reason: collision with root package name */
    public boolean f8424v1;

    /* renamed from: w1, reason: collision with root package name */
    public u6.i f8425w1;

    /* renamed from: x1, reason: collision with root package name */
    public boolean f8426x1;

    public FamilyFriendRecyclerView(Context context) {
        this(context, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void V(int i3) {
        this.f8424v1 = i3 == 1;
    }

    @Override // android.view.View
    public final void computeScroll() {
        LinearLayout linearLayout;
        Scroller scroller = this.f8414l1;
        if (scroller.computeScrollOffset() && (linearLayout = this.f8417o1) != null) {
            linearLayout.scrollTo(scroller.getCurrX(), scroller.getCurrY());
            invalidate();
        } else if (this.f8426x1) {
            this.f8426x1 = false;
            if (this.f8416n1 == 1) {
                this.f8416n1 = 0;
            }
            if (this.f8416n1 == 2) {
                this.f8416n1 = 3;
            }
        }
        super.computeScroll();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f8415m1.recycle();
        super.onDetachedFromWindow();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i3;
        u6.i iVar;
        LinearLayout linearLayout;
        VelocityTracker velocityTracker = this.f8415m1;
        velocityTracker.addMovement(motionEvent);
        int x10 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        Scroller scroller = this.f8414l1;
        if (action == 0) {
            int i10 = this.f8416n1;
            if (i10 == 0) {
                View A = A(x10, y4);
                if (A != null) {
                    z1 K = K(A);
                    if (K instanceof u6.h) {
                        u6.h hVar = (u6.h) K;
                        this.f8417o1 = hVar.e;
                        this.f8418p1 = hVar.getAdapterPosition();
                        Button button = (Button) this.f8417o1.findViewById(R$id.item_delete);
                        this.f8419q1 = button;
                        this.f8420r1 = button.getWidth();
                        this.f8419q1.setOnClickListener(new androidx.appcompat.app.c(this, 3));
                    }
                }
            } else if (i10 == 3) {
                scroller.startScroll(this.f8417o1.getScrollX(), 0, -this.f8420r1, 0);
                invalidate();
                this.f8416n1 = 0;
            }
            return false;
        }
        if (action != 1) {
            if (action == 2 && (linearLayout = this.f8417o1) != null) {
                int i11 = this.f8421s1 - x10;
                int i12 = this.f8422t1 - y4;
                int scrollX = linearLayout.getScrollX();
                if (Math.abs(i11) > Math.abs(i12)) {
                    this.f8423u1 = true;
                    int i13 = scrollX + i11;
                    if (i13 <= 0) {
                        this.f8417o1.scrollTo(0, 0);
                        return true;
                    }
                    int i14 = this.f8420r1;
                    if (i13 >= i14) {
                        this.f8417o1.scrollTo(i14, 0);
                        return true;
                    }
                    this.f8417o1.scrollBy(i11, 0);
                }
            }
        } else if (this.f8417o1 != null) {
            if (!this.f8424v1 && !this.f8423u1 && (iVar = this.f8425w1) != null) {
                int i15 = this.f8418p1;
                TRingFamilyActivity tRingFamilyActivity = ((w) iVar).f8322a;
                Object obj = tRingFamilyActivity.E.get(i15);
                if (obj instanceof MemberFriendBean) {
                    l0 l0Var = (l0) tRingFamilyActivity.I0();
                    kotlin.jvm.internal.e.c(l0Var);
                    Integer friendId = ((MemberFriendBean) obj).getFriendId();
                    kotlin.jvm.internal.e.e(friendId, "getFriendId(...)");
                    int intValue = friendId.intValue();
                    TRingFamilyActivity tRingFamilyActivity2 = (TRingFamilyActivity) ((g7.n) l0Var.f7255a);
                    tRingFamilyActivity2.getClass();
                    Intent intent = new Intent(tRingFamilyActivity2, (Class<?>) TRingFamilySportsActivity.class);
                    intent.putExtra("friendId", intValue);
                    tRingFamilyActivity2.startActivity(intent);
                }
            }
            this.f8423u1 = false;
            velocityTracker.computeCurrentVelocity(1000);
            float xVelocity = velocityTracker.getXVelocity();
            float yVelocity = velocityTracker.getYVelocity();
            int scrollX2 = this.f8417o1.getScrollX();
            if (Math.abs(xVelocity) <= 100.0f || Math.abs(xVelocity) <= Math.abs(yVelocity)) {
                int i16 = this.f8420r1;
                int i17 = i16 / 2;
                if (scrollX2 >= i17) {
                    i3 = i16 - scrollX2;
                    this.f8416n1 = 2;
                } else {
                    if (scrollX2 < i17) {
                        i3 = -scrollX2;
                        this.f8416n1 = 1;
                    }
                    i3 = 0;
                }
                scroller.startScroll(scrollX2, 0, i3, 0);
                this.f8426x1 = true;
                invalidate();
                velocityTracker.clear();
            } else {
                if (xVelocity <= -100.0f) {
                    i3 = this.f8420r1 - scrollX2;
                    this.f8416n1 = 2;
                } else {
                    if (xVelocity > 100.0f) {
                        i3 = -scrollX2;
                        this.f8416n1 = 1;
                    }
                    i3 = 0;
                }
                scroller.startScroll(scrollX2, 0, i3, 0);
                this.f8426x1 = true;
                invalidate();
                velocityTracker.clear();
            }
        }
        this.f8421s1 = x10;
        this.f8422t1 = y4;
        return super.onTouchEvent(motionEvent);
    }

    public void setOnItemClickListener(u6.i iVar) {
        this.f8425w1 = iVar;
    }

    public FamilyFriendRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FamilyFriendRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f8416n1 = 0;
        this.f8414l1 = new Scroller(context, new LinearInterpolator());
        this.f8415m1 = VelocityTracker.obtain();
    }
}
