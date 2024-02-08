package com.alinesno.infra.base.notice.channel;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 延时短信服务接口。
 */
public interface SmsDelayedService {

    /**
     * 使用固定模板发送延时短信。
     * <p>
     * 使用配置文件中定义的模板和变量发送延时短信，delayedTime为延迟时间，单位为毫秒。
     *
     * @param phone 接收短信的手机号码
     * @param message 要发送的文本消息内容
     * @param delayedTime 延迟时间，单位毫秒
     */
    void delayedMessage(String phone, String message, Long delayedTime);

    /**
     * 使用自定义模板发送延时短信。
     * <p>
     * 该方法使用方式与标准方法中的自定义模板发送方式一致，末尾添加了一个delayedTime延迟时间参数，单位为毫秒。
     *
     * @param phone 接收短信的手机号码
     * @param templateId 短信模板的ID
     * @param messages 包含模板参数的键值对映射
     * @param delayedTime 延迟时间，单位毫秒
     */
    void delayedMessage(String phone, String templateId, LinkedHashMap<String, String> messages, Long delayedTime);

    /**
     * 群发固定模板的延时短信。
     * <p>
     * 向一组电话号码批量发送延时短信，使用的是配置文件中预设的短信模板。
     *
     * @param phones 接收短信的手机号码列表
     * @param message 要发送的文本消息内容
     * @param delayedTime 延迟时间，单位毫秒
     */
    void delayMassTexting(List<String> phones, String message, Long delayedTime);

    /**
     * 群发自定义模板的延时短信。
     * <p>
     * 向多个手机号码发送相同内容的延时短信，使用的是自定义的短信模板。
     *
     * @param phones 接收短信的手机号码列表
     * @param templateId 短信模板的ID
     * @param messages 包含模板参数的键值对映射
     * @param delayedTime 延迟时间，单位毫秒
     */
    void delayMassTexting(List<String> phones, String templateId, LinkedHashMap<String, String> messages, Long delayedTime);
}