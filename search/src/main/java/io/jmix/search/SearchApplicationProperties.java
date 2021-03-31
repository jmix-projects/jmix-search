/*
 * Copyright 2020 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.jmix.search;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "jmix.search")
@ConstructorBinding
public class SearchApplicationProperties {

    protected final int searchResultPageSize;
    protected final int maxSearchPageCount;
    protected final int searchReloadEntitiesBatchSize;
    protected final int processQueueBatchSize;
    protected final int maxProcessedQueueItemsPerExecution;
    protected final int reindexEntityEnqueueBatchSize;

    protected final boolean autoMapIndexFileContent;

    protected final String elasticsearchHost;
    protected final int elasticsearchPort;

    public SearchApplicationProperties(
            @DefaultValue("100") int searchResultPageSize,
            @DefaultValue("100") int maxSearchPageCount,
            @DefaultValue("100") int searchReloadEntitiesBatchSize,
            @DefaultValue("100") int processQueueBatchSize,
            @DefaultValue("1000") int maxProcessedQueueItemsPerExecution,
            @DefaultValue("100") int reindexEntityEnqueueBatchSize,
            @DefaultValue("false") boolean autoMapIndexFileContent,
            @DefaultValue("localhost") String elasticsearchHost,
            @DefaultValue("9200") int elasticsearchPort) {
        this.searchResultPageSize = searchResultPageSize;
        this.maxSearchPageCount = maxSearchPageCount;
        this.searchReloadEntitiesBatchSize = searchReloadEntitiesBatchSize;
        this.processQueueBatchSize = processQueueBatchSize;
        this.maxProcessedQueueItemsPerExecution = maxProcessedQueueItemsPerExecution;
        this.reindexEntityEnqueueBatchSize = reindexEntityEnqueueBatchSize;
        this.autoMapIndexFileContent = autoMapIndexFileContent;

        this.elasticsearchHost = elasticsearchHost;
        this.elasticsearchPort = elasticsearchPort;
    }

    /**
     * @return max amount of objects displayed on single page of search result
     */
    public int getSearchResultPageSize() {
        return searchResultPageSize;
    }

    /**
     * @return max amount of result pages
     */
    public int getMaxSearchPageCount() {
        return maxSearchPageCount;
    }

    /**
     * @return batch size for post-search entity processing
     */
    public int getSearchReloadEntitiesBatchSize() {
        return searchReloadEntitiesBatchSize;
    }

    /**
     * @return amount of queue items processed in single batch
     */
    public int getProcessQueueBatchSize() {
        return processQueueBatchSize;
    }

    /**
     * @return max amount of items can be processed during single execution
     */
    public int getMaxProcessedQueueItemsPerExecution() {
        return maxProcessedQueueItemsPerExecution;
    }

    /**
     * @return amount of entity instances enqueued in single batch during entity reindex process
     */
    public int getReindexEntityEnqueueBatchSize() {
        return reindexEntityEnqueueBatchSize;
    }

    /**
     * @return is file content indexed using Auto Map strategy
     */
    public boolean isAutoMapIndexFileContent() {
        return autoMapIndexFileContent;
    }

    /**
     * @return Elasticsearch connection host
     */
    public String getElasticsearchHost() {
        return elasticsearchHost;
    }

    /**
     * @return Elasticsearch connection port
     */
    public int getElasticsearchPort() {
        return elasticsearchPort;
    }
}
