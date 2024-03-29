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

package com.github.shoothzj.zdash.controller;

import com.github.shoothzj.zdash.module.pulsar.PutManagedLedgerTopicReq;
import com.github.shoothzj.zdash.service.ZkService;
import com.github.shoothzj.zdash.utils.EncodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/zookeeper")
public class ZnodePutController {

    @Autowired
    private ZkService zkService;

    @PostMapping("/put-managed-ledger-topic")
    public ResponseEntity<Void> getNodes(@RequestBody PutManagedLedgerTopicReq req) {
        log.info("put managed ledger topic req {}", req);
        try {
            byte[] data = EncodeUtil.encodePulsarManagedLedgerTopic(req.getManagedLedgerTopicReq());
            zkService.putZnodeContent(req.getPath(), data, false);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("put managed ledger topic fail. err: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
