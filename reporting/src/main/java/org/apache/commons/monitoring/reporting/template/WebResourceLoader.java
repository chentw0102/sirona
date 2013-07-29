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
package org.apache.commons.monitoring.reporting.template;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.Resource;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.InputStream;

public class WebResourceLoader extends ClasspathResourceLoader {
    @Override
    public void init(final ExtendedProperties configuration) {
        // no-op
    }

    @Override
    public InputStream getResourceStream(final String source) throws ResourceNotFoundException {
        try {
            return super.getResourceStream(source);
        } catch (final ResourceNotFoundException rnfe) {
            final InputStream is = Templates.getServletContext().getResourceAsStream(source);
            if (is == null) {
                throw rnfe;
            }
            return is;
        }
    }

    @Override
    public boolean isSourceModified(final Resource resource) {
        return false;
    }

    @Override
    public long getLastModified(final Resource resource) {
        return 0;
    }
}