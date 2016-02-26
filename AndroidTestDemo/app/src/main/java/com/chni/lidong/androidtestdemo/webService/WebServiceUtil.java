package com.chni.lidong.androidtestdemo.webService;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @className WebServiceUtil 的工具类
 * Created by lidong on 2016/1/11.
 */
public class WebServiceUtil {
    /**
     * 获取数据
     * @param service_url
     * @param service_ns
     * @param methodName
     * @return   返回数据
     */
    public static SoapObject getData(String service_url, final String service_ns, final String methodName){
        /**
         * 创建HttpTransportSE 对象
         */
        final HttpTransportSE  ht = new HttpTransportSE(service_url);
        ht.debug = true;
        /**
         * 使用Soap1.1的协议创建EEnvelope
         */
        final SoapSerializationEnvelope  envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        /**
         *创建SoapObject对象
         */
        SoapObject soapObject = new SoapObject(service_ns,methodName);
        envelope.bodyOut =soapObject;
        /***
         * 设置与.NET提供的Web Service 保存更好的兼容
         */
        envelope.dotNet = true;
        FutureTask<SoapObject> task = new FutureTask<SoapObject>(new Callable<SoapObject>() {
            @Override
            public SoapObject call() throws Exception {
                //调用Web　Service
                ht.call(service_ns+methodName,envelope);
                if (envelope.getResponse()!=null){
                    //获取服务器返回的结果
                    SoapObject result = (SoapObject) envelope.bodyIn;
                    return result;
                }
                return null;
            }
        });
        new Thread(task).start();
        try {
            return  task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return  null;
    }

}
