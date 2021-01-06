package com.github.edgar615.shaddingsphere;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserIdHintShardingAlgorithm implements HintShardingAlgorithm<String> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<String> shardingValue) {
        List<String> shardingResult = new ArrayList<>();
        for (String targetName : availableTargetNames) {
            for (String value : shardingValue.getValues()) {
                if (targetName.equals(value)) {
                    shardingResult.add(targetName);
                }
            }
        }
        return shardingResult;
    }
}
