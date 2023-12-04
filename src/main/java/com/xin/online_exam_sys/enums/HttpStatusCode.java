package com.xin.online_exam_sys.enums;

import lombok.Getter;

/**
 * @author : AstreLee
 * @date : 2023/12/4 - 16:47
 * @file : HttpStatusCode.java
 * @ide : IntelliJ IDEA
 */
@Getter
public enum HttpStatusCode {
    // http状态码枚举所有状态码枚举
    // 100 ~ 200
    CONTINUE(100, "Continue", "请继续发送请求的剩余部分"),
    SWITCHING_PROTOCOLS(101, "Switching Protocols", "协议切换"),
    PROCESSING(102, "Processing", "请求将继续执行"),
    CHECKPOINT(103, "Checkpoint", "可以预加载"),

    // 200 ~ 300
    // [GET]，服务器成功返回用户请求的数据(select)，请求成功
    OK(200, "OK", "请求成功处理"),
    // [POST PUT PATCH]，新建或修改数据成功
    CREATED(201, "Created", "请求成功处理"),
    // 表示一个请求进入了后台排队-异步任务
    ACCEPTED(202, "Accepted", "请求接受，等待执行"),
    NON_AUTHORITATIVE_INFORMATION(203, "Non-Authoritative Information", "请求已经成功处理，但是信息不是原始的"),
    // [DELETE]，用户删除成功
    NO_CONTENT(204, "No Content", "请求成功处理"),

    // 300 ~ 400
    MOVED_PERMANENTLY(301, "Moved Permanently", "请求的资源已经永久转移"),
    FOUND(302, "Found", "请重新发送请求"),
    SEE_OTHER(303, "See Other", "请以Get方式请求另一个URI"),
    NOT_MODIFIED(304, "Not Modified", "资源未改变"),

    // 400 ~ 500
    // [POST PUt PATCH]，用户发的数据有误，服务器没有新建或修改数据
    BAD_REQUEST(400, "Bad Request", "请求错误，请修正请求"),
    // 用户无权限：用户名或者密码错误
    UNAUTHORIZED(401, "Unauthorized", "没有被授权或者授权已经失效"),
    // 和401状态码相对，表示得到授权但是访问被禁止
    FORBIDDEN(403, "Forbidden", "请求被理解，但是拒绝执行"),
    // 用户发出的请求是不存在的资源
    NOT_FOUND(404, "Not Found", "资源未找到"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed", "请求方法不允许被执行"),
    NOT_ACCEPTABLE(406, "Not Acceptable", "请求的资源不满足请求者要求"),
    PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required", "请通过代理进行身份验证"),
    REQUEST_TIMEOUT(408, "Request Timeout", "请求超时"),

    // 500
    // 服务器内部异常
    INTERNAL_SERVER_ERROR(500, "Internal Server Error", "服务器内部错误"),
    // 服务器资源有限，暂时无法响应
    SERVICE_UNAVAILABLE(503, "Service Unavailable", "服务器维护或者过载，拒绝服务"),
    // 网关超时
    GATEWAY_TIMEOUT(504, "Gateway Timeout", "上游服务器超时"),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version not supported", "不支持的HTTP版本");


    //构造函数
    HttpStatusCode(int code, String enMessage, String zhMessage) {

    }

    private Integer code;
    private String enMsg;
    private String cnMsg;
}
