/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shenyu.plugin.base.utils;

import org.apache.shenyu.common.dto.ConditionData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.mock.web.server.MockServerWebExchange;
import org.springframework.web.server.ServerWebExchange;

import java.util.ArrayList;
import java.util.List;

/**
 * The MatchStrategyFactory test.
 */
@RunWith(MockitoJUnitRunner.class)
public final class MatchStrategyUtilsTest {

    private ServerWebExchange exchange;

    private List<ConditionData> conditionDatas;

    @Before
    public void setUp() {
        this.conditionDatas = new ArrayList<>();
        ConditionData conditionData = new ConditionData();
        conditionData.setOperator("match");
        conditionData.setParamName("/");
        conditionData.setParamType("uri");
        conditionData.setParamValue("/http/**");
        conditionDatas.add(conditionData);
        this.exchange = MockServerWebExchange.from(MockServerHttpRequest.get("/http/SOUL")
                .build());
    }

    /**
     * The match tests.
     */
    @Test
    public void matchTest() {
        Assert.assertTrue(MatchStrategyUtils.match(0, conditionDatas, exchange));
    }
}
