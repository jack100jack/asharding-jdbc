package com.lyz.sharding.algorithm;
 import java.util.Collection;  
import java.util.LinkedHashSet;  
  
import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;  
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;  
import com.google.common.collect.Range;  
  
/** 
 * ��Ϊt_studentʵ�ʱ���ÿ������ֻ��2�������� %2 
 * @author iuyazhuang
 * 
 */  
public class StudentSingleKeyTableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Integer>{  
  
    /** 
     * sql �� = ����ʱ��table��ӳ�� 
     */  
    public String doEqualSharding(Collection<String> tableNames, ShardingValue<Integer> shardingValue) {  
        for (String each : tableNames) {  
            if (each.endsWith("0".concat(String.valueOf(shardingValue.getValue() % 2)))) {  
                return each;  
            }  
        }  
        throw new IllegalArgumentException();  
    }  
  
    /** 
     * sql �� in ����ʱ��table��ӳ�� 
     */  
    public Collection<String> doInSharding(Collection<String> tableNames, ShardingValue<Integer> shardingValue) {  
        Collection<String> result = new LinkedHashSet<String>(tableNames.size());  
        for (Integer value : shardingValue.getValues()) {  
            for (String tableName : tableNames) {  
                if (tableName.endsWith("0".concat(String.valueOf(value % 2)))) {  
                    result.add(tableName);  
                }  
            }  
        }  
        return result;  
    }  
  
    /** 
     * sql �� between ����ʱ��table��ӳ�� 
     */  
    public Collection<String> doBetweenSharding(Collection<String> tableNames,  
            ShardingValue<Integer> shardingValue) {  
        Collection<String> result = new LinkedHashSet<String>(tableNames.size());  
        Range<Integer> range = (Range<Integer>) shardingValue.getValueRange();  
        for (Integer i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {  
            for (String each : tableNames) {  
                if (each.endsWith("0".concat(String.valueOf(i % 2)))) {  
                    result.add(each);  
                }  
            }  
        }  
        return result;  
    }  
  
}  
