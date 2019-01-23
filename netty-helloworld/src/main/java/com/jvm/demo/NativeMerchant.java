package com.jvm.demo;

public class NativeMerchant extends Merchant {
    @Override
    public Double actionPrice(double price) {
        return 0.9 * price;
    }

    public static void main(String[] args) {
        Merchant merchant = new NativeMerchant();
        // price 必须定义成 Number 类型
        Number price = merchant.actionPrice(40);
        System.out.println(price);
    }
}
