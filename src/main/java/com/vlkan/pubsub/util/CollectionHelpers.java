/*
 * Copyright 2019-2020 Volkan Yazıcı
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permits and
 * limitations under the License.
 */

package com.vlkan.pubsub.util;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CollectionHelpers {;

    public static String limitedFormat(Collection<?> items, int maxVisibleItemCount) {
        int itemCount = items.size();
        Collection<?> visibleItems = items;
        if (itemCount > maxVisibleItemCount) {
            visibleItems = Stream
                    .concat(items.stream().limit(maxVisibleItemCount),
                            Stream.of(String.format("<%d more>", itemCount - maxVisibleItemCount)))
                    .collect(Collectors.toList());
        }
        return String.valueOf(visibleItems);
    }

}
