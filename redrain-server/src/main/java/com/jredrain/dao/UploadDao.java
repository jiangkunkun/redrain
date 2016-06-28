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


package com.jredrain.dao;

import com.jredrain.domain.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by benjobs on 15/10/18.
 */
@Repository
public class UploadDao extends BaseDao {

    public User uploadimg(MultipartFile file, Long userId) throws IOException {
        Session session = getSession();
        User loginUser =  get(User.class,userId);
        loginUser.setHeaderpic(Hibernate.getLobCreator(session).createBlob(file.getBytes()));
        session.save(loginUser);
        return loginUser;
    }

}
