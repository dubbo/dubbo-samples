/*
 *
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package org.apache.dubbo.samples.service.greeting;

import org.apache.dubbo.samples.api.GreetingService;
import org.apache.dubbo.samples.api.HelloService;

import java.util.Random;

public class GreetingServiceImpl implements GreetingService {

    private HelloService helloService;

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String greeting(String message) {
        try {
            Thread.sleep(new Random(System.currentTimeMillis()).nextInt(1000));
        } catch (InterruptedException e) {
            // no op
        }
        return "greeting, " + helloService.hello(message);
    }
}
