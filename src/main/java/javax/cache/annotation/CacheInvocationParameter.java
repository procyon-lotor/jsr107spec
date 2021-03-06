/**
 * Copyright 2011-2016 Terracotta, Inc.
 * Copyright 2011-2016 Oracle America Incorporated
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package javax.cache.annotation;

import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * A parameter to an intercepted method invocation. Contains the parameter value
 * as well static type and annotation information about the parameter.
 *
 * @author Eric Dalquist
 */
public interface CacheInvocationParameter {

    /**
     * The parameter type as declared on the method.
     */
    Class<?> getRawType();

    /**
     * @return The parameter value
     */
    Object getValue();

    /**
     * @return An immutable Set of all Annotations on this method parameter, never
     * null.
     */
    Set<Annotation> getAnnotations();

    /**
     * The index of the parameter in the original parameter array as returned by
     * {@link CacheInvocationContext#getAllParameters()}
     *
     * @return The index of the parameter in the original parameter array.
     */
    int getParameterPosition();
}
