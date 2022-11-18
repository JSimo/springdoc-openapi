/*
 *
 *  *
 *  *  *
 *  *  *  * Copyright 2019-2022 the original author or authors.
 *  *  *  *
 *  *  *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  *  *  * you may not use this file except in compliance with the License.
 *  *  *  * You may obtain a copy of the License at
 *  *  *  *
 *  *  *  *      https://www.apache.org/licenses/LICENSE-2.0
 *  *  *  *
 *  *  *  * Unless required by applicable law or agreed to in writing, software
 *  *  *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  *  *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  *  * See the License for the specific language governing permissions and
 *  *  *  * limitations under the License.
 *  *  *
 *  *
 *
 */

package test.org.springdoc.api.v30.app224;

import org.apache.commons.lang3.ArrayUtils;
import org.springdoc.core.customizers.RouterOperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/overloadedPath")
@RestController("overloadedPathTest")
public class HelloController {
    private final static String XHEADER = "X-Custom-Header";

    // Add custom header in swagger.
    @Bean
    public RouterOperationCustomizer customize() {
        return (operation, handlerMethod) -> {
            String[] headers = operation.getHeaders();
            operation.setHeaders(ArrayUtils.add(headers, XHEADER));
            return operation;
        };
    }

    @GetMapping(params = {"first"})
    public void getNames(
            @RequestParam final List<String> first
    ) {
    }

    @GetMapping(params = {"second"})
    public void getSecond(@RequestParam final List<String> second) {
    }

    @GetMapping(params = {"third"})
    public void getThird(@RequestParam final List<String> third) {
    }
}