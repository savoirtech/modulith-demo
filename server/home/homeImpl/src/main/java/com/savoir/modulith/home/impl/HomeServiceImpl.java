/*
 * Copyright (c) 2012-2024 Savoir Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.savoir.modulith.home.impl;

import com.savoir.modulith.datastore.api.GameStore;
import com.savoir.modulith.home.api.HomeService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/")
public class HomeServiceImpl implements HomeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeServiceImpl.class);

    private GameStore gameStore;

    public HomeServiceImpl(GameStore gameStore) {
        this.gameStore = gameStore;
    }

    @Override
    @Path("/getActiveGamesCount")
    @Produces("application/json")
    @GET
    public int getActiveGamesCount() {
        LOGGER.info("getActiveGamesCount");
        return gameStore.getActiveGamesCount();
    }
}
