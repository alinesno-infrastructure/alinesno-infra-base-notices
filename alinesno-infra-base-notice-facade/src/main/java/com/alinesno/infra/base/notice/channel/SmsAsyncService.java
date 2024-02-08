package com.alinesno.infra.base.notice.channel;

import com.alinesno.infra.base.notice.response.SmsNoticeResponse;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 短信服务接口扩展了异步发送短信的方法。
 */
public interface SmsAsyncService {

    /**
     * 异步发送固定模板的短信。
     * <p>
     * 此方法使用配置文件中预设的短信模板进行短信发送。
     * 该方法指定的模板变量只能存在一个（配置文件中）。
     *
     * @param phone 接收短信的手机号码
     * @param message 要发送的文本消息内容
     * @param callBack 发送结果的回调函数
     */
    void sendMessageAsync(String phone, String message, CallBack callBack);

    /**
     * 异步发送自定义模板的短信。
     * <p>
     * 该方法与同步发送自定义模板短信的方法使用一致，区别在于末尾接收一个callBack回调参数用于接收短信的发送结果。
     * 如果不关注发送结果，可以使用重载方法。
     *
     * @param phone 接收短信的手机号码
     * @param templateId 短信模板的ID
     * @param messages 包含模板参数的键值对映射
     * @param callBack 发送结果的回调函数
     */
    void sendMessageAsync(String phone, String templateId, LinkedHashMap<String, String> messages, CallBack callBack);

    /**
     * 异步群发固定模板的短信。
     * <p>
     * 此方法用于向一组电话号码批量发送短信，使用的是配置文件中预设的短信模板。
     * 需要注意的是，一次发送的电话号码数量不宜过多，建议不超过1000个，
     * 以避免影响性能或者超出某些服务商的限制。
     * 对于大量的短信发送需求，推荐使用异步群发或分批多次发送的方式。
     *
     * @param phones 接收短信的手机号码列表
     * @param message 要发送的文本消息内容
     * @param callBack 发送结果的回调函数
     */
    void massTextingAsync(List<String> phones, String message, CallBack callBack);

    /**
     * 异步使用自定义模板群发短信。
     * <p>
     * 类似于单条自定义模板短信，不同的是此方法适用于群发短信，可以向多个手机号码发送相同的内容。
     *
     * @param phones 接收短信的手机号码列表
     * @param templateId 短信模板的ID
     * @param messages 包含模板参数的键值对映射
     * @param callBack 发送结果的回调函数
     */
    void massTextingAsync(List<String> phones, String templateId, LinkedHashMap<String, String> messages, CallBack callBack);

    /**
     * 异步发送短信的回调接口。
     */
    interface CallBack {
        /**
         * 处理短信发送的结果。
         *
         * @param response 短信发送的响应对象
         */
        void onResult(SmsNoticeResponse response);
    }
}