/**
 * Copyright 2016 benjobs
 * <p>
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


package com.jredrain.job;

import com.alibaba.fastjson.JSON;
import com.jredrain.base.utils.CommonUtils;
import com.jredrain.domain.Worker;
import com.jredrain.service.WorkerService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import com.jredrain.base.job.Action;
import com.jredrain.base.job.RedRain;
import com.jredrain.base.job.Request;
import com.jredrain.base.job.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * agent CronJobCaller
 *
 * @author  <a href="mailto:benjobs@qq.com">B e n</a>
 * @version 1.0
 * @date 2016-03-27
 */

@Component
public class RedRainCaller {

    @Autowired
    private WorkerService workerService;

    public Response call(Worker worker,Request request) throws Exception {

        //代理...
        if (worker.getProxy() == RedRain.ConnType.PROXY.getType()) {
            Map<String,String> proxyParams = new HashMap<String, String>(0);
            proxyParams.put("proxyHost",request.getHostName());
            proxyParams.put("proxyPort",request.getPort()+"");
            proxyParams.put("proxyAction",request.getAction().name());
            proxyParams.put("proxyPassword",request.getPassword());
            if (CommonUtils.notEmpty(request.getParams())) {
                proxyParams.put("proxyParams", JSON.toJSONString(request.getParams()));
            }

            Worker proxyWorker = workerService.getWorker(worker.getProxyWorker());
            request.setHostName(proxyWorker.getIp());
            request.setPort(proxyWorker.getPort());
            request.setAction(Action.PROXY);
            request.setPassword(proxyWorker.getPassword());
            request.setParams(proxyParams);
        }

        TTransport transport = null;
        /**
         * ping的超时设置为5毫秒,其他默认
         */
        if (request.getAction().equals(Action.PING)) {
            transport = new TSocket(request.getHostName(),request.getPort(),1000*5);
        }else {
            transport = new TSocket(request.getHostName(),request.getPort());
        }
        TProtocol protocol = new TBinaryProtocol(transport);
        RedRain.Client client = new RedRain.Client(protocol);
        transport.open();

        Response response = null;
        for(Method method:client.getClass().getMethods()){
            if (method.getName().equalsIgnoreCase(request.getAction().name())) {
                response = (Response) method.invoke(client, request);
                break;
            }
        }

       transport.flush();
       transport.close();
       return response;
   }

}
