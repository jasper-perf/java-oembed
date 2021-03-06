/*
 * Copyright 2014 michael-simons.eu.
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
package ac.simons.oembed;

import java.net.URI;
import java.util.Optional;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The default implementation of an oembed provider. Creates plain GET requests.
 *
 * @author Michael J. Simons, 2014-12-31
 */
public class DefaultRequestProvider implements RequestProvider {

    public static final Logger logger = LoggerFactory.getLogger(DefaultRequestProvider.class.getPackage().getName());
   
    @Override
    public HttpGet createRequestFor(String userAgent, Optional<String> applicationName, URI uri) {		
	logger.debug("Creating HttpGet for url '{}'", uri.toString());

	final HttpGet request = new HttpGet(uri);
	request.setHeader("User-Agent", String.format("%s%s", userAgent, applicationName.map(s -> "; " + s).orElse("")));
	return request;
    }  
}
