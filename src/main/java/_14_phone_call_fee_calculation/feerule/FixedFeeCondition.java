package _14_phone_call_fee_calculation.feerule;

import _14_phone_call_fee_calculation.Call;
import _14_phone_call_fee_calculation.ratepolicy.DateTimeInterval;
import _14_phone_call_fee_calculation.ratepolicy.FeeCondition;

import java.util.Collections;
import java.util.List;

/**
 * 이 클래스는 개념적으로는 불필요한 클래스이며, List 임에도 항상 단 하나의 interval 인스턴스를 반환한다는 점이 마음에 걸리지만,
 * 개념적 무결성을 무너뜨리는 것보다는 약간의 부조화를 수용하는 편이 더 낫다.
 */
public class FixedFeeCondition implements FeeCondition {

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return Collections.singletonList(call.getInterval());
    }
}
