package com.sismics.docs.core.event;

import org.junit.Test;

public class TestToString {
        @Test
        public void testEventsToString()  {
            DocumentCreatedAsyncEvent documentCreatedAsyncEvent = new DocumentCreatedAsyncEvent();
            documentCreatedAsyncEvent.setUserId("1");
            documentCreatedAsyncEvent.setDocumentId("2");
            assert documentCreatedAsyncEvent.toString().equals("DocumentCreatedAsyncEvent{documentId=2}");

            DocumentUpdatedAsyncEvent documentUpdatedAsyncEvent = new DocumentUpdatedAsyncEvent();
            documentUpdatedAsyncEvent.setUserId("1");
            documentUpdatedAsyncEvent.setDocumentId("2");
            assert documentUpdatedAsyncEvent.toString().equals("DocumentUpdatedAsyncEvent{documentId=2}");

            DocumentDeletedAsyncEvent documentDeletedAsyncEvent = new DocumentDeletedAsyncEvent();
            documentDeletedAsyncEvent.setUserId("1");
            documentDeletedAsyncEvent.setDocumentId("2");
            assert documentDeletedAsyncEvent.toString().equals("DocumentDeletedAsyncEvent{documentId=2}");
        }
}
