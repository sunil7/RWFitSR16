package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class z1 {
    static final int FLAG_ADAPTER_FULLUPDATE = 1024;
    static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
    static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
    static final int FLAG_BOUND = 1;
    static final int FLAG_IGNORE = 128;
    static final int FLAG_INVALID = 4;
    static final int FLAG_MOVED = 2048;
    static final int FLAG_NOT_RECYCLABLE = 16;
    static final int FLAG_REMOVED = 8;
    static final int FLAG_RETURNED_FROM_SCRAP = 32;
    static final int FLAG_TMP_DETACHED = 256;
    static final int FLAG_UPDATE = 2;
    private static final List<Object> FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
    static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
    public final View itemView;
    z0 mBindingAdapter;
    int mFlags;
    WeakReference<RecyclerView> mNestedRecyclerView;
    RecyclerView mOwnerRecyclerView;
    int mPosition = -1;
    int mOldPosition = -1;
    long mItemId = -1;
    int mItemViewType = -1;
    int mPreLayoutPosition = -1;
    z1 mShadowedHolder = null;
    z1 mShadowingHolder = null;
    List<Object> mPayloads = null;
    List<Object> mUnmodifiedPayloads = null;
    private int mIsRecyclableCount = 0;
    q1 mScrapContainer = null;
    boolean mInChangeScrap = false;
    private int mWasImportantForAccessibilityBeforeHidden = 0;
    int mPendingAccessibilityState = -1;

    public z1(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.itemView = view;
    }

    public void addChangePayload(Object obj) {
        if (obj == null) {
            addFlags(1024);
            return;
        }
        if ((1024 & this.mFlags) == 0) {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
            this.mPayloads.add(obj);
        }
    }

    public void addFlags(int i3) {
        this.mFlags = i3 | this.mFlags;
    }

    public void clearOldPosition() {
        this.mOldPosition = -1;
        this.mPreLayoutPosition = -1;
    }

    public void clearPayload() {
        List<Object> list = this.mPayloads;
        if (list != null) {
            list.clear();
        }
        this.mFlags &= -1025;
    }

    public void clearReturnedFromScrapFlag() {
        this.mFlags &= -33;
    }

    public void clearTmpDetachFlag() {
        this.mFlags &= -257;
    }

    public boolean doesTransientStatePreventRecycling() {
        if ((this.mFlags & 16) != 0) {
            return false;
        }
        View view = this.itemView;
        WeakHashMap weakHashMap = l1.z0.f15748a;
        return l1.h0.i(view);
    }

    public void flagRemovedAndOffsetPosition(int i3, int i10, boolean z5) {
        addFlags(8);
        offsetPosition(i10, z5);
        this.mPosition = i3;
    }

    public final int getAbsoluteAdapterPosition() {
        RecyclerView recyclerView = this.mOwnerRecyclerView;
        if (recyclerView == null) {
            return -1;
        }
        return recyclerView.I(this);
    }

    @Deprecated
    public final int getAdapterPosition() {
        return getBindingAdapterPosition();
    }

    public final z0 getBindingAdapter() {
        return this.mBindingAdapter;
    }

    public final int getBindingAdapterPosition() {
        RecyclerView recyclerView;
        z0 adapter;
        int I;
        if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (I = this.mOwnerRecyclerView.I(this)) == -1) {
            return -1;
        }
        return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, I);
    }

    public final long getItemId() {
        return this.mItemId;
    }

    public final int getItemViewType() {
        return this.mItemViewType;
    }

    public final int getLayoutPosition() {
        int i3 = this.mPreLayoutPosition;
        return i3 == -1 ? this.mPosition : i3;
    }

    public final int getOldPosition() {
        return this.mOldPosition;
    }

    @Deprecated
    public final int getPosition() {
        int i3 = this.mPreLayoutPosition;
        return i3 == -1 ? this.mPosition : i3;
    }

    public List<Object> getUnmodifiedPayloads() {
        if ((this.mFlags & 1024) != 0) {
            return FULLUPDATE_PAYLOADS;
        }
        List<Object> list = this.mPayloads;
        return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
    }

    public boolean hasAnyOfTheFlags(int i3) {
        return (i3 & this.mFlags) != 0;
    }

    public boolean isAdapterPositionUnknown() {
        return (this.mFlags & 512) != 0 || isInvalid();
    }

    public boolean isAttachedToTransitionOverlay() {
        return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
    }

    public boolean isBound() {
        return (this.mFlags & 1) != 0;
    }

    public boolean isInvalid() {
        return (this.mFlags & 4) != 0;
    }

    public final boolean isRecyclable() {
        if ((this.mFlags & 16) != 0) {
            return false;
        }
        View view = this.itemView;
        WeakHashMap weakHashMap = l1.z0.f15748a;
        return !l1.h0.i(view);
    }

    public boolean isRemoved() {
        return (this.mFlags & 8) != 0;
    }

    public boolean isScrap() {
        return this.mScrapContainer != null;
    }

    public boolean isTmpDetached() {
        return (this.mFlags & 256) != 0;
    }

    public boolean isUpdated() {
        return (this.mFlags & 2) != 0;
    }

    public boolean needsUpdate() {
        return (this.mFlags & 2) != 0;
    }

    public void offsetPosition(int i3, boolean z5) {
        if (this.mOldPosition == -1) {
            this.mOldPosition = this.mPosition;
        }
        if (this.mPreLayoutPosition == -1) {
            this.mPreLayoutPosition = this.mPosition;
        }
        if (z5) {
            this.mPreLayoutPosition += i3;
        }
        this.mPosition += i3;
        if (this.itemView.getLayoutParams() != null) {
            ((j1) this.itemView.getLayoutParams()).f2635c = true;
        }
    }

    public void onEnteredHiddenState(RecyclerView recyclerView) {
        int i3 = this.mPendingAccessibilityState;
        if (i3 != -1) {
            this.mWasImportantForAccessibilityBeforeHidden = i3;
        } else {
            View view = this.itemView;
            WeakHashMap weakHashMap = l1.z0.f15748a;
            this.mWasImportantForAccessibilityBeforeHidden = l1.h0.c(view);
        }
        if (recyclerView.O()) {
            this.mPendingAccessibilityState = 4;
            recyclerView.f2451c1.add(this);
        } else {
            View view2 = this.itemView;
            WeakHashMap weakHashMap2 = l1.z0.f15748a;
            l1.h0.s(view2, 4);
        }
    }

    public void onLeftHiddenState(RecyclerView recyclerView) {
        int i3 = this.mWasImportantForAccessibilityBeforeHidden;
        if (recyclerView.O()) {
            this.mPendingAccessibilityState = i3;
            recyclerView.f2451c1.add(this);
        } else {
            View view = this.itemView;
            WeakHashMap weakHashMap = l1.z0.f15748a;
            l1.h0.s(view, i3);
        }
        this.mWasImportantForAccessibilityBeforeHidden = 0;
    }

    public void resetInternal() {
        this.mFlags = 0;
        this.mPosition = -1;
        this.mOldPosition = -1;
        this.mItemId = -1L;
        this.mPreLayoutPosition = -1;
        this.mIsRecyclableCount = 0;
        this.mShadowedHolder = null;
        this.mShadowingHolder = null;
        clearPayload();
        this.mWasImportantForAccessibilityBeforeHidden = 0;
        this.mPendingAccessibilityState = -1;
        RecyclerView.i(this);
    }

    public void saveOldPosition() {
        if (this.mOldPosition == -1) {
            this.mOldPosition = this.mPosition;
        }
    }

    public void setFlags(int i3, int i10) {
        this.mFlags = (i3 & i10) | (this.mFlags & (~i10));
    }

    public final void setIsRecyclable(boolean z5) {
        int i3 = this.mIsRecyclableCount;
        int i10 = z5 ? i3 - 1 : i3 + 1;
        this.mIsRecyclableCount = i10;
        if (i10 < 0) {
            this.mIsRecyclableCount = 0;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            return;
        }
        if (!z5 && i10 == 1) {
            this.mFlags |= 16;
        } else if (z5 && i10 == 0) {
            this.mFlags &= -17;
        }
    }

    public void setScrapContainer(q1 q1Var, boolean z5) {
        this.mScrapContainer = q1Var;
        this.mInChangeScrap = z5;
    }

    public boolean shouldBeKeptAsChild() {
        return (this.mFlags & 16) != 0;
    }

    public boolean shouldIgnore() {
        return (this.mFlags & 128) != 0;
    }

    public void stopIgnoring() {
        this.mFlags &= -129;
    }

    public String toString() {
        StringBuilder u10 = com.google.android.gms.internal.mlkit_vision_barcode.l0.u(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), Const.STR_MART_JSON_BEGIN);
        u10.append(Integer.toHexString(hashCode()));
        u10.append(" position=");
        u10.append(this.mPosition);
        u10.append(" id=");
        u10.append(this.mItemId);
        u10.append(", oldPos=");
        u10.append(this.mOldPosition);
        u10.append(", pLpos:");
        u10.append(this.mPreLayoutPosition);
        StringBuilder sb2 = new StringBuilder(u10.toString());
        if (isScrap()) {
            sb2.append(" scrap ");
            sb2.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
        }
        if (isInvalid()) {
            sb2.append(" invalid");
        }
        if (!isBound()) {
            sb2.append(" unbound");
        }
        if (needsUpdate()) {
            sb2.append(" update");
        }
        if (isRemoved()) {
            sb2.append(" removed");
        }
        if (shouldIgnore()) {
            sb2.append(" ignored");
        }
        if (isTmpDetached()) {
            sb2.append(" tmpDetached");
        }
        if (!isRecyclable()) {
            sb2.append(" not recyclable(" + this.mIsRecyclableCount + ")");
        }
        if (isAdapterPositionUnknown()) {
            sb2.append(" undefined adapter position");
        }
        if (this.itemView.getParent() == null) {
            sb2.append(" no parent");
        }
        sb2.append("}");
        return sb2.toString();
    }

    public void unScrap() {
        this.mScrapContainer.j(this);
    }

    public boolean wasReturnedFromScrap() {
        return (this.mFlags & 32) != 0;
    }
}
