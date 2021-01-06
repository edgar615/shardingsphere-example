package com.github.edgar615.shaddingsphere;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserIdTableHintShardingAlgorithm implements HintShardingAlgorithm<Integer> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<Integer> shardingValue) {
        List<String> shardingResult = new ArrayList<>();
        for (String targetName : availableTargetNames) {
            for (Integer value : shardingValue.getValues()) {
                shardingResult.add(targetName + value);
            }
        }
        return shardingResult;
    }
}
