package x2;

import b2.n;

/* loaded from: classes.dex */
public final class e extends n {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f19743d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(b2.i iVar, int i3) {
        super(iVar);
        this.f19743d = i3;
    }

    @Override // b2.n
    public final String b() {
        switch (this.f19743d) {
            case 0:
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            case 1:
                return "DELETE from WorkProgress where work_spec_id=?";
            case 2:
                return "DELETE FROM WorkProgress";
            case 3:
                return "DELETE FROM workspec WHERE id=?";
            case 4:
                return "UPDATE workspec SET output=? WHERE id=?";
            case 5:
                return "UPDATE workspec SET period_start_time=? WHERE id=?";
            case 6:
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            case 7:
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            case 8:
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            default:
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }
}
