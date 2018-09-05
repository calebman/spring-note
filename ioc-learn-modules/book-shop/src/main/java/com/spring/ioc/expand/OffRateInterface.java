package com.spring.ioc.expand;

import com.spring.ioc.book.BookInterface;

/**
 * @author calebman
 * @date 2018/9/5
 * @description
 */
public interface OffRateInterface extends BookInterface{
    // 获取书的折扣率
    Double getOffRate();

    void setOffRate(Double offRate);
}
