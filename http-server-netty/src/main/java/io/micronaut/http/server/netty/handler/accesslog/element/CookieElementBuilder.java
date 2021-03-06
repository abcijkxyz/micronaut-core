/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.http.server.netty.handler.accesslog.element;

/**
 * Builder for CookieElement and CookiesElement.
 *
 * @author croudet
 * @since 2.0
 */
public final class CookieElementBuilder implements LogElementBuilder {

    @Override
    public LogElement build(String token, String param) {
        if (CookieElement.REQUEST_COOKIE.equals(token)) {
            return param == null ? CookiesElement.forRequest() : new CookieElement(true, param);
        } else if (CookieElement.RESPONSE_COOKIE.equals(token)) {
            return param == null ? CookiesElement.forResponse() : new CookieElement(false, param);
        }
        return null;
    }

}
