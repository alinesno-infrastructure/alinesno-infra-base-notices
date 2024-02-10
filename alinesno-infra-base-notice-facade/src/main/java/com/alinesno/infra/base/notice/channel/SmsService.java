package com.alinesno.infra.base.notice.channel;

import com.alinesno.infra.base.notice.response.SmsNoticeResponse;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 短信服务接口定义了发送短信的方法。
 */
public interface SmsService {

    /**
     * 发送固定消息模板的短信到指定的手机号码。
     * <p>
     * 此方法会使用配置文件中预设的短信模板来进行短信发送。
     * 若使用的短信服务商允许的话，可以在消息内容中包含多个参数，用'&'符号分隔。
     * 例如："1234" + "&" + "5" 会被解析成 "您的验证码为{1}在{2}分钟内有效" 的格式。
     *
     * @param phone 接收短信的手机号码
     * @param message 要发送的文本消息内容
     * @return 短信发送响应对象
     */
    SmsNoticeResponse sendMessage(String phone, String message , String configId);

    /**
     * 发送固定模板但含有多个模板参数的短信。
     * <p>
     * 根据用户的反馈，有时需要发送含有单个模板但具有多个参数的短信，
     * 因此提供了此方法以适应这种场景。
     * 如果模板中没有变量，可以将消息内容设置为null。
     *
     * @param phone 接收短信的手机号码
     * @param messages 包含模板参数的键值对映射
     * @return 短信发送响应对象
     */
    SmsNoticeResponse sendMessage(String phone, Map<String, String> messages , String configId);

    /**
     * 使用指定的模板ID发送短信。
     * <p>
     * 此方法允许使用特定的模板ID来发送短信，其中模板ID对应于预定义的短信模板。
     * 在消息内容映射中，可以有一个或多个变量，具体取决于模板的要求。
     * 模板变量的名称作为键，对应的值作为值。
     *
     * @param phone 接收短信的手机号码
     * @param templateId 短信模板的ID
     * @param messages 包含模板参数的键值对映射
     * @return 短信发送响应对象
     */
    SmsNoticeResponse sendMessage(String phone, String templateId, LinkedHashMap<String, String> messages);

    /**
     * 群发固定模板的短信。
     * <p>
     * 此方法用于向一组电话号码批量发送短信，使用的是配置文件中预设的短信模板。
     * 需要注意的是，一次发送的电话号码数量不宜过多，建议不超过1000个，
     * 以避免影响性能或者超出某些服务商的限制。
     * 对于大量的短信发送需求，推荐使用异步群发或分批多次发送的方式。
     *
     * @param phones 接收短信的手机号码列表
     * @param message 要发送的文本消息内容
     * @return 短信发送响应对象
     */
    SmsNoticeResponse massTexting(List<String> phones, String message);

    /**
     * 使用自定义模板群发短信。
     * <p>
     * 类似于单条自定义模板短信，不同的是此方法适用于群发短信，可以向多个手机号码发送相同的内容。
     *
     * @param phones 接收短信的手机号码列表
     * @param templateId 短信模板的ID
     * @param messages 包含模板参数的键值对映射
     * @return 短信发送响应对象
     */
    SmsNoticeResponse massTexting(List<String> phones, String templateId, LinkedHashMap<String, String> messages);

}