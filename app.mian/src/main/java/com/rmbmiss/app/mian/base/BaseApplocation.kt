package com.rmbmiss.app.mian.base

import com.blankj.utilcode.util.Utils
import com.lzy.okgo.OkGo
import com.lzy.okgo.cache.CacheEntity
import com.lzy.okgo.cache.CacheMode
import com.lzy.okgo.https.HttpsUtils
import com.lzy.okgo.interceptor.HttpLoggingInterceptor
import com.lzy.okgo.model.HttpHeaders
import com.lzy.okgo.model.HttpParams
import com.rmbmiss.lib.style.StyleManager
import com.rmbmiss.lib.utils.apptools.AppManagerUtils
import com.rmbmiss.lib.utils.errortools.ErrorStringTools
import com.rmbmiss.lib.utils.lnstancetools.NoClassNullExt
import com.rmbmiss.lib.utils.pathtools.DirPathTools
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import java.util.logging.Level

/**
 * ================================================
 * 项目名称：YouYaXianZi
 * 类 描 述：   
 * 创 建 人：IMissYou
 * 创建时间：2017/5/26 9:29
 * 修 改 人：IMissYou
 * 修改时间：2017/5/26 9:29
 * 修改备注：   
 * 版    本：Vs.1.0.0
 * 修订版本：Vs.1.0.2
 * ================================================
 */
class BaseApplocation: StyleManager() {

    /**
     * 次级超类默认构造函数（相当于静态函数）,当列模式。
     */
    companion object{
        //自定义委托函数，确保变量值初始化一次。
        private var baseContent : BaseApplocation by NoClassNullExt.noNullClassObject<BaseApplocation>()
        // 获取对象
        fun getInstance(): BaseApplocation {
            return baseContent
        }
    }

    override fun onCreate() {
        super.onCreate()
        baseContent = this
        //初始化上下文
        BaseApplocation.baseContent = this
        //初始化工具集合
        Utils.init(this)
        //初始化网络工具
        addBuilder(addHeaders(),addParams())
        //抛出异常是否显示原因
        ErrorStringTools.showBool = true
    }

    /**
     * 配置请求头部信息
     */
    private fun addHeaders(): HttpHeaders {
        //---------这里给出的是示例代码,告诉你可以这么传,实际使用的时候,根据需要传,不需要就不传-------------//
        val headers = HttpHeaders()
        //headers.put("commonHeaderKey1", "commonHeaderValue1")    //header不支持中文，不允许有特殊字符
        //headers.put("commonHeaderKey2", "commonHeaderValue2")
        return headers
        //----------------------------------------------------------------------------------------//
    }

    /**
     * 配置公共传参
     */
    private fun addParams(): HttpParams {
        val params = HttpParams()
        //params.put("commonParamsKey1", "commonParamsValue1")     //param支持中文,直接传,不要自己编码
        params.put("accessorType", "Android")
        return params
    }

    /**
     * 配置请求参数验证
     */
    private fun addBuilder(headers: HttpHeaders, params: HttpParams){
        val builder = OkHttpClient.Builder()

        //log日志设置
        val loggingInterceptor = HttpLoggingInterceptor("SuperGodParks")
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY)   //log打印级别，决定了log显示的详细程度
        loggingInterceptor.setColorLevel(Level.INFO)    //log颜色级别，决定了log在控制台显示的颜色
        builder.addInterceptor(loggingInterceptor)
        //builder.addInterceptor(new ChuckInterceptor(this));    //第三方的开源库，使用通知显示当前请求的log

        //超时时间设置，默认60秒
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)      //全局的读取超时时间
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)     //全局的写入超时时间
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS)   //全局的连接超时时间

        //自动管理cookie（或者叫session的保持），以下几种任选其一就行
        //builder.cookieJar(new CookieJarImpl(new SPCookieStore(this)));            //使用sp保持cookie，如果cookie不过期，则一直有效
        //builder.cookieJar(CookieJarImpl(DBCookieStore(this)))              //使用数据库保持cookie，如果cookie不过期，则一直有效
        //builder.cookieJar(new CookieJarImpl(new MemoryCookieStore()));            //使用内存保持cookie，app退出后，cookie消失

        //https相关设置，以下几种方案根据需要自己设置
        //方法一：信任所有证书,不安全有风险
        val sslParams1 = HttpsUtils.getSslSocketFactory()
        //方法二：自定义信任规则，校验服务端证书
        //val sslParams2 = HttpsUtils.getSslSocketFactory(SafeTrustManager())
        //方法三：使用预埋证书，校验服务端证书（自签名证书）
        //HttpsUtils.SSLParams sslParams3 = HttpsUtils.getSslSocketFactory(getAssets().open("srca.cer"));
        //方法四：使用bks证书和密码管理客户端证书（双向认证），使用预埋证书，校验服务端证书（自签名证书）
        //HttpsUtils.SSLParams sslParams4 = HttpsUtils.getSslSocketFactory(getAssets().open("xxx.bks"), "123456", getAssets().open("yyy.cer"));

        builder.sslSocketFactory(sslParams1.sSLSocketFactory, sslParams1.trustManager)
        //配置https的域名匹配规则，详细看demo的初始化介绍，不需要就不要加入，使用不当会导致https握手失败
        //builder.hostnameVerifier(SafeHostnameVerifier())

        // 其他统一的配置
        // 详细说明看GitHub文档：https://github.com/jeasonlzy/
        OkGo.getInstance().init(this)                           //必须调用初始化
                .setOkHttpClient(builder.build())               //设置OkHttpClient
                .setCacheMode(CacheMode.NO_CACHE)               //全局统一缓存模式，默认不使用缓存，可以不传
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)   //全局统一缓存时间，默认永不过期，可以不传
                .setRetryCount(1)                               //全局统一超时重连次数，默认为三次，那么最差的情况会请求4次(一次原始请求，三次重连请求)，不需要可以设置为0
                .addCommonHeaders(headers)                      //全局公共头
                .addCommonParams(params)                       //全局公共参数
    }
}