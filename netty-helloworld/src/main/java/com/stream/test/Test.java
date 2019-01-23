package com.stream.test;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        BusinessPo businessPo1 = new BusinessPo(10086, "生鲜业务");
        BusinessPo businessPo2 = new BusinessPo(10096, "生鲜业务1");
        BusinessPo businessPo3 = new BusinessPo(10185, "买菜业务");
        BusinessPo businessPo4 = new BusinessPo(10085, "采购业务");

        List<BusinessPo> businessPos = Lists.newArrayList(businessPo1, businessPo2, businessPo3, businessPo4);
        List<BusinessPo> mallBusinessPos = businessPos.stream().filter(po->po.getBusinessName().contains("生鲜")).collect(Collectors.toList());
        for (BusinessPo businessPo : mallBusinessPos) {
            System.out.println("[" + businessPo.getBusinessName() + "]");
        }
    }
}
