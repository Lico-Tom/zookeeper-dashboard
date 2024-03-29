/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.github.shoothzj.zdash.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class DecodeUtilTest {

    @Test
    public void testDecodePulsarManagedLedgerTopic() throws Exception {
        byte[] data = HexUtil.hexToByteArray("0a0508da012000");
        String content = DecodeUtil.decodeData(data, "Pulsar", "ManagedLedgerTopic");
        log.info("content is\n{}", content);
    }

    @Test
    public void testDecodePulsarManagedLedgerSubscription() throws Exception {
        byte[] data = HexUtil.hexToByteArray("08db0110da0118eeeeeeeeeeeeeeeeee0130e09cdd-3bd30");
        String content = DecodeUtil.decodeData(data, "Pulsar", "ManagedLedgerSubscription");
        log.info("content is\n{}", content);
    }


}
