/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

'use strict';


var angularVersion='1.3.0-beta.16';

require.config({

  baseUrl: "js",
  // FIXME only for development purpose!!
  // retrieve the version and if end with -SNAPSHOT do it only in this case
  urlArgs: "_timestamp=" +  (new Date()).getTime(),
  paths: {
    'jquery': 'jquery-1.11.0',
    'angular': 'angular-'+angularVersion,
    'angular-route': 'angular-route-'+angularVersion,
    'angular-resource': 'angular-resource-'+angularVersion,
    'bootstrap' : 'bootstrap.3.2.0.min',
    'controllers': 'app/controllers/controllers',
    'services': 'app/services/services',
    'sirona': 'sirona'
  },

  shim: {
    'angular': ['jquery'],
    'angular-route': ['angular']
  },

  deps: ['sirona']

});