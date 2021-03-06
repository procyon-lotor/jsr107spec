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

package javax.cache.event;

import java.util.EventListener;

/**
 * A tagging interface for cache entry listeners.
 * <p>
 * Sub-interfaces exist for the various cache events allowing a listener to be
 * created that implements only those listeners it is interested in.
 * <p>
 * Listeners should be implemented with care. In particular it is important to
 * consider their impact on performance and latency.
 * <p>
 * Listeners:
 * <ul>
 * <li>are fired after the entry is mutated in the cache</li>
 * <li>if synchronous are fired, for a given key, in the order that events
 * occur</li>
 * <li>block the calling thread until the listener returns,
 * where the listener was registered as synchronous</li>
 * <li>that are asynchronous iterate through multiple events with an undefined
 * ordering, except that events on the same key are in the order that the
 * events occur.</li>
 * </ul>
 * Listeners follow the observer pattern. An exception thrown by a
 * listener does not cause the cache operation to fail.
 * <p>
 * Listeners can only throw {@link CacheEntryListenerException}. Caching
 * implementations must catch any other {@link Exception} from a listener, then
 * wrap and rethrow it as a {@link CacheEntryListenerException}.
 * <p>
 * A listener that mutates a cache on the CacheManager may cause a deadlock.
 * Detection and response to deadlocks is implementation specific.
 *
 * @param <K> the type of key
 * @param <V> the type of value
 * @author Yannis Cosmadopoulos
 * @author Greg Luck
 * @see CacheEntryCreatedListener
 * @see CacheEntryUpdatedListener
 * @see CacheEntryRemovedListener
 * @see CacheEntryExpiredListener
 * @see EventType
 * @since 1.0
 */
public interface CacheEntryListener<K, V> extends EventListener {

}
